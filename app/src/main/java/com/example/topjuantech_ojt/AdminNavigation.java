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

public class AdminNavigation extends AppCompatActivity {
    DrawerLayout drawer;
    Toolbar toolbar;
    NavigationView navView;
    ActionBarDrawerToggle toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_navigation);
        drawer = findViewById(R.id.drawer);
        toolbar = findViewById(R.id.toolbar);
        navView = findViewById(R.id.navView);
        setSupportActionBar(toolbar);
        toggle = new ActionBarDrawerToggle(this, drawer, toolbar, 0, 0);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if (id == R.id.navEstReg) {
                    Intent intent = new Intent(AdminNavigation.this, RegistrationEstablishment.class);
                    startActivity(intent);
                    return true;

//                }else if (id == R.id.estMenu) {
//                    Intent intent = new Intent(AdminNavigation.this, AdminMenu.class);
//                    startActivity(intent);
//                    return true;
                }else {
                    Intent intent = new Intent(AdminNavigation.this, RegistrationEstablishment.class);
                    startActivity(intent);
                    return true;
                }
            }
        });
        BottomNavigationView bottomNavigationView = findViewById(R.id.user_btm_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if (id == R.id.user_home) {
                    Intent intent = new Intent(AdminNavigation.this, MainActivity.class);
                    startActivity(intent);
                    return true;
                } if (id == R.id.user_booking) {
                    Intent intent = new Intent(AdminNavigation.this, MainActivity.class);
                    startActivity(intent);
                    return true;
                } if (id == R.id.user_profile) {
                    Intent intent = new Intent(AdminNavigation.this, MainActivity.class);
                    startActivity(intent);
                    return true;
                } else {
                    Intent intent = new Intent(AdminNavigation.this, MainActivity.class);
                    startActivity(intent);
                    return true;

                }
            }
        });
    }
}