package com.example.topjuantech_ojt;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.DatePicker;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.Calendar;

public class UserHotelReservation extends AppCompatActivity {
    EditText editTextDate;
    DatePickerDialog.OnDateSetListener setListener;
//    TextInputLayout textInputLayoutBedAndGuest;
//    AutoCompleteTextView autoCompleteTextViewBed;
//
//    ArrayList<String> arrayList_bed;
//    ArrayList<String> arrayAdapter_bed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_hotel_reservation);

        editTextDate = findViewById(R.id.editTextDate);
//        textInputLayoutBedAndGuest=(TextInputLayout)findViewById(R.id.textInputLayoutBedAndGuest);
//        autoCompleteTextViewBed=(AutoCompleteTextView)findViewById(R.id.autoCompleteTextViewBed);
//
//        arrayList_bed = new ArrayList<>();
//        arrayList_bed.add("1 and 2");
//        arrayList_bed.add("2 and 3");
//        arrayList_bed.add("4 and 5");
//
//        arrayAdapter_bed = new ArrayAdapter<>(getApplicationContext(),R.layout.dropdown_item, arrayList_bed);
//        autoCompleteTextViewBed.setAdapter(arrayAdapter_bed);

//        autoCompleteTextViewBed.setThreshold(2);

        Calendar calendar = Calendar.getInstance();
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);

        editTextDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        UserHotelReservation.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                        month = month+1;
                        String date = day+"/"+month+"/"+year;
                        editTextDate.setText(date);
                    }
                },year,month,day);
                datePickerDialog.show();
            }
        });
    }

}