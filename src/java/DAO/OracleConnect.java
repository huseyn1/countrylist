
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import oracle.jdbc.OracleDriver;

public class OracleConnect {
    
    Connection connection;
    PreparedStatement preparedStatement;
    ResultSet resultSet;
    
    private String url="jdbc:oracle:thin:@localhost:1521:ORCL";
     private String orcl_user="hr";
    private String orcl_password="hr";
    
    
   static{
   
        try {
            DriverManager.registerDriver(new OracleDriver());
        } catch (SQLException ex) {
         System.out.println("Oracle registr zamani xeta oldu");
            ex.printStackTrace();
        }
   }
   
   public void open(){
        try {
            connection=DriverManager.getConnection(url, orcl_user, orcl_password);
        } catch (SQLException ex) {
           System.out.println("Oracle open zamani xeta oldu");
            ex.printStackTrace();     
        }
   }
   
   public void close(){
        try {
            if(resultSet!=null) resultSet.close();
            if(preparedStatement!=null) preparedStatement.close();
            if(connection!=null) connection.close();
        } catch (SQLException ex) {
            System.out.println("Oracle close zamani xeta oldu");
            ex.printStackTrace();    
        }
   
   }
    
}
