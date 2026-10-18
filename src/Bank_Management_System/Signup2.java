package Bank_Management_System;

import com.mysql.cj.x.protobuf.MysqlxDatatypes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Signup2 extends JFrame implements ActionListener {
   static String formNo;
   JComboBox comboBox1,comboBox2,comboBox3,comboBox4, comboBox5, comboBox6;
   JTextField textpan,textadhar;
   JRadioButton r1,r2,e1,e2;
   JButton next;
    Signup2(String formNo){
        super("This is page 2 of form");

//         Image icon.
        ImageIcon ii1=new ImageIcon(ClassLoader.getSystemResource("icon/bank.png"));
        Image ii2=ii1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon ii3=new ImageIcon(ii2);
        JLabel image=new JLabel (ii3);
        image.setBounds(25,10,100,100);
        add(image);

//         Old Form No pass karna.
//        Agar error hoga so Form name ki wajah se hoga mismatch of form name.
        this.formNo=formNo;
//        ////////////////////////////////////////////////////////////////////

        JLabel l1=new JLabel("Page 2");
        l1.setBounds(300,30,600,40);
        l1.setFont(new Font("Raleway",Font.BOLD,18));
        add(l1);

        JLabel l2=new JLabel("Addtional Details : ");
        l2.setBounds(300,60,600,40);
        l2.setFont(new Font("Raleway",Font.BOLD,18));
        add(l2);

// combobox Religion.
        JLabel l3=new JLabel("Religion : ");
        l3.setBounds(100,120,100,30);
        l3.setFont(new Font("Raleway",Font.BOLD,18));
        add(l3);

        String religion[]={"Hindu","Musliim","Sikh","Christian","Others"};
        comboBox1=new JComboBox(religion);
        comboBox1.setBackground(new Color(252,208,76));
        comboBox1.setFont(new Font("Raleway",Font.BOLD,14));
        comboBox1.setBounds(350,120,320,30);
        add(comboBox1);

//         ComboBox categpry.
        JLabel l4=new JLabel("Category : ");
        l4.setBounds(100,170,100,30);
        l4.setFont(new Font("Raleway",Font.BOLD,18));
        add(l4);

        String category[]={"General","OBC","SC","ST","Others"};
        comboBox2=new JComboBox(category);
       comboBox2.setBackground(new Color(252,208,76));
        Signup2.this.comboBox2.setFont(new Font("Raleway",Font.BOLD,14));
       Signup2.this.comboBox2.setBounds(350,170,320,30);
        add(comboBox2);

// Income Combobox.
        JLabel l5=new JLabel("Income : ");
        l5.setBounds(100,220,100,30);
        l5.setFont(new Font("Raleway",Font.BOLD,18));
        add(l5);
        String income[]={"<1,00,000","<2,00,000","<5,00,000","<10,00,000","above 10,00,000"};
        comboBox3=new JComboBox(income);
        comboBox3.setBackground(new Color(252,208,76));
        Signup2.this.comboBox3.setFont(new Font("Raleway",Font.BOLD,14));
        Signup2.this.comboBox3.setBounds(350,220,320,30);
        add(comboBox3);

//         Education.
        JLabel l6=new JLabel("Education : ");
        l6.setBounds(100,270,200,30);
        l6.setFont(new Font("Raleway",Font.BOLD,18));
        add(l6);
        String education[]={"Matrix","Intermediate","Undergraduate","PostGraduate","Doctarate","Others"};
        comboBox4=new JComboBox(education);
        comboBox4.setBackground(new Color(252,208,76));
        Signup2.this.comboBox4.setFont(new Font("Raleway",Font.BOLD,14));
        Signup2.this.comboBox4.setBounds(350,270,320,30);
        add(comboBox4);

//      Occupation.
        JLabel l7=new JLabel("Occupation : ");
        l7.setBounds(100,320,120,30);
        l7.setFont(new Font("Raleway",Font.BOLD,18));
        add(l7);
        String occupation[]={"Business","Self-Employed","Salaried","Government","unemployed","Others"};
        comboBox5=new JComboBox(occupation);
        comboBox5.setBackground(new Color(252,208,76));
        Signup2.this.comboBox5.setFont(new Font("Raleway",Font.BOLD,14));
        Signup2.this.comboBox5.setBounds(350,320,320,30);
        add(comboBox5);

//         pan number.
        JLabel l8=new JLabel("Pan Number : ");
        l8.setFont(new Font("Raleway",Font.BOLD,18));
        l8.setBounds(100,370,200,30);
        add(l8);

        textpan=new JTextField(15);
        textpan.setBounds(350,370,320,30);
        textpan.setFont(new Font("Raleway",Font.BOLD,15));
        add(textpan);
//  Adhare Number.
        JLabel l9=new JLabel("Adhar Number : ");
        l9.setFont(new Font("Raleway",Font.BOLD,18));
        l9.setBounds(100,420,200,30);
        add(l9);

        textadhar=new JTextField(15);
        textadhar.setBounds(350,420,320,30);
        textadhar.setFont(new Font("Raleway",Font.BOLD,15));
        add( textadhar);
// Senior citizen.
        JLabel l10=new JLabel("Senior Citizen : ");
        l10.setFont(new Font("Raleway",Font.BOLD,18));
        l10.setBounds(100,470,200,30);
        add(l10);

        r1=new JRadioButton("Yes");
        r1.setBounds(350,470,150,30);
        r1.setFont(new Font("Raleway",Font.BOLD,15));
        r1.setBackground(new Color(252,208,76));
        add(r1);

        r2=new JRadioButton("No");
        r2.setBounds(500,470,150,30);
        r2.setFont(new Font("Raleway",Font.BOLD,15));
        r2.setBackground(new Color(252,208,76));
        add(r2);

//         Button combine.
        ButtonGroup btn1=new ButtonGroup();
        btn1.add(r1);
        btn1.add(r2);


//         Existing Bank account.

        JLabel l11=new JLabel("Extising Account : ");
        l11.setFont(new Font("Raleway",Font.BOLD,18));
        l11.setBounds(100,520,200,30);
        add(l11);

        e1=new JRadioButton("Yes");
        e1.setBounds(350,520,150,30);
        e1.setFont(new Font("Raleway",Font.BOLD,15));
        e1.setBackground(new Color(252,208,76));
        add(e1);

        e2=new JRadioButton("No");
        e2.setBounds(500,520,150,30);
        e2.setFont(new Font("Raleway",Font.BOLD,15));
        e2.setBackground(new Color(252,208,76));
        add(e2);
//         Button combine.
        ButtonGroup btn2=new ButtonGroup();
        btn2.add(e1);
        btn2.add(e2);

//         Next button.
        next=new JButton("next");
        next.setBounds(570,640,80,30);
        next.setFont(new Font("Raleway",Font.BOLD,15));
        next.setBackground(Color.white);
        next.setForeground(Color.black);
        next.addActionListener(this);
        add( next);

//        Form Number.
        JLabel l12=new JLabel("Form No : ");
        l12.setFont(new Font("Raleway",Font.BOLD,16));
        l12.setBounds(700,10,90,30);
        add(l12);
//         Form number passing from older form.
        JLabel l13=new JLabel(formNo);
        l13.setFont(new Font("Raleway",Font.BOLD,16));
        l13.setBounds(780,10,60,30);
        add(l13);

        setLayout(null);
        setSize(850,750);
        setLocation(450,80);
        getContentPane().setBackground(new Color(252,208,76));
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String rel=(String)comboBox1.getSelectedItem();
        String  cat=(String) comboBox2.getSelectedItem();
        String inc=(String) comboBox3.getSelectedItem();
        String edu=(String) comboBox4.getSelectedItem();
        String occu=(String) comboBox5.getSelectedItem();
        String pan=textpan.getText();
        String adhar=textadhar.getText();
        String senior=null;
        if(r1.isSelected()){
            senior="Yes";
        }else{
            senior="No";
        }
        String accExist=null;
        if(e1.isSelected()){
            accExist="Yes";
        }else{
            accExist="No";
        }

        try{
            if(textadhar.getText().trim().isEmpty()|| textpan.getText().trim().isEmpty()){
                JOptionPane.showMessageDialog(null,"FIll All The Fields.");
            }else{
                databaseConnection c2=new databaseConnection();
                String q="insert into Signuptwo values('"+formNo+"', '"+rel+"','"+cat+"', '"+inc+"','"+edu+"', '"+occu+"','"+pan+"', '"+adhar+"','"+senior+"', '"+accExist+"')";
                c2.statement.executeUpdate(q);
                new Signup3(formNo);
                setVisible(false);
            }


        }catch (Exception E){
            E.printStackTrace();
        }
    }

    public static  void main(String[] args) {

//         Yaha bhi form name check karna
        new Signup2(" ");

    }
}
