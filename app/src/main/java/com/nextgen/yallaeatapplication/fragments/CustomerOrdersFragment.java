package com.nextgen.yallaeatapplication.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class CustomerOrdersFragment extends Fragment {

    private RecyclerView rvOrders;
    private TextView tvEmpty;
    private OrderAdapter adapter;
    private AppViewModel viewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_customer_orders, container, false);

        rvOrders = view.findViewById(R.id.rvOrders);
        tvEmpty = view.findViewById(R.id.tvEmptyOrders);

        adapter = new OrderAdapter();
        rvOrders.setAdapter(adapter);
        rvOrders.setLayoutManager(new LinearLayoutManager(getContext()));

        viewModel = new ViewModelProvider(requireActivity()).get(AppViewModel.class);

        loadOrders();

        return view;
    }

    private void loadOrders() {
        if (viewModel.getCurrentUser().getValue() == null) {
            Context context = requireContext();
            String username = context.getSharedPreferences("app_prefs", Context.MODE_PRIVATE)
                    .getString("username", null);
            String role = context.getSharedPreferences("app_prefs", Context.MODE_PRIVATE)
                    .getString("role", "customer");

            if (username != null) {
                viewModel.setCurrentUser(new User(username, "", role));
            }
        }

        if (viewModel.getCurrentUser().getValue() != null) {
            viewModel.loadOrdersForCurrentUser(getViewLifecycleOwner(), orders -> {
                if (orders == null || orders.isEmpty()) {
                    rvOrders.setVisibility(View.GONE);
                    tvEmpty.setVisibility(View.VISIBLE);
                    tvEmpty.setText("No orders yet.");
                } else {
                    rvOrders.setVisibility(View.VISIBLE);
                    tvEmpty.setVisibility(View.GONE);
                    adapter.setOrders(orders);
                }
            });
        } else {
            rvOrders.setVisibility(View.GONE);
            tvEmpty.setVisibility(View.VISIBLE);
            tvEmpty.setText("Please login to view your orders.");
        }
    }
}