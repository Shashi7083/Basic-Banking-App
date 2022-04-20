package com.example.tsfbank;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.recyclerview_first.Classes.RecyclerItemClickListener;
import com.example.tsfbank.Database.DbHelper;

import com.example.tsfbank.Database.user_transfer_data;
import com.example.tsfbank.RecyclerViewAdapter.selectUserAdapter;
import com.example.tsfbank.RecyclerViewModel.selectUserModel;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class select_user extends AppCompatActivity {

    DbHelper mydb;
    RecyclerView srecyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_user);

        getSupportActionBar().setTitle("Select User ");

        mydb = new DbHelper(this);
        srecyclerView = findViewById(R.id.srecyclerView);

        ArrayList<selectUserModel> list = new ArrayList<>();

        Cursor res = mydb.readalldata();

        if(res.getCount()==0){
            Toast.makeText(select_user.this,"failed",Toast.LENGTH_SHORT).show();
        }


        while(res.moveToNext()){
            list.add(new selectUserModel(res.getString(1),res.getString(0),res.getString(2)));


        }

        selectUserAdapter adapter = new selectUserAdapter(list,this);
        srecyclerView.setAdapter(adapter);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        srecyclerView.setLayoutManager(linearLayoutManager);

        srecyclerView.addOnItemTouchListener(new RecyclerItemClickListener(this, srecyclerView, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                user_transfer_data data = new user_transfer_data();

                switch(position) {


                        case 0:
                            data.to_name = "Shashi Ranjan Kumar";
                            data.to_id = "1234567890";
                            to_get_old_amount(data.to_id);
                            dialogBox();
                            break;

                        case 1:
                            data.to_name = "Gautam Kumar";
                            data.to_id = "2345678901";
                            to_get_old_amount(data.to_id);
                            dialogBox();
                            break;

                        case 2:
                            data.to_name = "Prakash Kumar";
                            data.to_id = "3456789012";
                            to_get_old_amount(data.to_id);
                            dialogBox();
                            break;

                        case 3:
                            data.to_name = "Gopal Kumar";

                            data.to_id = "4567890123";
                            to_get_old_amount(data.to_id);
                            dialogBox();
                            break;

                        case 4:
                            data.to_name = "Suraj Kr Suman";
                            data.to_id = "5678901234";
                            to_get_old_amount(data.to_id);
                            dialogBox();
                            break;

                        case 5:
                            data.to_name = "Shivam Choudhary";
                            data.to_id = "6789012345";
                            to_get_old_amount(data.to_id);
                            dialogBox();
                            break;

                        case 6:
                            data.to_name = "Vishal Kumar Singh";
                            data.to_id = "7890123456";
                            to_get_old_amount(data.to_id);
                            dialogBox();
                            break;

                        case 7:
                            data.to_name = "Vicky Kumar Gupta";
                            data.to_id = "8901234567";
                            to_get_old_amount(data.to_id);
                            dialogBox();
                            break;

                        case 8:
                            data.to_name = "Md Wamique";
                            data.to_id = "9012345678";
                            to_get_old_amount(data.to_id);
                            dialogBox();
                            break;

                        case 9:
                            data.to_name = "Arun Kumar";
                            data.to_id = "9123456789";
                            to_get_old_amount(data.to_id);
                            dialogBox();

                            break;


                    }

            }

            @Override
            public void onLongItemClick(View view, int position) {

            }
        }));
    }

    public void to_get_old_amount(String id){
        Cursor res = mydb.readalldata();
        user_transfer_data d = new user_transfer_data();
        while(res.moveToNext()){

            if(res.getString(0).equals(id))
            {
                //Toast.makeText(this,"found",Toast.LENGTH_SHORT).show();

                d.t_old_amount = res.getString(2);
            }

        }
    }



    public void dialogBox()
    {


        user_transfer_data data = new user_transfer_data();
        AlertDialog.Builder mydialog = new AlertDialog.Builder(select_user.this);
        mydialog.setTitle("Enter Amount");

        final EditText enter_amount = new EditText(select_user.this);
        enter_amount.setInputType(InputType.TYPE_CLASS_NUMBER);
        mydialog.setView(enter_amount);
        mydialog.setPositiveButton("Send", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                data.transfer_amount = enter_amount.getText().toString();




                Double t_old_amount = Double.parseDouble(data.t_old_amount);
                int entAmount =Integer.parseInt(data.transfer_amount);



                double enterAmount = entAmount;
                Double f_old_amount = Double.parseDouble(data.f_old_amount);

                if(enterAmount<=f_old_amount){
                 data.f_new_amount = Double.toString((f_old_amount-enterAmount));

                 data.t_new_amount = Double.toString((t_old_amount+enterAmount));

                 data.status = "Successfull";
                 data.date = dateTime();
                    Toast.makeText(select_user.this,data.f_new_amount+" "+data.t_new_amount,Toast.LENGTH_SHORT).show();


                    boolean insert=  mydb.insertTransferData(data.date,data.from_name,data.to_name,data.transfer_amount,data.status);
                if(insert==false){
                    Toast.makeText(select_user.this,"failed insert history",Toast.LENGTH_SHORT).show();
               }
                mydb.updateAmount(data.from_id,data.f_new_amount);
                mydb.updateAmount(data.to_id,data.t_new_amount);


                   startActivity(new Intent(select_user.this,Transactions_History.class));

                }
                else if(enterAmount>f_old_amount){
                    data.status = "failed";
                    data.date= dateTime();
                    Toast.makeText(select_user.this,"Insufficient Balance",Toast.LENGTH_SHORT).show();
                    dialog.cancel();
                    boolean in =  mydb.insertTransferData(data.date,data.from_name,data.to_name,data.transfer_amount,data.status);
                    if(in==false){
                        Toast.makeText(select_user.this,"failed insert history",Toast.LENGTH_SHORT).show();
                    }

                }
                else{
                    data.status = "failed";
                    data.date = dateTime();
                    Toast.makeText(select_user.this,"Invalid",Toast.LENGTH_SHORT).show();
                    dialog.cancel();
                    boolean in =  mydb.insertTransferData(data.date,data.from_name,data.to_name,data.transfer_amount,data.status);
                    if(in==false){
                        Toast.makeText(select_user.this,"failed insert history",Toast.LENGTH_SHORT).show();
                    }
                }



            }
      });
        mydialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(select_user.this,"cancel",Toast.LENGTH_SHORT).show();
                dialog.cancel();
                data.status = "failed";
                data.date = dateTime();
                data.transfer_amount = enter_amount.getText().toString();
                boolean in =  mydb.insertTransferData(data.date,data.from_name,data.to_name,data.transfer_amount,data.status);
                if(in==false){
                    Toast.makeText(select_user.this,"failed insert history",Toast.LENGTH_SHORT).show();
                }
                startActivity(new Intent(select_user.this,Transactions_History.class));
            }
        });
        mydialog.show();
    }

    public String dateTime(){
        String strDate;
        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("dd/mm/yyy hh:mm");
        strDate = dateFormat.format(date);
        return strDate;
    }


}