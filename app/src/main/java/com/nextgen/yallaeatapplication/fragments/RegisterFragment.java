package com.nextgen.yallaeatapplication.fragments;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.nextgen.yallaeatapplication.R;
import com.nextgen.yallaeatapplication.activities.CustomerMainActivity;
import com.nextgen.yallaeatapplication.activities.OwnerMainActivity;
import com.nextgen.yallaeatapplication.data.model.User;
import com.nextgen.yallaeatapplication.data.viewModel.AppViewModel;

public class RegisterFragment extends Fragment {

    private EditText edtUsername, edtPassword;
    private Button btnRegister;
    private RadioGroup rgUserType;
    private AppViewModel viewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_register, container, false);

        edtUsername = view.findViewById(R.id.edtRegUsername);
        edtPassword = view.findViewById(R.id.edtRegPassword);
        rgUserType = view.findViewById(R.id.rgUserType);
        btnRegister = view.findViewById(R.id.btnRegister);

        viewModel = new ViewModelProvider(requireActivity()).get(AppViewModel.class);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = edtUsername.getText().toString().trim();
                String password = edtPassword.getText().toString().trim();

                if (TextUtils.isEmpty(username) || TextUtils.isEmpty(password)) {
                    Toast.makeText(getContext(), "Please enter username and password", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (username.length() < 3) {
                    Toast.makeText(getContext(), "Username must be at least 3 characters", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (password.length() < 8) {
                    Toast.makeText(getContext(), "Password must be at least 8 characters", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (!password.matches(".*[A-Z].*")) {
                    Toast.makeText(getContext(), "Password must contain at least one uppercase letter", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (!password.matches(".*[0-9].*")) {
                    Toast.makeText(getContext(), "Password must contain at least one number", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (!password.matches(".*[!@#$%^&*(),.?\":{}|<>].*")) {
                    Toast.makeText(getContext(), "Password must contain at least one special character", Toast.LENGTH_SHORT).show();
                    return;
                }

                String type = rgUserType.getCheckedRadioButtonId() == R.id.rbOwner ? "owner" : "customer";

                User newUser = new User(username, password, type);
                viewModel.registerUser(newUser);

                LoginFragment.currentUser = newUser;

                SharedPreferences prefs = requireContext().getSharedPreferences("app_prefs", getContext().MODE_PRIVATE);
                prefs.edit()
                        .putBoolean("logged_in", true)
                        .putString("username", newUser.getUsername())
                        .putString("role", newUser.getType())
                        .apply();

                Toast.makeText(getContext(), "Registration successful", Toast.LENGTH_SHORT).show();

                if (type.equals("owner")) {
                    startActivity(new Intent(requireActivity(), OwnerMainActivity.class));
                } else {
                    startActivity(new Intent(requireActivity(), CustomerMainActivity.class));
                }
                requireActivity().finish();
            }
        });

        return view;
    }
}
