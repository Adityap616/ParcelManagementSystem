package travel.management.system;

import javax.swing.*;
import java.sql.*;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.Statement;

public class Conn {
    Connection c;
    Statement s;

    public Conn() {
        //5 steps of database connectivity
        //1. Register the driver
        //2. Creating connection string
        //3. Creating the statement
        //4. Executing MySQL Queries

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/signup_info", "root", "1234");
            s = c.createStatement();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error");
            e.printStackTrace();
        }
    }
}