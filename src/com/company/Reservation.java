package com.company;

import java.util.ArrayList;

public class Reservation {
    private int ID, custID, signID, statusID, amount;
    private String requestedOn, lastActivity;

    /**
     * @param ID reservation ID number for database access
     * @param custID customer ID number
     * @param signID sign ID number
     * @param statusID status ID number
     * @param amount quantity of signs being reserved
     * @param requestedOn the date when the reservation was submitted
     * @param lastActivity date of the client's last reservation
     */
    public Reservation(int ID, int custID, int signID, int statusID, int amount, String requestedOn, String lastActivity){
        this.ID = ID;
        //this.custID = custID;   //if we make a Customer class, this will be something like Customer.getID()
        //this.signID = signID;   //Sign.getID() ?
        //this.statusID = statusID;
        this.amount = amount;
        this.requestedOn = requestedOn;
        this.lastActivity = lastActivity;
    }
}