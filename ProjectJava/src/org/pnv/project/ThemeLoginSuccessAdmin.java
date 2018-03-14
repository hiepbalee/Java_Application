package org.pnv.project;

import java.awt.Image;
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

public class ThemeLoginSuccessAdmin extends javax.swing.JFrame {

    private Connection connect;
    private ResultSetMetaData resultsetmetadata;
    private ResultSet resultset;
    private PreparedStatement preparedStatement = null;
    public String username_program;
    public String iduser_program;

    public ThemeLoginSuccessAdmin(String id_user, String name_user) throws SQLException {

        connect = DatabaseHelper.getConnection();
        initComponents();
        content_feedback.setVisible(false);
        jScrollPane2.setVisible(false);
        jScrollPane3.setVisible(false);
        table_feedback.setVisible(false);
        jScrollPane1.setVisible(false);
        viewnotification_bt.setVisible(false);
        uploadnotification_bt.setVisible(false);
        username_program = name_user;
        iduser_program = id_user;
        this.setLocationRelativeTo(null);
        CheckRole();
        hello_lb.setText("Hi, " + FunctionOfProgram.capsText(name_user));
        background_lb.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/org/pnv/image/backgrounds.jpg")).getImage().getScaledInstance(790, 640, Image.SCALE_SMOOTH)));
        background2_lb.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/org/pnv/image/online12.png")).getImage().getScaledInstance(490, 270, Image.SCALE_SMOOTH)));
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
                priceranges_bt.setEnabled(false);
                usersmanagement_bt.setEnabled(false);
                settingapp_bt.setEnabled(false);
            }
        }

    }

    public void ShowTableFeedBack() throws SQLException {

        preparedStatement = connect.prepareStatement("SELECT full_name, rate_app, feedback FROM feedback");
        resultset = preparedStatement.executeQuery();
        resultsetmetadata = resultset.getMetaData();
        DefaultTableModel model = new DefaultTableModel();
        int columnoftable = resultsetmetadata.getColumnCount();
        Object[] title = new Object[columnoftable];
        for (int i = 0; i < columnoftable; i++) {
            title[i] = resultsetmetadata.getColumnName(i + 1);

        }
        title[0] = "Name";
        title[1] = "Rate This App";
        title[2] = "Feedback";
        table_feedback.setModel(model);
        model.setColumnIdentifiers(title);
        int row = 0;
        while (resultset.next() != false) {

            Object[] content = new Object[columnoftable];
            for (int i = 0; i < columnoftable; i++) {
                content[i] = resultset.getString(i + 1);
            }
            model.addRow(content);
        }
        resultset.last();
        row = resultset.getRow();
        resultset.beforeFirst();
        content_feedback.setText(
                  "\n   User name: " + FunctionOfProgram.capsText((String) table_feedback.getValueAt(row - 1, 0))
                + "\n   Rate this app: " + (String) table_feedback.getValueAt(row - 1, 1)
                + "\n   With feedback for program is: " + (String) table_feedback.getValueAt(row - 1, 2));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        avatar_lb = new javax.swing.JLabel();
        upload_bt = new javax.swing.JButton();
        showfeedback_bt = new javax.swing.JButton();
        settingapp_bt = new javax.swing.JButton();
        signout_bt = new javax.swing.JButton();
        usersmanagement_bt = new javax.swing.JButton();
        exit_bt = new javax.swing.JButton();
        hello_lb = new javax.swing.JLabel();
        areasmanagement_bt = new javax.swing.JButton();
        statistical_bt = new javax.swing.JButton();
        payment_bt = new javax.swing.JButton();
        history_bt = new javax.swing.JButton();
        priceranges_bt = new javax.swing.JButton();
        customermanagement_bt = new javax.swing.JButton();
        calculatebill_bt = new javax.swing.JButton();
        background2_lb = new javax.swing.JLabel();
        uploadnotification_bt = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        table_feedback = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        content_feedback = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        viewnotification_bt = new javax.swing.JTextArea();
        background_lb = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Electricity Management");
        setResizable(false);

        jPanel1.setPreferredSize(new java.awt.Dimension(790, 640));
        jPanel1.setLayout(null);
        jPanel1.add(avatar_lb);
        avatar_lb.setBounds(590, 160, 140, 140);

        upload_bt.setFont(new java.awt.Font("Century Schoolbook", 1, 12)); // NOI18N
        upload_bt.setText("Upload the Notification");
        upload_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                upload_btActionPerformed(evt);
            }
        });
        jPanel1.add(upload_bt);
        upload_bt.setBounds(570, 360, 180, 50);

        showfeedback_bt.setFont(new java.awt.Font("Century Schoolbook", 1, 12)); // NOI18N
        showfeedback_bt.setText("Show Feedback");
        showfeedback_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showfeedback_btActionPerformed(evt);
            }
        });
        jPanel1.add(showfeedback_bt);
        showfeedback_bt.setBounds(570, 410, 180, 50);

        settingapp_bt.setFont(new java.awt.Font("Century Schoolbook", 1, 12)); // NOI18N
        settingapp_bt.setText("Setting Application");
        settingapp_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                settingapp_btActionPerformed(evt);
            }
        });
        jPanel1.add(settingapp_bt);
        settingapp_bt.setBounds(570, 310, 180, 50);

        signout_bt.setFont(new java.awt.Font("Century Schoolbook", 1, 12)); // NOI18N
        signout_bt.setText("Sign Out");
        signout_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signout_btActionPerformed(evt);
            }
        });
        jPanel1.add(signout_bt);
        signout_bt.setBounds(570, 460, 180, 50);

        usersmanagement_bt.setFont(new java.awt.Font("Century Schoolbook", 1, 12)); // NOI18N
        usersmanagement_bt.setText("Users Management");
        usersmanagement_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usersmanagement_btActionPerformed(evt);
            }
        });
        jPanel1.add(usersmanagement_bt);
        usersmanagement_bt.setBounds(290, 310, 200, 50);

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

        areasmanagement_bt.setFont(new java.awt.Font("Century Schoolbook", 1, 12)); // NOI18N
        areasmanagement_bt.setText("Areas Management");
        areasmanagement_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                areasmanagement_btActionPerformed(evt);
            }
        });
        jPanel1.add(areasmanagement_bt);
        areasmanagement_bt.setBounds(60, 430, 200, 50);

        statistical_bt.setFont(new java.awt.Font("Century Schoolbook", 1, 12)); // NOI18N
        statistical_bt.setText("Statistical ");
        statistical_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statistical_btActionPerformed(evt);
            }
        });
        jPanel1.add(statistical_bt);
        statistical_bt.setBounds(290, 490, 200, 50);

        payment_bt.setFont(new java.awt.Font("Century Schoolbook", 1, 12)); // NOI18N
        payment_bt.setText("Payment");
        payment_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                payment_btActionPerformed(evt);
            }
        });
        jPanel1.add(payment_bt);
        payment_bt.setBounds(290, 430, 200, 50);

        history_bt.setFont(new java.awt.Font("Century Schoolbook", 1, 12)); // NOI18N
        history_bt.setText("Usage History");
        history_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                history_btActionPerformed(evt);
            }
        });
        jPanel1.add(history_bt);
        history_bt.setBounds(290, 370, 200, 50);

        priceranges_bt.setFont(new java.awt.Font("Century Schoolbook", 1, 12)); // NOI18N
        priceranges_bt.setText("Price Ranges");
        priceranges_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                priceranges_btActionPerformed(evt);
            }
        });
        priceranges_bt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                priceranges_btKeyReleased(evt);
            }
        });
        jPanel1.add(priceranges_bt);
        priceranges_bt.setBounds(60, 310, 200, 50);

        customermanagement_bt.setFont(new java.awt.Font("Century Schoolbook", 1, 12)); // NOI18N
        customermanagement_bt.setText("Customer Management");
        customermanagement_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customermanagement_btActionPerformed(evt);
            }
        });
        jPanel1.add(customermanagement_bt);
        customermanagement_bt.setBounds(60, 490, 200, 50);

        calculatebill_bt.setFont(new java.awt.Font("Century Schoolbook", 1, 12)); // NOI18N
        calculatebill_bt.setText("Calculate Bill");
        calculatebill_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calculatebill_btActionPerformed(evt);
            }
        });
        jPanel1.add(calculatebill_bt);
        calculatebill_bt.setBounds(60, 370, 200, 50);
        jPanel1.add(background2_lb);
        background2_lb.setBounds(30, 290, 490, 270);

        uploadnotification_bt.setFont(new java.awt.Font("Century Schoolbook", 1, 14)); // NOI18N
        uploadnotification_bt.setText("Upload Notification");
        uploadnotification_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uploadnotification_btActionPerformed(evt);
            }
        });
        jPanel1.add(uploadnotification_bt);
        uploadnotification_bt.setBounds(340, 530, 180, 40);

        table_feedback.setFont(new java.awt.Font("Century Schoolbook", 0, 14)); // NOI18N
        table_feedback.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3"
            }
        ));
        table_feedback.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_feedbackMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(table_feedback);

        jPanel1.add(jScrollPane2);
        jScrollPane2.setBounds(30, 250, 490, 170);

        content_feedback.setEditable(false);
        content_feedback.setColumns(20);
        content_feedback.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        content_feedback.setRows(5);
        jScrollPane3.setViewportView(content_feedback);

        jPanel1.add(jScrollPane3);
        jScrollPane3.setBounds(30, 420, 490, 150);

        viewnotification_bt.setColumns(20);
        viewnotification_bt.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        viewnotification_bt.setRows(5);
        viewnotification_bt.setText("Notification from Administator:\n+ ");
        jScrollPane1.setViewportView(viewnotification_bt);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(30, 280, 490, 230);

        background_lb.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/pnv/image/backgrounds.jpg"))); // NOI18N
        background_lb.setPreferredSize(new java.awt.Dimension(790, 640));
        jPanel1.add(background_lb);
        background_lb.setBounds(0, 0, 790, 640);

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

    private void usersmanagement_btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usersmanagement_btActionPerformed

        try {
            ThemeUsers users = new ThemeUsers(iduser_program, username_program);
            FunctionOfProgram.insertHistory(iduser_program, "User: " + username_program + " Users management");
            dispose();
            users.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(ThemeLoginSuccessAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_usersmanagement_btActionPerformed

    private void signout_btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signout_btActionPerformed
        if (signout_bt.getText().equals("Sign Out")) {
            int check = JOptionPane.showConfirmDialog(rootPane, "Are you sure", "Sign Out", JOptionPane.YES_OPTION);
            if (check == JOptionPane.YES_OPTION) {
                ThemeLogin login = new ThemeLogin();
                FunctionOfProgram.insertHistory(iduser_program, username_program + " sign out system");
                dispose();
                login.setVisible(true);
            }
        } else {
            content_feedback.setVisible(false);
            jScrollPane2.setVisible(false);
            jScrollPane3.setVisible(false);
            table_feedback.setVisible(false);
            jScrollPane1.setVisible(false);
            viewnotification_bt.setVisible(false);
            uploadnotification_bt.setVisible(false);
            background2_lb.setVisible(true);
            history_bt.setVisible(true);
            usersmanagement_bt.setVisible(true);
            payment_bt.setVisible(true);
            areasmanagement_bt.setVisible(true);
            statistical_bt.setVisible(true);
            calculatebill_bt.setVisible(true);
            priceranges_bt.setVisible(true);
            customermanagement_bt.setVisible(true);
            signout_bt.setText("Sign Out");
        }

    }//GEN-LAST:event_signout_btActionPerformed

    private void upload_btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_upload_btActionPerformed

        try {
            background2_lb.setVisible(false);
            history_bt.setVisible(false);
            usersmanagement_bt.setVisible(false);
            payment_bt.setVisible(false);
            areasmanagement_bt.setVisible(false);
            statistical_bt.setVisible(false);
            calculatebill_bt.setVisible(false);
            priceranges_bt.setVisible(false);
            customermanagement_bt.setVisible(false);
            jScrollPane3.setVisible(false);
            content_feedback.setVisible(false);
            jScrollPane2.setVisible(false);
            table_feedback.setVisible(false);

            jScrollPane1.setVisible(true);
            viewnotification_bt.setVisible(true);
            viewnotification_bt.setVisible(true);
            uploadnotification_bt.setVisible(true);
            signout_bt.setText("Back Home");
            preparedStatement = connect.prepareStatement("SELECT * FROM Notification LIMIT 1 ");
            resultset = preparedStatement.executeQuery();
            while (resultset.next()) {
                viewnotification_bt.setText(resultset.getString(3));
            }

        } catch (SQLException ex) {
            Logger.getLogger(ThemeLoginSuccessAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_upload_btActionPerformed

    private void uploadnotification_btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uploadnotification_btActionPerformed
        try {
            int check = JOptionPane.showConfirmDialog(rootPane, "Are you sure", "Update Notification", JOptionPane.YES_OPTION);
            if (check == JOptionPane.YES_OPTION) {
                preparedStatement = connect.prepareStatement("UPDATE Notification SET notification_uploaded = ? ");
                preparedStatement.setString(1, viewnotification_bt.getText());
                preparedStatement.executeUpdate();
                JOptionPane.showMessageDialog(rootPane, "The notification updated success!");
            } else {
                JOptionPane.showMessageDialog(rootPane, "The notification hasn't been updated", "Update Notification", JOptionPane.OK_OPTION);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ThemeLoginSuccessAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_uploadnotification_btActionPerformed

    private void exit_btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exit_btActionPerformed
        int check = JOptionPane.showConfirmDialog(rootPane, "Are you sure", "Exit program", JOptionPane.YES_OPTION);
        if (check == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_exit_btActionPerformed

    private void showfeedback_btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showfeedback_btActionPerformed
        try {
            calculatebill_bt.setVisible(false);
            areasmanagement_bt.setVisible(false);
            statistical_bt.setVisible(false);
            priceranges_bt.setVisible(false);
            customermanagement_bt.setVisible(false);
            uploadnotification_bt.setVisible(false);
            history_bt.setVisible(false);
            usersmanagement_bt.setVisible(false);
            payment_bt.setVisible(false);
            jScrollPane3.setVisible(true);
            content_feedback.setVisible(true);
            signout_bt.setText("Back Home");
            jScrollPane2.setVisible(true);
            table_feedback.setVisible(true);
            background2_lb.setVisible(false);
            ShowTableFeedBack();
        } catch (SQLException ex) {
            Logger.getLogger(ThemeLoginSuccessAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_showfeedback_btActionPerformed

    private void table_feedbackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_feedbackMouseClicked
        int row = table_feedback.getSelectedRow();
        content_feedback.setText(""
                + "\n   User name: " + FunctionOfProgram.capsText((String) table_feedback.getValueAt(row, 0))
                + "\n   Rate this app: " + (String) table_feedback.getValueAt(row, 1)
                + "\n   With feedback for program is: " + (String) table_feedback.getValueAt(row, 2));
    }//GEN-LAST:event_table_feedbackMouseClicked

    private void settingapp_btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_settingapp_btActionPerformed
        try {
            SettingApp showTheme = new SettingApp(iduser_program, username_program);
            showTheme.setVisible(true);
            dispose();
        } catch (SQLException ex) {
            Logger.getLogger(ThemeLoginSuccessAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_settingapp_btActionPerformed

    private void areasmanagement_btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_areasmanagement_btActionPerformed
        try {
            Areas areas = new Areas(iduser_program, username_program);
            areas.setVisible(true);
            dispose();
        } catch (SQLException ex) {
            Logger.getLogger(ThemeLoginSuccessAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_areasmanagement_btActionPerformed

    private void priceranges_btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_priceranges_btActionPerformed
        try {
            PriceRanges range = new PriceRanges(iduser_program, username_program);
            range.setVisible(true);
            dispose();
        } catch (SQLException ex) {
            Logger.getLogger(ThemeLoginSuccessAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_priceranges_btActionPerformed

    private void customermanagement_btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customermanagement_btActionPerformed
        try {
            CustomerInformations showTheme = new CustomerInformations(iduser_program, username_program);
            showTheme.setVisible(true);
            dispose();
        } catch (SQLException ex) {
            Logger.getLogger(ThemeLoginSuccessAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_customermanagement_btActionPerformed

    private void calculatebill_btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calculatebill_btActionPerformed
        try {
            CalculaterBill showTheme = new CalculaterBill(iduser_program, username_program);
            showTheme.setVisible(true);
            dispose();
        } catch (SQLException ex) {
            Logger.getLogger(ThemeLoginSuccessAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_calculatebill_btActionPerformed

    private void payment_btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_payment_btActionPerformed
        try {
            PaymentOfCustomer a = new PaymentOfCustomer(iduser_program, username_program);
            a.setVisible(true);
            dispose();
        } catch (SQLException ex) {
            Logger.getLogger(ThemeLoginSuccessAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_payment_btActionPerformed

    private void history_btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_history_btActionPerformed
        try {
            ThemeUserHistory userhistory = new ThemeUserHistory(iduser_program, username_program);
            setVisible(false);
            userhistory.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(ThemeUsers.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_history_btActionPerformed

    private void priceranges_btKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_priceranges_btKeyReleased
        int key = evt.getKeyCode();
        if (key == java.awt.event.KeyEvent.VK_F1) {
            JOptionPane.showMessageDialog(rootPane, "ok baby2");
        }
    }//GEN-LAST:event_priceranges_btKeyReleased

    private void statistical_btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statistical_btActionPerformed
        try {
            ViewPayment showTheme = new ViewPayment(iduser_program, username_program);
            showTheme.setVisible(true);
            dispose();
        } catch (SQLException ex) {
            Logger.getLogger(ThemeLoginSuccessAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_statistical_btActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton areasmanagement_bt;
    private javax.swing.JLabel avatar_lb;
    private javax.swing.JLabel background2_lb;
    private javax.swing.JLabel background_lb;
    private javax.swing.JButton calculatebill_bt;
    private javax.swing.JTextArea content_feedback;
    private javax.swing.JButton customermanagement_bt;
    private javax.swing.JButton exit_bt;
    private javax.swing.JLabel hello_lb;
    private javax.swing.JButton history_bt;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton payment_bt;
    private javax.swing.JButton priceranges_bt;
    private javax.swing.JButton settingapp_bt;
    private javax.swing.JButton showfeedback_bt;
    private javax.swing.JButton signout_bt;
    private javax.swing.JButton statistical_bt;
    private javax.swing.JTable table_feedback;
    private javax.swing.JButton upload_bt;
    private javax.swing.JButton uploadnotification_bt;
    private javax.swing.JButton usersmanagement_bt;
    private javax.swing.JTextArea viewnotification_bt;
    // End of variables declaration//GEN-END:variables

}
