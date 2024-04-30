/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Book;
import java.sql.*;
import java.sql.DriverManager;

/**
 *
 * @author nshut
 */
public class BookDAO {
    
        private String db_url = "jdbc:postgresql://localhost:5432/GS_APACE_LMS";
        private String db_username = "postgres";
        private String db_passwd = "2804";

    public BookDAO() {
    }
        
public Integer addBook(Book book){
    try{
        Connection con = DriverManager.getConnection(db_url, db_username, db_passwd);
        PreparedStatement pst = con.prepareStatement("insert into books(book_name, quantity, classes) values (?,?,?)");
        pst.setString(1, book.getName());
        pst.setInt(2, book.getQuantity());
        pst.setString(3, book.getClasses());
        
        int rowsAffected = pst.executeUpdate();
        if(rowsAffected>0){
            return rowsAffected;
        }
        
    }catch(Exception ex){
        ex.printStackTrace();
    }
         return 0;
    
}
}
