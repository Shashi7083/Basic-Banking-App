

package com.example.tsfbank.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {
    public DbHelper( Context context) {
        super(context, para.DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table " + para.TABLE_NAME1 +" (ID INTEGER PRIMARY KEY AUTOINCREMENT ,NAME TEXT,BALANCE TEXT,EMAIL TEXT,ACCOUNT_NO TEXT,IFSC_CODE TEXT)");
        db.execSQL("create table " + para.TABLE_NAME2 +" (ID INTEGER PRIMARY KEY AUTOINCREMENT,DATE TEXT,FROMNAME TEXT,TONAME TEXT,AMOUNT TEXT,STATUS TEXT)");

        db.execSQL("insert into "+para.TABLE_NAME1+" values(1234567890,'Shashi Ranjan Kumar',10000.00,'TSF0001@gmail.com','XXXXXXXXXXXXXXX0','TSF0120')");
        db.execSQL("insert into "+para.TABLE_NAME1+" values(2345678901,'Gautam Kumar',10000.00,'TSF0002@gmail.com','XXXXXXXXXXXXXXX1','TSF0121')");
        db.execSQL("insert into "+para.TABLE_NAME1+" values(3456789012,'Prakash Kaushal',10000.00,'TSF0003@gmail.com','XXXXXXXXXXXXXXX2','TSF0122')");
        db.execSQL("insert into "+para.TABLE_NAME1+" values(4567890123,'Gopal Kumar',10000.00,'TSF0004@gmail.com','XXXXXXXXXXXXXXX3','TSF0123')");
        db.execSQL("insert into "+para.TABLE_NAME1+" values(5678901234,'Suraj Kr Suman',10000.00,'TSF0005@gmail.com','XXXXXXXXXXXXXXX4','TSF0124')");
        db.execSQL("insert into "+para.TABLE_NAME1+" values(6789012345,'Shivam Choudhary',10000.00,'TSF0006@gmail.com','XXXXXXXXXXXXXXX5','TSF0125')");
        db.execSQL("insert into "+para.TABLE_NAME1+" values(7890123456,'Vishal Kumar Singh',10000.00,'TSF0007@gmail.com','XXXXXXXXXXXXXXX6','TSF0126')");
        db.execSQL("insert into "+para.TABLE_NAME1+" values(8901234567,'Vicky Kumar Gupta',10000.00,'TSF0008@gmail.com','XXXXXXXXXXXXXXX7','TSF0127')");
        db.execSQL("insert into "+para.TABLE_NAME1+" values(9012345678,'Md Wamique',10000.00,'TSF0009@gmail.com','XXXXXXXXXXXXXXX8','TSF0128')");
        db.execSQL("insert into "+para.TABLE_NAME1+" values(9123456789,'Arun Kumar',10000.00,'TSF0000@gmail.com','XXXXXXXXXXXXXXX9','TSF0129')");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+para.TABLE_NAME1);
        db.execSQL("DROP TABLE IF EXISTS "+para.TABLE_NAME2);
        onCreate(db);
    }


    public boolean insertTransferData(String date,String from_name, String to_name, String amount, String status){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("DATE", date);
        contentValues.put("FROMNAME", from_name);
        contentValues.put("TONAME", to_name);
        contentValues.put("AMOUNT", amount);
        contentValues.put("STATUS", status);
        Long result = db.insert(para.TABLE_NAME2, null, contentValues);
        if(result == -1){
            return false;
        }else{
            return true;
        }
    }

    public Cursor readalldata(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from "+para.TABLE_NAME1, null);
        return cursor;
    }

    public Cursor readHistorydata(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from "+para.TABLE_NAME2, null);
        return cursor;
    }

    public Cursor readOneUser(String phonenumber){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from " +para.TABLE_NAME1+" where PHONENUMBER = " +phonenumber, null);
        return cursor;
    }

    public void updateAmount(String id, String amount){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("BALANCE",amount);

        db.update(para.TABLE_NAME1,contentValues, "ID = ? " ,new String[] {id});
    }


    public Boolean updateuserdata(String id,String balance)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("BALANCE",balance);


        Cursor cursor = db.rawQuery("Select * from "+para.TABLE_NAME1+" where ID = ?", new String[]{id});
        if (cursor.getCount() > 0) {
            long result = db.update(para.TABLE_NAME1, contentValues, "ID=?", new String[]{id});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }

    public boolean update_data(String id , String amount){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues  = new ContentValues();
        contentValues.put("BALANCE",amount);


        db.update(para.TABLE_NAME1,contentValues, "ID = ? " ,new String[] {id});
        return true;
    }
}
