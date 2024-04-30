/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author nshut
 */
public class IssuedBook extends javax.swing.JFrame {
    private String db_url="jdbc:postgresql://localhost:5432/GS_APACE_LMS";
    private String db_username="postgres";
    private String db_passwd ="2804";
    /**
     * Creates new form IssuedBook
     */
    
    
    public IssuedBook() {
        initComponents();
    }
    //fecth books' details from DB and display into book details panel
    public void getBookDetails(){
        int bookId = Integer.parseInt(bookIdTxt.getText());
        try{
            Connection con = DriverManager.getConnection(db_url, db_username, db_passwd);
            PreparedStatement pst = con.prepareStatement("select * from books where book_id=?");
            PreparedStatement pst2 = con.prepareStatement("select * from issuebooks where book_id=?");
            pst.setInt(1, bookId);
            pst2.setInt(1, bookId);
            ResultSet rs = pst.executeQuery();
            ResultSet rs2 = pst2.executeQuery();
            
            while(rs.next()){
                labelId.setText(rs.getString("book_id"));
                labelName.setText(rs.getString("book_name"));
                labelQuantity.setText(rs.getString("quantity"));
                labelClass.setText(rs.getString("classes")); 
                
            }
            while(rs2.next()){
                labelIssued.setText(rs2.getDate("issue_date").toString());
                labelDue.setText(rs2.getDate("due_date").toString());
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    //fecth teachers' details from DB and display into teacher details panel
    public void getTeacherDetails(){
        int teacherId = Integer.parseInt(teacherIdTxt.getText());
        try{
            Connection con = DriverManager.getConnection(db_url, db_username, db_passwd);
            PreparedStatement pst = con.prepareStatement("select * from teachers where teacherid=?");
            pst.setInt(1, teacherId);
            ResultSet rs = pst.executeQuery();
            
            while(rs.next()){
                labelTeacherId.setText(rs.getString("teacherid"));
                labelTeacherName.setText(rs.getString("teachername"));
                labelBookName.setText(rs.getString("bookname"));
                labelYear.setText(rs.getString("classes")); 
                labelNumber.setText(rs.getString("numberofbooks"));
                
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
    public boolean getIssueBook(){
        boolean isIssued = false;
        int teacherId = Integer.parseInt(teacherIdTxt.getText());
        int bookId = Integer.parseInt(bookIdTxt.getText());
        String teacherName = labelTeacherName.getText();
        String bookName = labelName.getText();
        
        Date issuedate = new Date(issuesDate.getDate().getTime());
        Date duedDate = new Date(dueDate.getDate().getTime());
             
        try{
            Connection con = DriverManager.getConnection(db_url, db_username, db_passwd);
            String sql = "insert into issuebooks(book_id,teacher_id,issue_date,due_date,status) values(?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, bookId);
            pst.setInt(2, teacherId);
            pst.setDate(3, issuedate);
            pst.setDate(4, duedDate);
            pst.setString(5, "Pending");
            int rs = pst.executeUpdate();
            
            if(rs>0){
                isIssued = true;
                
            }else{
                isIssued = false;
            }
            }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return isIssued;
    }
    public void updateBookCount(){
        int bookId = Integer.parseInt(bookIdTxt.getText());
        try{
            Connection con = DriverManager.getConnection(db_url, db_username, db_passwd);
            String sql = "update books set quantity = quantity - 1 where book_id=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, bookId);
            
            int rowCount = pst.executeUpdate();
            
            if(rowCount>0){
                JOptionPane.showMessageDialog(this, "Book count Updated.");
                int initalCount = Integer.parseInt(labelDue.getText());
                labelDue.setText(Integer.toString(initalCount - 1));
            }else{
                JOptionPane.showMessageDialog(this, "Can't update book count!");
            }
            
        }catch(Exception ex){
            ex.printStackTrace();
                    
        }
    }
    
    public boolean isAlreadyissued(){
        
        boolean isAlreadyIssued = false;
        int bookId = Integer.parseInt(bookIdTxt.getText());
        int teacherId = Integer.parseInt(teacherIdTxt.getText());
        try{
            Connection con = DriverManager.getConnection(db_url, db_username, db_passwd);
            String sql = "insert into issuebooks where book_id = ? and teacher_id = ? and status = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, bookId);
            pst.setInt(2, teacherId);
            pst.setString(3, "Pending");
            
            ResultSet rs = pst.executeQuery();
            
            if(rs.next()){
                isAlreadyIssued = true;
                
            }else{
                isAlreadyIssued = false;
            }
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
        
        return isAlreadyIssued;
        
    }  

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        labelClass = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        labelId = new javax.swing.JLabel();
        labelName = new javax.swing.JLabel();
        labelQuantity = new javax.swing.JLabel();
        labelIssued = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        labelDue = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        labelTeacherId = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        labelBook = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        labelTeacherName = new javax.swing.JLabel();
        labelBookName = new javax.swing.JLabel();
        labelYear = new javax.swing.JLabel();
        labelNumber = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        bookIdTxt = new app.bolivia.swing.JCTextField();
        jLabel15 = new javax.swing.JLabel();
        teacherIdTxt = new app.bolivia.swing.JCTextField();
        jLabel16 = new javax.swing.JLabel();
        labelDueDate = new javax.swing.JLabel();
        issueBtn = new rojerusan.RSMaterialButtonCircle();
        dueDate = new com.toedter.calendar.JDateChooser();
        issuesDate = new com.toedter.calendar.JDateChooser();
        jLabel20 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        mainPanel.setBackground(new java.awt.Color(255, 255, 255));
        mainPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(102, 102, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 102, 102));
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel2MouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Rewind_48px.png"))); // NOI18N
        jLabel1.setText("Back");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 110, 40));

        jLabel2.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 25)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Literature_100px_1.png"))); // NOI18N
        jLabel2.setText("Book Details");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 90, 280, 100));

        jLabel3.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Class(Year):");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 450, -1, -1));

        labelClass.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        labelClass.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(labelClass, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 450, 180, 30));

        jLabel5.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Book Name:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 310, -1, -1));

        jLabel6.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Quantity:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 380, -1, -1));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 400, 3));

        jLabel18.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Book Id:");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 240, -1, -1));

        labelId.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        labelId.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(labelId, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 240, 180, 30));

        labelName.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        labelName.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(labelName, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 310, 180, 30));

        labelQuantity.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        labelQuantity.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(labelQuantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 380, 180, 30));

        labelIssued.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        labelIssued.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(labelIssued, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 520, 180, 30));

        jLabel4.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Issued Date:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 520, -1, -1));

        labelDue.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        labelDue.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(labelDue, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 590, 180, 30));

        jLabel8.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Due Date:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 590, -1, -1));

        mainPanel.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 840));

        jPanel4.setBackground(new java.awt.Color(0, 153, 3));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 25)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/teacher.png"))); // NOI18N
        jLabel7.setText("Teacher's Details");
        jPanel4.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 129, -1, -1));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );

        jPanel4.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 400, 3));

        labelTeacherId.setBackground(new java.awt.Color(255, 255, 255));
        labelTeacherId.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        labelTeacherId.setForeground(new java.awt.Color(255, 255, 255));
        jPanel4.add(labelTeacherId, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 230, 190, 30));

        jLabel9.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Teacher's Name:");
        jPanel4.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, -1, -1));

        labelBook.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        labelBook.setForeground(new java.awt.Color(255, 255, 255));
        labelBook.setText("Book Name:");
        jPanel4.add(labelBook, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 380, -1, -1));

        jLabel11.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Class(Year):");
        jPanel4.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 450, -1, -1));

        jLabel12.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Number of Books:");
        jPanel4.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 520, -1, -1));

        jLabel19.setBackground(new java.awt.Color(255, 255, 255));
        jLabel19.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Teacher's Id:");
        jPanel4.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, -1, -1));

        labelTeacherName.setBackground(new java.awt.Color(255, 255, 255));
        labelTeacherName.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        labelTeacherName.setForeground(new java.awt.Color(255, 255, 255));
        jPanel4.add(labelTeacherName, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 310, 190, 30));

        labelBookName.setBackground(new java.awt.Color(255, 255, 255));
        labelBookName.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        labelBookName.setForeground(new java.awt.Color(255, 255, 255));
        jPanel4.add(labelBookName, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 380, 190, 30));

        labelYear.setBackground(new java.awt.Color(255, 255, 255));
        labelYear.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        labelYear.setForeground(new java.awt.Color(255, 255, 255));
        jPanel4.add(labelYear, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 450, 190, 30));

        labelNumber.setBackground(new java.awt.Color(255, 255, 255));
        labelNumber.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        labelNumber.setForeground(new java.awt.Color(255, 255, 255));
        jPanel4.add(labelNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 520, 190, 30));

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel22.setText("Copyright @TheMob 2023");
        jPanel4.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 810, -1, -1));

        mainPanel.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 0, 510, 830));

        jPanel6.setBackground(new java.awt.Color(255, 255, 0));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setBackground(new java.awt.Color(255, 255, 255));
        jLabel13.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 25)); // NOI18N
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/stack-of-books.png"))); // NOI18N
        jLabel13.setText("Issued Book");
        jPanel6.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 130, -1, -1));

        jPanel7.setBackground(new java.awt.Color(0, 0, 0));
        jPanel7.setPreferredSize(new java.awt.Dimension(400, 3));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );

        jPanel6.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 400, 3));

        jLabel23.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(204, 0, 0));
        jLabel23.setText("X");
        jLabel23.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel23MouseClicked(evt);
            }
        });
        jPanel6.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 0, -1, -1));

        jLabel14.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        jLabel14.setText("|");
        jPanel6.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 240, -1, -1));

        bookIdTxt.setBackground(new java.awt.Color(255, 255, 0));
        bookIdTxt.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        bookIdTxt.setFont(new java.awt.Font("Calibri", 0, 17)); // NOI18N
        bookIdTxt.setPlaceholder("Enter Book Id...");
        bookIdTxt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                bookIdTxtFocusLost(evt);
            }
        });
        jPanel6.add(bookIdTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 280, 130, -1));

        jLabel15.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        jLabel15.setText("Due Date:");
        jPanel6.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 450, -1, -1));

        teacherIdTxt.setBackground(new java.awt.Color(255, 255, 0));
        teacherIdTxt.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        teacherIdTxt.setFont(new java.awt.Font("Calibri", 0, 17)); // NOI18N
        teacherIdTxt.setPlaceholder("Enter Teacher's ID...");
        teacherIdTxt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                teacherIdTxtFocusLost(evt);
            }
        });
        jPanel6.add(teacherIdTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 280, 150, -1));

        jLabel16.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        jLabel16.setText("Teacher's Id:");
        jPanel6.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 240, -1, -1));

        labelDueDate.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        labelDueDate.setText("Issued Date:");
        jPanel6.add(labelDueDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 380, -1, -1));

        issueBtn.setBackground(new java.awt.Color(0, 0, 0));
        issueBtn.setText("ISSUE BOOK");
        issueBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                issueBtnActionPerformed(evt);
            }
        });
        jPanel6.add(issueBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 590, 230, 60));

        dueDate.setBackground(new java.awt.Color(255, 255, 0));
        jPanel6.add(dueDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 460, 200, -1));

        issuesDate.setBackground(new java.awt.Color(255, 255, 0));
        jPanel6.add(issuesDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 390, 200, -1));

        jLabel20.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        jLabel20.setText("Book Id:");
        jPanel6.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 240, -1, -1));

        mainPanel.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 0, 480, 830));

        getContentPane().add(mainPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1520, 830));

        setSize(new java.awt.Dimension(1523, 828));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        HomePage page = new HomePage();
        page.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jPanel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseClicked
        HomePage page = new HomePage();
        page.setVisible(true);
        dispose();
    }//GEN-LAST:event_jPanel2MouseClicked

    private void jLabel23MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel23MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel23MouseClicked

    private void issueBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_issueBtnActionPerformed
        if(!bookIdTxt.getText().equals("")){
            getIssueBook();
            getBookDetails();
        }
        
    }//GEN-LAST:event_issueBtnActionPerformed

    private void bookIdTxtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_bookIdTxtFocusLost
        
    }//GEN-LAST:event_bookIdTxtFocusLost

    private void teacherIdTxtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_teacherIdTxtFocusLost
       if(!teacherIdTxt.getText().equals("")){
           getTeacherDetails();
       }
    }//GEN-LAST:event_teacherIdTxtFocusLost

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(IssuedBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IssuedBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IssuedBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IssuedBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IssuedBook().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private app.bolivia.swing.JCTextField bookIdTxt;
    private com.toedter.calendar.JDateChooser dueDate;
    private rojerusan.RSMaterialButtonCircle issueBtn;
    private com.toedter.calendar.JDateChooser issuesDate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JLabel labelBook;
    private javax.swing.JLabel labelBookName;
    private javax.swing.JLabel labelClass;
    private javax.swing.JLabel labelDue;
    private javax.swing.JLabel labelDueDate;
    private javax.swing.JLabel labelId;
    private javax.swing.JLabel labelIssued;
    private javax.swing.JLabel labelName;
    private javax.swing.JLabel labelNumber;
    private javax.swing.JLabel labelQuantity;
    private javax.swing.JLabel labelTeacherId;
    private javax.swing.JLabel labelTeacherName;
    private javax.swing.JLabel labelYear;
    private javax.swing.JPanel mainPanel;
    private app.bolivia.swing.JCTextField teacherIdTxt;
    // End of variables declaration//GEN-END:variables
}
