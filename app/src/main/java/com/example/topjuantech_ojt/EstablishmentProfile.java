package com.example.topjuantech_ojt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.SetOptions;

import java.util.HashMap;
import java.util.Map;

public class EstablishmentProfile extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private FirebaseFirestore mFirestore;
    private EditText establishmentName, typeOfEstablishment, contact,
                    region, province, barangay, longitude, latitude;
    private Button edit;
    private boolean isEditable = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_establishment_profile);
        mAuth= FirebaseAuth.getInstance();
        mFirestore = FirebaseFirestore.getInstance();
        establishmentName= findViewById(R.id.editEstName);
        typeOfEstablishment= findViewById(R.id.editEstType);
        contact= findViewById(R.id.editEstContact);
        region= findViewById(R.id.editEstRegion);
        province= findViewById(R.id.editEstCity);
        barangay= findViewById(R.id.editEstBrgy);
        longitude= findViewById(R.id.editEstLong);
        latitude= findViewById(R.id.editEstLat);
        edit=findViewById(R.id.est_edit_btn);
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isEditable) {
                    // Make the EditText fields editable
                    contact.setEnabled(true);
                    region.setEnabled(true);
                    province.setEnabled(true);
                    barangay.setEnabled(true);
                    longitude.setEnabled(true);
                    latitude.setEnabled(true);
                    // Change the button text to "Save"
                    edit.setText("Save");
                    // Set isEditable to true
                    isEditable = true;
                } else {
                    // Make the EditText fields non-editable
                    contact.setEnabled(false);
                    region.setEnabled(false);
                    province.setEnabled(false);
                    barangay.setEnabled(false);
                    longitude.setEnabled(false);
                    latitude.setEnabled(false);
                    // Change the button text back to "Edit"
                    edit.setText("Edit Profile");
                    // Save the updated profile data
                    saveProfileData();
                    // Set isEditable to false
                    isEditable = false;
                }
            }
        });

    }
    private void saveProfileData() {
        FirebaseUser currentUser = mAuth.getCurrentUser();

        if (currentUser != null) {
            String uid = currentUser.getUid();

            Map<String, Object> profileData = new HashMap<>();
            profileData.put("Contact", contact.getText().toString());
            profileData.put("Region", region.getText().toString());
            profileData.put("City", province.getText().toString());
            profileData.put("Barangay", barangay.getText().toString());
            profileData.put("Longitude", longitude.getText().toString());
            profileData.put("Latitude", latitude.getText().toString());

            DocumentReference userRef = mFirestore.collection("Users").document(uid);
            userRef.set(profileData, SetOptions.merge())
                    .addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {
                            // Profile data saved successfully
                        }
                    });
        }
    }
}