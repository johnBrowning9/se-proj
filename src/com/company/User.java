package com.company;
import java.util.HashMap;
import java.util.Enumeration;

/**
 * This class represents a generic user. It includes fields for the user's name, id, role, and whether or not the user
 * is active according to the database. This class also keeps track of the user's permissions through the permissions
 * HashMap.
 */
public class User {
    private String role; //Role of the user. Ex: customer, database admin, traffic manager, etc.
    private String name; //user's name as listed in the database
    private int id; //user's id as listed in the database
    private boolean isActive; //user's activity as listed in the database
    private HashMap<String, Boolean> permissions; //Represents the different permissions the user has based on their role.

    //Constructor for the user class
    public User(String role, String name, int id, boolean isActive){
        permissions = new HashMap<>();
        this.role = role;

        //setting role to customer and giving correct permissions
        if(role == "customer"){
            permissions.put("reserveSign", true);
        } else {
            //no role recognized
            permissions.put("reserveSign", false);
        }

        this.name = name;
        this.id = id;
        this.isActive = isActive;
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


    //Accessors


    /**
     * Accessor for the user's id.
     * @return the user's id
     */
    public int getId() {
        return id;
    }

    /**
     * Accessor for the user's name.
     * @return the user's name
     */
    public String getName() {
        return name;
    }

    /**
     * Accessor for isActive.
     * @return true if the user is active, false otherwise
     */
    public boolean getIsActive(){
        return isActive;
    }

    /**
     * Accessor for the user's role.
     * @return the user's role
     */
    public String getRole(){
        return role;
    }
}