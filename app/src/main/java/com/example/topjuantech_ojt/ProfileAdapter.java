package com.example.topjuantech_ojt;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class ProfileAdapter extends BaseAdapter {
    private Context mContext;
    private ArrayList<UserDetails> mUserList;

    public ProfileAdapter(Context context, ArrayList<UserDetails> userList) {
        mContext = context;
        mUserList = userList;
    }

    @Override
    public int getCount() {
        return mUserList.size();
    }

    @Override
    public Object getItem(int position) {
        return mUserList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        ViewHolder holder;

        if (view == null) {
            LayoutInflater inflater = LayoutInflater.from(mContext);
            view = inflater.inflate(R.layout.activity_user_profile, null);
            holder = new ViewHolder();
            holder.firstname = view.findViewById(R.id.first_name_input);
            holder.lastname = view.findViewById(R.id.last_name_input);
            holder.email = view.findViewById(R.id.email);
            holder.phoneNumber = view.findViewById(R.id.phoneNumber);
            holder.status = view.findViewById(R.id.status);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        UserDetails user = mUserList.get(position);
        holder.firstname.setText(user.getFirstname());
        holder.lastname.setText(user.getLastname());
        holder.email.setText(user.getEmail());
        holder.phoneNumber.setText(user.getPhoneNumber());
        holder.status.setText(user.getStatus());

        return view;
    }

    private static class ViewHolder {
        EditText firstname, lastname, email, phoneNumber, status;
    }
}

//package com.example.topjuantech_ojt;
//
//import android.content.Context;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.EditText;
//
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.RecyclerView;
//
//import java.util.ArrayList;
//
//public class ProfileAdapter {
//    private Context context;
//    private ArrayList<UserDetails> userProfile;
//
//    public ProfileAdapter(Context context, ArrayList<UserDetails> userProfile) {
//        this.context = context;
//        this.userProfile = userProfile;
//    }
//
//    public View getView(int position, View convertView, ViewGroup parent) {
//        LayoutInflater inflater = LayoutInflater.from(context);
//        View itemView = inflater.inflate(R.layout.activity_user_profile, parent, false);
//
//        UserDetails user = userProfile.get(position);
//
//        EditText firstName = itemView.findViewById(R.id.first_name_input);
//        EditText lastName = itemView.findViewById(R.id.last_name_input);
//        EditText email = itemView.findViewById(R.id.email);
//        EditText phoneNumber = itemView.findViewById(R.id.phoneNumber);
//        EditText status = itemView.findViewById(R.id.status);
//
//        firstName.setText(user.getFirstname());
//        lastName.setText(user.getLastname());
//        email.setText(user.getEmail());
//        phoneNumber.setText(user.getPhoneNumber());
//        status.setText(user.getStatus());
//
//        return itemView;
//    }
//
//    public int getCount() {
//        return userProfile.size();
//    }
//
//    public UserDetails getItem(int position) {
//        return userProfile.get(position);
//    }
//
//    public long getItemId(int position) {
//        return position;
//    }
//
//    public void notifyDataSetChanged() {
//    }
//}
//
////package com.example.topjuantech_ojt;
////
////import android.content.Context;
////import android.view.LayoutInflater;
////import android.view.View;
////import android.view.ViewGroup;
////import android.widget.EditText;
////import android.widget.TextView;
////
////import androidx.annotation.NonNull;
////import androidx.recyclerview.widget.RecyclerView;
////
////import java.util.ArrayList;
////
////public class ProfileAdapter extends RecyclerView.Adapter<ProfileAdapter.MyViewHolder>{
////    Context context;
////    ArrayList<UserDetails> userProfile;
////    @NonNull
////    @Override
////    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
////        View v = LayoutInflater.from(context).inflate(R.layout.activity_user_profile,parent,false);
////
////        return new ProfileAdapter.MyViewHolder(v);
////    }
////    public ProfileAdapter(Context context, ArrayList<UserDetails> userProfile) {
////        this.context = context;
////        this.userProfile = userProfile;
////    }
////
////    @Override
////    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
////        UserDetails user=userProfile.get(position);
////        holder.firstName.setText(user.getFirstname());
////        holder.lastName.setText(user.getLastname());
////        holder.phoneNumber.setText(user.getPhoneNumber());
////        holder.email.setText(user.getEmail());
////        holder.status.setText(user.getStatus());
////
////    }
////
////    @Override
////    public int getItemCount() {
////        return userProfile.size();
////    }
////
////    public class MyViewHolder extends RecyclerView.ViewHolder {
////        UserDetails userDetails;
////        EditText firstName, lastName, phoneNumber, email, status;
////        public MyViewHolder(View v) {
////            super(v);
////            firstName = v.findViewById(R.id.first_name_input);
////            lastName = v.findViewById(R.id.last_name_input);
////            email = v.findViewById(R.id.email);
////            phoneNumber = v.findViewById(R.id.phoneNumber);
////            status = v.findViewById(R.id.status);
////        }
////    }
////
////}
