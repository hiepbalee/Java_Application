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
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.pnv.functions.DatabaseHelper;
import org.pnv.functions.FunctionOfProgram;

public class InformationDetail extends javax.swing.JFrame {

    private Connection connect;
    private ResultSet resultset;
    private ResultSetMetaData rsmt;
    private PreparedStatement preparedStatement = null;
    public String username_program;
    public String iduser_program;

    public InformationDetail(String id_user, String name_user) throws SQLException {
        connect = DatabaseHelper.getConnection();
        initComponents();
        username_program = name_user;
        iduser_program = id_user;
        showInformation(name_user);  
        jLabel1.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/org/pnv/image/background3.jpg")).getImage().getScaledInstance(785, 640, Image.SCALE_SMOOTH)));
        this.setLocationRelativeTo(null);
    }

    public void showInformation(String idCard) throws SQLException {
        preparedStatement = connect.prepareStatement("SELECT "
                + "Customer.cus_name, "
                + "Customer.gender, "
                + "Customer.date_of_birth, "
                + "Customer.ID_card, "
                + "Customer.address, "
                + "Customer.phone_number, "
                + "Customer.email_address, "
                + "Area.name_area "
                + "FROM Customer   JOIN Area ON Customer.area = Area.ID AND Customer.ID_card = ?");
        preparedStatement.setString(1, idCard);
        resultset = preparedStatement.executeQuery();
        if (resultset.next()) {
            jtf_name.setText(resultset.getString(1));
            jtf_gender.setText(resultset.getString(2));
            jtf_birthday.setText(resultset.getString(3));
            jtf_idCard.setText(resultset.getString(4));
            jtf_address.setText(resultset.getString(5));
            jtf_phone.setText(resultset.getString(6));
            jtf_mail.setText(resultset.getString(7));
            jtf_area.setText(resultset.getString(8));
            jtf_username.setText(resultset.getString(4));
        }
    }

    public static void main(String[] args) throws SQLException, SQLException, SQLException, SQLException, SQLException, SQLException, SQLException {
        InformationDetail a = new InformationDetail("1", "s");
        a.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel9 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jtf_name = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jtf_mail = new javax.swing.JTextField();
        jtf_area = new javax.swing.JTextField();
        jlb_phone = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jtf_idCard = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jtf_gender = new javax.swing.JTextField();
        jtf_phone = new javax.swing.JTextField();
        jtf_birthday = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jtf_username = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        avatar_lb = new javax.swing.JLabel();
        jtf_address = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Electricity Management");
        setPreferredSize(new java.awt.Dimension(790, 640));
        setResizable(false);
        setSize(new java.awt.Dimension(790, 640));
        getContentPane().setLayout(null);

        jLabel9.setFont(new java.awt.Font("Century Schoolbook", 3, 48)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 153));
        jLabel9.setText("Profile of Customer");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(250, 120, 490, 60);

        jLabel5.setFont(new java.awt.Font("Century Schoolbook", 1, 14)); // NOI18N
        jLabel5.setText("Customer Name");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(60, 260, 130, 40);

        jLabel4.setFont(new java.awt.Font("Century Schoolbook", 1, 14)); // NOI18N
        jLabel4.setText("Gender");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(60, 360, 130, 40);

        jtf_name.setEditable(false);
        jtf_name.setFont(new java.awt.Font("Century Schoolbook", 0, 14)); // NOI18N
        getContentPane().add(jtf_name);
        jtf_name.setBounds(210, 260, 180, 40);

        jLabel16.setFont(new java.awt.Font("Century Schoolbook", 1, 14)); // NOI18N
        jLabel16.setText("E-mail");
        getContentPane().add(jLabel16);
        jLabel16.setBounds(60, 460, 130, 40);

        jtf_mail.setEditable(false);
        jtf_mail.setFont(new java.awt.Font("Century Schoolbook", 0, 14)); // NOI18N
        getContentPane().add(jtf_mail);
        jtf_mail.setBounds(210, 460, 310, 40);

        jtf_area.setEditable(false);
        jtf_area.setFont(new java.awt.Font("Century Schoolbook", 0, 14)); // NOI18N
        getContentPane().add(jtf_area);
        jtf_area.setBounds(540, 360, 180, 40);

        jlb_phone.setFont(new java.awt.Font("Century Schoolbook", 1, 14)); // NOI18N
        jlb_phone.setText("Number Phone");
        getContentPane().add(jlb_phone);
        jlb_phone.setBounds(410, 310, 120, 40);

        jLabel11.setFont(new java.awt.Font("Century Schoolbook", 1, 14)); // NOI18N
        jLabel11.setText("Area");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(410, 360, 120, 40);

        jLabel7.setFont(new java.awt.Font("Century Schoolbook", 1, 14)); // NOI18N
        jLabel7.setText("Birthday");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(60, 410, 130, 40);

        jLabel3.setFont(new java.awt.Font("Century Schoolbook", 1, 14)); // NOI18N
        jLabel3.setText("ID Card");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(60, 310, 140, 40);

        jtf_idCard.setEditable(false);
        jtf_idCard.setFont(new java.awt.Font("Century Schoolbook", 0, 14)); // NOI18N
        getContentPane().add(jtf_idCard);
        jtf_idCard.setBounds(210, 310, 180, 40);

        jLabel10.setFont(new java.awt.Font("Century Schoolbook", 1, 14)); // NOI18N
        jLabel10.setText("Address");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(410, 260, 120, 40);

        jtf_gender.setEditable(false);
        jtf_gender.setFont(new java.awt.Font("Century Schoolbook", 0, 14)); // NOI18N
        getContentPane().add(jtf_gender);
        jtf_gender.setBounds(210, 360, 180, 40);

        jtf_phone.setEditable(false);
        jtf_phone.setFont(new java.awt.Font("Century Schoolbook", 0, 14)); // NOI18N
        jtf_phone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtf_phoneActionPerformed(evt);
            }
        });
        getContentPane().add(jtf_phone);
        jtf_phone.setBounds(540, 310, 180, 40);

        jtf_birthday.setEditable(false);
        jtf_birthday.setFont(new java.awt.Font("Century Schoolbook", 0, 14)); // NOI18N
        jtf_birthday.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtf_birthdayActionPerformed(evt);
            }
        });
        getContentPane().add(jtf_birthday);
        jtf_birthday.setBounds(210, 410, 180, 40);

        jLabel12.setFont(new java.awt.Font("Century Schoolbook", 1, 14)); // NOI18N
        jLabel12.setText("User Name");
        getContentPane().add(jLabel12);
        jLabel12.setBounds(410, 410, 120, 40);

        jtf_username.setEditable(false);
        jtf_username.setFont(new java.awt.Font("Century Schoolbook", 0, 14)); // NOI18N
        getContentPane().add(jtf_username);
        jtf_username.setBounds(540, 410, 180, 40);

        jButton1.setFont(new java.awt.Font("Century Schoolbook", 1, 14)); // NOI18N
        jButton1.setText("Go Home");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(540, 460, 180, 40);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(null);
        jPanel1.add(avatar_lb);
        avatar_lb.setBounds(30, 20, 140, 140);

        jtf_address.setEditable(false);
        jtf_address.setFont(new java.awt.Font("Century Schoolbook", 0, 14)); // NOI18N
        jtf_address.setPreferredSize(new java.awt.Dimension(740, 690));
        jPanel1.add(jtf_address);
        jtf_address.setBounds(520, 180, 180, 40);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(20, 80, 730, 490);

        jLabel1.setFont(new java.awt.Font("Century Schoolbook", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/pnv/image/background3.jpg"))); // NOI18N
        jLabel1.setPreferredSize(new java.awt.Dimension(790, 640));
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 790, 640);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtf_phoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtf_phoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_phoneActionPerformed

    private void jtf_birthdayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtf_birthdayActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_birthdayActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            ThemeLoginSuccessUser showTheme = new ThemeLoginSuccessUser(iduser_program, username_program);
            showTheme.setVisible(true);
            dispose();
        } catch (SQLException ex) {
            Logger.getLogger(ViewPayment.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel avatar_lb;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel jlb_phone;
    private javax.swing.JTextField jtf_address;
    private javax.swing.JTextField jtf_area;
    private javax.swing.JTextField jtf_birthday;
    private javax.swing.JTextField jtf_gender;
    private javax.swing.JTextField jtf_idCard;
    private javax.swing.JTextField jtf_mail;
    private javax.swing.JTextField jtf_name;
    private javax.swing.JTextField jtf_phone;
    private javax.swing.JTextField jtf_username;
    // End of variables declaration//GEN-END:variables
}
