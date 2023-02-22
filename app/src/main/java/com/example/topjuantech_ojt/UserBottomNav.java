package com.example.topjuantech_ojt;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class UserBottomNav extends AppCompatActivity {

}
//    BottomNavigationView bottomNavigationView;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_user_bottom_nav);
//
//        bottomNavigationView = findViewById(R.id.user_btm_navigation);
//        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                int itemId = item.getItemId();
//                switch (itemId) {
//                    case R.id.user_home:
//                        startActivity(new Intent(UserBottomNav.this, UserDashboard.class));
//                        return true;
//                    case R.id.user_orders:
//                        startActivity(new Intent(UserBottomNav.this, UserHotelReservation.class));
//                        return true;
//                    case R.id.user_booking:
//                        startActivity(new Intent(UserBottomNav.this, UserGas.class));
//                        return true;
//                    case R.id.user_profile:
//                        startActivity(new Intent(UserBottomNav.this, UserProfile.class));
//                        return true;
//                    default:
//                        startActivity(new Intent(UserBottomNav.this, UserAttraction.class));
//                        return true;
//                }
//            }
//        });
//    }
//}


//    public class AdminBottomNav extends AppCompatActivity {
//        BottomNavigationView bottomNavigationView;
//
//        @Override
//        protected void onCreate(Bundle savedInstanceState) {
//            super.onCreate(savedInstanceState);
//            setContentView(R.layout.activity_admin_bottom_nav);
//
//            bottomNavigationView = findViewById(R.id.bottom_navigation_view);
//            bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
//                @Override
//                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                    int itemId = item.getItemId();
//                    switch (itemId) {
//                        case R.id.user_home:
//                            startActivity(new Intent(AdminBottomNav.this, UserDashboard.class));
//                            return true;
//                        case R.id.user_orders:
//                            startActivity(new Intent(AdminBottomNav.this, UserHotelReservation.class));
//                            return true;
//                        case R.id.user_booking:
//                            startActivity(new Intent(AdminBottomNav.this, UserGas.class));
//                            return true;
//                        case R.id.user_profile:
//                            startActivity(new Intent(AdminBottomNav.this, UserProfile.class));
//                            return true;
//                        default:
//                            startActivity(new Intent(AdminBottomNav.this, UserAttraction.class));
//                            return true;
//                    }
//                }
//            });
//        }
//    }
//
//}






//    BottomNavigationView bottomNavigationView;
//
//    private void startActivityForMenuItem(MenuItem item) {
//        Intent intent;
//        switch (item.getItemId()) {
//            case R.id.user_home:
//                intent = new Intent(this, UserDashboard.class);
//                break;
//            case R.id.user_orders:
//                intent = new Intent(this, UserHotelReservation.class);
//                break;
//            case R.id.user_booking:
//                intent = new Intent(this, UserGas.class);
//                break;
//            case R.id.user_profile:
//                intent = new Intent(this, UserProfile.class);
//                break;
//            default:
//                intent = new Intent(this, UserAttraction.class);
//                break;
//        }
//        startActivity(intent);
//    }
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_user_dashboard);
//
//        bottomNavigationView = findViewById(R.id.user_btm_navigation);
//        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                startActivityForMenuItem(item);
//                return true;
//            }
//        });
//    }
//}