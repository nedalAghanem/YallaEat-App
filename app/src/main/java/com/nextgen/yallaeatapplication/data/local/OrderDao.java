package com.nextgen.yallaeatapplication.data.local;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.nextgen.yallaeatapplication.data.model.Order;

import java.util.List;

@Dao
public interface OrderDao {
    @Insert
    void insert(Order order);
    @Query("SELECT * FROM orders WHERE username = :username ORDER BY timestamp DESC")
    LiveData<List<Order>> getOrdersForUser(String username);
}
