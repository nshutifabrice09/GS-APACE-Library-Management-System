/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Teacher;
import java.sql.*;

/**
 *
 * @author nshut
 */
public class TeacherDAO {
     private String db_url = "jdbc:postgresql://localhost:5432/GS_APACE_LMS";
        private String db_username = "postgres";
        private String db_passwd = "2804";

    public TeacherDAO() {
    }
        
    public Integer addTeacher(Teacher teacher){
        try{
            Connection con = DriverManager.getConnection(db_url, db_username, db_passwd);
            PreparedStatement pst = con.prepareStatement("insert into teachers(teachername, bookname, classes, numberofbooks) values (?,?,?,?)");
            pst.setString(1, teacher.getTeacher_names());
            pst.setString(2, teacher.getBook_name());
            pst.setString(3, teacher.getClasses());
            pst.setInt(4, teacher.getNumberOfBooks());
            
            int rowAffected = pst.executeUpdate();
            if(rowAffected >=1 ){
                return rowAffected;
            }
            
        } catch(Exception ex){
            ex.printStackTrace();
        }
        
        return 0;
        
    }
}
