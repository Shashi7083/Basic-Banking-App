package com.example.tsfbank;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Toast;

import com.example.recyclerview_first.Classes.RecyclerItemClickListener;
import com.example.tsfbank.Database.DbHelper;
import com.example.tsfbank.Database.user_transfer_data;
import com.example.tsfbank.RecyclerViewAdapter.Adapter;
import com.example.tsfbank.RecyclerViewModel.Model;

import java.util.ArrayList;
import java.util.Date;

public class users extends AppCompatActivity {

    DbHelper mydb;

    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users);

        getSupportActionBar().setTitle("Users");

       mydb = new DbHelper(this);
        recyclerView = findViewById(R.id.recyclerView);

        ArrayList<Model> list = new ArrayList<>();

        Cursor res = mydb.readalldata();

       // mydb.updateAmount("1234567890","1234");

        if(res.getCount()==0){
            Toast.makeText(users.this,"failed",Toast.LENGTH_SHORT).show();
        }


        while(res.moveToNext()){
            list.add(new Model(res.getString(1),res.getString(0),res.getString(2),res.getString(0)));


        }

        Adapter adapter = new Adapter(list,this);
        recyclerView.setAdapter(adapter);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(this, recyclerView, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                user_transfer_data data = new user_transfer_data();
                switch(position){

                    case 0:
                    data.from_id = "1234567890";
                    data.from_name = "Shashi Ranjan Kumar";
                    startActivity(new Intent(users.this,user_details.class));
                    break;

                    case 1:
                        data.from_id = "2345678901";
                        data.from_name = "Gautam Kumar";
                        startActivity(new Intent(users.this,user_details.class));
                        break;

                    case 2:
                        data.from_id = "3456789012";
                        data.from_name = "Prakash Kumar";
                        startActivity(new Intent(users.this,user_details.class));
                        break;

                    case 3:
                        data.from_id = "4567890123";
                        data.from_name = "Gopal Kumar";
                        startActivity(new Intent(users.this,user_details.class));
                        break;

                    case 4:
                        data.from_id = "5678901234";
                        data.from_name = "Suraj Kr Suman";
                        startActivity(new Intent(users.this,user_details.class));
                        break;

                    case 5:
                        data.from_id = "6789012345";
                        data.from_name = "Shivam Choudhary";
                        startActivity(new Intent(users.this,user_details.class));
                        break;

                    case 6:
                        data.from_id = "7890123456";
                        data.from_name = "Vishal Kumar Singh";
                        startActivity(new Intent(users.this,user_details.class));
                        break;

                    case 7:
                        data.from_id = "8901234567";
                        data.from_name = "Vicky Kumar Gupta";
                        startActivity(new Intent(users.this,user_details.class));
                        break;

                    case 8:
                        data.from_id = "9012345678";
                        data.from_name = "Md Wamique";
                        startActivity(new Intent(users.this,user_details.class));
                        break;

                    case 9:
                        data.from_id = "9123456789";
                        data.from_name = "Arun Kumar";
                        startActivity(new Intent(users.this,user_details.class));
                        break;



                }

            }

            @Override
            public void onLongItemClick(View view, int position) {

            }
        }));


    }
}