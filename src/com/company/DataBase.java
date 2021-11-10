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

    /**
     * Retrieves data from database
     */
    private void select() throws SQLException {
        //ResultSet rs = stmt.executeQuery("Select signs from id"); //Retrieve data
        //System.out.println(rs);
        //sql = "SELECT * FROM signs WHERE description like '%Marker%'";
        sql = "SELECT * FROM signs";
        ResultSet rs = stmt.executeQuery(sql);
        System.out.print(rs);
    }

    /**
     * Retrieves data from database
     * @param desc
     */
    private void select(String desc) throws SQLException {
        //ResultSet rs = stmt.executeQuery("Select signs from id"); //Retrieve data
        //System.out.println(rs);
        sql = "SELECT * FROM signs WHERE description like " + desc;
        ResultSet rs = stmt.executeQuery(sql);
        System.out.print(rs);

        //Extract data from result set (FIX THIS)
        /*int inStock = 0;
        int id = 0;
        while(rs.next()){
            //Retrieve by column name
            id  = rs.getInt("id");
            String signNumber = rs.getString("number");
            String description = rs.getString("description");
            //int catregory = rs.getInt("category");
            String text = rs.getString("text");
            inStock = rs.getInt("inStock");*/
    }

    private void delete(String tableName,String id ) {
        sql = String.format("DELETE FROM % WHERE id='id'", tableName); // this is how you can insert variables into the sql calls.
        // the variable tableName goes in place of the %
        // I am not sure what our table names are or what properties
        // we have to work with but this is how we will be accessing the database.
        // we will need to figure out a way to plug in what variables we want into these sql strings. "id" variable is currently
        // not being passed in, in this state. Maybe simple string concatenation will work best instead of String.format
    }

    private void getInventory() throws SQLException {
        sql = "SELECT * FROM signs"; // select all from signs table.
        ResultSet rs = stmt.executeQuery("SELECT * FROM signs");
        System.out.println(" ");
        System.out.println("id  number  description");

        while (rs.next()) {
            int id = rs.getInt("id");
            String number = rs.getString("number");
            String description = rs.getString("description");
            System.out.println(id+"   "+number+"    "+description);
        }
    }

    public static void main(String[] args) throws SQLException {
        DataBase base = new DataBase();
        //base.select();
        base.getInventory();
    }

}