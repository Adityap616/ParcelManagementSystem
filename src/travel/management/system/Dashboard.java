package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dashboard extends JFrame implements ActionListener {
    String username;
    JButton addDetails,viewDetails;
    Dashboard(String username){
        this.username = username;
//        setBounds(0,0,1600,1000);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(null);
        getContentPane().setBackground(Color.ORANGE);

        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBackground(new Color(0,0,102));
        p1.setBounds(0,0,1600,65);
        add(p1);

        ImageIcon i1 = new ImageIcon("C:\\Users\\DELL\\OneDrive - vitap.ac.in\\Pictures\\dashboard1.png");
        Image i2 = i1.getImage().getScaledInstance(70,70,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(5,0,70,70);
        p1.add(image);

        JLabel heading = new JLabel("Dashboard");
        heading.setBounds(80,10,300,40);
        heading.setFont(new Font("Tahoma",Font.BOLD,30));
        heading.setForeground(Color.white);
        p1.add(heading);

        JPanel p2 = new JPanel();
        p2.setLayout(null);
        p2.setBackground(new Color(0,0,102));
        p2.setBounds(0,65,300,900);
        add(p2);

        addDetails = new JButton("Add User Details");
        addDetails.setBounds(0,0,300,50);
        addDetails.setBackground(new Color(0,0,102));
        addDetails.setForeground(Color.white);
        addDetails.setFont(new Font("Tahoma",Font.PLAIN,20));
        addDetails.setMargin(new Insets(0,0,0,60));
        addDetails.addActionListener(this);
        p2.add(addDetails);

        JButton updateDetails = new JButton("Update User Details");
        updateDetails.setBounds(0,50,300,50);
        updateDetails.setBackground(new Color(0,0,102));
        updateDetails.setForeground(Color.white);
        updateDetails.setFont(new Font("Tahoma",Font.PLAIN,20));
        updateDetails.setMargin(new Insets(0,0,0,30));
        p2.add(updateDetails);

        viewDetails = new JButton("View User Details");
        viewDetails.setBounds(0,100,300,50);
        viewDetails.setBackground(new Color(0,0,102));
        viewDetails.setForeground(Color.white);
        viewDetails.setFont(new Font("Tahoma",Font.PLAIN,20));
        viewDetails.setMargin(new Insets(0,0,0,70));
        p2.add(viewDetails);

        JButton deleteDetails = new JButton("Delete User Details");
        deleteDetails.setBounds(0,150,300,50);
        deleteDetails.setBackground(new Color(0,0,102));
        deleteDetails.setForeground(Color.white);
        deleteDetails.setFont(new Font("Tahoma",Font.PLAIN,20));
        deleteDetails.setMargin(new Insets(0,0,0,40));
        p2.add(deleteDetails);

        JButton placeOrders = new JButton("Place Orders");
        placeOrders.setBounds(0,200,300,50);
        placeOrders.setBackground(new Color(0,0,102));
        placeOrders.setForeground(Color.white);
        placeOrders.setFont(new Font("Tahoma",Font.PLAIN,20));
        placeOrders.setMargin(new Insets(0,0,0,110));
        p2.add(placeOrders);

        JButton checkOrders = new JButton("Check Orders");
        checkOrders.setBounds(0,250,300,50);
        checkOrders.setBackground(new Color(0,0,102));
        checkOrders.setForeground(Color.white);
        checkOrders.setFont(new Font("Tahoma",Font.PLAIN,20));
        checkOrders.setMargin(new Insets(0,0,0,110));
        p2.add(checkOrders);

        JButton viewOrders = new JButton("View Orders");
        viewOrders.setBounds(0,300,300,50);
        viewOrders.setBackground(new Color(0,0,102));
        viewOrders.setForeground(Color.white);
        viewOrders.setFont(new Font("Tahoma",Font.PLAIN,20));
        viewOrders.setMargin(new Insets(0,0,0,110));
        p2.add(viewOrders);

        JButton orderType = new JButton("Order Type");
        orderType.setBounds(0,350,300,50);
        orderType.setBackground(new Color(0,0,102));
        orderType.setForeground(Color.white);
        orderType.setFont(new Font("Tahoma",Font.PLAIN,20));
        orderType.setMargin(new Insets(0,0,0,110));
        p2.add(orderType);

        JButton trackOrders = new JButton("Track Orders");
        trackOrders.setBounds(0,400,300,50);
        trackOrders.setBackground(new Color(0,0,102));
        trackOrders.setForeground(Color.white);
        trackOrders.setFont(new Font("Tahoma",Font.PLAIN,20));
        trackOrders.setMargin(new Insets(0,0,0,110));
        p2.add(trackOrders);

        JButton destination = new JButton("Order Destination");
        destination.setBounds(0,450,300,50);
        destination.setBackground(new Color(0,0,102));
        destination.setForeground(Color.white);
        destination.setFont(new Font("Tahoma",Font.PLAIN,20));
        destination.setMargin(new Insets(0,0,0,60));
        p2.add(destination);

        JButton payments = new JButton("Payments");
        payments.setBounds(0,500,300,50);
        payments.setBackground(new Color(0,0,102));
        payments.setForeground(Color.white);
        payments.setFont(new Font("Tahoma",Font.PLAIN,20));
        payments.setMargin(new Insets(0,0,0,120));
        p2.add(payments);

        JButton terms = new JButton("T&C");
        terms.setBounds(0,550,300,50);
        terms.setBackground(new Color(0,0,102));
        terms.setForeground(Color.white);
        terms.setFont(new Font("Tahoma",Font.PLAIN,20));
        terms.setMargin(new Insets(0,0,0,140));
        p2.add(terms);

        JButton about = new JButton("About");
        about.setBounds(0,600,300,50);
        about.setBackground(new Color(0,0,102));
        about.setForeground(Color.white);
        about.setFont(new Font("Tahoma",Font.PLAIN,20));
        about.setMargin(new Insets(0,0,0,130));
        p2.add(about);

        JButton about1 = new JButton("About");
        about1.setBounds(0,650,300,50);
        about1.setBackground(new Color(0,0,102));
        about1.setForeground(Color.white);
        about1.setFont(new Font("Tahoma",Font.PLAIN,20));
        about1.setMargin(new Insets(0,0,0,130));
        p2.add(about1);

        ImageIcon i4 = new ImageIcon("C:\\Users\\DELL\\OneDrive - vitap.ac.in\\Pictures\\courierpic.png");
//        Image i5 = i4.getImage().getScaledInstance(1650,1000,Image.SCALE_DEFAULT);
//        ImageIcon i6 = new ImageIcon(i5);
//        JLabel img = new JLabel(i6);
        Image i5 = i4.getImage().getScaledInstance(1050,570,Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel img = new JLabel(i6);
        img.setBounds(0,0,1660,850);
        add(img);


        JLabel text = new JLabel("Courier Management System");
        text.setBounds(450,60,1300,90);
        text.setForeground(Color.RED);
        text.setFont(new Font("Raleway",Font.PLAIN,55));
        img.add(text);



        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == addDetails ){
            new AddUserDetails(username);
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new Dashboard(" ");
    }
}
