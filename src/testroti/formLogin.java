package testroti;


import java.sql.Connection;
import javax.swing.JOptionPane;
import testroti.connect_db;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ACER
 */
public class formLogin extends javax.swing.JFrame {

//    private void hakakses() {
//    String user=lbluserlogin.getText();
//        if(user.equals("Admin")){
//        
//        formMenu.setEnabled(true);
//        formKasir.setEnabled(true);
//        formLaporan.setEnabled(true);
//        formBarang.setEnabled(true);
//        formSupplier.setEnabled(true);
//        formKaryawan.setEnabled(true);
//        }
//        else {
//        
//        formMenu.setEnabled(false);
//        formKasir.setEnabled(true);
//        formLaporan.setEnabled(true);
//        formBarang.setEnabled(true);
//        formSupplier.setEnabled(true);
//        formKaryawan.setEnabled(false);
//        }
//        }
    public formLogin() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        txtid_karyawan = new javax.swing.JTextField();
        btnmasuk = new javax.swing.JButton();
        txtpassword = new javax.swing.JPasswordField();
        jCheckBox1 = new javax.swing.JCheckBox();
        jLabel2 = new javax.swing.JLabel();
        btnlupa = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtid_karyawan.setBackground(new java.awt.Color(228, 228, 228));
        txtid_karyawan.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtid_karyawan.setBorder(null);
        txtid_karyawan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtid_karyawanActionPerformed(evt);
            }
        });
        jPanel2.add(txtid_karyawan, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 330, 290, 30));

        btnmasuk.setBackground(new java.awt.Color(246, 118, 73));
        btnmasuk.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnmasuk.setText("Masuk");
        btnmasuk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmasukActionPerformed(evt);
            }
        });
        jPanel2.add(btnmasuk, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 550, 370, 40));

        txtpassword.setBackground(new java.awt.Color(228, 228, 228));
        txtpassword.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtpassword.setBorder(null);
        jPanel2.add(txtpassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 410, 290, 30));

        jCheckBox1.setText("Show Password");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });
        jPanel2.add(jCheckBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 460, 130, 40));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/Login (1).png"))); // NOI18N
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1080, 770));

        btnlupa.setText("lupapassword");
        btnlupa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlupaActionPerformed(evt);
            }
        });
        jPanel2.add(btnlupa, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 480, 220, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1080, 790));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtid_karyawanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtid_karyawanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtid_karyawanActionPerformed

    private void btnmasukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmasukActionPerformed
        // TODO add your handling code here:
        try {
            String sql = "SELECT * FROM karyawan WHERE id_karyawan='"+txtid_karyawan.getText()
            +"'AND password='"+txtpassword.getText()+"'";
            java.sql.Connection conn=(Connection)connect_db.configDB();
            java.sql.PreparedStatement pst=conn.prepareStatement(sql);
            java.sql.ResultSet rs = pst.executeQuery(sql);
            if(rs.next()){
                               
                if (txtid_karyawan.getText().equals(rs.getString("id_karyawan"))
                    && txtpassword.getText().equals(rs.getString("password"))){
                    JOptionPane.showMessageDialog(null, "Berhasil Login");
                    if(rs.getString("level").equals("admin")){
                        this.setVisible(false);
                        new formRegistrasi().setVisible(true);
                    } else if(rs.getString("level").equals("karyawan")){
                        this.setVisible(false);                        
                        new formMenu().setVisible(true);
                }
                }
            }else{
                JOptionPane.showMessageDialog(null,
                    "Username atau Password Salah!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_btnmasukActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        // TODO add your handling code here:
        if(jCheckBox1.isSelected())
            txtpassword.setEchoChar((char)0);
        else 
            txtpassword.setEchoChar('*');
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void btnlupaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlupaActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new formLupa().setVisible(true);   
    }//GEN-LAST:event_btnlupaActionPerformed

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
            java.util.logging.Logger.getLogger(formLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(formLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(formLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(formLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new formLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnlupa;
    private javax.swing.JButton btnmasuk;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField txtid_karyawan;
    private javax.swing.JPasswordField txtpassword;
    // End of variables declaration//GEN-END:variables
}
