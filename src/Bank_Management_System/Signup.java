package Bank_Management_System;

import com.toedter.calendar.JDateChooser;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Signup extends JFrame implements ActionListener {
    String formNo;
   JTextField textName,textFName,textEmail,textAdd,textCity,textPin,textState;
   JDateChooser dateChooser;
   JRadioButton r1,r2,m1,m2;
   JButton next;

    Signup(){
        Random ran=new Random();
        int first4=ran.nextInt(9000)+1000;
         formNo=" "+first4;
        super("Application Form");

//         Adding Image Icon.
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/bank.png"));
        Image i2=i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(25,10,100,100);
        add(image);

// Labels
        JLabel label1=new JLabel("Application Form No."+formNo);
        label1.setBounds(160,20,600,40);
        label1.setFont(new Font("Raleway",Font.BOLD,38));
        add(label1);

//         label page1.
        JLabel label2=new JLabel("Page 1");
        label2.setFont(new Font("Raleway",Font.BOLD,18));
        label2.setBounds(350,70,300,30);
        add(label2);
// label page 3.
        JLabel label3=new JLabel("Personal Details");
        label3.setFont(new Font("Raleway",Font.BOLD,22));
        label3.setBounds(300,100,300,35);
        add(label3);

        JLabel labelName=new JLabel("Name");
        labelName.setFont(new Font("Raleway",Font.BOLD,20));
        labelName.setBounds(100,190,100,30);
        add(labelName);

        textName=new JTextField(16);
        textName.setFont(new Font("Raleway",Font.BOLD,15));
        textName.setBounds(330,190,400,30);
        add(textName);

        JLabel labelFName=new JLabel("Father's Name");
        labelFName.setFont(new Font("Raleway",Font.BOLD,20));
        labelFName.setBounds(100,240,150,30);
       add(labelFName);

       textFName =new JTextField(15);
        textFName.setFont(new Font("Raleway",Font.BOLD,15));
        textFName.setBounds(330,230,400,30);
        add( textFName);

        JLabel DOB=new JLabel("Date of Birth");
        DOB.setFont(new Font("Raleway",Font.BOLD,20));
        DOB.setBounds(100,340,200,30);
        add(DOB);

        dateChooser=new JDateChooser();
        dateChooser.setForeground(new Color(105,105,105));
        dateChooser.setBounds(330,340,400,30);
        add(dateChooser);

        JLabel labelG=new JLabel("Gender");
        labelG.setFont(new Font("Raleway",Font.BOLD,20));
        labelG.setBounds(100,290,200,30);
        add(labelG);

//         Adding radio buttons.
        r1=new JRadioButton("Male");
        r1.setFont(new Font("Raleway",Font.BOLD,15));
        r1.setBackground(new Color(222,255,228));
        r1.setBounds(330,290,100,30);
        add(r1);

        r2=new JRadioButton("Female");
        r2.setFont(new Font("Raleway",Font.BOLD,15)); // 14 bhi try karke dekho.
        r2.setBackground(new Color(222,255,228));
        r2.setBounds(480,290,100,30);
        add(r2);

        ButtonGroup buttonGroup=new ButtonGroup();
        buttonGroup.add(r1);
        buttonGroup.add(r2);

        JLabel labelEmail=new JLabel("Email");
        labelEmail.setBounds(100,390,200,30);
        labelEmail.setFont(new Font("Raleway",Font.BOLD,20));
        add(labelEmail);

        textEmail=new JTextField(15);
        textEmail.setFont(new Font("Raleway",Font.BOLD,15));
        textEmail.setBounds(330,390,400,30);
        add(textEmail);

        JLabel labelMS=new JLabel("Martail Status");
        labelMS.setFont(new Font("Raleway",Font.BOLD,20));
        labelMS.setBounds(100,440,400,30);
        add(labelMS);

        m1=new JRadioButton("Married");
        m1.setFont(new Font("Raleway",Font.BOLD,15));
        m1.setBackground(new Color(222,255,228));
        m1.setBounds(330,440,100,30);
        add(m1);

        m2=new JRadioButton("Unmarried");
        m2.setFont(new Font("Raleway",Font.BOLD,15));
        m2.setBackground(new Color(222,255,228));
        m2.setBounds(480,440,120,30);
        add(m2);

        ButtonGroup btg=new ButtonGroup();
        btg.add(m1);
        btg.add(m2);


        JLabel labelAdd=new JLabel("Address");
        labelAdd.setFont(new Font("Raleway",Font.BOLD,20));
        labelAdd.setBounds(100,490,400,30);
        add(labelAdd);

       textAdd=new JTextField(15);
      textAdd .setFont(new Font("Raleway",Font.BOLD,15));
       textAdd.setBounds(330,490,400,30);
        add(textAdd);

        JLabel labelcity=new JLabel("City:");
        labelcity.setFont(new Font("Raleway",Font.BOLD,20));
        labelcity.setBounds(100,540,400,30);
        add(labelcity);

        textCity=new JTextField(15);
        textCity.setFont(new Font("Raleway",Font.BOLD,15));
        textCity.setBounds(330,540,400,30);
        add(textCity);

        JLabel labelpincode=new JLabel("Pin Code:");
        labelpincode.setFont(new Font("Raleway",Font.BOLD,20));
        labelpincode.setBounds(100,590,400,30);
        add(labelpincode);

        textPin=new JTextField(15);
        textPin.setFont(new Font("Raleway",Font.BOLD,15));
        textPin.setBounds(330,590,400,30);
        add(textPin);

        JLabel labelState=new JLabel("State:");
        labelState.setFont(new Font("Raleway",Font.BOLD,20));
        labelState.setBounds(100,640,400,30);
        add(labelState);

        textState=new JTextField(15);
        textState.setFont(new Font("Raleway",Font.BOLD,15));
        textState.setBounds(330,640,400,30);
        add(textState);

        next=new JButton("Next");
        next.setBackground(Color.black);
        next.setBounds(620,700,80,30);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.addActionListener(this);
        add(next);


        getContentPane().setBackground(new Color(222,255,228));
        setLayout(null);
        setSize(850,800);
        setLocation(360,40);
        setUndecorated(true);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try{

            String Formno=formNo;
            String name=textName.getText();
            String fname=textFName.getText();
            String dob=((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
            String gender=null;
            if(r1.isSelected()){
                gender="male";
            }else{
                gender="female";
            }
            String email=textEmail.getText();
            String  status=null;
            if(m1.isSelected()){
                status="married";
            }else{
                status="unmarried";
            }
            String address=textAdd.getText();
            String city=textCity.getText();
            String pincode=textPin.getText();
           String state=textState.getText();

//            If blocks are blanks then show this pop
            try{
            if(textName.getText().equals("")||textFName.getText().equals("")||textAdd.getText().equals("")||
                    textEmail.getText().equals("")||textPin.getText().equals("")
            ||textState.getText().equals("") ||textCity.getText().equals("")){
                JOptionPane.showMessageDialog(null,"Fill all the fields.");
            } else{
                databaseConnection con1=new databaseConnection();
                String q="insert into Signup values('"+Formno+"', '"+name+"','"+fname+"', '"+dob+"','"+gender+"', '"+email+"','"+status+"', '"+address+"','"+city+"', '"+pincode+"','"+state+"')";
                con1.statement.executeUpdate(q);
                setVisible(false);
                new Signup2(formNo);
            }

            } catch (Exception ex) {
                ex.printStackTrace();
                throw new RuntimeException(ex);
            }
        }catch(Exception E){
            E.printStackTrace();
        }
    }

    public static void main(String[] args){

        new Signup();
    }
}
