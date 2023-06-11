package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReceiverDetails extends JFrame implements ActionListener {
    String username;
    JLabel rname,rphone,rpin,rstate,rcity;
    JTextField tfname,tfphone,tfpin,tfcity;
    JTextField tfflat,tfstreet,tflandmark;
    JComboBox cState;
    JButton back,next;
    ReceiverDetails(String username){
        this.username = username;
        setBounds(230,60,900,650);
        getContentPane().setBackground(Color.ORANGE);
        setTitle("Receiver Details");
        setLayout(null);

        JLabel text = new JLabel("RECEIVER DETAILS");
        text.setBounds(300,10,300,30);
        text.setFont(new Font("Tahoma",Font.BOLD,30));
        add(text);

        rname = new JLabel("Full Name");
        rname.setBounds(250,75,150,25);
        rname.setFont(new Font("Tahoma",Font.BOLD,16));
        add(rname);

        tfname = new JTextField();
        tfname.setBounds(400,75,200,25);
        tfname.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(tfname);

        rphone = new JLabel("Mobile number");
        rphone.setBounds(250,125,150,25);
        rphone.setFont(new Font("Tahoma",Font.BOLD,16));
        add(rphone);

        tfphone = new JTextField();
        tfphone.setBounds(400,125,200,25);
        tfphone.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(tfphone);

        rpin = new JLabel("Pincode");
        rpin.setBounds(250,175,150,25);
        rpin.setFont(new Font("Tahoma",Font.BOLD,16));
        add(rpin);

        tfpin = new JTextField();
        tfpin.setBounds(400,175,200,25);
        tfpin.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(tfpin);

        rcity = new JLabel("Town/City");
        rcity.setBounds(75,225,150,25);
        rcity.setFont(new Font("Tahoma",Font.BOLD,16));
        add(rcity);

        tfcity = new JTextField();
        tfcity.setBounds(180,225,200,25);
        tfcity.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(tfcity);


        rstate = new JLabel("State");
        rstate.setBounds(480,225,150,25);
        rstate.setFont(new Font("Tahoma",Font.BOLD,16));
        add(rstate);


        cState = new JComboBox(new String[]{"Andaman and Nicobar Islands (UT)","Andhra Pradesh","Arunachal Pradesh","Assam","Bihar","Chandigarh (UT)","Chhattisgarh","Dadra and Nagar Haveli and Daman and Diu (UT)","Delhi (UT)","Goa","Gujarat","Haryana","Himachal Pradesh","Jammu and Kashmir (UT)","Jharkhand","Karnataka","Kerala","Ladakh (UT)","Lakshadweep (UT)","Madhya Pradesh","Maharashtra","Manipur","Meghalaya","Mizoram","Nagaland","Odisha","Puducherry (UT)","Punjab","Rajasthan","Sikkim","Tamil Nadu","Telangana","Tripura","Uttar Pradesh","Uttarakhand","West Bengal"});
        cState.setBounds(550,225,250,25);
        cState.setBackground(Color.WHITE);
        add(cState);

        JLabel flat = new JLabel("Flat, House no., Building, Company, Apartment");
        flat.setBounds(30,275,400,25);
        flat.setFont(new Font("Tahoma",Font.BOLD,16));
        add(flat);

        tfflat = new JTextField();
        tfflat.setBounds(30,315,600,25);
        tfflat.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(tfflat);

        JLabel street = new JLabel("Area, Street, Sector, Village");
        street.setBounds(30,355,300,25);
        street.setFont(new Font("Tahoma",Font.BOLD,16));
        add(street);

        tfstreet = new JTextField();
        tfstreet.setBounds(30,395,600,25);
        tfstreet.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(tfstreet);

        JLabel landmark = new JLabel("Landmark");
        landmark.setBounds(30,435,300,25);
        landmark.setFont(new Font("Tahoma",Font.BOLD,16));
        add(landmark);

        tflandmark = new JTextField();
        tflandmark.setBounds(30,475,600,25);
        tflandmark.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(tflandmark);

        back = new JButton("Back");
        back.setFont(new Font("Tahoma",Font.BOLD,16));
        back.setBounds(50,540,100,25);
        back.addActionListener(this);
        add(back);

        next = new JButton("Next");
        next.setFont(new Font("Tahoma",Font.BOLD,16));
        next.setBounds(720,540,100,25);
        next.addActionListener(this);
        add(next);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == back){
            new PlaceOrder(username);
            setVisible(false);
        } else if (e.getSource() == next) {
            String name = tfname.getText();
            String city = tfcity.getText();
            String state = (String) cState.getSelectedItem();
            String pin2 = tfpin.getText();
            String phone = tfphone.getText();
            String flat = tfflat.getText();
            String area = tfstreet.getText();
            String landmark = tflandmark.getText();
            try{
                Conn c = new Conn();
                String query = "insert into r_details values('"+username+"','"+name+"','"+pin2+"','"+phone+"','"+city+"','"+state+"','"+flat+"','"+area+"','"+landmark+"')";
                c.s.executeUpdate(query);
                new CourierType(username);
                setVisible(false);
            }catch (Exception e1){
                e1.printStackTrace();
            }
            new CourierType(username);
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new ReceiverDetails("");
    }
}
