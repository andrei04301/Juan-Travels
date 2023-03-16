package com.example.topjuantech_ojt;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.SetOptions;

import java.util.HashMap;
import java.util.Map;

public class UserProfile extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private FirebaseFirestore mFirestore;

    private ImageView mProfilePicture;
    private EditText firstname, lastname, phoneNumber,
            email, status;
    private TextView userName;
    private Button save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        mAuth = FirebaseAuth.getInstance();
        mFirestore = FirebaseFirestore.getInstance();

//        mProfilePicture = findViewById(R.id.profile_picture);
        firstname = findViewById(R.id.first_name_input);
        lastname = findViewById(R.id.last_name_input);
        email = findViewById(R.id.email);
        phoneNumber = findViewById(R.id.phoneNumber);
        status = findViewById(R.id.status);
        userName = findViewById(R.id.userEmail);
        save = findViewById(R.id.save);


        // Load the user's profile data
        loadProfileData();
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveProfileData();
                Toast.makeText(getApplicationContext(), "Profile data updated successfully", Toast.LENGTH_SHORT).show();
            }
        });
//        save.setOnClickListener(v -> saveProfileData(),
//                Toast.makeText(getApplicationContext(), "Document does not exist", Toast.LENGTH_SHORT).show();
    }

    private void loadProfileData() {
        FirebaseUser currentUser = mAuth.getCurrentUser();

        if (currentUser != null) {
            String uid = currentUser.getUid();

            mFirestore.collection("Users").document(uid)
                    .get()
                    .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                        @Override
                        public void onSuccess(DocumentSnapshot documentSnapshot) {
                            if (documentSnapshot.exists()) {
                                String firstName = documentSnapshot.getString("First Name");
                                String lastName = documentSnapshot.getString("Last Name");
                                String phoneNumberr = documentSnapshot.getString("Phone");
                                String Email = documentSnapshot.getString("Email");
                                String Status = documentSnapshot.getString("isUser");
                                String userEmail = documentSnapshot.getString("Email");

                                // Set the profile data in the layout
                                firstname.setText(firstName);
                                lastname.setText(lastName);
                                email.setText(Email);
                                status.setText(Status);
                                phoneNumber.setText(phoneNumberr);
                                userName.setText(userEmail);
                            }
                        }
                    });
        }
    }

    private void saveProfileData() {
        FirebaseUser currentUser = mAuth.getCurrentUser();

        if (currentUser != null) {
            String uid = currentUser.getUid();

            Map<String, Object> profileData = new HashMap<>();
            profileData.put("First Name", firstname.getText().toString());
            profileData.put("Last Name", lastname.getText().toString());
            profileData.put("Phone", phoneNumber.getText().toString());
            profileData.put("Email", email.getText().toString());
            profileData.put("isUser", status.getText().toString());

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

//    @Override
//    protected void onPause() {
//        super.onPause();
//        saveProfileData();
//    }
}


//    private void PerformFetching() {
//        FirebaseAuth mAuth = FirebaseAuth.getInstance();
//        FirebaseUser currentUser = mAuth.getCurrentUser();
//        FirebaseFirestore firestore = FirebaseFirestore.getInstance();
//        String uid = currentUser.getUid();
//        firestore.collection("Users")
//                .document(uid)
//                .get()
//                .addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
//                    @Override
//                    public void onComplete(@NonNull Task<DocumentSnapshot> task) {
//                        if (task.isSuccessful()) {
//                            DocumentSnapshot document = task.getResult();
//                            if (document.exists()) {
//                                String firstname = document.getString("First Name");
//                                String lastname = document.getString("Last Name");
//                                String phoneNumber = document.getString("Phone");
//                                String email = document.getString("Email");
//                                String status = document.getString("isUser");
//                                userDetails = new UserDetails(firstname, lastname, phoneNumber, email,status);
//                                mUserList.add(userDetails);
//                                profileAdapter.notifyDataSetChanged();
//                            } else {
//                                Toast.makeText(getApplicationContext(), "Document does not exist", Toast.LENGTH_SHORT).show();
//                            }
//                        } else {
//                            Toast.makeText(getApplicationContext(), "Error getting document", Toast.LENGTH_SHORT).show();
//                        }
//                    }
//                });
//    }
//    @Override
//    public void onClick(View v) {
//
//    }
//}