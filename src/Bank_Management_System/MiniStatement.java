package Bank_Management_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class MiniStatement extends JFrame implements ActionListener {
    String pin;
    JButton btn;
    MiniStatement(String pin){
        super("This page tells that How many Transction You made.");
        this.pin=pin;


//        Label Transction data show kar rha hai.
        JLabel label1=new JLabel();
        label1.setBounds(20,100,400,300);
        add(label1);


        JLabel label2=new JLabel("YOUR TRASACTION HISTORY");
        label2.setFont(new Font("System",Font.BOLD,15));
        label2.setBounds(100,20,300,30);
        add(label2);

//         Label 3 Card Number show kar rha hai.
        JLabel label3=new JLabel();
        label3.setBounds(20,60,300,30);
        add(label3);

//         Label 4 total balance show kar rha hai.
        JLabel label4=new JLabel();
        label4.setBounds(20,400,200,30);
        add(label4);

        btn=new JButton("EXIST");
        btn.setBounds(20,500,100,25);
        btn.addActionListener(this);
        btn.setBackground(Color.BLACK);
        btn.setForeground(Color.WHITE);
        add(btn);

        try{
            databaseConnection c=new databaseConnection();
            ResultSet resultSet=c.statement.executeQuery("select * from login where PIN= '"+pin+"'");
            while(resultSet.next()){
                String cardNo=resultSet.getString("Card_Number");
                label3.setText("Card Number: "+resultSet.getString("Card_Number").substring(0,4)+"XXXX XXXX"+resultSet.getString("Card_Number").substring(12,16));

            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try {
            databaseConnection c=new databaseConnection();
            StringBuilder htmlBuilder=new StringBuilder("<HTML>");
            int balance=0;
            int counter=0;
            ResultSet resultSet=c.statement.executeQuery("select  * from bank where PIN='"+pin+"'");
            while (resultSet.next()){
                String date = resultSet.getString("Date");
                String type = resultSet.getString("Type");
                String amount = resultSet.getString("Amount");

                // Sirf top 5 transactions screen par neatly print karne ke liye
                if (counter < 8) {
                    htmlBuilder.append(date).append("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;")
                            .append(type).append("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;")
                            .append("Rs. ").append(amount).append("<br><br>");
                    counter++;
                }
                if(resultSet.getString("Type").equals("Deposit")){
                    balance+=Integer.parseInt(resultSet.getString("Amount"));
                }else{
                    balance-=Integer.parseInt(resultSet.getString("Amount"));
                }
            }

            label1.setText(htmlBuilder.toString());
            label4.setText("Your Total Balance is Rs, "+balance);

        } catch (Exception e) {
            throw new RuntimeException(e);

        }
        setLayout(null);
        setLocation(20,20);
        setSize(400,600);
        setUndecorated(true);
        getContentPane().setBackground(new Color(255,204,204));
        setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
    System.exit(0);
    }

    public static void main(String[] args){

        new MiniStatement("");
    }
}
