package com.nextgen.yallaeatapplication.data.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "cart")
public class CartItem {
    @PrimaryKey(autoGenerate = true)
    private int id;

    private String username;
    private String dishName;
    private double price;
    private int quantity;

    public CartItem(String username, String dishName, double price, int quantity) {
        this.username = username;
        this.dishName = dishName;
        this.price = price;
        this.quantity = quantity;
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
