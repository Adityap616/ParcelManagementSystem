package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.URI;

public class Payment extends JFrame implements ActionListener{
    String username;
    JButton pay,back;
    Payment(String username){
        this.username = username;
        setBounds(420,100,800,600);
        setLayout(null);

        ImageIcon i1 = new ImageIcon("C:\\Users\\DELL\\OneDrive - vitap.ac.in\\Pictures\\paytm.jpeg");
        Image i2 = i1.getImage().getScaledInstance(800,600,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,800,600);
        add(image);

        pay = new JButton("Pay");
        pay.setBounds(420,0,80,40);
        pay.addActionListener(this);
        image.add(pay);

        back = new JButton("Back");
        back.setBounds(520,0,80,40);
        back.addActionListener(this);
        image.add(back);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
            if (e.getSource() == pay){
                 String link = "https://paytm.com/electricity-bill-payment";
        if (Desktop.isDesktopSupported()) {
            Desktop desktop = Desktop.getDesktop();
            if (desktop.isSupported(Desktop.Action.BROWSE)) {
                try {
                    desktop.browse(new URI(link));
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        }
            }
            else if (e.getSource() == back){
                setVisible(false);
                new Dashboard(username);
            }
    }

    public static void main(String[] args) {
        new Payment("");
    }
}
