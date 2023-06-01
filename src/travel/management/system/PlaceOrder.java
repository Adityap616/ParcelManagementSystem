package travel.management.system;

import javax.swing.*;
import java.awt.*;

public class PlaceOrder extends JFrame {
    JLabel labelusername;
    PlaceOrder(){
        setBounds(450,100,880,550);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        setVisible(true);

        JLabel username = new JLabel("Username");
        username.setBounds(30,50,150,25);
        add(username);

        labelusername = new JLabel();
        labelusername.setBounds(22,50,150,25);
        add(labelusername);




    }

    public static void main(String[] args) {
        new PlaceOrder();
    }
}
