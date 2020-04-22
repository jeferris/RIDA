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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import android.text.TextUtils;



public class NewUser extends AppCompatActivity {
    private EditText emailTV, passwordTV, full_nameTV, phone_numberTV, confirm_pass_newusrTV;
    private Button regBtn;

    public EditText getEmailTV() {
        return emailTV;
    }

    public EditText getPasswordTV() {
        return passwordTV;
    }

    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_user);

        mAuth = FirebaseAuth.getInstance();

        initializeUI();

        regBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerNewUser();
            }
        });
    }

    private void registerNewUser() {

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef;
        myRef = database.getReference();
        String email, password, full_name, phone_number, confirm_pass;
        email = emailTV.getText().toString();
        password = passwordTV.getText().toString();
        full_name = full_nameTV.getText().toString();
        phone_number = phone_numberTV.getText().toString();
        confirm_pass = confirm_pass_newusrTV.getText().toString();
        User u = new User(full_name, email, password, phone_number);
        myRef.child("users").push().setValue(u);

        if (TextUtils.isEmpty(email)) {
            Toast.makeText(getApplicationContext(), "Please enter email...", Toast.LENGTH_LONG).show();
            return;
        }
        if (TextUtils.isEmpty(password)) {
            Toast.makeText(getApplicationContext(), "Please enter password!", Toast.LENGTH_LONG).show();
            return;
        }
        if (TextUtils.isEmpty(full_name)) {
            Toast.makeText(getApplicationContext(), "Please enter full name!", Toast.LENGTH_LONG).show();
            return;
        }
        if (TextUtils.isEmpty(phone_number)) {
            Toast.makeText(getApplicationContext(), "Please enter phone number!", Toast.LENGTH_LONG).show();
            return;
        }
        if (TextUtils.isEmpty(confirm_pass)) {
            Toast.makeText(getApplicationContext(), "Please confirm password!", Toast.LENGTH_LONG).show();
            return;
        }

        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {

                            Toast.makeText(getApplicationContext(), "Registration successful!", Toast.LENGTH_LONG).show();


                            Intent intent = new Intent(NewUser.this, SignIn.class);
                            startActivity(intent);
                        }
                        else {
                            Toast.makeText(getApplicationContext(), "Registration failed! Please try again later", Toast.LENGTH_LONG).show();

                        }
                    }
                });
    }

    private void initializeUI() {
        emailTV = findViewById(R.id.email_newusr);
        passwordTV = findViewById(R.id.password_newusr);
        regBtn = findViewById(R.id.create_acct_newusr);
        full_nameTV = findViewById(R.id.full_name_newusr);
        phone_numberTV = findViewById(R.id.phone_newusr);
        confirm_pass_newusrTV = findViewById(R.id.conf_password_newusr);

        ImageButton back_btn_newusr = findViewById(R.id.back_btn_newusr);
        back_btn_newusr.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                Intent backNewUsrIntent = new Intent(getApplicationContext(), MainActivity.class );
                startActivity(backNewUsrIntent);
            }
        });

        Button sign_in_newusr = findViewById(R.id.sign_in_newusr);
        sign_in_newusr.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                Intent signInNewUsrIntent = new Intent(getApplication(), SignIn.class);
                startActivity(signInNewUsrIntent);
            }
        });
    }
}

        //firebase
        /*



        ImageButton back_btn_newusr = findViewById(R.id.back_btn_newusr);
        back_btn_newusr.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                Intent backNewUsrIntent = new Intent(getApplicationContext(), MainActivity.class );
                startActivity(backNewUsrIntent);
            }
        });
/*
        Button create_acct_newusr = findViewById(R.id.create_acct_newusr);
        create_acct_newusr.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                TextView full_name_newusr = (TextView) findViewById(R.id.full_name_newusr);
                TextView phone_newusr = (TextView) findViewById(R.id.phone_newusr);
                TextView email_newusr = (TextView) findViewById(R.id.email_newusr);
                TextView password_newusr = (TextView) findViewById(R.id.password_newusr);
                TextView confirm_pass_newusr = (TextView) findViewById(R.id.conf_password_newusr);
                CheckBox lyft_newusr = (CheckBox) findViewById(R.id.lyft_newusr);
                CheckBox uber_newusr = (CheckBox) findViewById(R.id.uber_newusr);

                String name = full_name_newusr.getText().toString();
                String phone = phone_newusr.getText().toString();
                String email = email_newusr.getText().toString();
                String password = password_newusr.getText().toString();
                String conf_pass = confirm_pass_newusr.getText().toString();
                boolean lyft = lyft_newusr.isChecked();
                boolean uber = uber_newusr.isChecked();

                if (    name.compareTo("") == 0 ||
                        phone.compareTo("") == 0 ||
                        email.compareTo("") == 0 ||
                        password.compareTo("") == 0 ||
                        conf_pass.compareTo("") == 0
                    ) {
                    Toast.makeText(v.getContext(),"All fields are required.", Toast.LENGTH_LONG+4).show();
                }
                else if (password.compareTo(conf_pass) != 0) {
                    Toast.makeText(v.getContext(),"Password and Confirm Password must match.", Toast.LENGTH_LONG+4).show();
                    password_newusr.setText("");
                    confirm_pass_newusr.setText("");
                }
                else if (!lyft && !uber) {
                    Toast.makeText(v.getContext(),"You must select Uber, Lyft, or both.", Toast.LENGTH_LONG+4).show();
                }
                else {
                    //saves data to database

                    //saves data to database

                    Intent createNewUsrIntent = new Intent(getApplication(), HomeActivity.class);
                    startActivity(createNewUsrIntent);
                }
            }
        });*/
/*
        Button sign_in_newusr = findViewById(R.id.sign_in_newusr);
        sign_in_newusr.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                Intent signInNewUsrIntent = new Intent(getApplication(), SignIn.class);
                startActivity(signInNewUsrIntent);
            }
        });
    }
}

 */
