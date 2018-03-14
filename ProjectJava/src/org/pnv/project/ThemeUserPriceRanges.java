package org.pnv.project;

import java.awt.Image;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.pnv.functions.DatabaseHelper;
import org.pnv.functions.FunctionOfProgram;

public class ThemeUserPriceRanges extends javax.swing.JFrame {

    private Connection connect;
    private ResultSet resultset;
    private PreparedStatement preparedStatement = null;
    public String username_program;
    public String iduser_program;
    private ResultSetMetaData rsmt;


    public void displayTable() throws SQLException {
        preparedStatement = connect.prepareStatement("SELECT * FROM PriceRange");
        resultset = preparedStatement.executeQuery();
        rsmt = resultset.getMetaData();
        DefaultTableModel model = new DefaultTableModel();
        int demcolumn = rsmt.getColumnCount();
        Object[] nameColumn = new Object[demcolumn];
        for (int i = 0; i < demcolumn; i++) {
            nameColumn[i] = rsmt.getColumnClassName(i + 1);
        }
        nameColumn[0] = "Price ID";
        nameColumn[1] = "Start number";
        nameColumn[2] = "End number";
        nameColumn[3] = "Price";
        jtbl_table.setModel(model);
        model.setColumnIdentifiers(nameColumn);
        while (resultset.next() != false) {
            Object[] content = new Object[demcolumn];
            for (int i = 0; i < demcolumn; i++) {
                content[i] = resultset.getString(i + 1);
            }
            model.addRow(content);
        }

    }

    public ThemeUserPriceRanges(String id, String name) throws SQLException {

        connect = DatabaseHelper.getConnection();
        initComponents();
        username_program = name;
        iduser_program = id;
        this.setLocationRelativeTo(null);
        preparedStatement = connect.prepareStatement("SELECT id, cus_name FROM Customer WHERE id_card = ?");
        preparedStatement.setString(1, name);
        resultset = preparedStatement.executeQuery();
        if (resultset.next()) {
            hello_lb.setText("Hi, " + FunctionOfProgram.capsText(resultset.getString(2)));
        }
        displayTable();
        jLabel1.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/org/pnv/image/backgrounds.jpg")).getImage().getScaledInstance(790, 640, Image.SCALE_SMOOTH)));
        avatar_lb.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/org/pnv/image/customer.png")).getImage().getScaledInstance(140, 140, Image.SCALE_SMOOTH)));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbl_table = new javax.swing.JTable();
        jlb_checkstart = new javax.swing.JLabel();
        jtb_checkPrice = new javax.swing.JLabel();
        jlb_checkend = new javax.swing.JLabel();
        avatar_lb = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        hello_lb = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Electricity Management");
        setResizable(false);

        jPanel1.setPreferredSize(new java.awt.Dimension(790, 640));
        jPanel1.setLayout(null);

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setLayout(null);

        jtbl_table.setFont(new java.awt.Font("Century Schoolbook", 0, 12)); // NOI18N
        jtbl_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Price ID", "Start number", "End number", "Price"
            }
        ));
        jtbl_table.setEnabled(false);
        jScrollPane1.setViewportView(jtbl_table);

        jPanel2.add(jScrollPane1);
        jScrollPane1.setBounds(0, 0, 490, 240);

        jlb_checkstart.setFont(new java.awt.Font("Century Schoolbook", 1, 12)); // NOI18N
        jlb_checkstart.setForeground(new java.awt.Color(255, 0, 0));
        jPanel2.add(jlb_checkstart);
        jlb_checkstart.setBounds(160, 60, 180, 20);

        jtb_checkPrice.setFont(new java.awt.Font("Century Schoolbook", 1, 12)); // NOI18N
        jtb_checkPrice.setForeground(new java.awt.Color(255, 0, 0));
        jPanel2.add(jtb_checkPrice);
        jtb_checkPrice.setBounds(160, 160, 180, 20);

        jlb_checkend.setFont(new java.awt.Font("Century Schoolbook", 1, 12)); // NOI18N
        jlb_checkend.setForeground(new java.awt.Color(255, 0, 0));
        jPanel2.add(jlb_checkend);
        jlb_checkend.setBounds(160, 110, 180, 20);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(30, 300, 490, 240);
        jPanel1.add(avatar_lb);
        avatar_lb.setBounds(590, 160, 140, 140);

        jButton4.setFont(new java.awt.Font("Century Schoolbook", 1, 12)); // NOI18N
        jButton4.setText("Go home");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4);
        jButton4.setBounds(570, 410, 180, 60);

        jButton3.setFont(new java.awt.Font("Century Schoolbook", 1, 12)); // NOI18N
        jButton3.setText("Exit");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3);
        jButton3.setBounds(570, 490, 180, 60);

        hello_lb.setFont(new java.awt.Font("Century Schoolbook", 3, 16)); // NOI18N
        hello_lb.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(hello_lb);
        hello_lb.setBounds(590, 120, 160, 30);

        jLabel3.setFont(new java.awt.Font("Century Schoolbook", 3, 48)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("View Price Range");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(50, 130, 450, 59);

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

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int check = JOptionPane.showConfirmDialog(rootPane, "Are you sure", "Exit program", JOptionPane.YES_OPTION);
        if (check == JOptionPane.YES_OPTION) {
            System.exit(0);
        } else {

        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        try {
            ThemeLoginSuccessUser gohome = new ThemeLoginSuccessUser(iduser_program, username_program);
            dispose();
            gohome.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(ThemeUserPriceRanges.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton4ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel avatar_lb;
    private javax.swing.JLabel hello_lb;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jlb_checkend;
    private javax.swing.JLabel jlb_checkstart;
    private javax.swing.JLabel jtb_checkPrice;
    private javax.swing.JTable jtbl_table;
    // End of variables declaration//GEN-END:variables

    private Icon ResizeImage(String path, Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
