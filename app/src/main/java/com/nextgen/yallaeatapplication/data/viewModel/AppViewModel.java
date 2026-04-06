package com.nextgen.yallaeatapplication.data.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.nextgen.yallaeatapplication.data.model.CartItem;
import com.nextgen.yallaeatapplication.data.model.Dish;
import com.nextgen.yallaeatapplication.data.model.Order;
import com.nextgen.yallaeatapplication.data.model.User;
import com.nextgen.yallaeatapplication.data.repository.AppRepository;

import java.util.ArrayList;
import java.util.List;


public class AppViewModel extends AndroidViewModel {

    private AppRepository repository;
    private MutableLiveData<User> currentUser = new MutableLiveData<>();

    public AppViewModel(@NonNull Application application) {
        super(application);
        repository = new AppRepository(application);
    }
    // ----------------- USERS -----------------

    public void setCurrentUser(User user) {
        currentUser.setValue(user);
    }

    public LiveData<User> getCurrentUser() {
        return currentUser;
    }

    public LiveData<User> loginUser(String username, String password) {
        return repository.loginUser(username, password);
    }

    public void registerUser(User user) {
        repository.insertUser(user);
    }

    public void updateUser(User user) {
        repository.updateUser(user);
        currentUser.postValue(user);
    }

    public LiveData<User> getUserByUsername(String username) {
        LiveData<User> userLiveData = repository.getUserByUsername(username);
        userLiveData.observeForever(user -> {
            if (user != null) {
                currentUser.postValue(user);
            }
        });
        return userLiveData;
    }

    // ----------------- DISHES -----------------
    public LiveData<List<Dish>> getAllDishesLive() {
        return repository.getAllDishes();
    }
    public void insertDish(Dish dish) {
        repository.insertDish(dish);
    }
    public void updateDish(Dish dish) {
        repository.updateDish(dish);
    }
    public void deleteDish(Dish dish) {
        repository.deleteDish(dish);
    }
    public Dish getDishByName(String name) {
        return repository.getDishByNameNow(name);
    }





    // ----------------- CART -----------------
    public LiveData<List<CartItem>> getCartItemsForCurrentUser() {
        User user = currentUser.getValue();
        if(user != null){
            return repository.getCartItemsForUser(user.getUsername());
        } else {
            return new MutableLiveData<>(new ArrayList<>());
        }
    }
    public void addToCartForCurrentUser(Dish dish, int quantityToAdd) {
        if (currentUser.getValue() != null) {
            repository.addToCartForUser(currentUser.getValue().getUsername(), dish, quantityToAdd);
        }
    }
    public void updateCartItemForCurrentUser(CartItem item) {
        if (currentUser.getValue() != null && item.getUsername().equals(currentUser.getValue().getUsername())) {
            repository.updateCartItem(item);
        }
    }
    public void deleteCartItemForCurrentUser(CartItem item) {
        if (currentUser.getValue() != null && item.getUsername().equals(currentUser.getValue().getUsername())) {
            repository.deleteCartItem(item);
        }
    }
    public void clearCartForCurrentUser() {
        if (currentUser.getValue() != null) {
            repository.clearCartForUser(currentUser.getValue().getUsername());
        }
    }
    public LiveData<Double> getTotalPriceForCurrentUser() {
        if (currentUser.getValue() != null) {
            return repository.getTotalPriceForUser(currentUser.getValue().getUsername());
        } else {
            return new MutableLiveData<>(0.0);
        }
    }

    // ----------------- ORDERS -----------------
    public void placeOrder(Order order){
        repository.placeOrder(order);
    }

    public LiveData<List<Order>> getOrdersForUser(String username){
        return repository.getOrdersForUser(username);
    }

    public void loadOrdersForCurrentUser(LifecycleOwner owner, Observer<List<Order>> observer) {
        if (currentUser.getValue() != null) {
            getOrdersForUser(currentUser.getValue().getUsername())
                    .observe(owner, observer);
        }
    }
}