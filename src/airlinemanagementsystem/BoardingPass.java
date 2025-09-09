package airlinemanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;


public class BoardingPass extends JFrame implements ActionListener{
    
    JTextField pnrbox;
    JLabel namebox,nationalitybox,destbox,sourcebox,fcodebox,lbldest,lblsource,datebox,fnamebox;
    JButton fetch,cancelbutton;
    
    BoardingPass(){
       
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading=new JLabel(" Boarding Pass ");
        heading.setBounds(330 ,10 , 500, 100);
        heading.setFont(new Font("Century Gothic", Font.BOLD, 36));
        heading.setForeground(Color.BLACK);
        add(heading);
        
        ImageIcon ic2=new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/icon/pass.png"));
        Image img = ic2.getImage();
        Image scaledImg = img.getScaledInstance(250, 300, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImg);
        JLabel lblimage=new JLabel(scaledIcon);
        lblimage.setBounds(580,90,500,300);
        add(lblimage);
        
     
        JLabel lblpnr=new JLabel(" PNR : ");
        lblpnr.setBounds(60 , 100 , 150 , 25);
        lblpnr.setFont(new Font("Times New Roman", Font.BOLD, 18));
        lblpnr.setForeground(Color.BLACK);
        add(lblpnr);
        
        pnrbox=new JTextField();
        pnrbox.setBounds(220,100,180,25);
        add(pnrbox);
        
        fetch=new JButton("Enter");
        fetch.setBackground(Color.BLACK);
        fetch.setForeground(Color.WHITE);
        fetch.setBounds(450,100,100,20);
        fetch.addActionListener(this);
        add(fetch);
        
        JLabel lblname=new JLabel(" NAME : ");
        lblname.setBounds(60 , 150 , 150 , 25);
        lblname.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblname.setForeground(Color.BLACK);
        add(lblname);
        
        namebox=new JLabel();
        namebox.setBounds(220,150,180,25);
        add(namebox);
   
        
        JLabel lblnationality=new JLabel(" NATIONALITY : ");
        lblnationality.setBounds(60 , 200 , 150 , 25);
        lblnationality.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblnationality.setForeground(Color.BLACK);
        add(lblnationality);
        
        nationalitybox=new JLabel();
        nationalitybox.setBounds(220,200,180,25);
        add(nationalitybox);
        
        JLabel lblfcode=new JLabel(" FLIGHT CODE: ");
        lblfcode.setBounds(60 , 250 , 150 , 25);
        lblfcode.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblfcode.setForeground(Color.BLACK);
        add(lblfcode);
        
        fcodebox=new JLabel();
        fcodebox.setBounds(220,250,180,25);
        add(fcodebox);
        
        JLabel lblfname=new JLabel(" FLIGHT NAME : ");
        lblfname.setBounds(420, 250 , 150 , 25);
        lblfname.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblfname.setForeground(Color.BLACK);
        add(lblfname);
        
        fnamebox=new JLabel();
        fnamebox.setBounds(580,250,100,25);
        add(fnamebox);
        
        JLabel lbljourneydate=new JLabel(" DATE : ");
        lbljourneydate.setBounds(60 , 300 , 150 , 25);
        lbljourneydate.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lbljourneydate.setForeground(Color.BLACK);
        add(lbljourneydate);
        
        datebox=new JLabel();
        datebox.setBounds(220 , 300 , 150 , 25);
        add(datebox);
        
        lblsource=new JLabel(" SOURCE: ");
        lblsource.setBounds(60 , 350 , 150 , 25);
        lblsource.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblsource.setForeground(Color.BLACK);
        add(lblsource);
        
        sourcebox=new JLabel();
        sourcebox.setBounds(220,350,100,25);
        add(sourcebox);
        
        lbldest=new JLabel(" DESTINATION: ");
        lbldest.setBounds(340, 350 , 150 , 25);
        lbldest.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lbldest.setForeground(Color.BLACK);
        add(lbldest);
        
        destbox=new JLabel();
        destbox.setBounds(500,350,100,25);
        add(destbox);
        
        
       setSize(1000,500);
       setLocation(300,150);
       setVisible(true);
        
    }
    
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==fetch){
        String pnr=pnrbox.getText();
        try{
            connectiondb c=new connectiondb();
            
            String query="SELECT * FROM reservation WHERE pnr = '"+pnr+"'";
            ResultSet res =c.s.executeQuery(query);
            if(res.next()){
                namebox.setText(res.getString("name"));
                nationalitybox.setText(res.getString("nationality"));
                fcodebox.setText(res.getString("flightcode"));
                fnamebox.setText(res.getString("flightname"));
                datebox.setText(res.getString("ddate"));
                sourcebox.setText(res.getString("src"));
                destbox.setText(res.getString("des"));
            }else{
                 JOptionPane.showMessageDialog(null,"Invalid PNR");
            }

           }   
           catch(Exception e){
            e.printStackTrace();
           }
    
    }
        
             
        }

    public static void main(String args[]){
        new BoardingPass();
    
    }
}
