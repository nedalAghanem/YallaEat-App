package com.nextgen.yallaeatapplication.fragments;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

import com.nextgen.yallaeatapplication.R;
import com.nextgen.yallaeatapplication.adapter.DishAdapter;
import com.nextgen.yallaeatapplication.data.model.Dish;
import com.nextgen.yallaeatapplication.data.viewModel.AppViewModel;

import java.io.IOException;

public class OwnerMenuFragment extends Fragment {

    private static final int PICK_IMAGE_ADD = 100;
    private static final int PICK_IMAGE_EDIT = 200;

    private AppViewModel viewModel;
    private DishAdapter adapter;
    private Bitmap selectedImage;
    private Bitmap updatedImage;
    private ImageView currentDialogImageView,ivDishAdd;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_owner_menu, container, false);

        RecyclerView recyclerView = v.findViewById(R.id.recyclerDishes);
        Button btnAdd = v.findViewById(R.id.btnAddDish);

        viewModel = new ViewModelProvider(requireActivity()).get(AppViewModel.class);

        adapter = new DishAdapter(getContext(), true, new DishAdapter.OnDishActionListener() {
            @Override
            public void onEdit(Dish dish) {
                showEditDialog(dish);
            }
            @Override
            public void onDelete(Dish dish) {
                viewModel.deleteDish(dish);
            }
            @Override
            public void onAddToCart(Dish dish) {
            }
        });

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        viewModel.getAllDishesLive().observe(getViewLifecycleOwner(), dishes -> adapter.setDishes(dishes));

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showAddDialog();
            }
        });

        return v;
    }

    private void showAddDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("Add Dish");

        View view = getLayoutInflater().inflate(R.layout.dialog_add_dish, null);
        EditText etName = view.findViewById(R.id.etDishName);
        EditText etPrice = view.findViewById(R.id.etDishPrice);
        EditText etQuantity = view.findViewById(R.id.etDishQuantity);
        Spinner spinnerCategory = view.findViewById(R.id.spinnerCategory);
        Button btnSelectImage = view.findViewById(R.id.btnSelectImage);
        ivDishAdd = view.findViewById(R.id.ivDishAdd);


        String[] categories = {"Starters", "Main Course", "Desserts", "Drinks"};
        ArrayAdapter<String> adapterSpinner = new ArrayAdapter<>(getContext(),
                android.R.layout.simple_spinner_item, categories);
        adapterSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCategory.setAdapter(adapterSpinner);

        btnSelectImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, PICK_IMAGE_ADD);
            }
        });

        builder.setView(view);
        builder.setPositiveButton("Add", (dialog, which) -> {
            String name = etName.getText().toString();
            String category = spinnerCategory.getSelectedItem().toString();
            double price;
            int quantity;
            try { price = Double.parseDouble(etPrice.getText().toString()); }
            catch (NumberFormatException e) { price = 0; }
            try { quantity = Integer.parseInt(etQuantity.getText().toString()); }
            catch (NumberFormatException e) { quantity = 1; }
            viewModel.insertDish(new Dish(name, price, category, selectedImage, quantity));

            selectedImage = null;
        });

        builder.setNegativeButton("Cancel", (dialog, which) -> selectedImage = null);
        builder.show();
    }


    private void showEditDialog(Dish dish) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("Edit Dish");

        View view = getLayoutInflater().inflate(R.layout.dialog_edit_dish, null);
        EditText edtName = view.findViewById(R.id.edtDishName);
        EditText edtPrice = view.findViewById(R.id.edtDishPrice);
        Spinner spCategory = view.findViewById(R.id.spDishCategory);
        EditText etQuantity = view.findViewById(R.id.edtQuantity);
        ImageView ivPreview = view.findViewById(R.id.ivDishPreview);
        Button btnSelectImage = view.findViewById(R.id.btnSelectImage);

        edtName.setText(dish.getName());
        edtPrice.setText(String.valueOf(dish.getPrice()));
        etQuantity.setText(String.valueOf(dish.getQuantity()));
        ivPreview.setImageBitmap(dish.getImage());


        String[] categories = {"Starters", "Main Course", "Desserts", "Drinks"};
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, categories);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spCategory.setAdapter(spinnerAdapter);

        int position = spinnerAdapter.getPosition(dish.getCategory());
        spCategory.setSelection(position);

        updatedImage = dish.getImage();
        currentDialogImageView = ivPreview;

        btnSelectImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, PICK_IMAGE_EDIT);
            }
        });

        builder.setView(view);
        builder.setPositiveButton("Update", (dialog, which) -> {
            dish.setName(edtName.getText().toString().trim());
            dish.setCategory(spCategory.getSelectedItem().toString());
            dish.setImage(updatedImage);

            try {
                Double price = Double.parseDouble(edtPrice.getText().toString().trim());
                dish.setPrice(price);
            } catch (NumberFormatException e) {
                dish.setPrice(0);
            }
            try {
                int quantity = Integer.parseInt(etQuantity.getText().toString());
                dish.setQuantity(quantity);
            } catch (NumberFormatException e) {
                dish.setQuantity(1); }
            viewModel.updateDish(dish);
        });
        builder.setNegativeButton("Cancel", (dialog, which) -> {});
        builder.show();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == Activity.RESULT_OK && data != null && data.getData() != null){
            try {
                Bitmap selected = MediaStore.Images.Media.getBitmap(getActivity().getContentResolver(), data.getData());
                ivDishAdd.setImageBitmap(selectedImage);
                if(requestCode == PICK_IMAGE_ADD){
                    selectedImage = selected;
                    ivDishAdd.setImageBitmap(selectedImage);
                } else if(requestCode == PICK_IMAGE_EDIT){
                    updatedImage = selected;
                    if(currentDialogImageView != null){
                        currentDialogImageView.setImageBitmap(updatedImage);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
