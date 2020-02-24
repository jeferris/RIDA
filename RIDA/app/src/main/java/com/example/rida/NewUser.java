package com.example.rida;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

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
                    Intent createNewUsrIntent = new Intent(getApplication(), HomeActivity.class);
                    startActivity(createNewUsrIntent);
                }
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
