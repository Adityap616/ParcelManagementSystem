package travel.management.system;

import javax.swing.*;
import javax.xml.transform.Result;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.SecureRandom;
import java.sql.ResultSet;
import java.util.Random;

public class ViewOrders extends JFrame implements ActionListener {
    String username;
    JButton back,check;
    JTextField uname,tfid;
    ViewOrders(String username){
        this.username = username;
        setBounds(400,110,900,600);
        getContentPane().setBackground(Color.CYAN);
        setTitle("View Orders");
        setLayout(null);

        JLabel text = new JLabel("COURIER DETAILS");
        text.setBounds(310,10,300,30);
        text.setFont(new Font("Tahoma",Font.BOLD,30));
        add(text);

        /*JLabel lname = new JLabel("Name");
        lname.setBounds(30,90,100,25);
        lname.setFont(new Font("Tahoma",Font.BOLD,18));
        add(lname);

        JLabel name = new JLabel();
        name.setBounds(150,90,200,25);
        name.setFont(new Font("Tahoma",Font.BOLD,18));
        add(name);

        JLabel c_id = new JLabel("Courier ID");
        c_id.setBounds(450,90,100,25);
        c_id.setFont(new Font("Tahoma",Font.BOLD,18));
        add(c_id);

        JLabel cid = new JLabel();
        cid.setBounds(600,90,200,25);
        cid.setFont(new Font("Tahoma",Font.BOLD,18));
        add(cid);

        JLabel pin1 = new JLabel("Sender's Pin");
        pin1.setBounds(30,150,150,25);
        pin1.setFont(new Font("Tahoma",Font.BOLD,18));
        add(pin1);

        JLabel rpin = new JLabel();
        rpin.setBounds(150,150,100,25);
        rpin.setFont(new Font("Tahoma",Font.BOLD,18));
        add(rpin);

        JLabel spin = new JLabel();
        spin.setBounds(600,150,10,25);
        spin.setFont(new Font("Tahoma",Font.BOLD,18));
        add(spin);

        JLabel pin2 = new JLabel("Receiver's Pin");
        pin2.setBounds(450,150,150,25);
        pin2.setFont(new Font("Tahoma",Font.BOLD,18));
        add(pin2);

        JLabel from = new JLabel("From");
        from.setBounds(30,210,100,25);
        from.setFont(new Font("Tahoma",Font.BOLD,18));
        add(from);

        JLabel city1 = new JLabel();
        city1.setBounds(150,210,200,25);
        city1.setFont(new Font("Tahoma",Font.BOLD,18));
        add(city1);

        JLabel to = new JLabel("To");
        to.setBounds(450,210,100,25);
        to.setFont(new Font("Tahoma",Font.BOLD,18));
        add(to);

        JLabel city2 = new JLabel();
        city2.setBounds(600,210,200,25);
        city2.setFont(new Font("Tahoma",Font.BOLD,18));
        add(city2);

        JLabel type = new JLabel("Delivery type");
        type.setBounds(30,270,150,25);
        type.setFont(new Font("Tahoma",Font.BOLD,18));
        add(type);

        JLabel ctype = new JLabel();
        ctype.setBounds(150,270,200,25);
        ctype.setFont(new Font("Tahoma",Font.BOLD,18));
        add(ctype);

        JLabel tcost = new JLabel("Total Amt");
        tcost.setBounds(450,270,150,25);
        tcost.setFont(new Font("Tahoma",Font.BOLD,18));
        add(tcost);

        JLabel cost = new JLabel();
        cost.setBounds(600,270,100,25);
        cost.setFont(new Font("Tahoma",Font.BOLD,18));
        add(cost);

        JLabel date1 = new JLabel("Pickup Date");
        date1.setBounds(30,330,150,25);
        date1.setFont(new Font("Tahoma",Font.BOLD,18));
        add(date1);

        JLabel pdate = new JLabel();
        pdate.setBounds(150,330,100,25);
        pdate.setFont(new Font("Tahoma",Font.BOLD,18));
        add(pdate);

        JLabel date2 = new JLabel("Delivery Date");
        date2.setBounds(450,330,150,25);
        date2.setFont(new Font("Tahoma",Font.BOLD,18));
        add(date2);

        JLabel ddate = new JLabel();
        ddate.setBounds(600,330,100,25);
        ddate.setFont(new Font("Tahoma",Font.BOLD,18));
        add(ddate);*/

        JLabel lusername = new JLabel("Username");
        lusername.setBounds(310,180,100,25);
        lusername.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(lusername);

        uname = new JTextField();
        uname.setBounds(450,180,150,25);
        uname.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(uname);

        JLabel lid = new JLabel("Order ID");
        lid.setBounds(310,230,100,25);
        lid.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(lid);

        tfid = new JTextField();
        tfid.setBounds(450,230,150,25);
        tfid.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(tfid);

        check = new JButton("Check");
        check.setBounds(465,350,100,25);
        check.setFont(new Font("Tahoma",Font.PLAIN,16));
        check.addActionListener(this);
        add(check);

        back = new JButton("Back");
        back.setBounds(320,350,100,25);
        back.setFont(new Font("Tahoma",Font.PLAIN,16));
        back.addActionListener(this);
        add(back);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == back){
            setVisible(false);
            new Dashboard(username);
        }
        else if (e.getSource() == check){
            try {
                String name = uname.getText();
                String id = tfid.getText();

                String query = "select * from courier where username = '"+username+"' and value = '"+id+"'";
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                setVisible(false);
                while (rs.next()){
                    setVisible(false);
                    new OrderViewing(username);
                }
            }catch (Exception e1){
                JOptionPane.showMessageDialog(null,"No such record found");
            }

        }
    }

    public static void main(String[] args) {
        new ViewOrders("");
    }
}
