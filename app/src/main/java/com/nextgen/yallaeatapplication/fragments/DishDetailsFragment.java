package com.nextgen.yallaeatapplication.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.nextgen.yallaeatapplication.R;
import com.nextgen.yallaeatapplication.data.model.Dish;
import com.nextgen.yallaeatapplication.data.model.User;
import com.nextgen.yallaeatapplication.data.viewModel.AppViewModel;

public class DishDetailsFragment extends Fragment {

    private static final String ARG_DISH = "dish";

    private Dish dish;
    private ImageView ivDish;
    private TextView tvName, tvPrice, tvQuantity;
    private Button btnIncrease, btnDecrease, btnAddToCart;
    private int quantity = 1;
    private AppViewModel viewModel;

    public static DishDetailsFragment newInstance(Dish dish) {
        DishDetailsFragment fragment = new DishDetailsFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_DISH, dish);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dish_details, container, false);

        ivDish = view.findViewById(R.id.ivDish);
        tvName = view.findViewById(R.id.tvDishName);
        tvPrice = view.findViewById(R.id.tvDishPrice);
        tvQuantity = view.findViewById(R.id.tvQuantity);
        btnIncrease = view.findViewById(R.id.btnIncrease);
        btnDecrease = view.findViewById(R.id.btnDecrease);
        btnAddToCart = view.findViewById(R.id.btnAddToCart);

        viewModel = new ViewModelProvider(requireActivity()).get(AppViewModel.class);

        if (getArguments() != null) {
            dish = (Dish) getArguments().getSerializable(ARG_DISH);
            populateDishDetails();
        }

        btnIncrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (quantity < dish.getQuantity()) {
                    quantity++;
                    tvQuantity.setText(String.valueOf(quantity));
                } else {
                    Toast.makeText(getContext(), "Cannot exceed available quantity", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnDecrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (quantity > 1) {
                    quantity--;
                    tvQuantity.setText(String.valueOf(quantity));
                }
            }
        });

        btnAddToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = requireContext();
                String username = context.getSharedPreferences("app_prefs", Context.MODE_PRIVATE)
                        .getString("username", null);

                if (username == null) {
                    Toast.makeText(getContext(), "Please login first", Toast.LENGTH_SHORT).show();
                    return;
                }

                viewModel.getUserByUsername(username).observe(getViewLifecycleOwner(), user -> {
                    if (user != null) {
                        viewModel.setCurrentUser(user);
                        addToCartForCurrentUser(user);
                    } else {
                        Toast.makeText(getContext(), "User not found in database", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        return view;
    }

    private void addToCartForCurrentUser(User user) {
        int availableQuantity = dish.getQuantity();
        int quantityToAdd = Math.min(quantity, availableQuantity);

        if (quantityToAdd <= 0) {
            Toast.makeText(getContext(), "No items available to add", Toast.LENGTH_SHORT).show();
            return;
        }

        viewModel.addToCartForCurrentUser(dish, quantityToAdd);

        Toast.makeText(getContext(), quantityToAdd + " item(s) added to cart", Toast.LENGTH_SHORT).show();

        quantity = 1;
        tvQuantity.setText(String.valueOf(quantity));
    }

    private void populateDishDetails() {
        tvName.setText(dish.getName());
        tvPrice.setText("Price: $" + dish.getPrice());
        if (dish.getImage() != null) {
            ivDish.setImageBitmap(dish.getImage());
        }
        tvQuantity.setText(String.valueOf(quantity));
    }
}
