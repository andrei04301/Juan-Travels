package com.example.topjuantech_ojt;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import android.os.Bundle;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;



public class UserDashboard extends NavigationDrawer implements View.OnClickListener {
    // creating object of ViewPager
    ViewPager mViewPager;

    // images array
    int[] images = {R.drawable.food, R.drawable.coffee, R.drawable.tourist, R.drawable.hospital,
            R.drawable.hotel, R.drawable.gas, R.drawable.logo, R.drawable.food};
    private ImageView icon1, icon2, icon3, icon4, icon5, icon6, icon7, icon8, icon9;
    // Creating Object of ViewPagerAdapter
    SliderAdapter mViewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LayoutInflater inflater = LayoutInflater.from(this);
        View v = inflater.inflate(R.layout.activity_user_dashboard, null, false);
        drawer.addView(v, 0);
        // creating object of ViewPager
        ViewPager mViewPager;

        // Initializing the ViewPager Object
        mViewPager = (ViewPager)findViewById(R.id.viewPagerMain);

        // Initializing the ViewPagerAdapter
        mViewPagerAdapter = new SliderAdapter(UserDashboard.this, images);
        // Adding the Adapter to the ViewPager
        mViewPager.setAdapter(mViewPagerAdapter);

        icon1 = (ImageView) findViewById(R.id.icon1);
        icon2 = (ImageView) findViewById(R.id.icon2);
        icon3 = (ImageView) findViewById(R.id.icon3);
        icon4 = (ImageView) findViewById(R.id.icon4);
        icon5 = (ImageView) findViewById(R.id.icon5);
        icon6 = (ImageView) findViewById(R.id.icon6);
        icon7 = (ImageView) findViewById(R.id.icon7);
        icon8 = (ImageView) findViewById(R.id.icon8);
        icon9 = (ImageView) findViewById(R.id.icon9);
        icon1.setOnClickListener(this);
        icon2.setOnClickListener(this);
        icon3.setOnClickListener(this);
        icon4.setOnClickListener(this);
        icon5.setOnClickListener(this);
        icon6.setOnClickListener(this);
        icon7.setOnClickListener(this);
        icon8.setOnClickListener(this);
        icon9.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.icon1:
                // Open the corresponding activity when icon1 is clicked
                Intent intent1 = new Intent(UserDashboard.this, UserDesiredCity.class);
                startActivity(intent1);
                break;
            case R.id.icon2:
                // Open the corresponding activity when icon2 is clicked
                Intent intent2 = new Intent(UserDashboard.this, UserBanks.class);
                startActivity(intent2);
                break;
            case R.id.icon3:
                // Open the corresponding activity when icon3 is clicked
                Intent intent3 = new Intent(UserDashboard.this, UserBeverages.class);
                startActivity(intent3);
                break;
            case R.id.icon4:
                // Open the corresponding activity when icon4 is clicked
                Intent intent4 = new Intent(UserDashboard.this, UserFoodspot.class);
                startActivity(intent4);
                break;
            case R.id.icon5:
                // Open the corresponding activity when icon5 is clicked
                Intent intent5 = new Intent(UserDashboard.this, UserGas.class);
                startActivity(intent5);
                break;
            case R.id.icon6:
                // Open the corresponding activity when icon6 is clicked
                Intent intent6 = new Intent(UserDashboard.this, UserGovernment.class);
                startActivity(intent6);
                break;
            case R.id.icon7:
                // Open the corresponding activity when icon7 is clicked
                Intent intent7 = new Intent(UserDashboard.this, UserHospital.class);
                startActivity(intent7);
                break;
            case R.id.icon8:
                // Open the corresponding activity when icon8 is clicked
                Intent intent8 = new Intent(UserDashboard.this, UserHotels.class);
                startActivity(intent8);
                break;
            case R.id.icon9:
                // Open the corresponding activity when icon 9 is clicked
                Intent intent9 = new Intent(UserDashboard.this, UserAttraction.class);
                startActivity(intent9);
                break;
            default:
                break;
        }
    }
    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }
}

