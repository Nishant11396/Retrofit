package com.example.retrofit_practice;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Myadapter extends RecyclerView.Adapter<Myadapter.MYviewholder> {

    List<Model> arr;
    Context context;

    public Myadapter(List<Model> demo, Context ctx) {

        this.arr = demo;
        this.context = ctx;
    }


    @NonNull
    @Override
    public MYviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view =inflater.inflate(R.layout.apiwithlayout,parent,false);
        return new MYviewholder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull MYviewholder holder, int position) {
        holder.name.setText(arr.get(position).getName());
        holder.email.setText(arr.get(position).getEmail());
//        holder.order.setText(arr.get(position).getId());


    }

    @Override
    public int getItemCount() {
        return arr.size();
    }

    public class MYviewholder extends RecyclerView.ViewHolder {
        ImageView img;

        TextView name, email;
        Button order;


        public MYviewholder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.textView1);
            email = itemView.findViewById(R.id.textView2);
            order = itemView.findViewById(R.id.button);
            img = itemView.findViewById(R.id.Image);
        }
    }
}
