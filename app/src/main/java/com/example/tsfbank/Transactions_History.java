package com.example.tsfbank;

import androidx.appcompat.app.AppCompatActivity;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.tsfbank.Database.DbHelper;
import com.example.tsfbank.RecyclerViewAdapter.historyAdapter;
import com.example.tsfbank.RecyclerViewModel.history_model;

import java.util.ArrayList;

public class Transactions_History extends AppCompatActivity {

    Button btnuser,btnhome;
    DbHelper mydb;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transactions_history);

        getSupportActionBar().setTitle("Transaction History");

        btnuser = findViewById(R.id.button);
        btnhome = findViewById(R.id.button2);

        btnhome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Transactions_History.this,MainActivity.class));
            }
        });

        btnuser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Transactions_History.this,users.class));
            }
        });


        mydb = new DbHelper(this);
     recyclerView = findViewById(R.id.rec);

        ArrayList<history_model> list = new ArrayList<>();

        Cursor res = mydb.readHistorydata();
        if(res.getCount()==0){
            Toast.makeText(Transactions_History.this,"failed",Toast.LENGTH_SHORT).show();
        }

        while(res.moveToNext()){

            list.add(new history_model(res.getString(2),res.getString(3),res.getString(4),res.getString(1),res.getString(5)));

        }

        historyAdapter adapter = new historyAdapter(list,this);
     recyclerView.setAdapter(adapter);

       LinearLayoutManager manager = new LinearLayoutManager(this);
       recyclerView.setLayoutManager(manager);
//        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,1);
//        recyclerView.setLayoutManager(gridLayoutManager);

    }
}