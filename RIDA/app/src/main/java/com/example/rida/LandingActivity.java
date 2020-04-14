package com.example.rida;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.fragment.app.Fragment;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

public class LandingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each more ID as a set of Ids because each
        // more should be considered as top level destinations.
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_events, R.id.navigation_expenses, R.id.navigation_hotspots, R.id.navigation_more)
                .build();
        //NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        //NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);

//        Button nav_to_events = findViewById(R.id.navigation_events);
//        nav_to_events.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                Intent nav_to_eventsIntent = new Intent(getApplicationContext(), Events.class);
//                startActivity(nav_to_eventsIntent);
//            }
//        });

    }
    //    private void navigateToEvents() {
//        Navigation.findNavController(view).navigate(R.id.navigation_events);
//    }

}
