package com.nextgen.yallaeatapplication.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nextgen.yallaeatapplication.R;
import com.nextgen.yallaeatapplication.data.model.CartItem;

import java.util.ArrayList;
import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartViewHolder> {

    private List<CartItem> cartItems = new ArrayList<>();
    private OnCartActionListener listener;

    public interface OnCartActionListener {
        void onIncreaseQuantity(CartItem item);
        void onDecreaseQuantity(CartItem item);
        void onDeleteItem(CartItem item);
    }

    public CartAdapter(OnCartActionListener listener) {
        this.listener = listener;
    }

    public void setCartItems(List<CartItem> items) {
        this.cartItems = items != null ? items : new ArrayList<>();
        notifyDataSetChanged();
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    @NonNull
    @Override
    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_cart, parent, false);
        return new CartViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull CartViewHolder holder, int position) {
        CartItem item = cartItems.get(position);

        holder.tvName.setText(item.getDishName());
        holder.tvUnitPrice.setText("Unit Price: $" + item.getPrice());
        holder.tvQuantity.setText("Qty: " + item.getQuantity());

        double totalItemPrice = item.getPrice() * item.getQuantity();
        holder.tvTotalPrice.setText("Total: $" + totalItemPrice);

        holder.btnIncrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listener != null) listener.onIncreaseQuantity(item);
            }
        });

        holder.btnDecrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listener != null) listener.onDecreaseQuantity(item);
            }
        });

        holder.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listener != null) listener.onDeleteItem(item);
            }
        });
    }

    @Override
    public int getItemCount() {
        return cartItems.size();
    }

    static class CartViewHolder extends RecyclerView.ViewHolder {
        TextView tvName, tvUnitPrice, tvQuantity, tvTotalPrice;
        Button btnIncrease, btnDecrease, btnDelete;

        public CartViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvCartName);
            tvUnitPrice = itemView.findViewById(R.id.tvCartUnitPrice);
            tvQuantity = itemView.findViewById(R.id.tvCartQuantity);
            tvTotalPrice = itemView.findViewById(R.id.tvCartTotalPrice);
            btnIncrease = itemView.findViewById(R.id.btnIncrease);
            btnDecrease = itemView.findViewById(R.id.btnDecrease);
            btnDelete = itemView.findViewById(R.id.btnDeleteItem);
        }
    }
}
