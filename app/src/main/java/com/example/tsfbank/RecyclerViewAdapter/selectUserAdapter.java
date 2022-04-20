package com.example.tsfbank.RecyclerViewAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tsfbank.R;
import com.example.tsfbank.RecyclerViewModel.selectUserModel;

import java.util.ArrayList;

public class selectUserAdapter extends RecyclerView.Adapter<selectUserAdapter.viewHolder> {
    ArrayList<selectUserModel> list;
    Context context;

    public selectUserAdapter(ArrayList<selectUserModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public selectUserAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.select_user_item,parent,false);

        return new selectUserAdapter.viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull selectUserAdapter.viewHolder holder, int position) {
        selectUserModel model = list.get(position);
        holder.sname.setText(model.getSname());
        holder.sbalance.setText(model.getSamount());
        holder.sphone.setText(model.getSphone());


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder{

        TextView sname,sphone ,sbalance,sid;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            sname = itemView.findViewById(R.id.sname);
            sphone = itemView.findViewById(R.id.sphone);
            sbalance = itemView.findViewById(R.id.samount);

        }

    }
}
