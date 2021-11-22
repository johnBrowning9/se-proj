package com.company;

import javax.swing.*;
import java.sql.SQLException;

public class Main {

    public static DataBase dataBase;

    public static void main(String[] args) {

        // Create instance of Database
        try {
            dataBase = new DataBase();
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null,"Error creating DB: " + e.getMessage(),"ERROR!", 1);
        }
        /////////////////////////////////////

        JFrame frame = new JFrame("City Sign Inventory Management");
        //frame.setContentPane(new mainForm().panel1);
        frame.setSize(500,500);
        frame.setContentPane(new mainForm());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.pack();
        frame.setVisible(true);

        //dataBase.

    }
}
