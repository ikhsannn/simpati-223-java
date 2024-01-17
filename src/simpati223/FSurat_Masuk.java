/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simpati223;

import java.awt.Desktop;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author Maulana Yusuf
 */
public class FSurat_Masuk extends javax.swing.JInternalFrame {

    private JFrame frame;
    private JFileChooser fileChooser;
    private DefaultTableModel DftTblModel_Surat_Masuk;
    private String SQL,dateChooser;
    /**
     * Creates new form FSurat_Masuk
     */
    public FSurat_Masuk() {
        initComponents();
        //letakkan fungsi tampil data disini
        TampilData();
        disableData();
        
        frame = new JFrame("File Upload Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jButton7.addActionListener(e -> {
            fileChooser = new JFileChooser();
            int result = fileChooser.showOpenDialog(frame);
            if (result == JFileChooser.APPROVE_OPTION) {
                // Get file path
                String path = fileChooser.getSelectedFile().getAbsolutePath();
                java.io.File selectedFile = fileChooser.getSelectedFile();
                String folderPath = "C:\\simpati223\\upload";
                String filePath = "C:\\simpati223\\upload\\"+"SM-"+jTextField3.getText()+".pdf";
                String file_name = "SM-"+jTextField3.getText()+".pdf";
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
                            try {
                                String destination = folder.getAbsolutePath() + File.separator + file_name;
                                // Copy file from source to destination
                                FileChannel source = new FileInputStream(path).getChannel();
                                FileChannel dest = new FileOutputStream(destination).getChannel();
                                dest.transferFrom(source, 0, source.size());

                                // Close shit
                                source.close();
                                dest.close();

                                System.out.println("File created successfully");
                            } catch (IOException es) {
                                es.printStackTrace();
                            }
                        }else{
                            System.out.println("Failed to create file");
                        }
                    }catch(IOException ef) {
                        System.out.println("An error occurred while creating the file: " + ef.getMessage());
                    }
                }else{
                    try {
                        String destination = folder.getAbsolutePath() + File.separator + file_name;
                        // Copy file from source to destination
                        FileChannel source = new FileInputStream(path).getChannel();
                        FileChannel dest = new FileOutputStream(destination).getChannel();
                        dest.transferFrom(source, 0, source.size());

                        // Close shit
                        source.close();
                        dest.close();

                        System.out.println("File created successfully");
                    } catch (IOException es) {
                        es.printStackTrace();
                    }
                }
//                String fileName = selectedFile.getName();
                jTextField9.setText(file_name);
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setPreferredSize(new java.awt.Dimension(700, 600));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Surat Masuk");

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
                .addGap(18, 18, 18))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                        .addGap(2, 2, 2))
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING))
                .addGap(13, 13, 13))
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
                .addGap(10, 10, 10))
        );

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No Surat", "Perihal", "Tanggal Surat", "Asal Surat", "File Surat"
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
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setToolTipText("");
        jPanel2.setName(""); // NOI18N
        jPanel2.setLayout(new java.awt.GridBagLayout());

        jLabel8.setText("No Surat");
        jLabel8.setPreferredSize(new java.awt.Dimension(120, 14));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel2.add(jLabel8, gridBagConstraints);

        jTextField3.setPreferredSize(new java.awt.Dimension(145, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        jPanel2.add(jTextField3, gridBagConstraints);

        jLabel9.setText("Pengirim");
        jLabel9.setPreferredSize(new java.awt.Dimension(120, 14));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel2.add(jLabel9, gridBagConstraints);

        jTextField4.setPreferredSize(new java.awt.Dimension(145, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        jPanel2.add(jTextField4, gridBagConstraints);

        jLabel10.setText("Alamat Pengirim");
        jLabel10.setPreferredSize(new java.awt.Dimension(120, 14));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        jPanel2.add(jLabel10, gridBagConstraints);

        jLabel11.setText("Perihal");
        jLabel11.setPreferredSize(new java.awt.Dimension(120, 14));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel2.add(jLabel11, gridBagConstraints);

        jTextField6.setPreferredSize(new java.awt.Dimension(145, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        jPanel2.add(jTextField6, gridBagConstraints);

        jLabel12.setText("Tanggal Surat");
        jLabel12.setPreferredSize(new java.awt.Dimension(120, 14));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel2.add(jLabel12, gridBagConstraints);

        jLabel14.setText("Asal Surat");
        jLabel14.setPreferredSize(new java.awt.Dimension(120, 14));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel2.add(jLabel14, gridBagConstraints);

        jTextField8.setPreferredSize(new java.awt.Dimension(145, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        jPanel2.add(jTextField8, gridBagConstraints);

        jLabel15.setText("File Surat");
        jLabel15.setPreferredSize(new java.awt.Dimension(120, 14));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel2.add(jLabel15, gridBagConstraints);

        jTextField9.setPreferredSize(new java.awt.Dimension(145, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 2;
        jPanel2.add(jTextField9, gridBagConstraints);

        jLabel5.setPreferredSize(new java.awt.Dimension(50, 14));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        jPanel2.add(jLabel5, gridBagConstraints);

        jButton7.setText("Pilih");
        jButton7.setPreferredSize(new java.awt.Dimension(65, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_END;
        jPanel2.add(jButton7, gridBagConstraints);

        jButton8.setText("Buka");
        jButton8.setPreferredSize(new java.awt.Dimension(65, 25));
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        jPanel2.add(jButton8, gridBagConstraints);

        jDateChooser1.setPreferredSize(new java.awt.Dimension(145, 25));
        jDateChooser1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jDateChooser1PropertyChange(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 1;
        jPanel2.add(jDateChooser1, gridBagConstraints);

        jScrollPane2.setPreferredSize(new java.awt.Dimension(145, 96));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setPreferredSize(new java.awt.Dimension(145, 94));
        jScrollPane2.setViewportView(jTextArea1);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        jPanel2.add(jScrollPane2, gridBagConstraints);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(10, 10, 10))
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
        DftTblModel_Surat_Masuk = new DefaultTableModel();
        DftTblModel_Surat_Masuk.addColumn("id");
        DftTblModel_Surat_Masuk.addColumn("No Surat");
        DftTblModel_Surat_Masuk.addColumn("Pengirim");
        DftTblModel_Surat_Masuk.addColumn("Alamat Pengirim");
        DftTblModel_Surat_Masuk.addColumn("Perihal");
        DftTblModel_Surat_Masuk.addColumn("Tanggal Surat"); 
        DftTblModel_Surat_Masuk.addColumn("Asal Surat");
        DftTblModel_Surat_Masuk.addColumn("File Surat");
       jTable1.setModel(DftTblModel_Surat_Masuk);

        Connection conn = Koneksi.getConnection();
        try {
            java.sql.Statement stmt = conn.createStatement();
            SQL = "select * from surat_masuk";
            java.sql.ResultSet res = stmt.executeQuery(SQL);
            while (res.next()) {
               DftTblModel_Surat_Masuk.addRow(new Object[]{
                    res.getString("id"),
                    res.getString("no_surat"), //tampilin ke layar
                    res.getString("pengirim"),
                    res.getString("alamat_pengirim"), 
                    res.getString("perihal"),//tampilin ke layar
                    res.getString("tgl_surat"),//tampilin ke layar
                    res.getString("asal_surat"), //tampilin ke layar
                    res.getString("nama_berkas"), //tampilin ke layar
                });
            }
            hideJTableColumn(jTable1.getColumnModel().getColumn(0));
            hideJTableColumn(jTable1.getColumnModel().getColumn(2));
            hideJTableColumn(jTable1.getColumnModel().getColumn(3));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void disableData(){
        jTextField2.setVisible(false);
        jButton2.setEnabled(false);
        jButton3.setEnabled(false);
        jButton4.setEnabled(false);
        jButton7.setEnabled(false);
        jButton8.setEnabled(false);
        //atur dibawahnya
        jTextField3.setEnabled(false);
        jTextField4.setEnabled(false);
        jTextArea1.setEnabled(false);
        jTextField6.setEnabled(false);
        jDateChooser1.setEnabled(false);
        jTextField8.setEnabled(false);
        jTextField9.setEnabled(false);
    }
//    
    public void enableData(){
        jButton2.setEnabled(true);
        jButton3.setEnabled(false);
        jButton4.setEnabled(false);
        jButton7.setEnabled(true);
        jButton8.setEnabled(false);
        //atur dibawahnya
        jTextField3.setEnabled(true);
        jTextField4.setEnabled(true);
        jTextArea1.setEnabled(true);
        jTextField6.setEnabled(true);
        jDateChooser1.setEnabled(true);
        jTextField8.setEnabled(true);
        jTextField9.setEnabled(false);
    }
//    
    public void enableDataEdit(){
        jButton2.setEnabled(false);
        jButton3.setEnabled(true);
        jButton4.setEnabled(true);
        jButton7.setEnabled(true);
        jButton8.setEnabled(true);
        //atur dibawahnya
        jTextField3.setEnabled(true);
        jTextField4.setEnabled(true);
        jTextArea1.setEnabled(true);
        jTextField6.setEnabled(true);
        jDateChooser1.setEnabled(true);
        jTextField8.setEnabled(true);
        jTextField9.setEnabled(false);
    }
//    
    public void clearData(){
        jTextField2.setText("");
        jTextField3.setText("");
        jTextField4.setText("");
        jTextArea1.setText("");
        jTextField6.setText("");
        jDateChooser1.setDate(null);
        jTextField8.setText("");
        jTextField9.setText("");
    }
    
    private void setTanggal(){
        Connection conn = Koneksi.getConnection();
        try {
        
            java.sql.Statement stmt = conn.createStatement();
            SQL = "select * from surat_masuk where id like '%" +jTextField2.getText()+"'";
            java.sql.ResultSet res = stmt.executeQuery(SQL);
            while (res.next())
            {
                jDateChooser1.setDate(res.getDate("tgl_surat", null));
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Ada kesalahan server, silahkan hubungi developer", "Pesan", JOptionPane.INFORMATION_MESSAGE);
        }
    }
//    
 public void getData() {
      jTextField2.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString());
        //atur dibawahnya 
        jTextField3.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 1).toString());
        jTextField4.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 2).toString());
        jTextArea1.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 3).toString());
        jTextField6.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 4).toString());
        setTanggal();
        jTextField8.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 6).toString());
        jTextField9.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 7).toString());
        jButton2.setEnabled(false);
    }

//    
  public void simpanData() {
    try {
        Connection conn = Koneksi.getConnection();
        PreparedStatement stmt = conn.prepareStatement("insert into surat_masuk(no_surat, pengirim, alamat_pengirim, perihal, tgl_surat, asal_surat, nama_berkas) "
                + "values(?,?,?,?,?,?,?)");
        stmt.setString(1, jTextField3.getText());
        stmt.setString(2, jTextField4.getText());
        stmt.setString(3, jTextArea1.getText());
        stmt.setString(4, jTextField6.getText());
        stmt.setObject(5, jDateChooser1.getDate());
        stmt.setString(6, jTextField8.getText()); 
        stmt.setString(7, jTextField9.getText()); 

        stmt.executeUpdate();
        JOptionPane.showMessageDialog(null, "Data berhasil disimpan", "Pesan", JOptionPane.INFORMATION_MESSAGE);
        TampilData();
        clearData();
    } catch (SQLException e) {
        System.out.println(e.getMessage());
    }
}

//    
    public void editData(){
        try {
            Connection conn = Koneksi.getConnection();
            Object id = jTable1.getValueAt(jTable1.getSelectedRow(), 0);
            PreparedStatement stmt = conn.prepareStatement("UPDATE surat_masuk SET no_surat='" + jTextField3.getText() + 
                    "'," + "pengirim ='" +jTextField4.getText() +"',alamat_pengirim ='" +jTextArea1.getText()+
                    "'," + "perihal ='" +jTextField6.getText() +"',tgl_surat ='" +dateChooser+
                    "'," + "asal_surat ='" +jTextField8.getText() +"',nama_berkas ='" +jTextField9.getText()+
                    "' WHERE id='" +id+"'");
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data berhasil diubah", "Pesan", JOptionPane.INFORMATION_MESSAGE);
            TampilData();
            clearData();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void deleteData(){
        Connection conn = Koneksi.getConnection();
        int confirm = JOptionPane.showConfirmDialog(null, "Apakah anda yakin ingin menghapus data tersebut?", 
                "Konfirmasi", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (confirm == 0) {
            try {
                Object id = jTable1.getValueAt(jTable1.getSelectedRow(), 0);
                java.sql.PreparedStatement stmt = conn.prepareStatement("delete from surat_masuk "
                        + "where id ='" + id + "'");
                stmt.executeUpdate();
                JOptionPane.showMessageDialog(null, "Data berhasil dihapus", "Pesan", 
                        JOptionPane.INFORMATION_MESSAGE);
                TampilData();
                clearData();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Data gagal di hapus" + e.getMessage(), "Pesan", 
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    private void uploadFile(String filePath) {
        // Perform the file upload operation
        System.out.println("Uploading file: " + filePath);
        // ...
    }
    
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        if (fileChooser != null && fileChooser.getSelectedFile() != null) {
            String filePath = "C:\\simpati223\\upload\\"+"SM-"+jTextField3.getText()+".pdf";
            // Perform the file upload operation using the selected file path
            uploadFile(filePath);
            simpanData();
        } else {
            System.out.println("No file selected.");
            simpanData();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton2KeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER){
            if (fileChooser != null && fileChooser.getSelectedFile() != null) {
                String filePath = "C:\\simpati223\\upload\\"+"SM-"+jTextField3.getText()+".pdf";
                // Perform the file upload operation using the selected file path
                uploadFile(filePath);
                simpanData();
            } else {
                System.out.println("No file selected.");
                simpanData();
            }
        }
    }//GEN-LAST:event_jButton2KeyPressed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        String id = jTextField2.getText();
        if (id.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Silahkan pilih data terlebih dahulu atau klik tombol new", "Pesan", JOptionPane.INFORMATION_MESSAGE);
        } else {
            if (fileChooser != null && fileChooser.getSelectedFile() != null) {
                String filePath = "C:\\simpati223\\upload\\"+"SM-"+jTextField3.getText()+".pdf";
                // Perform the file upload operation using the selected file path
                uploadFile(filePath);
                editData();
            } else {
                System.out.println("No file selected.");
                editData();
            }
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton3KeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER){
            String id = jTextField2.getText();
            if (id.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Silahkan pilih data terlebih dahulu atau klik tombol new", "Pesan", JOptionPane.INFORMATION_MESSAGE);
            } else {
                if (fileChooser != null && fileChooser.getSelectedFile() != null) {
                    String filePath = "C:\\simpati223\\upload\\"+"SM-"+jTextField3.getText()+".pdf";
                    // Perform the file upload operation using the selected file path
                    uploadFile(filePath);
                    editData();
                } else {
                    System.out.println("No file selected.");
                    editData();
                }
            }
        }
    }//GEN-LAST:event_jButton3KeyPressed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        String id = jTextField2.getText();
        if (id.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Silahkan pilih data terlebih dahulu atau klik tombol new", "Pesan", JOptionPane.INFORMATION_MESSAGE);
        } else {
            String folderPath = "C:\\simpati223\\upload";
            String filePath = "C:\\simpati223\\upload\\"+"SM-"+jTextField3.getText()+".pdf";
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
            if (file.exists()) {
                try {
                    if (file.delete()) {
                        System.out.println("File deleted successfully");
                    } else {
                        System.out.println("Failed to delete the file");
                    }
                } catch (SecurityException e) {
                    System.out.println("Failed to delete the file due to security restrictions");
                    e.printStackTrace();
                }
            } else {
                System.out.println("File does not exist");
            }
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
                String folderPath = "C:\\simpati223\\upload";
                String filePath = "C:\\simpati223\\upload\\"+"SM-"+jTextField3.getText()+".pdf";
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
                if (file.exists()) {
                    try {
                        if (file.delete()) {
                            System.out.println("File deleted successfully");
                        } else {
                            System.out.println("Failed to delete the file");
                        }
                    } catch (SecurityException e) {
                        System.out.println("Failed to delete the file due to security restrictions");
                        e.printStackTrace();
                    }
                } else {
                    System.out.println("File does not exist");
                }
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

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        String filePath = "C:\\simpati223\\upload\\"+"SM-"+jTextField3.getText()+".pdf";
        File file1 = new File(filePath);
        if (file1.exists()) {
            try {
                Desktop.getDesktop().open(file1);
            } catch (IOException ex) {
                Logger.getLogger(FSurat_Masuk.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            JOptionPane.showMessageDialog(null, "File belum diupload, silahkan upload terlebih dahulu", "Pesan", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_jButton8ActionPerformed

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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    // End of variables declaration//GEN-END:variables
}
