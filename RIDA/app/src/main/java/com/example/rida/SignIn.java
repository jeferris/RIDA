package com.example.rida;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

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
                Intent signInSigninIntent = new Intent(getApplication(), HomeActivity.class);
                startActivity(signInSigninIntent);
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
