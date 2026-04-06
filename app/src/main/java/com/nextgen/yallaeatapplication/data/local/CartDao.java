package com.nextgen.yallaeatapplication.data.local;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.nextgen.yallaeatapplication.data.model.CartItem;

import java.util.List;

@Dao
public interface CartDao {

    @Insert
    void insert(CartItem item);
    @Update
    void update(CartItem item);
    @Delete
    void delete(CartItem item);
    @Query("SELECT * FROM cart WHERE username = :username")
    LiveData<List<CartItem>> getCartItemsForUser(String username);
    @Query("SELECT SUM(price * quantity) FROM cart WHERE username = :username")
    LiveData<Double> getTotalPriceForUser(String username);
    @Query("SELECT * FROM cart WHERE dishName = :dishName AND username = :username LIMIT 1")
    CartItem getCartItemByNameNowAndUser(String dishName, String username);
    @Query("DELETE FROM cart WHERE username = :username")
    void clearCartForUser(String username);

}

