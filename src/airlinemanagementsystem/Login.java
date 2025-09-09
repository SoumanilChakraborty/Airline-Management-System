
package airlinemanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    JButton reset,submit,close;
    JTextField usernamebox;
    JPasswordField passwordbox;
    
    public Login() {
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel labelusername = new JLabel("Username");
        labelusername.setBounds(20,20,100,20);
        add(labelusername);
        
        usernamebox =new JTextField();
        usernamebox.setBounds(130,20,200,20);
        add(usernamebox);
        
        JLabel labelpassword = new JLabel("Password");
        labelpassword.setBounds(20,70,100,20);
        add(labelpassword);
        
        passwordbox =new JPasswordField();
        passwordbox.setBounds(130,70,200,20);
        add(passwordbox);
        
        reset=new JButton("Reset");
        reset.setBounds(40,120,120,20);
        reset.addActionListener(this);
        add(reset);
        
        submit=new JButton("Submit");
        submit.setBounds(190,120,120,20);
        submit.addActionListener(this);
        add(submit);
        
        close=new JButton("Close");
        close.addActionListener(this);
        close.setBounds(115,160,120,20);
        add(close);
        
        setLocation(600,250);
        setSize(400,250);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == submit){
            String username = usernamebox.getText();
            String password = new String(passwordbox.getPassword());
            
            try{
                connectiondb c=new connectiondb();
                
                String query="SELECT * FROM login WHERE username = '"+username+"' AND password = '"+password+"'";
                //DDL QUERY SO WE USE executequery
                ResultSet rs =c.s.executeQuery(query);
      
                
                if(rs.next()){
                    new Home();
                    setVisible(false);
                }else{
                    JOptionPane.showMessageDialog(null,"Invalid Username or Password");
                    setVisible(false);
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }else if(ae.getSource() == close){
            setVisible(false);
        }else if(ae.getSource() == reset){
            usernamebox.setText("");
            passwordbox.setText("");
            
        }
    }
    
    public static void main(String args[]){
        new Login();
  }
}
