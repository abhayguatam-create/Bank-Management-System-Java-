package Bank_Management_System;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class Withdrawl extends JFrame  implements ActionListener {
    JButton b1,b2;
    JTextField textamount;
    String pin;
    Withdrawl(String pin) {
     this.pin=pin;
        super("This is Withdrwal Page.");

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/atm2(1).png"));
        Image i2=i1.getImage().getScaledInstance(1550,830,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,1550,830);
        add(image);
//         Label.

        JLabel l1=new JLabel("MAXIMUM WITHDRAWL IS RS,10,000");
        l1.setFont(new Font("Raleway",Font.BOLD,18));
        l1.setBounds(460,180,400,35);
        l1.setForeground(Color.WHITE);
        image.add(l1);



        JLabel l2=new JLabel("PLEASE ENTER YOUR AMOUNT");
        l2.setFont(new Font("Raleway",Font.BOLD,18));
        l2.setBounds(460,220,400,35);
        l2.setForeground(Color.WHITE);
        image.add(l2);

        textamount=new JTextField(10);
        textamount.setFont(new Font("Raleway",Font.BOLD,22));
        textamount.setBounds(440,260,400,35);
        textamount.setBackground(new Color(65,125,128));
        textamount.setForeground(Color.WHITE);
        image.add(textamount);

//         Buttons. Deposit.
        b1=new JButton("WITHDRAWN");
//        b1.setFont(new Font("Raleway",Font.BOLD,22));
        b1.setBounds(700,362,150,35);
        b1.setBackground(new Color(65,125,128));
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        image.add(b1);

        b2=new JButton("BACK");
//        b2.setFont(new Font("Raleway",Font.BOLD,22));
        b2.setBounds(700,406,150,35);
        b2.setBackground(new Color(65,125,128));
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        image.add(b2);


        setLayout(null);
        setSize(1550,1000);
        setLocation(0,0);
        setUndecorated(true);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

//         brain of Bank System.
        try{
            String amount=textamount.getText();
            Date date=new Date();
            if(e.getSource()==b2){
                setVisible(false);
                new mainScreen(pin);
            }

            else {
                if(Integer.parseInt(amount)>10000){
                    JOptionPane.showMessageDialog(null,"Please Enter a Valid amount");
                    return;
                }
                else if (e.getSource() == b1) {
                    if(textamount.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Please Enter a Amount");
                    }
                    databaseConnection c = new databaseConnection();
                    ResultSet resultSet = c.statement.executeQuery("select * from bank where PIN='" + pin + "'");
                    int balance = 0;
                    while (resultSet.next()) { // agar pin match kar gaya so yeh work karo.
                        if (resultSet.getString("Type").equals("Deposit")) {
                            balance += Integer.parseInt(resultSet.getString("Amount"));
                        } else  {
                            balance -= Integer.parseInt(resultSet.getString("Amount"));
                        }
                    }

//                 Total balacne ab tak kaa jo maine While Loop se nikala hai Vo variable balance me store hai.
                    if (balance< Integer.parseInt(amount)) {
                        JOptionPane.showMessageDialog(null, "Insufficient Balance.");
                        return;
                    }
                    balance-=Integer.parseInt(amount);
                    c.statement.executeUpdate("insert into bank values('" + pin + "','" + date + "','Withdrawn','" + amount + "')");
                    JOptionPane.showMessageDialog(null, amount+" Debited Sucessfully.");
                    setVisible(false);
                    new mainScreen(pin);



                }
            }
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public static  void main(String[] args){
        new Withdrawl("");
    }

}
