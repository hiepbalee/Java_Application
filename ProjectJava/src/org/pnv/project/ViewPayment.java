package org.pnv.project;

import java.awt.Desktop;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.pnv.functions.DatabaseHelper;
import org.pnv.functions.FunctionOfProgram;

public class ViewPayment extends javax.swing.JFrame {

    private Connection connect;
    private ResultSet resultset;
    private ResultSetMetaData rsmt;
    private PreparedStatement preparedStatement = null;
    public String username_program;
    public String iduser_program;
    public String area;
    public String id;
    public String shorts;
    public String name;

    private void displayTable(String area) throws SQLException {
        preparedStatement = connect.prepareStatement("SELECT Area.short_name,"
                + "Area.name_area, "
                + "COUNT( Indexs.id ) AS TotalCustomer, "
                + "COUNT(CASE WHEN Indexs.payment = 'submit' THEN 1 END) AS TotalSubmit, "
                + "COUNT(CASE WHEN Indexs.payment = 'unsubmit' THEN 1 END) AS TotalUnSubmit FROM indexs "
                + "JOIN customer "
                + "ON Indexs.cus_ID = Customer.ID "
                + "JOIN area "
                + "ON Area.ID = ? AND Customer.area = ?"
                + "GROUP BY Customer.area");
        preparedStatement.setString(1, area);
        preparedStatement.setString(2, area);
        resultset = preparedStatement.executeQuery();
        rsmt = resultset.getMetaData();
        DefaultTableModel model = new DefaultTableModel();
        int demcolumn = rsmt.getColumnCount();
        Object[] nameColumn = new Object[demcolumn];
        for (int i = 0; i < demcolumn; i++) {
            nameColumn[i] = rsmt.getColumnClassName(i + 1);
        }
        nameColumn[0] = "Short Name";
        nameColumn[1] = "Name Area";
        nameColumn[2] = "Total";
        nameColumn[3] = "Submit";
        nameColumn[4] = "Unsubmit";

        table_area.setModel(model);
        model.setColumnIdentifiers(nameColumn);
        while (resultset.next() != false) {
            Object[] content = new Object[demcolumn];
            for (int i = 0; i < demcolumn; i++) {
                content[i] = resultset.getString(i + 1);
            }
            model.addRow(content);
        }

    }

    public void displayTable() throws SQLException {
        preparedStatement = connect.prepareStatement("SELECT Area.short_name,"
                + "Area.name_area, "
                + "COUNT( Indexs.id ) AS TotalCustomer, "
                + "COUNT(CASE WHEN Indexs.payment = 'submit' THEN 1 END) AS TotalSubmit, "
                + "COUNT(CASE WHEN Indexs.payment = 'unsubmit' THEN 1 END) AS TotalUnSubmit FROM indexs "
                + "JOIN customer "
                + "ON Indexs.cus_ID = Customer.ID "
                + "JOIN area "
                + "ON Area.ID = Customer.area "
                + "GROUP BY Customer.area");

        resultset = preparedStatement.executeQuery();
        rsmt = resultset.getMetaData();
        DefaultTableModel model = new DefaultTableModel();
        int demcolumn = rsmt.getColumnCount();
        Object[] nameColumn = new Object[demcolumn];
        for (int i = 0; i < demcolumn; i++) {
            nameColumn[i] = rsmt.getColumnClassName(i + 1);
        }
        nameColumn[0] = "Short Name";
        nameColumn[1] = "Name Area";
        nameColumn[2] = "Total";
        nameColumn[3] = "Submit";
        nameColumn[4] = "Unsubmit";

        table_area.setModel(model);
        model.setColumnIdentifiers(nameColumn);
        while (resultset.next() != false) {
            Object[] content = new Object[demcolumn];
            for (int i = 0; i < demcolumn; i++) {
                content[i] = resultset.getString(i + 1);
            }
            model.addRow(content);
        }

    }

    public void showIteamArea() throws SQLException {
        preparedStatement = connect.prepareStatement("SELECT name_area FROM Area");
        resultset = preparedStatement.executeQuery();
        resultset.last();
        resultset.beforeFirst();
        while (resultset.next()) {
            cbb_area.addItem(resultset.getString(1));
        }
    }

    public ViewPayment(String id_user, String name_user) throws SQLException {
        connect = DatabaseHelper.getConnection();
        initComponents();
        username_program = name_user;
        iduser_program = id_user;
        hello_lb.setText("Hi, " + FunctionOfProgram.capsText(username_program));
        showIteamArea();
        displayTable();
        this.setLocationRelativeTo(null);
        CheckRole();
        jLabel1.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/org/pnv/image/backgrounds.jpg")).getImage().getScaledInstance(790, 640, Image.SCALE_SMOOTH)));

    }

    public void CheckRole() throws SQLException {
        preparedStatement = connect.prepareStatement("SELECT role FROM Users WHERE ID = ? LIMIT 1");
        preparedStatement.setString(1, iduser_program);
        resultset = preparedStatement.executeQuery();
        while (resultset.next()) {
            if (resultset.getString(1).equals("Administrator")) {
                avatar_lb.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/org/pnv/image/admin.png")).getImage().getScaledInstance(140, 140, Image.SCALE_SMOOTH)));
            } else {
                avatar_lb.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/org/pnv/image/admin2.png")).getImage().getScaledInstance(140, 140, Image.SCALE_SMOOTH)));
            }
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jbt_goHome = new javax.swing.JButton();
        hello_lb = new javax.swing.JLabel();
        avatar_lb = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        cbb_area = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_area = new javax.swing.JTable();
        jButton6 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Electricity Management");
        setResizable(false);

        jPanel1.setPreferredSize(new java.awt.Dimension(790, 640));
        jPanel1.setLayout(null);

        jLabel3.setFont(new java.awt.Font("Century Schoolbook", 3, 48)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Statistical ");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(70, 150, 290, 59);

        jbt_goHome.setFont(new java.awt.Font("Century Schoolbook", 1, 12)); // NOI18N
        jbt_goHome.setText("Go Home");
        jbt_goHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbt_goHomeActionPerformed(evt);
            }
        });
        jPanel1.add(jbt_goHome);
        jbt_goHome.setBounds(570, 460, 180, 50);

        hello_lb.setFont(new java.awt.Font("Century Schoolbook", 3, 16)); // NOI18N
        hello_lb.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(hello_lb);
        hello_lb.setBounds(590, 120, 160, 30);
        jPanel1.add(avatar_lb);
        avatar_lb.setBounds(590, 160, 140, 140);

        jButton2.setFont(new java.awt.Font("Century Schoolbook", 1, 12)); // NOI18N
        jButton2.setText("Printf File PDF");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(570, 310, 180, 50);

        jButton3.setFont(new java.awt.Font("Century Schoolbook", 1, 12)); // NOI18N
        jButton3.setText("Exit");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3);
        jButton3.setBounds(570, 510, 180, 50);

        jPanel2.setLayout(null);

        cbb_area.setFont(new java.awt.Font("Century Schoolbook", 1, 14)); // NOI18N
        cbb_area.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "All Areas" }));
        cbb_area.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbb_areaItemStateChanged(evt);
            }
        });
        jPanel2.add(cbb_area);
        cbb_area.setBounds(230, 20, 230, 40);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel2.setText("Name Area:");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(60, 20, 140, 40);

        table_area.setFont(new java.awt.Font("Century Schoolbook", 1, 12)); // NOI18N
        table_area.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5"
            }
        ));
        jScrollPane1.setViewportView(table_area);

        jPanel2.add(jScrollPane1);
        jScrollPane1.setBounds(0, 100, 490, 170);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(30, 290, 490, 270);

        jButton6.setFont(new java.awt.Font("Century Schoolbook", 1, 12)); // NOI18N
        jButton6.setText("Customer Paymented");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton6);
        jButton6.setBounds(570, 360, 180, 50);

        jButton5.setFont(new java.awt.Font("Century Schoolbook", 1, 12)); // NOI18N
        jButton5.setText("Customer Unpayment");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5);
        jButton5.setBounds(570, 410, 180, 50);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/pnv/image/backgrounds.jpg"))); // NOI18N
        jLabel1.setPreferredSize(new java.awt.Dimension(790, 640));
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 790, 640);

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

    private void jbt_goHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbt_goHomeActionPerformed
        try {
            ThemeLoginSuccessAdmin showTheme = new ThemeLoginSuccessAdmin(iduser_program, username_program);
            showTheme.setVisible(true);
            dispose();
        } catch (SQLException ex) {
            Logger.getLogger(ViewPayment.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jbt_goHomeActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int check = JOptionPane.showConfirmDialog(rootPane, "Are you sure", "Exit program", JOptionPane.YES_OPTION);
        if (check == JOptionPane.YES_OPTION) {
            System.exit(0);
        } else {

        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void cbb_areaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbb_areaItemStateChanged
        try {
            area = (String) cbb_area.getSelectedItem();
            if (area.equals("All Areas")) {
                displayTable();

            } else {
                preparedStatement = connect.prepareStatement("SELECT ID FROM Area WHERE name_area = ?");
                preparedStatement.setString(1, area);
                resultset = preparedStatement.executeQuery();
                while (resultset.next()) {
                    area = null;
                    area = resultset.getString(1);
                    displayTable(area);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerInformationofArea.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cbb_areaItemStateChanged

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String path = FunctionOfProgram.PrintFilePDF(table_area, "List Customer Payment Bill");
        int check = JOptionPane.showConfirmDialog(rootPane, "Do you want open this file !", "Open File PDF", JOptionPane.YES_NO_OPTION);
        if (check == JOptionPane.YES_OPTION) {
            try {
                Desktop desktop = null;
                File file2 = new File(path + ".pdf");

                if (Desktop.isDesktopSupported()) {
                    desktop = Desktop.getDesktop();
                }
                if (file2.exists()) {
                    desktop.open(new File("" + file2));
                } else {
                    JOptionPane.showMessageDialog(rootPane, "File doesn't exist !\n Please print ", "Error", EXIT_ON_CLOSE);
                }
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }

        } else {

        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        try {
            CustomerPaymentDetail showTheme = new CustomerPaymentDetail(iduser_program, username_program, "submit");
            showTheme.setVisible(true);
            dispose();
        } catch (SQLException ex) {
            Logger.getLogger(PaymentOfCustomer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        try {
            CustomerPaymentDetail showTheme = new CustomerPaymentDetail(iduser_program, username_program, "Unsubmit");
            showTheme.setVisible(true);
            dispose();
        } catch (SQLException ex) {
            Logger.getLogger(PaymentOfCustomer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton5ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel avatar_lb;
    private javax.swing.JComboBox cbb_area;
    private javax.swing.JLabel hello_lb;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbt_goHome;
    private javax.swing.JTable table_area;
    // End of variables declaration//GEN-END:variables

}
