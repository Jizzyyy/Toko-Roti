package testroti;


import java.sql.Connection;
import java.text.DecimalFormat;
import testroti.connect_db;


public class Dasboard extends javax.swing.JFrame {

    /**
     * Creates new form Dasboard
     */
    public Dasboard() {
        initComponents();
        barangKeluar();
        stok();
        total_transaksi();
        pendapatan();
    }
    
    private void barangKeluar(){
        txt_barangkeluar.setText("0");
        int total =0;
        try {
            String sql = "SELECT SUM(dtl_transaksi.qty) AS TOTAL, (transaksi.tanggal_transaksi)"
                    + "FROM dtl_transaksi JOIN transaksi ON dtl_transaksi.id_transaksi=transaksi.id_transaksi" 
                    + " WHERE date(transaksi.tanggal_transaksi) = CURDATE()" 
                    + " GROUP BY transaksi.tanggal_transaksi";
            System.out.println(sql);
            java.sql.Connection conn = (Connection)connect_db.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            while(res.next()) {
                total += Integer.parseInt(res.getString("TOTAL"));
                txt_barangkeluar.setText(String.valueOf(total));
            }
        
        } catch (Exception e) {
    }
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
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txt_pendapatan = new javax.swing.JLabel();
        txt_stok = new javax.swing.JLabel();
        txt_transaksi = new javax.swing.JLabel();
        txt_barangkeluar = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_pendapatan.setFont(new java.awt.Font("Segoe UI", 1, 50)); // NOI18N
        txt_pendapatan.setForeground(new java.awt.Color(159, 67, 15));
        txt_pendapatan.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txt_pendapatan.setText("0");
        getContentPane().add(txt_pendapatan, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 510, 240, -1));

        txt_stok.setFont(new java.awt.Font("Segoe UI", 1, 50)); // NOI18N
        txt_stok.setForeground(new java.awt.Color(159, 67, 15));
        txt_stok.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txt_stok.setText("0");
        getContentPane().add(txt_stok, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 510, 180, -1));

        txt_transaksi.setFont(new java.awt.Font("Segoe UI", 1, 50)); // NOI18N
        txt_transaksi.setForeground(new java.awt.Color(159, 67, 15));
        txt_transaksi.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txt_transaksi.setText("0");
        getContentPane().add(txt_transaksi, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 260, 190, -1));

        txt_barangkeluar.setFont(new java.awt.Font("Segoe UI", 1, 50)); // NOI18N
        txt_barangkeluar.setForeground(new java.awt.Color(159, 67, 15));
        txt_barangkeluar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txt_barangkeluar.setText("0");
        getContentPane().add(txt_barangkeluar, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 260, 180, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Username");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 80, 100, 30));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/HomeKaryawan.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(Dasboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Dasboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Dasboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dasboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Dasboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel txt_barangkeluar;
    private javax.swing.JLabel txt_pendapatan;
    private javax.swing.JLabel txt_stok;
    private javax.swing.JLabel txt_transaksi;
    // End of variables declaration//GEN-END:variables
}
