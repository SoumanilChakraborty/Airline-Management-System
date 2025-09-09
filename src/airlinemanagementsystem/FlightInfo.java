package airlinemanagementsystem;


import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class FlightInfo extends JFrame {
    
    public FlightInfo(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JTable table=new JTable();
        table.setBounds(0,0,800,500);
        add(table);
        
        try{
          
          connectiondb con=new connectiondb();  
          ResultSet rs=con.s.executeQuery("SELECT * FROM flight");
          table.setModel(DbUtils.resultSetToTableModel(rs));
          
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        
        
        JScrollPane scroll=new JScrollPane(table);
        scroll.setBounds(0,0,800,500);
        add(scroll);
        
        
        setSize(800,500);
        setLocation(400,200);
        setVisible(true);
        
        
    }
    
    public static void main(String args[]){
        new FlightInfo();
    
    }
}
