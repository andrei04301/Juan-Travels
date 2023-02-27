package com.example.topjuantech_ojt;


import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class NavigationDrawer extends AppCompatActivity {

    DrawerLayout drawer;
    Toolbar toolbar;
    NavigationView navView;
    ActionBarDrawerToggle toggle;
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_drawer);

        drawer = findViewById(R.id.drawer);
        toolbar = findViewById(R.id.toolbar);
        navView = findViewById(R.id.navView);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        toggle = new ActionBarDrawerToggle(this, drawer, toolbar, 0, 0);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        bottomNavigationView = findViewById(R.id.user_btm_navigation);
        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if (id == R.id.btn_login) {
                    Intent intent = new Intent(NavigationDrawer.this, MainActivity.class);
                    startActivity(intent);
                    return true;
                } else {
                    Intent intent = new Intent(NavigationDrawer.this, MainActivity.class);
                    startActivity(intent);
                    return true;
                }
            }
        });

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if (id == R.id.user_home) {
                    Intent intent = new Intent(NavigationDrawer.this, UserDashboard.class);
                    startActivity(intent);
                    return true;
                } else {
                    if (id == R.id.user_booking) {
                        Intent intent = new Intent(NavigationDrawer.this, UserHotels.class);
                        startActivity(intent);
                        return true;
                    } else if (id == R.id.user_profile) {
                        Intent intent = new Intent(NavigationDrawer.this, UserAmusement.class);
                        startActivity(intent);
                        return true;
                    } else {
                        Intent intent = new Intent(NavigationDrawer.this, UserHotels.class);
                        startActivity(intent);
                        return true;
                    }
                }
            }
        });
//        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                int id = item.getItemId();
//                if (id == R.id.btn_login) {
//                    Intent intent = new Intent(NavigationDrawer.this, MainActivity.class);
//                    startActivity(intent);
//                    return true;
//                } else {
//                    Intent intent = new Intent(NavigationDrawer.this, MainActivity.class);
//                    startActivity(intent);
//                    return true;
//
//                }
//            }
//        });
//        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                int id = item.getItemId();
//                if (id == R.id.user_home) {
//                    Intent intent = new Intent(NavigationDrawer.this, UserDashboard.class);
//                    startActivity(intent);
//                    return true;
//                }else if (id == R.id.user_booking) {
//                    Intent intent = new Intent(NavigationDrawer.this, UserHotels.class);
//                    startActivity(intent);
//                    return true;
//                }else  if (id == R.id.user_profile) {
//                    Intent intent = new Intent(NavigationDrawer.this, UserAmusement.class);
//                    startActivity(intent);
//                    return true;
//                } else {
//                    Intent intent = new Intent(NavigationDrawer.this, UserHotels.class);
//                    startActivity(intent);
//                    return true;
//
//                }
//            }
//        });
    }
}