package com.example.tsfbank.RecyclerViewAdapter;

import android.content.Context;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tsfbank.R;
import com.example.tsfbank.RecyclerViewModel.Model;

import java.util.ArrayList;


public class Adapter  extends RecyclerView.Adapter<Adapter.viewHolder>{

ArrayList<Model> list;
Context context;

    public Adapter(ArrayList<Model> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycler_item,parent,false);
        
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        Model model = list.get(position);
        holder.name.setText(model.getUser_name());
        holder.balance.setText(model.getUser_balance());
        holder.phone.setText(model.getUser_phone());
        holder.id.setText(model.getId());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder{

        TextView name,phone ,balance,id;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            phone = itemView.findViewById(R.id.phone);
            balance = itemView.findViewById(R.id.amount);
            id = itemView.findViewById(R.id.id);
        }

    }
}
