package com.example.topjuantech_ojt;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdminAdapter extends RecyclerView.Adapter<AdminAdapter.MyViewHolder> {
    Context context;
    ArrayList<Admin> userArrayList;


    public AdminAdapter(Context context, ArrayList<Admin> userArrayList) {
        this.context = context;
        this.userArrayList = userArrayList;
    }

    @NonNull
    @Override
    public AdminAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View v = LayoutInflater.from(context).inflate(R.layout.admin_menu,parent,false);

        return new AdminAdapter.MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull AdminAdapter.MyViewHolder holder, int position){
        Admin admin=userArrayList.get(position);
        holder.ProductName.setText(admin.getProductName());
        holder.ProductPrice.setText(admin.getProductPrice());
        holder.Id.setText(admin.Id);
        holder.Spot.setText(admin.Spot);

    }

    @Override
    public int getItemCount(){
        return userArrayList.size();
    }
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        User model;
        TextView ProductName, ProductPrice, Id, Spot;

        public MyViewHolder(@NonNull View itemView){
            super(itemView);
            ProductName=itemView.findViewById(R.id.estProductName);
            ProductPrice=itemView.findViewById(R.id.estProductPrice);
            Id=itemView.findViewById(R.id.estId);
            Spot=itemView.findViewById(R.id.estSpot);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(itemView.getContext(),
                            UserGovernment.class);
                    intent.putExtra("ID", Id.getText());
                    intent.putExtra("SPOT", Spot.getText());
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    itemView.getContext().startActivity(intent);
                }
            });
        }
    }
}
