/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

import config.Session;
import config.dbConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import LoginPage.LoginForm;
import java.awt.Image;
import java.io.File;

/**
 *
 * @author milan
 */
public class adminDashboard extends javax.swing.JFrame {

    /**
     * Creates new form adminDashboard
     */
    public adminDashboard() {
        initComponents();
        
        loadUserProfile();
    }
    
    
    private void loadLogs() {
    dbConnector connector = new dbConnector();
    try (Connection con = connector.getConnection()) {

        // Update 'Pending' log_status to 'Active' for recent logins
        String updateQuery = "UPDATE tbl_log SET log_status = 'Active' WHERE log_status = 'Pending'";
        try (PreparedStatement updateStmt = con.prepareStatement(updateQuery)) {
            updateStmt.executeUpdate();
        }

        // Fetch updated logs including logout time and log_description
        String selectQuery = "SELECT l.log_id, l.u_username, l.login_time, l.logout_time, l.u_type, " +
                             "CASE WHEN u.u_username IS NULL THEN 'Invalid User' ELSE l.log_status END AS log_status, " +
                             "l.log_description " + // Include log_description
                             "FROM tbl_log l LEFT JOIN tbl_users u ON l.u_username = u.u_username " +
                             "ORDER BY l.login_time DESC";

        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(selectQuery)) {

            DefaultTableModel model = new DefaultTableModel(
                new String[]{"Log ID", "Username", "Login Time", "Logout Time", "User Type", "Status", "Description"}, 0 // Add "Description" column
            );

            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getInt("log_id"),
                    rs.getString("u_username"),
                    rs.getTimestamp("login_time"),
                    rs.getTimestamp("logout_time"),
                    rs.getString("u_type"),
                    rs.getString("log_status"),
                    rs.getString("log_description") // Add log_description value
                });
            }

            logstbl.setModel(model);
        }

    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error loading logs: " + ex.getMessage());
    }
}

 
 private void logoutUser(String username) {
    dbConnector connector = new dbConnector();
    try (Connection con = connector.getConnection()) {
        
        
        // Update log_status to "Inactive" and set logout_time
        String updateQuery = "UPDATE tbl_log SET log_status = 'Inactive', logout_time = NOW() " +
                             "WHERE u_username = ? AND log_status = 'Active'";
        
        try (PreparedStatement stmt = con.prepareStatement(updateQuery)) {
            stmt.setString(1, username);
            int updatedRows = stmt.executeUpdate();

            if (updatedRows > 0) {
                JOptionPane.showMessageDialog(null, "User " + username + " has logged out successfully!");
            } else {
                JOptionPane.showMessageDialog(null, "No active session found for " + username);
            }
        }

    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error logging out: " + ex.getMessage());
    }
}

 private void loadUserProfile() {
    dbConnector dbc = new dbConnector();
    Session sess = Session.getInstance();

    String query = "SELECT u_image FROM tbl_users WHERE u_id = ?";

    try (Connection conn = dbc.getConnection();
         PreparedStatement pstmt = conn.prepareStatement(query)) {

        pstmt.setInt(1, sess.getUid());
        ResultSet rs = pstmt.executeQuery();

        if (rs.next()) {
            String imagePath = rs.getString("u_image");

            if (imagePath != null && !imagePath.isEmpty()) {
                String projectDir = System.getProperty("user.dir");
                String absoluteImagePath = projectDir + File.separator + imagePath;

                System.out.println("Loading image from: " + absoluteImagePath);  // Debug print

                ImageIcon icon = new ImageIcon(absoluteImagePath);
                Image img = icon.getImage();
                Image scaledImg = img.getScaledInstance(u_image.getWidth(), u_image.getHeight(), Image.SCALE_SMOOTH);
                u_image.setIcon(new ImageIcon(scaledImg));
            } else {
                u_image.setIcon(null);  // Clear icon if no image path
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error loading profile image: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
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

        jPanel4 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        u_image = new javax.swing.JLabel();
        acc_id = new javax.swing.JLabel();
        acc_uname = new javax.swing.JLabel();
        acc_type = new javax.swing.JLabel();
        acc_email = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        logstbl = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 102, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 110, -1));

        u_image.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        u_image.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/zsa.png"))); // NOI18N

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(u_image, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(u_image, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 110, -1));

        acc_id.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        acc_id.setForeground(new java.awt.Color(255, 255, 255));
        acc_id.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        acc_id.setText("ID");
        jPanel1.add(acc_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 170, 30));

        acc_uname.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        acc_uname.setForeground(new java.awt.Color(255, 255, 255));
        acc_uname.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        acc_uname.setText("User Name");
        jPanel1.add(acc_uname, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 170, 30));

        acc_type.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        acc_type.setForeground(new java.awt.Color(255, 255, 255));
        acc_type.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        acc_type.setText("Type");
        jPanel1.add(acc_type, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 240, 170, 30));

        acc_email.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        acc_email.setForeground(new java.awt.Color(255, 255, 255));
        acc_email.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        acc_email.setText("Email");
        jPanel1.add(acc_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 170, 30));

        jButton2.setBackground(new java.awt.Color(0, 0, 0));
        jButton2.setText("LOG-OUT");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 470, 100, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 170, 530));

        jPanel2.setBackground(new java.awt.Color(153, 0, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Cambria", 3, 36)); // NOI18N
        jLabel1.setText("Admin Dashboard");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 0, -1, -1));

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel8MouseClicked(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/vz.png"))); // NOI18N
        jLabel5.setText("USERS");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(37, 37, 37))
        );

        jPanel2.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 160, 70));

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel10MouseClicked(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/zd.png"))); // NOI18N
        jLabel8.setText("ACCOUNTS");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(587, 587, 587))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 170, 160, 70));

        logstbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "log_id", "u_username", "login_time", "u_type", "log_status", "log_description"
            }
        ));
        jScrollPane1.setViewportView(logstbl);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 570, 250));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel5MouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-table-30.png"))); // NOI18N
        jLabel2.setText("APPLICATIONS");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 170, 160, 70));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 0, 590, 530));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
       Session sess = Session.getInstance();
       if(sess.getUid() == 0)
       {
           JOptionPane.showMessageDialog(null,"No Account, Login FIrst");
           LoginForm c = new LoginForm();
           c.setVisible(true);
           this.dispose();
       }else
       {
           
           acc_uname.setText("" + sess.getUsername());
           acc_type.setText("" + sess.getType());
           acc_email.setText("" + sess.getEmail());
           acc_id.setText("" + sess.getUid());
       }  
         loadLogs();
         loadUserProfile();
// TODO add your handling code here:
    }//GEN-LAST:event_formWindowActivated

    private void jPanel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel8MouseClicked
        usersForm usf = new usersForm();
        usf.setVisible(true);
        this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel8MouseClicked

    private void jPanel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel10MouseClicked
         AdminDetails usf = new AdminDetails();
        usf.setVisible(true);
        this.dispose();            // TODO add your handling code here:
    }//GEN-LAST:event_jPanel10MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Session sess = Session.getInstance();
        if (sess.getUid() != 0) {
            logoutUser(sess.getUsername());  // Log out the current user
        }

        LoginForm loginFrame = new LoginForm();
        JOptionPane.showMessageDialog(null, "Log-out Success!");
        loginFrame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jPanel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel5MouseClicked
          Applications app = new Applications();
        app.setVisible(true);
        this.dispose();         // TODO add your handling code here:
    }//GEN-LAST:event_jPanel5MouseClicked

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
            java.util.logging.Logger.getLogger(adminDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(adminDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(adminDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(adminDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new adminDashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel acc_email;
    private javax.swing.JLabel acc_id;
    private javax.swing.JLabel acc_type;
    private javax.swing.JLabel acc_uname;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable logstbl;
    private javax.swing.JLabel u_image;
    // End of variables declaration//GEN-END:variables
}
