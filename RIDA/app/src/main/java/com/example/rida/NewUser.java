package com.example.rida;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class NewUser extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_user);

        ImageButton back_btn_newusr = findViewById(R.id.back_btn_newusr);
        back_btn_newusr.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                Intent backNewUsrIntent = new Intent(getApplicationContext(), MainActivity.class );
                startActivity(backNewUsrIntent);
            }
        });

        Button sign_in_newusr = findViewById(R.id.sign_in_newusr);
        sign_in_newusr.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent signInNewUsrIntent = new Intent(getApplication(), SignIn.class);
                startActivity(signInNewUsrIntent);
            }
        });
    }
}
