package com.nextgen.yallaeatapplication.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

import androidx.appcompat.app.AppCompatActivity;

import com.nextgen.yallaeatapplication.R;

public class SplashActivity extends AppCompatActivity {

    private Handler handler;
    private Runnable runnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        handler = new Handler(Looper.getMainLooper());

        runnable = () -> {

            SharedPreferences prefs = getSharedPreferences("app_prefs", MODE_PRIVATE);
            boolean firstLaunch = prefs.getBoolean("first_launch", true);
            boolean loggedIn = prefs.getBoolean("logged_in", false);

            Intent intent;

            if (firstLaunch) {
                intent = new Intent(SplashActivity.this, OnboardingActivity.class);
                prefs.edit().putBoolean("first_launch", false).apply();
            } else if (loggedIn) {
                String role = prefs.getString("role", "customer");
                if (role.equals("owner")) {
                    intent = new Intent(SplashActivity.this, OwnerMainActivity.class);
                } else {
                    intent = new Intent(SplashActivity.this, CustomerMainActivity.class);
                }
            } else {
                intent = new Intent(SplashActivity.this, AuthActivity.class);
            }
            startActivity(intent);
            finish();
        };
        handler.postDelayed(runnable, 2500);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (handler != null && runnable != null) {
            handler.removeCallbacks(runnable);
        }
    }
}