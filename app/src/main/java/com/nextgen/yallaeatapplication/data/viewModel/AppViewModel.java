package com.nextgen.yallaeatapplication.data.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.nextgen.yallaeatapplication.data.model.User;
import com.nextgen.yallaeatapplication.data.repository.AppRepository;


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