/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author nshut
 */
public class ViewRecords extends javax.swing.JFrame {
    DefaultTableModel tableModel = new DefaultTableModel();
        private String db_url = "jdbc:postgresql://localhost:5432/GS_APACE_LMS";
        private String db_username = "postgres";
        private String db_passwd = "2804";
    /**
     * Creates new form ViewRecords
     */
        
        DefaultTableModel model;
    public ViewRecords() {
        initComponents();
        retrieveDataToTable();
        clearTable();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    
    public void clearTable(){
        DefaultTableModel tableModel = (DefaultTableModel) issueTable.getModel();
        tableModel.setRowCount(0);
    }
    
    public void retrieveDataToTable(){

       try{     
           Connection con = DriverManager.getConnection(db_url, db_username, db_passwd);
           Statement st = con.createStatement();
           ResultSet result = st.executeQuery("select * from issuebooks");
           
           if(result.next()== false){
               JOptionPane.showMessageDialog(this, "No Record Found!");
           }else{
              while(result.next()){
               
               int issueId = result.getInt("issue_id");
               int bookId= result.getInt("book_id");
               int teacherId = result.getInt("teacher_id");
               String issueDate = result.getString("issue_date");
               String dueDate = result.getString("due_date");
               String status = result.getString("status");
               
               
               Object[] obj = {issueId, bookId, teacherId, issueDate, dueDate, status};
               model =(DefaultTableModel ) issueTable.getModel();
               model.addRow(obj);
                
           }
           
           }
       }catch(Exception ex){
           ex.printStackTrace();
       } 
   } 
    //fetch the records using date
//    public void search(){
//       Date issueddate = new Date(issueDate.getDate().getTime());
//       Date duedDate = new Date(DueDate.getDate().getTime());  
//       try{
//           Connection con = DriverManager.getConnection(db_url, db_username, db_passwd);
//           String sql = "select * from issuebooks where issue_id=? BETWEEN ? and ?";
//           PreparedStatement pst = con.prepareStatement(sql);
//           pst.setDate(1, issueddate);
//           pst.setDate(2, duedDate);
//           ResultSet rs = pst.executeQuery();
//           while(rs.next()){ 
//               int issueId = rs.getInt("issue_id");
//               int bookId= rs.getInt("book_id");
//               int teacherId = rs.getInt("teacher_id");
//               String issueDate = rs.getString("issue_date");
//               String dueDate = rs.getString("due_date");
//               String status = rs.getString("status");
//               
//               Object[] obj = {issueId, bookId, teacherId, issueDate, dueDate, status};
//               model =(DefaultTableModel ) issueTable.getModel();
//               model.addRow(obj);
//           }
//       }catch(Exception ex){
//           ex.printStackTrace();
//       }
//    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        allBtn1 = new rojerusan.RSMaterialButtonCircle();
        jLabel22 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        issueTable = new rojeru_san.complementos.RSTableMetro();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(102, 102, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(0, 102, 102));
        jPanel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel3MouseClicked(evt);
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

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 110, 40));

        jLabel2.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 0, 0));
        jLabel2.setText("X");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1490, 10, 30, 30));

        jLabel3.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 25)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Literature_100px_1.png"))); // NOI18N
        jLabel3.setText("Book Details");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 20, 280, -1));

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

        jPanel2.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 130, -1, -1));

        allBtn1.setBackground(new java.awt.Color(0, 51, 153));
        allBtn1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        allBtn1.setText("DISPLAY ALL");
        allBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                allBtn1ActionPerformed(evt);
            }
        });
        jPanel2.add(allBtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1370, 220, 140, 50));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1530, 270));

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel22.setText("Copyright @TheMob 2023");
        jPanel1.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 810, -1, -1));

        issueTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Issue Id", "Book Id", "Teacher's Id", "Issue Date", "Due Date", "Status"
            }
        ));
        issueTable.setColorBackgoundHead(new java.awt.Color(102, 102, 255));
        issueTable.setColorBordeFilas(new java.awt.Color(102, 102, 255));
        issueTable.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        issueTable.setColorSelBackgound(new java.awt.Color(204, 204, 204));
        issueTable.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 25)); // NOI18N
        issueTable.setFuenteFilas(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
        issueTable.setFuenteFilasSelect(new java.awt.Font("Yu Gothic UI", 1, 20)); // NOI18N
        issueTable.setFuenteHead(new java.awt.Font("Yu Gothic UI Semibold", 1, 20)); // NOI18N
        issueTable.setIntercellSpacing(new java.awt.Dimension(0, 0));
        issueTable.setRowHeight(35);
        issueTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                issueTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(issueTable);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 1500, 530));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1530, 830));

        setSize(new java.awt.Dimension(1523, 828));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        HomePage page = new HomePage();
        page.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jPanel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseClicked
        HomePage page = new HomePage();
        page.setVisible(true);
        dispose();
    }//GEN-LAST:event_jPanel3MouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel2MouseClicked

    private void issueTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_issueTableMouseClicked
        
    }//GEN-LAST:event_issueTableMouseClicked

    private void allBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_allBtn1ActionPerformed
        clearTable();
        retrieveDataToTable();
    }//GEN-LAST:event_allBtn1ActionPerformed

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
            java.util.logging.Logger.getLogger(ViewRecords.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewRecords.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewRecords.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewRecords.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewRecords().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojerusan.RSMaterialButtonCircle allBtn1;
    private rojeru_san.complementos.RSTableMetro issueTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
