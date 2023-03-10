package com.example.topjuantech_ojt;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class UserInfoFragment extends Fragment {

    TextView establishmentInfo;
    FirebaseFirestore db;
    private ActivityCallback callback;
    String _adminID = "", _establishmentType = "";

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        callback = (ActivityCallback) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.user_information_fragment,container,false);
        db = FirebaseFirestore.getInstance();
        establishmentInfo = root.findViewById(R.id.establishmentInfo);
        _adminID = callback.getAdminID();
        _establishmentType = callback.getEstablishmentType();
        DocumentReference uidRef = db.collection("Region I - Ilocos RegionFood Spots").document("FTfQQBH6J3I3pknrtVk1");
        uidRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()) {
                        establishmentInfo.setText(document.getString("Information"));
                    }
                }
            }
        });

        return root;
    }
}
