package airlinemanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;



public class Home extends JFrame implements ActionListener {
    
    public Home() {
        setLayout(null);
        ImageIcon ic1=new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/icon/homepage3.jpg"));
         JLabel image=new JLabel(ic1);
         image.setBounds(0, 0, 1920, 1080);     
         add(image);
         
         JPanel headingBar = new JPanel();
         headingBar.setBackground(Color.BLACK);
         headingBar.setBounds(0, 0, 1920, 90); // Full width, height ~80px
         headingBar.setLayout(null); // So we can position the label manually
         image.add(headingBar);
         
         JLabel heading=new JLabel("- Welcome to Airline Management System -");
         heading.setBounds(430,20,1000,90);
         heading.setForeground(Color.WHITE);
         heading.setFont(new Font("Book Antiqua", Font.BOLD, 36));
         headingBar.add(heading);   
         
         JMenuBar menubar=new JMenuBar();
         setJMenuBar(menubar);
         
         JMenu details = new JMenu("Deatils");
         menubar.add(details);
         
         JMenuItem flightdetails=new JMenuItem("Flight Details");
         flightdetails.addActionListener(this);
         details.add(flightdetails);
         
         JMenuItem customerdetails=new JMenuItem("Add Customer Details");
         customerdetails.addActionListener(this);
         details.add(customerdetails);
         
         JMenuItem bookflight=new JMenuItem("Book Flight");
         bookflight.addActionListener(this);
         details.add(bookflight);
         
         JMenuItem journeydetails=new JMenuItem("Journey Details");
         journeydetails.addActionListener(this);
         details.add(journeydetails);
         
         JMenuItem ticketCancellation=new JMenuItem("Cancel Ticket");
         ticketCancellation.addActionListener(this);
         details.add(ticketCancellation);
         
         JMenu Ticket = new JMenu("Ticket");
         menubar.add(Ticket);
         
         JMenuItem boardingpass = new JMenuItem("Boarding Pass");
         boardingpass.addActionListener(this);
         Ticket.add(boardingpass);
         
         
         
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        String text=ae.getActionCommand();
        if(text.equals("Add Customer Details")){
           new AddCustomer();
        }
        else if(text.equals("Flight Details")){
           new FlightInfo();
        }else if(text.equals("Book Flight")){
            new BookFlight();
        }else if(text.equals("Journey Details")){
            new JourneyInfo();
        }else if(text.equals("Cancel Ticket")){
            new CancelTicket();
        }else if(text.equals("Boarding Pass")){
            new BoardingPass();
        }
        
    }
    
    public static void main(String args[]){
        new Home();
  }
}
