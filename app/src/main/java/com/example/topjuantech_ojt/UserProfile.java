package com.example.topjuantech_ojt;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class UserProfile extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private FirebaseFirestore mFirestore;

    private ImageView mProfilePicture;
    private EditText firstname, lastname, phoneNumber,
            email, status;

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

        // Load the user's profile data
        loadProfileData();
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

                                // Set the profile data in the layout
                                firstname.setText(firstName);
                                lastname.setText(lastName);
                                email.setText(Email);
                                status.setText(Status);
                                phoneNumber.setText(phoneNumberr);
                            }
                        }
                    });
        }
    }
}

//
//import static android.content.ContentValues.TAG;
//
//import androidx.annotation.NonNull;
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.app.ProgressDialog;
//import android.os.Bundle;
//import android.util.Log;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.widget.EditText;
//import android.widget.Toast;
//
//import com.google.android.gms.tasks.OnCompleteListener;
//import com.google.android.gms.tasks.OnFailureListener;
//import com.google.android.gms.tasks.OnSuccessListener;
//import com.google.android.gms.tasks.Task;
//import com.google.firebase.auth.FirebaseAuth;
//import com.google.firebase.auth.FirebaseUser;
//import com.google.firebase.database.FirebaseDatabase;
//import com.google.firebase.firestore.DocumentReference;
//import com.google.firebase.firestore.DocumentSnapshot;
//import com.google.firebase.firestore.FieldPath;
//import com.google.firebase.firestore.FirebaseFirestore;
//import com.google.firebase.firestore.QueryDocumentSnapshot;
//import com.google.firebase.firestore.QuerySnapshot;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//
//public class UserProfile extends NavigationDrawer implements View.OnClickListener {
//    private EditText firstname, lastname, phoneNumber,
//            email, status;
//    FirebaseAuth mAuth;
//    FirebaseUser mUser;
//    FirebaseDatabase db = FirebaseDatabase.getInstance();
//    ProgressDialog progressDialog;
//    FirebaseFirestore fStore;
//    ProfileAdapter profileAdapter;
//    ArrayList<UserDetails> mUserList;
//    List<String> ids;
//    UserDetails userDetails;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//        LayoutInflater inflater = LayoutInflater.from(this);
//        View v = inflater.inflate(R.layout.activity_user_profile, null, false);
//        drawer.addView(v, 0);
//
//        fStore = FirebaseFirestore.getInstance();
//        mUserList = new ArrayList<UserDetails>();
//        ids = new ArrayList<String>();
//        profileAdapter = new ProfileAdapter(getApplicationContext(), mUserList);
//        profileAdapter = new ProfileAdapter(UserProfile.this, mUserList);
//        userDetails = new UserDetails();
//        PerformFetching();
//    }
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