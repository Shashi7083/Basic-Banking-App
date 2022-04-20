package com.example.tsfbank.RecyclerViewAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tsfbank.R;
import com.example.tsfbank.RecyclerViewModel.Model;
import com.example.tsfbank.RecyclerViewModel.history_model;

import java.util.ArrayList;

public class historyAdapter extends  RecyclerView.Adapter<historyAdapter.viewHolder>{

    ArrayList<history_model> list ;
    Context context;

    public historyAdapter(ArrayList<history_model> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.history_item,parent,false);

        return new historyAdapter.viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {

        history_model model = list.get(position);

        holder.from_name.setText(model.getFrom_name());
        holder.to_name.setText(model.getTo_name());
        holder.amount.setText(model.getAmount());
        holder.date.setText(model.getDate());
        holder.status.setText(model.getStatus());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder{
      TextView from_name,to_name,amount, date,status;

        public viewHolder(@NonNull View itemView) {
            super(itemView);

            from_name = itemView.findViewById(R.id.from_name);
            to_name = itemView.findViewById(R.id.to_name);
            amount = itemView.findViewById(R.id.transfer_balance);
            date = itemView.findViewById(R.id.Date_and_time);
            status = itemView.findViewById(R.id.status);

        }
    }
}
