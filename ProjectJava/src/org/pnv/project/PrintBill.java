package org.pnv.project;

import org.pnv.functions.SnapshotExample;
import java.awt.Image;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;
import org.pnv.functions.DatabaseHelper;
import org.pnv.functions.FunctionOfProgram;

public class PrintBill extends javax.swing.JFrame {

    private Connection connect;
    private ResultSet resultset;
    private ResultSetMetaData resultSetMetaData;
    private PreparedStatement preparedStatement = null;
    public String username_program;
    public String iduser_program;
    public String email_jdbc = null;
    public String password_jdbc = null;
    public String monthbill = null;

    public void select1(String Idcus) throws SQLException {

        preparedStatement = connect.prepareStatement("SELECT ID, cus_name,address,email_address ,area FROM Customer WHERE ID= ?");

        preparedStatement.setString(1, Idcus);
        System.out.println(preparedStatement);
        resultset = preparedStatement.executeQuery();
        // String idCus = resultset.getString(1);
        if (resultset.next()) {
            jlb_IDcus.setText(resultset.getString(1));
            jlb_cusName.setText(resultset.getString(2));
            jlb_address.setText(resultset.getString(3));
            jlb_mail.setText(resultset.getString(4));
            jlb_areas.setText(resultset.getString(5));

        }
    }

    public void selectbill(String cusID, String month) throws SQLException {
        System.out.println(cusID);
        String sqlStml = "SELECT ID,index_of_month,  old_number,new_number,indexs,"
                + "into_Money ,vat_tax	, total FROM Indexs where cus_ID = ? and index_of_month = ?";
        preparedStatement = connect.prepareStatement(sqlStml);
        preparedStatement.setString(1, cusID);

        preparedStatement.setString(2, month);

        System.out.println(preparedStatement);
        resultset = preparedStatement.executeQuery();

        resultSetMetaData = resultset.getMetaData();
        DefaultTableModel model = new DefaultTableModel();
        int demcolumn = resultSetMetaData.getColumnCount();
        Object[] nameColumn = new Object[demcolumn];
        for (int i = 0; i < demcolumn; i++) {
            nameColumn[i] = resultSetMetaData.getColumnClassName(i + 1);
        }
        nameColumn[0] = "code";
        nameColumn[1] = "Months";
        nameColumn[2] = "Old number";
        nameColumn[3] = "New number";
        nameColumn[4] = "Indexs";
        nameColumn[5] = "Into Money";
        nameColumn[6] = "VAT TAX";
        nameColumn[7] = "Totals";

        jtb_table.setModel(model);
        model.setColumnIdentifiers(nameColumn);
        while (resultset.next() != false) {
            jlb_codeBill.setText(resultset.getString(1));
            jlb_intoMoney.setText(resultset.getString(6) + "VND");
            jlb_indexs1.setText(resultset.getString(5));
            System.out.println("index" + resultset.getString(5));
            jlb_total.setText(resultset.getString(8) + " VND");
            System.out.println("total" + resultset.getString(8));
            Object[] content = new Object[demcolumn];
            for (int i = 0; i < demcolumn; i++) {
                content[i] = resultset.getString(i + 1);
            }
            model.addRow(content);
        }
        jtb_table.setEnabled(false);
    }

    public PrintBill(String cusID, String month, String id_user, String name_user) throws SQLException {
        connect = DatabaseHelper.getConnection();
        username_program = name_user;
        iduser_program = id_user;
        initComponents();
        CheckRole();
        monthbill = month;
        preparedStatement = connect.prepareStatement("SELECT name_company, numberphone_company, address_company FROM settingapp");
        resultset = preparedStatement.executeQuery();
        if (resultset.next()) {
            company_name.setText(resultset.getString(1));
            numberphone_lb.setText(resultset.getString(2));
            address_lb.setText(resultset.getString(3));
        }
        try {
            select1(cusID);
            selectbill(cusID, month);
        } catch (SQLException ex) {
            Logger.getLogger(PrintBill.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.setLocationRelativeTo(null);
        jLabel1.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/org/pnv/image/background3.jpg")).getImage().getScaledInstance(790, 640, Image.SCALE_SMOOTH)));
    }

    public void CheckRole() throws SQLException {
        preparedStatement = connect.prepareStatement("SELECT role FROM Users WHERE ID = ? LIMIT 1");
        preparedStatement.setString(1, iduser_program);
        resultset = preparedStatement.executeQuery();
        while (resultset.next()) {
            if (resultset.getString(1).equals("Administrator")) {
                back_user.setVisible(false);
                avatar_lb.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/org/pnv/image/admin.png")).getImage().getScaledInstance(140, 140, Image.SCALE_SMOOTH)));
            } else if (resultset.getString(1).equals("Employee")) {
                back_user.setVisible(false);
                avatar_lb.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/org/pnv/image/admin2.png")).getImage().getScaledInstance(140, 140, Image.SCALE_SMOOTH)));
            } else {
                avatar_lb.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/org/pnv/image/customer.png")).getImage().getScaledInstance(140, 140, Image.SCALE_SMOOTH)));
                printf.setVisible(false);
                back.setVisible(false);
                
            }
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jlb_indexs1 = new javax.swing.JLabel();
        jlb_areas4 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jlb_address = new javax.swing.JLabel();
        jlb_intoMoney = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        numberphone_lb = new javax.swing.JLabel();
        jlb_total = new javax.swing.JLabel();
        jlb_IDcus = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jlb_mail = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        address_lb = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jlb_cusName = new javax.swing.JLabel();
        jlb_codeBill = new javax.swing.JLabel();
        jlb_areas = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        company_name = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtb_table = new javax.swing.JTable();
        printf = new javax.swing.JButton();
        back_user = new javax.swing.JButton();
        back = new javax.swing.JButton();
        avatar_lb = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Electricity Management");
        setResizable(false);

        jPanel1.setPreferredSize(new java.awt.Dimension(790, 640));
        jPanel1.setLayout(null);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(null);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/pnv/image/diens.jpg"))); // NOI18N
        jPanel2.add(jLabel2);
        jLabel2.setBounds(20, 10, 122, 122);

        jlb_indexs1.setFont(new java.awt.Font("Century Schoolbook", 1, 14)); // NOI18N
        jlb_indexs1.setForeground(new java.awt.Color(0, 153, 153));
        jPanel2.add(jlb_indexs1);
        jlb_indexs1.setBounds(530, 290, 160, 20);

        jlb_areas4.setFont(new java.awt.Font("Century Schoolbook", 1, 14)); // NOI18N
        jlb_areas4.setForeground(new java.awt.Color(0, 153, 153));
        jlb_areas4.setText("10%");
        jPanel2.add(jlb_areas4);
        jlb_areas4.setBounds(200, 350, 200, 20);

        jLabel18.setFont(new java.awt.Font("Century Schoolbook", 1, 14)); // NOI18N
        jLabel18.setText("Address:");
        jPanel2.add(jLabel18);
        jLabel18.setBounds(30, 260, 130, 20);

        jlb_address.setFont(new java.awt.Font("Century Schoolbook", 1, 14)); // NOI18N
        jlb_address.setForeground(new java.awt.Color(0, 153, 153));
        jPanel2.add(jlb_address);
        jlb_address.setBounds(200, 260, 200, 20);

        jlb_intoMoney.setFont(new java.awt.Font("Century Schoolbook", 1, 14)); // NOI18N
        jlb_intoMoney.setForeground(new java.awt.Color(0, 153, 153));
        jPanel2.add(jlb_intoMoney);
        jlb_intoMoney.setBounds(530, 320, 160, 20);

        jLabel22.setFont(new java.awt.Font("Century Schoolbook", 1, 14)); // NOI18N
        jLabel22.setText("Email Address:");
        jPanel2.add(jLabel22);
        jLabel22.setBounds(30, 230, 130, 20);

        jLabel19.setFont(new java.awt.Font("Century Schoolbook", 1, 14)); // NOI18N
        jLabel19.setText("Area ID:");
        jPanel2.add(jLabel19);
        jLabel19.setBounds(30, 320, 80, 20);

        numberphone_lb.setFont(new java.awt.Font("Century Schoolbook", 1, 14)); // NOI18N
        numberphone_lb.setForeground(new java.awt.Color(0, 153, 153));
        numberphone_lb.setText("01646171725");
        jPanel2.add(numberphone_lb);
        numberphone_lb.setBounds(200, 170, 300, 20);

        jlb_total.setFont(new java.awt.Font("Century Schoolbook", 1, 14)); // NOI18N
        jlb_total.setForeground(new java.awt.Color(0, 153, 153));
        jPanel2.add(jlb_total);
        jlb_total.setBounds(530, 350, 160, 20);

        jlb_IDcus.setFont(new java.awt.Font("Century Schoolbook", 1, 14)); // NOI18N
        jlb_IDcus.setForeground(new java.awt.Color(0, 153, 153));
        jPanel2.add(jlb_IDcus);
        jlb_IDcus.setBounds(200, 290, 200, 20);

        jLabel20.setFont(new java.awt.Font("Century Schoolbook", 1, 14)); // NOI18N
        jLabel20.setText("Customer ID:");
        jPanel2.add(jLabel20);
        jLabel20.setBounds(30, 290, 102, 20);

        jLabel24.setFont(new java.awt.Font("Century Schoolbook", 1, 14)); // NOI18N
        jLabel24.setText("Value-added tax:");
        jPanel2.add(jLabel24);
        jLabel24.setBounds(30, 350, 130, 20);

        jLabel31.setFont(new java.awt.Font("Century Schoolbook", 1, 14)); // NOI18N
        jLabel31.setText("Into money:");
        jPanel2.add(jLabel31);
        jLabel31.setBounds(430, 320, 101, 20);

        jLabel32.setFont(new java.awt.Font("Century Schoolbook", 1, 14)); // NOI18N
        jLabel32.setText("Indexs:");
        jPanel2.add(jLabel32);
        jLabel32.setBounds(430, 290, 90, 20);

        jlb_mail.setFont(new java.awt.Font("Century Schoolbook", 1, 14)); // NOI18N
        jlb_mail.setForeground(new java.awt.Color(0, 153, 153));
        jPanel2.add(jlb_mail);
        jlb_mail.setBounds(200, 230, 485, 20);

        jLabel21.setFont(new java.awt.Font("Century Schoolbook", 1, 14)); // NOI18N
        jLabel21.setText("Total:");
        jPanel2.add(jLabel21);
        jLabel21.setBounds(430, 350, 91, 20);

        jLabel16.setFont(new java.awt.Font("Century Schoolbook", 1, 14)); // NOI18N
        jLabel16.setText("Customer Name:");
        jPanel2.add(jLabel16);
        jLabel16.setBounds(30, 200, 170, 20);

        address_lb.setFont(new java.awt.Font("Century Schoolbook", 1, 14)); // NOI18N
        address_lb.setForeground(new java.awt.Color(0, 153, 153));
        address_lb.setText("02-Thanh Son - Da Nang");
        jPanel2.add(address_lb);
        address_lb.setBounds(200, 140, 300, 17);

        jLabel17.setFont(new java.awt.Font("Century Schoolbook", 1, 14)); // NOI18N
        jLabel17.setText("Phone:");
        jPanel2.add(jLabel17);
        jLabel17.setBounds(30, 170, 130, 20);

        jlb_cusName.setFont(new java.awt.Font("Century Schoolbook", 1, 14)); // NOI18N
        jlb_cusName.setForeground(new java.awt.Color(0, 153, 153));
        jPanel2.add(jlb_cusName);
        jlb_cusName.setBounds(200, 200, 300, 20);

        jlb_codeBill.setFont(new java.awt.Font("Century Schoolbook", 1, 14)); // NOI18N
        jlb_codeBill.setForeground(new java.awt.Color(0, 153, 153));
        jPanel2.add(jlb_codeBill);
        jlb_codeBill.setBounds(530, 260, 160, 20);

        jlb_areas.setFont(new java.awt.Font("Century Schoolbook", 1, 14)); // NOI18N
        jlb_areas.setForeground(new java.awt.Color(0, 153, 153));
        jPanel2.add(jlb_areas);
        jlb_areas.setBounds(200, 320, 200, 20);

        jLabel14.setFont(new java.awt.Font("Century Schoolbook", 1, 14)); // NOI18N
        jLabel14.setText("Address:");
        jPanel2.add(jLabel14);
        jLabel14.setBounds(30, 140, 130, 17);

        jLabel25.setFont(new java.awt.Font("Century Schoolbook", 1, 14)); // NOI18N
        jLabel25.setText("Code Bill:");
        jPanel2.add(jLabel25);
        jLabel25.setBounds(430, 260, 76, 20);

        company_name.setFont(new java.awt.Font("Century Schoolbook", 3, 18)); // NOI18N
        company_name.setText("Da Nang Power Company");
        jPanel2.add(company_name);
        company_name.setBounds(150, 10, 462, 23);

        jLabel9.setFont(new java.awt.Font("Times New Roman", 3, 48)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 153));
        jLabel9.setText("Electricity Bill");
        jPanel2.add(jLabel9);
        jLabel9.setBounds(240, 40, 310, 70);

        jtb_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jtb_table.setIntercellSpacing(new java.awt.Dimension(0, 0));
        jScrollPane2.setViewportView(jtb_table);

        jPanel2.add(jScrollPane2);
        jScrollPane2.setBounds(0, 410, 740, 50);

        printf.setFont(new java.awt.Font("Century Schoolbook", 1, 14)); // NOI18N
        printf.setText("Send Email");
        printf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printfActionPerformed(evt);
            }
        });
        jPanel2.add(printf);
        printf.setBounds(570, 140, 140, 40);

        back_user.setFont(new java.awt.Font("Century Schoolbook", 1, 14)); // NOI18N
        back_user.setText("Back");
        back_user.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                back_userActionPerformed(evt);
            }
        });
        jPanel2.add(back_user);
        back_user.setBounds(570, 140, 140, 40);

        back.setFont(new java.awt.Font("Century Schoolbook", 1, 14)); // NOI18N
        back.setText("Back");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });
        jPanel2.add(back);
        back.setBounds(570, 190, 140, 40);
        jPanel2.add(avatar_lb);
        avatar_lb.setBounds(570, 0, 140, 140);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(20, 110, 740, 460);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/pnv/image/background3.jpg"))); // NOI18N
        jLabel1.setPreferredSize(new java.awt.Dimension(790, 640));
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 780, 640);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 776, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed

        try {
            ThemeLoginSuccessAdmin loginSuccess = new ThemeLoginSuccessAdmin(iduser_program, username_program);
            setVisible(false);
            loginSuccess.setVisible(true);
            dispose();
        } catch (SQLException ex) {
            Logger.getLogger(PrintBill.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_backActionPerformed
    public void selectMail() throws SQLException {
        preparedStatement = connect.prepareStatement("SELECT email_program, password_program FROM settingapp ");
        resultset = preparedStatement.executeQuery();
        if (resultset.next()) {
            email_jdbc = resultset.getString(1);
            password_jdbc = resultset.getString(2);
        }
    }

    public void sendEmail(String EMAIL, String PASSWORD, String email, String namecustomer, String month, String path) {
        String HOST = "mail.smtp.host";
        String COM = "smtp.gmail.com";
        String SOCKETPORT = "mail.smtp.socketFactory.port";
        String SOCKETCLASS = "mail.smtp.socketFactory.class";
        String SOCKETJAVAX = "javax.net.ssl.SSLSocketFactory";
        String AUTH = "mail.smtp.auth";
        String PORT = "mail.smtp.port";
        String TO = email;
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
            message.setFrom(new InternetAddress("EMAIL"));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(TO));
            message.setSubject("Notification from Administrator ( Electricity Bill )");
            BodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setText("Hello " + namecustomer + ",\n\n"
                    + "This is your bill of month : " + month + "\n"
                    + "Please check your information and pay the fastest bill. "
                    + "You can sign in our system to see detail your bill and pay for it. \n"
                    + "\n"
                    + "Thanks,\n"
                    + "Administrator of System.");
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart);
            messageBodyPart = new MimeBodyPart();
            String filename = path;
            DataSource source = new FileDataSource(filename);
            messageBodyPart.setDataHandler(new DataHandler(source));
            messageBodyPart.setFileName("Electricity Bill of Customer.png");
            multipart.addBodyPart(messageBodyPart);
            message.setContent(multipart);
            Transport.send(message);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }

    }
    private void printfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printfActionPerformed

        try {
            avatar_lb.setVisible(false);
            printf.setVisible(false);
            back.setVisible(false);
            back_user.setVisible(false);
            String a = SnapshotExample.makePanelImage(jPanel1);
            selectMail();
            sendEmail(email_jdbc, password_jdbc, jlb_mail.getText(), jlb_cusName.getText(), monthbill, a + ".png");
            printf.setVisible(true);
            back.setVisible(true);
            avatar_lb.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(PrintBill.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_printfActionPerformed

    private void back_userActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_back_userActionPerformed
        try {
            ThemeLoginSuccessUser showTheme = new ThemeLoginSuccessUser(iduser_program, username_program);
            showTheme.setVisible(true);
            dispose();
        } catch (SQLException ex) {
            Logger.getLogger(PrintBill.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_back_userActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel address_lb;
    private javax.swing.JLabel avatar_lb;
    private javax.swing.JButton back;
    private javax.swing.JButton back_user;
    private javax.swing.JLabel company_name;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel jlb_IDcus;
    private javax.swing.JLabel jlb_address;
    private javax.swing.JLabel jlb_areas;
    private javax.swing.JLabel jlb_areas4;
    private javax.swing.JLabel jlb_codeBill;
    private javax.swing.JLabel jlb_cusName;
    private javax.swing.JLabel jlb_indexs1;
    private javax.swing.JLabel jlb_intoMoney;
    private javax.swing.JLabel jlb_mail;
    private javax.swing.JLabel jlb_total;
    private javax.swing.JTable jtb_table;
    private javax.swing.JLabel numberphone_lb;
    private javax.swing.JButton printf;
    // End of variables declaration//GEN-END:variables
}
