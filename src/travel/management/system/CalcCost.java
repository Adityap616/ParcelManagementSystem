package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class CalcCost extends JFrame implements FocusListener, ActionListener {
    JTextField tfp1,tfp2,tfwt,tflen,tfwid,tfh,tfvalue;
    JButton calc,back,reset;
    String username;
    JRadioButton cod,prepaid;
    CalcCost(String username){
        this.username = username;
        setBounds(450,100,880,550);
        setLayout(null);
        getContentPane().setBackground(Color.CYAN);

        JLabel text = new JLabel("DOMESTIC SHIPPING");
        text.setBounds(275,10,400,30);
        text.setFont(new Font("Tahoma",Font.BOLD,30));
        add(text);

        JLabel p1 = new JLabel("Pick-up Area Pincode*\n");
        p1.setBounds(30,70,300,25);
        p1.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(p1);

        JLabel p2 = new JLabel("Delivery Area Pincode*\n");
        p2.setBounds(500,70,300,25);
        p2.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(p2);

        tfp1 = new JTextField();
        tfp1.setText("Enter 6 digit Pickup Area Pincode");
        tfp1.addFocusListener(this);
        tfp1.setBounds(30,110,300,25);
        tfp1.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(tfp1); //"Enter 6 digit Pickup Area Pincode"

        tfp2 = new JTextField();
        tfp2.setText("Enter 6 digit Delivery Area Pincode");
        tfp2.addFocusListener(this);
        tfp2.setBounds(500,110,300,25);
        tfp2.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(tfp2); //"Enter 6 digit Delivery Area Pincode"

        JLabel wt = new JLabel("Weight(in kg)*\n");
        wt.setBounds(30,150,300,25);
        wt.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(wt);

        JLabel dimensions = new JLabel("Dimensions (optional)");
        dimensions.setBounds(500,150,400,25);
        dimensions.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(dimensions);

        tfwt = new JTextField();
        tfwt.setText("Input weight in kilograms");
        tfwt.addFocusListener(this);
        tfwt.setBounds(30,190,300,25);
        tfwt.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(tfwt);

        tflen = new JTextField();
        tflen.setText("Length");
        tflen.addFocusListener(this);
        tflen.setBounds(500,190,75,25);
        tflen.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(tflen);

        JLabel x1 = new JLabel("X");
        x1.setFont(new Font("Tahoma",Font.PLAIN,16));
        x1.setBounds(585,190,20,25);
        add(x1);

        tfwid = new JTextField();
        tfwid.setText("Width");
        tfwid.addFocusListener(this);
        tfwid.setBounds(610,190,75,25);
        tfwid.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(tfwid);

        JLabel x2 = new JLabel("X");
        x2.setFont(new Font("Tahoma",Font.PLAIN,16));
        x2.setBounds(695,190,20,25);
        add(x2);

        tfh = new JTextField();
        tfh.setText("Height");
        tfh.addFocusListener(this);
        tfh.setBounds(710,190,75,25);
        tfh.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(tfh);

        JLabel pay = new JLabel("Payment Mode*\n");
        pay.setBounds(30,230,300,25);
        pay.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(pay);

        JLabel value = new JLabel("Shipment Value");
        value.setBounds(500,230,300,25);
        value.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(value);

        prepaid = new JRadioButton("Prepaid");
        prepaid.setBounds(30,270,100,25);
        prepaid.setFont(new Font("Tahoma",Font.PLAIN,18));
        prepaid.addActionListener(this);
        prepaid.setBackground(Color.CYAN);
        add(prepaid);

        cod = new JRadioButton("Cash on Delivery");
        cod.setBounds(150,270,200,25);
        cod.setFont(new Font("Tahoma",Font.PLAIN,18));
        cod.addActionListener(this);
        cod.setBackground(Color.CYAN);
        add(cod);

        tfvalue = new JTextField();
        tfvalue.setBounds(500,270,300,25);
        tfvalue.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(tfvalue);

        calc = new JButton("Calculate");
        calc.setBounds(270,375,150,25);
        calc.setFont(new Font("Tahoma",Font.PLAIN,18));
        calc.addActionListener(this);
        add(calc);

        reset = new JButton("Reset");
        reset.setBounds(450,375,100,25);
        reset.setFont(new Font("Tahoma",Font.PLAIN,18));
        reset.addActionListener(this);
        add(reset);

        back = new JButton("Back");
        back.setBounds(30,430,100,25);
        back.setFont(new Font("Tahoma",Font.PLAIN,18));
        back.addActionListener(this);
        add(back);



        setVisible(true);
    }

    @Override
    public void focusGained(FocusEvent e) {
        if (tfp1.getText().equals("Enter 6 digit Pickup Area Pincode")){
            tfp1.setText("");
        }
        if (tfp2.getText().equals("Enter 6 digit Delivery Area Pincode")){
            tfp2.setText("");
        }
        if (tfwt.getText().equals("Input weight in kilograms")){
            tfwt.setText("");

        }
        if (tflen.getText().equals("Length")){
            tflen.setText("");
        }
        if (tfwid.getText().equals("Width")){
            tfwid.setText("");
        }
        if (tfh.getText().equals("Height")){
            tfh.setText("");
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
        if (tfp1.getText().isEmpty()){
            tfp1.setText("Enter 6 digit Pickup Area Pincode");
        }
        if (tfp2.getText().isEmpty()){
            tfp2.setText("Enter 6 digit Delivery Area Pincode");
        }
        if (tfwt.getText().isEmpty()){
            tfwt.setText("Input weight in kilograms");
        }
        if (tflen.getText().isEmpty()){
            tflen.setText("Length");
        }
        if (tfwid.getText().isEmpty()){
            tfwid.setText("Width");
        }
        if (tfh.getText().isEmpty()){
            tfh.setText("Height");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == back){
            new Dashboard(username);
            setVisible(false);
        } else if (e.getSource() == reset) {
            tfp1.setText("");
            tfp2.setText("");
            tfwt.setText("");
            tflen.setText("");
            tfwid.setText("");
            tfh.setText("");
            tfvalue.setText("");
            cod.setSelected(false);
            prepaid.setSelected(false);
        } else if (e.getSource() == calc) {
            String pin1 = tfp1.getText();
            String pin2 = tfp2.getText();
            String weight = tfwt.getText();
            if (pin1.isEmpty() || pin2.isEmpty() || weight.isEmpty() ||(!cod.isSelected() && !prepaid.isSelected())){
                JOptionPane.showMessageDialog(null,"Kindly input values for the required fields");
            }
            else{
                double p1 = Double.parseDouble(pin1);
                double p2 = Double.parseDouble(pin2);
                double wt = Double.parseDouble(weight);
                double fare = Math.abs(p1-p2)*0.002 + (wt*100);
                if (cod.isSelected()){
                    fare += 100;
                } else if (prepaid.isSelected()) {
                    fare *= 1;
                }

                String total = Double.toString(fare);
                JOptionPane.showMessageDialog(null,"Your total will be "+total+" rupees");
            }
        }
        if (cod.isSelected() && prepaid.isSelected()){
            JOptionPane.showMessageDialog(null,"Both modes of payment cannot be chosen, kindly select one.");
        }
    }

    public static void main(String[] args) {
        new CalcCost(" ");
    }
}
