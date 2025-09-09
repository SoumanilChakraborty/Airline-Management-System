package airlinemanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import com.toedter.calendar.JDateChooser;
import java.util.*;


public class BookFlight extends JFrame implements ActionListener{
    
    JTextField aadharbox;
    JLabel namebox,nationalitybox,addressbox,phonebox,genderbox,fnamebox,fcodebox,lbldest,lblsource,lblfname,lblfcode,lbldate;
    JLabel lblphone,lblgender;
    JButton fetch,bookflight,checkflight;
    Choice sourcechoice,destchoice;
    JDateChooser datebox;
    
    BookFlight(){
       
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading=new JLabel(" Book your Flight ");
        heading.setBounds(330 ,20 , 500, 50);
        heading.setFont(new Font("Century Gothic", Font.BOLD, 36));
        heading.setForeground(Color.BLACK);
        add(heading);
        
        JLabel lblaadhar=new JLabel(" Aadhar No : ");
        lblaadhar.setBounds(60 , 100 , 150 , 25);
        lblaadhar.setFont(new Font("Times New Roman", Font.BOLD, 18));
        lblaadhar.setForeground(Color.BLACK);
        add(lblaadhar);
        
        aadharbox=new JTextField();
        aadharbox.setBounds(220,100,180,25);
        add(aadharbox);
        
        fetch=new JButton("Fetch User");
        fetch.setBackground(Color.BLACK);
        fetch.setForeground(Color.WHITE);
        fetch.setBounds(450,100,110,20);
        fetch.addActionListener(this);
        add(fetch);
        
        JLabel lblname=new JLabel(" Name : ");
        lblname.setBounds(60 , 150 , 150 , 25);
        lblname.setFont(new Font("Times New Roman", Font.BOLD, 18));
        lblname.setForeground(Color.BLACK);
        add(lblname);
        
        namebox=new JLabel();
        namebox.setBounds(220,150,180,25);
        add(namebox);
        
        JLabel lblnationality=new JLabel(" Nationality : ");
        lblnationality.setBounds(60 , 200 , 150 , 25);
        lblnationality.setFont(new Font("Times New Roman", Font.BOLD, 18));
        lblnationality.setForeground(Color.BLACK);
        add(lblnationality);
        
        nationalitybox=new JLabel();
        nationalitybox.setBounds(220,200,180,25);
        add(nationalitybox);
        
        JLabel lbladdress=new JLabel(" Address : ");
        lbladdress.setBounds(60 , 250 , 150 , 25);
        lbladdress.setFont(new Font("Times New Roman", Font.BOLD, 18));
        lbladdress.setForeground(Color.BLACK);
        add(lbladdress);
        
        addressbox=new JLabel();
        addressbox.setBounds(220,250,180,25);
        add(addressbox);
        
        lblgender=new JLabel(" Gender : ");
        lblgender.setBounds(60 , 300 , 150 , 25);
        lblgender.setFont(new Font("Times New Roman", Font.BOLD, 18));
        lblgender.setForeground(Color.BLACK);
        add(lblgender);
        
        genderbox=new JLabel();
        genderbox.setBounds(220 , 300 , 150 , 25);
        add(genderbox);
        
        lblphone=new JLabel(" Phone No : ");
        lblphone.setBounds(60 ,350 , 150 , 25);
        lblphone.setFont(new Font("Times New Roman", Font.BOLD, 18));
        lblphone.setForeground(Color.BLACK);
        add(lblphone);
        
        phonebox = new JLabel();
        phonebox.setBounds(220,350,180,25);
        add(phonebox);
        
        lblsource=new JLabel(" Source: ");
        lblsource.setBounds(60 , 400 , 150 , 25);
        lblsource.setFont(new Font("Times New Roman", Font.BOLD, 18));
        lblsource.setForeground(Color.BLACK);
        add(lblsource);
        
        sourcechoice=new Choice();
        sourcechoice.setBounds(220,400,100,25);
        add(sourcechoice);
        
        lbldest=new JLabel(" Destination: ");
        lbldest.setBounds(60 , 450 , 150 , 25);
        lbldest.setFont(new Font("Times New Roman", Font.BOLD, 18));
        lbldest.setForeground(Color.BLACK);
        add(lbldest);
        
        destchoice=new Choice();
        destchoice.setBounds(220,450,100,25);
        add(destchoice);
        
        try{
            connectiondb c=new connectiondb();
            String query="SELECT * FROM  flight";
            ResultSet rs=c.s.executeQuery(query);
            
            while(rs.next()){
                sourcechoice.add(rs.getString("source"));
                destchoice.add(rs.getString("destination"));
            }
            
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
       checkflight=new JButton("Fetch Flights");
       checkflight.setBackground(Color.BLACK);
       checkflight.setForeground(Color.WHITE);
       checkflight.setBounds(340,450,100,25);
       add(checkflight);
       checkflight.addActionListener(this);
       
       lblfname=new JLabel(" Flight Name: ");
       lblfname.setBounds(60 , 500 , 150 , 25);
       lblfname.setFont(new Font("Times New Roman", Font.BOLD, 18));
       lblfname.setForeground(Color.BLACK);
       add(lblfname);
        
       fnamebox=new JLabel();
       fnamebox.setBounds(220,500,180,25);
       add(fnamebox);
       
       lblfcode=new JLabel(" Flight Code: ");
       lblfcode.setBounds(60 , 550 , 150 , 25);
       lblfcode.setFont(new Font("Times New Roman", Font.BOLD, 18));
       lblfcode.setForeground(Color.BLACK);
       add(lblfcode);
        
       fcodebox=new JLabel();
       fcodebox.setBounds(220,550,180,25);
       add(fcodebox);
       
       lbldate=new JLabel(" Date : ");
       lbldate.setBounds(60 , 600 , 150 , 25);
       lbldate.setFont(new Font("Times New Roman", Font.BOLD, 18));
       lbldate.setForeground(Color.BLACK);
       add(lbldate);
        
       datebox =new JDateChooser();
       datebox.setBounds(220,600,180,25);
       add(datebox);
      
       ImageIcon ic2=new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/icon/bookflighticon.png"));
       Image img = ic2.getImage();
       Image scaledImg = img.getScaledInstance(500, 300, Image.SCALE_SMOOTH);
       ImageIcon scaledIcon = new ImageIcon(scaledImg);
       JLabel lblimage=new JLabel(scaledIcon);
       lblimage.setBounds(450,170,500,300);
       add(lblimage);
        
       bookflight=new JButton("Book Flight");
       bookflight.setBackground(Color.BLACK);
       bookflight.setForeground(Color.WHITE);
       bookflight.setBounds(450,600,100,25);
       add(bookflight);
       bookflight.addActionListener(this);
        
       setSize(1000,730);
       setLocation(270,80);
       setVisible(true);
        
    }
    
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==fetch){
        String aadhar=aadharbox.getText();
        try{
            connectiondb c=new connectiondb();
            
            String query="SELECT * FROM passenger WHERE aadhar = '"+aadhar+"'";
            ResultSet res =c.s.executeQuery(query);
            if(res.next()){
                namebox.setText(res.getString("name"));
                nationalitybox.setText(res.getString("nationality"));
                addressbox.setText(res.getString("address"));
                phonebox.setText(res.getString("phone"));
                genderbox.setText(res.getString("gender"));
            
            }else{
                 JOptionPane.showMessageDialog(null,"User is not registered!");
            }

        }   catch(Exception e){
            e.printStackTrace();
        }
    
        }else if(ae.getSource()==checkflight){
        String src=sourcechoice.getSelectedItem();
        String des=destchoice.getSelectedItem();
        
        try{
            connectiondb c=new connectiondb();
            
            String query="SELECT * FROM flight WHERE source = '"+src+"' AND destination = '"+des+"'";
            ResultSet res =c.s.executeQuery(query);
            if(res.next()){
                fnamebox.setText(res.getString("f_name"));
                fcodebox.setText(res.getString("f_code"));
            }else{
                 JOptionPane.showMessageDialog(null,"No flights available for the given Source and Destination!");
            }

        }   catch(Exception e){
            e.printStackTrace();
        }
            
        
        }else{
             Random random=new Random();
            
             String aadhar =aadharbox.getText();
             String name =namebox.getText();
             String nationality=nationalitybox.getText();
             String flightname=fnamebox.getText();
             String flightcode=fcodebox.getText();;
             String src=sourcechoice.getSelectedItem();
             String des=destchoice.getSelectedItem();
             String d_date=((JTextField)datebox.getDateEditor().getUiComponent()).getText();
        
            try{
                connectiondb c=new connectiondb();
            
                String query="INSERT INTO reservation VALUES ('"+random.nextInt(10000)+"','TIC-"+random.nextInt(1000)+"','"+aadhar+"','"+name+"','"+nationality+"','"+flightname+"','"+flightcode+"', '"+src+"','"+des+"','"+d_date+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Ticket Booked Successfully");
                setVisible(false);
                }   catch(Exception e){
                    e.printStackTrace();
                }         
             
        }
 }

    public static void main(String args[]){
        new BookFlight();
    
    }
}