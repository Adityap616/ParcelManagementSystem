package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.SecureRandom;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;
import java.util.jar.JarFile;

import com.toedter.calendar.JDateChooser;
import org.jdatepicker.JDatePicker;
import org.jdatepicker.util.JDatePickerUtil;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

public class CourierType extends JFrame implements ActionListener {
    String username;
    JButton back,checkTotal,confirm;
    JTextField tfweight,tfcost,tfvalue;
    JTextArea tdesc;
    JComboBox cType,pmod;
    JDateChooser dateChooser;
    JLabel cvalue;
    CourierType(String username){
        this.username = username;
        setBounds(230,60,900,650);
        getContentPane().setBackground(Color.ORANGE);
        setTitle("Courier Type");
        setLayout(null);

        JLabel text = new JLabel("COURIER TYPE");
        text.setBounds(325,10,300,30);
        text.setFont(new Font("Tahoma",Font.BOLD,30));
        add(text);

        JLabel type = new JLabel("Type*\n");
        type.setBounds(250,70,150,25);
        type.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(type);

        cType = new JComboBox(new String[]{"Standard Delivery","Air Delivery","Surface Delivery","Express Delivery"});
        cType.setBounds(450,70,150,25);
        cType.setBackground(Color.white);
        add(cType);

        JLabel weight = new JLabel("Weight(in Kg)*\n");
        weight.setBounds(250,230,150,25);
        weight.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(weight);

        tfweight = new JTextField();
        tfweight.setBounds(450,230,150,25);
        tfweight.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(tfweight);

        JLabel pmode = new JLabel("Mode of Payment*\n");
        pmode.setBounds(250,150,250,25);
        pmode.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(pmode);

        pmod = new JComboBox(new String[]{"Pay on Delivery","Online Payment"});
        pmod.setBounds(250,190,250,25);
        pmod.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(pmod);

        SecureRandom random = new SecureRandom();
        String alphanumeric = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        StringBuilder codeBuilder = new StringBuilder();

        for (int i = 0; i < 10; i++) {
            int index = random.nextInt(alphanumeric.length());
            char character = alphanumeric.charAt(index);
            codeBuilder.append(character);
        }

        String generatedCode = codeBuilder.toString();

        JLabel value = new JLabel("Courier ID");
        value.setBounds(250,110,150,25);
        value.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(value);

        cvalue = new JLabel(generatedCode);
        cvalue.setBounds(450,110,150,25);
        cvalue.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(cvalue);

        /*tfvalue = new JTextField();   //450,110,150,25  //450,230,150,25
        tfvalue.setBounds(450,230,150,25);
        tfvalue.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(tfvalue);*/

        JLabel date = new JLabel("Pick-up Date*\n");
        date.setBounds(250,270,150,25);
        date.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(date);

        dateChooser = new JDateChooser();
        dateChooser.setBounds(450,270,150,25);
        dateChooser.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(dateChooser);

        JLabel desc = new JLabel("Description");
        desc.setBounds(250,310,200,25);
        desc.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(desc);

        tdesc = new JTextArea("Give proper description about your courier");
        tdesc.setBounds(250,350,450,125);
        tdesc.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(tdesc);

        JLabel cost = new JLabel("Order Total");
        cost.setBounds(250,495,150,25);
        cost.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(cost);

        tfcost = new JTextField();
        tfcost.setBounds(450,495,150,25);
        tfcost.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(tfcost);

        checkTotal = new JButton("Check Total");
        checkTotal.setBounds(625,495,150,25);
        checkTotal.setFont(new Font("Tahoma",Font.PLAIN,18));
        checkTotal.addActionListener(this);
        add(checkTotal);

        back = new JButton("Back");
        back.setBounds(50,540,100,30);
        back.setFont(new Font("Tahoma",Font.PLAIN,18));
        back.addActionListener(this);
        add(back);//50,540,150,30
//720,540,100,30
        confirm = new JButton("Confirm Order");
        confirm.setBounds(720,540,150,30);
        confirm.setFont(new Font("Tahoma",Font.PLAIN,18));
        confirm.addActionListener(this);
        add(confirm);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == back){
            new Dashboard(username);
            setVisible(false);
        }
        else if (e.getSource() == checkTotal){
            String pin1 = null;
            String pin2 = null;
            try{
                Conn c = new Conn();
                String t = (String) cType.getSelectedItem();
                ResultSet rs1 = c.s.executeQuery("Select * from order_details where username = '"+username+"'");
                while (rs1.next()){
                    pin1 = rs1.getString("pin1");
                }
                ResultSet rs2 = c.s.executeQuery("Select * from r_details where username = '"+username+"'");
                while (rs2.next()){
                    pin2 = rs2.getString("pin1");
                }
                String wt = tfweight.getText();
                double p1 = Double.parseDouble(pin1);
                double p2 = Double.parseDouble(pin2);
                double w = Double.parseDouble(wt);
                double fare=0;
                if (t.equals("Standard Delivery") || t.equals("Surface Delivery")){
                  fare = Math.abs(p1-p2)*0.002 + (w*100);
                } else if (t.equals("Air Delivery")|| t.equals("Express Delivery")) {
                    fare = Math.abs(p1-p2)*0.003 + (w*100);
                }
                String total = Double.toString(fare);
                tfcost.setText(total);
            }catch (Exception e1){
                e1.printStackTrace();
            }
        } else if (e.getSource() == confirm) {
            String type = (String) cType.getSelectedItem();
            String mode = (String) pmod.getSelectedItem();
            String weight = tfweight.getText();
            String value = cvalue.getText();
            String details = tdesc.getText();
            String cost = tfcost.getText();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String fdate = sdf.format(dateChooser.getDate());
            //String date = String.valueOf(dateChooser.getDate());

            try {
                Conn c = new Conn();
                String query = "insert into courier values('"+username+"','"+mode+"','"+type+"','"+weight+"','"+value+"','"+fdate+"','"+details+"','"+cost+"')";
                c.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null,"Order placed successfully");

            }catch (Exception e1){
                e1.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {

        new CourierType("admin");
    }
}
