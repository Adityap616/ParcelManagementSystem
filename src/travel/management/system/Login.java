package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.border.*; //border is a subpackage ,so it is not imported in line 3

public class Login extends JFrame implements ActionListener {
    JButton login,signup,forget;
    JTextField tfusername;
    JPasswordField tfpassword;
    Login(){
        setSize(900,400);
        setLocation(350,200);
        setLayout(null);

        getContentPane().setBackground(Color.WHITE); // this selects the entire panel and changes its color to white

        JPanel p1 = new JPanel();
        p1.setBackground(new Color(133,193,233));
        p1.setBounds(0,0,400,400);
        p1.setLayout(null);
        add(p1);

        ImageIcon i1 = new ImageIcon("C:\\Users\\DELL\\OneDrive - vitap.ac.in\\Pictures\\login.png");
        Image i2 = i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(100,100,200,200);
        p1.add(image);

        JPanel p2 = new JPanel();
        p2.setLayout(null);
        p2.setBounds(400,30,450,300);
        add(p2);

        JLabel username = new JLabel("User Name");
        username.setBounds(60,20,100,25);
        username.setFont(new Font("SAN SERIF",Font.PLAIN,18));
        p2.add(username);

        tfusername = new JTextField();
        tfusername.setBounds(60,60,300,30);
        tfusername.setBorder(BorderFactory.createEmptyBorder());
        p2.add(tfusername);

        JLabel password = new JLabel("Password");
        password.setBounds(60,110,100,25);
        password.setFont(new Font("SAN SERIF",Font.PLAIN,18));
        p2.add(password);

        tfpassword = new JPasswordField();
        tfpassword.setBounds(60,150,300,30);
        tfpassword.setBorder(BorderFactory.createEmptyBorder());
        p2.add(tfpassword);

        login = new JButton("Login");
        login.setBounds(60,200,130,30);
        login.setBackground(new Color(133,193,233));
        login.setForeground(Color.WHITE);
        login.setBorder(new LineBorder(new Color(133,193,233)));
        login.addActionListener(this);
        p2.add(login);

        signup = new JButton("Signup");
        signup.setBounds(230,200,130,30);
        signup.setBackground(new Color(133,193,233));
        signup.setForeground(Color.WHITE);
        signup.setBorder(new LineBorder(new Color(133,193,233)));
        signup.addActionListener(this);
        p2.add(signup);

        forget = new JButton("Forget Password");
        forget.setBounds(130,250,130,30);
        forget.setBackground(new Color(133,193,233));
        forget.setForeground(Color.WHITE);
        forget.setBorder(new LineBorder(new Color(133,193,233)));
        forget.addActionListener(this);
        p2.add(forget);

        JLabel text = new JLabel("Trouble in Login...");
        text.setBounds(300,250,150,20);
        text.setForeground (Color.RED);
        p2.add(text);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == login){
            try {
                String username = tfusername.getText();
                String password = new String(tfpassword.getPassword());

                String query = "Select * from details where username = '"+username+"' AND password = '"+password+"'";
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                if (rs.next()){
                    setVisible(false);
                    new Loading(username);
                }
                else {
                    JOptionPane.showMessageDialog(null,"Incorrect username or password");
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        } else if (ae.getSource() == signup) {
            setVisible(false);
            new Signup();
        } else if (ae.getSource() == forget) {
            setVisible(false);
            new ForgetPassword();
        }
    }

    public static void main(String[] args) {

        new Login();
    }
}
