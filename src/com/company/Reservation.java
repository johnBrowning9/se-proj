package com.company;

import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.*;

public class Reservation {
    private int ID, cust, sign, status, amount;
    private String requestedOn, lastActivity;

    /**
     * @param ID reservation ID number for database access
     * @param cust customer ID number
     * @param sign sign ID number
     * @param status status ID number
     * @param amount quantity of signs being reserved
     * @param requestedOn the date when the reservation was submitted
     * @param lastActivity date of the client's last reservation
     */
    public Reservation(int ID, int cust, int sign, int status, int amount, String requestedOn, String lastActivity){
        this.ID = ID;
        this.cust = cust;
        this.sign = sign;
        this.status = status;
        this.amount = amount;
        this.requestedOn = requestedOn;
        this.lastActivity = lastActivity;
    }

    //blank constructor- to be used with getResByID() method
    public Reservation(){}

    //this method may need to go in a separate class
    //implement similar method for each table
    public Reservation getResByID(int id, Statement s) throws SQLException {
        //check if object exists first
        final String SELECT_STMT = "SELECT id, customer, sign, status, amount, requestedOn, lastActivity FROM reservation WHERE id = ?";
        ResultSet rs = s.executeQuery(SELECT_STMT);
        if(rs.next()) {
            Reservation r = new Reservation();
            r.setID(rs.getInt("id"));
            r.setCust(rs.getInt("cust"));
            r.setSign(rs.getInt("sign"));
            r.setStatus(rs.getInt("status"));
            r.setAmount(rs.getInt("amount"));
            r.setRequested(rs.getString("requestedOn"));
            r.setLastActivity(rs.getString("lastActivity"));

            return r;
        }
        return null;
    }

    //accessors
    public int getID(){return ID;}

    public int getCust(){return cust;}

    public int getSign(){return sign;}

    public int getStatus(){return status;}

    public int getAmount(){return amount;}

    public String getRequestedOn(){return requestedOn;}

    public String getLastActivity(){return lastActivity;}

    //mutators
    public void setID(int ID){ this.ID = ID;}

    public void setCust(int cust){ this.cust = cust; }

    public void setSign(int sign){ this.sign = sign; }

    public void setStatus(int status){ this.status = status; }

    public void setAmount(int amount){ this.amount = amount; }

    public void setRequested(String request){ this.requestedOn = request; }

    public void setLastActivity(String activity){ this.lastActivity = activity; }

}
