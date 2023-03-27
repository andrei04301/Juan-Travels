package com.example.topjuantech_ojt;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class UserFoodspot extends NavigationDrawer implements View.OnClickListener {
    private String chosenCity, chosenRegion;
    private TextView txtRegion, txtCity;
    public Spinner spinCity, spinRegion;
    public ArrayAdapter<CharSequence> adapterCity, adapterRegion;
    androidx.cardview.widget.CardView cardView;
    LinearLayout lLayout;
    Button btnProceed;
    RecyclerView recyclerView;
    MyAdapter myAdapter;
    ArrayList<User> userArrayList;
    List<String> ids;
    FirebaseFirestore db;
    User user;

    EditText search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        search = findViewById(R.id.search);
        LayoutInflater inflater = LayoutInflater.from(this);
        View v = inflater.inflate(R.layout.activity_user_foodspot, null, false);
        drawer.addView(v, 0);

        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        db = FirebaseFirestore.getInstance();
        userArrayList = new ArrayList<User>();
        ids = new ArrayList<String>();
        myAdapter = new MyAdapter(getApplicationContext(), userArrayList);
        myAdapter = new MyAdapter(UserFoodspot.this, userArrayList);
        user = new User();

        recyclerView.setAdapter(myAdapter);
//        EventChangeListener(userArrayList);
        recyclerView.setItemAnimator(null);
        lLayout=findViewById(R.id.lLayout);
        cardView=findViewById(R.id.cardView);
        btnProceed=findViewById(R.id.btnProceed);
        txtRegion = (TextView) findViewById(R.id.txt_region);
        txtCity = (TextView) findViewById(R.id.txt_district);
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
        btnProceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (chosenRegion.equals("Select Your Region")) {
                    Toast.makeText(UserFoodspot.this, "Please select your Region from the list", Toast.LENGTH_LONG).show();
                    txtRegion.setError("Region is required");      //To set error on TextView
                } else if (chosenCity.equals("Select Your Province/City")) {
                    Toast.makeText(UserFoodspot.this, "Please select your Province/City from the list", Toast.LENGTH_LONG).show();
                    txtCity.setError("Province/City is required!");
                    txtRegion.setError(null);
                }else {
                    cardView.setVisibility(v.INVISIBLE);
                    lLayout.setVisibility(v.VISIBLE);
                    db.collection(chosenRegion+"Food Spots").whereEqualTo("City", chosenCity).get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<QuerySnapshot> task) {
                            if (task.isSuccessful()) {
                                for (QueryDocumentSnapshot document : task.getResult()) {
                                    String uid = document.getId();
                                    DocumentReference uidRef = db.collection(chosenRegion+"Food Spots").document(uid);
                                    System.out.println(uid);
                                    uidRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                                        @Override
                                        public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                                            if (task.isSuccessful()) {
                                                DocumentSnapshot document = task.getResult();
                                                if (document.exists()) {
                                                    String city = document.getString("City");
                                                    String establishmentName = document.getString("EstablishmentName");
                                                    user = new User(establishmentName, city, document.getId(), chosenRegion+"Food Spots");
                                                    if (!ids.contains(document.getId())) {
                                                        ids.add(document.getId());
                                                        userArrayList.add(user);
                                                    }
                                                    myAdapter.notifyDataSetChanged();
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
                    });
                }
            }
        });
    }

    @Override
    public void onClick(View v) {

    }
}
