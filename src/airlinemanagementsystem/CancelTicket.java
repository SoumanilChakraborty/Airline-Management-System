package airlinemanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;


public class CancelTicket extends JFrame implements ActionListener{
    
    JTextField pnrbox;
    JLabel namebox,cancellationidbox,destbox,sourcebox,fcodebox,lbldest,lblsource,datebox;
    JButton fetch,cancelbutton;
    
    CancelTicket(){
       
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading=new JLabel(" Ticket Cancellation ");
        heading.setBounds(330 ,10 , 500, 100);
        heading.setFont(new Font("Century Gothic", Font.BOLD, 36));
        heading.setForeground(Color.BLACK);
        add(heading);
        
        ImageIcon ic2=new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/icon/cancel.png"));
        Image img = ic2.getImage();
        Image scaledImg = img.getScaledInstance(250, 300, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImg);
        JLabel lblimage=new JLabel(scaledIcon);
        lblimage.setBounds(500,170,500,300);
        add(lblimage);
        
     
        JLabel lblpnr=new JLabel(" PNR : ");
        lblpnr.setBounds(60 , 100 , 150 , 25);
        lblpnr.setFont(new Font("Times New Roman", Font.BOLD, 18));
        lblpnr.setForeground(Color.BLACK);
        add(lblpnr);
        
        pnrbox=new JTextField();
        pnrbox.setBounds(220,100,180,25);
        add(pnrbox);
        
        fetch=new JButton("Show Details");
        fetch.setBackground(Color.BLACK);
        fetch.setForeground(Color.WHITE);
        fetch.setBounds(450,100,110,20);
        fetch.addActionListener(this);
        add(fetch);
        
        JLabel lblname=new JLabel(" Name : ");
        lblname.setBounds(60 , 150 , 150 , 25);
        lblname.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblname.setForeground(Color.BLACK);
        add(lblname);
        
        namebox=new JLabel();
        namebox.setBounds(220,150,180,25);
        add(namebox);
        
        
        
        JLabel lblcancellationid=new JLabel(" Cancellation ID : ");
        lblcancellationid.setBounds(60 , 200 , 150 , 25);
        lblcancellationid.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblcancellationid.setForeground(Color.BLACK);
        add(lblcancellationid);
        
        cancellationidbox=new JLabel();
        cancellationidbox.setBounds(220,200,180,25);
        add(cancellationidbox);
        
        JLabel lblfcode=new JLabel(" Flight Code: ");
        lblfcode.setBounds(60 , 250 , 150 , 25);
        lblfcode.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblfcode.setForeground(Color.BLACK);
        add(lblfcode);
        
        fcodebox=new JLabel();
        fcodebox.setBounds(220,250,180,25);
        add(fcodebox);
        
        JLabel lbljourneydate=new JLabel(" Journey Date : ");
        lbljourneydate.setBounds(60 , 300 , 150 , 25);
        lbljourneydate.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lbljourneydate.setForeground(Color.BLACK);
        add(lbljourneydate);
        
        datebox=new JLabel();
        datebox.setBounds(220 , 300 , 150 , 25);
        add(datebox);
        
        lblsource=new JLabel(" Source: ");
        lblsource.setBounds(60 , 350 , 150 , 25);
        lblsource.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblsource.setForeground(Color.BLACK);
        add(lblsource);
        
        sourcebox=new JLabel();
        sourcebox.setBounds(220,350,100,25);
        add(sourcebox);
        
        lbldest=new JLabel(" Destination: ");
        lbldest.setBounds(60 , 400 , 150 , 25);
        lbldest.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lbldest.setForeground(Color.BLACK);
        add(lbldest);
        
        destbox=new JLabel();
        destbox.setBounds(220,400,100,25);
        add(destbox);
        

       cancelbutton=new JButton("Cancel Flight");
       cancelbutton.setBackground(Color.BLACK);
       cancelbutton.setForeground(Color.WHITE);
       cancelbutton.setBounds(240,450,200,25);
       add(cancelbutton);
       cancelbutton.addActionListener(this);
       
       setSize(1000,730);
       setLocation(270,80);
       setVisible(true);
        
    }
    
    
    public void actionPerformed(ActionEvent ae){
        Random rand=new Random();
        if(ae.getSource()==fetch){
        String pnr=pnrbox.getText();
        try{
            connectiondb c=new connectiondb();
            
            String query="SELECT * FROM reservation WHERE pnr = '"+pnr+"'";
            ResultSet res =c.s.executeQuery(query);
            if(res.next()){
                namebox.setText(res.getString("name"));
                cancellationidbox.setText(""+rand.nextInt(1000));
                fcodebox.setText(res.getString("flightcode"));
                datebox.setText(res.getString("ddate"));
                sourcebox.setText(res.getString("src"));
                destbox.setText(res.getString("des"));
            }else{
                 JOptionPane.showMessageDialog(null,"Invalid PNR");
            }

        }   catch(Exception e){
            e.printStackTrace();
        }
    
        }
        else if(ae.getSource()==cancelbutton){
            String pnr=pnrbox.getText();
            String name=namebox.getText();
            String fcode=fcodebox.getText();
            String date=datebox.getText();
            String source=sourcebox.getText();
            String dest=destbox.getText();
        
        try{
            connectiondb c=new connectiondb();
            
            String query="INSERT INTO reservation VALUES('"+pnr+"','"+name+"','"+fcode+"','"+date+"','"+source+"','"+dest+"')";
            c.s.executeUpdate(query);
            c.s.executeUpdate("DELETE FROM reservation WHERE pnr='"+pnr+"'");
            JOptionPane.showMessageDialog(null,"Ticket Cancelled Successfully!");
            setVisible(false);

        }   catch(Exception e){
            e.printStackTrace();
        }
             
        }
 }

    public static void main(String args[]){
        new CancelTicket();
    
    }
}
