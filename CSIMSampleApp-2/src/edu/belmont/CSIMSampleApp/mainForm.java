package edu.belmont.CSIMSampleApp;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class mainForm {
    private JButton btnOK;
    private JPanel panel1;
    private JTextArea response1;

    public mainForm() {

        btnOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Connection conn = openDatabase();
                    Statement stmt = null;
                    try{
                        // Execute a query
                        stmt = conn.createStatement();
                        String sql;

                        //  SELECT STATEMENT
                        // look for the Dutchman's Curve historical marker sign
                        sql = "SELECT * FROM signs WHERE description like '%Marker%'";
                        ResultSet rs = stmt.executeQuery(sql);

                        //Extract data from result set
                        int inStock = 0;
                        int id = 0;
                        while(rs.next()){
                            //Retrieve by column name
                            id  = rs.getInt("id");
                            String signNumber = rs.getString("number");
                            String description = rs.getString("description");
                            //int catregory = rs.getInt("category");
                            String text = rs.getString("text");
                            inStock = rs.getInt("inStock");

                            //Display values
                            response1.append("Mile Markers\n");
                            response1.append("id: " + id + "\n");
                            response1.append("description : " + description + "\n");
                            response1.append("Content: " + text +"\n");
                            response1.append("There are " + inStock + " signs in stock.\n");
                        }

                        // UPDATE STATEMENT
                        inStock += 10;
                        sql = "UPDATE signs SET inStock=" + inStock + " WHERE id=" + id + ";";
                        stmt.executeUpdate(sql);

                        // TEST UPDATE
                        sql = "SELECT * FROM signs WHERE description like '%Marker%'";
                        rs = stmt.executeQuery(sql);

                        //Extract data from result set (again)
                        while(rs.next()){
                            //Retrieve by column name
                            int inStock2 = rs.getInt("inStock");
                            response1.append("There are NOW " + inStock2 + " signs in stock.\n");
                        }

                        // INSERT STATEMENT
                        sql = "INSERT INTO customers (name, isActive) VALUES ('Bill Lee', 1);";
                        if (stmt.executeUpdate(sql) > 0) {
                            response1.append("Bill Lee inserted.\n");
                        }
                        else {
                            response1.append("Cannot Insert more than once.");
                        }

                        // DELETE STATEMENT
                        sql = "DELETE FROM customers WHERE name='Bill Lee';";
                        if (stmt.executeUpdate(sql) > 0) {
                            response1.append("DELETE Successfull!\n");
                        }
                        else {
                            response1.append("Uh-oh...DELETE not successful.");
                        }

                        // USING JOINS TO COMBINE TABLE DATA
                        sql="SELECT reservations.ID, customers.name AS custname, signs.description AS descr, " +
                                "amount, requestedOn FROM reservations " +
                            "INNER JOIN customers ON customers.id = reservations.customer " +
                            "INNER JOIN signs ON signs.id = reservations.sign " +
                            "WHERE requestedOn BETWEEN '2021-01-01' AND '2021-11-30'";

                        rs = stmt.executeQuery(sql);

                        //Extract data from result set (yet again)
                        while(rs.next()){
                            //Retrieve by column name
                            response1.append("\n\nCustomer\tSign\tAmount\tRequest Date\n\n");
                            response1.append(rs.getString("custname") + "\t" +
                                             rs.getString("descr") + "\t" +
                                             rs.getDouble("amount") + "\t" +
                                             rs.getDate("requestedOn"));
                        }

                        // Clean-up
                        rs.close();
                        stmt.close();

                    }
                    catch(SQLException se)
                    {
                        //Handle errors for JDBC
                        se.printStackTrace();
                    }
                    catch(Exception exc)
                    {
                        //Handle errors for Class.forName
                        exc.printStackTrace();
                    }
                    finally
                    {
                        // do any last stuff
                        conn.close();
                    }

                }
                catch (Exception exc) {
                    JOptionPane.showMessageDialog(null,"Error loading data: " + exc.getMessage(),"ERROR!", 1);
                }
            }
        });


    }

    private Connection openDatabase( ) {
        try {
            String myDriver = "org.gjt.mm.mysql.Driver";
            // Team 1 use this URL
            //String myUrl = "jdbc:mysql://opalsw.com:3306/opalswco_csim1";
            //String passWord = "CSC4610#";
            //String userName = "opalswco_csimu1";

            // Team 2 use this URL
            String myUrl = "jdbc:mysql://opalsw.com:3306/opalswco_csim2";
            String passWord = "csc4610#2021";
            String userName = "opalswco_csimu2";

            Class.forName(myDriver);
            Connection conn = DriverManager.getConnection(myUrl, userName, passWord);

            return conn;
        }
        catch (Exception ex) {
            JOptionPane.showMessageDialog(null,"Error opening DB: " + ex.getMessage(),"ERROR!", 1);
            return null;
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("City Sign Inventory Management");
        frame.setContentPane(new mainForm().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

}
