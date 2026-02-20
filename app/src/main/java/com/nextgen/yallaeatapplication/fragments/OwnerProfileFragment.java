package com.example.project;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class OwnerProfileFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_owner_profile, container, false);

        TextView tvUser = v.findViewById(R.id.tvUsername);
        Button btnLogout = v.findViewById(R.id.btnLogout);

        SharedPreferences prefs = getActivity().getSharedPreferences("app_prefs", getContext().MODE_PRIVATE);
        String username = prefs.getString("username", "Owner");
        tvUser.setText("Welcome, " + username);

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = prefs.edit();
                editor.clear();
                editor.apply();

                startActivity(new Intent(getActivity(), AuthActivity.class));
                getActivity().finish();
            }
        });

        return v;
    }
}