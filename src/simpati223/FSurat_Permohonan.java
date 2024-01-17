/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simpati223;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.LineSeparator;
import java.awt.Desktop;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import static simpati223.FSurat_Keterangan.hideJTableColumn;

/**
 *
 * @author Ikhsan Abdillah
 */
public class FSurat_Permohonan extends javax.swing.JInternalFrame {
    
    /**
     * Creates new form FGuru
     */
    
    private DefaultTableModel DftTblModel_Permohonan;
    public String dateChooser,atas_nama,nip,nrk,pangkat,golongan,jabatan,pensiun;
    private String SQL;
    
    public FSurat_Permohonan() {
        initComponents();
        Combox1("");
        jComboBox2.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    try {
                        Connection conn = Koneksi.getConnection();
                        Object selectedItem = jComboBox2.getSelectedItem();
                        if (selectedItem != null) {
                            java.sql.Statement stmt = conn.createStatement();
                            SQL = "select * from guru where nama = '"+selectedItem+"'";
                            java.sql.ResultSet res = stmt.executeQuery(SQL);

                            while (res.next()) {
                                atas_nama = res.getString("id");
                            }
                        }
                    } catch (SQLException es) {
                        JOptionPane.showMessageDialog(null, "Ada kesalahan server, silahkan hubungi developer", "Pesan", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }
        });
        
        jDateChooser1.addPropertyChangeListener("date", new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                if ("date".equals(evt.getPropertyName())) {
                    try {
                        if (jDateChooser1.getDate()!= null) {
                            String tanggal = "yyyy-MM-dd";
                            SimpleDateFormat format = new SimpleDateFormat (tanggal);
                            dateChooser = String.valueOf(format.format(jDateChooser1.getDate()));
                        }
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Ada kesalahan server, silahkan hubungi developer", "Pesan", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }
        });
        //letakkan fungsi tampil data disini
        TampilData();
        disableData();
    }

    private void setTanggal(){
        Connection conn = Koneksi.getConnection();
        try {
            java.sql.Statement stmt = conn.createStatement();
            SQL = "select * from surat_permohonan where id like '%" +jTextField2.getText()+"'";
            java.sql.ResultSet res = stmt.executeQuery(SQL);
            while (res.next())
            {
                jDateChooser1.setDate(res.getDate("tgl_surat", null));
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Ada kesalahan server, silahkan hubungi developer", "Pesan", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    
    
    private void Combox1(String id_guru){
        Connection conn = Koneksi.getConnection();
        if (id_guru.isEmpty()) {
            try {
                 java.sql.Statement stmt = conn.createStatement();
                SQL = "select * from guru";
                java.sql.ResultSet res = stmt.executeQuery(SQL);

                while (res.next()) {                
                    jComboBox2.addItem(res.getString("nama"));
                }

                res.last();
                int jumlahdata = res.getRow();
                res.first();

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Ada kesalahan server, silahkan hubungi developer", "Pesan", JOptionPane.INFORMATION_MESSAGE);
            }  
        } else {
            try {
                java.sql.Statement stmt = conn.createStatement();
                SQL = "select * from guru a where nama = '"+id_guru+"'";
                java.sql.ResultSet res = stmt.executeQuery(SQL);

                while (res.next()) {
                    atas_nama = res.getString("id");
                    nip = res.getString("nip");
                    nrk = res.getString("nrk");
                    pangkat = res.getString("pangkat");
                    golongan = res.getString("golongan");
                    jabatan = res.getString("jabatan");
                    pensiun = res.getString("pensiun");
                }
            } catch (SQLException es) {
                JOptionPane.showMessageDialog(null, "Ada kesalahan server, silahkan hubungi developer", "Pesan", JOptionPane.INFORMATION_MESSAGE);
            }
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

        jPanel2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jTextField12 = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jComboBox1 = new javax.swing.JComboBox();
        jComboBox2 = new javax.swing.JComboBox();
        jTextField1 = new javax.swing.JTextField();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();

        setPreferredSize(new java.awt.Dimension(700, 600));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setToolTipText("");
        jPanel2.setName(""); // NOI18N

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel9.setText("No Surat");
        jLabel9.setPreferredSize(new java.awt.Dimension(50, 15));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel10.setText("Tgl Surat");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel11.setText("Sifat");
        jLabel11.setPreferredSize(new java.awt.Dimension(50, 15));

        jTextField6.setPreferredSize(new java.awt.Dimension(145, 25));

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel12.setText("Lampiran");
        jLabel12.setPreferredSize(new java.awt.Dimension(50, 15));

        jTextField7.setPreferredSize(new java.awt.Dimension(100, 25));

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel13.setText("Perihal");
        jLabel13.setPreferredSize(new java.awt.Dimension(100, 15));

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel14.setText("Kepada");
        jLabel14.setPreferredSize(new java.awt.Dimension(100, 15));

        jTextField8.setPreferredSize(new java.awt.Dimension(145, 25));

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel15.setText("Keterangan");
        jLabel15.setPreferredSize(new java.awt.Dimension(50, 15));

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel18.setText("Atas Nama");
        jLabel18.setPreferredSize(new java.awt.Dimension(100, 15));

        jTextField12.setPreferredSize(new java.awt.Dimension(145, 25));

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel19.setText("Jenis permohonan");
        jLabel19.setPreferredSize(new java.awt.Dimension(100, 15));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "----Pilih----", "pensiun", "lainnya" }));
        jComboBox1.setPreferredSize(new java.awt.Dimension(145, 25));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "----Pilih----" }));
        jComboBox2.setPreferredSize(new java.awt.Dimension(145, 25));
        jComboBox2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jComboBox2KeyReleased(evt);
            }
        });

        jTextField1.setPreferredSize(new java.awt.Dimension(145, 25));

        jDateChooser1.setPreferredSize(new java.awt.Dimension(145, 25));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("File");
        jLabel2.setPreferredSize(new java.awt.Dimension(44, 15));

        jButton6.setText("Cetak");
        jButton6.setPreferredSize(new java.awt.Dimension(145, 25));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jButton6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButton6KeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel17)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel17)
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(15, 15, 15)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane2))
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setForeground(new java.awt.Color(255, 255, 255));

        jButton2.setBackground(new java.awt.Color(51, 0, 204));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Simpan");
        jButton2.setPreferredSize(new java.awt.Dimension(120, 33));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jButton2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButton2KeyPressed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(255, 204, 0));
        jButton3.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Ubah");
        jButton3.setPreferredSize(new java.awt.Dimension(120, 33));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jButton3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButton3KeyPressed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(204, 0, 0));
        jButton4.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Hapus");
        jButton4.setPreferredSize(new java.awt.Dimension(120, 33));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jButton4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButton4KeyPressed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(0, 153, 0));
        jButton5.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("Batal");
        jButton5.setPreferredSize(new java.awt.Dimension(120, 33));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jButton5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButton5KeyPressed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(0, 153, 153));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("New");
        jButton1.setMaximumSize(new java.awt.Dimension(109, 31));
        jButton1.setPreferredSize(new java.awt.Dimension(100, 33));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jButton1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButton1KeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nama", "NIP", "NRK", "Jabatan", "Golongan"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 740, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)
                .addGap(10, 10, 10))
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Surat Permohonan");

        jTextField2.setPreferredSize(new java.awt.Dimension(60, 20));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(40, 40, 40))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                    .addComponent(jLabel1))
                .addGap(7, 7, 7))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    
    public static void hideJTableColumn(TableColumn tc) {
       lockJTableColumnWidth(tc, 0);
   }

   public static void lockJTableColumnWidth(TableColumn tc, int pixels) {
       if (tc != null) {
           tc.setMinWidth(pixels);
           tc.setMaxWidth(pixels);
           tc.setPreferredWidth(pixels);
           tc.setResizable(false);
       }
   }
   
    public void TampilData() {
        DftTblModel_Permohonan = new DefaultTableModel();
        DftTblModel_Permohonan.addColumn("id");
        DftTblModel_Permohonan.addColumn("No Surat"); //tampilin ke layar
        DftTblModel_Permohonan.addColumn("Tanggal"); //tampilin ke layar
        DftTblModel_Permohonan.addColumn("Sifat"); //tampilin ke layar
        DftTblModel_Permohonan.addColumn("Lampiran"); //tampilin ke layar
        DftTblModel_Permohonan.addColumn("Perihal"); //tampilin ke layar
        DftTblModel_Permohonan.addColumn("Kepada");
        DftTblModel_Permohonan.addColumn("Keterangan"); 
        DftTblModel_Permohonan.addColumn("Atas Nama");
        DftTblModel_Permohonan.addColumn("Jenis Permohonan");
        
        jTable1.setModel(DftTblModel_Permohonan);
        Connection conn = Koneksi.getConnection();
        try {
            java.sql.Statement stmt = conn.createStatement();
            SQL = "select a.*, b.nama as nama_guru from surat_permohonan a "+
                  "LEFT JOIN guru b ON a.atas_nama = b.id";
            java.sql.ResultSet res = stmt.executeQuery(SQL);
            while (res.next()) {
                DftTblModel_Permohonan.addRow(new Object[]{
                    res.getString("id"),
                    res.getString("no_surat"), //tampilin ke layar
                    res.getString("tgl_surat"), //tampilin ke layar
                    res.getString("sifat"), //tampilin ke layar
                    res.getString("lampiran"), //tampilin ke layar
                    res.getString("perihal"), //tampilin ke layar
                    res.getString("kepada"),
                    res.getString("keterangan"),
                    res.getString("nama_guru"),
                    res.getString("jenis_permohonan")
                });
            }
            hideJTableColumn(jTable1.getColumnModel().getColumn(0));
            hideJTableColumn(jTable1.getColumnModel().getColumn(6));
            hideJTableColumn(jTable1.getColumnModel().getColumn(7));
            hideJTableColumn(jTable1.getColumnModel().getColumn(8));
            hideJTableColumn(jTable1.getColumnModel().getColumn(9));
            TableColumn column = jTable1.getColumnModel().getColumn(2);
            column.setPreferredWidth(8);
            column = jTable1.getColumnModel().getColumn(3);
            column.setPreferredWidth(8);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ada kesalahan server, silahkan hubungi developer", "Pesan", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    public void disableData(){
        jTextField2.setVisible(false);
        jButton2.setEnabled(false);
        jButton3.setEnabled(false);
        jButton4.setEnabled(false);
        jButton6.setEnabled(false);
        //atur dibawahnya
        jTextField1.setEnabled(false);
        jDateChooser1.setEnabled(false);
        jTextField6.setEnabled(false);
        jTextField7.setEnabled(false);
        jTextField12.setEnabled(false);
        jTextField8.setEnabled(false);
        jTextArea1.setEnabled(false);
        jComboBox2.setEnabled(false);
        jComboBox1.setEnabled(false);
        
    }
//    
    public void enableData(){
        jButton2.setEnabled(true);
        jButton3.setEnabled(false);
        jButton4.setEnabled(false);
        jButton6.setEnabled(false);
        //atur dibawahnya
        jTextField1.setEnabled(true);
        jDateChooser1.setEnabled(true);
        jTextField6.setEnabled(true);
        jTextField7.setEnabled(true);
        jTextField12.setEnabled(true);
        jTextField8.setEnabled(true);
        jTextArea1.setEnabled(true);
        jComboBox2.setEnabled(true);
        jComboBox1.setEnabled(true);
        
    }
//    
    public void enableDataEdit(){
        jButton2.setEnabled(false);
        jButton3.setEnabled(true);
        jButton4.setEnabled(true);
        jButton6.setEnabled(true);
        //atur dibawahnya
        jTextField1.setEnabled(true);
        jDateChooser1.setEnabled(true);
        jTextField6.setEnabled(true);
        jTextField7.setEnabled(true);
        jTextField12.setEnabled(true);
        jTextField8.setEnabled(true);
        jTextArea1.setEnabled(true);
        jComboBox2.setEnabled(true);
        jComboBox1.setEnabled(true);
        
    }
//    
    public void clearData(){
        jTextField2.setText("");
        jTextField1.setText("");
        jDateChooser1.setDate(null);
        jTextField6.setText("");
        jTextField7.setText("");
        jTextField12.setText("");
        jTextField8.setText("");
        jTextArea1.setText("");
        jComboBox2.setSelectedItem("");
        jComboBox1.setSelectedItem("");
        
    }
//    
    public void getData(){
        jTextField2.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString());
        //atur dibawahnya 
        jTextField1.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 1).toString());
        setTanggal();
        jTextField6.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 3).toString());
        jTextField7.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 4).toString());
        jTextField12.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 5).toString());
        jTextField8.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 6).toString());
        jTextArea1.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 7).toString());
        Object obj = jTable1.getValueAt(jTable1.getSelectedRow(), 8);
        jComboBox2.setSelectedItem(obj);
        Combox1((String) obj);
        Object obj1 = jTable1.getValueAt(jTable1.getSelectedRow(), 9);
        jComboBox1.setSelectedItem(obj1);
        jButton2.setEnabled(false);
    }
//    
    public void simpanData(){
        try {
            Connection conn = Koneksi.getConnection();
            PreparedStatement stmt = conn.prepareStatement("insert into surat_permohonan(no_surat, tgl_surat, sifat, lampiran,"
                    + " perihal, kepada, keterangan, atas_nama, jenis_permohonan) "
                    + "values(?,?,?,?,?,?,?,?,?)");
            stmt.setString(1, jTextField1.getText());
            stmt.setObject(2, jDateChooser1.getDate());
            stmt.setString(3, jTextField6.getText());
            stmt.setString(4, jTextField7.getText());
            stmt.setString(5, jTextField12.getText());
            stmt.setString(6, jTextField8.getText());
            stmt.setString(7, jTextArea1.getText());
            stmt.setObject(8, atas_nama);
            stmt.setObject(9, jComboBox1.getItemAt(jComboBox1.getSelectedIndex()));
            
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data berhasil disimpan", "Pesan", JOptionPane.INFORMATION_MESSAGE);
            TampilData();
            clearData();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Data gagal simpan", "Pesan", JOptionPane.INFORMATION_MESSAGE);
        }
    }
//    
    public void editData(){
        try {
            Connection conn = Koneksi.getConnection();
            Object id = jTable1.getValueAt(jTable1.getSelectedRow(), 0);
            PreparedStatement stmt = conn.prepareStatement("UPDATE surat_permohonan SET no_surat='" + jTextField1.getText() + 
                    "'," + "tgl_surat ='" + dateChooser +"',sifat ='" +jTextField6.getText()+
                    "'," + "lampiran ='" +jTextField7.getText() +"',perihal ='" +jTextField12.getText()+
                    "'," + "kepada ='" +jTextField8.getText() +"',keterangan ='" +jTextArea1.getText()+
                    "'," + "atas_nama ='" + atas_nama +
                    "'," + "jenis_permohonan ='" + jComboBox1.getItemAt(jComboBox1.getSelectedIndex()) +
                    "' WHERE id='" +id+"'");
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data berhasil diubah", "Pesan", JOptionPane.INFORMATION_MESSAGE);
            TampilData();
            clearData();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Data gagal diubah", "Pesan", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    public void deleteData(){
        Connection conn = Koneksi.getConnection();
        int confirm = JOptionPane.showConfirmDialog(null, "Apakah anda yakin ingin menghapus data tersebut?", 
                "Konfirmasi", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (confirm == 0) {
            try {
                Object id = jTable1.getValueAt(jTable1.getSelectedRow(), 0);
                java.sql.PreparedStatement stmt = conn.prepareStatement("delete from surat_permohonan "
                        + "where id ='" + id + "'");
                stmt.executeUpdate();
                JOptionPane.showMessageDialog(null, "Data berhasil dihapus", "Pesan", 
                        JOptionPane.INFORMATION_MESSAGE);
                TampilData();
                clearData();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Data gagal dihapus" + e.getMessage(), "Pesan", 
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        simpanData();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton2KeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER){
            simpanData();
        }
    }//GEN-LAST:event_jButton2KeyPressed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        String id = jTextField2.getText();
        if (id.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Silahkan pilih data terlebih dahulu atau klik tombol new", "Pesan", JOptionPane.INFORMATION_MESSAGE);
        } else {
            editData();
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton3KeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER){
            String id = jTextField2.getText();
            if (id.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Silahkan pilih data terlebih dahulu atau klik tombol new", "Pesan", JOptionPane.INFORMATION_MESSAGE);
            } else {
                editData();
            }
        }
    }//GEN-LAST:event_jButton3KeyPressed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        String id = jTextField2.getText();
        if (id.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Silahkan pilih data terlebih dahulu atau klik tombol new", "Pesan", JOptionPane.INFORMATION_MESSAGE);
        } else {
            deleteData();
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton4KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton4KeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER){
            String id = jTextField2.getText();
            if (id.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Silahkan pilih data terlebih dahulu atau klik tombol new", "Pesan", JOptionPane.INFORMATION_MESSAGE);
            } else {
                deleteData();
            }
        }
    }//GEN-LAST:event_jButton4KeyPressed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton5KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton5KeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            dispose();
        }
    }//GEN-LAST:event_jButton5KeyPressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        enableData();
        clearData();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton1KeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            enableData();
            clearData();
        }
    }//GEN-LAST:event_jButton1KeyPressed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        getData();
        enableDataEdit();
    }//GEN-LAST:event_jTable1MouseClicked

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jDateChooser1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jDateChooser1PropertyChange
        // TODO add your handling code here:
        try {
            if (jDateChooser1.getDate()!= null) {
                String tanggal = "yyyy-MM-dd";
                SimpleDateFormat format = new SimpleDateFormat (tanggal);
                dateChooser = String.valueOf(format.format(jDateChooser1.getDate()));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ada kesalahan server, silahkan hubungi developer", "Pesan", JOptionPane.INFORMATION_MESSAGE);
        }         
    }//GEN-LAST:event_jDateChooser1PropertyChange

    private void jComboBox2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboBox2KeyReleased
          // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2KeyReleased

    // Helper method to add a table row
    private static void addTableRow(PdfPTable table, String col1, String col2, String col3, String col4,
                                    String col5, String col6, String col7, String col8) {
        table.addCell(col1);
        table.addCell(col2);
        table.addCell(col3);
        table.addCell(col4);
        table.addCell(col5);
        table.addCell(col6);
        table.addCell(col7);
        table.addCell(col8);
    }
    
    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        Connection conn = Koneksi.getConnection();
        try {
            FSurat_Permohonan sp = new FSurat_Permohonan();
            String no_surat = jTextField1.getText();
            String sifat = jTextField6.getText();
            String lampiran = jTextField7.getText();
            String perihal = jTextField12.getText();
            String kepada = jTextField8.getText();
            Object atas_namas = jComboBox2.getItemAt(jComboBox2.getSelectedIndex());
            sp.Combox1((String) atas_namas);
            Object jenis_permohonan = jComboBox1.getItemAt(jComboBox1.getSelectedIndex());
            String keterangan = jTextArea1.getText();
            String folderPath = "C:\\simpati223";
            String filePath = "C:\\simpati223\\surat_permohonan_"+atas_namas+".pdf";

            // Check if folder exists, create if it doesn't
            File folder = new File(folderPath);
            if (!folder.exists()) {
                boolean created = folder.mkdirs();
                if (created) {
                    System.out.println("Folder created successfully");
                } else {
                    System.out.println("Failed to create folder");
                }
            } else {
                System.out.println("Folder already exists");
            }

            // Check if file exists, create if it doesn't
            File file = new File(filePath);
            if (!file.exists()) {
                try {
                    boolean created = file.createNewFile();
                    if (created) {
                        //after created file, then we can create a content from pdf
                        //50 pertama itu left
                        //50 kedua itu right
                        Document document = new Document(PageSize.A4, 65, 65, 5, 50);
                        PdfWriter.getInstance(document, new FileOutputStream(filePath));

                        document.open();

                        // Create the header table
                        PdfPTable headerTable = new PdfPTable(2);
                        headerTable.setWidthPercentage(100);
                        headerTable.setWidths(new float[]{13, 87});

                        // Create the image cell
                        PdfPCell imageCell = new PdfPCell();
                        Image logo = Image.getInstance(getClass().getResource("/logo-jakarta-raya.jpeg"));
                        logo.scaleToFit(87, 125);
                        logo.setSpacingBefore(10f);
                        imageCell.addElement(logo);
                        imageCell.setRowspan(7);
                        imageCell.setBorder(PdfPCell.NO_BORDER);
                        headerTable.addCell(imageCell);

                        // Create the text cell
                        PdfPCell textCell = new PdfPCell();
                        Paragraph paragraph1 = new Paragraph("PEMERINTAH PROVINSI DAERAH KHUSUS IBUKOTA JAKARTA\nDINAS PENDIDIKAN", new Font(Font.FontFamily.HELVETICA, 10));
                        paragraph1.setAlignment(Paragraph.ALIGN_CENTER);
                        Paragraph paragraph2 = new Paragraph("SMP NEGERI 223 JAKARTA", new Font(Font.FontFamily.HELVETICA, 13, Font.BOLD));
                        paragraph2.setAlignment(Paragraph.ALIGN_CENTER);
                        Paragraph paragraph3 = new Paragraph("Jl. Surilang No. 6 Kel. Gedong Kec. Pasar Rebo\nTelepon (021) 8403316 Faximile (021) 8403316", new Font(Font.FontFamily.HELVETICA,11));
                        paragraph3.setAlignment(Paragraph.ALIGN_CENTER);
                        Paragraph paragraph4 = new Paragraph("E-mail: smpn223jktm@gmail.com\nJAKARTA", new Font(Font.FontFamily.HELVETICA, 11));
                        paragraph4.setAlignment(Paragraph.ALIGN_CENTER);
                        Paragraph paragraph5 = new Paragraph("Kode Pos : 13760", new Font(Font.FontFamily.HELVETICA, 11));
                        paragraph5.setAlignment(Paragraph.ALIGN_RIGHT);
                        Paragraph paragraph6 = new Paragraph(" ", new Font(Font.FontFamily.HELVETICA, 3));

                        textCell.addElement(paragraph1);
                        textCell.addElement(paragraph2);
                        textCell.addElement(paragraph3);
                        textCell.addElement(paragraph4);
                        textCell.addElement(paragraph5);
                        textCell.addElement(paragraph6);
                        textCell.setBorder(PdfPCell.NO_BORDER);
                        headerTable.addCell(textCell);

                        // Add the header table to the document
                        document.add(headerTable);

                        // Add a horizontal line
                        LineSeparator lineSeparator = new LineSeparator();
                        lineSeparator.setLineWidth(4);
                        document.add(lineSeparator);

                        Paragraph para1 = new Paragraph(" ");
                        para1.setPaddingTop(35f);

                        document.add(para1);

                        PdfPTable table = new PdfPTable(8);

                        // Set table properties
                        table.setWidthPercentage(100);
                        table.setHorizontalAlignment(Element.ALIGN_LEFT);
                        float[] columnWidths = {1f, 0.3f, 2f, 0.3f, 0.4f, 0.4f, 0.4f, 2f};
                        table.setWidths(columnWidths);

                        PdfPCell row1_cellOne = new PdfPCell(new Phrase("Nomor"));
                        PdfPCell row1_cellTwo = new PdfPCell(new Phrase(":"));
                        PdfPCell row1_cellThree = new PdfPCell(new Phrase(no_surat));
                        PdfPCell row1_cellFour = new PdfPCell(new Phrase(""));
                        PdfPCell row1_cellFive = new PdfPCell(new Phrase(""));
                        PdfPCell row1_cellSix = new PdfPCell(new Phrase(""));
                        PdfPCell row1_cellSeven = new PdfPCell(new Phrase(""));
                        PdfPCell row1_cellEight = new PdfPCell(new Phrase(Fungsi.getDate(dateChooser)));

                        row1_cellOne.setBorder(Rectangle.NO_BORDER);
                        row1_cellTwo.setBorder(Rectangle.NO_BORDER);
                        row1_cellThree.setBorder(Rectangle.NO_BORDER);
                        row1_cellFour.setBorder(Rectangle.NO_BORDER);
                        row1_cellFive.setBorder(Rectangle.NO_BORDER);
                        row1_cellSix.setBorder(Rectangle.NO_BORDER);
                        row1_cellSeven.setBorder(Rectangle.NO_BORDER);
                        row1_cellEight.setBorder(Rectangle.NO_BORDER);

                        // Add table cells
                        table.addCell(row1_cellOne);
                        table.addCell(row1_cellTwo);
                        table.addCell(row1_cellThree);
                        table.addCell(row1_cellFour);
                        table.addCell(row1_cellFive);
                        table.addCell(row1_cellSix);
                        table.addCell(row1_cellSeven);
                        table.addCell(row1_cellEight);

                        PdfPCell row2_cellOne = new PdfPCell(new Phrase("Sifat"));
                        PdfPCell row2_cellTwo = new PdfPCell(new Phrase(":"));
                        PdfPCell row2_cellThree = new PdfPCell(new Phrase(sifat));
                        PdfPCell row2_cellFour = new PdfPCell(new Phrase(""));
                        PdfPCell row2_cellFive = new PdfPCell(new Phrase(""));
                        PdfPCell row2_cellSix = new PdfPCell(new Phrase(""));
                        PdfPCell row2_cellSeven = new PdfPCell(new Phrase(""));
                        PdfPCell row2_cellEight = new PdfPCell(new Phrase(""));

                        row2_cellOne.setBorder(Rectangle.NO_BORDER);
                        row2_cellTwo.setBorder(Rectangle.NO_BORDER);
                        row2_cellThree.setBorder(Rectangle.NO_BORDER);
                        row2_cellFour.setBorder(Rectangle.NO_BORDER);
                        row2_cellFive.setBorder(Rectangle.NO_BORDER);
                        row2_cellSix.setBorder(Rectangle.NO_BORDER);
                        row2_cellSeven.setBorder(Rectangle.NO_BORDER);
                        row2_cellEight.setBorder(Rectangle.NO_BORDER);

                        // Add table cells
                        table.addCell(row2_cellOne);
                        table.addCell(row2_cellTwo);
                        table.addCell(row2_cellThree);
                        table.addCell(row2_cellFour);
                        table.addCell(row2_cellFive);
                        table.addCell(row2_cellSix);
                        table.addCell(row2_cellSeven);
                        table.addCell(row2_cellEight);

                        PdfPCell row3_cellOne = new PdfPCell(new Phrase("Lampiran"));
                        PdfPCell row3_cellTwo = new PdfPCell(new Phrase(":"));
                        PdfPCell row3_cellThree = new PdfPCell(new Phrase(lampiran));
                        PdfPCell row3_cellFour = new PdfPCell(new Phrase(""));
                        PdfPCell row3_cellFive = new PdfPCell(new Phrase(""));
                        PdfPCell row3_cellSix = new PdfPCell(new Phrase(""));
                        PdfPCell row3_cellSeven = new PdfPCell(new Phrase(""));
                        PdfPCell row3_cellEight = new PdfPCell(new Phrase(""));

                        row3_cellOne.setBorder(Rectangle.NO_BORDER);
                        row3_cellTwo.setBorder(Rectangle.NO_BORDER);
                        row3_cellThree.setBorder(Rectangle.NO_BORDER);
                        row3_cellFour.setBorder(Rectangle.NO_BORDER);
                        row3_cellFive.setBorder(Rectangle.NO_BORDER);
                        row3_cellSix.setBorder(Rectangle.NO_BORDER);
                        row3_cellSeven.setBorder(Rectangle.NO_BORDER);
                        row3_cellEight.setBorder(Rectangle.NO_BORDER);

                        // Add table cells
                        table.addCell(row3_cellOne);
                        table.addCell(row3_cellTwo);
                        table.addCell(row3_cellThree);
                        table.addCell(row3_cellFour);
                        table.addCell(row3_cellFive);
                        table.addCell(row3_cellSix);
                        table.addCell(row3_cellSeven);
                        table.addCell(row3_cellEight);

                        PdfPCell row4_cellOne = new PdfPCell(new Phrase("Perihal"));
                        PdfPCell row4_cellTwo = new PdfPCell(new Phrase(":"));
                        PdfPCell row4_cellThree = new PdfPCell(new Phrase(perihal));
                        PdfPCell row4_cellFour = new PdfPCell(new Phrase(""));
                        PdfPCell row4_cellFive = new PdfPCell(new Phrase(""));
                        PdfPCell row4_cellSix = new PdfPCell(new Phrase(""));
                        PdfPCell row4_cellSeven = new PdfPCell(new Phrase(""));
                        PdfPCell row4_cellEight = new PdfPCell(new Phrase("Kepada"));

                        row4_cellOne.setBorder(Rectangle.NO_BORDER);
                        row4_cellTwo.setBorder(Rectangle.NO_BORDER);
                        row4_cellThree.setBorder(Rectangle.NO_BORDER);
                        row4_cellFour.setBorder(Rectangle.NO_BORDER);
                        row4_cellFive.setBorder(Rectangle.NO_BORDER);
                        row4_cellSix.setBorder(Rectangle.NO_BORDER);
                        row4_cellSeven.setBorder(Rectangle.NO_BORDER);
                        row4_cellEight.setBorder(Rectangle.NO_BORDER);

                        // Add table cells
                        table.addCell(row4_cellOne);
                        table.addCell(row4_cellTwo);
                        table.addCell(row4_cellThree);
                        table.addCell(row4_cellFour);
                        table.addCell(row4_cellFive);
                        table.addCell(row4_cellSix);
                        table.addCell(row4_cellSeven);
                        table.addCell(row4_cellEight);

                        PdfPCell row5_cellOne = new PdfPCell(new Phrase(""));
                        PdfPCell row5_cellTwo = new PdfPCell(new Phrase(""));
                        PdfPCell row5_cellThree = new PdfPCell(new Phrase(""));
                        PdfPCell row5_cellFour = new PdfPCell(new Phrase(""));
                        PdfPCell row5_cellFive = new PdfPCell(new Phrase("Yth."));
                        PdfPCell row5_cellSix = new PdfPCell(new Phrase(""));
                        PdfPCell row5_cellSeven = new PdfPCell(new Phrase(""));
                        PdfPCell row5_cellEight = new PdfPCell(new Phrase(kepada));

                        row5_cellOne.setBorder(Rectangle.NO_BORDER);
                        row5_cellTwo.setBorder(Rectangle.NO_BORDER);
                        row5_cellThree.setBorder(Rectangle.NO_BORDER);
                        row5_cellFour.setBorder(Rectangle.NO_BORDER);
                        row5_cellFive.setBorder(Rectangle.NO_BORDER);
                        row5_cellSix.setBorder(Rectangle.NO_BORDER);
                        row5_cellSeven.setBorder(Rectangle.NO_BORDER);
                        row5_cellEight.setBorder(Rectangle.NO_BORDER);

                        // Add table cells
                        table.addCell(row5_cellOne);
                        table.addCell(row5_cellTwo);
                        table.addCell(row5_cellThree);
                        table.addCell(row5_cellFour);
                        table.addCell(row5_cellFive);
                        table.addCell(row5_cellSix);
                        table.addCell(row5_cellSeven);
                        table.addCell(row5_cellEight);

                        document.add(table);

                        Font boldFont = new Font(Font.FontFamily.HELVETICA, 12);
                        Paragraph para2 = new Paragraph(keterangan, boldFont);
                        para2.setAlignment(Element.ALIGN_JUSTIFIED);
                        para2.setFirstLineIndent(70f);
                        para2.setSpacingBefore(10f);
                        para2.setSpacingAfter(20f);

                        document.add(para2);

                        PdfPTable table2 = new PdfPTable(3);

                        // Set table properties
                        float[] columnWidth = {1.7f, 0.1f, 2f};
                        table2.setWidths(columnWidth);

                        Font data_font = new Font(Font.FontFamily.HELVETICA, 11);
                        PdfPCell cellOne = new PdfPCell(new Phrase("Nama",data_font));
                        PdfPCell cellTwo = new PdfPCell(new Phrase(":",data_font));
                        PdfPCell cellThree = new PdfPCell(new Phrase((String) atas_namas,data_font));

                        cellOne.setBorder(Rectangle.NO_BORDER);
                        cellTwo.setBorder(Rectangle.NO_BORDER);
                        cellThree.setBorder(Rectangle.NO_BORDER);
                        cellOne.setPaddingLeft(47f);

                        PdfPCell cellFour = new PdfPCell(new Phrase("NIP / NRK",data_font));
                        PdfPCell cellFive = new PdfPCell(new Phrase(":",data_font));
                        PdfPCell cellSix = new PdfPCell(new Phrase(sp.nip+"/"+sp.nrk,data_font));

                        cellFour.setBorder(Rectangle.NO_BORDER);
                        cellFive.setBorder(Rectangle.NO_BORDER);
                        cellSix.setBorder(Rectangle.NO_BORDER);
                        cellFour.setPaddingLeft(47f);

                        PdfPCell cellSeven = new PdfPCell(new Phrase("Pangkat / Golongan",data_font));
                        PdfPCell cellEight = new PdfPCell(new Phrase(":",data_font));
                        PdfPCell cellNine = new PdfPCell(new Phrase(sp.pangkat+"/ ("+sp.golongan+")",data_font));

                        cellSeven.setBorder(Rectangle.NO_BORDER);
                        cellEight.setBorder(Rectangle.NO_BORDER);
                        cellNine.setBorder(Rectangle.NO_BORDER);
                        cellSeven.setPaddingLeft(47f);

                        PdfPCell cellTen = new PdfPCell(new Phrase("Jabatan",data_font));
                        PdfPCell cellEleven = new PdfPCell(new Phrase(":",data_font));
                        PdfPCell cellTwelve =  new PdfPCell(new Phrase(sp.jabatan,data_font));

                        cellTen.setBorder(Rectangle.NO_BORDER);
                        cellEleven.setBorder(Rectangle.NO_BORDER);
                        cellTwelve.setBorder(Rectangle.NO_BORDER);
                        cellTen.setPaddingLeft(47f);

                        PdfPCell cell13 = new PdfPCell(new Phrase("Tempat Tugas",data_font));
                        PdfPCell cell14 = new PdfPCell(new Phrase(":",data_font));
                        PdfPCell cell15 =  new PdfPCell(new Phrase("SMP Negeri 223 Jakarta",data_font));

                        cell13.setBorder(Rectangle.NO_BORDER);
                        cell14.setBorder(Rectangle.NO_BORDER);
                        cell15.setBorder(Rectangle.NO_BORDER);
                        if (jenis_permohonan.equals("lainnya")) {
                            cell15.setPaddingBottom(40f);
                        }
                        cell13.setPaddingLeft(47f);

                        String tmt_pensiun = (sp.pensiun.isEmpty()) ? "Silahkan update tgl pensiun di master data guru terlebih dahulu" : Fungsi.getDate(sp.pensiun);
                        PdfPCell cell16 = new PdfPCell(new Phrase("TMT Pensiun",data_font));
                        PdfPCell cell17 = new PdfPCell(new Phrase(":",data_font));
                        PdfPCell cell18 =  new PdfPCell(new Phrase(tmt_pensiun,data_font));

                        cell16.setBorder(Rectangle.NO_BORDER);
                        cell17.setBorder(Rectangle.NO_BORDER);
                        cell18.setBorder(Rectangle.NO_BORDER);
                        cell18.setPaddingBottom(40f);
                        cell16.setPaddingLeft(47f);

                        // Add table cells
                        table2.addCell(cellOne);
                        table2.addCell(cellTwo);
                        table2.addCell(cellThree);
                        table2.addCell(cellFour);
                        table2.addCell(cellFive);
                        table2.addCell(cellSix);
                        table2.addCell(cellSeven);
                        table2.addCell(cellEight);
                        table2.addCell(cellNine);
                        table2.addCell(cellTen);
                        table2.addCell(cellEleven);
                        table2.addCell(cellTwelve);
                        table2.addCell(cell13);
                        table2.addCell(cell14);
                        table2.addCell(cell15);
                        if (jenis_permohonan.equals("pensiun")) {
                            table2.addCell(cell16);
                            table2.addCell(cell17);
                            table2.addCell(cell18);
                        }

                        // Add the table to the document
                        document.add(table2);

                        Paragraph para3 = new Paragraph("Demikian atas perhatian Bapak di ucapkan terima kasih.", boldFont);
                        para3.setAlignment(Element.ALIGN_JUSTIFIED);
                        para3.setFirstLineIndent(70f);
                        para3.setSpacingAfter(40f);

                        document.add(para3);

                        // Create the content table
                        PdfPTable contentTable3 = new PdfPTable(1);
                        contentTable3.setWidthPercentage(48);
                        contentTable3.setHorizontalAlignment(Element.ALIGN_RIGHT);

                        // Add the content footer rows to the table
                        PdfPCell cell_footer2 = new PdfPCell(new Phrase("Kepala SMP Negeri 223 Jakarta", new Font(Font.FontFamily.HELVETICA,11)));
                        cell_footer2.setBorder(PdfPCell.NO_BORDER);  
                        cell_footer2.setPaddingBottom(60f);
                        contentTable3.addCell(cell_footer2);

                        // Add the content footer rows to the table
                        PdfPCell cell_footer3 = new PdfPCell(new Phrase("OMAN NURYANI, M.Pd.", new Font(Font.FontFamily.HELVETICA,11)));
                        cell_footer3.setBorder(PdfPCell.NO_BORDER);
                        cell_footer3.setPaddingLeft(15f);
                        contentTable3.addCell(cell_footer3);

                        PdfPCell cell_footer4 = new PdfPCell(new Phrase("NIP. 196807191997031003", new Font(Font.FontFamily.HELVETICA,11)));
                        cell_footer4.setBorder(PdfPCell.NO_BORDER);  
                        cell_footer4.setPaddingLeft(5f);
                        contentTable3.addCell(cell_footer4);

                        document.add(contentTable3);

                        document.close();
                        System.out.println("File created successfully");
                    }else{
                        System.out.println("Failed to create file");
                    }
                } catch (IOException e) {
                    System.out.println(e);
                    System.out.println("An error occurred while creating the file: " + e.getMessage());
                }
            }else{
                //if file exist, then we can create the content from pdf
                //50 pertama itu left
                //50 kedua itu right
                Document document = new Document(PageSize.A4, 65, 65, 5, 50);
                PdfWriter.getInstance(document, new FileOutputStream(filePath));

                document.open();

                // Create the header table
                PdfPTable headerTable = new PdfPTable(2);
                headerTable.setWidthPercentage(100);
                headerTable.setWidths(new float[]{13, 87});

                // Create the image cell
                PdfPCell imageCell = new PdfPCell();
                Image logo = Image.getInstance(getClass().getResource("/logo-jakarta-raya.jpeg"));
                logo.scaleToFit(87, 125);
                logo.setSpacingBefore(10f);
                imageCell.addElement(logo);
                imageCell.setRowspan(7);
                imageCell.setBorder(PdfPCell.NO_BORDER);
                headerTable.addCell(imageCell);

                // Create the text cell
                PdfPCell textCell = new PdfPCell();
                Paragraph paragraph1 = new Paragraph("PEMERINTAH PROVINSI DAERAH KHUSUS IBUKOTA JAKARTA\nDINAS PENDIDIKAN", new Font(Font.FontFamily.HELVETICA, 10));
                paragraph1.setAlignment(Paragraph.ALIGN_CENTER);
                Paragraph paragraph2 = new Paragraph("SMP NEGERI 223 JAKARTA", new Font(Font.FontFamily.HELVETICA, 13, Font.BOLD));
                paragraph2.setAlignment(Paragraph.ALIGN_CENTER);
                Paragraph paragraph3 = new Paragraph("Jl. Surilang No. 6 Kel. Gedong Kec. Pasar Rebo\nTelepon (021) 8403316 Faximile (021) 8403316", new Font(Font.FontFamily.HELVETICA,11));
                paragraph3.setAlignment(Paragraph.ALIGN_CENTER);
                Paragraph paragraph4 = new Paragraph("E-mail: smpn223jktm@gmail.com\nJAKARTA", new Font(Font.FontFamily.HELVETICA, 11));
                paragraph4.setAlignment(Paragraph.ALIGN_CENTER);
                Paragraph paragraph5 = new Paragraph("Kode Pos : 13760", new Font(Font.FontFamily.HELVETICA, 11));
                paragraph5.setAlignment(Paragraph.ALIGN_RIGHT);
                Paragraph paragraph6 = new Paragraph(" ", new Font(Font.FontFamily.HELVETICA, 3));

                textCell.addElement(paragraph1);
                textCell.addElement(paragraph2);
                textCell.addElement(paragraph3);
                textCell.addElement(paragraph4);
                textCell.addElement(paragraph5);
                textCell.addElement(paragraph6);
                textCell.setBorder(PdfPCell.NO_BORDER);
                headerTable.addCell(textCell);

                // Add the header table to the document
                document.add(headerTable);

                // Add a horizontal line
                LineSeparator lineSeparator = new LineSeparator();
                lineSeparator.setLineWidth(4);
                document.add(lineSeparator);
                
                Paragraph para1 = new Paragraph(" ");
                para1.setPaddingTop(35f);
                 
                document.add(para1);
                
                PdfPTable table = new PdfPTable(8);

                // Set table properties
                table.setWidthPercentage(100);
                table.setHorizontalAlignment(Element.ALIGN_LEFT);
                float[] columnWidths = {1f, 0.3f, 2f, 0.3f, 0.4f, 0.4f, 0.4f, 2f};
                table.setWidths(columnWidths);

                PdfPCell row1_cellOne = new PdfPCell(new Phrase("Nomor"));
                PdfPCell row1_cellTwo = new PdfPCell(new Phrase(":"));
                PdfPCell row1_cellThree = new PdfPCell(new Phrase(no_surat));
                PdfPCell row1_cellFour = new PdfPCell(new Phrase(""));
                PdfPCell row1_cellFive = new PdfPCell(new Phrase(""));
                PdfPCell row1_cellSix = new PdfPCell(new Phrase(""));
                PdfPCell row1_cellSeven = new PdfPCell(new Phrase(""));
                PdfPCell row1_cellEight = new PdfPCell(new Phrase(Fungsi.getDate(dateChooser)));

                row1_cellOne.setBorder(Rectangle.NO_BORDER);
                row1_cellTwo.setBorder(Rectangle.NO_BORDER);
                row1_cellThree.setBorder(Rectangle.NO_BORDER);
                row1_cellFour.setBorder(Rectangle.NO_BORDER);
                row1_cellFive.setBorder(Rectangle.NO_BORDER);
                row1_cellSix.setBorder(Rectangle.NO_BORDER);
                row1_cellSeven.setBorder(Rectangle.NO_BORDER);
                row1_cellEight.setBorder(Rectangle.NO_BORDER);
                
                // Add table cells
                table.addCell(row1_cellOne);
                table.addCell(row1_cellTwo);
                table.addCell(row1_cellThree);
                table.addCell(row1_cellFour);
                table.addCell(row1_cellFive);
                table.addCell(row1_cellSix);
                table.addCell(row1_cellSeven);
                table.addCell(row1_cellEight);
                
                PdfPCell row2_cellOne = new PdfPCell(new Phrase("Sifat"));
                PdfPCell row2_cellTwo = new PdfPCell(new Phrase(":"));
                PdfPCell row2_cellThree = new PdfPCell(new Phrase(sifat));
                PdfPCell row2_cellFour = new PdfPCell(new Phrase(""));
                PdfPCell row2_cellFive = new PdfPCell(new Phrase(""));
                PdfPCell row2_cellSix = new PdfPCell(new Phrase(""));
                PdfPCell row2_cellSeven = new PdfPCell(new Phrase(""));
                PdfPCell row2_cellEight = new PdfPCell(new Phrase(""));

                row2_cellOne.setBorder(Rectangle.NO_BORDER);
                row2_cellTwo.setBorder(Rectangle.NO_BORDER);
                row2_cellThree.setBorder(Rectangle.NO_BORDER);
                row2_cellFour.setBorder(Rectangle.NO_BORDER);
                row2_cellFive.setBorder(Rectangle.NO_BORDER);
                row2_cellSix.setBorder(Rectangle.NO_BORDER);
                row2_cellSeven.setBorder(Rectangle.NO_BORDER);
                row2_cellEight.setBorder(Rectangle.NO_BORDER);
                
                // Add table cells
                table.addCell(row2_cellOne);
                table.addCell(row2_cellTwo);
                table.addCell(row2_cellThree);
                table.addCell(row2_cellFour);
                table.addCell(row2_cellFive);
                table.addCell(row2_cellSix);
                table.addCell(row2_cellSeven);
                table.addCell(row2_cellEight);
                
                PdfPCell row3_cellOne = new PdfPCell(new Phrase("Lampiran"));
                PdfPCell row3_cellTwo = new PdfPCell(new Phrase(":"));
                PdfPCell row3_cellThree = new PdfPCell(new Phrase(lampiran));
                PdfPCell row3_cellFour = new PdfPCell(new Phrase(""));
                PdfPCell row3_cellFive = new PdfPCell(new Phrase(""));
                PdfPCell row3_cellSix = new PdfPCell(new Phrase(""));
                PdfPCell row3_cellSeven = new PdfPCell(new Phrase(""));
                PdfPCell row3_cellEight = new PdfPCell(new Phrase(""));

                row3_cellOne.setBorder(Rectangle.NO_BORDER);
                row3_cellTwo.setBorder(Rectangle.NO_BORDER);
                row3_cellThree.setBorder(Rectangle.NO_BORDER);
                row3_cellFour.setBorder(Rectangle.NO_BORDER);
                row3_cellFive.setBorder(Rectangle.NO_BORDER);
                row3_cellSix.setBorder(Rectangle.NO_BORDER);
                row3_cellSeven.setBorder(Rectangle.NO_BORDER);
                row3_cellEight.setBorder(Rectangle.NO_BORDER);
                
                // Add table cells
                table.addCell(row3_cellOne);
                table.addCell(row3_cellTwo);
                table.addCell(row3_cellThree);
                table.addCell(row3_cellFour);
                table.addCell(row3_cellFive);
                table.addCell(row3_cellSix);
                table.addCell(row3_cellSeven);
                table.addCell(row3_cellEight);
                
                PdfPCell row4_cellOne = new PdfPCell(new Phrase("Perihal"));
                PdfPCell row4_cellTwo = new PdfPCell(new Phrase(":"));
                PdfPCell row4_cellThree = new PdfPCell(new Phrase(perihal));
                PdfPCell row4_cellFour = new PdfPCell(new Phrase(""));
                PdfPCell row4_cellFive = new PdfPCell(new Phrase(""));
                PdfPCell row4_cellSix = new PdfPCell(new Phrase(""));
                PdfPCell row4_cellSeven = new PdfPCell(new Phrase(""));
                PdfPCell row4_cellEight = new PdfPCell(new Phrase("Kepada"));

                row4_cellOne.setBorder(Rectangle.NO_BORDER);
                row4_cellTwo.setBorder(Rectangle.NO_BORDER);
                row4_cellThree.setBorder(Rectangle.NO_BORDER);
                row4_cellFour.setBorder(Rectangle.NO_BORDER);
                row4_cellFive.setBorder(Rectangle.NO_BORDER);
                row4_cellSix.setBorder(Rectangle.NO_BORDER);
                row4_cellSeven.setBorder(Rectangle.NO_BORDER);
                row4_cellEight.setBorder(Rectangle.NO_BORDER);
                
                // Add table cells
                table.addCell(row4_cellOne);
                table.addCell(row4_cellTwo);
                table.addCell(row4_cellThree);
                table.addCell(row4_cellFour);
                table.addCell(row4_cellFive);
                table.addCell(row4_cellSix);
                table.addCell(row4_cellSeven);
                table.addCell(row4_cellEight);
                
                PdfPCell row5_cellOne = new PdfPCell(new Phrase(""));
                PdfPCell row5_cellTwo = new PdfPCell(new Phrase(""));
                PdfPCell row5_cellThree = new PdfPCell(new Phrase(""));
                PdfPCell row5_cellFour = new PdfPCell(new Phrase(""));
                PdfPCell row5_cellFive = new PdfPCell(new Phrase("Yth."));
                PdfPCell row5_cellSix = new PdfPCell(new Phrase(""));
                PdfPCell row5_cellSeven = new PdfPCell(new Phrase(""));
                PdfPCell row5_cellEight = new PdfPCell(new Phrase(kepada));

                row5_cellOne.setBorder(Rectangle.NO_BORDER);
                row5_cellTwo.setBorder(Rectangle.NO_BORDER);
                row5_cellThree.setBorder(Rectangle.NO_BORDER);
                row5_cellFour.setBorder(Rectangle.NO_BORDER);
                row5_cellFive.setBorder(Rectangle.NO_BORDER);
                row5_cellSix.setBorder(Rectangle.NO_BORDER);
                row5_cellSeven.setBorder(Rectangle.NO_BORDER);
                row5_cellEight.setBorder(Rectangle.NO_BORDER);
                
                // Add table cells
                table.addCell(row5_cellOne);
                table.addCell(row5_cellTwo);
                table.addCell(row5_cellThree);
                table.addCell(row5_cellFour);
                table.addCell(row5_cellFive);
                table.addCell(row5_cellSix);
                table.addCell(row5_cellSeven);
                table.addCell(row5_cellEight);
                
                document.add(table);
                
                Font boldFont = new Font(Font.FontFamily.HELVETICA, 12);
                Paragraph para2 = new Paragraph(keterangan, boldFont);
                para2.setAlignment(Element.ALIGN_JUSTIFIED);
                para2.setFirstLineIndent(70f);
                para2.setSpacingBefore(10f);
                para2.setSpacingAfter(20f);

                document.add(para2);
                
                PdfPTable table2 = new PdfPTable(3);

                // Set table properties
                table.setWidthPercentage(78);
                table.setHorizontalAlignment(Element.ALIGN_LEFT);
                float[] columnWidth = {1.7f, 0.1f, 2f};
                table2.setWidths(columnWidth);

                Font data_font = new Font(Font.FontFamily.HELVETICA, 11);
                PdfPCell cellOne = new PdfPCell(new Phrase("Nama",data_font));
                PdfPCell cellTwo = new PdfPCell(new Phrase(":",data_font));
                PdfPCell cellThree = new PdfPCell(new Phrase((String) atas_namas,data_font));

                cellOne.setBorder(Rectangle.NO_BORDER);
                cellTwo.setBorder(Rectangle.NO_BORDER);
                cellThree.setBorder(Rectangle.NO_BORDER);
                cellOne.setPaddingLeft(47f);

                PdfPCell cellFour = new PdfPCell(new Phrase("NIP / NRK",data_font));
                PdfPCell cellFive = new PdfPCell(new Phrase(":",data_font));
                PdfPCell cellSix = new PdfPCell(new Phrase(sp.nip+"/"+sp.nrk,data_font));

                cellFour.setBorder(Rectangle.NO_BORDER);
                cellFive.setBorder(Rectangle.NO_BORDER);
                cellSix.setBorder(Rectangle.NO_BORDER);
                cellFour.setPaddingLeft(47f);

                PdfPCell cellSeven = new PdfPCell(new Phrase("Pangkat / Golongan",data_font));
                PdfPCell cellEight = new PdfPCell(new Phrase(":",data_font));
                PdfPCell cellNine = new PdfPCell(new Phrase(sp.pangkat+"/ ("+sp.golongan+")",data_font));

                cellSeven.setBorder(Rectangle.NO_BORDER);
                cellEight.setBorder(Rectangle.NO_BORDER);
                cellNine.setBorder(Rectangle.NO_BORDER);
                cellSeven.setPaddingLeft(47f);

                PdfPCell cellTen = new PdfPCell(new Phrase("Jabatan",data_font));
                PdfPCell cellEleven = new PdfPCell(new Phrase(":",data_font));
                PdfPCell cellTwelve =  new PdfPCell(new Phrase(sp.jabatan,data_font));

                cellTen.setBorder(Rectangle.NO_BORDER);
                cellEleven.setBorder(Rectangle.NO_BORDER);
                cellTwelve.setBorder(Rectangle.NO_BORDER);
                cellTen.setPaddingLeft(47f);
                
                PdfPCell cell13 = new PdfPCell(new Phrase("Tempat Tugas",data_font));
                PdfPCell cell14 = new PdfPCell(new Phrase(":",data_font));
                PdfPCell cell15 =  new PdfPCell(new Phrase("SMP Negeri 223 Jakarta",data_font));

                cell13.setBorder(Rectangle.NO_BORDER);
                cell14.setBorder(Rectangle.NO_BORDER);
                cell15.setBorder(Rectangle.NO_BORDER);
                if (jenis_permohonan.equals("lainnya")) {
                    cell15.setPaddingBottom(40f);
                }
                cell13.setPaddingLeft(47f);
                
                String tmt_pensiun = (sp.pensiun.isEmpty()) ? "Silahkan update tgl pensiun di master data guru terlebih dahulu" : Fungsi.getDate(sp.pensiun);
                PdfPCell cell16 = new PdfPCell(new Phrase("TMT Pensiun",data_font));
                PdfPCell cell17 = new PdfPCell(new Phrase(":",data_font));
                PdfPCell cell18 =  new PdfPCell(new Phrase(tmt_pensiun,data_font));

                cell16.setBorder(Rectangle.NO_BORDER);
                cell17.setBorder(Rectangle.NO_BORDER);
                cell18.setBorder(Rectangle.NO_BORDER);
                cell18.setPaddingBottom(40f);
                cell16.setPaddingLeft(47f);

                // Add table cells
                table2.addCell(cellOne);
                table2.addCell(cellTwo);
                table2.addCell(cellThree);
                table2.addCell(cellFour);
                table2.addCell(cellFive);
                table2.addCell(cellSix);
                table2.addCell(cellSeven);
                table2.addCell(cellEight);
                table2.addCell(cellNine);
                table2.addCell(cellTen);
                table2.addCell(cellEleven);
                table2.addCell(cellTwelve);
                table2.addCell(cell13);
                table2.addCell(cell14);
                table2.addCell(cell15);
                if (jenis_permohonan.equals("pensiun")) {
                    table2.addCell(cell16);
                    table2.addCell(cell17);
                    table2.addCell(cell18);
                }

                // Add the table to the document
                document.add(table2);
                
                Paragraph para3 = new Paragraph("Demikian atas perhatian Bapak di ucapkan terima kasih.", boldFont);
                para3.setAlignment(Element.ALIGN_JUSTIFIED);
                para3.setFirstLineIndent(70f);
                para3.setSpacingAfter(40f);

                document.add(para3);
                
                // Create the content table
                PdfPTable contentTable3 = new PdfPTable(1);
                contentTable3.setWidthPercentage(48);
                contentTable3.setHorizontalAlignment(Element.ALIGN_RIGHT);

                // Add the content footer rows to the table
                PdfPCell cell_footer2 = new PdfPCell(new Phrase("Kepala SMP Negeri 223 Jakarta", new Font(Font.FontFamily.HELVETICA,11)));
                cell_footer2.setBorder(PdfPCell.NO_BORDER);  
                cell_footer2.setPaddingBottom(60f);
                contentTable3.addCell(cell_footer2);

                // Add the content footer rows to the table
                PdfPCell cell_footer3 = new PdfPCell(new Phrase("OMAN NURYANI, M.Pd.", new Font(Font.FontFamily.HELVETICA,11)));
                cell_footer3.setBorder(PdfPCell.NO_BORDER);
                cell_footer3.setPaddingLeft(15f);
                contentTable3.addCell(cell_footer3);

                PdfPCell cell_footer4 = new PdfPCell(new Phrase("NIP. 196807191997031003", new Font(Font.FontFamily.HELVETICA,11)));
                cell_footer4.setBorder(PdfPCell.NO_BORDER);  
                cell_footer4.setPaddingLeft(5f);
                contentTable3.addCell(cell_footer4);

                document.add(contentTable3);
                
                document.close();
                System.out.println("File created successfully");
            }
            File file1 = new File(filePath);

            JOptionPane.showMessageDialog(null, "Data berhasil dicetak", "Pesan", JOptionPane.INFORMATION_MESSAGE);
            // Open the URL in the default web browser
            Desktop.getDesktop().open(file1);
        } catch (Exception e) {
                System.out.println(e);
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton6KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton6KeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            Connection conn = Koneksi.getConnection();
            try {
                FSurat_Permohonan sp = new FSurat_Permohonan();
                String no_surat = jTextField1.getText();
                String sifat = jTextField6.getText();
                String lampiran = jTextField7.getText();
                String perihal = jTextField12.getText();
                String kepada = jTextField8.getText();
                Object atas_namas = jComboBox2.getItemAt(jComboBox2.getSelectedIndex());
                sp.Combox1((String) atas_namas);
                Object jenis_permohonan = jComboBox1.getItemAt(jComboBox1.getSelectedIndex());
                String keterangan = jTextArea1.getText();
                String folderPath = "C:\\simpati223";
                String filePath = "C:\\simpati223\\surat_permohonan_"+atas_namas+".pdf";

                // Check if folder exists, create if it doesn't
                File folder = new File(folderPath);
                if (!folder.exists()) {
                    boolean created = folder.mkdirs();
                    if (created) {
                        System.out.println("Folder created successfully");
                    } else {
                        System.out.println("Failed to create folder");
                    }
                } else {
                    System.out.println("Folder already exists");
                }

                // Check if file exists, create if it doesn't
                File file = new File(filePath);
                if (!file.exists()) {
                    try {
                        boolean created = file.createNewFile();
                        if (created) {
                            //after created file, then we can create a content from pdf
                            //50 pertama itu left
                            //50 kedua itu right
                            Document document = new Document(PageSize.A4, 65, 65, 5, 50);
                            PdfWriter.getInstance(document, new FileOutputStream(filePath));

                            document.open();

                            // Create the header table
                            PdfPTable headerTable = new PdfPTable(2);
                            headerTable.setWidthPercentage(100);
                            headerTable.setWidths(new float[]{13, 87});

                            // Create the image cell
                            PdfPCell imageCell = new PdfPCell();
                            Image logo = Image.getInstance(getClass().getResource("/logo-jakarta-raya.jpeg"));
                            logo.scaleToFit(87, 125);
                            logo.setSpacingBefore(10f);
                            imageCell.addElement(logo);
                            imageCell.setRowspan(7);
                            imageCell.setBorder(PdfPCell.NO_BORDER);
                            headerTable.addCell(imageCell);

                            // Create the text cell
                            PdfPCell textCell = new PdfPCell();
                            Paragraph paragraph1 = new Paragraph("PEMERINTAH PROVINSI DAERAH KHUSUS IBUKOTA JAKARTA\nDINAS PENDIDIKAN", new Font(Font.FontFamily.HELVETICA, 10));
                            paragraph1.setAlignment(Paragraph.ALIGN_CENTER);
                            Paragraph paragraph2 = new Paragraph("SMP NEGERI 223 JAKARTA", new Font(Font.FontFamily.HELVETICA, 13, Font.BOLD));
                            paragraph2.setAlignment(Paragraph.ALIGN_CENTER);
                            Paragraph paragraph3 = new Paragraph("Jl. Surilang No. 6 Kel. Gedong Kec. Pasar Rebo\nTelepon (021) 8403316 Faximile (021) 8403316", new Font(Font.FontFamily.HELVETICA,11));
                            paragraph3.setAlignment(Paragraph.ALIGN_CENTER);
                            Paragraph paragraph4 = new Paragraph("E-mail: smpn223jktm@gmail.com\nJAKARTA", new Font(Font.FontFamily.HELVETICA, 11));
                            paragraph4.setAlignment(Paragraph.ALIGN_CENTER);
                            Paragraph paragraph5 = new Paragraph("Kode Pos : 13760", new Font(Font.FontFamily.HELVETICA, 11));
                            paragraph5.setAlignment(Paragraph.ALIGN_RIGHT);
                            Paragraph paragraph6 = new Paragraph(" ", new Font(Font.FontFamily.HELVETICA, 3));

                            textCell.addElement(paragraph1);
                            textCell.addElement(paragraph2);
                            textCell.addElement(paragraph3);
                            textCell.addElement(paragraph4);
                            textCell.addElement(paragraph5);
                            textCell.addElement(paragraph6);
                            textCell.setBorder(PdfPCell.NO_BORDER);
                            headerTable.addCell(textCell);

                            // Add the header table to the document
                            document.add(headerTable);

                            // Add a horizontal line
                            LineSeparator lineSeparator = new LineSeparator();
                            lineSeparator.setLineWidth(4);
                            document.add(lineSeparator);

                            Paragraph para1 = new Paragraph(" ");
                            para1.setPaddingTop(35f);

                            document.add(para1);

                            PdfPTable table = new PdfPTable(8);

                            // Set table properties
                            table.setWidthPercentage(100);
                            table.setHorizontalAlignment(Element.ALIGN_LEFT);
                            float[] columnWidths = {1f, 0.3f, 2f, 0.3f, 0.4f, 0.4f, 0.4f, 2f};
                            table.setWidths(columnWidths);

                            PdfPCell row1_cellOne = new PdfPCell(new Phrase("Nomor"));
                            PdfPCell row1_cellTwo = new PdfPCell(new Phrase(":"));
                            PdfPCell row1_cellThree = new PdfPCell(new Phrase(no_surat));
                            PdfPCell row1_cellFour = new PdfPCell(new Phrase(""));
                            PdfPCell row1_cellFive = new PdfPCell(new Phrase(""));
                            PdfPCell row1_cellSix = new PdfPCell(new Phrase(""));
                            PdfPCell row1_cellSeven = new PdfPCell(new Phrase(""));
                            PdfPCell row1_cellEight = new PdfPCell(new Phrase(Fungsi.getDate(dateChooser)));

                            row1_cellOne.setBorder(Rectangle.NO_BORDER);
                            row1_cellTwo.setBorder(Rectangle.NO_BORDER);
                            row1_cellThree.setBorder(Rectangle.NO_BORDER);
                            row1_cellFour.setBorder(Rectangle.NO_BORDER);
                            row1_cellFive.setBorder(Rectangle.NO_BORDER);
                            row1_cellSix.setBorder(Rectangle.NO_BORDER);
                            row1_cellSeven.setBorder(Rectangle.NO_BORDER);
                            row1_cellEight.setBorder(Rectangle.NO_BORDER);

                            // Add table cells
                            table.addCell(row1_cellOne);
                            table.addCell(row1_cellTwo);
                            table.addCell(row1_cellThree);
                            table.addCell(row1_cellFour);
                            table.addCell(row1_cellFive);
                            table.addCell(row1_cellSix);
                            table.addCell(row1_cellSeven);
                            table.addCell(row1_cellEight);

                            PdfPCell row2_cellOne = new PdfPCell(new Phrase("Sifat"));
                            PdfPCell row2_cellTwo = new PdfPCell(new Phrase(":"));
                            PdfPCell row2_cellThree = new PdfPCell(new Phrase(sifat));
                            PdfPCell row2_cellFour = new PdfPCell(new Phrase(""));
                            PdfPCell row2_cellFive = new PdfPCell(new Phrase(""));
                            PdfPCell row2_cellSix = new PdfPCell(new Phrase(""));
                            PdfPCell row2_cellSeven = new PdfPCell(new Phrase(""));
                            PdfPCell row2_cellEight = new PdfPCell(new Phrase(""));

                            row2_cellOne.setBorder(Rectangle.NO_BORDER);
                            row2_cellTwo.setBorder(Rectangle.NO_BORDER);
                            row2_cellThree.setBorder(Rectangle.NO_BORDER);
                            row2_cellFour.setBorder(Rectangle.NO_BORDER);
                            row2_cellFive.setBorder(Rectangle.NO_BORDER);
                            row2_cellSix.setBorder(Rectangle.NO_BORDER);
                            row2_cellSeven.setBorder(Rectangle.NO_BORDER);
                            row2_cellEight.setBorder(Rectangle.NO_BORDER);

                            // Add table cells
                            table.addCell(row2_cellOne);
                            table.addCell(row2_cellTwo);
                            table.addCell(row2_cellThree);
                            table.addCell(row2_cellFour);
                            table.addCell(row2_cellFive);
                            table.addCell(row2_cellSix);
                            table.addCell(row2_cellSeven);
                            table.addCell(row2_cellEight);

                            PdfPCell row3_cellOne = new PdfPCell(new Phrase("Lampiran"));
                            PdfPCell row3_cellTwo = new PdfPCell(new Phrase(":"));
                            PdfPCell row3_cellThree = new PdfPCell(new Phrase(lampiran));
                            PdfPCell row3_cellFour = new PdfPCell(new Phrase(""));
                            PdfPCell row3_cellFive = new PdfPCell(new Phrase(""));
                            PdfPCell row3_cellSix = new PdfPCell(new Phrase(""));
                            PdfPCell row3_cellSeven = new PdfPCell(new Phrase(""));
                            PdfPCell row3_cellEight = new PdfPCell(new Phrase(""));

                            row3_cellOne.setBorder(Rectangle.NO_BORDER);
                            row3_cellTwo.setBorder(Rectangle.NO_BORDER);
                            row3_cellThree.setBorder(Rectangle.NO_BORDER);
                            row3_cellFour.setBorder(Rectangle.NO_BORDER);
                            row3_cellFive.setBorder(Rectangle.NO_BORDER);
                            row3_cellSix.setBorder(Rectangle.NO_BORDER);
                            row3_cellSeven.setBorder(Rectangle.NO_BORDER);
                            row3_cellEight.setBorder(Rectangle.NO_BORDER);

                            // Add table cells
                            table.addCell(row3_cellOne);
                            table.addCell(row3_cellTwo);
                            table.addCell(row3_cellThree);
                            table.addCell(row3_cellFour);
                            table.addCell(row3_cellFive);
                            table.addCell(row3_cellSix);
                            table.addCell(row3_cellSeven);
                            table.addCell(row3_cellEight);

                            PdfPCell row4_cellOne = new PdfPCell(new Phrase("Perihal"));
                            PdfPCell row4_cellTwo = new PdfPCell(new Phrase(":"));
                            PdfPCell row4_cellThree = new PdfPCell(new Phrase(perihal));
                            PdfPCell row4_cellFour = new PdfPCell(new Phrase(""));
                            PdfPCell row4_cellFive = new PdfPCell(new Phrase(""));
                            PdfPCell row4_cellSix = new PdfPCell(new Phrase(""));
                            PdfPCell row4_cellSeven = new PdfPCell(new Phrase(""));
                            PdfPCell row4_cellEight = new PdfPCell(new Phrase("Kepada"));

                            row4_cellOne.setBorder(Rectangle.NO_BORDER);
                            row4_cellTwo.setBorder(Rectangle.NO_BORDER);
                            row4_cellThree.setBorder(Rectangle.NO_BORDER);
                            row4_cellFour.setBorder(Rectangle.NO_BORDER);
                            row4_cellFive.setBorder(Rectangle.NO_BORDER);
                            row4_cellSix.setBorder(Rectangle.NO_BORDER);
                            row4_cellSeven.setBorder(Rectangle.NO_BORDER);
                            row4_cellEight.setBorder(Rectangle.NO_BORDER);

                            // Add table cells
                            table.addCell(row4_cellOne);
                            table.addCell(row4_cellTwo);
                            table.addCell(row4_cellThree);
                            table.addCell(row4_cellFour);
                            table.addCell(row4_cellFive);
                            table.addCell(row4_cellSix);
                            table.addCell(row4_cellSeven);
                            table.addCell(row4_cellEight);

                            PdfPCell row5_cellOne = new PdfPCell(new Phrase(""));
                            PdfPCell row5_cellTwo = new PdfPCell(new Phrase(""));
                            PdfPCell row5_cellThree = new PdfPCell(new Phrase(""));
                            PdfPCell row5_cellFour = new PdfPCell(new Phrase(""));
                            PdfPCell row5_cellFive = new PdfPCell(new Phrase("Yth."));
                            PdfPCell row5_cellSix = new PdfPCell(new Phrase(""));
                            PdfPCell row5_cellSeven = new PdfPCell(new Phrase(""));
                            PdfPCell row5_cellEight = new PdfPCell(new Phrase(kepada));

                            row5_cellOne.setBorder(Rectangle.NO_BORDER);
                            row5_cellTwo.setBorder(Rectangle.NO_BORDER);
                            row5_cellThree.setBorder(Rectangle.NO_BORDER);
                            row5_cellFour.setBorder(Rectangle.NO_BORDER);
                            row5_cellFive.setBorder(Rectangle.NO_BORDER);
                            row5_cellSix.setBorder(Rectangle.NO_BORDER);
                            row5_cellSeven.setBorder(Rectangle.NO_BORDER);
                            row5_cellEight.setBorder(Rectangle.NO_BORDER);

                            // Add table cells
                            table.addCell(row5_cellOne);
                            table.addCell(row5_cellTwo);
                            table.addCell(row5_cellThree);
                            table.addCell(row5_cellFour);
                            table.addCell(row5_cellFive);
                            table.addCell(row5_cellSix);
                            table.addCell(row5_cellSeven);
                            table.addCell(row5_cellEight);

                            document.add(table);

                            Font boldFont = new Font(Font.FontFamily.HELVETICA, 12);
                            Paragraph para2 = new Paragraph(keterangan, boldFont);
                            para2.setAlignment(Element.ALIGN_JUSTIFIED);
                            para2.setFirstLineIndent(70f);
                            para2.setSpacingBefore(10f);
                            para2.setSpacingAfter(20f);

                            document.add(para2);

                            PdfPTable table2 = new PdfPTable(3);

                            // Set table properties
                            float[] columnWidth = {1.7f, 0.1f, 2f};
                            table2.setWidths(columnWidth);

                            Font data_font = new Font(Font.FontFamily.HELVETICA, 11);
                            PdfPCell cellOne = new PdfPCell(new Phrase("Nama",data_font));
                            PdfPCell cellTwo = new PdfPCell(new Phrase(":",data_font));
                            PdfPCell cellThree = new PdfPCell(new Phrase((String) atas_namas,data_font));

                            cellOne.setBorder(Rectangle.NO_BORDER);
                            cellTwo.setBorder(Rectangle.NO_BORDER);
                            cellThree.setBorder(Rectangle.NO_BORDER);
                            cellOne.setPaddingLeft(47f);

                            PdfPCell cellFour = new PdfPCell(new Phrase("NIP / NRK",data_font));
                            PdfPCell cellFive = new PdfPCell(new Phrase(":",data_font));
                            PdfPCell cellSix = new PdfPCell(new Phrase(sp.nip+"/"+sp.nrk,data_font));

                            cellFour.setBorder(Rectangle.NO_BORDER);
                            cellFive.setBorder(Rectangle.NO_BORDER);
                            cellSix.setBorder(Rectangle.NO_BORDER);
                            cellFour.setPaddingLeft(47f);

                            PdfPCell cellSeven = new PdfPCell(new Phrase("Pangkat / Golongan",data_font));
                            PdfPCell cellEight = new PdfPCell(new Phrase(":",data_font));
                            PdfPCell cellNine = new PdfPCell(new Phrase(sp.pangkat+"/ ("+sp.golongan+")",data_font));

                            cellSeven.setBorder(Rectangle.NO_BORDER);
                            cellEight.setBorder(Rectangle.NO_BORDER);
                            cellNine.setBorder(Rectangle.NO_BORDER);
                            cellSeven.setPaddingLeft(47f);

                            PdfPCell cellTen = new PdfPCell(new Phrase("Jabatan",data_font));
                            PdfPCell cellEleven = new PdfPCell(new Phrase(":",data_font));
                            PdfPCell cellTwelve =  new PdfPCell(new Phrase(sp.jabatan,data_font));

                            cellTen.setBorder(Rectangle.NO_BORDER);
                            cellEleven.setBorder(Rectangle.NO_BORDER);
                            cellTwelve.setBorder(Rectangle.NO_BORDER);
                            cellTen.setPaddingLeft(47f);

                            PdfPCell cell13 = new PdfPCell(new Phrase("Tempat Tugas",data_font));
                            PdfPCell cell14 = new PdfPCell(new Phrase(":",data_font));
                            PdfPCell cell15 =  new PdfPCell(new Phrase("SMP Negeri 223 Jakarta",data_font));

                            cell13.setBorder(Rectangle.NO_BORDER);
                            cell14.setBorder(Rectangle.NO_BORDER);
                            cell15.setBorder(Rectangle.NO_BORDER);
                            if (jenis_permohonan.equals("lainnya")) {
                                cell15.setPaddingBottom(40f);
                            }
                            cell13.setPaddingLeft(47f);

                            String tmt_pensiun = (sp.pensiun.isEmpty()) ? "Silahkan update tgl pensiun di master data guru terlebih dahulu" : Fungsi.getDate(sp.pensiun);
                            PdfPCell cell16 = new PdfPCell(new Phrase("TMT Pensiun",data_font));
                            PdfPCell cell17 = new PdfPCell(new Phrase(":",data_font));
                            PdfPCell cell18 =  new PdfPCell(new Phrase(tmt_pensiun,data_font));

                            cell16.setBorder(Rectangle.NO_BORDER);
                            cell17.setBorder(Rectangle.NO_BORDER);
                            cell18.setBorder(Rectangle.NO_BORDER);
                            cell18.setPaddingBottom(40f);
                            cell16.setPaddingLeft(47f);

                            // Add table cells
                            table2.addCell(cellOne);
                            table2.addCell(cellTwo);
                            table2.addCell(cellThree);
                            table2.addCell(cellFour);
                            table2.addCell(cellFive);
                            table2.addCell(cellSix);
                            table2.addCell(cellSeven);
                            table2.addCell(cellEight);
                            table2.addCell(cellNine);
                            table2.addCell(cellTen);
                            table2.addCell(cellEleven);
                            table2.addCell(cellTwelve);
                            table2.addCell(cell13);
                            table2.addCell(cell14);
                            table2.addCell(cell15);
                            if (jenis_permohonan.equals("pensiun")) {
                                table2.addCell(cell16);
                                table2.addCell(cell17);
                                table2.addCell(cell18);
                            }

                            // Add the table to the document
                            document.add(table2);

                            Paragraph para3 = new Paragraph("Demikian atas perhatian Bapak di ucapkan terima kasih.", boldFont);
                            para3.setAlignment(Element.ALIGN_JUSTIFIED);
                            para3.setFirstLineIndent(70f);
                            para3.setSpacingAfter(40f);

                            document.add(para3);

                            // Create the content table
                            PdfPTable contentTable3 = new PdfPTable(1);
                            contentTable3.setWidthPercentage(48);
                            contentTable3.setHorizontalAlignment(Element.ALIGN_RIGHT);

                            // Add the content footer rows to the table
                            PdfPCell cell_footer2 = new PdfPCell(new Phrase("Kepala SMP Negeri 223 Jakarta", new Font(Font.FontFamily.HELVETICA,11)));
                            cell_footer2.setBorder(PdfPCell.NO_BORDER);  
                            cell_footer2.setPaddingBottom(60f);
                            contentTable3.addCell(cell_footer2);

                            // Add the content footer rows to the table
                            PdfPCell cell_footer3 = new PdfPCell(new Phrase("OMAN NURYANI, M.Pd.", new Font(Font.FontFamily.HELVETICA,11)));
                            cell_footer3.setBorder(PdfPCell.NO_BORDER);
                            cell_footer3.setPaddingLeft(15f);
                            contentTable3.addCell(cell_footer3);

                            PdfPCell cell_footer4 = new PdfPCell(new Phrase("NIP. 196807191997031003", new Font(Font.FontFamily.HELVETICA,11)));
                            cell_footer4.setBorder(PdfPCell.NO_BORDER);  
                            cell_footer4.setPaddingLeft(5f);
                            contentTable3.addCell(cell_footer4);

                            document.add(contentTable3);

                            document.close();
                            System.out.println("File created successfully");
                        }else{
                            System.out.println("Failed to create file");
                        }
                    } catch (IOException e) {
                        System.out.println(e);
                        System.out.println("An error occurred while creating the file: " + e.getMessage());
                    }
                }else{
                    //if file exist, then we can create the content from pdf
                    //50 pertama itu left
                    //50 kedua itu right
                    Document document = new Document(PageSize.A4, 65, 65, 5, 50);
                    PdfWriter.getInstance(document, new FileOutputStream(filePath));

                    document.open();

                    // Create the header table
                    PdfPTable headerTable = new PdfPTable(2);
                    headerTable.setWidthPercentage(100);
                    headerTable.setWidths(new float[]{13, 87});

                    // Create the image cell
                    PdfPCell imageCell = new PdfPCell();
                    Image logo = Image.getInstance(getClass().getResource("/logo-jakarta-raya.jpeg"));
                    logo.scaleToFit(87, 125);
                    logo.setSpacingBefore(10f);
                    imageCell.addElement(logo);
                    imageCell.setRowspan(7);
                    imageCell.setBorder(PdfPCell.NO_BORDER);
                    headerTable.addCell(imageCell);

                    // Create the text cell
                    PdfPCell textCell = new PdfPCell();
                    Paragraph paragraph1 = new Paragraph("PEMERINTAH PROVINSI DAERAH KHUSUS IBUKOTA JAKARTA\nDINAS PENDIDIKAN", new Font(Font.FontFamily.HELVETICA, 10));
                    paragraph1.setAlignment(Paragraph.ALIGN_CENTER);
                    Paragraph paragraph2 = new Paragraph("SMP NEGERI 223 JAKARTA", new Font(Font.FontFamily.HELVETICA, 13, Font.BOLD));
                    paragraph2.setAlignment(Paragraph.ALIGN_CENTER);
                    Paragraph paragraph3 = new Paragraph("Jl. Surilang No. 6 Kel. Gedong Kec. Pasar Rebo\nTelepon (021) 8403316 Faximile (021) 8403316", new Font(Font.FontFamily.HELVETICA,11));
                    paragraph3.setAlignment(Paragraph.ALIGN_CENTER);
                    Paragraph paragraph4 = new Paragraph("E-mail: smpn223jktm@gmail.com\nJAKARTA", new Font(Font.FontFamily.HELVETICA, 11));
                    paragraph4.setAlignment(Paragraph.ALIGN_CENTER);
                    Paragraph paragraph5 = new Paragraph("Kode Pos : 13760", new Font(Font.FontFamily.HELVETICA, 11));
                    paragraph5.setAlignment(Paragraph.ALIGN_RIGHT);
                    Paragraph paragraph6 = new Paragraph(" ", new Font(Font.FontFamily.HELVETICA, 3));

                    textCell.addElement(paragraph1);
                    textCell.addElement(paragraph2);
                    textCell.addElement(paragraph3);
                    textCell.addElement(paragraph4);
                    textCell.addElement(paragraph5);
                    textCell.addElement(paragraph6);
                    textCell.setBorder(PdfPCell.NO_BORDER);
                    headerTable.addCell(textCell);

                    // Add the header table to the document
                    document.add(headerTable);

                    // Add a horizontal line
                    LineSeparator lineSeparator = new LineSeparator();
                    lineSeparator.setLineWidth(4);
                    document.add(lineSeparator);

                    Paragraph para1 = new Paragraph(" ");
                    para1.setPaddingTop(35f);

                    document.add(para1);

                    PdfPTable table = new PdfPTable(8);

                    // Set table properties
                    table.setWidthPercentage(100);
                    table.setHorizontalAlignment(Element.ALIGN_LEFT);
                    float[] columnWidths = {1f, 0.3f, 2f, 0.3f, 0.4f, 0.4f, 0.4f, 2f};
                    table.setWidths(columnWidths);

                    PdfPCell row1_cellOne = new PdfPCell(new Phrase("Nomor"));
                    PdfPCell row1_cellTwo = new PdfPCell(new Phrase(":"));
                    PdfPCell row1_cellThree = new PdfPCell(new Phrase(no_surat));
                    PdfPCell row1_cellFour = new PdfPCell(new Phrase(""));
                    PdfPCell row1_cellFive = new PdfPCell(new Phrase(""));
                    PdfPCell row1_cellSix = new PdfPCell(new Phrase(""));
                    PdfPCell row1_cellSeven = new PdfPCell(new Phrase(""));
                    PdfPCell row1_cellEight = new PdfPCell(new Phrase(Fungsi.getDate(dateChooser)));

                    row1_cellOne.setBorder(Rectangle.NO_BORDER);
                    row1_cellTwo.setBorder(Rectangle.NO_BORDER);
                    row1_cellThree.setBorder(Rectangle.NO_BORDER);
                    row1_cellFour.setBorder(Rectangle.NO_BORDER);
                    row1_cellFive.setBorder(Rectangle.NO_BORDER);
                    row1_cellSix.setBorder(Rectangle.NO_BORDER);
                    row1_cellSeven.setBorder(Rectangle.NO_BORDER);
                    row1_cellEight.setBorder(Rectangle.NO_BORDER);

                    // Add table cells
                    table.addCell(row1_cellOne);
                    table.addCell(row1_cellTwo);
                    table.addCell(row1_cellThree);
                    table.addCell(row1_cellFour);
                    table.addCell(row1_cellFive);
                    table.addCell(row1_cellSix);
                    table.addCell(row1_cellSeven);
                    table.addCell(row1_cellEight);

                    PdfPCell row2_cellOne = new PdfPCell(new Phrase("Sifat"));
                    PdfPCell row2_cellTwo = new PdfPCell(new Phrase(":"));
                    PdfPCell row2_cellThree = new PdfPCell(new Phrase(sifat));
                    PdfPCell row2_cellFour = new PdfPCell(new Phrase(""));
                    PdfPCell row2_cellFive = new PdfPCell(new Phrase(""));
                    PdfPCell row2_cellSix = new PdfPCell(new Phrase(""));
                    PdfPCell row2_cellSeven = new PdfPCell(new Phrase(""));
                    PdfPCell row2_cellEight = new PdfPCell(new Phrase(""));

                    row2_cellOne.setBorder(Rectangle.NO_BORDER);
                    row2_cellTwo.setBorder(Rectangle.NO_BORDER);
                    row2_cellThree.setBorder(Rectangle.NO_BORDER);
                    row2_cellFour.setBorder(Rectangle.NO_BORDER);
                    row2_cellFive.setBorder(Rectangle.NO_BORDER);
                    row2_cellSix.setBorder(Rectangle.NO_BORDER);
                    row2_cellSeven.setBorder(Rectangle.NO_BORDER);
                    row2_cellEight.setBorder(Rectangle.NO_BORDER);

                    // Add table cells
                    table.addCell(row2_cellOne);
                    table.addCell(row2_cellTwo);
                    table.addCell(row2_cellThree);
                    table.addCell(row2_cellFour);
                    table.addCell(row2_cellFive);
                    table.addCell(row2_cellSix);
                    table.addCell(row2_cellSeven);
                    table.addCell(row2_cellEight);

                    PdfPCell row3_cellOne = new PdfPCell(new Phrase("Lampiran"));
                    PdfPCell row3_cellTwo = new PdfPCell(new Phrase(":"));
                    PdfPCell row3_cellThree = new PdfPCell(new Phrase(lampiran));
                    PdfPCell row3_cellFour = new PdfPCell(new Phrase(""));
                    PdfPCell row3_cellFive = new PdfPCell(new Phrase(""));
                    PdfPCell row3_cellSix = new PdfPCell(new Phrase(""));
                    PdfPCell row3_cellSeven = new PdfPCell(new Phrase(""));
                    PdfPCell row3_cellEight = new PdfPCell(new Phrase(""));

                    row3_cellOne.setBorder(Rectangle.NO_BORDER);
                    row3_cellTwo.setBorder(Rectangle.NO_BORDER);
                    row3_cellThree.setBorder(Rectangle.NO_BORDER);
                    row3_cellFour.setBorder(Rectangle.NO_BORDER);
                    row3_cellFive.setBorder(Rectangle.NO_BORDER);
                    row3_cellSix.setBorder(Rectangle.NO_BORDER);
                    row3_cellSeven.setBorder(Rectangle.NO_BORDER);
                    row3_cellEight.setBorder(Rectangle.NO_BORDER);

                    // Add table cells
                    table.addCell(row3_cellOne);
                    table.addCell(row3_cellTwo);
                    table.addCell(row3_cellThree);
                    table.addCell(row3_cellFour);
                    table.addCell(row3_cellFive);
                    table.addCell(row3_cellSix);
                    table.addCell(row3_cellSeven);
                    table.addCell(row3_cellEight);

                    PdfPCell row4_cellOne = new PdfPCell(new Phrase("Perihal"));
                    PdfPCell row4_cellTwo = new PdfPCell(new Phrase(":"));
                    PdfPCell row4_cellThree = new PdfPCell(new Phrase(perihal));
                    PdfPCell row4_cellFour = new PdfPCell(new Phrase(""));
                    PdfPCell row4_cellFive = new PdfPCell(new Phrase(""));
                    PdfPCell row4_cellSix = new PdfPCell(new Phrase(""));
                    PdfPCell row4_cellSeven = new PdfPCell(new Phrase(""));
                    PdfPCell row4_cellEight = new PdfPCell(new Phrase("Kepada"));

                    row4_cellOne.setBorder(Rectangle.NO_BORDER);
                    row4_cellTwo.setBorder(Rectangle.NO_BORDER);
                    row4_cellThree.setBorder(Rectangle.NO_BORDER);
                    row4_cellFour.setBorder(Rectangle.NO_BORDER);
                    row4_cellFive.setBorder(Rectangle.NO_BORDER);
                    row4_cellSix.setBorder(Rectangle.NO_BORDER);
                    row4_cellSeven.setBorder(Rectangle.NO_BORDER);
                    row4_cellEight.setBorder(Rectangle.NO_BORDER);

                    // Add table cells
                    table.addCell(row4_cellOne);
                    table.addCell(row4_cellTwo);
                    table.addCell(row4_cellThree);
                    table.addCell(row4_cellFour);
                    table.addCell(row4_cellFive);
                    table.addCell(row4_cellSix);
                    table.addCell(row4_cellSeven);
                    table.addCell(row4_cellEight);

                    PdfPCell row5_cellOne = new PdfPCell(new Phrase(""));
                    PdfPCell row5_cellTwo = new PdfPCell(new Phrase(""));
                    PdfPCell row5_cellThree = new PdfPCell(new Phrase(""));
                    PdfPCell row5_cellFour = new PdfPCell(new Phrase(""));
                    PdfPCell row5_cellFive = new PdfPCell(new Phrase("Yth."));
                    PdfPCell row5_cellSix = new PdfPCell(new Phrase(""));
                    PdfPCell row5_cellSeven = new PdfPCell(new Phrase(""));
                    PdfPCell row5_cellEight = new PdfPCell(new Phrase(kepada));

                    row5_cellOne.setBorder(Rectangle.NO_BORDER);
                    row5_cellTwo.setBorder(Rectangle.NO_BORDER);
                    row5_cellThree.setBorder(Rectangle.NO_BORDER);
                    row5_cellFour.setBorder(Rectangle.NO_BORDER);
                    row5_cellFive.setBorder(Rectangle.NO_BORDER);
                    row5_cellSix.setBorder(Rectangle.NO_BORDER);
                    row5_cellSeven.setBorder(Rectangle.NO_BORDER);
                    row5_cellEight.setBorder(Rectangle.NO_BORDER);

                    // Add table cells
                    table.addCell(row5_cellOne);
                    table.addCell(row5_cellTwo);
                    table.addCell(row5_cellThree);
                    table.addCell(row5_cellFour);
                    table.addCell(row5_cellFive);
                    table.addCell(row5_cellSix);
                    table.addCell(row5_cellSeven);
                    table.addCell(row5_cellEight);

                    document.add(table);

                    Font boldFont = new Font(Font.FontFamily.HELVETICA, 12);
                    Paragraph para2 = new Paragraph(keterangan, boldFont);
                    para2.setAlignment(Element.ALIGN_JUSTIFIED);
                    para2.setFirstLineIndent(70f);
                    para2.setSpacingBefore(10f);
                    para2.setSpacingAfter(20f);

                    document.add(para2);

                    PdfPTable table2 = new PdfPTable(3);

                    // Set table properties
                    table.setWidthPercentage(78);
                    table.setHorizontalAlignment(Element.ALIGN_LEFT);
                    float[] columnWidth = {1.7f, 0.1f, 2f};
                    table2.setWidths(columnWidth);

                    Font data_font = new Font(Font.FontFamily.HELVETICA, 11);
                    PdfPCell cellOne = new PdfPCell(new Phrase("Nama",data_font));
                    PdfPCell cellTwo = new PdfPCell(new Phrase(":",data_font));
                    PdfPCell cellThree = new PdfPCell(new Phrase((String) atas_namas,data_font));

                    cellOne.setBorder(Rectangle.NO_BORDER);
                    cellTwo.setBorder(Rectangle.NO_BORDER);
                    cellThree.setBorder(Rectangle.NO_BORDER);
                    cellOne.setPaddingLeft(47f);

                    PdfPCell cellFour = new PdfPCell(new Phrase("NIP / NRK",data_font));
                    PdfPCell cellFive = new PdfPCell(new Phrase(":",data_font));
                    PdfPCell cellSix = new PdfPCell(new Phrase(sp.nip+"/"+sp.nrk,data_font));

                    cellFour.setBorder(Rectangle.NO_BORDER);
                    cellFive.setBorder(Rectangle.NO_BORDER);
                    cellSix.setBorder(Rectangle.NO_BORDER);
                    cellFour.setPaddingLeft(47f);

                    PdfPCell cellSeven = new PdfPCell(new Phrase("Pangkat / Golongan",data_font));
                    PdfPCell cellEight = new PdfPCell(new Phrase(":",data_font));
                    PdfPCell cellNine = new PdfPCell(new Phrase(sp.pangkat+"/ ("+sp.golongan+")",data_font));

                    cellSeven.setBorder(Rectangle.NO_BORDER);
                    cellEight.setBorder(Rectangle.NO_BORDER);
                    cellNine.setBorder(Rectangle.NO_BORDER);
                    cellSeven.setPaddingLeft(47f);

                    PdfPCell cellTen = new PdfPCell(new Phrase("Jabatan",data_font));
                    PdfPCell cellEleven = new PdfPCell(new Phrase(":",data_font));
                    PdfPCell cellTwelve =  new PdfPCell(new Phrase(sp.jabatan,data_font));

                    cellTen.setBorder(Rectangle.NO_BORDER);
                    cellEleven.setBorder(Rectangle.NO_BORDER);
                    cellTwelve.setBorder(Rectangle.NO_BORDER);
                    cellTen.setPaddingLeft(47f);

                    PdfPCell cell13 = new PdfPCell(new Phrase("Tempat Tugas",data_font));
                    PdfPCell cell14 = new PdfPCell(new Phrase(":",data_font));
                    PdfPCell cell15 =  new PdfPCell(new Phrase("SMP Negeri 223 Jakarta",data_font));

                    cell13.setBorder(Rectangle.NO_BORDER);
                    cell14.setBorder(Rectangle.NO_BORDER);
                    cell15.setBorder(Rectangle.NO_BORDER);
                    if (jenis_permohonan.equals("lainnya")) {
                        cell15.setPaddingBottom(40f);
                    }
                    cell13.setPaddingLeft(47f);

                    String tmt_pensiun = (sp.pensiun.isEmpty()) ? "Silahkan update tgl pensiun di master data guru terlebih dahulu" : Fungsi.getDate(sp.pensiun);
                    PdfPCell cell16 = new PdfPCell(new Phrase("TMT Pensiun",data_font));
                    PdfPCell cell17 = new PdfPCell(new Phrase(":",data_font));
                    PdfPCell cell18 =  new PdfPCell(new Phrase(tmt_pensiun,data_font));

                    cell16.setBorder(Rectangle.NO_BORDER);
                    cell17.setBorder(Rectangle.NO_BORDER);
                    cell18.setBorder(Rectangle.NO_BORDER);
                    cell18.setPaddingBottom(40f);
                    cell16.setPaddingLeft(47f);

                    // Add table cells
                    table2.addCell(cellOne);
                    table2.addCell(cellTwo);
                    table2.addCell(cellThree);
                    table2.addCell(cellFour);
                    table2.addCell(cellFive);
                    table2.addCell(cellSix);
                    table2.addCell(cellSeven);
                    table2.addCell(cellEight);
                    table2.addCell(cellNine);
                    table2.addCell(cellTen);
                    table2.addCell(cellEleven);
                    table2.addCell(cellTwelve);
                    table2.addCell(cell13);
                    table2.addCell(cell14);
                    table2.addCell(cell15);
                    if (jenis_permohonan.equals("pensiun")) {
                        table2.addCell(cell16);
                        table2.addCell(cell17);
                        table2.addCell(cell18);
                    }

                    // Add the table to the document
                    document.add(table2);

                    Paragraph para3 = new Paragraph("Demikian atas perhatian Bapak di ucapkan terima kasih.", boldFont);
                    para3.setAlignment(Element.ALIGN_JUSTIFIED);
                    para3.setFirstLineIndent(70f);
                    para3.setSpacingAfter(40f);

                    document.add(para3);

                    // Create the content table
                    PdfPTable contentTable3 = new PdfPTable(1);
                    contentTable3.setWidthPercentage(48);
                    contentTable3.setHorizontalAlignment(Element.ALIGN_RIGHT);

                    // Add the content footer rows to the table
                    PdfPCell cell_footer2 = new PdfPCell(new Phrase("Kepala SMP Negeri 223 Jakarta", new Font(Font.FontFamily.HELVETICA,11)));
                    cell_footer2.setBorder(PdfPCell.NO_BORDER);  
                    cell_footer2.setPaddingBottom(60f);
                    contentTable3.addCell(cell_footer2);

                    // Add the content footer rows to the table
                    PdfPCell cell_footer3 = new PdfPCell(new Phrase("OMAN NURYANI, M.Pd.", new Font(Font.FontFamily.HELVETICA,11)));
                    cell_footer3.setBorder(PdfPCell.NO_BORDER);
                    cell_footer3.setPaddingLeft(15f);
                    contentTable3.addCell(cell_footer3);

                    PdfPCell cell_footer4 = new PdfPCell(new Phrase("NIP. 196807191997031003", new Font(Font.FontFamily.HELVETICA,11)));
                    cell_footer4.setBorder(PdfPCell.NO_BORDER);  
                    cell_footer4.setPaddingLeft(5f);
                    contentTable3.addCell(cell_footer4);

                    document.add(contentTable3);

                    document.close();
                    System.out.println("File created successfully");
                }
                File file1 = new File(filePath);

                JOptionPane.showMessageDialog(null, "Data berhasil dicetak", "Pesan", JOptionPane.INFORMATION_MESSAGE);
                // Open the URL in the default web browser
                Desktop.getDesktop().open(file1);
            } catch (Exception e) {
                    System.out.println(e);
            }
        }
    }//GEN-LAST:event_jButton6KeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    // End of variables declaration//GEN-END:variables
}
