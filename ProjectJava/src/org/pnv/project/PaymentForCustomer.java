package org.pnv.project;

import java.awt.Image;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import org.pnv.functions.DatabaseHelper;
import org.pnv.functions.FunctionOfProgram;

public class PaymentForCustomer extends javax.swing.JFrame {

    private Connection connect;

    private ResultSet resultset;

    private PreparedStatement preparedStatement = null;
    private String idindex;
    public String username_program;
    public String iduser_program;
    public String username_cus;
    public int s = 0;
    public int power = 0;
    public int money = 0;
    public int moneytax = 0;
    public int total = 0;

    public PaymentForCustomer(String id_user, String name_user) throws SQLException {
        initComponents();
        connect = DatabaseHelper.getConnection();
        username_program = name_user;
        iduser_program = id_user;
        preparedStatement = connect.prepareStatement("SELECT id, cus_name FROM Customer WHERE id_card = ?");
        preparedStatement.setString(1, name_user);
        resultset = preparedStatement.executeQuery();
        if (resultset.next()) {
            jtf_cus.setText(resultset.getString(1));
            username_cus = resultset.getString(1);
            hello_lb.setText("Hi, " + FunctionOfProgram.capsText(resultset.getString(2)));
        }

        avatar_lb.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/org/pnv/image/customer.png")).getImage().getScaledInstance(140, 140, Image.SCALE_SMOOTH)));
        jLabel1.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/org/pnv/image/backgrounds.jpg")).getImage().getScaledInstance(790, 640, Image.SCALE_SMOOTH)));
        this.setLocationRelativeTo(null);
        cbb_payment.setSelectedItem(null);
        showInfor(String.valueOf(cbb_month1.getSelectedIndex() + 1));
    }

    public void showInfor(String month) {
        try {
            preparedStatement = connect.prepareStatement("SELECT Indexs.indexs, Indexs.Total, Indexs.payment From Indexs JOIN customer ON Indexs.cus_ID = ? AND Customer.ID = ? AND index_of_month = ?");
            preparedStatement.setString(1, jtf_cus.getText());
            preparedStatement.setString(2, jtf_cus.getText());
            preparedStatement.setString(3, month);
            System.out.println(preparedStatement);
            resultset = preparedStatement.executeQuery();
            if (resultset.next()) {
                jtf_cus.setText(username_cus);
                jtf_index.setText(resultset.getString(1));
                jtf_total.setText(resultset.getString(2));
                if (resultset.getString(3).equals("Submit")) {
                    payment_jbt.setEnabled(false);
                    cbb_payment.setEditable(false);
                    jtf_payment.setEditable(false);
                } else {
                    payment_jbt.setEnabled(true);
                    jtf_payment.setEditable(true);
                }

            } else {
                jtf_index.setText(null);
                jtf_payment.setText(null);
                jtf_total.setText(null);
            }

        } catch (SQLException ex) {
            Logger.getLogger(CustomerInformations.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        avatar_lb = new javax.swing.JLabel();
        hello_lb = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        noti = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jtf_cus = new javax.swing.JTextField();
        jtf_index = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jtf_payment = new javax.swing.JTextField();
        cbb_payment = new javax.swing.JComboBox();
        jLabel13 = new javax.swing.JLabel();
        jtf_total = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        payment_jbt = new javax.swing.JButton();
        cbb_month1 = new javax.swing.JComboBox<String>();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Electricity Management");
        setPreferredSize(new java.awt.Dimension(790, 640));
        setSize(new java.awt.Dimension(790, 640));
        getContentPane().setLayout(null);

        jLabel10.setFont(new java.awt.Font("Century Schoolbook", 3, 36)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Payment of Customer");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(70, 140, 430, 40);
        getContentPane().add(avatar_lb);
        avatar_lb.setBounds(590, 160, 140, 140);

        hello_lb.setFont(new java.awt.Font("Century Schoolbook", 3, 16)); // NOI18N
        hello_lb.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(hello_lb);
        hello_lb.setBounds(590, 120, 160, 30);

        jButton4.setFont(new java.awt.Font("Century Schoolbook", 1, 12)); // NOI18N
        jButton4.setText("Go Home");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4);
        jButton4.setBounds(570, 410, 180, 60);

        jButton3.setFont(new java.awt.Font("Century Schoolbook", 1, 12)); // NOI18N
        jButton3.setText("Exit");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(570, 490, 180, 60);

        noti.setFont(new java.awt.Font("Century Schoolbook", 1, 18)); // NOI18N
        noti.setForeground(new java.awt.Color(255, 0, 0));
        getContentPane().add(noti);
        noti.setBounds(30, 240, 490, 30);

        jPanel3.setLayout(null);

        jLabel8.setFont(new java.awt.Font("Century Schoolbook", 1, 16)); // NOI18N
        jLabel8.setText("Month");
        jPanel3.add(jLabel8);
        jLabel8.setBounds(30, 20, 150, 40);

        jLabel9.setFont(new java.awt.Font("Century Schoolbook", 1, 16)); // NOI18N
        jLabel9.setText("Customer ID");
        jPanel3.add(jLabel9);
        jLabel9.setBounds(30, 70, 150, 40);

        jtf_cus.setEditable(false);
        jtf_cus.setFont(new java.awt.Font("Century Schoolbook", 0, 12)); // NOI18N
        jPanel3.add(jtf_cus);
        jtf_cus.setBounds(200, 70, 170, 40);

        jtf_index.setEditable(false);
        jtf_index.setFont(new java.awt.Font("Century Schoolbook", 0, 12)); // NOI18N
        jPanel3.add(jtf_index);
        jtf_index.setBounds(200, 120, 170, 40);

        jLabel15.setFont(new java.awt.Font("Century Schoolbook", 1, 16)); // NOI18N
        jLabel15.setText("Index ");
        jPanel3.add(jLabel15);
        jLabel15.setBounds(30, 120, 160, 40);

        jLabel12.setFont(new java.awt.Font("Century Schoolbook", 1, 16)); // NOI18N
        jLabel12.setText("Enter the money");
        jPanel3.add(jLabel12);
        jLabel12.setBounds(30, 270, 160, 40);

        jtf_payment.setFont(new java.awt.Font("Century Schoolbook", 0, 12)); // NOI18N
        jtf_payment.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtf_paymentMouseClicked(evt);
            }
        });
        jtf_payment.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtf_paymentKeyReleased(evt);
            }
        });
        jPanel3.add(jtf_payment);
        jtf_payment.setBounds(200, 270, 170, 40);

        cbb_payment.setEditable(true);
        cbb_payment.setFont(new java.awt.Font("Century Schoolbook", 1, 12)); // NOI18N
        cbb_payment.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Debit card", "Creadit Card", "ATM Card" }));
        jPanel3.add(cbb_payment);
        cbb_payment.setBounds(200, 220, 170, 40);

        jLabel13.setFont(new java.awt.Font("Century Schoolbook", 1, 16)); // NOI18N
        jLabel13.setText("Total");
        jPanel3.add(jLabel13);
        jLabel13.setBounds(30, 170, 160, 40);

        jtf_total.setEditable(false);
        jtf_total.setFont(new java.awt.Font("Century Schoolbook", 0, 12)); // NOI18N
        jtf_total.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtf_totalMouseClicked(evt);
            }
        });
        jPanel3.add(jtf_total);
        jtf_total.setBounds(200, 170, 170, 40);

        jLabel14.setFont(new java.awt.Font("Century Schoolbook", 1, 16)); // NOI18N
        jLabel14.setText("Payment");
        jPanel3.add(jLabel14);
        jLabel14.setBounds(30, 220, 160, 40);

        payment_jbt.setFont(new java.awt.Font("Century Schoolbook", 1, 12)); // NOI18N
        payment_jbt.setForeground(new java.awt.Color(51, 51, 255));
        payment_jbt.setText("Payment");
        payment_jbt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                payment_jbtActionPerformed(evt);
            }
        });
        jPanel3.add(payment_jbt);
        payment_jbt.setBounds(390, 220, 90, 90);

        cbb_month1.setFont(new java.awt.Font("Century Schoolbook", 1, 14)); // NOI18N
        cbb_month1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "January", "Frebuary", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" }));
        cbb_month1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbb_month1ItemStateChanged(evt);
            }
        });
        jPanel3.add(cbb_month1);
        cbb_month1.setBounds(200, 20, 170, 40);

        getContentPane().add(jPanel3);
        jPanel3.setBounds(30, 250, 490, 320);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/pnv/image/backgrounds.jpg"))); // NOI18N
        jLabel1.setPreferredSize(new java.awt.Dimension(790, 640));
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 790, 640);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        try {
            ThemeLoginSuccessUser showTheme = new ThemeLoginSuccessUser(iduser_program, username_program);
            FunctionOfProgram.insertHistory(iduser_program, "User: " + username_program + " Sign out");
            showTheme.setVisible(true);
            dispose();
        } catch (SQLException ex) {
            Logger.getLogger(PaymentForCustomer.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int check = JOptionPane.showConfirmDialog(rootPane, "Are you sure", "Exit program", JOptionPane.YES_OPTION);
        if (check == JOptionPane.YES_OPTION) {
            System.exit(0);
        } else {

        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jtf_paymentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtf_paymentMouseClicked
        // TODO add your handling code here:
        //   preparedStatement =connect.prepareStatement("SELECT ")
    }//GEN-LAST:event_jtf_paymentMouseClicked

    private void jtf_totalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtf_totalMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_totalMouseClicked

    private void payment_jbtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_payment_jbtActionPerformed
        try {
            preparedStatement = connect.prepareStatement("UPDATE Indexs SET payment = ? WHERE id = ?");
            preparedStatement.setString(1, "Submit");
            preparedStatement.setString(2, jtf_cus.getText());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
            jtf_cus.setText(null);
            // cbb_submit.setText(null);
            jtf_index.setText(null);
            jtf_total.setText(null);
            cbb_payment.setSelectedItem(null);
            jtf_cus.setText(null);

        } catch (SQLException ex) {
            Logger.getLogger(CustomerInformations.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_payment_jbtActionPerformed

    private void cbb_month1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbb_month1ItemStateChanged
        showInfor(String.valueOf(cbb_month1.getSelectedIndex() + 1));
    }//GEN-LAST:event_cbb_month1ItemStateChanged

    private void jtf_paymentKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_paymentKeyReleased
        Double total = Double.valueOf(jtf_total.getText());
        Double payment = Double.valueOf(jtf_payment.getText());
        if (payment < total) {
            noti.setText("Payment money < Total money! Please enter the money");
            jtf_payment.setText(null);
        } else {
        }
    }//GEN-LAST:event_jtf_paymentKeyReleased
    public static void main(String[] args) throws SQLException {
        PaymentForCustomer a = new PaymentForCustomer("2", "212430550");
        a.setVisible(true);

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel avatar_lb;
    private javax.swing.JComboBox<String> cbb_month1;
    private javax.swing.JComboBox cbb_payment;
    private javax.swing.JLabel hello_lb;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField jtf_cus;
    private javax.swing.JTextField jtf_index;
    private javax.swing.JTextField jtf_payment;
    private javax.swing.JTextField jtf_total;
    private javax.swing.JLabel noti;
    private javax.swing.JButton payment_jbt;
    // End of variables declaration//GEN-END:variables
}
