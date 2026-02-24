package com.nextgen.yallaeatapplication.data.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.nextgen.yallaeatapplication.data.local.AppDatabase;
import com.nextgen.yallaeatapplication.data.local.UserDao;
import com.nextgen.yallaeatapplication.data.model.User;

public class AppRepository {

    private UserDao userDao;


    public AppRepository(Application application) {
        AppDatabase db = AppDatabase.getDatabase(application);
        userDao = db.userDao();

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
}
