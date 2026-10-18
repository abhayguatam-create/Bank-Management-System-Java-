package Bank_Management_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;


// Jframe extends se swing import hota hai jo ki GUI application ki liye hai Yeh AWT se beeter hai and modern hai.
// Action Listerner se ham Buttons par kya action perform ho rha hai Detect kar usse perform karnege.
public class Login  extends JFrame implements ActionListener {

// Global Variable.
   JLabel label1;
   JLabel label2;
   JLabel label3;

JTextField textField;
JPasswordField passwordField;

JButton button1,button2,button3;

String pin1;
//     Default Constructor.
    Login(String pin1){
//        Super constructor ki neeche sabse top par rhenga becuase hai doo kaam kar rha hai . Parent constructor ko call laga rha hai and Title set kar rha hai.
        super("Bank Management System");
        this.pin1=pin1;

//         Adding icon1.
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/bank.png"));
        Image i2=i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(350,10,100,100);
        add(image);

//         Adding icon2.
        ImageIcon ii1=new ImageIcon(ClassLoader.getSystemResource("icon/card.png"));
        Image ii2=ii1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon ii3=new ImageIcon(ii2);
        JLabel iimage=new JLabel(ii3);
        iimage.setBounds(630,350,100,100);
        add(iimage);

       // Setting Labels. ham isse icon2 ki neeche set kar rhe hai because hamne setlayout =null kiya hai order maintian importsnt hai. Ab hamare pass power hai soo Ham cheeze apne according kar rhe hai.
//         labels vo hai jo hame Jframe par text likhne dete hai

        label1=new JLabel("Welcome to Gautam's Bank");
        label1.setBounds(230,125,550,40);
        label1.setFont(new Font("AvantGrade",Font.BOLD,38));
        label1.setForeground(Color.WHITE);
        add(label1);

//         Enter card number Label.
        label2 =new JLabel("Card No:");
        label2.setFont(new Font("AvantGrade",Font.BOLD,28));
        label2.setForeground(Color.WHITE);
        label2.setBounds(150,190,400,30);
        add(label2);

//         Entering card number (means Text field)
        textField=new JTextField(16);
        textField.setFont(new Font("Arial",Font.BOLD,14));
        textField.setBounds(340,190,230,30);
        add(textField);


//         Enter pin.
        label3=new JLabel("Enter Pin:");
        label3.setForeground(Color.WHITE);
        label3.setBounds(150,250,430,30);
        label3.setFont(new Font("AvantGrade",Font.BOLD,28));
        add(label3);

//         Entering Passowrd field.
        passwordField =new JPasswordField(16);
        passwordField.setBounds(340,250,230,30);
        passwordField.setFont(new Font("Arial",Font.BOLD,14));
        add(passwordField);

//         Sign In button
        button1=new JButton("Sign In");
        button1.setFont(new Font("Arail",Font.BOLD,14));
        button1.setForeground(Color.WHITE);
        button1.setBackground(Color.BLACK);
        button1.setBounds(300,300,100,25);
        button1.addActionListener(this);
        add(button1);

//         Clear button.
        button2=new JButton("Clear");
        button2.setFont(new Font("Arial",Font.BOLD,14));
        button2.setForeground(Color.WHITE);
        button2.setBackground(Color.BLACK);
        button2.setBounds(460,300,100,25);
        button2.addActionListener(this);
        add(button2);

//         Sign Up button.
        button3=new JButton("Sign Up");
        button3.setForeground(Color.WHITE);
        button3.setBackground(Color.BLACK);
        button3.setFont(new Font("Arial",Font.BOLD,14));
        button3.setBounds(300,350,250,25);
        button3.addActionListener(this);
        add(button3);


//         Adding icon3.
        ImageIcon iii1=new ImageIcon(ClassLoader.getSystemResource("icon/backbg.png"));
        Image iii2=iii1.getImage().getScaledInstance(850,480,Image.SCALE_DEFAULT);
        ImageIcon iii3=new ImageIcon(iii2);
        JLabel iiimage=new JLabel(iii3);
        iiimage.setBounds(0,0,850,480);
        add(iiimage);


        setLayout(null);
        setSize(850,480);
        setLocation(450,200);
        setUndecorated(true);
        setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent e){
try{
    if(e.getSource()==button1){
        databaseConnection c=new databaseConnection();
        String cardno=textField.getText();
        String pin=passwordField.getText();
        String q="select * from login where Card_Number='"+cardno+"' and PIN='"+pin+"'";
        ResultSet resultSet=c.statement.executeQuery(q);
        if(resultSet.next()){
            setVisible(false);
            new mainScreen(pin);
        }else{
            JOptionPane.showMessageDialog(null,"Incorrect Pin or Card Number");
        }

    } else if (e.getSource()==button2) {
        textField.setText("");
        passwordField.setText("");
    } else{
        new Signup();
    }
}catch (Exception E){
    E.printStackTrace(); // Ab yeh bata dega ki error kis wajah se aa rha hai.
}
    }

    public static  void main(String[] args){

        Login Abhay=new Login("");
    }
}
