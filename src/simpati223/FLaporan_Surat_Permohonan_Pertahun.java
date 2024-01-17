/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simpati223;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import static simpati223.FSurat_Permohonan.hideJTableColumn;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import static simpati223.FSurat_Permohonan.hideJTableColumn;
import simpati223.Fungsi;
import java.awt.Desktop;
import java.io.File;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.TableColumn;
import static simpati223.FLaporan_Surat_Permohonan_Perbulan.hideJTableColumn;
import static simpati223.FSiswa.hideJTableColumn;

/**
 *
 * @author Ikhsan Abdillah
 */
public class FLaporan_Surat_Permohonan_Pertahun extends javax.swing.JInternalFrame {

    /**
     * Creates new form FLaporan_Surat_permohonan_Pertahun
     */
    public FLaporan_Surat_Permohonan_Pertahun() {
        initComponents();
        TampilData();
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
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jYearChooser2 = new com.toedter.calendar.JYearChooser();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Laporan Surat Permohonan Pertahun");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setToolTipText("");
        jPanel2.setName(""); // NOI18N

        jButton1.setText("CETAK");
        jButton1.setPreferredSize(new java.awt.Dimension(100, 25));
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

        jYearChooser2.setPreferredSize(new java.awt.Dimension(47, 25));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jYearChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jYearChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10))
        );

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No Surat", "Tgl Surat", "Asal Surat", "Perihal"
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
            .addGap(0, 684, Short.MAX_VALUE)
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel7Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1)
                    .addContainerGap()))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 297, Short.MAX_VALUE)
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel7Layout.createSequentialGroup()
                    .addGap(20, 20, 20)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(21, Short.MAX_VALUE)))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setToolTipText("");
        jPanel3.setName(""); // NOI18N

        jButton2.setBackground(new java.awt.Color(0, 153, 0));
        jButton2.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Batal");
        jButton2.setPreferredSize(new java.awt.Dimension(100, 25));
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

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(16, 16, 16)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private DefaultTableModel DftTblModel_Permohonan;
    private String SQL;
    
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
                  "LEFT JOIN guru b ON a.atas_nama = b.id ";
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
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Connection conn = Koneksi.getConnection();
        try {
            String folderPath = "C:\\simpati223";
            int year = jYearChooser2.getYear();
            String date = Integer.toString(year);
            System.out.println(date);
            String filePath = "C:\\simpati223\\laporan_surat_permohonan_pertahun_"+date+".pdf";

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
                        Document document = new Document();
                        PdfWriter.getInstance(document, new FileOutputStream(filePath));

                        document.open();

                        //created a title from pdf
                        Font boldFont = new Font(Font.FontFamily.TIMES_ROMAN, 17, Font.BOLD);
                        Paragraph para = new Paragraph("Laporan Surat Permohonan Tahun "+date, boldFont);
                        para.setAlignment(Element.ALIGN_CENTER);

                        document.add(para);
                        
                        // Create the table
                        PdfPTable table = new PdfPTable(6);
                        table.setWidthPercentage(100);
                        table.setSpacingBefore(40f);

                        // Set column widths
                        float[] columnWidths = { 0.7f, 2f, 2f, 2f, 2f, 3f };
                        table.setWidths(columnWidths);

                        // Add table headers
                        Font headerFont = new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.BOLD);
                        table.addCell(new PdfPCell(new Phrase("#", headerFont)));
                        table.addCell(new PdfPCell(new Phrase("No Surat", headerFont)));
                        table.addCell(new PdfPCell(new Phrase("Tgl Surat", headerFont)));
                        table.addCell(new PdfPCell(new Phrase("Sifat", headerFont)));
                        table.addCell(new PdfPCell(new Phrase("Lampiran", headerFont)));
                        table.addCell(new PdfPCell(new Phrase("Perihal", headerFont)));

                        // Retrieve data from the database
                        String SQL = "SELECT * FROM surat_permohonan WHERE YEAR(tgl_surat) = ?";
                        PreparedStatement stmt = conn.prepareStatement(SQL);
                        stmt.setString(1, date);
                        ResultSet res = stmt.executeQuery();

                        Font bodyFont = new Font(Font.FontFamily.TIMES_ROMAN, 10);
                        int no = 0;
                        while (res.next()) {
                            no++;
                            table.addCell(new PdfPCell(new Phrase(String.valueOf(no), bodyFont)));
                            table.addCell(new PdfPCell(new Phrase(res.getString("no_surat"), bodyFont)));
                            table.addCell(new PdfPCell(new Phrase(res.getString("tgl_surat"), bodyFont)));
                            table.addCell(new PdfPCell(new Phrase(res.getString("sifat"), bodyFont)));
                            table.addCell(new PdfPCell(new Phrase(res.getString("lampiran"), bodyFont)));
                            table.addCell(new PdfPCell(new Phrase(res.getString("perihal"), bodyFont)));

                            // Apply styling to body cells
                            table.getRow(no).getCells()[0].setHorizontalAlignment(Element.ALIGN_CENTER);
                            table.getRow(no).getCells()[1].setPaddingLeft(4f);
                            table.getRow(no).getCells()[2].setPaddingLeft(4f);
                            table.getRow(no).getCells()[3].setPaddingLeft(4f);
                            table.getRow(no).getCells()[4].setPaddingLeft(4f);
                            table.getRow(no).getCells()[5].setPaddingLeft(4f);
                        }

                        table.getRow(0).getCells()[0].setHorizontalAlignment(Element.ALIGN_CENTER);
                        table.getRow(0).getCells()[1].setHorizontalAlignment(Element.ALIGN_CENTER);
                        table.getRow(0).getCells()[2].setHorizontalAlignment(Element.ALIGN_CENTER);
                        table.getRow(0).getCells()[3].setHorizontalAlignment(Element.ALIGN_CENTER);
                        table.getRow(0).getCells()[4].setHorizontalAlignment(Element.ALIGN_CENTER);
                        table.getRow(0).getCells()[5].setHorizontalAlignment(Element.ALIGN_CENTER);

                        // Add the table to the document
                        document.add(table);

                        document.close();
                        System.out.println("File created successfully");
                    } else {
                        System.out.println("Failed to create file");
                    }
                } catch (IOException e) {
                    System.out.println("An error occurred while creating the file: " + e.getMessage());
                }
            } else {
                //if file exist, then we can create the content from pdf
                Document document = new Document();
                PdfWriter.getInstance(document, new FileOutputStream(filePath));

                document.open();

                //created a title from pdf
                Font boldFont = new Font(Font.FontFamily.TIMES_ROMAN, 17, Font.BOLD);
                Paragraph para = new Paragraph("Laporan Surat Permohonan Tahun "+date, boldFont);
                para.setAlignment(Element.ALIGN_CENTER);

                document.add(para);

                // then we create a table with five columns
                PdfPTable table = new PdfPTable(6);

                // Set table properties
                table.setWidthPercentage(100);
                table.setSpacingBefore(40f);

                // Set column widths
                 float[] columnWidths = { 0.7f, 2f, 2f, 2f, 2f, 3f };
                table.setWidths(columnWidths);

                // Add table headers
                Font headerFont = new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.BOLD);
                table.addCell(new PdfPCell(new Phrase("#", headerFont)));
                table.addCell(new PdfPCell(new Phrase("No Surat", headerFont)));
                table.addCell(new PdfPCell(new Phrase("Tgl Surat", headerFont)));
                table.addCell(new PdfPCell(new Phrase("Sifat", headerFont)));
                table.addCell(new PdfPCell(new Phrase("Lampiran", headerFont)));
                table.addCell(new PdfPCell(new Phrase("Perihal", headerFont)));

                // Retrieve data from the database
                String SQL = "SELECT * FROM surat_permohonan WHERE YEAR(tgl_surat) = ?";
                PreparedStatement stmt = conn.prepareStatement(SQL);
                stmt.setString(1, date);
                ResultSet res = stmt.executeQuery();

                Font bodyFont = new Font(Font.FontFamily.TIMES_ROMAN, 10);
                int no = 0;
                while (res.next()) {
                    no++;
                    table.addCell(new PdfPCell(new Phrase(String.valueOf(no), bodyFont)));
                    table.addCell(new PdfPCell(new Phrase(res.getString("no_surat"), bodyFont)));
                    table.addCell(new PdfPCell(new Phrase(res.getString("tgl_surat"), bodyFont)));
                    table.addCell(new PdfPCell(new Phrase(res.getString("sifat"), bodyFont)));
                    table.addCell(new PdfPCell(new Phrase(res.getString("lampiran"), bodyFont)));
                    table.addCell(new PdfPCell(new Phrase(res.getString("perihal"), bodyFont)));
                    
                    // Apply styling to body cells
                    table.getRow(no).getCells()[0].setHorizontalAlignment(Element.ALIGN_CENTER);
                    table.getRow(no).getCells()[1].setPaddingLeft(4f);
                    table.getRow(no).getCells()[2].setPaddingLeft(4f);
                    table.getRow(no).getCells()[3].setPaddingLeft(4f);
                    table.getRow(no).getCells()[4].setPaddingLeft(4f);
                    table.getRow(no).getCells()[5].setPaddingLeft(4f);
                }
                
                table.getRow(0).getCells()[0].setHorizontalAlignment(Element.ALIGN_CENTER);
                table.getRow(0).getCells()[1].setHorizontalAlignment(Element.ALIGN_CENTER);
                table.getRow(0).getCells()[2].setHorizontalAlignment(Element.ALIGN_CENTER);
                table.getRow(0).getCells()[3].setHorizontalAlignment(Element.ALIGN_CENTER);
                table.getRow(0).getCells()[4].setHorizontalAlignment(Element.ALIGN_CENTER);
                table.getRow(0).getCells()[5].setHorizontalAlignment(Element.ALIGN_CENTER);

                // Add the table to the document
                document.add(table);
                
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
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton1KeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER){
            Connection conn = Koneksi.getConnection();
            try {
                String folderPath = "C:\\simpati223";
                int year = jYearChooser2.getYear();
                String date = Integer.toString(year);
                System.out.println(date);
                String filePath = "C:\\simpati223\\laporan_surat_permohonan_pertahun_"+date+".pdf";

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
                            Document document = new Document();
                            PdfWriter.getInstance(document, new FileOutputStream(filePath));

                            document.open();

                            //created a title from pdf
                            Font boldFont = new Font(Font.FontFamily.TIMES_ROMAN, 17, Font.BOLD);
                            Paragraph para = new Paragraph("Laporan Surat Permohonan Tahun "+date, boldFont);
                            para.setAlignment(Element.ALIGN_CENTER);

                            document.add(para);

                            // Create the table
                            PdfPTable table = new PdfPTable(6);
                            table.setWidthPercentage(100);
                            table.setSpacingBefore(40f);

                            // Set column widths
                            float[] columnWidths = { 0.7f, 2f, 2f, 2f, 2f, 3f };
                            table.setWidths(columnWidths);

                            // Add table headers
                            Font headerFont = new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.BOLD);
                            table.addCell(new PdfPCell(new Phrase("#", headerFont)));
                            table.addCell(new PdfPCell(new Phrase("No Surat", headerFont)));
                            table.addCell(new PdfPCell(new Phrase("Tgl Surat", headerFont)));
                            table.addCell(new PdfPCell(new Phrase("Sifat", headerFont)));
                            table.addCell(new PdfPCell(new Phrase("Lampiran", headerFont)));
                            table.addCell(new PdfPCell(new Phrase("Perihal", headerFont)));

                            // Retrieve data from the database
                            String SQL = "SELECT * FROM surat_permohonan WHERE YEAR(tgl_surat) = ?";
                            PreparedStatement stmt = conn.prepareStatement(SQL);
                            stmt.setString(1, date);
                            ResultSet res = stmt.executeQuery();

                            Font bodyFont = new Font(Font.FontFamily.TIMES_ROMAN, 10);
                            int no = 0;
                            while (res.next()) {
                                no++;
                                table.addCell(new PdfPCell(new Phrase(String.valueOf(no), bodyFont)));
                                table.addCell(new PdfPCell(new Phrase(res.getString("no_surat"), bodyFont)));
                                table.addCell(new PdfPCell(new Phrase(res.getString("tgl_surat"), bodyFont)));
                                table.addCell(new PdfPCell(new Phrase(res.getString("sifat"), bodyFont)));
                                table.addCell(new PdfPCell(new Phrase(res.getString("lampiran"), bodyFont)));
                                table.addCell(new PdfPCell(new Phrase(res.getString("perihal"), bodyFont)));

                                // Apply styling to body cells
                                table.getRow(no).getCells()[0].setHorizontalAlignment(Element.ALIGN_CENTER);
                                table.getRow(no).getCells()[1].setPaddingLeft(4f);
                                table.getRow(no).getCells()[2].setPaddingLeft(4f);
                                table.getRow(no).getCells()[3].setPaddingLeft(4f);
                                table.getRow(no).getCells()[4].setPaddingLeft(4f);
                                table.getRow(no).getCells()[5].setPaddingLeft(4f);
                            }

                            table.getRow(0).getCells()[0].setHorizontalAlignment(Element.ALIGN_CENTER);
                            table.getRow(0).getCells()[1].setHorizontalAlignment(Element.ALIGN_CENTER);
                            table.getRow(0).getCells()[2].setHorizontalAlignment(Element.ALIGN_CENTER);
                            table.getRow(0).getCells()[3].setHorizontalAlignment(Element.ALIGN_CENTER);
                            table.getRow(0).getCells()[4].setHorizontalAlignment(Element.ALIGN_CENTER);
                            table.getRow(0).getCells()[5].setHorizontalAlignment(Element.ALIGN_CENTER);

                            // Add the table to the document
                            document.add(table);

                            document.close();
                            System.out.println("File created successfully");
                        } else {
                            System.out.println("Failed to create file");
                        }
                    } catch (IOException e) {
                        System.out.println("An error occurred while creating the file: " + e.getMessage());
                    }
                } else {
                    //if file exist, then we can create the content from pdf
                    Document document = new Document();
                    PdfWriter.getInstance(document, new FileOutputStream(filePath));

                    document.open();

                    //created a title from pdf
                    Font boldFont = new Font(Font.FontFamily.TIMES_ROMAN, 17, Font.BOLD);
                    Paragraph para = new Paragraph("Laporan Surat Permohonan Tahun "+date, boldFont);
                    para.setAlignment(Element.ALIGN_CENTER);

                    document.add(para);

                    // then we create a table with five columns
                    PdfPTable table = new PdfPTable(6);

                    // Set table properties
                    table.setWidthPercentage(100);
                    table.setSpacingBefore(40f);

                    // Set column widths
                     float[] columnWidths = { 0.7f, 2f, 2f, 2f, 2f, 3f };
                    table.setWidths(columnWidths);

                    // Add table headers
                    Font headerFont = new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.BOLD);
                    table.addCell(new PdfPCell(new Phrase("#", headerFont)));
                    table.addCell(new PdfPCell(new Phrase("No Surat", headerFont)));
                    table.addCell(new PdfPCell(new Phrase("Tgl Surat", headerFont)));
                    table.addCell(new PdfPCell(new Phrase("Sifat", headerFont)));
                    table.addCell(new PdfPCell(new Phrase("Lampiran", headerFont)));
                    table.addCell(new PdfPCell(new Phrase("Perihal", headerFont)));

                    // Retrieve data from the database
                    String SQL = "SELECT * FROM surat_permohonan WHERE YEAR(tgl_surat) = ?";
                    PreparedStatement stmt = conn.prepareStatement(SQL);
                    stmt.setString(1, date);
                    ResultSet res = stmt.executeQuery();

                    Font bodyFont = new Font(Font.FontFamily.TIMES_ROMAN, 10);
                    int no = 0;
                    while (res.next()) {
                        no++;
                        table.addCell(new PdfPCell(new Phrase(String.valueOf(no), bodyFont)));
                        table.addCell(new PdfPCell(new Phrase(res.getString("no_surat"), bodyFont)));
                        table.addCell(new PdfPCell(new Phrase(res.getString("tgl_surat"), bodyFont)));
                        table.addCell(new PdfPCell(new Phrase(res.getString("sifat"), bodyFont)));
                        table.addCell(new PdfPCell(new Phrase(res.getString("lampiran"), bodyFont)));
                        table.addCell(new PdfPCell(new Phrase(res.getString("perihal"), bodyFont)));

                        // Apply styling to body cells
                        table.getRow(no).getCells()[0].setHorizontalAlignment(Element.ALIGN_CENTER);
                        table.getRow(no).getCells()[1].setPaddingLeft(4f);
                        table.getRow(no).getCells()[2].setPaddingLeft(4f);
                        table.getRow(no).getCells()[3].setPaddingLeft(4f);
                        table.getRow(no).getCells()[4].setPaddingLeft(4f);
                        table.getRow(no).getCells()[5].setPaddingLeft(4f);
                    }

                    table.getRow(0).getCells()[0].setHorizontalAlignment(Element.ALIGN_CENTER);
                    table.getRow(0).getCells()[1].setHorizontalAlignment(Element.ALIGN_CENTER);
                    table.getRow(0).getCells()[2].setHorizontalAlignment(Element.ALIGN_CENTER);
                    table.getRow(0).getCells()[3].setHorizontalAlignment(Element.ALIGN_CENTER);
                    table.getRow(0).getCells()[4].setHorizontalAlignment(Element.ALIGN_CENTER);
                    table.getRow(0).getCells()[5].setHorizontalAlignment(Element.ALIGN_CENTER);

                    // Add the table to the document
                    document.add(table);

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
    }//GEN-LAST:event_jButton1KeyPressed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        //        getData();
        //        enableDataEdit();
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton2KeyPressed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButton2KeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private com.toedter.calendar.JYearChooser jYearChooser2;
    // End of variables declaration//GEN-END:variables
}