package com.example.topjuantech_ojt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class UserDesiredCity extends AppCompatActivity {
    public Spinner spinCity, spinRegion;
    public String chosenCity, chosenRegion, barangay, longi, lat;
    public ArrayAdapter<CharSequence> adapterCity, adapterRegion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_desired_city);

        spinRegion = findViewById(R.id.region);
        adapterRegion = ArrayAdapter.createFromResource(this, R.array.arr_region, R.layout.spin);
        adapterRegion.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinRegion.setAdapter(adapterRegion);
//        spinRegion.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                spinCity = findViewById(R.id.city_district);
//                chosenRegion = spinRegion.getSelectedItem().toString();
//                int parentID = parent.getId();
//                if (parentID == R.id.region) {
//                    switch (chosenRegion) {
//                        case "Select Your Region":
//                            adapterCity = ArrayAdapter.createFromResource(parent.getContext(),
//                                    R.array.arr_def_region, R.layout.spin);
//                            break;
//                        case "Region I - Ilocos Region":
//                            adapterCity = ArrayAdapter.createFromResource(parent.getContext(),
//                                    R.array.arr_region1_city, R.layout.spin);
//                            break;
//                        case "Region II - Cagayan Valley":
//                            adapterCity = ArrayAdapter.createFromResource(parent.getContext(),
//                                    R.array.arr_region2_city, R.layout.spin);
//                            break;
//                        case "Region III - Central Luzon":
//                            adapterCity = ArrayAdapter.createFromResource(parent.getContext(),
//                                    R.array.arr_region3_city, R.layout.spin);
//                            break;
//                        case "Region IVA - CALABARZON":
//                            adapterCity = ArrayAdapter.createFromResource(parent.getContext(),
//                                    R.array.arr_region4A_city, R.layout.spin);
//                            break;
//                        case "NCR - National Capital Region":
//                            adapterCity = ArrayAdapter.createFromResource(parent.getContext(),
//                                    R.array.arr_NCR_city, R.layout.spin);
//                            break;
//                        case "CAR - Cordillera Administrative Region":
//                            adapterCity = ArrayAdapter.createFromResource(parent.getContext(),
//                                    R.array.arr_CAR_city, R.layout.spin);
//                            break;
//                        case "MIMAROPA Region":
//                            adapterCity = ArrayAdapter.createFromResource(parent.getContext(),
//                                    R.array.arr_MIMAROPA_city, R.layout.spin);
//                            break;
//                        case "Region V - Bicol Region":
//                            adapterCity = ArrayAdapter.createFromResource(parent.getContext(),
//                                    R.array.arr_region5_city, R.layout.spin);
//                            break;
//                        case "Region VI - Western Visayas":
//                            adapterCity = ArrayAdapter.createFromResource(parent.getContext(),
//                                    R.array.arr_region6_city, R.layout.spin);
//                            break;
//                        case "Region VII - Central Visayas":
//                            adapterCity = ArrayAdapter.createFromResource(parent.getContext(),
//                                    R.array.arr_region7_city, R.layout.spin);
//                            break;
//                        case "Region VIII - Eastern Visayas":
//                            adapterCity = ArrayAdapter.createFromResource(parent.getContext(),
//                                    R.array.arr_region8_city, R.layout.spin);
//                            break;
//                        case "Region IX - Zamboanga Peninsula":
//                            adapterCity = ArrayAdapter.createFromResource(parent.getContext(),
//                                    R.array.arr_region9_city, R.layout.spin);
//                            break;
//                        case "Region X - Northern Mindanao":
//                            adapterCity = ArrayAdapter.createFromResource(parent.getContext(),
//                                    R.array.arr_region10_city, R.layout.spin);
//                            break;
//                        case "Region XI - Davao Region":
//                            adapterCity = ArrayAdapter.createFromResource(parent.getContext(),
//                                    R.array.arr_region11_city, R.layout.spin);
//                            break;
//                        case "Region XII - SOCCKSARGEN":
//                            adapterCity = ArrayAdapter.createFromResource(parent.getContext(),
//                                    R.array.arr_region12_city, R.layout.spin);
//                            break;
//                        case "Region XIII - Caraga":
//                            adapterCity = ArrayAdapter.createFromResource(parent.getContext(),
//                                    R.array.arr_region13_city, R.layout.spin);
//                            break;
//                        case "BARMM - Bangsamoro Autonomous Region in Muslim Mindanao":
//                            adapterCity = ArrayAdapter.createFromResource(parent.getContext(),
//                                    R.array.arr_BARRM_city, R.layout.spin);
//                            break;
//                        default:
//                            break;
//                    }
//                    adapterCity.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//                    spinCity.setAdapter(adapterCity);
//                    spinCity.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//                        @Override
//                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                            chosenCity = spinCity.getSelectedItem().toString();
//                        }
//
//                        @Override
//                        public void onNothingSelected(AdapterView<?> parent) {
//                        }
//                    });
//                }
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//            }
//        });
    }
}