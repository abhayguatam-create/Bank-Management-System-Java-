package Bank_Management_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class BalanceEquiry extends JFrame implements ActionListener {
    String pin;
    JButton b1;
    JLabel l2;
    BalanceEquiry(String pin) {
        super("This pages shows Yours Current Balance.");
        this.pin = pin;



            ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm2(1).png"));
            Image i2 = i1.getImage().getScaledInstance(1550, 830, Image.SCALE_DEFAULT);
            ImageIcon i3 = new ImageIcon(i2);
            JLabel image = new JLabel(i3);
            image.setBounds(0, 0, 1550, 830);
            add(image);
//         Label.

            JLabel l1 = new JLabel("YOUR CURRENT BALANCE IS : ");
            l1.setFont(new Font("Raleway", Font.BOLD, 18));
            l1.setBounds(420, 180, 400, 35);
            l1.setForeground(Color.WHITE);
            image.add(l1);

//            Total Amount show wala label.
        l2=new JLabel();
        l2.setFont(new Font("Raleway", Font.BOLD, 22));
        l2.setBounds(450, 220, 400, 35);
        l2.setForeground(Color.WHITE);
        image.add(l2);

//         Buttons. .
            b1 = new JButton("BACK");
        b1.setFont(new Font("Raleway",Font.BOLD,18));
            b1.setBounds(700, 362, 120, 35);
            b1.setBackground(new Color(65, 125, 128));
            b1.setForeground(Color.WHITE);
            b1.addActionListener(this);
            image.add(b1);


        int balance=0;
        try{
            databaseConnection c=new databaseConnection();
                ResultSet resultSet= c.statement.executeQuery("select * from bank where PIN='"+pin+"'");
                while(resultSet.next()){
                    if(resultSet.getString("Type").equals("Deposit")){
                        balance+=Integer.parseInt(resultSet.getString("Amount"));
                    } else if (resultSet.getString("Type").equals("Withdrawn")) {
                        balance-=Integer.parseInt(resultSet.getString("Amount"));
                    }
            }
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        l2.setText(""+balance);
        setLayout(null);
        setSize(1550, 1000);
        setLocation(0, 0);
        setUndecorated(true);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b1){
            setVisible(false);
            new mainScreen(pin);

        }
    }
    public static  void main(String[] args){

        new BalanceEquiry("");
    }
}
