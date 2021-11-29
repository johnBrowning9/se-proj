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
    private void delete(String table, String column, String condition) throws SQLException {
        sql = "DELETE FROM " + table + " WHERE " + column + "= '" + condition + "'";
        ResultSet rs = stmt.executeQuery(sql);
    }

    /**
     * Prints signs Table
     * @throws SQLException
     */
    private void printSigns() throws SQLException {
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
    private void printCategories() throws SQLException {
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
    private void printLanguages() throws SQLException {
        sql = "SELECT * FROM languages"; // select all from languages table.
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
    private void printCustomers() throws SQLException {
        sql = "SELECT * FROM customers"; // select all from customer table.
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
    private void printReservations() throws SQLException {
        sql = "SELECT * FROM reservations"; // select all from reservation table.
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
        sql = "SELECT * FROM statuses"; // select all from statuses table.
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
        printSigns();
        printCategories();
        printLanguages();
        printCustomers();
        printReservations();
        getStatuses();
    }

    /**
     * Creates an instance of a sign in the database.
     * @param descr
     * @return returns a sign object representative of the sign in the database
     * @throws SQLException
     */
    public Sign getSign(String descr) throws SQLException {
        Sign sign = new Sign(0,0,"0","0",false,false);

        sql = "SELECT * FROM signs";
        ResultSet rs = stmt.executeQuery(sql);

        String description = "";

        while(rs.next()) {
            description = rs.getString("description");
            if(descr.contains(description)) {
                sign.setUsable(rs.getBoolean("isActive"));
                sign.setHeight(rs.getInt("length"));
                sign.setPrice(rs.getDouble("price"));
                sign.setLanguage(getLanguage(rs.getInt("language")));
                sign.setType(description);
                return sign;
            }
        }
        return null;
    }

    /**
     * Returns the language that a particular sign is in.
     * @param lang
     * @return The language consistent with the id #
     * @throws SQLException
     */
    private String getLanguage(int lang) throws SQLException {
        sql = "SELECT * FROM languages"; // select all from languages table.
        ResultSet rs = stmt.executeQuery(sql);

        String language = "";
        int id = 0;

        while (rs.next() && lang != id) {
            id = rs.getInt("id");
            if (lang == id) {
                language = rs.getString("name");
            }
        }
        return language;
    }

    /**
     * Gets a String array of the category table.
     * @return an array with the category id number and description of category
     * @throws SQLException
     */
    private String[][] getCategories() throws SQLException {
        String array[][] = new String[2][1]; //3 units long and 2 unit wide
        sql = "SELECT * FROM categories"; // select all from signs table.
        ResultSet rs = stmt.executeQuery(sql);

        while (rs.next()) {
            int j = 0;
            for (int i = 0; i <= 2; i++) {
                array[i][j] = String.valueOf(rs.getInt("id"));
                array[i][j + 1] = rs.getString("description");
                j++;
            }
        }
        return array;
    }

    public static void main(String[] args) throws SQLException {
        DataBase base = new DataBase();
        base.printAll();
        //base.select("signs", "description");
        Sign sign = new Sign(0,0,"0","0",false,false);
        sign = base.getSign("Stop Sign");
    }

}