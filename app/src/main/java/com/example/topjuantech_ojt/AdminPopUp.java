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

import java.util.HashMap;
import java.util.List;

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
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;
        int height = dm.heightPixels;
        getWindow().setLayout((int) (width*.7),(int)(height*.5));
        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.gravity= Gravity.CENTER;
        params.x=0;
        params.y=-20;
        getWindow().setAttributes(params);

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

        if(name.isEmpty()){
            prodName.setError("Please input the Product's Name!");
        }else if(price.isEmpty()){
            prodPrice.setError("Please input the Product's Price!");
        }else{
            FirebaseAuth mAuth = FirebaseAuth.getInstance();
            FirebaseUser currentUser = mAuth.getCurrentUser();
            FirebaseFirestore firestore = FirebaseFirestore.getInstance();
            String uid = currentUser.getUid();

            if (uid != null) {
                HashMap<String, String> userMap = new HashMap<>();
                FirebaseFirestore db = FirebaseFirestore.getInstance();
                CollectionReference establishment = firestore.collection("Region I - Ilocos Region" + "Food Spots");
                if(firestore.collection("Region I - Ilocos Region" + "Food Spots").whereEqualTo("AdminID", uid) != null){
                    progressDialog.setMessage("Please wait...");
                    progressDialog.setTitle("Adding Menu...");
                    progressDialog.setCanceledOnTouchOutside(false);
                    progressDialog.show();
                    userMap.put("Product Name", name);
                    userMap.put("Product Price", price);
                    userMap.put("Product Description", desc);
                    userMap.put("AdminID", uid);
                    userMap.put("AdminID", uid);
                    establishment.add(userMap)
                            .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                                @Override
                                public void onSuccess(DocumentReference documentReference) {
                                    progressDialog.dismiss();
                                    Toast.makeText(AdminPopUp.this, "Product data saved successfully", Toast.LENGTH_SHORT).show();
                                    Log.d(TAG, "Product data saved with ID: " + documentReference.getId());
                                }
                            })
                            .addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    progressDialog.dismiss();
                                    Toast.makeText(AdminPopUp.this, "Error saving Product data", Toast.LENGTH_SHORT).show();
                                    Log.e(TAG, "Error saving Product data: " + e.getMessage());
                                }
                            });
                }
            }

        }
    }

}
