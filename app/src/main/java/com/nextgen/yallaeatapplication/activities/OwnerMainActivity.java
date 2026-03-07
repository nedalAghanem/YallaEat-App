package com.nextgen.yallaeatapplication.activities;

import android.os.Bundle;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.nextgen.yallaeatapplication.R;

public class OwnerMainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_owner_main);

        bottomNav = findViewById(R.id.bottomNav);

        if (savedInstanceState == null) {
            var transaction = getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragmentContainer, new OwnerMenuFragment());
            if (false) transaction.addToBackStack(null);
            transaction.commit();
            bottomNav.setSelectedItemId(R.id.nav_menu);
        }

        bottomNav.setOnItemSelectedListener(item -> {
            Fragment current = getSupportFragmentManager().findFragmentById(R.id.fragmentContainer);
            Fragment selected = null;
            switch(item.getItemId()){
                case R.id.nav_menu:
                    if (!(current instanceof OwnerMenuFragment)) selected = new OwnerMenuFragment();
                    break;
                case R.id.nav_profile:
                    if (!(current instanceof OwnerProfileFragment)) selected = new OwnerProfileFragment();
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
            if (current instanceof OwnerMenuFragment) {
                bottomNav.setSelectedItemId(R.id.nav_menu);
            } else if (current instanceof OwnerProfileFragment) {
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
                    OwnerMainActivity.super.onBackPressed();
                }
            }
        });
    }

    private void replaceFragment(Fragment fragment, boolean addToBackStack) {
        var transaction = getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragmentContainer, fragment);
        if (addToBackStack) transaction.addToBackStack(null);
        transaction.commit();
    }
}
