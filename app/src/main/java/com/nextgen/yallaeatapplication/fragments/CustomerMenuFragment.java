package com.nextgen.yallaeatapplication.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.nextgen.yallaeatapplication.R;
import com.nextgen.yallaeatapplication.adapter.DishAdapter;
import com.nextgen.yallaeatapplication.data.model.Dish;
import com.nextgen.yallaeatapplication.data.viewModel.AppViewModel;

import java.util.ArrayList;
import java.util.List;

public class CustomerMenuFragment extends Fragment {

    private RecyclerView rvDishes;
    private DishAdapter adapter;
    private AppViewModel viewModel;
    private List<Dish> allDishes;

    private Button btnAll, btnStarters,btnMainCourse,btnDesserts,btnDrinks;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_customer_menu, container, false);

        rvDishes = view.findViewById(R.id.rvDishes);
        viewModel = new ViewModelProvider(requireActivity()).get(AppViewModel.class);
        btnAll = view.findViewById(R.id.btnAll);
        btnStarters = view.findViewById(R.id.btnStarters);
        btnMainCourse = view.findViewById(R.id.btnMainCourse);
        btnDesserts = view.findViewById(R.id.btnDesserts);
        btnDrinks = view.findViewById(R.id.btnDrinks);


        adapter = new DishAdapter(getContext(), false, new DishAdapter.OnDishActionListener() {
            @Override
            public void onAddToCart(Dish dish) {
                DishDetailsFragment fragment = DishDetailsFragment.newInstance(dish);
                getParentFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragmentContainer, fragment)
                        .addToBackStack(null)
                        .commit();
            }

            @Override
            public void onEdit(Dish dish) {}

            @Override
            public void onDelete(Dish dish) {}
        });

        rvDishes.setAdapter(adapter);
        rvDishes.setLayoutManager(new LinearLayoutManager(getContext()));

        viewModel.getAllDishesLive().observe(getViewLifecycleOwner(), dishes -> {
            allDishes = dishes;
            adapter.setDishes(allDishes);
        });

        View.OnClickListener filterListener = v -> {
            String category = ((Button)v).getText().toString();
            filterDishes(category);
        };

        btnAll.setOnClickListener(filterListener);
        btnStarters.setOnClickListener(filterListener);
        btnMainCourse.setOnClickListener(filterListener);
        btnDesserts.setOnClickListener(filterListener);
        btnDrinks.setOnClickListener(filterListener);


        return view;
    }
    private void filterDishes(String category) {
        if (category.equals("All")) {
            adapter.setDishes(allDishes);
            return;
        }

        List<Dish> filtered = new ArrayList<>();
        for (Dish dish : allDishes) {
            if (dish.getCategory() != null && dish.getCategory().equalsIgnoreCase(category)) {
                filtered.add(dish);
            }
        }
        adapter.setDishes(filtered);
    }
}
