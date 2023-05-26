package travel.management.system;

import javax.swing.*;
import java.awt.*;


public class Signup extends JFrame {
    Signup(){
        // setBounds is the combination of both setSize and setLocation
        //setSize(900,400);
        //setLocation(350,200);
        setBounds(350,200,900,360);
        getContentPane().setBackground(Color.WHITE); //Color class belongs to awt package, so import java.awt
        setLayout(null); // if this is not null then setBounds on panel does not work

        JPanel p1 = new JPanel();
        p1.setBackground(new Color(133,193,233));
        p1.setBounds(0,0,500,400);
        p1.setLayout(null);
        add(p1);

        JLabel username = new JLabel("User Name");
        username.setBounds(50,20,125,25);
        username.setFont(new Font("Tamoha",Font.BOLD,14));
        p1.add(username);

        JTextField tfusername = new JTextField();
        tfusername.setBounds(190,20,180,25);
        tfusername.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfusername);

        JLabel name = new JLabel("Name");
        name.setBounds(50,60,125,25);
        name.setFont(new Font("Tamoha",Font.BOLD,14));
        p1.add(name);

        JTextField tfname = new JTextField();
        tfname.setBounds(190,60,180,25);
        tfname.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfname);

        JLabel password = new JLabel("Password");
        password.setBounds(50,100,125,25);
        password.setFont(new Font("Tamoha",Font.BOLD,14));
        p1.add(password);

        JTextField tfpassword = new JTextField();
        tfpassword.setBounds(190,100,180,25);
        tfpassword.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfpassword);

        JLabel securityQtn = new JLabel("Security Question");
        securityQtn.setBounds(50,140,125,25);
        securityQtn.setFont(new Font("Tamoha",Font.BOLD,14));
        p1.add(securityQtn);

        Choice security = new Choice();//gives a dropdown of various options to choose from
        security.add("Place of Birth");
        security.add("Favourite sport");
        security.add("Father's name");
        security.add("School attended");
        security.setBounds(190,140,180,25);
        p1.add(security);

        JLabel answer = new JLabel("Answer");
        answer.setBounds(50,180,125,25);
        answer.setFont(new Font("Tamoha",Font.BOLD,14));
        p1.add(answer);

        JTextField tfanswer = new JTextField();
        tfanswer.setBounds(190,180,180,25);
        tfanswer.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfanswer);

        JButton create = new JButton("Create");
        create.setBackground(Color.WHITE);
        create.setForeground(new Color(133,193,233));
        create.setBounds(80,250,100,30);
        create.setFont(new Font("Tamoha",Font.BOLD,14));
        p1.add(create);

        JButton back = new JButton("Back");
        back.setBackground(Color.WHITE);
        back.setForeground(new Color(133,193,233));
        back.setBounds(250,250,100,30);
        back.setFont(new Font("Tamoha",Font.BOLD,14));
        p1.add(back);

        ImageIcon i1 = new ImageIcon("C:\\Users\\DELL\\OneDrive - vitap.ac.in\\Pictures\\login2.png");
        Image i2 = i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(580,50,250,250);
        add(image);



        setVisible(true); //should always be placed at the end
    }
    public static void main(String[] args) {
        new Signup();
    }
}
