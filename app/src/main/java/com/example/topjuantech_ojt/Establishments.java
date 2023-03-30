package com.example.topjuantech_ojt;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Establishments extends NavigationDrawer implements View.OnClickListener {
    private FirebaseAuth mAuth;
    private FirebaseFirestore mFirestore;
    RecyclerView recyclerView;
    EstablishmentAdapter establishmentAdapter;
    ArrayList<User> userArrayList;
    List<String> ids;
    FirebaseFirestore db;
    User user;

    EditText search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LayoutInflater inflater = LayoutInflater.from(this);
        View v = inflater.inflate(R.layout.activity_establishments, null, false);
        drawer.addView(v, 0);

        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        db = FirebaseFirestore.getInstance();
        userArrayList = new ArrayList<User>();
        ids = new ArrayList<String>();
        establishmentAdapter = new EstablishmentAdapter(getApplicationContext(), userArrayList);
        establishmentAdapter = new EstablishmentAdapter(Establishments.this, userArrayList);
        user = new User();
        recyclerView.setAdapter(establishmentAdapter);
        loadingEstablishment();

    }
    private void loadingEstablishment() {
        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        FirebaseFirestore firestore = FirebaseFirestore.getInstance();
        String uid = currentUser.getUid();
        if (uid != null) {
            String[] collections = {"Region I - Ilocos RegionBanks", "Region III - Central LuzonFood Spots", "Region I - Ilocos RegionFood Spots","Region IVA - CALABARZONGas Stations"};
            FirebaseFirestore db = FirebaseFirestore.getInstance();
            List<Task<?>> tasks = new ArrayList<>();
            for (String collectionn : collections) {
                Query query = db.collection(collectionn).whereEqualTo("AdminID", uid);
                Task<QuerySnapshot> task = query.get().addOnSuccessListener(querySnapshot -> {
                    for (QueryDocumentSnapshot document : querySnapshot) {
                        String region = (String) document.get("Region");
                        String establishmentType = (String) document.get("EstablishmentType");
                        String Collection = region + establishmentType;
                        if (region != null && establishmentType != null) {
                            CollectionReference collectionRef = db.collection(Collection);
                            collectionRef.document(document.getId()).get().addOnCompleteListener(task1 -> {
                                if (task1.isSuccessful()) {
                                    DocumentSnapshot documentSnapshot = task1.getResult();
                                    if (documentSnapshot.exists()) {
                                        String EstablishmentName = documentSnapshot.getString("EstablishmentName");
                                        String City = documentSnapshot.getString("City");
                                        User user = new User(EstablishmentName, City, documentSnapshot.getId(), region + establishmentType);
                                        if (!ids.contains(documentSnapshot.getId())) {
                                            ids.add(documentSnapshot.getId());
                                            userArrayList.add(user);
                                        }
                                        establishmentAdapter.notifyDataSetChanged();
                                    } else {
                                        Toast.makeText(getApplicationContext(), "No such document", Toast.LENGTH_SHORT).show();
                                    }
                                } else {
                                    Toast.makeText(getApplicationContext(), "Error getting document", Toast.LENGTH_SHORT).show();
                                }
                            });
                        }
                    }
                });
                tasks.add(task);
            }
            Tasks.whenAllComplete(tasks)
                    .addOnSuccessListener(aVoid -> {
                        Log.d(TAG, "All queries completed successfully");
                        // TODO: Add any post-query logic here
                    })
                    .addOnFailureListener(e -> {
                        Log.e(TAG, "One or more queries failed", e);
                        // TODO: Handle query failures here
                    });
        } else {
            Toast.makeText(getApplicationContext(), "Login Expired, please log in again.", Toast.LENGTH_SHORT).show();
        }
    }


//    private void loadingEstablishment() {
//        FirebaseAuth mAuth = FirebaseAuth.getInstance();
//        FirebaseUser currentUser = mAuth.getCurrentUser();
//        FirebaseFirestore firestore = FirebaseFirestore.getInstance();
//        String uid = currentUser.getUid();
//        if (uid != null) {
//            String[] collections = {"Region I - Ilocos RegionFood Spots", "Region I - Ilocos RegionBanks", "Region III - Central LuzonFood Spots"};
//            FirebaseFirestore db = FirebaseFirestore.getInstance();
//            // Use a loop to create a collection group query for each collection
//            for (String collectionn : collections) {
//                db.collectionGroup(collectionn)
//                        .whereEqualTo("AdminID", uid)
//                        .get()
//                        .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
//                            @Override
//                            public void onSuccess(QuerySnapshot querySnapshot) {
//                                for (QueryDocumentSnapshot document : querySnapshot) {
//                                    Log.d(TAG, "Found document with ID: " + document.getId());
//                                    // Access document data as needed
//                                    Map<String, Object> data = document.getData();
//                                    String region =(String) data.get("Region");
//                                    String establishmentType = (String)data.get("EstablishmentType");
//                                    String Collection = region+establishmentType;
//                                    if (region != null && establishmentType != null) {
//                                        FirebaseFirestore db = FirebaseFirestore.getInstance();
//                                        Log.d(TAG, "Collection: " + Collection);
//                                        Log.d(TAG, "EstType: " + establishmentType);
//                                        CollectionReference collectionRef = db.collection(Collection);
//                                        collectionRef.document(document.getId()).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
//                                            @Override
//                                            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
//                                                Log.d(TAG, "dbb: " + collectionRef);
//                                                if (task.isSuccessful()) {
//                                                    DocumentSnapshot document = task.getResult();
//                                                    if (document.exists()) {
//                                                        Log.d(TAG, "secon step: " + document.getId());
//                                                        String EstablishmentName = document.getString("EstablishmentName");
//                                                        String City = document.getString("City");
//                                                        user = new User(EstablishmentName, City, document.getId(), region.toString() + establishmentType.toString());
//                                                        if (!ids.contains(document.getId())) {
//                                                            ids.add(document.getId());
//                                                            userArrayList.add(user);
//                                                        }
//                                                        myAdapter.notifyDataSetChanged();
//                                                    } else {
//                                                        Toast.makeText(getApplicationContext(), "No such document", Toast.LENGTH_SHORT).show();
//                                                    }
//                                                } else {
//                                                    Toast.makeText(getApplicationContext(), "Error getting document", Toast.LENGTH_SHORT).show();
//                                                }
//                                            }
//                                        });
//                                    }
//                                }
//                            }
//                        });
//            }
//        } else {
//            Toast.makeText(getApplicationContext(), "Login Expired, please log in again.", Toast.LENGTH_SHORT).show();
//        }
//    }

    @Override
    public void onClick(View v) {
    }
}