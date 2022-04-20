package com.example.tsfbank.RecyclerViewModel;

public class selectUserModel {
    String sname,sphone,samount;

    public void setSname(String sname) {
        this.sname = sname;
    }

    public void setSphone(String sphone) {
        this.sphone = sphone;
    }

    public void setSamount(String samount) {
        this.samount = samount;
    }

    public String getSname() {
        return sname;
    }

    public String getSphone() {
        return sphone;
    }

    public String getSamount() {
        return samount;
    }

    public selectUserModel(String sname, String sphone, String samount) {
        this.sname = sname;
        this.sphone = sphone;
        this.samount = samount;
    }
}
