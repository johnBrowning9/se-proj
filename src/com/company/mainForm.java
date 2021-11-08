package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class mainForm extends JPanel {
    // Initialize
    private JButton button;
    private JTextField input;
    private int data;

    // Constructor
    public mainForm() {
        button = new JButton("Submit");
        add(button);
        button.addActionListener(new ButtonListener());  // Listener added for button.

        input = new JTextField();
        add(input);

    }

    private class ButtonListener implements ActionListener {

        /*
         * Inspects the numbers typed into the text fields and generates the song after the start song button is pushed.
         */
        public void actionPerformed(ActionEvent event) {

            // Retrieves the numbers typed in the text fields, converts them to an integer, and stores them in their
            // corresponding local variable.
            data = Integer.parseInt(input.getText());
            System.out.println(data);
        }
    }
}
