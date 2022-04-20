package com.example.tsfbank.RecyclerViewModel;

public class Model {

    String user_name, user_phone, user_balance,id;

    public Model(String user_name, String user_phone, String user_balance,String id) {
        this.user_name = user_name;
        this.user_phone = user_phone;
        this.user_balance = user_balance;
        this.id = id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public void setUser_phone(String user_phone) {
        this.user_phone = user_phone;
    }

    public void setUser_balance(String user_balance) {
        this.user_balance = user_balance;
    }

    public String getUser_name() {
        return user_name;
    }

    public String getUser_phone() {
        return user_phone;
    }

    public String getUser_balance() {
        return user_balance;
    }
}
