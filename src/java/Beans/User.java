package Beans;

import DB.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Savinda Keshan
 */
public class User {

    String id;
    String name;
    String email;
    String password;

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public boolean login(String email,String password) {
        boolean check = false;
        try{
            DBConnection dbconn=new DBConnection();
            Connection myconnection= dbconn.connection();
            
            PreparedStatement ps =myconnection.prepareStatement("select * from user where email=? and password=?");

            ps.setString(1, email);
            ps.setString(2, password);
            
            ResultSet rs =ps.executeQuery();
            check = rs.next();
            
            myconnection.close();
        }
        catch(Exception e){e.printStackTrace();}
        
        return check;
    }

    public boolean register() {
        //todo
        //viduni & uthpala
        return true;
    }

    public User getUser(String email) {
        User temp = new User();
        //todo
        return temp;
    }

}
