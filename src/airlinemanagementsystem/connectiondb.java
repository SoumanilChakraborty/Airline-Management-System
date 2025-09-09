
package airlinemanagementsystem;

import java.sql.*;

public class connectiondb {
    Connection c;
    Statement s;
    
    public connectiondb(){
        try{
            
           c=DriverManager.getConnection("jdbc:postgresql://localhost:5432/AirlineManagementSystem", "postgres" ,"soumanil4");
           s=c.createStatement();
           System.out.println(" Connected to PostgreSQL successfully!");
          }
          catch(Exception e){
               e.printStackTrace();
        }
    }
}
