package com.company;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        JFrame frame = new JFrame("City Sign Inventory Management");
        //frame.setContentPane(new mainForm().panel1);
        frame.setSize(500,500);
        frame.setContentPane(new mainForm());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.pack();
        frame.setVisible(true);

    }
}
