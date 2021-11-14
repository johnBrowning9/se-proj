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
    private Connection openDatabase() {
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
     * @param desc
     */
    private void select(String desc) throws SQLException {
        sql = "SELECT * FROM signs WHERE description like " + desc;
        ResultSet rs = stmt.executeQuery(sql);
        System.out.print(rs);
    }

    private void delete(String tableName,String id ) {
        sql = String.format("DELETE FROM % WHERE id='id'", tableName); // this is how you can insert variables into the sql calls.
        // the variable tableName goes in place of the %
        // I am not sure what our table names are or what properties
        // we have to work with but this is how we will be accessing the database.
        // we will need to figure out a way to plug in what variables we want into these sql strings. "id" variable is currently
        // not being passed in, in this state. Maybe simple string concatenation will work best instead of String.format
    }

    /**
     * Prints signs Table
     * @throws SQLException
     */
    private void getSigns() throws SQLException {
        sql = "SELECT * FROM signs"; // select all from signs table.
        ResultSet rs = stmt.executeQuery(sql);
        System.out.println(" ");
        System.out.println("id  number  description  category length width text language inStock price isActive");

        while (rs.next()) {
            int id = rs.getInt("id");
            String number = rs.getString("number");
            String description = rs.getString("description");
            int category = rs.getInt("category");
            int length = rs.getInt("length");
            int width = rs.getInt("width");
            String text = rs.getString("text");
            int language = rs.getInt("language");
            int inStock = rs.getInt("inStock");
            double price = rs.getDouble("price");
            boolean isActive = rs.getBoolean("isActive");
            System.out.println(id+"   "+number+"    "+description+"    "+category+"    "+length+"   "+width+"    "+text+"    "+language+"    "+inStock+"    "+price+"    "+isActive);
        }
    }

    /**
     * Prints categories table
     * @throws SQLException
     */
    private void getCategories() throws SQLException {
        sql = "SELECT * FROM categories"; // select all from signs table.
        ResultSet rs = stmt.executeQuery(sql);
        System.out.println(" ");
        System.out.println("id description");

        while (rs.next()) {
            int id = rs.getInt("id");
            String description = rs.getString("description");
            System.out.println(id+"   "+description);
        }
    }

    /**
     * print languages table
     * @throws SQLException
     */
    private void getLanguages() throws SQLException {
        sql = "SELECT * FROM languages"; // select all from signs table.
        ResultSet rs = stmt.executeQuery(sql);
        System.out.println(" ");
        System.out.println("id  name");

        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            System.out.println(id + "   " +name);
        }
    }

    /**
     * prints customers Table
     * @throws SQLException
     */
    private void getCustomers() throws SQLException {
        sql = "SELECT * FROM customers"; // select all from signs table.
        ResultSet rs = stmt.executeQuery(sql);
        System.out.println(" ");
        System.out.println("id  name  isActive");

        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            boolean isActive = rs.getBoolean("isActive");
            System.out.println(id+"   "+name+"    "+isActive);
        }
    }

    /**
     * prints reservations Table
     * @throws SQLException
     */
    private void getReservations() throws SQLException {
        sql = "SELECT * FROM reservations"; // select all from signs table.
        ResultSet rs = stmt.executeQuery(sql);
        System.out.println(" ");
        System.out.println("id  customer   sign   amount  requestedOn status  lastActivity");

        while (rs.next()) {
            int id = rs.getInt("id");
            int customer = rs.getInt("customer");
            int sign = rs.getInt("sign");
            int amount = rs.getInt("amount");
            Date requestedOn = rs.getDate("requestedOn");
            int status = rs.getInt("status");
            Date lastActivity = rs.getDate("lastActivity");
            System.out.println(id + "   " + customer + "    " + sign + "    " + amount + "    " + requestedOn + "   " + status + "    " + lastActivity);
        }
    }

    /**
     * prints statuses Table
     * @throws SQLException
     */
    private void getStatuses() throws SQLException {
        sql = "SELECT * FROM statuses"; // select all from signs table.
        ResultSet rs = stmt.executeQuery(sql);
        System.out.println(" ");
        System.out.println("id  name");

        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            System.out.println(id + "   " + name);
        }
    }

    /**
     * prints all tables
     * @throws SQLException
     */
    private void printAll() throws SQLException {
        getSigns();
        getCategories();
        getLanguages();
        getCustomers();
        getReservations();
        getStatuses();
    }

    public static void main(String[] args) throws SQLException {
        DataBase base = new DataBase();
        base.printAll();
    }

}