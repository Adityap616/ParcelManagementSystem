package travel.management.system;

import javax.swing.*;
import java.awt.*;

public class TrackOrder extends JFrame {
    String username;
    TrackOrder(String username){
        this.username = username;
        setBounds(400,110,900,600);
        getContentPane().setBackground(Color.CYAN);
        setTitle("Track Orders");
        setLayout(null);

        setVisible(true);
    }

    public static void main(String[] args) {
        new TrackOrder("");
    }
}
