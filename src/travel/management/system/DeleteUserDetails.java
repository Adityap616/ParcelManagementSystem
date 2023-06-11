package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class DeleteUserDetails extends JFrame implements ActionListener {
    JButton delete;
    String username;
    DeleteUserDetails(String username){
        this.username = username;
        setBounds(450,100,870,625);
        getContentPane().setBackground(Color.white);
        setLayout(null);

        JLabel lusername = new JLabel("Username");
        lusername.setBounds(30,50,150,25);
        add(lusername);

        JLabel uname = new JLabel();
        uname.setBounds(220,50,150,25);
        add(uname);

        JLabel lname = new JLabel("Name");
        lname.setBounds(30,110,150,25);
        add(lname);

        JLabel name = new JLabel();
        name.setBounds(220,110,150,25);
        add(name);

        JLabel lID = new JLabel("ID");
        lID.setBounds(30,170,150,25);
        add(lID);

        JLabel id = new JLabel();
        id.setBounds(220,170,150,25);
        add(id);

        JLabel lnumber = new JLabel("ID Number");
        lnumber.setBounds(30,230,150,25);
        add(lnumber);

        JLabel number = new JLabel();
        number.setBounds(220,230,150,25);
        add(number);

        JLabel lphone = new JLabel("Phone No");
        lphone.setBounds(30,290,150,25);
        add(lphone);

        JLabel phone = new JLabel();
        phone.setBounds(220,290,150,25);
        add(phone);

        JLabel lmail = new JLabel("Email");
        lmail.setBounds(500,50,150,25);
        add(lmail);

        JLabel email = new JLabel();
        email.setBounds(690,50,150,25);
        add(email);

        JLabel lstate = new JLabel("State");
        lstate.setBounds(500,110,150,25);
        add(lstate);

        JLabel state = new JLabel();
        state.setBounds(690,110,150,25);
        add(state);

        JLabel lcity = new JLabel("City/Town");
        lcity.setBounds(500,170,150,25);
        add(lcity);

        JLabel city = new JLabel();
        city.setBounds(690,170,150,25);
        add(city);

        JLabel lpin = new JLabel("Pin Code");
        lpin.setBounds(500,230,150,25);
        add(lpin);

        JLabel pin = new JLabel();
        pin.setBounds(690,230,150,25);
        add(pin);

        delete = new JButton("Delete");
        delete.setBackground(Color.BLACK);
        delete.setForeground(Color.WHITE);
        delete.setBounds(350,400,100,25);
        delete.addActionListener(this);
        add(delete);

        try {
            Conn c = new Conn();
            String query = "select * from customer where username = '"+username+"'";
            ResultSet rs = c.s.executeQuery(query);
            while (rs.next()){
                uname.setText(rs.getString("username"));
                name.setText(rs.getString("name"));
                id.setText(rs.getString("id"));
                number.setText(rs.getString("no"));
                phone.setText(rs.getString("phone"));
                email.setText(rs.getString("email"));
                state.setText(rs.getString("state"));
                city.setText(rs.getString("city"));
                pin.setText(rs.getString("pin"));
            }

        }catch (Exception e){
            e.printStackTrace();

        }

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == delete){
            try {
                Conn c = new Conn();
                c.s.executeUpdate("delete from details where username = '"+username+"'");
                c.s.executeUpdate("delete from customer where username = '"+username+"'");
                c.s.executeUpdate("delete from order_details where username = '"+username+"'");
                c.s.executeUpdate("delete from r_details where username = '"+username+"'");
                c.s.executeUpdate("delete from courier where username = '"+username+"'");

                JOptionPane.showMessageDialog(null,"User Details Deleted Successfully");

                System.exit(0);
            }catch (Exception e){
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {

        new DeleteUserDetails("");
    }
}
