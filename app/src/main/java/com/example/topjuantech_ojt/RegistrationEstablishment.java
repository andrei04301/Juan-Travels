package com.example.topjuantech_ojt;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;

public class RegistrationEstablishment extends AppCompatActivity {
    private EditText estName, estType, estContact;
    private Button btnRegisterEst;
    public String chosenCity, chosenRegion, barangay, longi, lat;
    private TextView txtRegion, txtCity, txtBarangay, txtLong, txtLat;
    public Spinner spinCity, spinRegion;
    public ArrayAdapter<CharSequence> adapterCity, adapterRegion;
    private String establishment, type, contact;
    FirebaseAuth mAuth;
    FirebaseUser mUser;
    FirebaseDatabase db = FirebaseDatabase.getInstance();
    ProgressDialog progressDialog;
    FirebaseFirestore fStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_establishment);

        Button btnRegisterEst = (Button) findViewById(R.id.btnRegisterEst);
        progressDialog = new ProgressDialog(this);
        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();
        fStore = FirebaseFirestore.getInstance();

        estName = (EditText) findViewById(R.id.editNameEst);
        estType = (EditText) findViewById(R.id.editTypeEst);
        estContact = (EditText) findViewById(R.id.editContactNumber);
        txtRegion = (TextView) findViewById(R.id.txt_region);
        txtCity = (TextView) findViewById(R.id.txt_district);
        txtBarangay = (EditText) findViewById(R.id.editBarangay);
        txtLong = (EditText) findViewById(R.id.editLocationLong);
        txtLat = (EditText) findViewById(R.id.editLocationLat);

        spinRegion = findViewById(R.id.region);
        adapterRegion = ArrayAdapter.createFromResource(this, R.array.arr_region, R.layout.spin);
        adapterRegion.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinRegion.setAdapter(adapterRegion);
        spinRegion.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                spinCity = findViewById(R.id.city_district);
                chosenRegion = spinRegion.getSelectedItem().toString();
                int parentID = parent.getId();
                if (parentID == R.id.region) {
                    switch (chosenRegion) {
                        case "Select Your Region":
                            adapterCity = ArrayAdapter.createFromResource(parent.getContext(),
                                    R.array.arr_def_region, R.layout.spin);
                            break;
                        case "Region I - Ilocos Region":
                            adapterCity = ArrayAdapter.createFromResource(parent.getContext(),
                                    R.array.arr_region1_city, R.layout.spin);
                            break;
                        case "Region II - Cagayan Valley":
                            adapterCity = ArrayAdapter.createFromResource(parent.getContext(),
                                    R.array.arr_region2_city, R.layout.spin);
                            break;
                        case "Region III - Central Luzon":
                            adapterCity = ArrayAdapter.createFromResource(parent.getContext(),
                                    R.array.arr_region3_city, R.layout.spin);
                            break;
                        case "Region IVA - CALABARZON":
                            adapterCity = ArrayAdapter.createFromResource(parent.getContext(),
                                    R.array.arr_region4A_city, R.layout.spin);
                            break;
                        case "NCR - National Capital Region":
                            adapterCity = ArrayAdapter.createFromResource(parent.getContext(),
                                    R.array.arr_NCR_city, R.layout.spin);
                            break;
                        case "CAR - Cordillera Administrative Region":
                            adapterCity = ArrayAdapter.createFromResource(parent.getContext(),
                                    R.array.arr_CAR_city, R.layout.spin);
                            break;
                        case "MIMAROPA Region":
                            adapterCity = ArrayAdapter.createFromResource(parent.getContext(),
                                    R.array.arr_MIMAROPA_city, R.layout.spin);
                            break;
                        case "Region V - Bicol Region":
                            adapterCity = ArrayAdapter.createFromResource(parent.getContext(),
                                    R.array.arr_region5_city, R.layout.spin);
                            break;
                        case "Region VI - Western Visayas":
                            adapterCity = ArrayAdapter.createFromResource(parent.getContext(),
                                    R.array.arr_region6_city, R.layout.spin);
                            break;
                        case "Region VII - Central Visayas":
                            adapterCity = ArrayAdapter.createFromResource(parent.getContext(),
                                    R.array.arr_region7_city, R.layout.spin);
                            break;
                        case "Region VIII - Eastern Visayas":
                            adapterCity = ArrayAdapter.createFromResource(parent.getContext(),
                                    R.array.arr_region8_city, R.layout.spin);
                            break;
                        case "Region IX - Zamboanga Peninsula":
                            adapterCity = ArrayAdapter.createFromResource(parent.getContext(),
                                    R.array.arr_region9_city, R.layout.spin);
                            break;
                        case "Region X - Northern Mindanao":
                            adapterCity = ArrayAdapter.createFromResource(parent.getContext(),
                                    R.array.arr_region10_city, R.layout.spin);
                            break;
                        case "Region XI - Davao Region":
                            adapterCity = ArrayAdapter.createFromResource(parent.getContext(),
                                    R.array.arr_region11_city, R.layout.spin);
                            break;
                        case "Region XII - SOCCKSARGEN":
                            adapterCity = ArrayAdapter.createFromResource(parent.getContext(),
                                    R.array.arr_region12_city, R.layout.spin);
                            break;
                        case "Region XIII - Caraga":
                            adapterCity = ArrayAdapter.createFromResource(parent.getContext(),
                                    R.array.arr_region13_city, R.layout.spin);
                            break;
                        case "BARMM - Bangsamoro Autonomous Region in Muslim Mindanao":
                            adapterCity = ArrayAdapter.createFromResource(parent.getContext(),
                                    R.array.arr_BARRM_city, R.layout.spin);
                            break;
                        default:
                            break;
                    }
                    adapterCity.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinCity.setAdapter(adapterCity);
                    spinCity.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            chosenCity = spinCity.getSelectedItem().toString();
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {
                        }
                    });
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });



        Button submitButton;
        submitButton = findViewById(R.id.btnRegisterEst);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                establishment = estName.getText().toString();
                type = estType.getText().toString();
                contact = estContact.getText().toString();
                barangay = txtBarangay.getText().toString();
                longi = txtLong.getText().toString();
                lat = txtLat.getText().toString();
                if (establishment.isEmpty()) {
                    Toast.makeText(RegistrationEstablishment.this, "Please input your Establishment Name", Toast.LENGTH_LONG).show();
                    estName.setError("Establishment Name is required!");
                } else if (type.isEmpty()) {
                    Toast.makeText(RegistrationEstablishment.this, "Please input the type of your Establishment", Toast.LENGTH_LONG).show();
                    estType.setError("Type is required!");
                } else if (contact.isEmpty()) {
                    Toast.makeText(RegistrationEstablishment.this, "Please input your Establishment's Contact Number", Toast.LENGTH_LONG).show();
                    txtLong.setError("Contact Number is required!");
                } else if (chosenRegion.equals("Select Your Region")) {
                    Toast.makeText(RegistrationEstablishment.this, "Please select your Region from the list", Toast.LENGTH_LONG).show();
                    txtRegion.setError("Region is required");      //To set error on TextView
                } else if (chosenCity.equals("Select Your Province/City")) {
                    Toast.makeText(RegistrationEstablishment.this, "Please select your Province/City from the list", Toast.LENGTH_LONG).show();
                    txtCity.setError("Province/City is required!");
                    txtRegion.setError(null);
                } else if (barangay.isEmpty()) {
                    Toast.makeText(RegistrationEstablishment.this, "Please input the Establishment's Barangay", Toast.LENGTH_LONG).show();
                    txtBarangay.setError("Barangay is required!");
                } else if (longi.isEmpty()) {
                    Toast.makeText(RegistrationEstablishment.this, "Please input the Longitude of the Establishment", Toast.LENGTH_LONG).show();
                    txtLong.setError("Longitude is required!");
                } else if (lat.isEmpty()) {
                    Toast.makeText(RegistrationEstablishment.this, "Please input the Latitude of the Establishment", Toast.LENGTH_LONG).show();
                    txtLat.setError("Latitude is required!");
                } else {
                    FirebaseAuth mAuth = FirebaseAuth.getInstance();
                    FirebaseUser currentUser = mAuth.getCurrentUser();
                    if (currentUser != null) {
                        String uid = currentUser.getUid();
                        // Do something with the user ID
                        estName.setError(null);
                        estType.setError(null);
                        estContact.setError(null);
                        txtRegion.setError(null);
                        txtCity.setError(null);
                        txtBarangay.setError(null);
                        txtLong.setError(null);
                        txtLat.setError(null);
                        Toast.makeText(RegistrationEstablishment.this, "Selected Region: " + chosenRegion + "\nSelected Province/City: " + chosenCity, Toast.LENGTH_LONG).show();
                        progressDialog.setMessage("Please wait...");
                        progressDialog.setTitle("Saving Data");
                        progressDialog.setCanceledOnTouchOutside(false);
                        progressDialog.show();
                        FirebaseFirestore firestore = FirebaseFirestore.getInstance();
                        HashMap<String, String> userMap = new HashMap<>();
                        userMap.put("Establishment Type", type);
                        userMap.put("Establishment Name", establishment);
                        userMap.put("Contact", contact);
                        userMap.put("Region", chosenRegion);
                        userMap.put("City", chosenCity);
                        userMap.put("Barangay", barangay);
                        userMap.put("Longitude", longi);
                        userMap.put("Latitude", lat);
                        userMap.put("Admin ID", uid);
                        storeDataInFirestore(type, userMap);
//                        userMap.put("Establishment ID", documentReference.getId());
                    }
//                    DatabaseReference root = db.getReference().child("Establishments");
                }
            }

            public void storeDataInFirestore(String type, HashMap<String, String> userMap) {
                FirebaseFirestore firestore = FirebaseFirestore.getInstance();

                CollectionReference reference;
                if (type.toLowerCase().equals("amusement")) {
                    reference = firestore.collection(chosenCity + "Amusements");
                } else if (type.toLowerCase().equals("attraction")) {
                    reference = firestore.collection(chosenCity + "Attractions");
                } else if (type.toLowerCase().equals("bank")) {
                    reference = firestore.collection(chosenCity + "Banks");
                } else if (type.toLowerCase().equals("beverage")) {
                    reference = firestore.collection(chosenCity + "Beverages");
                } else if (type.toLowerCase().equals("food")) {
                    reference = firestore.collection(chosenCity + "Food Spots");
                } else if (type.toLowerCase().equals("gas")) {
                    reference = firestore.collection(chosenCity + "Gas Stations");
                } else if (type.toLowerCase().equals("government")) {
                    reference = firestore.collection(chosenCity + "Government");
                } else if (type.toLowerCase().equals("hospital")) {
                    reference = firestore.collection(chosenCity + "Hospitals");
                } else if (type.toLowerCase().equals("hotel")) {
                    reference = firestore.collection(chosenCity + "Hotels");
                } else {
                    progressDialog.dismiss();
                    Toast.makeText(RegistrationEstablishment.this, "Choose from: 1. Amusement 2. Banks " +
                            "3. Beverages 4. Food 5. Gas 6. Hospital 7. Hotels 8. Attraction 9. Government", Toast.LENGTH_SHORT).show();
                    Log.e(TAG, "Invalid establishment type: " + type);
                    return;
                }
                reference.add(userMap)
                        .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                            @Override
                            public void onSuccess(DocumentReference documentReference) {
                                progressDialog.dismiss();
                                Toast.makeText(RegistrationEstablishment.this, "Establishment data saved successfully", Toast.LENGTH_SHORT).show();
                                Log.d(TAG, "Establishment data saved with ID: " + documentReference.getId());
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                progressDialog.dismiss();
                                Toast.makeText(RegistrationEstablishment.this, "Error saving establishment data", Toast.LENGTH_SHORT).show();
                                Log.e(TAG, "Error saving establishment data: " + e.getMessage());
                            }
                        });
            }
        });

    }
    public String getChosenRegion() {
        return chosenRegion;
    }
    public String getChosenCity() {
        return chosenCity;
    }
}

//                    if (type.toLowerCase() ==  "amusement") {
//                        CollectionReference reference = firestore.collection("Amusements");
//                        reference.add(userMap)
//                                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
//                                    @Override
//                                    public void onSuccess(DocumentReference documentReference) {
//                                        progressDialog.dismiss();
//                                        Toast.makeText(RegistrationEstablishment.this, "Data Stored Successfully", Toast.LENGTH_SHORT).show();
//                                        Log.d(TAG, "DocumentSnapshot added with ID: " + documentReference.getId());
//                                    }
//                                })
//                                .addOnFailureListener(new OnFailureListener() {
//                                    @Override
//                                    public void onFailure(@NonNull Exception e) {
//                                        Toast.makeText(RegistrationEstablishment.this, "Data Storage Failed", Toast.LENGTH_SHORT).show();
//                                        Log.w(TAG, "Error adding document", e);
//                                    }
//                                });
//                    }
//                    else if (type.toLowerCase() ==  "beverage") {
//                        CollectionReference reference = firestore.collection("Beverages");
//                        reference.add(userMap)
//                                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
//                                    @Override
//                                    public void onSuccess(DocumentReference documentReference) {
//                                        progressDialog.dismiss();
//                                        Toast.makeText(RegistrationEstablishment.this, "Data Stored Successfully", Toast.LENGTH_SHORT).show();
//                                        Log.d(TAG, "DocumentSnapshot added with ID: " + documentReference.getId());
//                                    }
//                                })
//                                .addOnFailureListener(new OnFailureListener() {
//                                    @Override
//                                    public void onFailure(@NonNull Exception e) {
//                                        Toast.makeText(RegistrationEstablishment.this, "Data Storage Failed", Toast.LENGTH_SHORT).show();
//                                        Log.w(TAG, "Error adding document", e);
//                                    }
//                                });
//                    }
//                    else if (type.toLowerCase() ==  "food") {
//                        CollectionReference reference = firestore.collection("Foods");
//                        reference.add(userMap)
//                                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
//                                    @Override
//                                    public void onSuccess(DocumentReference documentReference) {
//                                        progressDialog.dismiss();
//                                        Toast.makeText(RegistrationEstablishment.this, "Data Stored Successfully", Toast.LENGTH_SHORT).show();
//                                        Log.d(TAG, "DocumentSnapshot added with ID: " + documentReference.getId());
//                                    }
//                                })
//                                .addOnFailureListener(new OnFailureListener() {
//                                    @Override
//                                    public void onFailure(@NonNull Exception e) {
//                                        Toast.makeText(RegistrationEstablishment.this, "Data Storage Failed", Toast.LENGTH_SHORT).show();
//                                        Log.w(TAG, "Error adding document", e);
//                                    }
//                                });
//                    }
//                    else if (type.toLowerCase() ==  "gas station") {
//                        CollectionReference reference = firestore.collection("Gas Stations");
//                        reference.add(userMap)
//                                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
//                                    @Override
//                                    public void onSuccess(DocumentReference documentReference) {
//                                        progressDialog.dismiss();
//                                        Toast.makeText(RegistrationEstablishment.this, "Data Stored Successfully", Toast.LENGTH_SHORT).show();
//                                        Log.d(TAG, "DocumentSnapshot added with ID: " + documentReference.getId());
//                                    }
//                                })
//                                .addOnFailureListener(new OnFailureListener() {
//                                    @Override
//                                    public void onFailure(@NonNull Exception e) {
//                                        Toast.makeText(RegistrationEstablishment.this, "Data Storage Failed", Toast.LENGTH_SHORT).show();
//                                        Log.w(TAG, "Error adding document", e);
//                                    }
//                                });
//                    }
//                    else if (type.toLowerCase() == "government") {
//                        CollectionReference reference = firestore.collection("Government");
//                        reference.add(userMap)
//                                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
//                                    @Override
//                                    public void onSuccess(DocumentReference documentReference) {
//                                        progressDialog.dismiss();
//                                        Toast.makeText(RegistrationEstablishment.this, "Data Stored Successfully", Toast.LENGTH_SHORT).show();
//                                        Log.d(TAG, "DocumentSnapshot added with ID: " + documentReference.getId());
//                                    }
//                                })
//                                .addOnFailureListener(new OnFailureListener() {
//                                    @Override
//                                    public void onFailure(@NonNull Exception e) {
//                                        Toast.makeText(RegistrationEstablishment.this, "Data Storage Failed", Toast.LENGTH_SHORT).show();
//                                        Log.w(TAG, "Error adding document", e);
//                                    }
//                                });
//                    }
//                    else if (type.toLowerCase() == "hospital") {
//                        CollectionReference reference = firestore.collection("Hospital");
//                        reference.add(userMap)
//                                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
//                                    @Override
//                                    public void onSuccess(DocumentReference documentReference) {
//                                        progressDialog.dismiss();
//                                        Toast.makeText(RegistrationEstablishment.this, "Data Stored Successfully", Toast.LENGTH_SHORT).show();
//                                        Log.d(TAG, "DocumentSnapshot added with ID: " + documentReference.getId());
//                                    }
//                                })
//                                .addOnFailureListener(new OnFailureListener() {
//                                    @Override
//                                    public void onFailure(@NonNull Exception e) {
//                                        Toast.makeText(RegistrationEstablishment.this, "Data Storage Failed", Toast.LENGTH_SHORT).show();
//                                        Log.w(TAG, "Error adding document", e);
//                                    }
//                                });
//                    }
//                    else if (type.toLowerCase() == "hotels") {
//                        CollectionReference reference = firestore.collection("Hotels");
//                        reference.add(userMap)
//                                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
//                                    @Override
//                                    public void onSuccess(DocumentReference documentReference) {
//                                        progressDialog.dismiss();
//                                        Toast.makeText(RegistrationEstablishment.this, "Data Stored Successfully", Toast.LENGTH_SHORT).show();
//                                        Log.d(TAG, "DocumentSnapshot added with ID: " + documentReference.getId());
//                                    }
//                                })
//                                .addOnFailureListener(new OnFailureListener() {
//                                    @Override
//                                    public void onFailure(@NonNull Exception e) {
//                                        Toast.makeText(RegistrationEstablishment.this, "Data Storage Failed", Toast.LENGTH_SHORT).show();
//                                        Log.w(TAG, "Error adding document", e);
//                                    }
//                                });
//                    }
//                    else if (type.toLowerCase() == "attraction") {
//                        CollectionReference reference = firestore.collection("Attractions");
//                        reference.add(userMap)
//                                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
//                                    @Override
//                                    public void onSuccess(DocumentReference documentReference) {
//                                        progressDialog.dismiss();
//                                        Toast.makeText(RegistrationEstablishment.this, "Data Stored Successfully", Toast.LENGTH_SHORT).show();
//                                        Log.d(TAG, "DocumentSnapshot added with ID: " + documentReference.getId());
//                                    }
//                                })
//                                .addOnFailureListener(new OnFailureListener() {
//                                    @Override
//                                    public void onFailure(@NonNull Exception e) {
//                                        Toast.makeText(RegistrationEstablishment.this, "Data Storage Failed", Toast.LENGTH_SHORT).show();
//                                        Log.w(TAG, "Error adding document", e);
//                                    }
//                                });
//                    }