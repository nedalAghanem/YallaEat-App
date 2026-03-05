package com.nextgen.yallaeatapplication.fragments;

import android.Manifest;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.nextgen.yallaeatapplication.MainActivity;
import com.nextgen.yallaeatapplication.R;
import com.nextgen.yallaeatapplication.adapter.CartAdapter;
import com.nextgen.yallaeatapplication.data.model.CartItem;
import com.nextgen.yallaeatapplication.data.model.Dish;
import com.nextgen.yallaeatapplication.data.model.Order;
import com.nextgen.yallaeatapplication.data.viewModel.AppViewModel;

import java.util.concurrent.Executors;

public class CustomerCartFragment extends Fragment {

    private RecyclerView rvCart;
    private TextView tvTotalPrice;
    private Button btnCheckout, btnClearCart;
    private CartAdapter adapter;
    private AppViewModel viewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_customer_cart, container, false);

        rvCart = view.findViewById(R.id.rvCart);
        tvTotalPrice = view.findViewById(R.id.tvTotalPrice);
        btnCheckout = view.findViewById(R.id.btnCheckout);
        btnClearCart = view.findViewById(R.id.btnClearCart);


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(
                    "checkout_channel",
                    "Checkout Notifications",
                    NotificationManager.IMPORTANCE_DEFAULT
            );
            NotificationManager manager = requireActivity().getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            if (ActivityCompat.checkSelfPermission(requireContext(), Manifest.permission.POST_NOTIFICATIONS)
                    != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(requireActivity(),
                        new String[]{Manifest.permission.POST_NOTIFICATIONS}, 101);
            }
        }

        viewModel = new ViewModelProvider(requireActivity()).get(AppViewModel.class);

        if (viewModel.getCurrentUser().getValue() == null) {
            Context context = requireContext();
            String username = context.getSharedPreferences("app_prefs", Context.MODE_PRIVATE)
                    .getString("username", null);
            String role = context.getSharedPreferences("app_prefs", Context.MODE_PRIVATE)
                    .getString("role", "customer");

            if (username != null) {
                viewModel.getUserByUsername(username).observe(getViewLifecycleOwner(), user -> {
                    if (user != null) {
                        viewModel.setCurrentUser(user);
                        setupCartAdapter();
                    }
                });
            } else {
                setupCartAdapter();
            }
        } else {
            setupCartAdapter();
        }

        btnClearCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewModel.clearCartForCurrentUser();
            }
        });

        btnCheckout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (viewModel.getCurrentUser().getValue() == null) {
                    Toast.makeText(getContext(), "Please login first", Toast.LENGTH_SHORT).show();
                    return;
                }

                for (CartItem item : adapter.getCartItems()) {
                    long timestamp = System.currentTimeMillis();
                    double totalPrice = item.getPrice() * item.getQuantity();
                    Order order = new Order(
                            viewModel.getCurrentUser().getValue().getUsername(),
                            item.getDishName(),
                            item.getQuantity(),
                            totalPrice,
                            timestamp
                    );
                    viewModel.placeOrder(order);
                }

                viewModel.clearCartForCurrentUser();

                Toast.makeText(getContext(), "Checkout successful! Orders created.", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(getContext(), MainActivity.class);
                PendingIntent pendingIntent = PendingIntent.getActivity(
                        getContext(),
                        0,
                        intent,
                        PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE
                );

                NotificationCompat.Builder builder = new NotificationCompat.Builder(requireContext(), "checkout_channel")
                        .setContentTitle("Order Confirmed")
                        .setContentText("Thank you for your purchase!")
                        .setSmallIcon(R.drawable.ic_launcher_background)
                        .setContentIntent(pendingIntent)
                        .setAutoCancel(true);

                NotificationManagerCompat notificationManager = NotificationManagerCompat.from(requireContext());
                if (ActivityCompat.checkSelfPermission(requireContext(), Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED) {
                    return;
                }
                notificationManager.notify(1, builder.build());
            }
        });

        return view;
    }

    private void setupCartAdapter() {
        adapter = new CartAdapter(new CartAdapter.OnCartActionListener() {
            @Override
            public void onIncreaseQuantity(CartItem item) {
                Executors.newSingleThreadExecutor().execute(() -> {
                    Dish dish = viewModel.getDishByName(item.getDishName());
                    if (dish != null) {
                        viewModel.addToCartForCurrentUser(dish, 1);
                    }
                });
            }


            @Override
            public void onDecreaseQuantity(CartItem item) {
                if (item.getQuantity() > 1) {
                    item.setQuantity(item.getQuantity() - 1);
                    Executors.newSingleThreadExecutor().execute(() -> {
                        Dish dish = viewModel.getDishByName(item.getDishName());
                        dish.setQuantity(dish.getQuantity()+1);
                        viewModel.updateDish(dish);
                        viewModel.updateCartItemForCurrentUser(item);
                    });
                } else {
                    Executors.newSingleThreadExecutor().execute(() -> {
                        Dish dish = viewModel.getDishByName(item.getDishName());
                        dish.setQuantity(dish.getQuantity()+1);
                        viewModel.updateDish(dish);
                        viewModel.updateCartItemForCurrentUser(item);
                        viewModel.deleteCartItemForCurrentUser(item);
                    });
                }
            }

            @Override
            public void onDeleteItem(CartItem item) {
                Executors.newSingleThreadExecutor().execute(() -> {
                    Dish dish = viewModel.getDishByName(item.getDishName());
                    dish.setQuantity(dish.getQuantity()+item.getQuantity());
                    viewModel.updateDish(dish);
                    viewModel.deleteCartItemForCurrentUser(item);
                });
            }
        });

        rvCart.setAdapter(adapter);
        rvCart.setLayoutManager(new LinearLayoutManager(getContext()));


        viewModel.getCartItemsForCurrentUser().observe(getViewLifecycleOwner(), items -> adapter.setCartItems(items));

        viewModel.getTotalPriceForCurrentUser().observe(getViewLifecycleOwner(), total -> {
            if (total == null) total = 0.0;
            tvTotalPrice.setText("Total: $" + total);
        });
    }



    private void checkout() {

    }

}
