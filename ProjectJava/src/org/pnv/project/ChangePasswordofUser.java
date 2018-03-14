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
import javax.swing.JTable;
import org.pnv.functions.CapsLock;
import org.pnv.functions.DatabaseHelper;
import org.pnv.functions.FunctionOfProgram;

public class ChangePasswordofUser extends javax.swing.JFrame {

    private Connection connect;
    private Statement statement;
    private ResultSet resultset;
    private ResultSetMetaData resultsetmetadata;
    private PreparedStatement preparedStatement = null;
    public String username_program;
    public String iduser_program;
    private String iduser_table;
    private String path = null;

    public ChangePasswordofUser(String id_user, String name_user) throws SQLException {
        connect = DatabaseHelper.getConnection();
        initComponents();
        username_program = name_user;
        iduser_program = id_user;
        username_tf.setText(name_user);
        preparedStatement = connect.prepareStatement("SELECT  cus_name FROM Customer   WHERE ID_card=? ");
        preparedStatement.setString(1, username_program);
        resultset = preparedStatement.executeQuery();
        if (resultset.next()) {
            hello_lb.setText("Hi, " + CapsLock.capstext(resultset.getString(1)));
        }
        this.setLocationRelativeTo(null);
        avatar_lb.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/org/pnv/image/customer.png")).getImage().getScaledInstance(140, 140, Image.SCALE_SMOOTH)));
        background2_lb.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/org/pnv/image/online12.png")).getImage().getScaledInstance(490, 290, Image.SCALE_SMOOTH)));
        change_jbt.setEnabled(true);
        newPassword_jpw.setEnabled(false);
        rePassword_pw.setEnabled(false);
        username_tf.setEnabled(false);
    }

    public static boolean isEmpty(JTable jTable) {
        if (jTable != null && jTable.getModel() != null) {
            return jTable.getModel().getRowCount() <= 0 ? true : false;
        }
        return false;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        username_tf = new javax.swing.JTextField();
        username_lb = new javax.swing.JLabel();
        password_lb = new javax.swing.JLabel();
        repassword_lb = new javax.swing.JLabel();
        change_jbt = new javax.swing.JButton();
        avatar_lb = new javax.swing.JLabel();
        home_bt = new javax.swing.JButton();
        exit_bt = new javax.swing.JButton();
        hello_lb = new javax.swing.JLabel();
        password_lb1 = new javax.swing.JLabel();
        oldPassword_jpw = new javax.swing.JPasswordField();
        newPassword_jpw = new javax.swing.JPasswordField();
        rePassword_pw = new javax.swing.JPasswordField();
        check_jlb = new javax.swing.JLabel();
        background2_lb = new javax.swing.JLabel();
        background_lb = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Electricity Management");
        setResizable(false);

        jPanel1.setPreferredSize(new java.awt.Dimension(790, 640));
        jPanel1.setLayout(null);

        username_tf.setFont(new java.awt.Font("Century Schoolbook", 0, 13)); // NOI18N
        username_tf.setEnabled(false);
        jPanel1.add(username_tf);
        username_tf.setBounds(250, 290, 210, 40);

        username_lb.setFont(new java.awt.Font("Century Schoolbook", 1, 16)); // NOI18N
        username_lb.setText("User Name");
        jPanel1.add(username_lb);
        username_lb.setBounds(100, 290, 130, 40);

        password_lb.setFont(new java.awt.Font("Century Schoolbook", 1, 16)); // NOI18N
        password_lb.setText("New Password");
        jPanel1.add(password_lb);
        password_lb.setBounds(100, 390, 130, 40);

        repassword_lb.setFont(new java.awt.Font("Century Schoolbook", 1, 16)); // NOI18N
        repassword_lb.setText("Re-Password");
        jPanel1.add(repassword_lb);
        repassword_lb.setBounds(100, 440, 130, 40);

        change_jbt.setFont(new java.awt.Font("Century Schoolbook", 0, 14)); // NOI18N
        change_jbt.setText("Change Password");
        change_jbt.setEnabled(false);
        change_jbt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                change_jbtActionPerformed(evt);
            }
        });
        jPanel1.add(change_jbt);
        change_jbt.setBounds(250, 500, 210, 40);
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
        home_bt.setBounds(570, 450, 180, 50);

        exit_bt.setFont(new java.awt.Font("Century Schoolbook", 1, 12)); // NOI18N
        exit_bt.setText("Exit");
        exit_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exit_btActionPerformed(evt);
            }
        });
        jPanel1.add(exit_bt);
        exit_bt.setBounds(570, 510, 180, 50);

        hello_lb.setFont(new java.awt.Font("Century Schoolbook", 3, 16)); // NOI18N
        hello_lb.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(hello_lb);
        hello_lb.setBounds(590, 120, 160, 30);

        password_lb1.setFont(new java.awt.Font("Century Schoolbook", 1, 16)); // NOI18N
        password_lb1.setText("Old Password");
        jPanel1.add(password_lb1);
        password_lb1.setBounds(100, 340, 130, 40);

        oldPassword_jpw.setFont(new java.awt.Font("Century Schoolbook", 0, 13)); // NOI18N
        oldPassword_jpw.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                oldPassword_jpwKeyReleased(evt);
            }
        });
        jPanel1.add(oldPassword_jpw);
        oldPassword_jpw.setBounds(250, 340, 210, 40);

        newPassword_jpw.setFont(new java.awt.Font("Century Schoolbook", 0, 13)); // NOI18N
        newPassword_jpw.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                newPassword_jpwKeyReleased(evt);
            }
        });
        jPanel1.add(newPassword_jpw);
        newPassword_jpw.setBounds(250, 390, 210, 40);

        rePassword_pw.setFont(new java.awt.Font("Century Schoolbook", 0, 13)); // NOI18N
        rePassword_pw.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                rePassword_pwKeyReleased(evt);
            }
        });
        jPanel1.add(rePassword_pw);
        rePassword_pw.setBounds(250, 440, 210, 40);

        check_jlb.setFont(new java.awt.Font("Century Schoolbook", 3, 18)); // NOI18N
        jPanel1.add(check_jlb);
        check_jlb.setBounds(100, 240, 370, 30);
        jPanel1.add(background2_lb);
        background2_lb.setBounds(30, 270, 490, 290);

        background_lb.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/pnv/image/backgrounds.jpg"))); // NOI18N
        background_lb.setPreferredSize(new java.awt.Dimension(790, 640));
        jPanel1.add(background_lb);
        background_lb.setBounds(0, 0, 790, 640);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 781, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exit_btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exit_btActionPerformed

    }//GEN-LAST:event_exit_btActionPerformed

    private void home_btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_home_btActionPerformed

        try {
            ThemeLoginSuccessUser loginSuccess = new ThemeLoginSuccessUser(iduser_program, username_program);

            loginSuccess.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(ChangePasswordofUser.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_home_btActionPerformed

    private void change_jbtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_change_jbtActionPerformed

        try {
            preparedStatement = connect.prepareStatement("UPDATE Users SET  user_password = ? WHERE id = ?");
            preparedStatement.setString(2, iduser_program);

            preparedStatement.setString(1, FunctionOfProgram.getMD5(newPassword_jpw.getText()));
            preparedStatement.executeUpdate();
            resultset.getString(1);
            JOptionPane.showMessageDialog(rootPane, "Update username success !!");

            newPassword_jpw.setText(null);
            oldPassword_jpw.setText(null);
            rePassword_pw.setText(null);
        } catch (SQLException ex) {
            Logger.getLogger(ChangePasswordofUser.class.getName()).log(Level.SEVERE, null, ex);
        }

//        }
    }//GEN-LAST:event_change_jbtActionPerformed

    private void oldPassword_jpwKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_oldPassword_jpwKeyReleased
        try {
            preparedStatement = connect.prepareStatement("SELECT  user_password from Users WHERE user_password = ? AND id = ?");
            preparedStatement.setString(2, iduser_program);
            preparedStatement.setString(1, FunctionOfProgram.getMD5(oldPassword_jpw.getText()));
            resultset = preparedStatement.executeQuery();
            if (!resultset.next()) {
                newPassword_jpw.setEnabled(false);
                rePassword_pw.setEnabled(false);
                change_jbt.setEnabled(false);
                check_jlb.setText("Password wrong");
            } else {
                newPassword_jpw.setEnabled(true);
                rePassword_pw.setEnabled(true);
                change_jbt.setEnabled(true);
                check_jlb.setText(null);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ChangePasswordofUser.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_oldPassword_jpwKeyReleased

    private void newPassword_jpwKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_newPassword_jpwKeyReleased

        if (newPassword_jpw.getText().length() <= 6) {
            check_jlb.setText("password not shortter 6");
            change_jbt.setEnabled(false);
        } else {
            check_jlb.setText(null);
            change_jbt.setEnabled(true);
        }
    }//GEN-LAST:event_newPassword_jpwKeyReleased

    private void rePassword_pwKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_rePassword_pwKeyReleased

        if (!(rePassword_pw.getText().equals(newPassword_jpw.getText()))) {
            check_jlb.setText("ko");
            change_jbt.setEnabled(false);
        } else {
            check_jlb.setText("ok");
            change_jbt.setEnabled(true);
        }
    }//GEN-LAST:event_rePassword_pwKeyReleased
    public static void main(String[] args) throws SQLException {
        ChangePasswordofUser s = new ChangePasswordofUser("s", "s");
        s.setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel avatar_lb;
    private javax.swing.JLabel background2_lb;
    private javax.swing.JLabel background_lb;
    private javax.swing.JButton change_jbt;
    private javax.swing.JLabel check_jlb;
    private javax.swing.JButton exit_bt;
    private javax.swing.JLabel hello_lb;
    private javax.swing.JButton home_bt;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField newPassword_jpw;
    private javax.swing.JPasswordField oldPassword_jpw;
    private javax.swing.JLabel password_lb;
    private javax.swing.JLabel password_lb1;
    private javax.swing.JPasswordField rePassword_pw;
    private javax.swing.JLabel repassword_lb;
    private javax.swing.JLabel username_lb;
    private javax.swing.JTextField username_tf;
    // End of variables declaration//GEN-END:variables
}
