package com.example.tsfbank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.tsfbank.Database.DbHelper;
import com.example.tsfbank.Database.user_transfer_data;
import com.example.tsfbank.databinding.ActivityUserDetailsBinding;

public class user_details extends AppCompatActivity {

    DbHelper mydb;
    ActivityUserDetailsBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_details);
        getSupportActionBar().setTitle("User Details");

        mydb = new DbHelper(this);

        binding = ActivityUserDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(user_details.this,users.class));
            }
        });

        binding.transfer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(user_details.this,select_user.class));
            }
        });

        Cursor res = mydb.readalldata();

        if (res.getCount() == 0) {
            Toast.makeText(user_details.this,"failed",Toast.LENGTH_SHORT).show();
            return;
        }
        while (res.moveToNext()) {

            if (res.getString(0).equals(user_transfer_data.from_id)) {
                //Toast.makeText(this,"found",Toast.LENGTH_SHORT).show();

                binding.name.setText(res.getString(1));
                binding.phone.setText(res.getString(0));
                binding.email.setText(res.getString(3));
                binding.Account.setText(res.getString(4));
                binding.ifsc.setText(res.getString(5));
                binding.balance.setText(res.getString(2));
                break;
            }
        }


              user_transfer_data data = new user_transfer_data();
         data.f_old_amount = binding.balance.getText().toString();
        }
}