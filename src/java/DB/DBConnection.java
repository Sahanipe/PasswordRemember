
package DB;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBConnection {
    
    public Connection connection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection myConnection =DriverManager.getConnection("jdbc:mysql://localhost:3306/number_remembering", "root", "");
            return myConnection;
        }
        catch (ClassNotFoundException | SQLException ex) 
        {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println(ex);
        }
        return null;
    }
    
}