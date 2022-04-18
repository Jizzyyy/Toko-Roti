package testroti;


import testroti.Karyawan;
import java.sql.Connection;
import java.text.DecimalFormat;
import testroti.connect_db;


public class Home extends javax.swing.JFrame {

    /**
     * Creates new form Home
     */
    public Home() {
        initComponents();
        stok();
        total_transaksi();
        pendapatan();
        karyawan();
    }

    private void stok(){
        txt_stok.setText(null);
        int total =0;
        try {
            String sql = "SELECT *, SUM(stok) AS TOTAL FROM roti";
            java.sql.Connection conn = (Connection)connect_db.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            while(res.next()) {
                total += Integer.parseInt(res.getString("TOTAL"));
                txt_stok.setText(String.valueOf(total));
            }
        } catch (Exception e) {
        }
    }
    
    private void total_transaksi() {
        txt_transaksi.setText(null);
        int total =0;
        try {
            String sql = "SELECT *, COUNT(id_transaksi) AS TOTAL_TRANSAKSI FROM transaksi WHERE date(tanggal_transaksi) = CURDATE()";
            System.out.println(sql);
            java.sql.Connection conn = (Connection)connect_db.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            while(res.next()) {
                total += Integer.parseInt(res.getString("TOTAL_TRANSAKSI"));
                txt_transaksi.setText(String.valueOf(total));
            } 
        } catch (Exception e) {
        }
    }
    
    private void pendapatan() {
        txt_pendapatan.setText("0");
        int total =0;
        try {
            String sql = "SELECT *, SUM(tot_bayar) AS PENDAPATAN FROM transaksi WHERE date(tanggal_transaksi) = CURDATE()";
            java.sql.Connection conn = (Connection)connect_db.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            while(res.next()) {
                total += Integer.parseInt(res.getString("PENDAPATAN"));
                txt_pendapatan.setText(String.valueOf(total));
            }
            String mataUang = txt_pendapatan.getText().replaceAll("\\.", "");
            double dbbyr = Double.parseDouble(mataUang);
            DecimalFormat df = new DecimalFormat("#,###,##0");
            if(dbbyr>999) {
                txt_pendapatan.setText(df.format(dbbyr));
                
            }
        } catch (Exception e) {
        }
    }
    
    private void karyawan(){
        txt_karyawan.setText(null);
        int total =0;
        try {
            String sql = "SELECT*, COUNT(nama) AS TOTAL FROM user WHERE level = 'karyawan'";
            System.out.println(sql);
            java.sql.Connection conn = (Connection)connect_db.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            while(res.next()) {
                total += Integer.parseInt(res.getString("TOTAL"));
                txt_karyawan.setText(String.valueOf(total));
            }
        } catch (Exception e) {
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txt_transaksi = new javax.swing.JLabel();
        txt_pendapatan = new javax.swing.JLabel();
        txt_karyawan = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        txt_username = new javax.swing.JLabel();
        txt_stok = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_transaksi.setFont(new java.awt.Font("Segoe UI", 1, 50)); // NOI18N
        txt_transaksi.setForeground(new java.awt.Color(159, 67, 15));
        txt_transaksi.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txt_transaksi.setText("0");
        getContentPane().add(txt_transaksi, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 260, 180, -1));

        txt_pendapatan.setFont(new java.awt.Font("Segoe UI", 1, 45)); // NOI18N
        txt_pendapatan.setForeground(new java.awt.Color(159, 67, 15));
        txt_pendapatan.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txt_pendapatan.setText("0");
        getContentPane().add(txt_pendapatan, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 510, 240, 70));

        txt_karyawan.setFont(new java.awt.Font("Segoe UI", 1, 50)); // NOI18N
        txt_karyawan.setForeground(new java.awt.Color(159, 67, 15));
        txt_karyawan.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txt_karyawan.setText("0");
        getContentPane().add(txt_karyawan, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 260, 140, -1));

        jButton1.setOpaque(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setBorderPainted(false);
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 0, 130, 120));

        txt_username.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txt_username.setText("Username");
        getContentPane().add(txt_username, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 80, -1, -1));

        txt_stok.setFont(new java.awt.Font("Segoe UI", 1, 50)); // NOI18N
        txt_stok.setForeground(new java.awt.Color(159, 67, 15));
        txt_stok.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txt_stok.setText("0");
        getContentPane().add(txt_stok, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 510, 140, -1));

        jButton2.setOpaque(false);
        jButton2.setContentAreaFilled(false);
        jButton2.setBorderPainted(false);
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 110, 100));

        jButton3.setOpaque(false);
        jButton3.setContentAreaFilled(false);
        jButton3.setBorderPainted(false);
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 270, 110, 100));

        jButton4.setOpaque(false);
        jButton4.setContentAreaFilled(false);
        jButton4.setBorderPainted(false);
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 390, 110, 90));

        jButton5.setOpaque(false);
        jButton5.setContentAreaFilled(false);
        jButton5.setBorderPainted(false);
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 510, 110, 100));

        jButton6.setOpaque(false);
        jButton6.setContentAreaFilled(false);
        jButton6.setBorderPainted(false);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 620, 110, 90));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/Home.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        this.setVisible(false);
        new Karyawan().setVisible(true);
    }//GEN-LAST:event_jButton6ActionPerformed

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
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel txt_karyawan;
    private javax.swing.JLabel txt_pendapatan;
    private javax.swing.JLabel txt_stok;
    private javax.swing.JLabel txt_transaksi;
    private javax.swing.JLabel txt_username;
    // End of variables declaration//GEN-END:variables
}
