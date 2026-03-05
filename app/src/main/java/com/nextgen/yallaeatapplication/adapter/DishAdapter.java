package com.nextgen.yallaeatapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nextgen.yallaeatapplication.R;
import com.nextgen.yallaeatapplication.data.model.Dish;

import java.util.ArrayList;
import java.util.List;

public class DishAdapter extends RecyclerView.Adapter<DishAdapter.DishViewHolder> {

    private List<Dish> dishes = new ArrayList<>();
    private Context context;
    private boolean isOwner;
    private OnDishActionListener listener;

    public interface OnDishActionListener {
        void onAddToCart(Dish dish);
        void onEdit(Dish dish);
        void onDelete(Dish dish);
    }

    /**
     * @param context
     * @param isOwner
     * @param listener
     */
    public DishAdapter(Context context, boolean isOwner, OnDishActionListener listener){
        this.context = context;
        this.isOwner = isOwner;
        this.listener = listener;
    }

    public void setDishes(List<Dish> dishes){
        this.dishes = dishes;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public DishViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_dish_actions, parent, false);
        return new DishViewHolder(v);
    }
    @Override
    public void onBindViewHolder(@NonNull DishViewHolder holder, int position) {
        Dish d = dishes.get(position);
        holder.tvName.setText(d.getName());
        holder.tvPrice.setText("Price: $" + d.getPrice() + " | Category: " + d.getCategory());
        if(d.getImage() != null) holder.ivDish.setImageBitmap(d.getImage());

        if(isOwner && listener != null){
            holder.btnEdit.setVisibility(View.VISIBLE);
            holder.btnDelete.setVisibility(View.VISIBLE);
            holder.btnAddToCart.setVisibility(View.GONE);
            holder.btnEdit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onEdit(d);
                }
            });
            holder.btnDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onDelete(d);
                }
            });
        } else {
            holder.btnEdit.setVisibility(View.GONE);
            holder.btnDelete.setVisibility(View.GONE);
            holder.btnAddToCart.setVisibility(View.GONE);

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(listener != null) listener.onAddToCart(d);
                }
            });
        }
    }


    @Override
    public int getItemCount() {
        return dishes.size();
    }

    static class DishViewHolder extends RecyclerView.ViewHolder {
        TextView tvName, tvPrice;
        ImageView ivDish;
        Button btnEdit, btnDelete, btnAddToCart;

        public DishViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);
            tvPrice = itemView.findViewById(R.id.tvPrice);
            ivDish = itemView.findViewById(R.id.ivDish);
            btnEdit = itemView.findViewById(R.id.btnEdit);
            btnDelete = itemView.findViewById(R.id.btnDelete);
            btnAddToCart = itemView.findViewById(R.id.btnAddToCart);
        }
    }
}
