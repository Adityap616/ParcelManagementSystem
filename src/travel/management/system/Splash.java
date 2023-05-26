package travel.management.system;

import javax.swing.*;
import java.awt.*;

public class Splash extends JFrame implements Runnable {
    Thread thread;
    Splash(){
        ImageIcon i1 = new ImageIcon("C:\\Users\\DELL\\OneDrive - vitap.ac.in\\Pictures\\splash_icon.png");
        Image i2 = i1.getImage().getScaledInstance(1200,600,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image);

        /*setSize(1200,600);
        setLocation(200,100);*/
        setVisible(true);

        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        try {
            Thread.sleep(7000); //holds execution for 7 secs
            new Login();
            Thread.sleep(30);
            new Signup();
            setVisible(false);
        }catch (Exception e){

        }
    }

    public static void main(String[] args) {

        Splash frame = new Splash();
        int x = 1;
        for (int i = 1;i<=500;x+=7,i++){
            frame.setLocation(750-(x+i)/4,400-(i/2));
            frame.setSize(x+i,i);
            try {
                Thread.sleep(10); //controls the delay in the opening of the frame
            }catch (Exception e){

            }
        }
    }
}
