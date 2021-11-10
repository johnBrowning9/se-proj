package com.company;
import java.util.HashMap;
import java.util.Enumeration;

/**
 * This class represents a generic user. It includes fields for a username and password.
 */
public class User {
    private String role; //Role of the user. Ex: customer, database admin, traffic manager, etc.
    private String userName;
    private String password;
    private HashMap<String, Boolean> permissions; //Represents the different permissions the user has based on their role.

    //Constructor for the user class
    public User(String role, String userName, String password){
        permissions = new HashMap<>();
        this.role = role;

        //setting role to customer and giving correct permissions
        if(role == "customer"){
            permissions.put("reserveSign", true);
        } else {
            //no role recognized
            permissions.put("reserveSign", false);
        }

        this.userName = userName;
        this.password = password;
    }

    /**
     * This function reserves a sign for the user if that sign is not already reserved.
     * Otherwise, it prints out a message saying that the sign is already reserved.
     * @param s The sign the user wants to reserve.
     */
    public void reserveSign(Sign s) {

        //check if the user has permission to reserve signs
        if (permissions.get("reserveSign")) {

            if (!s.isReserved()) {
                //user has permission
                s.setReserved(true);
                System.out.println("Sign Reserved!");
            } else {
                //sign is already reserved
                System.out.println("Sign is already reserved.");
            }
        } else {
            //user does not have permission to reserve signs
            System.out.println("You do not have permission to reserve this sign.");
        }
    }
}