package com.nextgen.yallaeatapplication.activities;

import android.os.Bundle;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.nextgen.yallaeatapplication.R;
import com.nextgen.yallaeatapplication.fragments.CustomerCartFragment;
import com.nextgen.yallaeatapplication.fragments.CustomerMenuFragment;
import com.nextgen.yallaeatapplication.fragments.CustomerOrdersFragment;
import com.nextgen.yallaeatapplication.fragments.CustomerProfileFragment;

public class CustomerMainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_main);

        bottomNav = findViewById(R.id.bottomNav);

        if (savedInstanceState == null) {
            var transaction = getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragmentContainer, new CustomerMenuFragment());
            if (false) transaction.addToBackStack(null);
            transaction.commit();
            bottomNav.setSelectedItemId(R.id.nav_home);
        }

        bottomNav.setOnItemSelectedListener(item -> {
            Fragment current = getSupportFragmentManager().findFragmentById(R.id.fragmentContainer);
            Fragment selected = null;
            switch(item.getItemId()){
                case R.id.nav_home:
                    if (!(current instanceof CustomerMenuFragment)) selected = new CustomerMenuFragment();
                    break;
                case R.id.nav_cart:
                    if (!(current instanceof CustomerCartFragment)) selected = new CustomerCartFragment();
                    break;
                case R.id.nav_orders:
                    if (!(current instanceof CustomerOrdersFragment)) selected = new CustomerOrdersFragment();
                    break;
                case R.id.nav_profile:
                    if (!(current instanceof CustomerProfileFragment)) selected = new CustomerProfileFragment();
                    break;
            }
            if (selected != null){
                var transaction = getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragmentContainer, selected);
                if (true) transaction.addToBackStack(null);
                transaction.commit();
            }
            return true;
        });

        getSupportFragmentManager().addOnBackStackChangedListener(() -> {
            Fragment current = getSupportFragmentManager().findFragmentById(R.id.fragmentContainer);
            if (current instanceof CustomerMenuFragment) {
                bottomNav.setSelectedItemId(R.id.nav_home);
            } else if (current instanceof CustomerCartFragment) {
                bottomNav.setSelectedItemId(R.id.nav_cart);
            } else if (current instanceof CustomerOrdersFragment) {
                bottomNav.setSelectedItemId(R.id.nav_orders);
            } else if (current instanceof CustomerProfileFragment) {
                bottomNav.setSelectedItemId(R.id.nav_profile);
            }
        });

        getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
                    getSupportFragmentManager().popBackStack();
                } else {
                    setEnabled(false);
                    CustomerMainActivity.super.onBackPressed();
                }
            }
        });
    }
}
