package com.company;
import java.util.ArrayList;

public class Invoice {
    private float price;
    private Sign sign;
    private ArrayList<String> pickupDates;

    public Invoice(){
        sign = null;
        price = 0;
        pickupDates = new ArrayList<>();
    }


    // ACCESSORS

    public ArrayList<String> getPickupDates() {
        return pickupDates;
    }

    public float getPrice() {
        return price;
    }

    public Sign getSign() {
        return sign;
    }


    // MUTATORS


    public void setSign(Sign sign) {
        this.sign = sign;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setPickupDates(ArrayList<String> pickupDates) {
        this.pickupDates = pickupDates;
    }
}

// testing 123.
