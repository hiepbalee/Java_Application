package org.pnv.project;

import com.sun.glass.events.KeyEvent;
import java.awt.Image;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;
import org.pnv.functions.DatabaseHelper;
import org.pnv.functions.FunctionOfProgram;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

public class CustomerInformations extends javax.swing.JFrame {

    private Connection connect;
    private ResultSet resultset;
    private ResultSetMetaData rsmt;
    private PreparedStatement preparedStatement = null;
    public String username_program;
    public String iduser_program;
    public String area;
    public String idArea;
    private String idCus = null;
    private String idChangeUser = null;
    private String email_jdbc = null;
    private String password_jdbc = null;

    public void displayTable() throws SQLException {
        String sqlStml = "SELECT Customer.ID,"
                + "Customer.cus_name,"
                + "Customer.gender,"
                + "Customer.date_of_birth,"
                + "Customer.ID_card,"
                + "Customer.address,"
                + "Customer.phone_number,"
                + "Customer.email_address,"
                + "Area.name_area "
                + "FROM Customer JOIN Area ON Customer.area = Area.ID";
        resultset = preparedStatement.executeQuery(sqlStml);
        rsmt = resultset.getMetaData();
        DefaultTableModel model = new DefaultTableModel();
        int demcolumn = rsmt.getColumnCount();
        Object[] nameColumn = new Object[demcolumn];
        for (int i = 0; i < demcolumn; i++) {
            nameColumn[i] = rsmt.getColumnClassName(i + 1);
        }
        nameColumn[0] = "ID";
        nameColumn[1] = "Name";
        nameColumn[2] = "Gender";
        nameColumn[3] = "Birthday";
        nameColumn[4] = "ID card";
        nameColumn[5] = "Address";
        nameColumn[6] = "Phone";
        nameColumn[7] = "Email";
        nameColumn[8] = "Area ";
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

    public CustomerInformations(String id_user, String name_user) throws SQLException {
        connect = DatabaseHelper.getConnection();
        initComponents();
        username_program = name_user;
        iduser_program = id_user;
        preparedStatement = connect.prepareStatement("SELECT name_area FROM Area");
        resultset = preparedStatement.executeQuery();
        resultset.last();
        resultset.beforeFirst();
        while (resultset.next()) {
            jcb_area.addItem(resultset.getString(1));
        }
        jLabel1.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/org/pnv/image/background3.jpg")).getImage().getScaledInstance(785, 640, Image.SCALE_SMOOTH)));
        this.setLocationRelativeTo(null);
        displayTable();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel9 = new javax.swing.JLabel();
        jtf_name = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jlb_checkname = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jcb_gender = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jDateChooser_birth = new com.toedter.calendar.JDateChooser();
        jtf_idCard = new javax.swing.JTextField();
        jlb_checkidcard = new javax.swing.JLabel();
        jbt_searching = new javax.swing.JButton();
        jbt_gohome = new javax.swing.JButton();
        jbt_exit = new javax.swing.JButton();
        jcb_area = new javax.swing.JComboBox();
        jLabel11 = new javax.swing.JLabel();
        jlb_phone = new javax.swing.JLabel();
        jlb_checkPhone = new javax.swing.JLabel();
        jtf_phone = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jtf_mail = new javax.swing.JTextField();
        jlb_checkmail = new javax.swing.JLabel();
        jtf_address = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jlb_checkaddress = new javax.swing.JLabel();
        jbt_add = new javax.swing.JButton();
        jbt_update = new javax.swing.JButton();
        jbt_delete = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtb_table = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Electricity Management");
        setMinimumSize(new java.awt.Dimension(790, 640));
        setResizable(false);
        setSize(new java.awt.Dimension(790, 640));
        getContentPane().setLayout(null);

        jLabel9.setFont(new java.awt.Font("Century Schoolbook", 3, 40)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 153));
        jLabel9.setText("Enter The Data of Customer");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(160, 90, 590, 40);

        jtf_name.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtf_nameKeyReleased(evt);
            }
        });
        getContentPane().add(jtf_name);
        jtf_name.setBounds(200, 160, 180, 30);

        jLabel5.setFont(new java.awt.Font("Century Schoolbook", 1, 14)); // NOI18N
        jLabel5.setText("Customer Name:");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(60, 160, 130, 30);

        jlb_checkname.setFont(new java.awt.Font("Century Schoolbook", 1, 12)); // NOI18N
        jlb_checkname.setForeground(new java.awt.Color(255, 0, 0));
        getContentPane().add(jlb_checkname);
        jlb_checkname.setBounds(200, 190, 180, 30);

        jLabel4.setFont(new java.awt.Font("Century Schoolbook", 1, 14)); // NOI18N
        jLabel4.setText("Gender:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(60, 220, 130, 30);

        jcb_gender.setFont(new java.awt.Font("Century Schoolbook", 1, 12)); // NOI18N
        jcb_gender.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Male", "Female" }));
        getContentPane().add(jcb_gender);
        jcb_gender.setBounds(200, 220, 180, 30);

        jLabel3.setFont(new java.awt.Font("Century Schoolbook", 1, 14)); // NOI18N
        jLabel3.setText("ID Card");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(60, 340, 130, 30);

        jDateChooser_birth.setDateFormatString("dd-MM-yyyy");
        jDateChooser_birth.setFont(new java.awt.Font("Century Schoolbook", 1, 12)); // NOI18N
        jDateChooser_birth.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jDateChooser_birthMouseClicked(evt);
            }
        });
        getContentPane().add(jDateChooser_birth);
        jDateChooser_birth.setBounds(200, 280, 180, 30);

        jtf_idCard.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtf_idCardKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtf_idCardKeyTyped(evt);
            }
        });
        getContentPane().add(jtf_idCard);
        jtf_idCard.setBounds(200, 340, 180, 30);

        jlb_checkidcard.setFont(new java.awt.Font("Century Schoolbook", 1, 12)); // NOI18N
        jlb_checkidcard.setForeground(new java.awt.Color(255, 0, 0));
        getContentPane().add(jlb_checkidcard);
        jlb_checkidcard.setBounds(200, 370, 180, 30);

        jbt_searching.setFont(new java.awt.Font("Century Schoolbook", 1, 14)); // NOI18N
        jbt_searching.setText("Search");
        jbt_searching.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbt_searchingActionPerformed(evt);
            }
        });
        getContentPane().add(jbt_searching);
        jbt_searching.setBounds(410, 400, 100, 40);

        jbt_gohome.setFont(new java.awt.Font("Century Schoolbook", 1, 14)); // NOI18N
        jbt_gohome.setText("Go Home");
        jbt_gohome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbt_gohomeActionPerformed(evt);
            }
        });
        getContentPane().add(jbt_gohome);
        jbt_gohome.setBounds(630, 400, 100, 40);

        jbt_exit.setFont(new java.awt.Font("Century Schoolbook", 1, 14)); // NOI18N
        jbt_exit.setText("Area");
        jbt_exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbt_exitActionPerformed(evt);
            }
        });
        getContentPane().add(jbt_exit);
        jbt_exit.setBounds(520, 400, 100, 40);

        jcb_area.setFont(new java.awt.Font("Century Schoolbook", 1, 12)); // NOI18N
        jcb_area.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcb_areaItemStateChanged(evt);
            }
        });
        getContentPane().add(jcb_area);
        jcb_area.setBounds(560, 280, 170, 30);

        jLabel11.setFont(new java.awt.Font("Century Schoolbook", 1, 14)); // NOI18N
        jLabel11.setText("Area");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(410, 280, 140, 30);

        jlb_phone.setFont(new java.awt.Font("Century Schoolbook", 1, 14)); // NOI18N
        jlb_phone.setText("Number phone");
        getContentPane().add(jlb_phone);
        jlb_phone.setBounds(410, 220, 140, 30);

        jlb_checkPhone.setFont(new java.awt.Font("Century Schoolbook", 1, 12)); // NOI18N
        jlb_checkPhone.setForeground(new java.awt.Color(255, 0, 0));
        getContentPane().add(jlb_checkPhone);
        jlb_checkPhone.setBounds(560, 250, 170, 30);

        jtf_phone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtf_phoneKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtf_phoneKeyTyped(evt);
            }
        });
        getContentPane().add(jtf_phone);
        jtf_phone.setBounds(560, 220, 170, 30);

        jLabel16.setFont(new java.awt.Font("Century Schoolbook", 1, 14)); // NOI18N
        jLabel16.setText("E-mail");
        getContentPane().add(jLabel16);
        jLabel16.setBounds(410, 160, 140, 30);

        jtf_mail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtf_mailKeyReleased(evt);
            }
        });
        getContentPane().add(jtf_mail);
        jtf_mail.setBounds(560, 160, 170, 30);

        jlb_checkmail.setFont(new java.awt.Font("Century Schoolbook", 1, 12)); // NOI18N
        jlb_checkmail.setForeground(new java.awt.Color(255, 0, 0));
        getContentPane().add(jlb_checkmail);
        jlb_checkmail.setBounds(560, 190, 170, 30);

        jtf_address.setPreferredSize(new java.awt.Dimension(740, 690));
        jtf_address.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtf_addressKeyReleased(evt);
            }
        });
        getContentPane().add(jtf_address);
        jtf_address.setBounds(200, 400, 180, 30);

        jLabel10.setFont(new java.awt.Font("Century Schoolbook", 1, 14)); // NOI18N
        jLabel10.setText("Address:");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(60, 400, 130, 30);

        jlb_checkaddress.setFont(new java.awt.Font("Century Schoolbook", 1, 12)); // NOI18N
        jlb_checkaddress.setForeground(new java.awt.Color(255, 0, 0));
        getContentPane().add(jlb_checkaddress);
        jlb_checkaddress.setBounds(200, 430, 180, 30);

        jbt_add.setFont(new java.awt.Font("Century Schoolbook", 1, 14)); // NOI18N
        jbt_add.setText("Add");
        jbt_add.setEnabled(false);
        jbt_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbt_addActionPerformed(evt);
            }
        });
        getContentPane().add(jbt_add);
        jbt_add.setBounds(410, 340, 100, 40);

        jbt_update.setFont(new java.awt.Font("Century Schoolbook", 1, 14)); // NOI18N
        jbt_update.setText("Update");
        jbt_update.setEnabled(false);
        jbt_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbt_updateActionPerformed(evt);
            }
        });
        getContentPane().add(jbt_update);
        jbt_update.setBounds(520, 340, 100, 40);

        jbt_delete.setFont(new java.awt.Font("Century Schoolbook", 1, 14)); // NOI18N
        jbt_delete.setText("Delete");
        jbt_delete.setEnabled(false);
        jbt_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbt_deleteActionPerformed(evt);
            }
        });
        getContentPane().add(jbt_delete);
        jbt_delete.setBounds(630, 340, 100, 40);

        jtb_table.setFont(new java.awt.Font("Century Schoolbook", 1, 12)); // NOI18N
        jtb_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "CusID", "Customer Name", "Gender", "Birthday", "ID card ", "Address", "Address email", "Number phone", "Area"
            }
        ));
        jtb_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtb_tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtb_table);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(20, 460, 740, 120);

        jLabel7.setFont(new java.awt.Font("Century Schoolbook", 1, 14)); // NOI18N
        jLabel7.setText("Birthday:");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(60, 280, 130, 30);

        jLabel1.setFont(new java.awt.Font("Century Schoolbook", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/pnv/image/background3.jpg"))); // NOI18N
        jLabel1.setMaximumSize(new java.awt.Dimension(790, 640));
        jLabel1.setMinimumSize(new java.awt.Dimension(790, 640));
        jLabel1.setPreferredSize(new java.awt.Dimension(790, 640));
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 790, 640);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtf_nameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_nameKeyReleased

        char[] number = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        String stringName = jtf_name.getText();
        char charOfString[] = stringName.toCharArray();
        for (int i = 0; i < charOfString.length; i++) {
            for (int j = 0; j < number.length; j++) {
                if (charOfString[i] == number[j]) {
                    jlb_checkname.setText("Id mustn't have digits");
                    jtf_name.setText(null);
                } else {
                    jlb_checkname.setText(null);
                }
            }
        }
    }//GEN-LAST:event_jtf_nameKeyReleased

    private void jDateChooser_birthMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jDateChooser_birthMouseClicked
        jDateChooser_birth.getDate();
        String dateInput = new SimpleDateFormat("yyyy-MM-dd").format(jDateChooser_birth);
    }//GEN-LAST:event_jDateChooser_birthMouseClicked

    private void jtf_idCardKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_idCardKeyReleased

        try {
            preparedStatement = connect.prepareStatement("SELECT ID_card FROM Customer WHERE ID_card = ?");
            preparedStatement.setString(1, jtf_idCard.getText());
            resultset = preparedStatement.executeQuery();
            if (!resultset.first()) {
                jbt_add.setEnabled(true);
                jlb_checkidcard.setText(null);
            } else {
                jbt_add.setEnabled(false);
                jlb_checkidcard.setText("ID card already exists!");
            }

        } catch (SQLException ex) {
            Logger.getLogger(CustomerInformations.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jtf_idCardKeyReleased

    private void jbt_searchingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbt_searchingActionPerformed
        try {
            CustomerInformationDetail loginSuccess = new CustomerInformationDetail(iduser_program, username_program);
            setVisible(false);
            loginSuccess.setVisible(true);
            dispose();
        } catch (SQLException ex) {
            Logger.getLogger(CustomerInformations.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jbt_searchingActionPerformed

    private void jbt_gohomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbt_gohomeActionPerformed
        try {
            ThemeLoginSuccessAdmin loginSuccess = new ThemeLoginSuccessAdmin(iduser_program, username_program);
            setVisible(false);
            loginSuccess.setVisible(true);
            dispose();
        } catch (SQLException ex) {
            Logger.getLogger(CustomerInformations.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jbt_gohomeActionPerformed

    private void jbt_exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbt_exitActionPerformed
        try {
            Areas areas = new Areas(iduser_program, username_program);
            areas.setVisible(true);
            dispose();
        } catch (SQLException ex) {
            Logger.getLogger(ThemeLoginSuccessAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jbt_exitActionPerformed

    private void jtf_phoneKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_phoneKeyReleased

        try {
            char c = evt.getKeyChar();
            if (!Character.isDigit(c) || (c == KeyEvent.VK_SPACE) || (c == KeyEvent.VK_DELETE)) {
                evt.consume();
            }

            preparedStatement = connect.prepareStatement("SELECT phone_number  FROM Customer WHERE phone_number= ?");
            preparedStatement.setString(1, jtf_phone.getText());
            resultset = preparedStatement.executeQuery();
            if (!resultset.first()) {
                jbt_add.setEnabled(true);
                jbt_update.setEnabled(true);
                jbt_delete.setEnabled(true);
                jlb_checkPhone.setText(null);
            } else {
                jbt_add.setEnabled(false);
                jbt_delete.setEnabled(false);
                jbt_update.setEnabled(false);
                jlb_checkPhone.setText("Phone number exists!");

            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerInformations.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            jtf_phone.setText(null);
        }
    }//GEN-LAST:event_jtf_phoneKeyReleased

    private void jtf_mailKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_mailKeyReleased
        try {
            resultset = preparedStatement.executeQuery("SELECT email_address FROM Customer LIMIT 1 ");
            if (resultset.next()) {
                String mail = resultset.getString(1);
                if ((jtf_mail.getText().equals(mail))) {
                    jbt_add.setEnabled(false);
                    jbt_update.setEnabled(false);
                    jbt_delete.setEnabled(false);
                    jlb_checkmail.setText(" Your email exists !");
                } else {
                    jbt_add.setEnabled(true);
                    jbt_update.setEnabled(true);
                    jbt_delete.setEnabled(true);
                    jlb_checkmail.setText("");
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerInformations.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jtf_mailKeyReleased

    private void jtf_addressKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_addressKeyReleased
        try {
            resultset = preparedStatement.executeQuery("SELECT address FROM Customer LIMIT 1 ");
            if (resultset.next()) {
                String address = resultset.getString(1);
                if ((jtf_address.getText().equals(address))) {
                    jlb_checkaddress.setText(" Your address already exists!");
                    jbt_add.setEnabled(false);
                    jbt_update.setEnabled(false);
                    jbt_delete.setEnabled(false);
                } else {
                    jlb_checkaddress.setText("");
                    jbt_add.setEnabled(true);
                    jbt_update.setEnabled(true);
                    jbt_delete.setEnabled(true);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerInformations.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jtf_addressKeyReleased

    private void jtb_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtb_tableMouseClicked
        try {
            int b = jtb_table.getSelectedRow();
            SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
            Date dateBirth = null;
            try {
                dateBirth = date.parse((String) jtb_table.getValueAt(b, 3));
            } catch (ParseException ex) {
                Logger.getLogger(CustomerInformations.class.getName()).log(Level.SEVERE, null, ex);
            }
            jDateChooser_birth.setDate(dateBirth);
            idCus = (String) jtb_table.getValueAt(b, 0);
            String name = (String) jtb_table.getValueAt(b, 1);
            String gender = (String) jtb_table.getValueAt(b, 2);
            String idCard = (String) jtb_table.getValueAt(b, 4);
            String address = (String) jtb_table.getValueAt(b, 5);
            String phone = (String) jtb_table.getValueAt(b, 6);
            String mail = (String) jtb_table.getValueAt(b, 7);
            getId(idCard);
            area = (String) jtb_table.getValueAt(b, 8);
            jcb_gender.setSelectedItem(gender);
            jtf_name.setText(name);
            jtf_idCard.setText(idCard);
            jtf_address.setText(address);
            jtf_phone.setText(phone);
            jtf_mail.setText(mail);
            jcb_area.setSelectedItem(area);
            jbt_add.setEnabled(false);
            jbt_update.setEnabled(true);
            jbt_delete.setEnabled(true);
            jlb_checkname.setText(null);
            jlb_checkaddress.setText(null);
            jlb_checkidcard.setText(null);
            jlb_checkmail.setText(null);
            jlb_checkPhone.setText(null);
        } catch (SQLException ex) {
            Logger.getLogger(CustomerInformations.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jtb_tableMouseClicked
    public void getId(String user_name) throws SQLException {
        preparedStatement = connect.prepareStatement("SELECT ID FROM Users WHERE user_name = ? ");
        preparedStatement.setString(1, user_name);
        resultset = preparedStatement.executeQuery();
        if (resultset.first()) {
            idChangeUser = resultset.getString(1);
        }
    }

    public boolean sendEmail(String EMAIL, String PASSWORD, String cusname, String gender, String birthday, String idcard, String address, String email, String numberphone, String area, String content) {
        boolean isError = true;
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
            message.setFrom(new InternetAddress("EMAIL"));// change accordingly
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(TO));
            message.setSubject("Notification for Customer " + content);
            message.setText("Hello " + cusname + ",\n\n"
                    + "Your information has been updated in the system as follows:\n"
                    + "----------------------------------------------------------------------------------------------------------\n"
                    + "  - Customer Name: " + cusname + "\n"
                    + "  - Gender: " + gender + "\n"
                    + "  - Birthday: " + birthday + "\n"
                    + "  - ID Card: " + idcard + "\n"
                    + "  - Address: " + address + "\n"
                    + "  - Email: " + email + "\n"
                    + "  - Number Phone: " + numberphone + "\n"
                    + "  - Area: " + area + "\n"
                    + "----------------------------------------------------------------------------------------------------------\n"
                    + "Please check your information, (if any) please contact the administrator to change your exact information. \n"
                    + "To log into the system, this is your default account and password:\n"
                    + "----------------------------------------------------------------------------------------------------------\n"
                    + "  - Username: " + idcard + "\n"
                    + "  - Password: " + birthday + "\n"
                    + " ----------------------------------------------------------------------------------------------------------\n"
                    + "\n"
                    + "Thanks,\n"
                    + "Administrator of System.");
            Transport.send(message);
        } catch (MessagingException e) {
            isError = false;
        }
        return isError;
    }

    public void selectMail() throws SQLException {
        preparedStatement = connect.prepareStatement("SELECT email_program, password_program FROM settingapp ");
        resultset = preparedStatement.executeQuery();
        if (resultset.next()) {
            email_jdbc = resultset.getString(1);
            password_jdbc = resultset.getString(2);
        }
    }
    private void jbt_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbt_addActionPerformed

        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String dateBirth = dateFormat.format(jDateChooser_birth.getDate());
            selectMail();
            if (sendEmail(email_jdbc, password_jdbc, String.valueOf(FunctionOfProgram.capsText(jtf_name.getText())), (String) jcb_gender.getSelectedItem().toString(), dateBirth, jtf_idCard.getText(), String.valueOf(FunctionOfProgram.capsText(jtf_address.getText())), jtf_mail.getText(), jtf_phone.getText(), jcb_area.getSelectedItem().toString(), " ( Add Customer Information Success )") == true) {

                preparedStatement = connect.prepareStatement("INSERT INTO Customer (cus_name, "
                        + "gender, "
                        + "date_of_birth ,"
                        + "ID_card,address, "
                        + "phone_number, "
                        + "email_address, "
                        + "area) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?)");
                preparedStatement.setString(1, String.valueOf(FunctionOfProgram.capsText(jtf_name.getText())));
                preparedStatement.setString(2, (String) jcb_gender.getSelectedItem().toString());
                preparedStatement.setString(3, dateBirth);
                preparedStatement.setString(4, jtf_idCard.getText());
                preparedStatement.setString(5, jtf_address.getText());
                preparedStatement.setString(6, jtf_phone.getText());
                preparedStatement.setString(7, jtf_mail.getText());
                preparedStatement.setString(8, idArea);
                preparedStatement.executeUpdate();
                displayTable();
                JOptionPane.showMessageDialog(rootPane, "Add customer information success !!");
                JOptionPane.showMessageDialog(rootPane, "Email sent successfully !!");
                preparedStatement = connect.prepareStatement("INSERT INTO Users ( user_name, user_password , role) VALUES ( ?, ?, ? )");
                preparedStatement.setString(1, jtf_idCard.getText());
                preparedStatement.setString(2, FunctionOfProgram.getMD5(dateBirth));
                preparedStatement.setString(3, "Customer");
                preparedStatement.executeUpdate();
                jbt_add.setEnabled(false);
                jtf_name.setText(null);
                jcb_gender.setSelectedItem(null);
                jtf_idCard.setText(null);
                jtf_address.setText(null);
                jtf_mail.setText(null);
                jtf_phone.setText(null);
                jcb_area.setSelectedItem(null);
            } else {
                JOptionPane.showMessageDialog(rootPane, "Enter the data have problem \n Please check again !!");
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerInformations.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jbt_addActionPerformed

    private void jbt_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbt_updateActionPerformed

        if (jtf_phone.getText().length() < 9 || jtf_phone.getText().length() > 13) {
            jtf_phone.setText(null);
            jlb_checkPhone.setText(" Phone number not wrong!");

        }
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String dateBirth = dateFormat.format(jDateChooser_birth.getDate());
            selectMail();
            if (sendEmail(email_jdbc, password_jdbc, String.valueOf(FunctionOfProgram.capsText(jtf_name.getText())), (String) jcb_gender.getSelectedItem().toString(), dateBirth, jtf_idCard.getText(), String.valueOf(FunctionOfProgram.capsText(jtf_address.getText())), jtf_mail.getText(), jtf_phone.getText(), jcb_area.getSelectedItem().toString(), " ( Updated Customer Information Success )") == true) {

                preparedStatement = connect.prepareStatement("UPDATE Customer SET  cus_name=?,"
                        + "gender=?,date_of_birth=?,ID_card=?,"
                        + "address=?,phone_number=?, email_address=?,"
                        + "area=?WHERE ID=?");
                preparedStatement.setString(9, idCus);
                preparedStatement.setString(1, String.valueOf(FunctionOfProgram.capsText(jtf_name.getText())));
                preparedStatement.setString(2, (String) jcb_gender.getSelectedItem().toString());
                preparedStatement.setString(3, dateBirth);
                preparedStatement.setString(4, jtf_idCard.getText());
                preparedStatement.setString(5, String.valueOf(FunctionOfProgram.capsText(jtf_address.getText())));
                preparedStatement.setString(6, jtf_phone.getText());
                preparedStatement.setString(7, jtf_mail.getText());
                preparedStatement.setString(8, idArea);
                preparedStatement.executeUpdate();
                displayTable();
                JOptionPane.showMessageDialog(rootPane, "Updated customer information success !!");
                JOptionPane.showMessageDialog(rootPane, "Email sent successfully!!");
                preparedStatement = connect.prepareStatement("UPDATE Users SET user_name= ?,  user_password = ? WHERE ID = ?");
                preparedStatement.setString(3, idChangeUser);
                preparedStatement.setString(1, jtf_idCard.getText());
                preparedStatement.setString(2, FunctionOfProgram.getMD5(dateBirth));
                preparedStatement.executeUpdate();
                jbt_update.setEnabled(false);
                jbt_delete.setEnabled(false);
                jtf_name.setText(null);
                jcb_gender.setSelectedItem(null);
                jtf_idCard.setText(null);
                jtf_address.setText(null);
                jtf_mail.setText(null);
                jtf_phone.setText(null);
                jcb_area.setSelectedItem(null);
            } else {
                JOptionPane.showMessageDialog(rootPane, "Enter the data have problem \n Please check again !!");
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerInformations.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jbt_updateActionPerformed

    private void jbt_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbt_deleteActionPerformed

       try {
            preparedStatement = connect.prepareStatement("SELECT * FROM Indexs ");
            resultset = preparedStatement.executeQuery();
            if (resultset.next()) {
                preparedStatement = connect.prepareStatement("DELETE FROM Indexs  WHERE ID = ?");
                preparedStatement.setString(1, idCus);
                preparedStatement.executeUpdate();
                preparedStatement = connect.prepareStatement("DELETE FROM Customer  WHERE ID = ?");
                preparedStatement.setString(1, idCus);
                preparedStatement.executeUpdate();
                preparedStatement = connect.prepareStatement("DELETE FROM Users WHERE ID = ?");
                preparedStatement.setString(1, idChangeUser);
                System.out.println(preparedStatement);
                preparedStatement.executeUpdate();
                displayTable();
            } else {
                preparedStatement = connect.prepareStatement("DELETE FROM Customer  WHERE ID = ?");
                preparedStatement.setString(1, idCus);
                preparedStatement.executeUpdate();
                preparedStatement = connect.prepareStatement("DELETE FROM Users WHERE ID = ?");
                preparedStatement.setString(1, idChangeUser);
                System.out.println(preparedStatement);
                preparedStatement.executeUpdate();
                displayTable();
            }
            jbt_update.setEnabled(false);
            jbt_delete.setEnabled(false);
            jtf_name.setText(null);
            jcb_gender.setSelectedItem(null);
            jtf_idCard.setText(null);
            jtf_address.setText(null);
            jtf_mail.setText(null);
            jcb_area.setSelectedItem(null);
            jtf_phone.setText(null);

        } catch (SQLException ex) {
            System.out.println("k xoa dc");
        }
    }//GEN-LAST:event_jbt_deleteActionPerformed

    private void jcb_areaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcb_areaItemStateChanged
        idArea = String.valueOf(jcb_area.getSelectedIndex() + 1);
    }//GEN-LAST:event_jcb_areaItemStateChanged

    private void jtf_idCardKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_idCardKeyTyped
        char c = evt.getKeyChar();
        if (!Character.isDigit(c) || (c == KeyEvent.VK_SPACE) || (c == KeyEvent.VK_DELETE)) {
            evt.consume();
        }
    }//GEN-LAST:event_jtf_idCardKeyTyped

    private void jtf_phoneKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_phoneKeyTyped
        char c = evt.getKeyChar();
        if (!Character.isDigit(c) || (c == KeyEvent.VK_SPACE) || (c == KeyEvent.VK_DELETE)) {
            evt.consume();
        }
    }//GEN-LAST:event_jtf_phoneKeyTyped

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser jDateChooser_birth;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbt_add;
    private javax.swing.JButton jbt_delete;
    private javax.swing.JButton jbt_exit;
    private javax.swing.JButton jbt_gohome;
    private javax.swing.JButton jbt_searching;
    private javax.swing.JButton jbt_update;
    private javax.swing.JComboBox jcb_area;
    private javax.swing.JComboBox jcb_gender;
    private javax.swing.JLabel jlb_checkPhone;
    private javax.swing.JLabel jlb_checkaddress;
    private javax.swing.JLabel jlb_checkidcard;
    private javax.swing.JLabel jlb_checkmail;
    private javax.swing.JLabel jlb_checkname;
    private javax.swing.JLabel jlb_phone;
    private javax.swing.JTable jtb_table;
    private javax.swing.JTextField jtf_address;
    private javax.swing.JTextField jtf_idCard;
    private javax.swing.JTextField jtf_mail;
    private javax.swing.JTextField jtf_name;
    private javax.swing.JTextField jtf_phone;
    // End of variables declaration//GEN-END:variables
}
