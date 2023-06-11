package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class About extends JFrame implements ActionListener {

    String username;
    About(String username){
        setBounds(420,100,800,600);
        setLayout(null);

        JLabel text = new JLabel("ABOUT US");
        text.setBounds(300,10,400,30);
        text.setFont(new Font("Tahoma",Font.PLAIN,30));
        add(text);

        String s = "                                    About Projects          \n  "
                + "\nThe objective of the Travel and Tourism Management System"
                + "project is to develop a system that automates the processes "
                + "and activities of a travel and the purpose is to design a "
                + "system using which one can perform all operations related to "
                + "traveling.\n\n"
                + "This application will help in accessing the information related "
                + "to the travel to the particular destination with great ease. "
                + "The users can track the information related to their tours with "
                + "great ease through this application. The travel agency information "
                + "can also be obtained through this application.\n\n"
                + "Advantages of Project:"
                + "\nGives accurate information"
                + "\nSimplifies the manual work"
                + "\nIt minimizes the documentation related work"
                + "\nProvides up to date information"
                + "\nFriendly Environment by providing warning messages."
                + "\ntravelers details can be provided"
                + "\nbooking confirmation notification"
                ;
        JTextArea t1 = new JTextArea(s);
        t1.setBounds(120, 100, 550, 400);
        t1.setFont(new Font("RALEWAY", Font.BOLD, 16));
        t1.setEditable(false);
        add(t1);


        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {


    }

    public static void main(String[] args) {
        new About("");
    }
}
