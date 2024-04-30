/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import Model.*;
import java.sql.*;
import java.time.DayOfWeek;
import java.time.temporal.TemporalAdjusters;
import javax.swing.*;
/**
 *
 * @author nshut
 */
public class UserDAO {
    private String db_url = "jdbc:postgresql://localhost:5432/GS_APACE_LMS";
        private String db_username = "postgres";
        private String db_passwd = "2804";

    public UserDAO() {
    }
    
   
    
public Integer addUser(User user){
    try{
        Connection con = DriverManager.getConnection(db_url, db_username, db_passwd);
        PreparedStatement pst = con.prepareStatement("insert into users(names ,username, password, email, contact) values (?,?,?,?,?)");
        pst.setString(1,  user.getName());
        pst.setString(2,  user.getUsername());
        pst.setString(3,  user.getPassword());
        pst.setString(4,  user.getEmail());
        pst.setString(5,  user.getContact());
        
        int rowsAffected = pst.executeUpdate();
        if(rowsAffected >= 1){
            return rowsAffected;
        }else{
            
        }
    }catch(Exception ex){
        ex.printStackTrace();
    }
        return 0;
}

public boolean checkUsername(String user){
    try{
        Connection con = DriverManager.getConnection(db_url,db_username,db_passwd);
        Statement st = con.createStatement();
        String selectQuerry = "select * from users where username = ?";
        PreparedStatement pst = con.prepareStatement(selectQuerry);
        pst.setString(1, user);
        ResultSet set = pst.executeQuery();
        
        if(set.next()){
            return true;
        }
        
    }catch(Exception ex){
        ex.printStackTrace();
    }
        return false;
    
}
public boolean checkEmail(String email){
    try{
        Connection con = DriverManager.getConnection(db_url,db_username,db_passwd);
        Statement st = con.createStatement();
        String selectQuerry = "select * from users where email = ?";
        PreparedStatement pst = con.prepareStatement(selectQuerry);
        pst.setString(1, email);
        ResultSet set = pst.executeQuery();
        
        if(set.next()){
            return true;
        }
    }catch(Exception ex){
        ex.printStackTrace();
    }
        return false;
        
}
public boolean checkContact(String contact){
    try{
        Connection con = DriverManager.getConnection(db_url,db_username,db_passwd);
        Statement st = con.createStatement();
        String selectQuerry = "select * from users where contact = ?";
        PreparedStatement pst = con.prepareStatement(selectQuerry);
        pst.setString(1, contact);
        ResultSet set = pst.executeQuery();
        
        if(set.next()){
            return true;
        }
    }catch(Exception ex){
        ex.printStackTrace();
    }
        return false;
}

}
