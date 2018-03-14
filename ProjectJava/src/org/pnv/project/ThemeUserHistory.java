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
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.pnv.functions.DatabaseHelper;
import org.pnv.functions.FunctionOfProgram;

public class ThemeUserHistory extends javax.swing.JFrame {

    private Connection connect;
    private ResultSet resultset;
    private ResultSetMetaData resultsetmetadata;
    private PreparedStatement preparedStatement = null;
    private String path = null;
    public String username_program;
    public String iduser_program;

    public ThemeUserHistory(String id_user, String name_user) throws SQLException {
        connect = DatabaseHelper.getConnection();
        initComponents();
        username_program = name_user;
        iduser_program = id_user;
        CheckRole();
        name_lb.setText("Hi, " + FunctionOfProgram.capsText(name_user));
        this.setLocationRelativeTo(null);
        ShowTableHistory();
        
    }

    public void CheckRole() throws SQLException {
        preparedStatement = connect.prepareStatement("SELECT role FROM Users WHERE ID = ? LIMIT 1");
        preparedStatement.setString(1, iduser_program);
        resultset = preparedStatement.executeQuery();
        if (resultset.next()) {
            if (resultset.getString(1).equals("Administrator")) {
                avatar_lb.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/org/pnv/image/admin.png")).getImage().getScaledInstance(140, 140, Image.SCALE_SMOOTH)));
            } else {
                avatar_lb.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/org/pnv/image/admin2.png")).getImage().getScaledInstance(140, 140, Image.SCALE_SMOOTH)));
            }
        }

    }

    public void ShowTableHistory() throws SQLException {
        preparedStatement = connect.prepareStatement("SELECT history,time_of_use FROM History ");
        resultset = preparedStatement.executeQuery();
        resultsetmetadata = resultset.getMetaData();
        DefaultTableModel model = new DefaultTableModel();
        int columnoftable = resultsetmetadata.getColumnCount();
        Object[] title = new Object[columnoftable];
        for (int i = 0; i < columnoftable; i++) {
            title[i] = resultsetmetadata.getColumnName(i + 1);
        }
        title[0] = "Date Time";
        title[1] = "History";
        table_history.setModel(model);
        model.setColumnIdentifiers(title);
        while (resultset.next() != false) {
            Object[] content = new Object[columnoftable];
            for (int i = 0; i < columnoftable; i++) {
                content[i] = resultset.getString(i + 1);
            }
            model.addRow(content);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        avatar_lb = new javax.swing.JLabel();
        home_bt = new javax.swing.JButton();
        exit_bt = new javax.swing.JButton();
        delete_bt = new javax.swing.JButton();
        sendEmail_bt = new javax.swing.JButton();
        printf_bt = new javax.swing.JButton();
        name_lb = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_history = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Electricity Management");
        setResizable(false);

        jPanel1.setPreferredSize(new java.awt.Dimension(790, 640));
        jPanel1.setLayout(null);
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

        exit_bt.setFont(new java.awt.Font("Century Schoolbook", 1, 12)); // NOI18N
        exit_bt.setText("Exit");
        exit_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exit_btActionPerformed(evt);
            }
        });
        jPanel1.add(exit_bt);
        exit_bt.setBounds(570, 510, 180, 50);

        delete_bt.setFont(new java.awt.Font("Century Schoolbook", 1, 12)); // NOI18N
        delete_bt.setText("Delete All Data");
        delete_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete_btActionPerformed(evt);
            }
        });
        jPanel1.add(delete_bt);
        delete_bt.setBounds(570, 410, 180, 50);

        sendEmail_bt.setFont(new java.awt.Font("Century Schoolbook", 1, 12)); // NOI18N
        sendEmail_bt.setText("Send Email");
        sendEmail_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendEmail_btActionPerformed(evt);
            }
        });
        jPanel1.add(sendEmail_bt);
        sendEmail_bt.setBounds(570, 360, 180, 50);

        printf_bt.setFont(new java.awt.Font("Century Schoolbook", 1, 12)); // NOI18N
        printf_bt.setText("Print File PDF");
        printf_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printf_btActionPerformed(evt);
            }
        });
        jPanel1.add(printf_bt);
        printf_bt.setBounds(570, 310, 180, 50);

        name_lb.setFont(new java.awt.Font("Century Schoolbook", 3, 16)); // NOI18N
        name_lb.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(name_lb);
        name_lb.setBounds(590, 120, 160, 30);

        table_history.setFont(new java.awt.Font("Century Schoolbook", 0, 12)); // NOI18N
        table_history.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Title 1", "Title 2"
            }
        ));
        jScrollPane1.setViewportView(table_history);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(30, 250, 490, 310);

        jLabel3.setFont(new java.awt.Font("Century Schoolbook", 3, 48)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Usage History");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(70, 120, 360, 59);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/pnv/image/backgrounds.jpg"))); // NOI18N
        jLabel1.setPreferredSize(new java.awt.Dimension(790, 640));
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 790, 640);

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

    private void delete_btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete_btActionPerformed
        try {
            int check = JOptionPane.showConfirmDialog(rootPane, "Delete All Data", "Are you sure delete all data ", JOptionPane.YES_NO_OPTION);
            if (check == JOptionPane.YES_OPTION) {
                preparedStatement = connect.prepareStatement("DELETE FROM History");
                preparedStatement.executeUpdate();
                ShowTableHistory();
            } else {

            }

        } catch (SQLException ex) {
            Logger.getLogger(ThemeUserHistory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_delete_btActionPerformed

    private void home_btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_home_btActionPerformed

        try {
            ThemeLoginSuccessAdmin loginSuccess = new ThemeLoginSuccessAdmin(iduser_program, username_program);
            setVisible(false);
            loginSuccess.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(ThemeUserHistory.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_home_btActionPerformed

    private void sendEmail_btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendEmail_btActionPerformed
        path = null;
        JFileChooser file = new JFileChooser();
        file.setCurrentDirectory(new File(System.getProperty("user.home")));
        int result = file.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            try {
                File selectedFile = file.getSelectedFile();
                path = selectedFile.getAbsolutePath();
                FunctionOfProgram.sendEmailWithAttachment("ariesspeedkun@gmail.com", "Administrator", path);
            } catch (SQLException ex) {
                Logger.getLogger(ThemeUserHistory.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
        }

    }//GEN-LAST:event_sendEmail_btActionPerformed

    private void printf_btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printf_btActionPerformed
        path = FunctionOfProgram.PrintFilePDF(table_history, "Usage History of Program");
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
    }//GEN-LAST:event_printf_btActionPerformed

    private void exit_btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exit_btActionPerformed
        int check = JOptionPane.showConfirmDialog(rootPane, "Are you sure", "Exit program", JOptionPane.YES_OPTION);
        if (check == JOptionPane.YES_OPTION) {
            System.exit(0);
        } else {

        }
    }//GEN-LAST:event_exit_btActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel avatar_lb;
    private javax.swing.JButton delete_bt;
    private javax.swing.JButton exit_bt;
    private javax.swing.JButton home_bt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel name_lb;
    private javax.swing.JButton printf_bt;
    private javax.swing.JButton sendEmail_bt;
    private javax.swing.JTable table_history;
    // End of variables declaration//GEN-END:variables

}
