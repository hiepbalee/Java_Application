package org.pnv.project;

import java.awt.Image;
import java.awt.event.KeyEvent;
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

public final class PriceRanges extends javax.swing.JFrame {

    private Connection connect;
    private ResultSet resultset;
    private ResultSetMetaData rsmt;
    private PreparedStatement preparedStatement = null;
    public String username_program;
    public String iduser_program;
    private String iduser_table;

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

    public PriceRanges(String id_user, String name_user) throws SQLException {
        connect = DatabaseHelper.getConnection();
        initComponents();
        username_program = name_user;
        iduser_program = id_user;
        hello_lb.setText("Hi, " + FunctionOfProgram.capsText(username_program));
        jLabel1.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/org/pnv/image/backgrounds.jpg")).getImage().getScaledInstance(790, 640, Image.SCALE_SMOOTH)));
        avatar_lb.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/org/pnv/image/admin.png")).getImage().getScaledInstance(140, 140, Image.SCALE_SMOOTH)));
        this.setLocationRelativeTo(null);
        displayTable();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        hello_lb = new javax.swing.JLabel();
        avatar_lb = new javax.swing.JLabel();
        home_bt = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jbt_update = new javax.swing.JButton();
        jbt_delete = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbl_table = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jlb_checkstart = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jtb_checkPrice = new javax.swing.JLabel();
        jbt_add = new javax.swing.JButton();
        jtf_endNumber = new javax.swing.JTextField();
        jtf_startnumber = new javax.swing.JTextField();
        jtf_Price = new javax.swing.JTextField();
        jlb_checkend = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Electricity Management");
        setResizable(false);

        jPanel1.setPreferredSize(new java.awt.Dimension(790, 640));
        jPanel1.setLayout(null);

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 153));
        jLabel9.setText("Price Range");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(140, 150, 186, 42);

        hello_lb.setFont(new java.awt.Font("Century Schoolbook", 3, 16)); // NOI18N
        hello_lb.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(hello_lb);
        hello_lb.setBounds(590, 120, 160, 30);
        jPanel1.add(avatar_lb);
        avatar_lb.setBounds(590, 160, 140, 140);

        home_bt.setFont(new java.awt.Font("Century Schoolbook", 1, 12)); // NOI18N
        home_bt.setText("Go Home");
        home_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                home_btActionPerformed(evt);
            }
        });
        jPanel1.add(home_bt);
        home_bt.setBounds(570, 460, 180, 50);

        jButton3.setFont(new java.awt.Font("Century Schoolbook", 1, 12)); // NOI18N
        jButton3.setText("Exit");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3);
        jButton3.setBounds(570, 510, 180, 50);

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setLayout(null);

        jbt_update.setFont(new java.awt.Font("Century Schoolbook", 1, 14)); // NOI18N
        jbt_update.setForeground(new java.awt.Color(0, 0, 255));
        jbt_update.setText("Update");
        jbt_update.setEnabled(false);
        jbt_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbt_updateActionPerformed(evt);
            }
        });
        jPanel2.add(jbt_update);
        jbt_update.setBounds(370, 80, 100, 40);

        jbt_delete.setFont(new java.awt.Font("Century Schoolbook", 1, 14)); // NOI18N
        jbt_delete.setForeground(new java.awt.Color(0, 0, 255));
        jbt_delete.setText("Delete");
        jbt_delete.setEnabled(false);
        jbt_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbt_deleteActionPerformed(evt);
            }
        });
        jPanel2.add(jbt_delete);
        jbt_delete.setBounds(370, 130, 100, 40);

        jtbl_table.setFont(new java.awt.Font("Century Schoolbook", 1, 12)); // NOI18N
        jtbl_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Price ID", "Start number", "End number", "Price"
            }
        ));
        jtbl_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbl_tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtbl_table);

        jPanel2.add(jScrollPane1);
        jScrollPane1.setBounds(0, 190, 490, 100);

        jLabel7.setFont(new java.awt.Font("Century Schoolbook", 1, 14)); // NOI18N
        jLabel7.setText("Price:");
        jPanel2.add(jLabel7);
        jLabel7.setBounds(30, 120, 110, 40);

        jlb_checkstart.setFont(new java.awt.Font("Century Schoolbook", 1, 12)); // NOI18N
        jlb_checkstart.setForeground(new java.awt.Color(255, 0, 0));
        jPanel2.add(jlb_checkstart);
        jlb_checkstart.setBounds(160, 60, 180, 20);

        jLabel8.setFont(new java.awt.Font("Century Schoolbook", 1, 14)); // NOI18N
        jLabel8.setText("End number:");
        jPanel2.add(jLabel8);
        jLabel8.setBounds(30, 70, 110, 40);

        jLabel3.setFont(new java.awt.Font("Century Schoolbook", 1, 14)); // NOI18N
        jLabel3.setText("Start number:");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(30, 20, 110, 40);

        jtb_checkPrice.setFont(new java.awt.Font("Century Schoolbook", 1, 12)); // NOI18N
        jtb_checkPrice.setForeground(new java.awt.Color(255, 0, 0));
        jPanel2.add(jtb_checkPrice);
        jtb_checkPrice.setBounds(160, 160, 180, 20);

        jbt_add.setFont(new java.awt.Font("Century Schoolbook", 1, 14)); // NOI18N
        jbt_add.setForeground(new java.awt.Color(0, 0, 255));
        jbt_add.setText("Add");
        jbt_add.setEnabled(false);
        jbt_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbt_addActionPerformed(evt);
            }
        });
        jPanel2.add(jbt_add);
        jbt_add.setBounds(370, 30, 100, 40);

        jtf_endNumber.setFont(new java.awt.Font("Century Schoolbook", 0, 12)); // NOI18N
        jtf_endNumber.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtf_endNumberKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtf_endNumberKeyTyped(evt);
            }
        });
        jPanel2.add(jtf_endNumber);
        jtf_endNumber.setBounds(160, 80, 180, 30);

        jtf_startnumber.setFont(new java.awt.Font("Century Schoolbook", 0, 12)); // NOI18N
        jtf_startnumber.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtf_startnumberKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtf_startnumberKeyTyped(evt);
            }
        });
        jPanel2.add(jtf_startnumber);
        jtf_startnumber.setBounds(160, 30, 180, 30);

        jtf_Price.setFont(new java.awt.Font("Century Schoolbook", 0, 12)); // NOI18N
        jtf_Price.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtf_PriceKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtf_PriceKeyTyped(evt);
            }
        });
        jPanel2.add(jtf_Price);
        jtf_Price.setBounds(160, 130, 180, 30);

        jlb_checkend.setFont(new java.awt.Font("Century Schoolbook", 1, 12)); // NOI18N
        jlb_checkend.setForeground(new java.awt.Color(255, 0, 0));
        jPanel2.add(jlb_checkend);
        jlb_checkend.setBounds(160, 110, 180, 20);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(30, 270, 490, 290);

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

    private void home_btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_home_btActionPerformed
        try {
            ThemeLoginSuccessAdmin login = new ThemeLoginSuccessAdmin(iduser_program, username_program);
            dispose();
            login.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(PriceRanges.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_home_btActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int check = JOptionPane.showConfirmDialog(rootPane, "Are you sure", "Exit program", JOptionPane.YES_OPTION);
        if (check == JOptionPane.YES_OPTION) {
            System.exit(0);
        } else {

        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jbt_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbt_updateActionPerformed
        // TODO add your handling code here:
        try {

            preparedStatement = connect.prepareStatement("UPDATE PriceRange SET start_number= ?,  end_number = ?, price= ? WHERE ID = ?");
            preparedStatement.setString(4, iduser_table);
            preparedStatement.setString(1, jtf_startnumber.getText());
            preparedStatement.setString(2, jtf_endNumber.getText());
            preparedStatement.setString(3, jtf_Price.getText());
            preparedStatement.executeUpdate();
            displayTable();
            JOptionPane.showMessageDialog(rootPane, "Updated success !!");
            jtf_startnumber.setText(null);
            jtf_endNumber.setText(null);
            jtf_Price.setText(null);
            jtf_startnumber.setEnabled(true);
            jtf_endNumber.setEnabled(true);
            jtf_Price.setEnabled(true);
            jbt_add.setEnabled(false);
            jbt_update.setEnabled(false);
            jbt_delete.setEnabled(false);

        } catch (SQLException ex) {
            Logger.getLogger(ThemeUsers.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jbt_updateActionPerformed

    private void jbt_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbt_deleteActionPerformed
        // TODO add your handling code here:
        try {
            preparedStatement = connect.prepareStatement("DELETE FROM PriceRange  WHERE ID = ?");
            preparedStatement.setString(1, iduser_table);
            preparedStatement.executeUpdate();
            displayTable();
            JOptionPane.showMessageDialog(rootPane, "Deleted success !!");
            jtf_startnumber.setText(null);
            jtf_endNumber.setText(null);
            jtf_Price.setText(null);
            jtf_startnumber.setEnabled(true);
            jtf_endNumber.setEnabled(true);
            jtf_Price.setEnabled(true);
            jbt_add.setEnabled(false);
            jbt_update.setEnabled(false);
            jbt_delete.setEnabled(false);

        } catch (SQLException ex) {
            Logger.getLogger(ThemeUsers.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jbt_deleteActionPerformed

    private void jtbl_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbl_tableMouseClicked

        int b = jtbl_table.getSelectedRow();

        iduser_table = (String) jtbl_table.getValueAt(b, 0);
        String start = (String) jtbl_table.getValueAt(b, 1);
        String end = (String) jtbl_table.getValueAt(b, 2);
        String price = (String) jtbl_table.getValueAt(b, 3);
        jbt_add.setEnabled(false);
        jbt_update.setEnabled(true);
        jlb_checkend.setText(null);
        jlb_checkstart.setText(null);
        jtf_startnumber.setText(start);
        jtf_endNumber.setText(end);
        jtf_Price.setText(price);
        if (b + 1 == jtbl_table.getRowCount()) {
            jbt_delete.setEnabled(true);
            jtf_startnumber.setEnabled(true);
            jtf_endNumber.setEnabled(true);
            jtf_Price.setEnabled(true);
        } else {
            jtf_startnumber.setEnabled(false);
            jtf_endNumber.setEnabled(false);
            jbt_delete.setEnabled(false);
        }

    }//GEN-LAST:event_jtbl_tableMouseClicked

    private void jbt_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbt_addActionPerformed

        try {
            preparedStatement = connect.prepareStatement("INSERT INTO PriceRange (start_number, end_number, price)" + " VALUES (  ?, ? ,?)");
            preparedStatement.setString(1, jtf_startnumber.getText());
            preparedStatement.setString(2, jtf_endNumber.getText());
            preparedStatement.setString(3, jtf_Price.getText());
            preparedStatement.executeUpdate();
            displayTable();
            JOptionPane.showMessageDialog(rootPane, "Add success !!");
            jtf_startnumber.setText(null);
            jtf_endNumber.setText(null);
            jtf_Price.setText(null);
            jtf_startnumber.setEnabled(true);
            jtf_endNumber.setEnabled(true);
            jtf_Price.setEnabled(true);
            jbt_add.setEnabled(false);
            jbt_update.setEnabled(false);
            jbt_delete.setEnabled(false);
        } catch (SQLException ex) {
            Logger.getLogger(PriceRanges.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jbt_addActionPerformed

    private void jtf_endNumberKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_endNumberKeyReleased
        try {
            int start = Integer.parseInt(jtf_startnumber.getText());
            int end = Integer.parseInt(jtf_endNumber.getText());

            if (end < start) {
                jtf_startnumber.setEnabled(false);
                jtf_Price.setEnabled(false);
                jlb_checkend.setText("Not valid: end > start");

            } else {
                jlb_checkend.setText(null);
                jtf_Price.setEnabled(true);
                jtf_endNumber.setEnabled(true);
                jtf_startnumber.setEnabled(true);
            }
        } catch (Exception ex) {
            jtf_endNumber.setText(null);
        }
    }//GEN-LAST:event_jtf_endNumberKeyReleased

    private void jtf_startnumberKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_startnumberKeyReleased

        try {
            int start = Integer.parseInt(jtf_startnumber.getText());
            try {

                preparedStatement = connect.prepareStatement("SELECT end_number FROM PriceRange");
                resultset = preparedStatement.executeQuery("SELECT end_number FROM PriceRange ");
                while (resultset.next()) {
                    int ended = resultset.getInt("end_number");
                    if (ended >= start) {
                        jtf_endNumber.setEnabled(false);
                        jtf_Price.setEnabled(false);
                        jlb_checkstart.setText(" Number already exists");

                    } else if ((ended + 1) != start) {
                        jlb_checkstart.setText("Please enter the next number of the last number");
                        jtf_endNumber.setEnabled(false);
                        jtf_Price.setEnabled(false);
                    } else {
                        jlb_checkstart.setText(null);
                        jtf_Price.setEnabled(true);
                        jtf_endNumber.setEnabled(true);
                        jtf_startnumber.setEnabled(true);
                    }

                }

            } catch (SQLException ex) {
                Logger.getLogger(Areas.class.getName()).log(Level.SEVERE, null, ex);

            }
        } catch (Exception ex) {
            jtf_startnumber.setText(null);
        }
    }//GEN-LAST:event_jtf_startnumberKeyReleased

    private void jtf_PriceKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_PriceKeyReleased
        if (jtf_startnumber.getText().equals("") && (jtf_endNumber.getText().equals(""))) {
            jbt_add.setEnabled(false);
        } else {
            jbt_add.setEnabled(true);
        }

    }//GEN-LAST:event_jtf_PriceKeyReleased

    private void jtf_startnumberKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_startnumberKeyTyped
        char c = evt.getKeyChar();
        if (!Character.isDigit(c) || (c == KeyEvent.VK_SPACE) || (c == KeyEvent.VK_DELETE)) {
            evt.consume();
        }
    }//GEN-LAST:event_jtf_startnumberKeyTyped

    private void jtf_endNumberKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_endNumberKeyTyped
        char c = evt.getKeyChar();
        if (!Character.isDigit(c) || (c == KeyEvent.VK_SPACE) || (c == KeyEvent.VK_DELETE)) {
            evt.consume();
        }
    }//GEN-LAST:event_jtf_endNumberKeyTyped

    private void jtf_PriceKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_PriceKeyTyped
        char c = evt.getKeyChar();
        if (!Character.isDigit(c) || (c == KeyEvent.VK_SPACE) || (c == KeyEvent.VK_DELETE)) {
            evt.consume();
        }
    }//GEN-LAST:event_jtf_PriceKeyTyped

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel avatar_lb;
    private javax.swing.JLabel hello_lb;
    private javax.swing.JButton home_bt;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbt_add;
    private javax.swing.JButton jbt_delete;
    private javax.swing.JButton jbt_update;
    private javax.swing.JLabel jlb_checkend;
    private javax.swing.JLabel jlb_checkstart;
    private javax.swing.JLabel jtb_checkPrice;
    private javax.swing.JTable jtbl_table;
    private javax.swing.JTextField jtf_Price;
    private javax.swing.JTextField jtf_endNumber;
    private javax.swing.JTextField jtf_startnumber;
    // End of variables declaration//GEN-END:variables
}
