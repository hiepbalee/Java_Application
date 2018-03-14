package org.pnv.project;

import java.awt.Desktop;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import org.pnv.functions.DatabaseHelper;
import org.pnv.functions.FunctionOfProgram;

public class ThemeLogin extends javax.swing.JFrame {

    private Connection connect;
    private ResultSet resultset;
    private PreparedStatement preparedStatement = null;

    public ThemeLogin() {

        try {
            connect = DatabaseHelper.getConnection();
            initComponents();
            this.setLocationRelativeTo(null);
            notification_jscroll.setVisible(false);
            contentNotification_jtextArea.setVisible(false);
            lb_name.setVisible(false);
            lb_rate.setVisible(false);
            lb_tell.setVisible(false);
            tf_fullName.setVisible(false);
            contentFeedback_jscroll.setVisible(false);
            cbb_feedbackApp.setVisible(false);
            contentFeedback_jtextArea.setVisible(false);
            backgroup_lb.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/org/pnv/image/backgrounds.jpg")).getImage().getScaledInstance(790, 640, Image.SCALE_SMOOTH)));
            backgroup2_lb.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/org/pnv/image/roo6.png")).getImage().getScaledInstance(490, 290, Image.SCALE_SMOOTH)));
            preparedStatement = connect.prepareStatement("SELECT * FROM Notification LIMIT 1 ");
            resultset = preparedStatement.executeQuery();
            while (resultset.next()) {
                contentNotification_jtextArea.setText(resultset.getString(3));
                contentNotification_jtextArea.setText(contentNotification_jtextArea.getText());
                lb_notification.setText(contentNotification_jtextArea.getText());
            }

        } catch (SQLException ex) {
            Logger.getLogger(ThemeLoginSuccessAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        login_panel = new javax.swing.JPanel();
        title_lb = new javax.swing.JLabel();
        username_lb = new javax.swing.JLabel();
        username_tf = new javax.swing.JTextField();
        password_lb = new javax.swing.JLabel();
        password_tf = new javax.swing.JPasswordField();
        login_bt = new javax.swing.JButton();
        lb_notification = new javax.swing.JLabel();
        lb_name = new javax.swing.JLabel();
        tf_fullName = new javax.swing.JTextField();
        lb_rate = new javax.swing.JLabel();
        cbb_feedbackApp = new javax.swing.JComboBox();
        lb_tell = new javax.swing.JLabel();
        contentFeedback_jscroll = new javax.swing.JScrollPane();
        contentFeedback_jtextArea = new javax.swing.JTextArea();
        notification_jscroll = new javax.swing.JScrollPane();
        contentNotification_jtextArea = new javax.swing.JTextArea();
        backgroup2_lb = new javax.swing.JLabel();
        feedback_bt = new javax.swing.JButton();
        homebrower_bt = new javax.swing.JButton();
        backgroup_lb = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Electricity Management");
        setName("Login Program"); // NOI18N
        setResizable(false);

        login_panel.setPreferredSize(new java.awt.Dimension(790, 640));
        login_panel.setLayout(null);

        title_lb.setFont(new java.awt.Font("Century Schoolbook", 1, 15)); // NOI18N
        title_lb.setForeground(new java.awt.Color(255, 255, 255));
        title_lb.setText("Login in System");
        login_panel.add(title_lb);
        title_lb.setBounds(570, 220, 180, 50);

        username_lb.setFont(new java.awt.Font("Century Schoolbook", 1, 15)); // NOI18N
        username_lb.setForeground(new java.awt.Color(255, 255, 255));
        username_lb.setText("Username");
        login_panel.add(username_lb);
        username_lb.setBounds(570, 280, 100, 30);

        username_tf.setFont(new java.awt.Font("Century Schoolbook", 1, 14)); // NOI18N
        login_panel.add(username_tf);
        username_tf.setBounds(570, 310, 180, 30);

        password_lb.setFont(new java.awt.Font("Century Schoolbook", 1, 15)); // NOI18N
        password_lb.setForeground(new java.awt.Color(255, 255, 255));
        password_lb.setText("Password");
        login_panel.add(password_lb);
        password_lb.setBounds(570, 340, 100, 30);

        password_tf.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        password_tf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                password_tfKeyReleased(evt);
            }
        });
        login_panel.add(password_tf);
        password_tf.setBounds(570, 370, 180, 30);

        login_bt.setFont(new java.awt.Font("Century Schoolbook", 1, 14)); // NOI18N
        login_bt.setText("Login");
        login_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                login_btActionPerformed(evt);
            }
        });
        login_panel.add(login_bt);
        login_bt.setBounds(570, 410, 180, 40);

        lb_notification.setFont(new java.awt.Font("Century Schoolbook", 2, 20)); // NOI18N
        lb_notification.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_notificationMouseClicked(evt);
            }
        });
        login_panel.add(lb_notification);
        lb_notification.setBounds(30, 590, 420, 22);

        lb_name.setFont(new java.awt.Font("Century Schoolbook", 1, 18)); // NOI18N
        lb_name.setText("Name of you:");
        login_panel.add(lb_name);
        lb_name.setBounds(50, 290, 130, 30);

        tf_fullName.setFont(new java.awt.Font("Century Schoolbook", 1, 14)); // NOI18N
        login_panel.add(tf_fullName);
        tf_fullName.setBounds(210, 290, 290, 30);

        lb_rate.setFont(new java.awt.Font("Century Schoolbook", 1, 18)); // NOI18N
        lb_rate.setText("Rate this app:");
        login_panel.add(lb_rate);
        lb_rate.setBounds(50, 330, 140, 22);

        cbb_feedbackApp.setFont(new java.awt.Font("Century Schoolbook", 1, 14)); // NOI18N
        cbb_feedbackApp.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Very Good", "Good", "Fail" }));
        login_panel.add(cbb_feedbackApp);
        cbb_feedbackApp.setBounds(210, 330, 290, 30);

        lb_tell.setFont(new java.awt.Font("Century Schoolbook", 1, 18)); // NOI18N
        lb_tell.setText("Tell us what you think:");
        login_panel.add(lb_tell);
        lb_tell.setBounds(50, 370, 220, 22);

        contentFeedback_jtextArea.setColumns(20);
        contentFeedback_jtextArea.setFont(new java.awt.Font("Century Schoolbook", 1, 18)); // NOI18N
        contentFeedback_jtextArea.setRows(5);
        contentFeedback_jtextArea.setWrapStyleWord(true);
        contentFeedback_jtextArea.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        contentFeedback_jscroll.setViewportView(contentFeedback_jtextArea);

        login_panel.add(contentFeedback_jscroll);
        contentFeedback_jscroll.setBounds(50, 410, 450, 140);

        contentNotification_jtextArea.setColumns(20);
        contentNotification_jtextArea.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        contentNotification_jtextArea.setRows(5);
        notification_jscroll.setViewportView(contentNotification_jtextArea);

        login_panel.add(notification_jscroll);
        notification_jscroll.setBounds(30, 270, 490, 290);
        login_panel.add(backgroup2_lb);
        backgroup2_lb.setBounds(30, 270, 490, 290);

        feedback_bt.setFont(new java.awt.Font("Century Schoolbook", 1, 14)); // NOI18N
        feedback_bt.setText("Feedback");
        feedback_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                feedback_btActionPerformed(evt);
            }
        });
        login_panel.add(feedback_bt);
        feedback_bt.setBounds(570, 510, 180, 40);

        homebrower_bt.setFont(new java.awt.Font("Century Schoolbook", 1, 14)); // NOI18N
        homebrower_bt.setText("Home Brower");
        homebrower_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homebrower_btActionPerformed(evt);
            }
        });
        login_panel.add(homebrower_bt);
        homebrower_bt.setBounds(570, 460, 180, 40);

        backgroup_lb.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/pnv/image/backgrounds.jpg"))); // NOI18N
        backgroup_lb.setPreferredSize(new java.awt.Dimension(790, 640));
        login_panel.add(backgroup_lb);
        backgroup_lb.setBounds(0, 0, 790, 640);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(login_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(login_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void login_btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_login_btActionPerformed
        Checklogin();
    }//GEN-LAST:event_login_btActionPerformed
    public void Checklogin() {
        try {

            preparedStatement = connect.prepareStatement("SELECT * FROM Users WHERE user_name = ? AND user_password = ?  ");
            preparedStatement.setString(1, username_tf.getText());
            preparedStatement.setString(2, FunctionOfProgram.getMD5(password_tf.getText()));
            resultset = preparedStatement.executeQuery();
            if (resultset.next()) {
                if (("Administrator".equals(resultset.getString(4))) || ("Employee".equals(resultset.getString(4)))) {
                    ThemeLoginSuccessAdmin loginSuccess = new ThemeLoginSuccessAdmin(resultset.getString(1), resultset.getString(2));
                    setVisible(false);
                    loginSuccess.setVisible(true);
                    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                    LocalDateTime now = LocalDateTime.now();
                    preparedStatement = connect.prepareStatement("UPDATE Users SET date_login = ? WHERE ID = ?");
                    preparedStatement.setString(1, dtf.format(now));
                    preparedStatement.setString(2, resultset.getString(1));
                    preparedStatement.executeUpdate();
                    FunctionOfProgram.insertHistory(resultset.getString(1), resultset.getString(2) + " logined in program");
                } else if ("Customer".equals(resultset.getString(4))) {
         
                    
                        ThemeLoginSuccessUser themeUser = new ThemeLoginSuccessUser(resultset.getString(1),resultset.getString(2));
                        themeUser.setVisible(true);
                        dispose();
                        FunctionOfProgram.insertHistory(resultset.getString(1), resultset.getString(2) + " logined in program");
                }
            } else {
                JOptionPane.showMessageDialog(rootPane, " Please check information of you ! \n User not exist !");
                password_tf.setText(null);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ThemeLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void feedback_btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_feedback_btActionPerformed
        if (feedback_bt.getText().equals("Feedback")) {
            notification_jscroll.setVisible(false);
            contentNotification_jtextArea.setVisible(false);
            lb_name.setVisible(false);
            lb_rate.setVisible(false);
            lb_tell.setVisible(false);
            feedback_bt.setText("Send Feedback");
            lb_name.setVisible(true);
            lb_rate.setVisible(true);
            lb_tell.setVisible(true);
            tf_fullName.setVisible(true);
            cbb_feedbackApp.setVisible(true);
            contentFeedback_jtextArea.setVisible(true);
            contentFeedback_jscroll.setVisible(true);
            backgroup2_lb.setVisible(true);
        } else {
            String name = tf_fullName.getText();
            String feedback = contentFeedback_jtextArea.getText();
            try {
                if (tf_fullName.getText().equals("")) {
                    JOptionPane.showMessageDialog(rootPane, "Please enter the name! Thank you ");

                } else if (contentFeedback_jtextArea.getText().equals("")) {
                    JOptionPane.showMessageDialog(rootPane, "Please enter your feedback!! Thank you ");
                } else {

                    preparedStatement = connect.prepareStatement("INSERT INTO Feedback (full_name, rate_app, feedback) VALUES ( ?, ?, ? )");
                    preparedStatement.setString(1, name);
                    preparedStatement.setString(2, cbb_feedbackApp.getSelectedItem().toString());
                    preparedStatement.setString(3, feedback);
                    preparedStatement.executeUpdate();
                    JOptionPane.showMessageDialog(rootPane, "You send to feedback success!! \n Thank you", "Success", WIDTH);
                    contentFeedback_jtextArea.setText("");
                    tf_fullName.setText("");
                    feedback_bt.setText("Feedback");
                    lb_name.setVisible(false);
                    lb_rate.setVisible(false);
                    lb_tell.setVisible(false);
                    tf_fullName.setVisible(false);
                    cbb_feedbackApp.setVisible(false);
                    contentFeedback_jtextArea.setVisible(false);
                    contentFeedback_jscroll.setVisible(false);
                }

            } catch (SQLException ex) {
                Logger.getLogger(ThemeLogin.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_feedback_btActionPerformed

    private void password_tfKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_password_tfKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            Checklogin();
            }
    }//GEN-LAST:event_password_tfKeyReleased

    private void lb_notificationMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_notificationMouseClicked
        backgroup2_lb.setVisible(false);
        notification_jscroll.setVisible(true);
        contentNotification_jtextArea.setVisible(true);
        contentNotification_jtextArea.setEditable(false);
        contentNotification_jtextArea.getText();
        lb_notification.setVisible(false);
        lb_name.setVisible(false);
        lb_rate.setVisible(false);
        lb_tell.setVisible(false);
        tf_fullName.setVisible(false);
        contentFeedback_jscroll.setVisible(false);
        cbb_feedbackApp.setVisible(false);
        contentFeedback_jtextArea.setVisible(false);
    }//GEN-LAST:event_lb_notificationMouseClicked

    private void homebrower_btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homebrower_btActionPerformed
        if (Desktop.isDesktopSupported()) {
            Desktop desktop = Desktop.getDesktop();
            try {
                desktop.browse(new URI("http://en.evn.com.vn/"));
            } catch (IOException | URISyntaxException e) {
                JOptionPane.showMessageDialog(rootPane, desktop);
            }
        }
    }//GEN-LAST:event_homebrower_btActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ThemeLogin.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ThemeLogin.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ThemeLogin.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ThemeLogin.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ThemeLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel backgroup2_lb;
    private javax.swing.JLabel backgroup_lb;
    private javax.swing.JComboBox cbb_feedbackApp;
    private javax.swing.JScrollPane contentFeedback_jscroll;
    private javax.swing.JTextArea contentFeedback_jtextArea;
    private javax.swing.JTextArea contentNotification_jtextArea;
    private javax.swing.JButton feedback_bt;
    private javax.swing.JButton homebrower_bt;
    private javax.swing.JLabel lb_name;
    private javax.swing.JLabel lb_notification;
    private javax.swing.JLabel lb_rate;
    private javax.swing.JLabel lb_tell;
    private javax.swing.JButton login_bt;
    private javax.swing.JPanel login_panel;
    private javax.swing.JScrollPane notification_jscroll;
    private javax.swing.JLabel password_lb;
    private javax.swing.JPasswordField password_tf;
    private javax.swing.JTextField tf_fullName;
    private javax.swing.JLabel title_lb;
    private javax.swing.JLabel username_lb;
    private javax.swing.JTextField username_tf;
    // End of variables declaration//GEN-END:variables
}
