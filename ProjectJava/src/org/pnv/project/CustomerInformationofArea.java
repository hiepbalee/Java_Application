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

public class CustomerInformationofArea extends javax.swing.JFrame {

    private Connection connect;
    private ResultSet resultset;
    private ResultSetMetaData rsmt;
    private PreparedStatement preparedStatement = null;
    public String username_program;
    public String iduser_program;
    public String area;
    public String idArea;

    public void displayTable(String id) throws SQLException {
        preparedStatement = connect.prepareStatement(" SELECT "
                + "Area.short_name,"
                + "Area.name_area, "
                + "Customer.cus_name,"
                + "Customer.ID_card,"
                + "Customer.address,"
                + "Customer.phone_number,"
                + "Customer.email_address "
                + "FROM Customer, Area WHERE Customer.Area = ? AND Area.ID  = ? ");
        preparedStatement.setString(1, id);
        preparedStatement.setString(2, id);
        resultset = preparedStatement.executeQuery();
        rsmt = resultset.getMetaData();
        DefaultTableModel model = new DefaultTableModel();
        int demcolumn = rsmt.getColumnCount();
        Object[] nameColumn = new Object[demcolumn];
        for (int i = 0; i < demcolumn; i++) {
            nameColumn[i] = rsmt.getColumnClassName(i + 1);
        }
        nameColumn[0] = "ID Area";
        nameColumn[1] = "Name Area";
        nameColumn[2] = "Full Name";
        nameColumn[3] = "ID Card";
        nameColumn[4] = "Address";
        nameColumn[5] = "Phone";
        nameColumn[6] = "Email";
        jtb_table.setModel(model);
        model.setColumnIdentifiers(nameColumn);
        while (resultset.next() != false) {
            Object[] content = new Object[demcolumn];
            for (int i = 0; i < demcolumn; i++) {
                content[i] = resultset.getString(i + 1);
            }
            model.addRow(content);
        }

    }

    public void showTable() {
        try {
            preparedStatement = connect.prepareStatement(" SELECT Area.short_name,"
                    + "Area.name_area, "
                    + "Customer.cus_name,"
                    + "Customer.ID_card,"
                    + "Customer.address,"
                    + "Customer.phone_number,"
                    + "Customer.email_address FROM Customer,"
                    + "Area WHERE "
                    + "Customer.Area = Area.ID");
            resultset = preparedStatement.executeQuery();
            rsmt = resultset.getMetaData();
            DefaultTableModel model = new DefaultTableModel();
            int demcolumn = rsmt.getColumnCount();
            Object[] nameColumn = new Object[demcolumn];
            for (int i = 0; i < demcolumn; i++) {
                nameColumn[i] = rsmt.getColumnClassName(i + 1);
            }
            nameColumn[0] = "ID Area";
            nameColumn[1] = "Name Area";
            nameColumn[2] = "Full Name";
            nameColumn[3] = "ID Card";
            nameColumn[4] = "Address";
            nameColumn[5] = "Phone";
            nameColumn[6] = "Email";
            jtb_table.setModel(model);
            model.setColumnIdentifiers(nameColumn);
            while (resultset.next() != false) {
                Object[] content = new Object[demcolumn];
                for (int i = 0; i < demcolumn; i++) {
                    content[i] = resultset.getString(i + 1);
                }
                model.addRow(content);
            }

        } catch (SQLException ex) {
            Logger.getLogger(CustomerInformationofArea.class.getName()).log(Level.SEVERE, null, ex);
        }
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

    public CustomerInformationofArea(String id_user, String name_user) throws SQLException {
        connect = DatabaseHelper.getConnection();
        initComponents();
        username_program = name_user;
        iduser_program = id_user;
        CheckRole();
        hello_lb.setText("Hi, " + FunctionOfProgram.capsText(username_program));
        showTable();
        preparedStatement = connect.prepareStatement("SELECT name_area FROM Area");
        resultset = preparedStatement.executeQuery();
        resultset.last();
        resultset.beforeFirst();
        while (resultset.next()) {
            cbb_area.addItem(resultset.getString(1));
        }
        jLabel1.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/org/pnv/image/background3.jpg")).getImage().getScaledInstance(785, 640, Image.SCALE_SMOOTH)));
        this.setLocationRelativeTo(null);

    }

    public static void main(String[] args) throws SQLException {
        CustomerInformationofArea a = new CustomerInformationofArea("1", "s");
        a.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtb_table = new javax.swing.JTable();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        avatar_lb = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cus_name = new javax.swing.JTextField();
        cbb_area = new javax.swing.JComboBox();
        hello_lb = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Electricity Management");
        setPreferredSize(new java.awt.Dimension(790, 640));
        setResizable(false);
        setSize(new java.awt.Dimension(790, 640));
        getContentPane().setLayout(null);

        jLabel9.setFont(new java.awt.Font("Century Schoolbook", 3, 48)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 153));
        jLabel9.setText("Customer of Area");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(240, 90, 430, 60);

        jtb_table.setFont(new java.awt.Font("Century Schoolbook", 1, 12)); // NOI18N
        jtb_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "", "", "", "", "", "", "", "", ""
            }
        ));
        jtb_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtb_tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtb_table);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(20, 290, 740, 290);

        jButton7.setFont(new java.awt.Font("Century Schoolbook", 1, 14)); // NOI18N
        jButton7.setText("Print File PDF");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton7);
        jButton7.setBounds(220, 190, 150, 40);

        jButton8.setFont(new java.awt.Font("Century Schoolbook", 1, 14)); // NOI18N
        jButton8.setText("Go Home");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton8);
        jButton8.setBounds(220, 240, 150, 40);
        getContentPane().add(avatar_lb);
        avatar_lb.setBounds(40, 110, 170, 170);

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel6.setText("Customer Name");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(410, 240, 130, 40);

        cus_name.setFont(new java.awt.Font("Century Schoolbook", 0, 13)); // NOI18N
        cus_name.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cus_nameKeyReleased(evt);
            }
        });
        getContentPane().add(cus_name);
        cus_name.setBounds(550, 240, 180, 40);

        cbb_area.setFont(new java.awt.Font("Century Schoolbook", 1, 14)); // NOI18N
        cbb_area.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "All Areas" }));
        cbb_area.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbb_areaItemStateChanged(evt);
            }
        });
        getContentPane().add(cbb_area);
        cbb_area.setBounds(550, 190, 180, 40);

        hello_lb.setFont(new java.awt.Font("Century Schoolbook", 3, 18)); // NOI18N
        getContentPane().add(hello_lb);
        hello_lb.setBounds(220, 150, 190, 30);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel2.setText("Name Area:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(410, 190, 130, 40);

        jLabel1.setFont(new java.awt.Font("Century Schoolbook", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/pnv/image/background3.jpg"))); // NOI18N
        jLabel1.setPreferredSize(new java.awt.Dimension(790, 640));
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 790, 640);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtb_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtb_tableMouseClicked


    }//GEN-LAST:event_jtb_tableMouseClicked

    private void cbb_areaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbb_areaItemStateChanged
        try {
            area = (String) cbb_area.getSelectedItem();
            if (area.equals("All Areas")) {
                showTable();

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

    private void cus_nameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cus_nameKeyReleased
        try {
            if (cbb_area.getSelectedItem().equals("All")) {
                preparedStatement = connect.prepareStatement(" SELECT Area.short_name,"
                        + "Area.name_area, "
                        + "Customer.cus_name,"
                        + "Customer.ID_card,"
                        + "Customer.address,"
                        + "Customer.phone_number,"
                        + "Customer.email_address FROM Customer,"
                        + "Area WHERE Customer.cus_name LIKE ? "
                        + "AND Customer.Area = Area.ID");
                preparedStatement.setString(1, "%" + cus_name.getText() + "%");
                resultset = preparedStatement.executeQuery();
                rsmt = resultset.getMetaData();

            } else {
                preparedStatement = connect.prepareStatement(" SELECT Area.short_name,"
                        + "Area.name_area, "
                        + "Customer.cus_name,"
                        + "Customer.ID_card,"
                        + "Customer.address,"
                        + "Customer.phone_number,"
                        + "Customer.email_address FROM Customer,"
                        + "Area WHERE Customer.cus_name LIKE ? "
                        + "AND Customer.Area = ? AND Area.ID = ?");
                preparedStatement.setString(1, "%" + cus_name.getText() + "%");
                preparedStatement.setString(2, area);
                preparedStatement.setString(3, area);
                resultset = preparedStatement.executeQuery();
                rsmt = resultset.getMetaData();

            }
            DefaultTableModel model = new DefaultTableModel();
            int demcolumn = rsmt.getColumnCount();
            Object[] nameColumn = new Object[demcolumn];
            for (int i = 0; i < demcolumn; i++) {
                nameColumn[i] = rsmt.getColumnClassName(i + 1);
            }
            nameColumn[0] = "ID Area";
            nameColumn[1] = "Name Area";
            nameColumn[2] = "Full Name";
            nameColumn[3] = "ID Card";
            nameColumn[4] = "Address";
            nameColumn[5] = "Phone";
            nameColumn[6] = "Email";
            jtb_table.setModel(model);
            model.setColumnIdentifiers(nameColumn);
            while (resultset.next() != false) {
                Object[] content = new Object[demcolumn];
                for (int i = 0; i < demcolumn; i++) {
                    content[i] = resultset.getString(i + 1);
                }
                model.addRow(content);
            }

        } catch (SQLException ex) {
            Logger.getLogger(CustomerInformationofArea.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cus_nameKeyReleased

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        String path = FunctionOfProgram.PrintFilePDF(jtb_table, "The List Customer Information");
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
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        try {
            ThemeLoginSuccessAdmin adminTheme = new ThemeLoginSuccessAdmin(iduser_program, username_program);
            adminTheme.setVisible(true);
            dispose();
        } catch (SQLException ex) {
            Logger.getLogger(CustomerInformationofArea.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton8ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel avatar_lb;
    private javax.swing.JComboBox cbb_area;
    private javax.swing.JTextField cus_name;
    private javax.swing.JLabel hello_lb;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtb_table;
    // End of variables declaration//GEN-END:variables
}
