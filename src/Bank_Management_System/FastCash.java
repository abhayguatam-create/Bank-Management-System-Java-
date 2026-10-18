package Bank_Management_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener {
    JButton b1,b2,b3,b4,b5,b6,b7;
    String pin;
    FastCash(String pin){
    this.pin=pin;

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/atm2(1).png"));
        Image i2=i1.getImage().getScaledInstance(1550,830,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,1550,830);
        add(image);

        JLabel l1=new JLabel("ENTER WITHDRAWAL AMOUNT");
        l1.setFont(new Font("SYstem",Font.BOLD,20));
        l1.setBounds(450,180,700,35);
        l1.setForeground(Color.WHITE);
        image.add(l1);

//         Buttons.
        b1=new JButton("RS, 100");
        b1.setBounds(410,274,150,35);
        b1.setBackground(new Color(65,125,128));
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        image.add(b1);

        b2=new JButton("RS, 500");
        b2.setBounds(700,274,150,35);
        b2.setBackground(new Color(65,125,128));
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        image.add(b2);

        b3=new JButton("RS, 1000");
        b3.setBounds(410,318,150,35);
        b3.setBackground(new Color(65,125,128));
        b3.setForeground(Color.WHITE);
        b3.addActionListener(this);
        image.add(b3);

        b4=new JButton("RS, 2000");
        b4.setBounds(700,318,150,35);
        b4.setBackground(new Color(65,125,128));
        b4.setForeground(Color.WHITE);
        b4.addActionListener(this);
        image.add(b4);

        b5=new JButton("RS, 5000");
        b5.setBounds(410,362,150,35);
        b5.setBackground(new Color(65,125,128));
        b5.setForeground(Color.WHITE);
        b5.addActionListener(this);
        image.add(b5);

        b6=new JButton("RS, 10000");
        b6.setBounds(700,362,150,35);
        b6.setBackground(new Color(65,125,128));
        b6.setForeground(Color.WHITE);
        b6.addActionListener(this);
        image.add(b6);

        b7=new JButton("BACK");
        b7.setBounds(700,406,150,35);
        b7.setBackground(new Color(65,125,128));
        b7.setForeground(Color.WHITE);
        b7.addActionListener(this);
        image.add(b7);

        setLayout(null);
        setSize(1550,1080);
        setLocation(0,0);
        setUndecorated(true);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b7) {
            setVisible(false);
            new mainScreen(pin);
        } else {
            try {
                databaseConnection c=new databaseConnection();
                Date date=new Date();
                String amount=((JButton)e.getSource()).getText().substring(4);
                ResultSet resultSet=c.statement.executeQuery("select * from bank where PIN='"+pin+"'");
                int balance=0;
                while (resultSet.next()){
                    if(resultSet.getString("Type").equals("Deposit")){
                        balance+=Integer.parseInt(resultSet.getString("Amount"));
                    }else{
                        balance-=Integer.parseInt(resultSet.getString("Amount"));
                    }
                }
                if(e.getSource()!=b7 && balance>=Integer.parseInt(amount)){
                    balance-=Integer.parseInt(amount);
                    c.statement.executeUpdate("insert into bank values('" + pin + "','" + date + "','Withdrawn','" + amount + "')");
                    JOptionPane.showMessageDialog(null,amount+" Debited Sucessfully");
                    setVisible(false);
                    new mainScreen(pin);
                }else{
                    JOptionPane.showMessageDialog(null,"Insufficient Balance.");
                    return;
                }

            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    public static  void main(String[] args){
        new FastCash(" ");
    }
}
