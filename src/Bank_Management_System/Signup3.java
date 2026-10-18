package Bank_Management_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Signup3 extends JFrame implements ActionListener {
    JRadioButton r1,r2,r3,r4;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    JButton s,c;
    static String formNo;
     public Signup3(String formNo){
         super("Application Form: Page NO 3");
         this.formNo=formNo;
         ImageIcon ii1=new ImageIcon(ClassLoader.getSystemResource("icon/bank.png"));
         Image ii2=ii1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
         ImageIcon ii3=new ImageIcon(ii2);
         JLabel image=new JLabel (ii3);
         image.setBounds(25,10,100,100);
         add(image);

//          label1
         JLabel l1=new JLabel("Page 3");
         l1.setBounds(280,40,400,40);
         l1.setFont(new Font("Raleway",Font.BOLD,22));
         add(l1);

//         label 2
         JLabel l2=new JLabel("Account Details : ");
         l2.setBounds(280,70,300,40);
         l2.setFont(new Font("Raleway",Font.BOLD,22));
         add(l2);

//          label 3
         JLabel l3=new JLabel("Account Type : ");
         l3.setBounds(100,140,200,30);
         l3.setFont(new Font("Raleway",Font.BOLD,18));
         add(l3);
//      Radio buttons.
         r1=new JRadioButton("Saving Account");
         r1.setFont(new Font("Raleway",Font.BOLD,15));
         r1.setBounds(100,190,150,30);
         r1.setBackground(new Color(215,252,252));
         add(r1);

         r2=new JRadioButton("Fixed Depoist Account ");
         r2.setFont(new Font("Raleway",Font.BOLD,15));
         r2.setBounds(400,190,350,30);
         r2.setBackground(new Color(215,252,252));
         add(r2);

         r3=new JRadioButton("Current Acccount");
         r3.setFont(new Font("Raleway",Font.BOLD,15));
         r3.setBounds(100,230,250,30);
         r3.setBackground(new Color(215,252,252));
         add(r3);

         r4=new JRadioButton("Recurring Deposit Account");
         r4.setFont(new Font("Raleway",Font.BOLD,15));
         r4.setBounds(400,230,350,30);
         r4.setBackground(new Color(215,252,252));
         add(r4);

         ButtonGroup btn=new ButtonGroup();
         btn.add(r1);
         btn.add(r2);
         btn.add(r3);
         btn.add(r4);

//          Label 4.
         JLabel l4=new JLabel("Card Number");
         l4.setFont(new Font("Raleway",Font.BOLD,18));
         l4.setBounds(100,280,250,30);
         add(l4);

         JLabel l5=new JLabel("(Your 16-digit Card Number)");
         l5.setFont(new Font("Raleway",Font.BOLD,12));
         l5.setBounds(100,310,250,30);
         add(l5);

         JLabel l6=new JLabel("XXXX-XXXX-XXXX-4861");
         l6.setFont(new Font("Raleway",Font.BOLD,18));
         l6.setBounds(330,280,250,30);
         add(l6);

         JLabel l7=new JLabel("(It would appear on atm card/cheque Book and Statements)");
         l7.setFont(new Font("Raleway",Font.BOLD,12));
         l7.setBounds(330,310,350,30);
         add(l7);

         JLabel l8=new JLabel("PIN :");
         l8.setFont(new Font("Raleway",Font.BOLD,18));
         l8.setBounds(100,360,250,30);
         add(l8);

         JLabel l9=new JLabel("XXXX ");
         l9.setFont(new Font("Raleway",Font.BOLD,18));
         l9.setBounds(330,360,250,30);
         add(l9);

         JLabel l10=new JLabel("(4-digit Password)");
         l10.setFont(new Font("Raleway",Font.BOLD,12));
         l10.setBounds(100,380,250,30);
         add(l10);

         JLabel l11=new JLabel("Services Required :");
         l11.setFont(new Font("Raleway",Font.BOLD,18));
         l11.setBounds(100,430,250,30);
         add(l11);
//          check boxs.
         c1=new JCheckBox("ATM CARD");
         c1.setFont(new Font("Raleway",Font.BOLD,14));
         c1.setBackground(new Color(215,252,252));
         c1.setBounds(100,480,200,30);
         add(c1);

         c2=new JCheckBox("Internet Banking");
         c2.setFont(new Font("Raleway",Font.BOLD,14));
         c2.setBackground(new Color(215,252,252));
         c2.setBounds(330,480,400,30);
         add(c2);

         c3=new JCheckBox("Mobile Banking");
         c3.setFont(new Font("Raleway",Font.BOLD,14));
         c3.setBackground(new Color(215,252,252));
         c3.setBounds(100,530,200,30);
         add(c3);

         c4=new JCheckBox("Emails ALerts");
         c4.setFont(new Font("Raleway",Font.BOLD,14));
         c4.setBackground(new Color(215,252,252));
         c4.setBounds(330,530,400,30);
         add(c4);

         c5=new JCheckBox("Cheque Book");
         c5.setFont(new Font("Raleway",Font.BOLD,14));
         c5.setBackground(new Color(215,252,252));
         c5.setBounds(100,580,200,30);
         add(c5);

         c6=new JCheckBox("E-Statement");
         c6.setFont(new Font("Raleway",Font.BOLD,14));
         c6.setBackground(new Color(215,252,252));
         c6.setBounds(330,580,400,30);
         add(c6);

         c7=new JCheckBox("I here by decleares that the above entered details correct to the best of my Knowledge.");
         c7.setFont(new Font("Raleway",Font.BOLD,12));
         c7.setBackground(new Color(215,252,252));
         c7.setBounds(100,660,600,30);
         add(c7);

         JLabel l12=new JLabel("Form No :");
         l12.setFont(new Font("Raleway",Font.BOLD,18));
         l12.setBounds(680,10,100,30);
         add(l12);

         JLabel l13=new JLabel(/*formno*/ formNo); // yeh form Number yaha baad me aayega
         l13.setFont(new Font("Raleway",Font.BOLD,16));
         l13.setBounds(770,10,100,30);
         add(l13);

         s=new JButton("Submit");
         s.setFont(new Font("Raleway",Font.BOLD,14));
         s.setBounds(260,720,100,30);
         s.setForeground(Color.WHITE);
         s.addActionListener(this);
         s.setBackground(Color.black);
         add(s);

         c=new JButton("Cancel");
         c.setFont(new Font("Raleway",Font.BOLD,14));
         c.setBounds(420,720,100,30);
         c.setForeground(Color.WHITE);
         c.addActionListener(this);
         c.setBackground(Color.black);
         add(c);

         setSize(850,800);
        setLocation(400,20);
        getContentPane().setBackground(new Color(215,252,252));
        setLayout(null);
         setUndecorated(true);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
         String accType=null;
         if(r1.isSelected()){
             accType="Saving Account";
         } else if (r2.isSelected()) {
             accType="Fixed Depoist Account";
         }else if(r3.isSelected()){
             accType="Current Account";
         } else if (r4.isSelected()) {
             accType="Recurring Deposit Account";
         }

         Random ran=new Random();
        String cardNo = "" + Math.abs(
                (ran.nextLong() % 90000000L) + 5040936000000000L
        );

         int first4=ran.nextInt(9000)+1000;
         String pin=""+first4;

         String services=" ";
         if(c1.isSelected()){
             services+=c1.getText()+"   ";
         }if(c2.isSelected()){
            services+=c2.getText()+"   ";
        }if(c3.isSelected()){
            services+=c3.getText()+"   ";
        }if(c4.isSelected()){
            services+=c4.getText()+"   ";
        }if(c5.isSelected()){
            services+=c5.getText()+"   ";
        }if(c6.isSelected()){
            services+=c6.getText()+"   ";
        }

        try {
            if(e.getSource()==s) {
                if (accType==null) {
                    JOptionPane.showMessageDialog(null, "Fill the Details");
                }else if(!c7.isSelected()){
                    JOptionPane.showMessageDialog(null, "Please check the declaration Box.");
                }
                else {
                    databaseConnection c3 = new databaseConnection();
                    databaseConnection c4 = new databaseConnection();
                    String q1 = "insert into Signupthree values('" + formNo + "','" + accType + "','" + cardNo + "','" + first4 + "','" + services + "')";
                    String q2 = "insert into login values ('" + formNo + "','" + cardNo + "','" + pin + "')";
                    c3.statement.executeUpdate(q1);
                    c4.statement.executeUpdate(q2);
                    JOptionPane.showMessageDialog(null,"Card Number:  "+cardNo+" \n"+"Pin:  "+pin);
                    setVisible(false);
                    new Deposit(pin);

                }
            }else if(e.getSource()==c){
                System.exit(0);
            }
        }catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    public  static  void main(String[] args){

         new Signup3("");
    }
}
