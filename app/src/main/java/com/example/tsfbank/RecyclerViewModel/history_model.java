package com.example.tsfbank.RecyclerViewModel;

public class history_model {
    String from_name;
    String to_name;
    String amount;
    String date;
    String status;

    public history_model(String from_name, String to_name, String amount, String date, String status) {
        this.from_name = from_name;
        this.to_name = to_name;
        this.amount = amount;
        this.date = date;
        this.status = status;
    }

    public void setFrom_name(String from_name) {
        this.from_name = from_name;
    }

    public void setTo_name(String to_name) {
        this.to_name = to_name;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getFrom_name() {
        return from_name;
    }

    public String getTo_name() {
        return to_name;
    }

    public String getAmount() {
        return amount;
    }

    public String getDate() {
        return date;
    }

    public String getStatus() {
        return status;
    }
}
