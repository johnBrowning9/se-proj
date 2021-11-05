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
}
