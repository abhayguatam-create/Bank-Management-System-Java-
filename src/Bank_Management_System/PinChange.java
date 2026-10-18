package Bank_Management_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class PinChange extends JFrame implements ActionListener {
    JButton b1,b2;
    JTextField textCardNo,textPassword1,textPassword2;
    String pin;
    PinChange(String pin){
        this.pin=pin;
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/atm2(1).png"));
        Image i2=i1.getImage().getScaledInstance(1550,830,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,1550,830);
        add(image);
//         Label.
        JLabel l1=new JLabel("CHANGE YOUR PIN");
        l1.setFont(new Font("Raleway",Font.BOLD,20));
        l1.setBounds(500,160,400,35);
        l1.setForeground(Color.WHITE);
        image.add(l1);

//         Card no.
        JLabel l2=new JLabel("Card Number : ");
        l2.setFont(new Font("Raleway",Font.BOLD,15));
        l2.setBounds(420,200,200,35);
        l2.setForeground(Color.WHITE);
        image.add(l2);

        textCardNo=new JTextField();
        textCardNo.setFont(new Font("Raleway",Font.BOLD,15));
        textCardNo.setBounds(550,200,200,35);
        textCardNo.setBackground(new Color(65,125,128));
        textCardNo.setForeground(Color.WHITE);
        image.add( textCardNo);

//        password.

        JLabel l3=new JLabel("NEW PIN : ");
        l3.setFont(new Font("Raleway",Font.BOLD,15));
        l3.setBounds(420,250,200,35);
        l3.setForeground(Color.WHITE);
        image.add(l3);

        textPassword1=new JTextField();
        textPassword1.setFont(new Font("Raleway",Font.BOLD,15));
        textPassword1.setBounds(550,250,200,35);
        textPassword1.setBackground(new Color(65,125,128));
        textPassword1.setForeground(Color.WHITE);
        image.add( textPassword1);

//        Reenter password.
        JLabel l4=new JLabel("RENTER PIN : ");
        l4.setFont(new Font("Raleway",Font.BOLD,15));
        l4.setBounds(420,290,200,35);
        l4.setForeground(Color.WHITE);
        image.add(l4);

        textPassword2=new JTextField();
        textPassword2.setFont(new Font("Raleway",Font.BOLD,15));
        textPassword2.setBounds(550,290,200,35);
        textPassword2.setForeground(Color.WHITE);
        textPassword2.setBackground(new Color(65,125,128));
        image.add( textPassword2);


//         Buttons. Deposit.
        b1=new JButton("CHANGE");
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
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==b2){
            setVisible(false);
            new mainScreen(pin);
        }else {
            try {
            String cardNo=textCardNo.getText();
            String pin1=textPassword1.getText();
            String pin2=textPassword2.getText();
            if(cardNo.trim().isEmpty() || pin1.trim().isEmpty() || pin2.trim().isEmpty()){
                JOptionPane.showMessageDialog(null,"Please Fill the Details");
                return;
            }else{
                databaseConnection c=new databaseConnection();
             ResultSet resultSet =c.statement.executeQuery("select * from login where PIN='"+pin+"'");
             if(resultSet.next()){
                 String q1=resultSet.getString("Card_Number");
                 if(!q1.equals(cardNo)){
                     JOptionPane.showMessageDialog(null,"Incorrect Card Number");
                     return;
                 }
                 if(!pin1.equals(pin2)){
                     JOptionPane.showMessageDialog(null,"PIN Numbers do not match");
                     return;
                 }
                   String q2="update bank set PIN='"+pin1+"' where PIN='"+pin+"'";
                 String q3="update login set PIN='"+pin1+"' where PIN='"+pin+"'";
                 String q4="update Signupthree set PIN='"+pin1+"' where PIN='"+pin+"'";

                 c.statement.executeUpdate(q2);
                 c.statement.executeUpdate(q3);
                 c.statement.executeUpdate(q4);

                 JOptionPane.showMessageDialog(null,"PIN Changed Successfully.");
                 setVisible(false);
                 new Login(pin1);

             }
            }
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }



    }
    public static  void main(String[] args){
        new PinChange("");
    }
}
