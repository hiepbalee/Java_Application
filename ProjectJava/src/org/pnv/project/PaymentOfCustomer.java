package org.pnv.project;

import java.awt.Image;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import org.pnv.functions.DatabaseHelper;
import org.pnv.functions.FunctionOfProgram;

public class PaymentOfCustomer extends javax.swing.JFrame {

    private Connection connect;
    private ResultSet resultset;
    private PreparedStatement preparedStatement = null;
    public String username_program;
    public String iduser_program;
    public String idIndex;

    public PaymentOfCustomer(String id_user, String name_user) throws SQLException {
        initComponents();
        connect = DatabaseHelper.getConnection();
        username_program = name_user;
        iduser_program = id_user;
        CheckRole();
        hello_lb.setText("Hi, " + FunctionOfProgram.capsText(username_program));
        jLabel1.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/org/pnv/image/backgrounds.jpg")).getImage().getScaledInstance(790, 640, Image.SCALE_SMOOTH)));
        this.setLocationRelativeTo(null);
        cbb_submit.setSelectedItem(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        avatar_lb = new javax.swing.JLabel();
        hello_lb = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        noti = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        payment_bt = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jtf_cus = new javax.swing.JTextField();
        jtf_namecustomer = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jtf_area = new javax.swing.JTextField();
        jtf_index = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jtf_total = new javax.swing.JTextField();
        cbb_submit = new javax.swing.JComboBox();
        jLabel14 = new javax.swing.JLabel();
        cbb_month = new javax.swing.JComboBox<String>();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Electricity Management");
        setPreferredSize(new java.awt.Dimension(790, 640));
        setSize(new java.awt.Dimension(790, 640));
        getContentPane().setLayout(null);

        jLabel10.setFont(new java.awt.Font("Century Schoolbook", 3, 36)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Payment of Admin");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(70, 140, 400, 40);
        getContentPane().add(avatar_lb);
        avatar_lb.setBounds(590, 160, 140, 140);

        hello_lb.setFont(new java.awt.Font("Century Schoolbook", 3, 16)); // NOI18N
        hello_lb.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(hello_lb);
        hello_lb.setBounds(590, 120, 160, 30);

        jButton7.setFont(new java.awt.Font("Century Schoolbook", 1, 12)); // NOI18N
        jButton7.setText("View Statistical ");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton7);
        jButton7.setBounds(570, 310, 180, 50);

        jButton6.setFont(new java.awt.Font("Century Schoolbook", 1, 12)); // NOI18N
        jButton6.setText("Customer Paymented");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton6);
        jButton6.setBounds(570, 360, 180, 50);

        jButton5.setFont(new java.awt.Font("Century Schoolbook", 1, 12)); // NOI18N
        jButton5.setText("Customer Unpayment");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5);
        jButton5.setBounds(570, 410, 180, 50);

        jButton4.setFont(new java.awt.Font("Century Schoolbook", 1, 12)); // NOI18N
        jButton4.setText("Go Home");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4);
        jButton4.setBounds(570, 460, 180, 50);

        jButton3.setFont(new java.awt.Font("Century Schoolbook", 1, 12)); // NOI18N
        jButton3.setText("Exit");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(570, 510, 180, 50);

        noti.setFont(new java.awt.Font("Century Schoolbook", 1, 18)); // NOI18N
        noti.setForeground(new java.awt.Color(255, 0, 0));
        getContentPane().add(noti);
        noti.setBounds(30, 240, 490, 30);

        jPanel3.setLayout(null);

        payment_bt.setFont(new java.awt.Font("Century Schoolbook", 1, 12)); // NOI18N
        payment_bt.setForeground(new java.awt.Color(51, 51, 255));
        payment_bt.setText("Payment");
        payment_bt.setEnabled(false);
        payment_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                payment_btActionPerformed(evt);
            }
        });
        jPanel3.add(payment_bt);
        payment_bt.setBounds(380, 220, 100, 70);

        jLabel8.setFont(new java.awt.Font("Century Schoolbook", 1, 16)); // NOI18N
        jLabel8.setText("Month");
        jPanel3.add(jLabel8);
        jLabel8.setBounds(30, 60, 150, 30);

        jLabel9.setFont(new java.awt.Font("Century Schoolbook", 1, 16)); // NOI18N
        jLabel9.setText("Customer ID");
        jPanel3.add(jLabel9);
        jLabel9.setBounds(30, 20, 150, 30);

        jtf_cus.setFont(new java.awt.Font("Century Schoolbook", 0, 12)); // NOI18N
        jtf_cus.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtf_cusKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtf_cusKeyTyped(evt);
            }
        });
        jPanel3.add(jtf_cus);
        jtf_cus.setBounds(200, 20, 170, 30);

        jtf_namecustomer.setEditable(false);
        jtf_namecustomer.setFont(new java.awt.Font("Century Schoolbook", 0, 12)); // NOI18N
        jPanel3.add(jtf_namecustomer);
        jtf_namecustomer.setBounds(200, 100, 170, 30);

        jLabel13.setFont(new java.awt.Font("Century Schoolbook", 1, 16)); // NOI18N
        jLabel13.setText("Name Customer");
        jPanel3.add(jLabel13);
        jLabel13.setBounds(30, 100, 150, 30);

        jLabel16.setFont(new java.awt.Font("Century Schoolbook", 1, 16)); // NOI18N
        jLabel16.setText("Area");
        jPanel3.add(jLabel16);
        jLabel16.setBounds(30, 140, 160, 30);

        jtf_area.setEditable(false);
        jtf_area.setFont(new java.awt.Font("Century Schoolbook", 0, 12)); // NOI18N
        jPanel3.add(jtf_area);
        jtf_area.setBounds(200, 140, 170, 30);

        jtf_index.setEditable(false);
        jtf_index.setFont(new java.awt.Font("Century Schoolbook", 0, 12)); // NOI18N
        jPanel3.add(jtf_index);
        jtf_index.setBounds(200, 180, 170, 30);

        jLabel15.setFont(new java.awt.Font("Century Schoolbook", 1, 16)); // NOI18N
        jLabel15.setText("Index ");
        jPanel3.add(jLabel15);
        jLabel15.setBounds(30, 180, 160, 30);

        jLabel12.setFont(new java.awt.Font("Century Schoolbook", 1, 16)); // NOI18N
        jLabel12.setText("Total");
        jPanel3.add(jLabel12);
        jLabel12.setBounds(30, 220, 160, 30);

        jtf_total.setEditable(false);
        jtf_total.setFont(new java.awt.Font("Century Schoolbook", 0, 12)); // NOI18N
        jPanel3.add(jtf_total);
        jtf_total.setBounds(200, 220, 170, 30);

        cbb_submit.setFont(new java.awt.Font("Century Schoolbook", 1, 12)); // NOI18N
        cbb_submit.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Submit", "Unsubmit" }));
        jPanel3.add(cbb_submit);
        cbb_submit.setBounds(200, 260, 170, 30);

        jLabel14.setFont(new java.awt.Font("Century Schoolbook", 1, 16)); // NOI18N
        jLabel14.setText("Payment");
        jPanel3.add(jLabel14);
        jLabel14.setBounds(30, 260, 160, 30);

        cbb_month.setFont(new java.awt.Font("Century Schoolbook", 1, 12)); // NOI18N
        cbb_month.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "January", "Frebuary", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" }));
        cbb_month.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbb_monthItemStateChanged(evt);
            }
        });
        jPanel3.add(cbb_month);
        cbb_month.setBounds(200, 60, 170, 30);

        getContentPane().add(jPanel3);
        jPanel3.setBounds(30, 250, 490, 310);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/pnv/image/backgrounds.jpg"))); // NOI18N
        jLabel1.setPreferredSize(new java.awt.Dimension(790, 640));
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 790, 640);

        pack();
    }// </editor-fold>//GEN-END:initComponents
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
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        try {
            ThemeLoginSuccessAdmin showTheme = new ThemeLoginSuccessAdmin(iduser_program, username_program);
            FunctionOfProgram.insertHistory(iduser_program, "User: " + username_program + " Sign out");
            showTheme.setVisible(true);
            dispose();
        } catch (SQLException ex) {
            Logger.getLogger(PaymentOfCustomer.class.getName()).log(Level.SEVERE, null, ex);
        }

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
            ViewPayment showTheme = new ViewPayment(iduser_program, username_program);
            showTheme.setVisible(true);
            dispose();
        } catch (SQLException ex) {
            Logger.getLogger(ThemeLoginSuccessAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void payment_btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_payment_btActionPerformed
        try {
            preparedStatement = connect.prepareStatement("UPDATE Indexs SET payment = ? WHERE id = ?");
            preparedStatement.setString(1, cbb_submit.getSelectedItem().toString());
            preparedStatement.setString(2, idIndex);
            preparedStatement.executeUpdate();
            jtf_namecustomer.setText(null);
            jtf_area.setText(null);
            jtf_index.setText(null);
            jtf_total.setText(null);
            cbb_submit.setSelectedItem(null);
            jtf_cus.setText(null);
            cbb_month.setSelectedItem(null);
        } catch (SQLException ex) {
            Logger.getLogger(CustomerInformations.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_payment_btActionPerformed
    public void showInformation(String cusId, String month) {
        try {
            preparedStatement = connect.prepareStatement("SELECT Indexs.id, "
                    + "Customer.cus_name, "
                    + "Area.name_area, "
                    + "Indexs.indexs, "
                    + "Indexs.Total, "
                    + "Indexs.payment From Indexs JOIN customer ON Indexs.cus_ID = ? AND "
                    + "Customer.ID = ? AND index_of_month = ?"
                    + "JOIN Area "
                    + "ON Area.ID = Customer.area");
            preparedStatement.setString(1, cusId);
            preparedStatement.setString(2, cusId);
            preparedStatement.setString(3, month);
            resultset = preparedStatement.executeQuery();
            if (resultset.first()) {
                idIndex = resultset.getString(1);
                jtf_namecustomer.setText(resultset.getString(2));
                jtf_area.setText(resultset.getString(3));
                jtf_index.setText(resultset.getString(4));
                jtf_total.setText(resultset.getString(5));
                cbb_submit.setSelectedItem(resultset.getString(6));
                payment_bt.setEnabled(true);
            } else {
                jtf_namecustomer.setText(null);
                jtf_area.setText(null);
                jtf_index.setText(null);
                jtf_total.setText(null);
                cbb_submit.setSelectedItem(null);
                payment_bt.setEnabled(false);
            }

        } catch (SQLException ex) {
            Logger.getLogger(CustomerInformations.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
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

    private void cbb_monthItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbb_monthItemStateChanged
        showInformation(jtf_cus.getText(), String.valueOf(cbb_month.getSelectedIndex() + 1));
    }//GEN-LAST:event_cbb_monthItemStateChanged

    private void jtf_cusKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_cusKeyReleased
        showInformation(jtf_cus.getText(), String.valueOf(cbb_month.getSelectedIndex() + 1));
    }//GEN-LAST:event_jtf_cusKeyReleased

    private void jtf_cusKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_cusKeyTyped
        char c = evt.getKeyChar();
        if (!Character.isDigit(c) || (c == KeyEvent.VK_SPACE) || (c == KeyEvent.VK_DELETE)) {
            evt.consume();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_cusKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel avatar_lb;
    private javax.swing.JComboBox<String> cbb_month;
    private javax.swing.JComboBox cbb_submit;
    private javax.swing.JLabel hello_lb;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField jtf_area;
    private javax.swing.JTextField jtf_cus;
    private javax.swing.JTextField jtf_index;
    private javax.swing.JTextField jtf_namecustomer;
    private javax.swing.JTextField jtf_total;
    private javax.swing.JLabel noti;
    private javax.swing.JButton payment_bt;
    // End of variables declaration//GEN-END:variables
}
