package com.nextgen.yallaeatapplication.data.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.nextgen.yallaeatapplication.data.local.AppDatabase;
import com.nextgen.yallaeatapplication.data.local.DishDao;
import com.nextgen.yallaeatapplication.data.local.OrderDao;
import com.nextgen.yallaeatapplication.data.local.UserDao;
import com.nextgen.yallaeatapplication.data.model.Dish;
import com.nextgen.yallaeatapplication.data.model.Order;
import com.nextgen.yallaeatapplication.data.model.User;

import java.util.List;

public class AppRepository {

    private UserDao userDao;
    private DishDao dishDao;
    private OrderDao orderDao;


    public AppRepository(Application application) {
        AppDatabase db = AppDatabase.getDatabase(application);
        userDao = db.userDao();
        dishDao = db.dishDao();
        orderDao = db.orderDao();

    }

    // ----------------- USERS -----------------
    public LiveData<User> loginUser(String username, String password) {
        return userDao.login(username, password);
    }

    public void insertUser(User user) {
        AppDatabase.databaseWriteExecutor.execute(() -> userDao.insert(user));
    }

    public void updateUser(User user) {
        AppDatabase.databaseWriteExecutor.execute(() -> userDao.update(user));
    }

    public LiveData<User> getUserByUsername(String username) {
        return userDao.getUserByUsername(username);
    }

    // ----------------- DISHES -----------------
    public LiveData<List<Dish>> getAllDishes() {
        return dishDao.getAllDishes();
    }

    public void insertDish(Dish dish) {
        AppDatabase.databaseWriteExecutor.execute(() -> dishDao.insert(dish));
    }

    public void updateDish(Dish dish) {
        AppDatabase.databaseWriteExecutor.execute(() -> dishDao.update(dish));
    }

    public void deleteDish(Dish dish) {
        AppDatabase.databaseWriteExecutor.execute(() -> dishDao.delete(dish));
    }

    public LiveData<List<Dish>> getDishesByCategory(String category){
        return dishDao.getDishesByCategory(category);
    }

    public Dish getDishByNameNow(String name) {
        return dishDao.getDishByName(name);
    }


    // ----------------- ORDERS -----------------
    public void placeOrder(Order order){
        AppDatabase.databaseWriteExecutor.execute(() -> orderDao.insert(order));
    }
    public LiveData<List<Order>> getOrdersForUser(String username){
        return orderDao.getOrdersForUser(username);
    }
}


