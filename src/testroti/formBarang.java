package testroti;


import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
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
public class formBarang extends javax.swing.JFrame {


//    private void cari_barang() {  
//    int jumlahrow = jTable2.getRowCount();
//    for (int n=0; n<jumlahrow; n++){
//        model.removeRow(0);
//    }
//    String cari = txtcari.getText();
//    try {
//        java.sql.Connection conn=(Connection)config.configDB();
//        java.sql.Statement stm=conn.createStatement();
//        java.sql.ResultSet rs=stm.executeQuery(sql);
//        st = config.configDB().createStatement();
//        rs = st.executeQuery("SELECT * FROM roti WHERE nama LIKE '%"+cari+"%'");
//        while (rs.next()){
//             model.addRow(new Object[]{no++, rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
//             rs.getString(5), rs.getString(6), rs.getString(8), rs.getString(9), rs.getString(10)});   
//         }
//    }catch(Exception e){
//        JOptionPane.showMessageDialog(null, "Koneksi Database Gagal"+ e.getMessage());
//    }
// }
    private void autonumber() {
       try {
           String sql = "SELECT MAX(id_roti) AS ID FROM roti";
           java.sql.Connection conn = (Connection)connect_db.configDB();
           java.sql.Statement pst = conn.createStatement();
           java.sql.ResultSet rs = pst.executeQuery(sql);
           while(rs.next()) {
               Object[] obj = new Object[1];
               obj[0] = rs.getString("ID");
               if(obj[0] == null) {
                   obj[0] = "BR000";
               }
               String str_kd = (String) obj[0];
               String kd = str_kd.substring(2, 5);
               int int_code = Integer.parseInt(kd);
               int_code++;
               String a = String.format("%03d", int_code);
               String b = "BA" + a;
               txtid.setText(b);
               txtid.setEditable(false);
           }
       } catch (Exception e) {      
       }
    }
    
    private Statement st;
    private ResultSet rs;
    
    private void otoid() {
        try {
            st = connect_db.configDB().createStatement();
            rs = st.executeQuery("SELECT * FROM supplier");
            while (rs.next()) {
                cbidsupp.addItem(rs.getString("id_supp"));
            }
        } catch (Exception e) {
        }
    }
    
    private void otoidsupp() {
        try {
            st = connect_db.configDB().createStatement();
            rs = st.executeQuery("SELECT * FROM supplier WHERE id_supp = '" 
                    + cbidsupp.getSelectedItem() + "'");
           while (rs.next()) {
                String a = rs.getString("id_supp");
                String b = rs.getString("nama_supp");
                String c = rs.getString("telp_supp");
                String d = rs.getString("alamat");
                txtnama1.setText(b);
                txttelp.setText(c);
                txtalamat.setText(d);
           }
        } catch (Exception e) {
        }
    }
    private void load_table(){
     DefaultTableModel model = new DefaultTableModel();
     model.addColumn("No");
     model.addColumn("KODE BARANG");
     model.addColumn("NAMA BARANG");
     model.addColumn("HARGA BELI");
     model.addColumn("HARGA JUAL");
     model.addColumn("STOK");
     model.addColumn("ID SUPPLIER");
     model.addColumn("NAMA SUPPLIER");                                                                                                                                                                                                                                                         
     model.addColumn("TELP SUPPLIER");
     model.addColumn("ALAMAT SUPPLIER");
     
    String cari = txtcari.getText();
     try {
         int no=1;
         String sql = "SELECT * FROM roti JOIN supplier ON roti.id_supp = supplier.id_supp WHERE nama LIKE '%"+cari+"%'";
         java.sql.Connection conn=(Connection)connect_db.configDB();
         java.sql.Statement stm=conn.createStatement();
         java.sql.ResultSet res=stm.executeQuery(sql);
         while (res.next()){
             model.addRow(new Object[]{no++, res.getString(1), res.getString(2), res.getString(3), res.getString(4),
             res.getString(5), res.getString(6), res.getString(8), res.getString(9), res.getString(10)});   
         }
         jTable2.setModel(model);
         } catch (SQLException e){
         }   
    }
    
    private void kosong(){
    txtid.disable();
    txtnama.setText(null);
    txthargabeli.setText(null);
    txthargajual.setText(null);
    txtstok.setText(null);
    cbidsupp.setSelectedItem(null);
    txtnama1.setText(null);
    txttelp.setText(null);
    txtalamat.setText(null);
}
     
    public formBarang() {
        initComponents();
        kosong();
        load_table();
        otoid();
        autonumber();
    }




    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        btnedit = new javax.swing.JButton();
        btnclear = new javax.swing.JButton();
        btnhapus = new javax.swing.JButton();
        btncari = new javax.swing.JButton();
        cbidsupp = new javax.swing.JComboBox<>();
        txtstok = new javax.swing.JTextField();
        txtnama = new javax.swing.JTextField();
        txthargajual = new javax.swing.JTextField();
        txtnama1 = new javax.swing.JTextField();
        txthargabeli = new javax.swing.JTextField();
        txttelp = new javax.swing.JTextField();
        txtalamat = new javax.swing.JTextField();
        txtid = new javax.swing.JTextField();
        btntambah = new javax.swing.JButton();
        txtcari = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btnhome = new javax.swing.JButton();
        btnkasir = new javax.swing.JButton();
        btnlaporan = new javax.swing.JButton();
        btnbarang = new javax.swing.JButton();
        btnsupplier = new javax.swing.JButton();
        btnsupplier1 = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 600, 910, 160));

        btnedit.setBackground(new java.awt.Color(246, 118, 73));
        btnedit.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnedit.setForeground(new java.awt.Color(255, 255, 255));
        btnedit.setText("EDIT");
        btnedit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneditActionPerformed(evt);
            }
        });
        jPanel1.add(btnedit, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 490, 80, 40));

        btnclear.setBackground(new java.awt.Color(246, 118, 73));
        btnclear.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnclear.setForeground(new java.awt.Color(255, 255, 255));
        btnclear.setText("CLEAR");
        btnclear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnclearActionPerformed(evt);
            }
        });
        jPanel1.add(btnclear, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 490, 80, 40));

        btnhapus.setBackground(new java.awt.Color(246, 118, 73));
        btnhapus.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnhapus.setForeground(new java.awt.Color(255, 255, 255));
        btnhapus.setText("HAPUS");
        btnhapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnhapusActionPerformed(evt);
            }
        });
        jPanel1.add(btnhapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 490, 80, 40));

        btncari.setBackground(new java.awt.Color(246, 118, 73));
        btncari.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btncari.setForeground(new java.awt.Color(255, 255, 255));
        btncari.setText("CARI");
        btncari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncariActionPerformed(evt);
            }
        });
        jPanel1.add(btncari, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 490, 90, 40));

        cbidsupp.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "  " }));
        cbidsupp.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbidsuppItemStateChanged(evt);
            }
        });
        jPanel1.add(cbidsupp, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 220, 190, 40));
        jPanel1.add(txtstok, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 430, 190, 40));
        jPanel1.add(txtnama, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 220, 190, 40));
        jPanel1.add(txthargajual, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 360, 190, 40));
        jPanel1.add(txtnama1, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 290, 190, 40));
        jPanel1.add(txthargabeli, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 290, 190, 40));
        jPanel1.add(txttelp, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 360, 190, 40));
        jPanel1.add(txtalamat, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 430, 190, 40));
        jPanel1.add(txtid, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 150, 190, 40));

        btntambah.setBackground(new java.awt.Color(246, 118, 73));
        btntambah.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btntambah.setForeground(new java.awt.Color(255, 255, 255));
        btntambah.setText("TAMBAH");
        btntambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntambahActionPerformed(evt);
            }
        });
        jPanel1.add(btntambah, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 490, 90, 40));
        jPanel1.add(txtcari, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 490, 100, 40));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/Barang.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1080, 770));

        btnhome.setText("home");
        btnhome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnhomeActionPerformed(evt);
            }
        });
        jPanel1.add(btnhome, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 80, 70));

        btnkasir.setText("kasir");
        btnkasir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnkasirActionPerformed(evt);
            }
        });
        jPanel1.add(btnkasir, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 80, 70));

        btnlaporan.setText("laporan");
        jPanel1.add(btnlaporan, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 80, 80));

        btnbarang.setText("barang");
        btnbarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbarangActionPerformed(evt);
            }
        });
        jPanel1.add(btnbarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 410, 80, 70));

        btnsupplier.setText("karyawan");
        jPanel1.add(btnsupplier, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 650, 80, 90));

        btnsupplier1.setText("supplier");
        jPanel1.add(btnsupplier1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 530, 80, 80));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1080, 790));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btneditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneditActionPerformed
        // TODO add your handling code here:
        try {
            String sql = "UPDATE roti INNER JOIN supplier ON supplier.id_supp = roti.id_supp "
                    + "SET nama = '"+txtnama.getText()+"', harga_beli = '"+
                    txthargabeli.getText()+"', harga_jual = '"+txthargajual.getText()+"', stok = '"+txtstok.getText()
                    +"', nama_supp = '"+txtnama1.getText()+"', telp_supp = '"+txttelp.getText()+
                    "', alamat = '"+txtalamat.getText()+"' WHERE supplier.id_supp = '"+cbidsupp.getSelectedItem()+"'";                  
            java.sql.Connection conn=(Connection)connect_db.configDB();
            java.sql.PreparedStatement pst=conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "DATA BERHASIL DI EDIT");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "PERUBAHAN DATA GAGAL"
                        +e.getMessage());
        }
        load_table();
        kosong();
    }//GEN-LAST:event_btneditActionPerformed

    private void btnclearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnclearActionPerformed
        // TODO add your handling code here:
        kosong();
    }//GEN-LAST:event_btnclearActionPerformed

    private void btnhapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnhapusActionPerformed
        // TODO add your handling code here:
        try {
            String sql  = "DELETE FROM roti WHERE id_roti='"+txtid.getText()+"'";
            java.sql.Connection conn=(Connection)connect_db.configDB();
            java.sql.PreparedStatement pst=conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(this, "BERHASIL DI HAPUS");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "GAGAL TERHAPUS");
        }
        load_table();
        kosong();
    }//GEN-LAST:event_btnhapusActionPerformed

    private void btncariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncariActionPerformed
        // TODO add your handling code here:
        load_table();
    }//GEN-LAST:event_btncariActionPerformed

    private void btnhomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnhomeActionPerformed
        // TODO add your handling code here:
//        this.setVisible(false);
//        new formHome().setVisible(true);
    }//GEN-LAST:event_btnhomeActionPerformed

    private void btnkasirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnkasirActionPerformed
        // TODO add your handling code here:
//        this.setVisible(false);
//        new formKasir().setVisible(true);
    }//GEN-LAST:event_btnkasirActionPerformed
                                    
    
    private void btntambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntambahActionPerformed
        // TODO add your handling code here:
         try {
            String sql1 = "INSERT INTO roti VALUES ('"+txtid.getText()+"','"
            +txtnama.getText()+"','"+txthargajual.getText()+"','"+txthargabeli.getText()+"','"
            +txtstok.getText()+"','"+cbidsupp.getSelectedItem()+"')";
            java.sql.Connection conn=(java.sql.Connection)(Connection)connect_db.configDB();
            java.sql.PreparedStatement pst1=conn.prepareStatement(sql1);
            pst1.execute();
            this.setVisible(false);
            new formBarang().setVisible(true);
            JOptionPane.showMessageDialog(null, "Penyimpanan Data Berhasil");

        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        load_table();
        kosong();
    }//GEN-LAST:event_btntambahActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        // TODO add your handling code here:
                // TODO add your handling code here:
        int baris = jTable2.rowAtPoint(evt.getPoint());
        String barang = jTable2.getValueAt(baris,1).toString();
        txtid.setText(barang);
        txtid.disable();
        if (jTable2.getValueAt(baris, 2)==null){
            txtnama.setText("");
        } else {
            txtnama.setText(jTable2.getValueAt(baris, 2).toString());
        }
        if (jTable2.getValueAt(baris, 3)==null){
            txthargabeli.setText("");
        } else {
            txthargabeli.setText(jTable2.getValueAt(baris, 3).toString());
        }
        if (jTable2.getValueAt(baris, 4)==null){
            txthargajual.setText("");
        } else {
            txthargajual.setText(jTable2.getValueAt(baris, 4).toString());
        }
        if (jTable2.getValueAt(baris, 5)==null){
            txtstok.setText("");
        } else {
            txtstok.setText(jTable2.getValueAt(baris, 5).toString());
        if (jTable2.getValueAt(baris, 6)==null){
            cbidsupp.setSelectedItem("");
        } else {
            cbidsupp.setSelectedItem(jTable2.getValueAt(baris, 6).toString());
        if (jTable2.getValueAt(baris, 7)==null){
            txtnama1.setText("");
        } else {
            txtnama1.setText(jTable2.getValueAt(baris, 7).toString());
        if (jTable2.getValueAt(baris, 8)==null){
            txttelp.setText("");
        } else {
            txttelp.setText(jTable2.getValueAt(baris, 8).toString());
        if (jTable2.getValueAt(baris, 9)==null){
            txtalamat.setText("");
        } else {
            txtalamat.setText(jTable2.getValueAt(baris, 9).toString());
        }
        }
        }
        }
        }
    }//GEN-LAST:event_jTable2MouseClicked

    private void cbidsuppItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbidsuppItemStateChanged
        // TODO add your handling code here:
        otoidsupp();
    }//GEN-LAST:event_cbidsuppItemStateChanged

    private void btnbarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbarangActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new formBarang().setVisible(true);
    }//GEN-LAST:event_btnbarangActionPerformed

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
            java.util.logging.Logger.getLogger(formBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(formBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(formBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(formBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new formBarang().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnbarang;
    private javax.swing.JButton btncari;
    private javax.swing.JButton btnclear;
    private javax.swing.JButton btnedit;
    private javax.swing.JButton btnhapus;
    private javax.swing.JButton btnhome;
    private javax.swing.JButton btnkasir;
    private javax.swing.JButton btnlaporan;
    private javax.swing.JButton btnsupplier;
    private javax.swing.JButton btnsupplier1;
    private javax.swing.JButton btntambah;
    private javax.swing.JComboBox<String> cbidsupp;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField txtalamat;
    private javax.swing.JTextField txtcari;
    private javax.swing.JTextField txthargabeli;
    private javax.swing.JTextField txthargajual;
    private javax.swing.JTextField txtid;
    private javax.swing.JTextField txtnama;
    private javax.swing.JTextField txtnama1;
    private javax.swing.JTextField txtstok;
    private javax.swing.JTextField txttelp;
    // End of variables declaration//GEN-END:variables
}
