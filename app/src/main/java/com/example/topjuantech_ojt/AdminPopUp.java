package com.example.topjuantech_ojt;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdminPopUp extends AppCompatActivity {
    private EditText prodName, prodPrice, prodDesc;
    private String name, price, image, desc;
    private ImageButton prodImage;
    FirebaseAuth mAuth;
    FirebaseUser mUser;
    FirebaseDatabase db = FirebaseDatabase.getInstance();
    ProgressDialog progressDialog;
    FirebaseFirestore fStore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_pop_up);
//        DisplayMetrics dm = new DisplayMetrics();
//        getWindowManager().getDefaultDisplay().getMetrics(dm);
//        int width = dm.widthPixels;
//        int height = dm.heightPixels;
//        getWindow().setLayout((int) (width*.7),(int)(height*.5));
//        WindowManager.LayoutParams params = getWindow().getAttributes();
//        params.gravity= Gravity.CENTER;
//        params.x=0;
//        params.y=-20;
//        getWindow().setAttributes(params);
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;
        int height = dm.heightPixels;
        getWindow().setLayout(width, height);
        Button btnAdd = (Button) findViewById(R.id.btnAdd);
        progressDialog = new ProgressDialog(this);
        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();
        fStore = FirebaseFirestore.getInstance();
        prodName = (EditText) findViewById(R.id.prodName);
        prodPrice = (EditText) findViewById(R.id.prodPrice);
        prodDesc = (EditText) findViewById(R.id.prodDesc);
        prodImage = findViewById(R.id.prodImage);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PerformAuth();
            }
        });
    }
//    private void findAllCollections() {
//        FirebaseFirestore db = FirebaseFirestore.getInstance();
//
//        // Get a list of all the collection IDs in the root directory
//        db.listCollections().addOnSuccessListener(new OnSuccessListener<List<CollectionReference>>() {
//            @Override
//            public void onSuccess(List<CollectionReference> collections) {
//                // Iterate over the collections and do something with them, e.g. print their IDs
//                for (CollectionReference collection : collections) {
//                    Log.d(TAG, collection.getId());
//                }
//            }
//        }).addOnFailureListener(new OnFailureListener() {
//            @Override
//            public void onFailure(@NonNull Exception e) {
//                // Handle errors here
//            }
//        });
//    }
    private void PerformAuth() {
        RegistrationEstablishment registrationEstablishment = new RegistrationEstablishment();
        String chosenRegion = registrationEstablishment.getChosenRegion();
        String chosenCity = registrationEstablishment.getChosenCity();
        name = prodName.getText().toString();
        price = prodPrice.getText().toString();
        desc = prodDesc.getText().toString();

        if (name.isEmpty()) {
            prodName.setError("Please input the Product's Name!");
        } else if (price.isEmpty()) {
            prodPrice.setError("Please input the Product's Price!");
        } else {
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
                                            progressDialog.setMessage("Please wait...");
                                            progressDialog.setTitle("Adding Menu...");
                                            progressDialog.setCanceledOnTouchOutside(false);
                                            progressDialog.show();
                                            HashMap<String, String> userMap = new HashMap<>();
                                            userMap.put("ProductName", name);
                                            userMap.put("ProductPrice", price);
                                            userMap.put("ProductDescription", desc);
                                            userMap.put("AdminID", uid);
                                            CollectionReference chosenType = firestore.collection(region.toString() + establishmentType.toString());
                                            chosenType.add(userMap)
                                                    .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                                                        @Override
                                                        public void onSuccess(DocumentReference documentReference) {
                                                            Toast.makeText(AdminPopUp.this, "Product data saved successfully", Toast.LENGTH_SHORT).show();
                                                            progressDialog.dismiss();
                                                            // Do something after adding the document
                                                        }
                                                    })
                                                    .addOnFailureListener(new OnFailureListener() {
                                                        @Override
                                                        public void onFailure(@NonNull Exception e) {
                                                            Log.w(TAG, "Error adding document: ", e);
                                                            Toast.makeText(getApplicationContext(), "Error adding document", Toast.LENGTH_SHORT).show();
                                                            progressDialog.dismiss();
                                                        }
                                                    });
                                        }else{
                                            Toast.makeText(getApplicationContext(), "Error retrieving Establishment type and its address.", Toast.LENGTH_SHORT).show();
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
                }else{
                Toast.makeText(getApplicationContext(), "Login Expired, please log again.", Toast.LENGTH_SHORT).show();
            }
            }
        }
    }
