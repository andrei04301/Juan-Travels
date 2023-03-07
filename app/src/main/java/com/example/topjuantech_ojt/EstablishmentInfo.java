package com.example.topjuantech_ojt;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class EstablishmentInfo extends AppCompatActivity implements ActivityCallback{
    Button btn_estMaps, btn_estInfo;
    View view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_establishment_fragments);
//        btn_estInfo =findViewById(R.id.btn_estInfo);
//        btn_estMaps =findViewById(R.id.btn_estMaps);
    }


    @Override
    public void onEditTextChange(String _id, String _spot) {

    }

    @Override
    public String getID() {
        return null;
    }

    @Override
    public String getSpot() {
        return null;
    }
}