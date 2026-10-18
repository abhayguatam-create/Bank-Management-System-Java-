package Bank_Management_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class Deposit  extends JFrame implements ActionListener {
    String pin;
    JTextField textamount;
    JButton b1,b2;
    Deposit(String pin){
        super("Bank Deposit page.");
        this.pin=pin;
//         Image set.
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/atm2(1).png"));
        Image i2=i1.getImage().getScaledInstance(1550,830,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,1550,830);
        add(image);
//         Label.
        JLabel l1=new JLabel("ENTER AMOUNT YOU WANT TO DEPOSIT");
        l1.setFont(new Font("Raleway",Font.BOLD,18));
        l1.setBounds(460,180,400,35);
        l1.setForeground(Color.WHITE);
        image.add(l1);

        textamount=new JTextField(10);
        textamount.setFont(new Font("Raleway",Font.BOLD,22));
        textamount.setBounds(440,220,400,35);
        textamount.setBackground(new Color(65,125,128));
        textamount.setForeground(Color.WHITE);
        image.add(textamount);

//         Buttons. Deposit.
        b1=new JButton("DEPOSIT");
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
    try{
            if (e.getSource() == b1) {
                String amount=textamount.getText();
                Date date=new Date();
                if(amount.trim().isEmpty()){
                    JOptionPane.showMessageDialog(null,"Please Enter a Amount You want to Deposit");
                }
                else {
                    databaseConnection c = new databaseConnection();
                    String q = "insert into bank values('" + pin + "','" + date + "','Deposit','" + amount + "')";
                    c.statement.executeUpdate(q);
                    JOptionPane.showMessageDialog(null, "Amount " + amount + " is Depoisted Sucessfully.");
                    setVisible(false);
                    new mainScreen(pin);

                }
            }else if(e.getSource()==b2){
               new mainScreen(pin);
            }

    } catch (Exception ex) {
        ex.printStackTrace();
        throw new RuntimeException(ex);
    }
    }

    public static  void main(String[] args){
        new Deposit("");
    }
}
