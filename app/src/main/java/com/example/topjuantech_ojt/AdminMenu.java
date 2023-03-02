package com.example.topjuantech_ojt;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdminMenu extends AppCompatActivity {
    FloatingActionButton addMenu;
    LinearLayout lLayout;
    Button btnProceed;
    RecyclerView recyclerView;
    AdminAdapter adminAdapter;
    ArrayList<Admin> userArrayList;
    List<String> ids;
    FirebaseFirestore db;
    Admin admin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_menu);
        recyclerView = findViewById(R.id.estProducts);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        db = FirebaseFirestore.getInstance();
        userArrayList = new ArrayList<Admin>();
        ids = new ArrayList<String>();
        adminAdapter = new AdminAdapter(getApplicationContext(), userArrayList);
        adminAdapter = new AdminAdapter(AdminMenu.this, userArrayList);
        admin = new Admin();

        addMenu = findViewById(R.id.addMenu);
        addMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PerformAuth();
                openPopUpWindow();
            }
        });
    }
    private void openPopUpWindow() {
        Intent popupwindow = new Intent(AdminMenu.this, AdminPopUp.class);
        startActivity(popupwindow);
    }

    private void PerformAuth() {
        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        FirebaseFirestore firestore = FirebaseFirestore.getInstance();
        String uid = currentUser.getUid();
        if (uid != null) {
            String[] collections = {"Region I - Ilocos RegionFood Spots", "Region II - Cagayan ValleyFood Spots", "Region III - Central LuzonFood Spots"};
            FirebaseFirestore db = FirebaseFirestore.getInstance();
            // Use a loop to create a collection group query for each collection
            for (String collectionn : collections) {
                db.collectionGroup(collectionn)
                        .whereEqualTo("AdminID", uid)
                        .get()
                        .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                            @Override
                            public void onSuccess(QuerySnapshot querySnapshot) {
                                for (QueryDocumentSnapshot document : querySnapshot) {
                                    Log.d(TAG, "Found document with ID: " + document.getId());
                                    // Access document data as needed
                                    Map<String, Object> data = document.getData();
                                    Object region = data.get("Region");
                                    Object establishmentType = data.get("EstablishmentType");
                                    if (region != null && establishmentType != null) {
                                        DocumentReference uidRef = db.collection(region.toString() + establishmentType.toString()).document(uid);
                                        uidRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                                            @Override
                                            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                                                if (task.isSuccessful()) {
                                                    DocumentSnapshot document = task.getResult();
                                                    if (document.exists()) {
                                                        String productName = document.getString("ProductName");
                                                        String productPrice = document.getString("ProductPrice");
                                                        admin = new Admin(productName, productPrice, document.getId(), region.toString() + establishmentType.toString());
                                                        if (!ids.contains(document.getId())) {
                                                            ids.add(document.getId());
                                                            userArrayList.add(admin);
                                                        }
                                                        adminAdapter.notifyDataSetChanged();
                                                    } else {
                                                        Toast.makeText(getApplicationContext(), "No such document", Toast.LENGTH_SHORT).show();
                                                    }
                                                } else {
                                                    Toast.makeText(getApplicationContext(), "Error getting document", Toast.LENGTH_SHORT).show();
                                                }
                                            }
                                        });
                                    }
                                }
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Log.w(TAG, "Error getting documents: ", e);
                                Toast.makeText(getApplicationContext(), "Error retrieving documents, please register your establishment first", Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        } else {
            Toast.makeText(getApplicationContext(), "Login Expired, please log in again.", Toast.LENGTH_SHORT).show();
        }
    }
}