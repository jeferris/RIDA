package com.example.rida;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button new_acct_main = findViewById(R.id.new_acct_main);
        new_acct_main.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                Intent newAcctMainIntent = new Intent(getApplicationContext(), NewUser.class );
                startActivity(newAcctMainIntent);
            }
        });

        Button sign_in_main = findViewById(R.id.sign_in_main);
        sign_in_main.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent signInMainIntent = new Intent(getApplication(), SignIn.class);
                startActivity(signInMainIntent);
            }
        });
    }



}
