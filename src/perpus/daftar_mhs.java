/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perpus;

import java.awt.Dimension;
import java.awt.Toolkit;
import Fungsi.fungsi;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Kelompok 5
 */
public class daftar_mhs extends javax.swing.JFrame {
    public Statement st;
    public ResultSet rs;
    public ResultSet rs2;
    String sql;
    Connection con = koneksi.koneksi.getKoneksi();

    /**
     * Creates new form daftar_user
     */
    public daftar_mhs() {
        initComponents();
        autokode();
        user_id.setEditable(false);
        laki.setActionCommand("Laki-laki");
        perempuan.setActionCommand("Perempuan");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = getSize();
        setLocation(
        (screenSize.width - frameSize.width) / 2,
        (screenSize.height - frameSize.height) / 2);
    }
    public void reset(){
        nama_user.setText(null);
        pass_user.setText(null);
        pass_konfir.setText(null);
        ambil_kelamin.clearSelection();
        telp_user.setText(null);
        alamat_user.setText(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    
    
    public void reset_user(){
        nama_user.setText(null);
        pass_user.setText(null);
        pass_konfir.setText(null);
        ambil_kelamin.clearSelection();
        telp_user.setText(null);
        alamat_user.setText(null);
    }
    
    public Boolean kosong(){
        return (user_id.getText().equals("") || nama_user.getText().equals("") || pass_user.getText().equals("") || pass_konfir.getText().equals("") || (ambil_kelamin.getSelection() == null) || telp_user.getText().equals("") || alamat_user.getText().equals(""));

    }
    
     public Boolean tidak_sesuai(){
        String pass1 = pass_user.getText();
        String pass2 = pass_konfir.getText();
        return !(pass1.equals(pass2));
    }
    
    public void autokode(){
         try{
            String sql;
            sql = "SELECT COUNT(id_anggota) as jumlah FROM tb_anggota";
            st = con.createStatement();
            rs = st.executeQuery(sql);
            if (rs.next()) {
                String jumlah = rs.getString("jumlah");
                int jumint = Integer.parseInt(String.valueOf(jumlah));
                if (jumint > 0) {
                    st = con.createStatement();
                        sql = "SELECT MAX(id_anggota) AS kode FROM tb_anggota";
                        rs2 = st.executeQuery(sql);
                        if(rs2.next()){
                            String id = rs2.getString("kode").substring(3);
                            String kode = String.valueOf(Integer.parseInt(id) + 1);
                            if(kode.length() == 1){
                               user_id.setText("MHS00"+kode);
                            }else if(kode.length() == 2){
                                user_id.setText("MHS0"+kode);
                            }else
                                user_id.setText("MHS"+kode);
                        }
                }else{
                    user_id.setText("MHS001");
                }
            }
        }catch(SQLException e){
            
        }
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ambil_kelamin = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        user_id = new javax.swing.JTextField();
        jSeparator6 = new javax.swing.JSeparator();
        jLabel14 = new javax.swing.JLabel();
        jSeparator7 = new javax.swing.JSeparator();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        telp_user = new javax.swing.JTextField();
        jSeparator9 = new javax.swing.JSeparator();
        jLabel17 = new javax.swing.JLabel();
        alamat_user = new javax.swing.JTextField();
        jSeparator10 = new javax.swing.JSeparator();
        daftar_user = new javax.swing.JButton();
        close = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        laki = new javax.swing.JRadioButton();
        perempuan = new javax.swing.JRadioButton();
        kembali = new javax.swing.JButton();
        jdsfks = new javax.swing.JLabel();
        jSeparator8 = new javax.swing.JSeparator();
        pass_user = new javax.swing.JPasswordField();
        nama_user = new javax.swing.JTextField();
        jdsfks1 = new javax.swing.JLabel();
        jSeparator12 = new javax.swing.JSeparator();
        pass_konfir = new javax.swing.JPasswordField();
        jLabel20 = new javax.swing.JLabel();
        reset = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(221, 219, 219));
        jPanel1.setForeground(new java.awt.Color(2, 62, 138));

        jLabel3.setFont(new java.awt.Font("Segoe UI Historic", 1, 22)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(2, 62, 138));
        jLabel3.setText("Daftar");

        jLabel13.setFont(new java.awt.Font("Segoe UI Historic", 0, 16)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(2, 62, 138));
        jLabel13.setText("Mahasiswa ID");

        user_id.setBackground(new java.awt.Color(221, 219, 219));
        user_id.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        user_id.setForeground(new java.awt.Color(2, 62, 138));
        user_id.setBorder(null);

        jSeparator6.setForeground(new java.awt.Color(2, 62, 138));

        jLabel14.setFont(new java.awt.Font("Segoe UI Historic", 0, 16)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(2, 62, 138));
        jLabel14.setText("Nama Lengkap");

        jSeparator7.setForeground(new java.awt.Color(2, 62, 138));

        jLabel15.setFont(new java.awt.Font("Segoe UI Historic", 0, 16)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(2, 62, 138));
        jLabel15.setText("Jenis Kelamin");

        jLabel16.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(2, 62, 138));
        jLabel16.setText("No Telepon");

        telp_user.setBackground(new java.awt.Color(221, 219, 219));
        telp_user.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        telp_user.setForeground(new java.awt.Color(2, 62, 138));
        telp_user.setBorder(null);
        telp_user.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                angka(evt);
            }
        });

        jSeparator9.setForeground(new java.awt.Color(2, 62, 138));

        jLabel17.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(2, 62, 138));
        jLabel17.setText("Alamat");

        alamat_user.setBackground(new java.awt.Color(221, 219, 219));
        alamat_user.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        alamat_user.setForeground(new java.awt.Color(2, 62, 138));
        alamat_user.setBorder(null);

        jSeparator10.setForeground(new java.awt.Color(2, 62, 138));

        daftar_user.setBackground(new java.awt.Color(2, 62, 138));
        daftar_user.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        daftar_user.setForeground(new java.awt.Color(255, 255, 255));
        daftar_user.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/13. Plus.png"))); // NOI18N
        daftar_user.setText("Daftar");
        daftar_user.setBorder(null);
        daftar_user.setContentAreaFilled(false);
        daftar_user.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        daftar_user.setOpaque(true);
        daftar_user.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                daftar_userActionPerformed(evt);
            }
        });

        close.setBackground(new java.awt.Color(28, 42, 57));
        close.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        close.setForeground(new java.awt.Color(255, 255, 255));
        close.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/2. Close.png"))); // NOI18N
        close.setToolTipText("Tutup");
        close.setBorder(null);
        close.setBorderPainted(false);
        close.setContentAreaFilled(false);
        close.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        close.setFocusPainted(false);
        close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeActionPerformed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Century Gothic", 0, 10)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(192, 16, 5));
        jLabel19.setText("* Maksimal 13 karakter");

        laki.setBackground(new java.awt.Color(2, 62, 138));
        ambil_kelamin.add(laki);
        laki.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        laki.setForeground(new java.awt.Color(2, 62, 138));
        laki.setText("Laki-Laki");
        laki.setBorder(null);
        laki.setContentAreaFilled(false);
        laki.setFocusPainted(false);

        perempuan.setBackground(new java.awt.Color(2, 62, 138));
        ambil_kelamin.add(perempuan);
        perempuan.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        perempuan.setForeground(new java.awt.Color(2, 62, 138));
        perempuan.setText("Perempuan");
        perempuan.setBorder(null);
        perempuan.setContentAreaFilled(false);
        perempuan.setFocusPainted(false);
        perempuan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                perempuanActionPerformed(evt);
            }
        });

        kembali.setBackground(new java.awt.Color(28, 42, 57));
        kembali.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        kembali.setForeground(new java.awt.Color(2, 62, 138));
        kembali.setText("kembali");
        kembali.setToolTipText("Logout");
        kembali.setBorder(null);
        kembali.setBorderPainted(false);
        kembali.setContentAreaFilled(false);
        kembali.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        kembali.setFocusPainted(false);
        kembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kembaliActionPerformed(evt);
            }
        });

        jdsfks.setFont(new java.awt.Font("Segoe UI Historic", 0, 16)); // NOI18N
        jdsfks.setForeground(new java.awt.Color(2, 62, 138));
        jdsfks.setText("Password");

        jSeparator8.setForeground(new java.awt.Color(2, 62, 138));

        pass_user.setBackground(new java.awt.Color(221, 219, 219));
        pass_user.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        pass_user.setForeground(new java.awt.Color(2, 62, 138));
        pass_user.setBorder(null);
        pass_user.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        nama_user.setBackground(new java.awt.Color(221, 219, 219));
        nama_user.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        nama_user.setForeground(new java.awt.Color(2, 62, 138));
        nama_user.setBorder(null);

        jdsfks1.setFont(new java.awt.Font("Segoe UI Historic", 0, 16)); // NOI18N
        jdsfks1.setForeground(new java.awt.Color(2, 62, 138));
        jdsfks1.setText("Konfirmasi Password");

        jSeparator12.setForeground(new java.awt.Color(2, 62, 138));

        pass_konfir.setBackground(new java.awt.Color(221, 219, 219));
        pass_konfir.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        pass_konfir.setForeground(new java.awt.Color(2, 62, 138));
        pass_konfir.setBorder(null);
        pass_konfir.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        jLabel20.setFont(new java.awt.Font("Century Gothic", 0, 10)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(192, 16, 5));
        jLabel20.setText("* Minimal 8 karakter");

        reset.setBackground(new java.awt.Color(2, 62, 138));
        reset.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        reset.setForeground(new java.awt.Color(255, 255, 255));
        reset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/16. Reset.png"))); // NOI18N
        reset.setText("Reset");
        reset.setBorder(null);
        reset.setContentAreaFilled(false);
        reset.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        reset.setOpaque(true);
        reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(jLabel3)
                        .addGap(452, 452, 452)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addComponent(close, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(kembali, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(jLabel13))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(user_id, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 560, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(nama_user, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 560, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(jdsfks))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(pass_user, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(jLabel20))
                            .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 560, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(jdsfks1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(pass_konfir, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(jSeparator12, javax.swing.GroupLayout.PREFERRED_SIZE, 560, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(jLabel15))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(laki, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(perempuan, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(jLabel16))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(telp_user, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator9, javax.swing.GroupLayout.PREFERRED_SIZE, 560, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(jLabel19))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(jLabel17))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(alamat_user, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(daftar_user, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(24, 24, 24)
                                .addComponent(reset, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jSeparator10, javax.swing.GroupLayout.PREFERRED_SIZE, 560, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(close, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(kembali)))
                .addGap(30, 30, 30)
                .addComponent(jLabel13)
                .addGap(6, 6, 6)
                .addComponent(user_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jLabel14)
                .addGap(4, 4, 4)
                .addComponent(nama_user, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jdsfks)
                .addGap(6, 6, 6)
                .addComponent(pass_user, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addComponent(jdsfks1)
                .addGap(6, 6, 6)
                .addComponent(pass_konfir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jSeparator12, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jLabel15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(laki, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(perempuan, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addComponent(jLabel16)
                .addGap(6, 6, 6)
                .addComponent(telp_user, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator9, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel19)))
                .addGap(6, 6, 6)
                .addComponent(jLabel17)
                .addGap(9, 9, 9)
                .addComponent(alamat_user, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jSeparator10, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(reset, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(daftar_user, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void closeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeActionPerformed
        // TODO add your handling code here:
        fungsi.close();
    }//GEN-LAST:event_closeActionPerformed

    private void angka(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_angka
        // TODO add your handling code here:
        if(!Character.isDigit(evt.getKeyChar()) || telp_user.getText().length()>=13){
            evt.consume();
        }
    }//GEN-LAST:event_angka

    private void daftar_userActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_daftar_userActionPerformed
        // TODO add your handling code here:
        
        
        if(kosong()){
            JOptionPane.showMessageDialog(null, "Harap Lengkapi Data !","Kesalahan", JOptionPane.ERROR_MESSAGE);
        }else if(pass_user.getText().length()<8){
            JOptionPane.showMessageDialog(null, "Password minimal 8 karakter !","Kesalahan", JOptionPane.ERROR_MESSAGE);
        }else if(tidak_sesuai()){
            JOptionPane.showMessageDialog(null, "Password tidak sesuai !","Kesalahan", JOptionPane.ERROR_MESSAGE);            
        }else{
            Kebijakan kb = new Kebijakan();
            kb.show();
            int jawab;
            if((jawab = JOptionPane.showConfirmDialog(null,"Dengan menekan tombol 'Yes' maka anda menerima segala kebijakan perpus ini", "Konfirmasi", JOptionPane.OK_CANCEL_OPTION)) == 0){
                try {
                String id = user_id.getText();
                String nama = nama_user.getText();
                String pass = pass_user.getText();
                String jk = ambil_kelamin.getSelection().getActionCommand();
                String telp = telp_user.getText();
                String alamat = alamat_user.getText();
                sql = "INSERT INTO tb_anggota VALUES('"+ id +"','"+ nama +"','"+ pass +"','"+ jk +"','"+ telp +"','"+ alamat +"','Tidak pinjam')";
                st = con.createStatement();
                st.executeUpdate(sql);
                JOptionPane.showMessageDialog(null, "Berhasil Mendaftar");
                autokode();
                Login lg = new Login();
                lg.show();
                this.dispose();
                kb.dispose();
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Terjadi Kesalahan");
                reset();
            }
            }
        }
    }//GEN-LAST:event_daftar_userActionPerformed

    private void kembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kembaliActionPerformed
        // TODO add your handling code here:
        Login lg = new Login();
        lg.show();
        this.dispose();
    }//GEN-LAST:event_kembaliActionPerformed

    private void resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetActionPerformed
        // TODO add your handling code here:
        reset_user();
    }//GEN-LAST:event_resetActionPerformed

    private void perempuanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_perempuanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_perempuanActionPerformed

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
            java.util.logging.Logger.getLogger(daftar_mhs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(daftar_mhs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(daftar_mhs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(daftar_mhs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new daftar_mhs().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField alamat_user;
    private javax.swing.ButtonGroup ambil_kelamin;
    private javax.swing.JButton close;
    private javax.swing.JButton daftar_user;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JLabel jdsfks;
    private javax.swing.JLabel jdsfks1;
    private javax.swing.JButton kembali;
    private javax.swing.JRadioButton laki;
    private javax.swing.JTextField nama_user;
    private javax.swing.JPasswordField pass_konfir;
    private javax.swing.JPasswordField pass_user;
    private javax.swing.JRadioButton perempuan;
    private javax.swing.JButton reset;
    private javax.swing.JTextField telp_user;
    private javax.swing.JTextField user_id;
    // End of variables declaration//GEN-END:variables
}
