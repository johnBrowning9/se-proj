package com.company;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;

public class DataBase {
    Connection conn;
    Statement stmt;
    String sql;     //holds the SQL instruction
    ArrayList<String> array;

    public DataBase() throws SQLException {
        conn = openDatabase();
        stmt = null;
        sql = null;
        stmt = conn.createStatement(); //creates Statement object to execute SQL methods
        array = null;
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
     * @param table
     */
    private void select(String table, String column) throws SQLException {
        if(column.contains("all")) {
            sql = "SELECT * FROM " + table;
            ResultSet rs = stmt.executeQuery(sql);
        }
        else {
            sql = "SELECT " + column + " FROM " + table;
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                array.add(rs.getString(column));
            }
        }
        for (String x: array) {
            System.out.println(x);
        }
    }

    /**
     * Deletes data from database.
     * @param table
     * @param column
     * @param condition
     */
    private void delete(String table, String column, String condition) {
        sql = "DELETE FROM " + table + " WHERE " + column + "= '" + condition + "'";
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
        //base.select("signs", "description");
    }

}