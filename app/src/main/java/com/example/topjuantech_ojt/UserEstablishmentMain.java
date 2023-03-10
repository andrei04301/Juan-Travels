package com.example.topjuantech_ojt;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.firestore.FirebaseFirestore;

import java.text.DecimalFormat;

public class UserEstablishmentMain extends AppCompatActivity implements ActivityCallback{
    TabLayout tabLayout;
    ViewPager viewPager;
    FloatingActionButton fb,google,twitter;
    FirebaseFirestore db;
    ImageView img_details;
    TextView details_name, establishmentInfo;
    public String adminID = "";
    public String establishmentType = "";
    Button btnGo;
    DecimalFormat decimalFormat = new DecimalFormat("#");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_establishment_main);
        db = FirebaseFirestore.getInstance();
        img_details = findViewById(R.id.img_details);
        details_name = findViewById(R.id.details_name);
        establishmentInfo = findViewById(R.id.establishmentInfo);
        btnGo = findViewById(R.id.btnGo);
        tabLayout = findViewById(R.id.tab_layout);
        viewPager = findViewById(R.id.view_pager);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        UserInfoAdapter userInfoAdapter = new UserInfoAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        userInfoAdapter.addFragment(new UserInfoFragment(), "Information");
//        userInfoAdapter.addFragment(new FeaturedFragment(), "Featured Establishment");
        viewPager.setAdapter(userInfoAdapter);
    }

    @Override
    public void onEditTextChange(String _adminID, String _establishmentType) {

    }

    @Override
    public String getAdminID() {
        return null;
    }

    @Override
    public String getEstablishmentType() {
        return null;
    }
}