package airlinemanagementsystem;


import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import net.proteanit.sql.DbUtils;

public class JourneyInfo extends JFrame implements ActionListener{
    JTable table;
    JTextField pnrbox;
    JButton show;
    public JourneyInfo(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading=new JLabel(" Ticket Details ");
        heading.setBounds(270 ,20 , 500, 100);
        heading.setFont(new Font("Century Gothic", Font.BOLD, 36));
        heading.setForeground(Color.BLACK);
        add(heading);
        
        JLabel lblpnr=new JLabel("PNR Details-");
        lblpnr.setBounds(20,120,100, 50);
        add(lblpnr);
        
        pnrbox=new JTextField();
        pnrbox.setBounds(160,130,120,25);
        add(pnrbox);
        
        show=new JButton("Show Details");
        show.setBackground(Color.BLACK);
        show.setForeground(Color.WHITE);
        show.setBounds(290,130,120,25);
        show.addActionListener(this);
        add(show);
         
     
        table=new JTable();
        table.setBounds(400,350,800,100);
        add(table);
  
        
        JScrollPane scroll=new JScrollPane(table);
        scroll.setBounds(0,250,800,500);
        add(scroll);
        
        
        setSize(800,600);
        setLocation(400,150);
        setVisible(true);
        
        
    }
    public void actionPerformed(ActionEvent ae){
          String pnr=pnrbox.getText();
        
        try{
          
          connectiondb con=new connectiondb();  
          ResultSet rs=con.s.executeQuery("SELECT * FROM reservation WHERE pnr='"+pnr+"'");
          
          if(!rs.isBeforeFirst()){
              JOptionPane.showMessageDialog(null,"Invalid PNR number");
              return;
          }
          table.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    
    public static void main(String args[]){
        new JourneyInfo();
    
    }
}

