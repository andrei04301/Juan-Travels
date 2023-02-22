//package com.example.topjuantech_ojt;
//
//
//import androidx.annotation.NonNull;
//import androidx.appcompat.app.ActionBarDrawerToggle;
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.appcompat.widget.Toolbar;
//import androidx.drawerlayout.widget.DrawerLayout;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.view.MenuItem;
//
//import com.google.android.material.bottomnavigation.BottomNavigationView;
//import com.google.android.material.navigation.NavigationView;
//
//public class AdminBottomNav extends AppCompatActivity {
//
//
//
//    public class AdminBottomNav extends AppCompatActivity {
//
//        BottomNavigationView bottomNavigationView;
//
//        @Override
//        protected void onCreate(Bundle savedInstanceState) {
//            super.onCreate(savedInstanceState);
//            setContentView(R.layout.activity_admin_bottom_nav);
//
//            bottomNavigationView = findViewById(R.id.admin_btm_navigation);
//
//            // set the listener for the bottom navigation view
//            bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
//                @Override
//                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                    // determine which menu item was clicked
//                    switch (item.getItemId()) {
//                        case R.id.admin_home:
//                            startActivity(new Intent(AdminBottomNav.this, AdminDashboard.class));
//                            return true;
//                        case R.id.admin_products:
//                            startActivity(new Intent(AdminBottomNav.this, AdminOrders.class));
//                            return true;
//                        case R.id.admin_booking:
//                            startActivity(new Intent(AdminBottomNav.this, AdminInventory.class));
//                            return true;
//                        case R.id.admin_profile:
//                            startActivity(new Intent(AdminBottomNav.this, AdminProfile.class));
//                            return true;
//                    }
//                    return false;
//                }
//            });
//        }
//    }
//
//}
////    BottomNavigationView bottomNavigationView;
////
////    private void startActivityForMenuItem(MenuItem item) {
////        Intent intent;
////        switch (item.getItemId()) {
////            case R.id.user_home:
////                intent = new Intent(this, AdminDashboard.class);
////                break;
////            case R.id.user_orders:
////                intent = new Intent(this, UserHotelReservation.class);
////                break;
////            case R.id.user_booking:
////                intent = new Intent(this, UserGas.class);
////                break;
////            case R.id.user_profile:
////                intent = new Intent(this, UserProfile.class);
////                break;
////            default:
////                intent = new Intent(this, UserAttraction.class);
////                break;
////        }
////        startActivity(intent);
////    }
////
////    @Override
////    protected void onCreate(Bundle savedInstanceState) {
////        super.onCreate(savedInstanceState);
////        setContentView(R.layout.activity_user_dashboard);
////
////        bottomNavigationView = findViewById(R.id.user_btm_navigation);
////        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
////            @Override
////            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
////                startActivityForMenuItem(item);
////                return true;
////            }
////        });
////    }
////}
//
//
//
//
//
//
////
////    @Override
////    protected void onCreate(Bundle savedInstanceState) {
////        super.onCreate(savedInstanceState);
////        setContentView(R.layout.activity_navigation_drawer);
//
////        BottomNavigationView bottomNavigationView = findViewById(R.id.user_btm_navigation);
////        bottomNavigationView.setOnNavigationItemSelectedListener(
////                new BottomNavigationView.OnNavigationItemSelectedListener() {
////                    @Override
////                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
////                        switch (item.getItemId()) {
////                            case R.id.admin_home:
////                                setContentView(R.layout.activity_user_dashboard);
////                                return true;
////                            case R.id.admin_products:
////                                setContentView(R.layout.activity_user_foodspot);
////                                return true;
////                            case R.id.admin_booking:
////                                setContentView(R.layout.activity_user_gas);
////                                return true;
////                            case R.id.user_profile:
////                                setContentView(R.layout.activity_user_profile);
////                                return true;
//
////                        return false;
////                    }
////                });
////    }
////}