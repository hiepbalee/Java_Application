package org.pnv.project;

import java.awt.Image;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import javax.swing.JOptionPane;
import org.pnv.functions.DatabaseHelper;
import org.pnv.functions.CapsLock;
import org.pnv.functions.History;

public class ThemeLoginSuccessUser extends javax.swing.JFrame {

    private Connection connect;
    private ResultSet resultset;
    private PreparedStatement preparedStatement = null;
    private String username_cus = null;
    private String id_cus = null;

    public ThemeLoginSuccessUser(String id_user, String user_name) throws SQLException {
        connect = DatabaseHelper.getConnection();
        initComponents();
        id_cus = id_user;
        username_cus = user_name;
        this.setLocationRelativeTo(null);
        preparedStatement = connect.prepareCall("SELECT cus_name FROM Customer WHERE id_card = ?");
        preparedStatement.setString(1, user_name);
        resultset = preparedStatement.executeQuery();
        if (resultset.next()) {
            hello_lb.setText("Hi, " + CapsLock.capstext(resultset.getString(1)));
        }
        jLabel1.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/org/pnv/image/backgrounds.jpg")).getImage().getScaledInstance(790, 640, Image.SCALE_SMOOTH)));
        avatar_lb.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/org/pnv/image/customer.png")).getImage().getScaledInstance(140, 140, Image.SCALE_SMOOTH)));
        jLabel5.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/org/pnv/image/roo5.png")).getImage().getScaledInstance(490, 270, Image.SCALE_SMOOTH)));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        avatar_lb = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        viewbill_bt = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        cbb_month = new javax.swing.JComboBox<String>();
        hello_lb = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Electricity Management");
        setResizable(false);

        jPanel1.setPreferredSize(new java.awt.Dimension(790, 640));
        jPanel1.setLayout(null);
        jPanel1.add(avatar_lb);
        avatar_lb.setBounds(590, 160, 140, 140);

        jButton7.setFont(new java.awt.Font("Century Schoolbook", 1, 14)); // NOI18N
        jButton7.setText("View Profile");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton7);
        jButton7.setBounds(70, 310, 200, 50);

        jButton6.setFont(new java.awt.Font("Century Schoolbook", 1, 12)); // NOI18N
        jButton6.setText("Change Password");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton6);
        jButton6.setBounds(570, 340, 180, 60);

        jButton5.setFont(new java.awt.Font("Century Schoolbook", 1, 14)); // NOI18N
        jButton5.setText("Payment");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5);
        jButton5.setBounds(70, 470, 200, 50);

        jButton4.setFont(new java.awt.Font("Century Schoolbook", 1, 12)); // NOI18N
        jButton4.setText("Sign Out");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4);
        jButton4.setBounds(570, 420, 180, 60);

        viewbill_bt.setFont(new java.awt.Font("Century Schoolbook", 1, 14)); // NOI18N
        viewbill_bt.setText("View Bill");
        viewbill_bt.setEnabled(false);
        viewbill_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewbill_btActionPerformed(evt);
            }
        });
        jPanel1.add(viewbill_bt);
        viewbill_bt.setBounds(300, 470, 200, 50);

        jButton3.setFont(new java.awt.Font("Century Schoolbook", 1, 12)); // NOI18N
        jButton3.setText("Exit");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3);
        jButton3.setBounds(570, 500, 180, 60);

        jButton8.setFont(new java.awt.Font("Century Schoolbook", 1, 14)); // NOI18N
        jButton8.setText("Calcutale Bill ( Demo )");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton8);
        jButton8.setBounds(300, 310, 200, 50);

        jButton9.setFont(new java.awt.Font("Century Schoolbook", 1, 14)); // NOI18N
        jButton9.setText("View Price Ranges");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton9);
        jButton9.setBounds(70, 390, 200, 50);

        cbb_month.setFont(new java.awt.Font("Century Schoolbook", 1, 14)); // NOI18N
        cbb_month.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "January", "Frebuary", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" }));
        cbb_month.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbb_monthMouseClicked(evt);
            }
        });
        jPanel1.add(cbb_month);
        cbb_month.setBounds(300, 390, 200, 50);

        hello_lb.setFont(new java.awt.Font("Century Schoolbook", 3, 16)); // NOI18N
        hello_lb.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(hello_lb);
        hello_lb.setBounds(590, 120, 160, 30);
        jPanel1.add(jLabel5);
        jLabel5.setBounds(30, 280, 490, 270);

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

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        ThemeLogin login = new ThemeLogin();
        dispose();
        login.setVisible(true);

    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int check = JOptionPane.showConfirmDialog(rootPane, "Are you sure", "Exit program", JOptionPane.YES_OPTION);
        if (check == JOptionPane.YES_OPTION) {
            System.exit(0);
        } else {

        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        try {
            InformationDetail themeDetail = new InformationDetail(id_cus, username_cus);
            themeDetail.setVisible(true);
            dispose();
        } catch (SQLException ex) {
            Logger.getLogger(ThemeLoginSuccessUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        try {
            ChangePasswordofUser themeDetail = new ChangePasswordofUser(id_cus, username_cus);
            themeDetail.setVisible(true);
            dispose();
        } catch (SQLException ex) {
            Logger.getLogger(ThemeLoginSuccessUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void viewbill_btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewbill_btActionPerformed
        try {
            String id = null;
            preparedStatement = connect.prepareStatement("SELECT ID FROM Customer WHERE Id_card = ? ");
            preparedStatement.setString(1, username_cus);
            resultset = preparedStatement.executeQuery();
            if (resultset.next()) {
                id = resultset.getString(1);
                PrintBill bill = new PrintBill(id, String.valueOf(cbb_month.getSelectedIndex() + 1), id_cus, username_cus);
                bill.setVisible(true);
                dispose();
            }

        } catch (SQLException ex) {
            Logger.getLogger(CalculaterBill.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_viewbill_btActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        try {
            CustomerCalculater a = new CustomerCalculater(id_cus, username_cus);
            a.setVisible(true);
            dispose();
        } catch (SQLException ex) {
            Logger.getLogger(ThemeLoginSuccessUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        try {
            ThemeUserPriceRanges a = new ThemeUserPriceRanges(id_cus, username_cus);
            a.setVisible(true);
            dispose();
        } catch (SQLException ex) {
            Logger.getLogger(ThemeLoginSuccessUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        try {

            PaymentForCustomer showTheme = new PaymentForCustomer(id_cus, username_cus);
            showTheme.setVisible(true);
            dispose();

        } catch (SQLException ex) {
            Logger.getLogger(ThemeLoginSuccessUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void cbb_monthMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbb_monthMouseClicked
        viewbill_bt.setEnabled(true);
    }//GEN-LAST:event_cbb_monthMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel avatar_lb;
    private javax.swing.JComboBox<String> cbb_month;
    private javax.swing.JLabel hello_lb;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton viewbill_bt;
    // End of variables declaration//GEN-END:variables

    private Icon ResizeImage(String path, Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
