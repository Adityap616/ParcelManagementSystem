package travel.management.system;

import javax.swing.*;
import java.awt.*;

public class Loading extends JFrame implements Runnable {
    Thread t;
    JProgressBar bar;
    String username;

    public void run(){
        try {
            for (int i =1;i<101;i++){
                int max = bar.getMaximum();//100
                int value = bar.getValue();

                if(value<max){
                    bar.setValue(bar.getValue()+1);
                }
                else {
                    setVisible(false);
                    new Dashboard(username);
                }
                Thread.sleep(50);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        setVisible(false);
    }
    Loading(String username){
        this.username = username;
        t = new Thread(this);

        setBounds(500,200,650,400);
        getContentPane().setBackground(Color.white);
        setLayout(null);

        JLabel text = new JLabel("Courier Management System");
        text.setBounds(60,20,600,40);
        text.setForeground(Color.BLUE);
        text.setFont(new Font("Raleway",Font.BOLD,35));
        add(text);

        bar = new JProgressBar();
        bar.setBounds(150,100,300,35);
        bar.setStringPainted(true);
        add(bar);

        JLabel loading = new JLabel("Loading, please wait...");
        loading.setBounds(230,130,150,30);
        loading.setForeground(Color.RED);
        loading.setFont(new Font("Raleway",Font.BOLD,16));
        add(loading);

        JLabel uname = new JLabel("Welcome "+ username);
        uname.setBounds(20,210,400,40);
        uname.setForeground(Color.RED);
        uname.setFont(new Font("Raleway",Font.BOLD,16));
        add(uname);

        t.start();
        setVisible(true);
    }
    public static void main(String[] args) {

        new Loading("");
    }
}
