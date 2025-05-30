/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package users;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author milan
 */
public class BusinessFillUp extends javax.swing.JFrame {

  private int currentUserId;
    /**
     * Creates new form BusinessFillUp
     */
    public BusinessFillUp(int userId) {
        initComponents();
        
        this.currentUserId = userId;
    }
    
    
 private void submitApplication() {
    String username = un.getText().trim();
    String firstname = fn.getText().trim();
    String lastname = ln.getText().trim();
    String businessName = busname.getText().trim();
    String businessType = ty.getSelectedItem().toString().trim();
    String clearanceNo = busnum.getText().trim();

    if (username.isEmpty() || firstname.isEmpty() || lastname.isEmpty()
            || businessName.isEmpty() || businessType.isEmpty() || clearanceNo.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Please fill in all fields.");
        return;
    }

    try (Connection conn = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/businesspermit_db", "root", "")) {

        // Validate against actual user info
        String userQuery = "SELECT u_username, u_fname, u_lname FROM tbl_users WHERE u_id = ?";
        try (PreparedStatement userStmt = conn.prepareStatement(userQuery)) {
            userStmt.setInt(1, currentUserId);  // Your session-based user ID
            ResultSet rs = userStmt.executeQuery();

            if (rs.next()) {
                String dbUsername = rs.getString("u_username").trim();
                String dbFirstname = rs.getString("u_fname").trim();
                String dbLastname = rs.getString("u_lname").trim();

                if (!username.equalsIgnoreCase(dbUsername) || 
                    !firstname.equalsIgnoreCase(dbFirstname) || 
                    !lastname.equalsIgnoreCase(dbLastname)) {
                    JOptionPane.showMessageDialog(this, "Invalid user information. Please make sure your username, first name, and last name are correct.");
                    return;
                }
            } else {
                JOptionPane.showMessageDialog(this, "User not found.");
                return;
            }
        }

        // Proceed with submission
        String sql = "INSERT INTO applications (u_id, username, firstname, lastname, business_name, business_type, barangay_clearance_no) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, currentUserId);
            stmt.setString(2, username);
            stmt.setString(3, firstname);
            stmt.setString(4, lastname);
            stmt.setString(5, businessName);
            stmt.setString(6, businessType);
            stmt.setString(7, clearanceNo);

            stmt.executeUpdate();
            JOptionPane.showMessageDialog(this, "Application submitted successfully!");
            this.dispose();
        }

    } catch (SQLException ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error submitting application.");
    }
}





    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        fn = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        un = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        ln = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        busname = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        ty = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        busnum = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(153, 0, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(fn, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 160, 35));

        jLabel1.setText("Username");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));
        jPanel1.add(un, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 43, 160, 35));

        jLabel2.setText("First Name");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, -1, -1));

        jLabel3.setText("Last Name");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, -1, -1));
        jPanel1.add(ln, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 160, 30));

        jLabel4.setText("Business Name");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 20, -1, -1));
        jPanel1.add(busname, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 40, 180, 40));

        jLabel5.setText("Business Type");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 100, -1, -1));

        ty.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Retail", "Food", "Services" }));
        jPanel1.add(ty, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 130, 180, -1));

        jLabel6.setText("Barangay Clearance Number");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 180, -1, -1));
        jPanel1.add(busnum, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 200, 180, 30));

        jButton1.setText("Submit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 340, -1, -1));

        jButton2.setText("Cancel");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(379, 340, 70, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 640, 420));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
   submitApplication();

   // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        userDashboard accd = new userDashboard();
        accd.setVisible(true);
        this.dispose();          // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(BusinessFillUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BusinessFillUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BusinessFillUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BusinessFillUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
             int currentUserId = 123; // get this from your login/session
         new BusinessFillUp(currentUserId).setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField busname;
    private javax.swing.JTextField busnum;
    private javax.swing.JTextField fn;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField ln;
    private javax.swing.JComboBox<String> ty;
    private javax.swing.JTextField un;
    // End of variables declaration//GEN-END:variables
}
