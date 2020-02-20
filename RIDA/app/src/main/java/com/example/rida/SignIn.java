package com.example.rida;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class SignIn extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
    }

    ImageButton back_btn_signin = findViewById(R.id.back_btn_signin);
        back_btn_signin.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v){
            Intent backSignInIntent = new Intent(getApplicationContext(), MainActivity.class );
            startActivity(backSignInIntent);
        }
    });
}
