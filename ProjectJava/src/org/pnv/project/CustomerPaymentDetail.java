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
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.pnv.functions.DatabaseHelper;
import org.pnv.functions.FunctionOfProgram;

public class CustomerPaymentDetail extends javax.swing.JFrame {

    private Connection connect;
    private ResultSet resultset;
    private ResultSetMetaData rsmt;
    private PreparedStatement preparedStatement = null;
    public String username_program;
    public String iduser_program;
    public String area;
    public String idArea;
    public String query_jdbc;

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

    public void displayTable(String id) throws SQLException {
        preparedStatement = connect.prepareStatement("SELECT Customer.cus_name, "
                + "Customer.ID_card, "
                + "Customer.address, "
                + "Customer.phone_number, "
                + "Customer.email_address, "
                + "Area.name_area, "
                + "indexs.payment FROM indexs "
                + "JOIN customer "
                + "ON Indexs.cus_ID = Customer.ID and indexs.payment = ? "
                + "JOIN area "
                + "ON Area.ID = ? AND Customer.area = ?");
        preparedStatement.setString(1, query_jdbc);
        preparedStatement.setString(2, id);
        preparedStatement.setString(3, id);
        resultset = preparedStatement.executeQuery();
        rsmt = resultset.getMetaData();
        DefaultTableModel model = new DefaultTableModel();
        int demcolumn = rsmt.getColumnCount();
        Object[] nameColumn = new Object[demcolumn];
        for (int i = 0; i < demcolumn; i++) {
            nameColumn[i] = rsmt.getColumnClassName(i + 1);
        }
        nameColumn[0] = "ID Area";
        nameColumn[1] = "Name Area";
        nameColumn[2] = "Full Name";
        nameColumn[3] = "ID Card";
        nameColumn[4] = "Address";
        nameColumn[5] = "Phone";
        nameColumn[6] = "Email";
        jtb_table.setModel(model);
        model.setColumnIdentifiers(nameColumn);
        while (resultset.next() != false) {
            Object[] content = new Object[demcolumn];
            for (int i = 0; i < demcolumn; i++) {
                content[i] = resultset.getString(i + 1);
            }
            model.addRow(content);
        }

    }

    public void showTable() {
        try {
            preparedStatement = connect.prepareStatement("SELECT Customer.cus_name, "
                    + "Customer.ID_card, "
                    + "Customer.address, "
                    + "Customer.phone_number, "
                    + "Customer.email_address, "
                    + "Area.name_area, "
                    + "indexs.payment FROM indexs "
                    + "JOIN customer "
                    + "ON Indexs.cus_ID = Customer.ID and indexs.payment = ? "
                    + "JOIN area "
                    + "ON Area.ID = Customer.area");
            preparedStatement.setString(1, query_jdbc);
            resultset = preparedStatement.executeQuery();
            rsmt = resultset.getMetaData();
            DefaultTableModel model = new DefaultTableModel();
            int demcolumn = rsmt.getColumnCount();
            Object[] nameColumn = new Object[demcolumn];
            for (int i = 0; i < demcolumn; i++) {
                nameColumn[i] = rsmt.getColumnClassName(i + 1);
            }
            nameColumn[0] = "ID Area";
            nameColumn[1] = "Name Area";
            nameColumn[2] = "Full Name";
            nameColumn[3] = "ID Card";
            nameColumn[4] = "Address";
            nameColumn[5] = "Phone";
            nameColumn[6] = "Email";
            jtb_table.setModel(model);
            model.setColumnIdentifiers(nameColumn);
            while (resultset.next() != false) {
                Object[] content = new Object[demcolumn];
                for (int i = 0; i < demcolumn; i++) {
                    content[i] = resultset.getString(i + 1);
                }
                model.addRow(content);
            }

        } catch (SQLException ex) {
            Logger.getLogger(CustomerPaymentDetail.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public CustomerPaymentDetail(String id_user, String name_user, String query) throws SQLException {
        connect = DatabaseHelper.getConnection();
        initComponents();
        if (query.equals("Unsubmit")) {
            bt_sendnotificationemail.setVisible(true);
        } else {
            bt_sendnotificationemail.setVisible(false);
        }
        username_program = name_user;
        iduser_program = id_user;
        CheckRole();
        query_jdbc = query;
        hello_lb.setText("Hi, " + FunctionOfProgram.capsText(username_program));
        showTable();
        preparedStatement = connect.prepareStatement("SELECT name_area FROM Area");
        resultset = preparedStatement.executeQuery();
        resultset.last();
        resultset.beforeFirst();
        while (resultset.next()) {
            cbb_area.addItem(resultset.getString(1));
        }
        jLabel1.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/org/pnv/image/background3.jpg")).getImage().getScaledInstance(785, 640, Image.SCALE_SMOOTH)));
        this.setLocationRelativeTo(null);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtb_table = new javax.swing.JTable();
        jButton7 = new javax.swing.JButton();
        bt_sendnotificationemail = new javax.swing.JButton();
        avatar_lb = new javax.swing.JLabel();
        cbb_area = new javax.swing.JComboBox();
        jButton9 = new javax.swing.JButton();
        hello_lb = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Electricity Management");
        setPreferredSize(new java.awt.Dimension(790, 640));
        setResizable(false);
        setSize(new java.awt.Dimension(790, 640));
        getContentPane().setLayout(null);

        jLabel9.setFont(new java.awt.Font("Century Schoolbook", 3, 36)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 153));
        jLabel9.setText("Payment Detail of Customer");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(220, 100, 540, 60);

        jtb_table.setFont(new java.awt.Font("Century Schoolbook", 0, 13)); // NOI18N
        jtb_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "", "", "", "", "", "", ""
            }
        ));
        jtb_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtb_tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtb_table);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(20, 290, 740, 290);

        jButton7.setFont(new java.awt.Font("Century Schoolbook", 1, 12)); // NOI18N
        jButton7.setText("Print File PDF");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton7);
        jButton7.setBounds(220, 190, 160, 40);

        bt_sendnotificationemail.setFont(new java.awt.Font("Century Schoolbook", 1, 12)); // NOI18N
        bt_sendnotificationemail.setText("Send Mail to Customer");
        bt_sendnotificationemail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_sendnotificationemailActionPerformed(evt);
            }
        });
        getContentPane().add(bt_sendnotificationemail);
        bt_sendnotificationemail.setBounds(450, 240, 290, 40);
        getContentPane().add(avatar_lb);
        avatar_lb.setBounds(40, 110, 170, 170);

        cbb_area.setFont(new java.awt.Font("Century Schoolbook", 1, 14)); // NOI18N
        cbb_area.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "All Areas" }));
        cbb_area.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbb_areaItemStateChanged(evt);
            }
        });
        getContentPane().add(cbb_area);
        cbb_area.setBounds(560, 190, 180, 40);

        jButton9.setFont(new java.awt.Font("Century Schoolbook", 1, 12)); // NOI18N
        jButton9.setText("Go Home");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton9);
        jButton9.setBounds(220, 240, 160, 40);

        hello_lb.setFont(new java.awt.Font("Century Schoolbook", 3, 18)); // NOI18N
        getContentPane().add(hello_lb);
        hello_lb.setBounds(220, 150, 190, 30);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel2.setText("Name Area:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(450, 190, 100, 40);

        jLabel1.setFont(new java.awt.Font("Century Schoolbook", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/pnv/image/background3.jpg"))); // NOI18N
        jLabel1.setPreferredSize(new java.awt.Dimension(790, 640));
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 790, 640);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtb_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtb_tableMouseClicked


    }//GEN-LAST:event_jtb_tableMouseClicked

    private void cbb_areaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbb_areaItemStateChanged
        try {
            area = (String) cbb_area.getSelectedItem();
            if (area.equals("All Areas")) {
                showTable();

            } else {
                preparedStatement = connect.prepareStatement("SELECT ID FROM Area WHERE name_area = ?");
                preparedStatement.setString(1, area);
                resultset = preparedStatement.executeQuery();
                while (resultset.next()) {
                    area = null;
                    area = resultset.getString(1);
                    displayTable(area);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerPaymentDetail.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cbb_areaItemStateChanged

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        String path = FunctionOfProgram.PrintFilePDF(jtb_table, "The List Customer Information");
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
    }//GEN-LAST:event_jButton7ActionPerformed
    public boolean sendEmail(String EMAIL, String PASSWORD, String email) {
        boolean isError = true;
        String HOST = "mail.smtp.host";
        String COM = "smtp.gmail.com";
        String SOCKETPORT = "mail.smtp.socketFactory.port";
        String SOCKETCLASS = "mail.smtp.socketFactory.class";
        String SOCKETJAVAX = "javax.net.ssl.SSLSocketFactory";
        String AUTH = "mail.smtp.auth";
        String PORT = "mail.smtp.port";
        // String TO = email;
        Properties props = new Properties();
        props.put(HOST, COM);
        props.put(SOCKETPORT, "465");
        props.put(SOCKETCLASS, SOCKETJAVAX);
        props.put(AUTH, "true");
        props.put(PORT, "465");
        Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(EMAIL, PASSWORD);
            }
        });
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress("EMAIL"));// change accordingly
            message.addRecipients(Message.RecipientType.BCC, InternetAddress.parse(email));
            message.setSubject("Notification for Customer ( Payment Bill) ");
            message.setText("Hello Customer,\n\n"
                    + "Please check your bill and please pay your electricity bill. \n"
                    + "Thanks,\n\n"
                    + "Administrator of System.");
            Transport.send(message);
        } catch (MessagingException e) {
            isError = false;
        }
        return isError;
    }
    private void bt_sendnotificationemailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_sendnotificationemailActionPerformed
        try {
            String email_jdbc = null;
            String password_jdbc = null;
            preparedStatement = connect.prepareStatement("SELECT email_program, password_program FROM settingapp ");
            resultset = preparedStatement.executeQuery();
            if (resultset.next()) {
                email_jdbc = resultset.getString(1);
                password_jdbc = resultset.getString(2);
            }
            int countmail = 0;
            String mailbcc = "";
            preparedStatement = connect.prepareStatement("SELECT Customer.email_address "
                    + "FROM indexs "
                    + "JOIN customer "
                    + "ON Indexs.cus_ID = Customer.ID "
                    + "AND Indexs.payment = ? "
                    + "JOIN area ON Area.ID = Customer.area");
            preparedStatement.setString(1, "unsubmit");
            resultset = preparedStatement.executeQuery();
            resultset.last();
            int totalmail = resultset.getRow();
            resultset.beforeFirst();
            while (resultset.next()) {
                countmail++;
                if (countmail > 1 && countmail <= totalmail) {
                    mailbcc = mailbcc + "," + resultset.getString(1);
                } else {
                    mailbcc = mailbcc + resultset.getString(1);
                }

            }
            if (sendEmail(email_jdbc, password_jdbc, mailbcc) == true) {
                JOptionPane.showMessageDialog(rootPane, "Send Email Success!");
            } else {
                JOptionPane.showMessageDialog(rootPane, "Send Email Fail!");
            }

        } catch (SQLException ex) {
            Logger.getLogger(CustomerPaymentDetail.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_bt_sendnotificationemailActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        try {
            ThemeLoginSuccessAdmin showTheme = new ThemeLoginSuccessAdmin(iduser_program, username_program);
            showTheme.setVisible(true);
            dispose();
        } catch (SQLException ex) {
            Logger.getLogger(ViewPayment.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton9ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel avatar_lb;
    private javax.swing.JButton bt_sendnotificationemail;
    private javax.swing.JComboBox cbb_area;
    private javax.swing.JLabel hello_lb;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtb_table;
    // End of variables declaration//GEN-END:variables
}
