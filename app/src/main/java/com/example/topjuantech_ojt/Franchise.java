package com.example.topjuantech_ojt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Franchise extends AppCompatActivity {
    private Button estProfile,estMenu,any;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_franchise);

        estProfile = findViewById(R.id.btnEstProfile);
        estMenu = findViewById(R.id.btnEstMenu);
        any = findViewById(R.id.btnEstAnyMuna);

        estProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), EstablishmentProfile.class);
                startActivity(intent);
            }
        });
        estMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AdminMenu.class);
                startActivity(intent);
            }
        });
        any.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), UserDashboard.class);
                startActivity(intent);
            }
        });
    }
}