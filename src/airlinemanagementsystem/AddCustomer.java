
package airlinemanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class AddCustomer extends JFrame implements ActionListener{
    
    JTextField namebox,nationalitybox,aadharbox,addressbox,phonebox;
    JRadioButton rbmale,rbfemale;  
    AddCustomer(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading=new JLabel("Add Customer Details : ");
        heading.setBounds(240 ,50 , 500, 35);
        heading.setFont(new Font("Century Gothic", Font.BOLD, 36));
        heading.setForeground(Color.BLACK);
        add(heading);
        
        JLabel lblname=new JLabel(" Name : ");
        lblname.setBounds(60 , 115 , 150 , 25);
        lblname.setFont(new Font("Times New Roman", Font.BOLD, 18));
        lblname.setForeground(Color.BLACK);
        add(lblname);
        
        namebox=new JTextField();
        namebox.setBounds(220,115,180,25);
        add(namebox);
        
        JLabel lblnationality=new JLabel(" Nationality : ");
        lblnationality.setBounds(60 , 150 , 150 , 25);
        lblnationality.setFont(new Font("Times New Roman", Font.BOLD, 18));
        lblnationality.setForeground(Color.BLACK);
        add(lblnationality);
        
        nationalitybox=new JTextField();
        nationalitybox.setBounds(220,150,180,25);
        add(nationalitybox);
        
        JLabel lblaadhar=new JLabel(" Aadhar No : ");
        lblaadhar.setBounds(60 , 185 , 150 , 25);
        lblaadhar.setFont(new Font("Times New Roman", Font.BOLD, 18));
        lblaadhar.setForeground(Color.BLACK);
        add(lblaadhar);
        
        aadharbox=new JTextField();
        aadharbox.setBounds(220,185,180,25);
        add(aadharbox);
        
        JLabel lbladdress=new JLabel(" Address : ");
        lbladdress.setBounds(60 , 220 , 150 , 25);
        lbladdress.setFont(new Font("Times New Roman", Font.BOLD, 18));
        lbladdress.setForeground(Color.BLACK);
        add(lbladdress);
        
        addressbox=new JTextField();
        addressbox.setBounds(220,220,180,25);
        add(addressbox);
        
        JLabel lblgender=new JLabel(" Gender : ");
        lblgender.setBounds(60 , 255 , 150 , 25);
        lblgender.setFont(new Font("Times New Roman", Font.BOLD, 18));
        lblgender.setForeground(Color.BLACK);
        add(lblgender);
        
        rbmale = new JRadioButton("Male");
        rbmale.setBackground(Color.WHITE);
        rbmale.setBounds(220,255,90,25);
        add(rbmale);
        
        rbfemale = new JRadioButton("Female");
        rbfemale.setBackground(Color.WHITE);
        rbfemale.setBounds(320,255,90,25);
        add(rbfemale);
        
        //for chosing only one option out of 2
        ButtonGroup gendergrp=new ButtonGroup();
        gendergrp.add(rbmale);
        gendergrp.add(rbfemale);
        
        JLabel lblphone=new JLabel(" Phone No : ");
        lblphone.setBounds(60 , 290 , 150 , 25);
        lblphone.setFont(new Font("Times New Roman", Font.BOLD, 18));
        lblphone.setForeground(Color.BLACK);
        add(lblphone);
        
        phonebox = new JTextField();
        phonebox.setBounds(220,290,180,25);
        add(phonebox);
        
        JButton save=new JButton("Save");
        save.setBackground(Color.BLACK);
        save.setForeground(Color.WHITE);
        save.setBounds(220,330,180,30);
        add(save);
        save.addActionListener(this);
        
        
        ImageIcon ic2=new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/icon/emp3.jpg"));
        Image img = ic2.getImage();
        Image scaledImg = img.getScaledInstance(500, 300, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImg);
        JLabel lblimage=new JLabel(scaledIcon);
        lblimage.setBounds(400,100,500,300);
        add(lblimage);
        
        setSize(900,600);
        setLocation(300,150);
        setVisible(true);
        
           
    }
    
    
    public void actionPerformed(ActionEvent ae){
        
        String name=namebox.getText();
        String nationality=nationalitybox.getText();
        String aadhar=aadharbox.getText();
        String address=addressbox.getText();
        String phone=phonebox.getText();
        
//        phonebox.addKeyListener(new KeyAdapter() {
//        public void keyTyped(KeyEvent e) {
//        if (phonebox.getText().length() >= 10) {
//            e.consume(); // block further typing
//            JOptionPane.showMessageDialog(null, "Phone no. can't exceed 10 digits");
//        }
//        if (!Character.isDigit(e.getKeyChar())) {
//            e.consume(); // allow only digits
//        }
//    }
//    });
        
        String gender=null;
        if(rbmale.isSelected()){
            gender="Male";
        }else{
            gender="Female";
        }
        try{
            connectiondb c=new connectiondb();
            
            String query="INSERT INTO passenger VALUES('"+name+"', '"+nationality+"', '"+phone+"', '"+address+"', '"+aadhar+"', '"+gender+"' )";
            c.s.executeUpdate(query);
            JOptionPane.showMessageDialog(null,"Customer Details Added Sucessfully!");
            setVisible(false);

        }   catch(Exception e){
            e.printStackTrace();
        }
    
    }
    
    public static void main(String args[]){
        new AddCustomer();
    
    }
}
