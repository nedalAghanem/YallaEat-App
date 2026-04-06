package com.nextgen.yallaeatapplication.data.model;

import android.graphics.Bitmap;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "dishes")
public class Dish implements Serializable {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String name;
    private double price;
    private String category;
    private Bitmap image;
    private int quantity;


    public Dish(String name, double price, String category, Bitmap image, int quantity) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.image = image;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}