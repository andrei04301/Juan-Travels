package com.example.topjuantech_ojt;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

//import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.util.ArrayList;
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    Context context;
    ArrayList<User> userArrayList;


    public MyAdapter(Context context, ArrayList<User> userArrayList) {
        this.context = context;
        this.userArrayList = userArrayList;
    }

    @NonNull
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View v = LayoutInflater.from(context).inflate(R.layout.user_establishment_list,parent,false);

        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.MyViewHolder holder, int position){
        User user=userArrayList.get(position);
        holder.Name.setText(user.getEstablishmentName());
        holder.Address.setText(user.getCity());
        holder.Id.setText(user.Id);
        holder.Spot.setText(user.Spot);

    }

    @Override
    public int getItemCount(){
        return userArrayList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        User model;
        TextView Name, Address, Id, Spot;

        public MyViewHolder(@NonNull View itemView){
            super(itemView);
            Name=itemView.findViewById(R.id.estName);
            Address=itemView.findViewById(R.id.estAddress);
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
