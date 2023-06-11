package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class OrderViewing extends JFrame implements ActionListener {
    String username;
    JButton back;
    OrderViewing(String username){
        this.username = username;
        setBounds(230,60,900,650);
        getContentPane().setBackground(Color.ORANGE);
        setLayout(null);

        JLabel lname = new JLabel("Name");
        lname.setBounds(30,90,100,25);
        lname.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(lname);

        JLabel name = new JLabel();
        name.setBounds(200,90,200,25);
        name.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(name);

        JLabel c_id = new JLabel("Courier ID");
        c_id.setBounds(450,90,100,25);
        c_id.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(c_id);

        JLabel cid = new JLabel();
        cid.setBounds(600,90,200,25);
        cid.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(cid);

        JLabel pin1 = new JLabel("Pincode");
        pin1.setBounds(30,230,150,25);
        pin1.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(pin1);

        JLabel rpin = new JLabel();
        rpin.setBounds(200,230,100,25);
        rpin.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(rpin);

        JLabel spin = new JLabel();
        spin.setBounds(600,230,150,25);
        spin.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(spin);

        JLabel pin2 = new JLabel("Pincode");
        pin2.setBounds(450,230,150,25);
        pin2.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(pin2);

        JLabel from = new JLabel("From");
        from.setBounds(30,165,100,25);
        from.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(from);

        JLabel city1 = new JLabel();
        city1.setBounds(200,165,200,25);
        city1.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(city1);

        JLabel to = new JLabel("To");
        to.setBounds(450,165,100,25);
        to.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(to);

        JLabel city2 = new JLabel();
        city2.setBounds(600,165,200,25);
        city2.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(city2);

        JLabel type = new JLabel("Delivery type");
        type.setBounds(30,305,150,25);
        type.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(type);

        JLabel ctype = new JLabel();
        ctype.setBounds(200,305,200,25);
        ctype.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(ctype);

        JLabel tcost = new JLabel("Total Amt");
        tcost.setBounds(450,305,150,25);
        tcost.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(tcost);

        JLabel cost = new JLabel();
        cost.setBounds(600,305,100,25);
        cost.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(cost);

        JLabel ptype = new JLabel("Payment Method");
        ptype.setBounds(30,380,150,25);
        ptype.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(ptype);

        JLabel paym = new JLabel();
        paym.setBounds(200,380,200,25);
        paym.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(paym);

        back = new JButton("Back");
        back.setBounds(600,500,80,25);
        back.setFont(new Font("Tahoma",Font.PLAIN,18));
        back.addActionListener(this);
        add(back);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from courier where username = '"+username+"'");
            while (rs.next()){
                cost.setText(rs.getString("cost"));
                ctype.setText(rs.getString("mode"));
                cid.setText(rs.getString("value"));
                paym.setText(rs.getString("type"));
            }
            ResultSet rs1 = c.s.executeQuery("select * from r_details where username = '"+username+"'");
            while (rs1.next()){
                name.setText(rs1.getString("name"));
                rpin.setText(rs1.getString("pin1"));
                city2.setText(rs1.getString("city"));
            }
            ResultSet rs2 = c.s.executeQuery("select * from order_details where username = '"+username+"'");
            while (rs2.next()){
                spin.setText(rs2.getString("pin1"));
                city1.setText(rs2.getString("city"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == back){
            setVisible(false);
            new ViewOrders(username);
        }
    }

    public static void main(String[] args) {
        new OrderViewing("");
    }
}
