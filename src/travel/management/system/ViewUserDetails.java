package travel.management.system;

import javax.swing.*;
import java.awt.*;

public class ViewUserDetails extends JFrame {
    String username;
    ViewUserDetails(String username){
        setBounds(450,100,870,625);
        getContentPane().setBackground(Color.white);
        setLayout(null);

        JLabel lusername = new JLabel("Username");


        setVisible(true);
    }
    public static void main(String[] args) {
        new ViewUserDetails(" ");
    }
}
