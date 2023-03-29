package com.example.topjuantech_ojt;


import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class NavigationDrawer extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private FirebaseFirestore mFirestore;
    DrawerLayout drawer;
    Toolbar toolbar;
    NavigationView navView;
    ActionBarDrawerToggle toggle;
    BottomNavigationView bottomNavigationView;
    private Menu menu; // Declare menu as a class-level variable
    private boolean userIsRegistered = false; // Add userIsRegistered as a class-level variable


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_drawer);
        mAuth = FirebaseAuth.getInstance();
        mFirestore = FirebaseFirestore.getInstance();
        drawer = findViewById(R.id.drawer);
        toolbar = findViewById(R.id.toolbar);
        navView = findViewById(R.id.navView);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        toggle = new ActionBarDrawerToggle(this, drawer, toolbar, 0, 0);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        menu = navView.getMenu(); // Assign the menu variable inside onCreate()
        UserFilter(); // Call UserFilter() to check if the user is registered
//        menu.clear(); // Clear the previous menu items
//        if (userIsRegistered) {
//            getMenuInflater().inflate(R.menu.drawer_menu_registered, menu);
//        } else {
//            getMenuInflater().inflate(R.menu.drawer_menu, menu);
//        }
        bottomNavigationView = findViewById(R.id.user_btm_navigation);

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
    }
    private void UserFilter() {
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser != null) {
            String uid = currentUser.getUid();
            mFirestore.collection("Users").document(uid)
                    .get()
                    .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                        @Override
                        public void onSuccess(DocumentSnapshot documentSnapshot) {
                            if (documentSnapshot.exists()) {
                                String userType = documentSnapshot.getString("isUser");
                                if (userType.equals("Basic")) {
                                    navView.getMenu().clear(); // Remove the other menu
                                    getMenuInflater().inflate(R.menu.menu, menu);
                                    navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
                                        @Override
                                        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                                            int id = item.getItemId();
                                            if (id == R.id.navDash) {
                                                Intent intent = new Intent(NavigationDrawer.this, UserDashboard.class);
                                                startActivity(intent);
                                                return true;
                                            } else if (id == R.id.navProfile) {
                                                    Intent intent = new Intent(NavigationDrawer.this, UserProfile.class);
                                                    startActivity(intent);
                                                    return true;
                                            } else if (id == R.id.navEstReg) {
                                                    Intent intent = new Intent(NavigationDrawer.this, RegistrationEstablishment.class);
                                                    startActivity(intent);
                                                    return true;
                                            } else {
                                                    Intent intent = new Intent(NavigationDrawer.this, UserDashboard.class);
                                                    startActivity(intent);
                                                    return true;
                                                }
                                            }
                                    });
                                } else {
                                    navView.getMenu().clear(); // Remove the other menu
                                    getMenuInflater().inflate(R.menu.admin_menu, menu);
                                    navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
                                        @Override
                                        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                                            int id = item.getItemId();
                                            if (id == R.id.navDash) {
                                                Intent intent = new Intent(NavigationDrawer.this, UserDashboard.class);
                                                startActivity(intent);
                                                return true;
                                            } else if (id == R.id.navProfile) {
                                                Intent intent = new Intent(NavigationDrawer.this, UserProfile.class);
                                                startActivity(intent);
                                                return true;
                                            } else if (id == R.id.navEstReg) {
                                                Intent intent = new Intent(NavigationDrawer.this, RegistrationEstablishment.class);
                                                startActivity(intent);
                                                return true;
                                            } else if (id == R.id.estMenu) {
                                                Intent intent = new Intent(NavigationDrawer.this, AdminMenu.class);
                                                startActivity(intent);
                                                return true;
                                            } else if (id == R.id.est) {
                                                Intent intent = new Intent(NavigationDrawer.this, Establishments.class);
                                                startActivity(intent);
                                                return true;
                                            } else {
                                                Intent intent = new Intent(NavigationDrawer.this, UserDashboard.class);
                                                startActivity(intent);
                                                return true;
                                            }
                                        }
                                    });
                                }
                            } else {
                                Toast.makeText(NavigationDrawer.this, "Failed", Toast.LENGTH_LONG).show();
                            }
                        }
                    });
        }
    }
}
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
//    }
//}