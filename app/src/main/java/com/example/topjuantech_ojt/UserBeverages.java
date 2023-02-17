package com.example.topjuantech_ojt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class UserBeverages extends AppCompatActivity {
    androidx.cardview.widget.CardView cardView;
    LinearLayout lLayout;
    Button btnProceed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_beverages);
        lLayout=findViewById(R.id.lLayout);
        cardView=findViewById(R.id.cardView);
        btnProceed=findViewById(R.id.btnProceed);
        btnProceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cardView.setVisibility(v. INVISIBLE);
                lLayout.setVisibility(v. VISIBLE);
            }
        });
    }
}