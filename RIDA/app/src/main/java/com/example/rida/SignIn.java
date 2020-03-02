package com.example.rida;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Toast;
import androidx.annotation.NonNull;


import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import android.text.TextUtils;


public class SignIn extends AppCompatActivity {

    private EditText emailTV, passwordTV;
    private Button loginBtn;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        mAuth = FirebaseAuth.getInstance();

        initializeUI();

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginUserAccount();
            }
        });
    }

    private void loginUserAccount() {

        String email, password;
        email = emailTV.getText().toString();
        password = passwordTV.getText().toString();

        if (TextUtils.isEmpty(email)) {
            Toast.makeText(getApplicationContext(), "Please enter email...", Toast.LENGTH_LONG).show();
            return;
        }
        if (TextUtils.isEmpty(password)) {
            Toast.makeText(getApplicationContext(), "Please enter password!", Toast.LENGTH_LONG).show();
            return;
        }

        mAuth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        Toast.makeText(getApplicationContext(), "Login successful!", Toast.LENGTH_LONG).show();


                        Intent intent = new Intent(SignIn.this, LandingActivity.class);
                        startActivity(intent);
                    }
                    else {
                        Toast.makeText(getApplicationContext(), "Login failed! Please try again later", Toast.LENGTH_LONG).show();

                    }
                }
            });
    }

    private void initializeUI() {
        emailTV = findViewById(R.id.email_signin); //will be email for now
        passwordTV = findViewById(R.id.password_signin);
        loginBtn = findViewById(R.id.sign_in_signin);

        ImageButton back_btn_signin = findViewById(R.id.back_btn_signin);
        back_btn_signin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent backSignInIntent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(backSignInIntent);
            }
        });

        Button new_acct_signin = findViewById(R.id.new_acct_signin);
        new_acct_signin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                Intent newAcctSigninIntent = new Intent(getApplication(), NewUser.class);
                startActivity(newAcctSigninIntent);
            }
        });
    }
}
/*
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class SignIn extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        ImageButton back_btn_signin = findViewById(R.id.back_btn_signin);
        back_btn_signin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent backSignInIntent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(backSignInIntent);
            }
        });

        Button sign_in_signin = findViewById(R.id.sign_in_signin);
        sign_in_signin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                TextView phone_signin = findViewById(R.id.phone_signin);
                TextView password_signin = findViewById(R.id.password_signin);

                String phone = phone_signin.getText().toString();
                String password = password_signin.getText().toString();

                if (phone.compareTo("") == 0 ||
                    password.compareTo("") == 0) {
                    Toast.makeText(v.getContext(), "All fields are required.", Toast.LENGTH_LONG + 4).show();
                } else {


                    Intent signInSigninIntent = new Intent(getApplication(), HomeActivity.class);
                    startActivity(signInSigninIntent);
                }
            }
        });

        Button new_acct_signin = findViewById(R.id.new_acct_signin);
        new_acct_signin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                Intent newAcctSigninIntent = new Intent(getApplication(), NewUser.class);
                startActivity(newAcctSigninIntent);
            }
        });
    }
}

 */
