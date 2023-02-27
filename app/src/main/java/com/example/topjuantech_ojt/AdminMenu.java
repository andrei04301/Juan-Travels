package com.example.topjuantech_ojt;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

public class AdminMenu extends AppCompatActivity {
    FloatingActionButton addMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_menu);

        addMenu = findViewById(R.id.addMenu);
        addMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPopUpWindow();
            }
        });
    }

    private void openPopUpWindow() {
        Intent popupwindow = new Intent(AdminMenu.this, AdminPopUp.class);
        startActivity(popupwindow);
    }
//    String[] collections = { "Region I - Ilocos RegionFood Spots", "Region I - Ilocos RegionAttractions" };
//    // Use a loop to create a collection group query for each collection
//                    for (String collection : collections) {
//        db.collectionGroup(collection)
//                .whereEqualTo("AdminID", uid)
//                .get()
//                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
//                    @Override
//                    public void onSuccess(QuerySnapshot querySnapshot) {
//                        for (QueryDocumentSnapshot document : querySnapshot) {
//                            Log.d(TAG, "Found document with ID: " + document.getId());
//                            // Access document data as needed
//                        }
//                    }
//                })
//                .addOnFailureListener(new OnFailureListener() {
//                    @Override
//                    public void onFailure(@NonNull Exception e) {
//                        Log.w(TAG, "Error getting documents: ", e);
//                        Toast.makeText(getApplicationContext(), "Error retrieving documents", Toast.LENGTH_SHORT).show();
//                    }
//                });
}