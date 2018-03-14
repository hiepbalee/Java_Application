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

public final class SettingApp extends javax.swing.JFrame {

    private Connection connect;
    private ResultSet resultset;
    private PreparedStatement preparedStatement = null;
    public String username_program;
    public String iduser_program;
    private String id;

    public void showInformation() throws SQLException {

        preparedStatement = connect.prepareStatement("SELECT * FROM settingapp");
        resultset = preparedStatement.executeQuery();
        if (resultset.next()) {
            id = resultset.getString(1);
            jtf_email.setText(resultset.getString(2));
            jtf_password.setText(resultset.getString(3));
            jtf_namecompany.setText(resultset.getString(4));
            jtf_phone.setText(resultset.getString(5));
            jtf_address.setText(resultset.getString(6));
        }

    }

    public SettingApp(String id_user, String name_user) throws SQLException {
        connect = DatabaseHelper.getConnection();
        initComponents();
        username_program = name_user;
        iduser_program = id_user;
        hello_lb.setText("Hi, " + FunctionOfProgram.capsText(username_program));
        jLabel1.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/org/pnv/image/backgrounds.jpg")).getImage().getScaledInstance(790, 640, Image.SCALE_SMOOTH)));
        avatar_lb.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/org/pnv/image/admin.png")).getImage().getScaledInstance(140, 140, Image.SCALE_SMOOTH)));
        this.setLocationRelativeTo(null);
        showInformation();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        hello_lb = new javax.swing.JLabel();
        avatar_lb = new javax.swing.JLabel();
        home_bt = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jbt_update = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jtf_email = new javax.swing.JTextField();
        jtf_phone = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jtf_namecompany = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jtf_address = new javax.swing.JTextField();
        jtf_password = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Electricity Management");
        setResizable(false);

        jPanel1.setPreferredSize(new java.awt.Dimension(790, 640));
        jPanel1.setLayout(null);

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
        jbt_update.setText("Change Information");
        jbt_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbt_updateActionPerformed(evt);
            }
        });
        jPanel2.add(jbt_update);
        jbt_update.setBounds(270, 230, 190, 50);

        jLabel7.setFont(new java.awt.Font("Century Schoolbook", 1, 14)); // NOI18N
        jLabel7.setText("Number Phone");
        jPanel2.add(jLabel7);
        jLabel7.setBounds(20, 150, 140, 30);

        jLabel8.setFont(new java.awt.Font("Century Schoolbook", 1, 14)); // NOI18N
        jLabel8.setText("Password Default");
        jPanel2.add(jLabel8);
        jLabel8.setBounds(20, 70, 140, 30);

        jLabel3.setFont(new java.awt.Font("Century Schoolbook", 1, 14)); // NOI18N
        jLabel3.setText("Email Default");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(20, 30, 140, 30);

        jtf_email.setEditable(false);
        jtf_email.setFont(new java.awt.Font("Century Schoolbook", 0, 14)); // NOI18N
        jPanel2.add(jtf_email);
        jtf_email.setBounds(180, 30, 280, 30);

        jtf_phone.setEditable(false);
        jtf_phone.setFont(new java.awt.Font("Century Schoolbook", 0, 14)); // NOI18N
        jtf_phone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtf_phoneKeyTyped(evt);
            }
        });
        jPanel2.add(jtf_phone);
        jtf_phone.setBounds(180, 150, 280, 30);

        jLabel10.setFont(new java.awt.Font("Century Schoolbook", 1, 14)); // NOI18N
        jLabel10.setText("Name of Company");
        jPanel2.add(jLabel10);
        jLabel10.setBounds(20, 110, 140, 30);

        jtf_namecompany.setEditable(false);
        jtf_namecompany.setFont(new java.awt.Font("Century Schoolbook", 0, 14)); // NOI18N
        jPanel2.add(jtf_namecompany);
        jtf_namecompany.setBounds(180, 110, 280, 30);

        jLabel11.setFont(new java.awt.Font("Century Schoolbook", 1, 14)); // NOI18N
        jLabel11.setText("Address Contact");
        jPanel2.add(jLabel11);
        jLabel11.setBounds(20, 190, 140, 30);

        jtf_address.setEditable(false);
        jtf_address.setFont(new java.awt.Font("Century Schoolbook", 0, 14)); // NOI18N
        jPanel2.add(jtf_address);
        jtf_address.setBounds(180, 190, 280, 30);

        jtf_password.setEditable(false);
        jPanel2.add(jtf_password);
        jtf_password.setBounds(180, 70, 280, 30);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(30, 270, 490, 290);

        jLabel4.setFont(new java.awt.Font("Century Schoolbook", 3, 48)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Setting App");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(80, 130, 320, 59);

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
            Logger.getLogger(SettingApp.class.getName()).log(Level.SEVERE, null, ex);
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

        try {
            if (jbt_update.getText().equals("Change Information")) {
                jtf_email.setEditable(true);
                jtf_phone.setEditable(true);
                jtf_password.setEditable(true);
                jtf_address.setEditable(true);
                jtf_namecompany.setEditable(true);
                jbt_update.setText("Update Information");
                jtf_email.setText(null);
                jtf_password.setText(null);
                jtf_namecompany.setText(null);
                jtf_phone.setText(null);
                jtf_address.setText(null);

            } else {
                int check = JOptionPane.showConfirmDialog(rootPane, "Are you sure", "Update Information", JOptionPane.YES_OPTION);
                if (check == JOptionPane.YES_OPTION) {
                    preparedStatement = connect.prepareStatement("UPDATE settingapp SET email_program = ?,  password_program = ?, name_company = ?, numberphone_company = ?, address_company = ? WHERE ID = ? ");
                    preparedStatement.setString(6, id);
                    preparedStatement.setString(1, jtf_email.getText());
                    preparedStatement.setString(2, jtf_password.getText());
                    preparedStatement.setString(3, jtf_namecompany.getText());
                    preparedStatement.setString(4, jtf_phone.getText());
                    preparedStatement.setString(5, jtf_address.getText());
                    preparedStatement.executeUpdate();
                    showInformation();
                    jbt_update.setText("Change Information");
                    jtf_email.setEditable(false);
                    jtf_phone.setEditable(false);
                    jtf_password.setEditable(false);
                    jtf_address.setEditable(false);
                    jtf_namecompany.setEditable(false);
                } else {
                    jbt_update.setText("Change Information");
                    showInformation();
                    jtf_email.setEditable(false);
                    jtf_phone.setEditable(false);
                    jtf_password.setEditable(false);
                    jtf_address.setEditable(false);
                    jtf_namecompany.setEditable(false);
                }

            }
        } catch (SQLException ex) {
            Logger.getLogger(ThemeUsers.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jbt_updateActionPerformed

    private void jtf_phoneKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_phoneKeyTyped
       char c = evt.getKeyChar();
        if (!Character.isDigit(c) || (c == KeyEvent.VK_SPACE) || (c == KeyEvent.VK_DELETE)) {
            evt.consume();
        }
    }//GEN-LAST:event_jtf_phoneKeyTyped

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel avatar_lb;
    private javax.swing.JLabel hello_lb;
    private javax.swing.JButton home_bt;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton jbt_update;
    private javax.swing.JTextField jtf_address;
    private javax.swing.JTextField jtf_email;
    private javax.swing.JTextField jtf_namecompany;
    private javax.swing.JPasswordField jtf_password;
    private javax.swing.JTextField jtf_phone;
    // End of variables declaration//GEN-END:variables
}
