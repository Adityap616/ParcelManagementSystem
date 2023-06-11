package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URI;
import java.sql.ResultSet;

public class Paytm extends JFrame implements ActionListener {
    String username;
    JButton pay,back;
    Paytm(String username){
        this.username = username;
        setBounds(400,120,800,600);
        getContentPane().setBackground(Color.cyan);
        setLayout(null);

        JLabel cid = new JLabel("Courier ID");
        cid.setBounds(200,80,150,25);
        cid.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(cid);

        JLabel id = new JLabel();
        id.setBounds(390,80,150,25);
        id.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(id);

        JLabel mode = new JLabel("Mode of Payment");
        mode.setBounds(200,140,150,25);
        mode.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(mode);

        JLabel mod = new JLabel();
        mod.setBounds(390,140,150,25);
        mod.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(mod);

        JLabel cost = new JLabel("Total Amt");
        cost.setBounds(200,200,150,25);
        cost.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(cost);

        JLabel total = new JLabel();
        total.setBounds(390,200,150,25);
        total.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(total);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from courier where username = '"+username+"'");
            while (rs.next()){
                id.setText("value");
                mod.setText("mode");
                total.setText("cost");
            }
        }catch (Exception e){
            e.printStackTrace();
        }

//        JEditorPane pane = new JEditorPane();
//        pane.setEditable(false);

        /*try {
            pane.setPage("https://paytm.com/electricity-bill-payment");
        }catch (Exception e){
           pane.setContentType("text/html");
           pane.setText("<html>Could not load</html>");
        }*/

        /*String link = "https://paytm.com/electricity-bill-payment";
        if (Desktop.isDesktopSupported()) {
            Desktop desktop = Desktop.getDesktop();
            if (desktop.isSupported(Desktop.Action.BROWSE)) {
                try {
                    desktop.browse(new URI(link));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }*/

//        JScrollPane sp = new JScrollPane();
//        setDefaultCloseOperation(EXIT_ON_CLOSE);
//        getContentPane().add(sp);
//        setPreferredSize(new Dimension(800,600));

        back = new JButton("Back");
        back.setBounds(40,450,80,40);
        back.setFont(new Font("Tahoma",Font.PLAIN,16));
        back.addActionListener(this);
        add(back);

        pay = new JButton("Pay online");
        pay.setBounds(600,450,120,40);
        pay.setFont(new Font("Tahoma",Font.PLAIN,16));
        pay.addActionListener(this);
        add(pay);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == pay){
            new Payment(username);
            setVisible(false);
        }
        else if (e.getSource() == back){
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new Paytm("");
    }
}
