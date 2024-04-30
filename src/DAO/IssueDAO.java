/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Book;
import Model.Issue;
import java.sql.*;

/**
 *
 * @author nshut
 */
public class IssueDAO {
        private String db_url = "jdbc:postgresql://localhost:5432/GS_APACE_LMS";
        private String db_username = "postgres";
        private String db_passwd = "2804";

    public IssueDAO() {
    }
        
    public Integer addIssue(Issue issue){    
        
        try{
            Connection con = DriverManager.getConnection(db_url, db_username, db_passwd);
            String sql =("insert int issuebooks (book_id, book_name, teacher_id, teacher_name, issue_date, due_date, status values(?,?,?,?,?,?,?)");
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, issue.getBook_id());
            pst.setString(2, issue.getBook_name());
            pst.setInt(3, issue.getTeacher_id());
            pst.setString(4, issue.getTeacher_name());
            pst.setDate(5, (Date) issue.getIssue_date());
            pst.setDate(6, (Date) issue.getDue_date());
            pst.setString(7, issue.getStatus());
            
            int rowsAffected = pst.executeUpdate();
            if(rowsAffected>=1){
                return rowsAffected;
            }
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
            return 0;
}
}
