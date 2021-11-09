package com.company;

import javax.swing.*;
import java.sql.*;

public class DataBase {
    Connection conn;
    Statement stmt;
    String sql;     //holds the SQL instruction

    public DataBase() throws SQLException {
        conn = openDatabase();
        stmt = null;
        sql = null;
        stmt = conn.createStatement(); //creates Statement object to execute SQL methods
    }

    /**
     * Connects to the database
     */
    private Connection openDatabase( ) {
        try {
            String myDriver = "org.gjt.mm.mysql.Driver";

            String myUrl = "jdbc:mysql://opalsw.com:3306/opalswco_csim2";
            String passWord = "csc4610#2021";
            String userName = "opalswco_csimu2";

            Class.forName(myDriver);
            Connection conn = DriverManager.getConnection(myUrl, userName, passWord);

            System.out.println("Connection established......");

            return conn;
        }
        catch (Exception ex) {
            JOptionPane.showMessageDialog(null,"Error opening DB: " + ex.getMessage(),"ERROR!", 1);
            return null;
        }
    }

    private void select() {

    }

    // This stuff is just to give you an idea on how to go about writing these sql calls.

    private void delete(String tableName,String id ) {
        sql = String.format("DELETE FROM % WHERE id='id'", tableName); // this is how you can insert variables into the sql calls.
                                                                                // the variable tableName goes in place of the %
                                                                                // I am not sure what our table names are or what properties
                                                                                // we have to work with but this is how we will be accessing the database.
                                                // we will need to figure out a way to plug in what variables we want into these sql strings. "id" variable is currently
                                            // not being passed in, in this state. Maybe simple string concatenation will work best instead of String.format
    }

    private void getInventory() {
        sql = "SELECT * FROM signs"; // select all from signs table.
    }
}
