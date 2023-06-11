package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class UpdateUserDetails extends JFrame implements ActionListener {
    JLabel labelusername,lname;
    JTextField tfphone,tfcity,tfemail,tfpc,tfnumber,tfid,tfstate;
    JComboBox cID,cState;
    JButton update,back;
    UpdateUserDetails(String uname){
        setBounds(470,150,850,550);
        setLayout(null);
        getContentPane().setBackground(Color.CYAN);

        JLabel text = new JLabel("UPDATE USER DETAILS");
        text.setBounds(50,10,300,25);
        text.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(text);

        JLabel username = new JLabel("Username:"); //JLabel in non-editable
        username.setBounds(30,50,150,25);
        add(username);

        labelusername = new JLabel();
        labelusername.setBounds(220,50,150,25);
        add(labelusername);

        JLabel name = new JLabel("Name:");
        name.setBounds(30,90,150,25);
        add(name);

        lname = new JLabel();
        lname.setBounds(220,90,150,25);
        add(lname);

        JLabel id = new JLabel("ID:");
        id.setBounds(30,130,150,25);
        add(id);

        /*cID = new JComboBox(new String[]{"Aadhar","Passport","Ration Card","Voter ID"});
        cID.setBounds(220,130,150,25);
        cID.setBackground(Color.WHITE);
        add(cID);*/

        tfid = new JTextField();
        tfid.setBounds(220,130,150,25);
        add(tfid);

        JLabel number = new JLabel("ID Number");
        number.setBounds(30,170,150,25);
        add(number);

        tfnumber = new JTextField();
        tfnumber.setBounds(220,170,150,25);
        add(tfnumber);

        JLabel phno = new JLabel("Phone No:");
        phno.setBounds(30,210,150,25);
        add(phno);

        tfphone = new JTextField();
        tfphone.setBounds(220,210,150,25);
        add(tfphone);

        JLabel email = new JLabel("Email:");
        email.setBounds(30,250,150,25);
        add(email);

        tfemail = new JTextField();
        tfemail.setBounds(220,250,150,25);
        add(tfemail);

        JLabel state = new JLabel("State/UT");
        state.setBounds(30,290,150,25);
        add(state);

        /*cState = new JComboBox(new String[]{"Andaman and Nicobar Islands (UT)","Andhra Pradesh","Arunachal Pradesh","Assam","Bihar","Chandigarh (UT)","Chhattisgarh","Dadra and Nagar Haveli and Daman and Diu (UT)","Delhi (UT)","Goa","Gujarat","Haryana","Himachal Pradesh","Jammu and Kashmir (UT)","Jharkhand","Karnataka","Kerala","Ladakh (UT)","Lakshadweep (UT)","Madhya Pradesh","Maharashtra","Manipur","Meghalaya","Mizoram","Nagaland","Odisha","Puducherry (UT)","Punjab","Rajasthan","Sikkim","Tamil Nadu","Telangana","Tripura","Uttar Pradesh","Uttarakhand","West Bengal"});
        cState.setBounds(220,290,150,25);
        cState.setBackground(Color.WHITE);
        add(cState);*/

        tfstate = new JTextField();
        tfstate.setBounds(220,290,150,25);
        add(tfstate);


        JLabel city = new JLabel("City/Town");
        city.setBounds(30,330,150,25);
        add(city);

        tfcity = new JTextField();
        tfcity.setBounds(220,330,150,25);
        add(tfcity);

        JLabel pc = new JLabel("Pin Code");
        pc.setBounds(30,370,150,25);
        add(pc);

        tfpc = new JTextField();
        tfpc.setBounds(220,370,150,25);
        add(tfpc);

        update = new JButton("Update");
        update.setBackground(Color.black);
        update.setForeground(Color.WHITE);
        update.setBounds(70,430,100,25);
        update.addActionListener(this);
        add(update);

        back = new JButton("Back");
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.setBounds(220,430,100,25);
        back.addActionListener(this);
        add(back);


        ImageIcon i1 = new ImageIcon("C:\\Users\\DELL\\OneDrive - vitap.ac.in\\Pictures\\user.png");
        Image i2 = i1.getImage().getScaledInstance(400,450,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400,40,450,420);
        add(image);

        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("Select * from customer where username='"+uname+"'");
            while (rs.next()){
                labelusername.setText(rs.getString("username"));
                lname.setText((rs.getString("name")));
                tfid.setText(rs.getString("id"));
                tfnumber.setText(rs.getString("no"));
                tfphone.setText(rs.getString("phone"));
                tfemail.setText(rs.getString("email"));
                tfstate.setText(rs.getString("state"));
                tfcity.setText(rs.getString("city"));
                tfpc.setText(rs.getString("pin"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == update){
            String username = labelusername.getText();
            String name = lname.getText();
            String id = tfid.getText();
            String no = tfnumber.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();
            String state = tfstate.getText();
            String city = tfcity.getText();
            String pincode = tfpc.getText();
            try {
                Conn c = new Conn();
                String query = "update customer set username = '"+username+"',name = '"+name+"',id = '"+id+"',no = '"+no+"',phone = '"+phone+"',email = '"+email+"',state = '"+state+"',city = '"+city+"',pin = '"+pincode+"'";
                c.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null,"Customer Details Updated Successfully");
                setVisible(false);
            }catch (Exception e){
                JOptionPane.showMessageDialog(null,"Request failed");
                e.printStackTrace();
            }
        }
        else if (ae.getSource() == back){
            setVisible(false);
        }
        else {
            setVisible(false);
        }
    }
    public static void main(String[] args) {
        new UpdateUserDetails("");
    }
}
