package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ViewGroup root;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        root = findViewById(R.id.root);

        Switch registerLogin = findViewById(R.id.switch1);
        TextView mainLabel = findViewById(R.id.loginText);
        EditText username = findViewById(R.id.usernameEdit);
        EditText password = findViewById(R.id.passwordEdit);
        EditText confirmPassword = findViewById(R.id.Password);
        EditText email = findViewById(R.id.emailEdit);
        Button loginBtn = findViewById(R.id.loginBtn);

        registerLogin.setOnClickListener(
                v -> {
                    if (registerLogin.isChecked()) {
                        confirmPassword.setVisibility(View.VISIBLE);
                        email.setVisibility(View.VISIBLE);
                        loginBtn.setText("Press Me To Register");
                        mainLabel.setText("Register");
                    } else {
                        confirmPassword.setVisibility(View.INVISIBLE);
                        email.setVisibility(View.INVISIBLE);
                        mainLabel.setText("Login");
                        loginBtn.setVisibility(View.VISIBLE);
                    }
                }
        );

        loginBtn.setOnClickListener(
                v -> {

                    if (registerLogin.isChecked()) {
                        String usernameValue = username.getText().toString();
                        String passwordValue = password.getText().toString();
                        if (usernameValue.isEmpty() || passwordValue.isEmpty()) {
                            Toast.makeText(this, "Please fill all the fields!", Toast.LENGTH_SHORT).show();

                        } else {
                            if (usernameValue.equals("test") && passwordValue.equals("test")) {
                                Toast.makeText(this, "You are successfully logged in!", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(this, "Username/Password is incorrect!", Toast.LENGTH_SHORT).show();
                            }

                        }

                    } else {
                        String usernameValue = username.getText().toString();
                        String passwordValue = password.getText().toString();
                        String confirmPasswordValue = confirmPassword.getText().toString();
                        String emailValue = email.getText().toString();
                        if (usernameValue.isEmpty() || passwordValue.isEmpty() || confirmPasswordValue.isEmpty() || emailValue.isEmpty()) {
                            Toast.makeText(this, "Please fill all the fields!", Toast.LENGTH_SHORT).show();

                        } else {
                            if (passwordValue.equals(confirmPasswordValue) == false) {
                                Toast.makeText(this, "Confirm password should match!", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(this, "You are successfully registered!", Toast.LENGTH_SHORT).show();
                            }

                        }
                    }


                });
    }
}