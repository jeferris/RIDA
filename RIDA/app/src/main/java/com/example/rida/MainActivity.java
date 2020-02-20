package com.example.rida;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button new_acct = findViewById(R.id.new_acct);
        new_acct.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                Intent newUserIntent = new Intent(getApplicationContext(), NewUser.class );
                startActivity(newUserIntent);
            }
        });
    }



}
