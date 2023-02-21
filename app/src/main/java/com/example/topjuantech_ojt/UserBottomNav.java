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

public class UserBottomNav extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_drawer);

        BottomNavigationView bottomNavigationView = findViewById(R.id.user_btm_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.user_home:
                                setContentView(R.layout.activity_user_dashboard);
                                return true;
                            case R.id.user_orders:
                                setContentView(R.layout.activity_user_foodspot);
                                return true;
                            case R.id.user_booking:
                                setContentView(R.layout.activity_user_gas);
                                return true;
                            case R.id.user_profile:
                                setContentView(R.layout.activity_user_profile);
                                return true;
                        }
                        return false;
                    }
                });
        }
    }