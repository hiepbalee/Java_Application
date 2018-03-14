package org.pnv.project;

import java.awt.Image;
import java.awt.event.KeyEvent;
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

public class CustomerInformationDetail extends javax.swing.JFrame {

    private Connection connect;
    private ResultSet resultset;
    private ResultSetMetaData rsmt;
    private PreparedStatement preparedStatement = null;
    public String username_program;
    public String iduser_program;
    public String idArea;
    public int countRow;

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

    public void showTable() throws SQLException {
        preparedStatement = connect.prepareStatement("SELECT Customer.cus_name,"
                + "Customer.gender,"
                + "Customer.date_of_birth,"
                + "Customer.ID_card,"
                + "Customer.address,"
                + "Customer.phone_number,"
                + "Customer.email_address,"
                + "Area.name_area"
                + "   FROM Customer   JOIN Area ON Customer.area = Area.ID");
        resultset = preparedStatement.executeQuery();
        rsmt = resultset.getMetaData();
        showinfo(rsmt, resultset, jtb_table);
    }

    public void showinfo(ResultSetMetaData rsmt, ResultSet resultset, JTable table) throws SQLException {
        DefaultTableModel model = new DefaultTableModel();
        int demcolumn = rsmt.getColumnCount();
        Object[] nameColumn = new Object[demcolumn];
        for (int i = 0; i < demcolumn; i++) {
            nameColumn[i] = rsmt.getColumnClassName(i + 1);
        }
        nameColumn[0] = "Name";
        nameColumn[1] = "Gender";
        nameColumn[2] = "Birthday";
        nameColumn[3] = "ID card";
        nameColumn[4] = "Address";
        nameColumn[5] = "Phone";
        nameColumn[6] = "Email";
        nameColumn[7] = "Area ";
        table.setModel(model);
        model.setColumnIdentifiers(nameColumn);
        while (resultset.next() != false) {
            Object[] content = new Object[demcolumn];
            for (int i = 0; i < demcolumn; i++) {
                content[i] = resultset.getString(i + 1);
            }
            model.addRow(content);
            show(0);
        }
    }

    public CustomerInformationDetail(String id_user, String name_user) throws SQLException {
        connect = DatabaseHelper.getConnection();
        initComponents();
        username_program = name_user;
        iduser_program = id_user;
        CheckRole();
        hello_lb.setText("Hi, " + FunctionOfProgram.capsText(username_program));
        showTable();
        CheckRole();
        jLabel1.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/org/pnv/image/background3.jpg")).getImage().getScaledInstance(785, 640, Image.SCALE_SMOOTH)));
        this.setLocationRelativeTo(null);
    }

    public static void main(String[] args) throws SQLException, SQLException, SQLException, SQLException, SQLException, SQLException, SQLException {
        CustomerInformationDetail a = new CustomerInformationDetail("1", "s");
        a.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel9 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        avatar_lb = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cus_ID = new javax.swing.JTextField();
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
        jtf_address = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtb_table = new javax.swing.JTable();
        jtf_gender = new javax.swing.JTextField();
        jtf_phone = new javax.swing.JTextField();
        jtf_birthday = new javax.swing.JTextField();
        hello_lb = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Electricity Management");
        setPreferredSize(new java.awt.Dimension(790, 640));
        setResizable(false);
        setSize(new java.awt.Dimension(790, 640));
        getContentPane().setLayout(null);

        jLabel9.setFont(new java.awt.Font("Century Schoolbook", 3, 48)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 153));
        jLabel9.setText("Search Information");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(220, 110, 520, 60);

        jButton8.setFont(new java.awt.Font("Century Schoolbook", 1, 14)); // NOI18N
        jButton8.setText("Go Home");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton8);
        jButton8.setBounds(210, 210, 100, 40);
        getContentPane().add(avatar_lb);
        avatar_lb.setBounds(40, 100, 150, 150);

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel6.setText("ID Card");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(350, 210, 90, 40);

        cus_ID.setFont(new java.awt.Font("Century Schoolbook", 0, 14)); // NOI18N
        cus_ID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cus_IDKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cus_IDKeyTyped(evt);
            }
        });
        getContentPane().add(cus_ID);
        cus_ID.setBounds(460, 210, 260, 40);

        jLabel5.setFont(new java.awt.Font("Century Schoolbook", 1, 14)); // NOI18N
        jLabel5.setText("Customer Name:");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(60, 260, 130, 40);

        jLabel4.setFont(new java.awt.Font("Century Schoolbook", 1, 14)); // NOI18N
        jLabel4.setText("Gender:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(60, 360, 130, 40);

        jtf_name.setEditable(false);
        jtf_name.setFont(new java.awt.Font("Century Schoolbook", 0, 14)); // NOI18N
        getContentPane().add(jtf_name);
        jtf_name.setBounds(210, 260, 180, 40);

        jLabel16.setFont(new java.awt.Font("Century Schoolbook", 1, 14)); // NOI18N
        jLabel16.setText("E-mail");
        getContentPane().add(jLabel16);
        jLabel16.setBounds(340, 360, 80, 40);

        jtf_mail.setEditable(false);
        jtf_mail.setFont(new java.awt.Font("Century Schoolbook", 0, 14)); // NOI18N
        getContentPane().add(jtf_mail);
        jtf_mail.setBounds(430, 360, 290, 40);

        jtf_area.setEditable(false);
        jtf_area.setFont(new java.awt.Font("Century Schoolbook", 0, 14)); // NOI18N
        getContentPane().add(jtf_area);
        jtf_area.setBounds(540, 410, 180, 40);

        jlb_phone.setFont(new java.awt.Font("Century Schoolbook", 1, 14)); // NOI18N
        jlb_phone.setText("Number phone");
        getContentPane().add(jlb_phone);
        jlb_phone.setBounds(410, 310, 120, 40);

        jLabel11.setFont(new java.awt.Font("Century Schoolbook", 1, 14)); // NOI18N
        jLabel11.setText("Area");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(410, 410, 120, 40);

        jLabel7.setFont(new java.awt.Font("Century Schoolbook", 1, 14)); // NOI18N
        jLabel7.setText("Birthday:");
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
        jLabel10.setText("Address:");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(410, 260, 120, 40);

        jtf_address.setEditable(false);
        jtf_address.setFont(new java.awt.Font("Century Schoolbook", 0, 14)); // NOI18N
        jtf_address.setPreferredSize(new java.awt.Dimension(740, 690));
        getContentPane().add(jtf_address);
        jtf_address.setBounds(540, 260, 180, 40);

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
        jScrollPane1.setBounds(20, 470, 740, 100);

        jtf_gender.setEditable(false);
        jtf_gender.setFont(new java.awt.Font("Century Schoolbook", 0, 14)); // NOI18N
        getContentPane().add(jtf_gender);
        jtf_gender.setBounds(210, 360, 110, 40);

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

        hello_lb.setFont(new java.awt.Font("Century Schoolbook", 3, 18)); // NOI18N
        getContentPane().add(hello_lb);
        hello_lb.setBounds(210, 170, 180, 30);

        jLabel1.setFont(new java.awt.Font("Century Schoolbook", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/pnv/image/background3.jpg"))); // NOI18N
        jLabel1.setPreferredSize(new java.awt.Dimension(790, 640));
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 790, 640);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cus_IDKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cus_IDKeyReleased
        try {
            preparedStatement = connect.prepareStatement("SELECT "
                    + "Customer.cus_name, "
                    + "Customer.gender, "
                    + "Customer.date_of_birth, "
                    + "Customer.ID_card, "
                    + "Customer.address, "
                    + "Customer.phone_number, "
                    + "Customer.email_address, "
                    + "Area.name_area "
                    + "   FROM Customer   JOIN Area ON Customer.area = Area.ID AND Customer.ID_card LIKE ?");
            preparedStatement.setString(1, "%" + cus_ID.getText() + "%");
            resultset = preparedStatement.executeQuery();
            rsmt = resultset.getMetaData();
            showinfo(rsmt, resultset, jtb_table);
            if (jtb_table.getRowCount() == 0) {
                jtf_gender.setText(null);
                jtf_name.setText(null);
                jtf_idCard.setText(null);
                jtf_address.setText(null);
                jtf_birthday.setText(null);
                jtf_phone.setText(null);
                jtf_mail.setText(null);
                jtf_area.setText(null);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerInformationDetail.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_cus_IDKeyReleased

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        try {
            ThemeLoginSuccessAdmin adminTheme = new ThemeLoginSuccessAdmin(iduser_program, username_program);
            adminTheme.setVisible(true);
            dispose();
        } catch (SQLException ex) {
            Logger.getLogger(CustomerInformationDetail.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jtb_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtb_tableMouseClicked

        countRow = jtb_table.getSelectedRow();
        show(countRow);

    }//GEN-LAST:event_jtb_tableMouseClicked
    public void show(int countRow) {
        String name = (String) jtb_table.getValueAt(countRow, 0);
        String gender = (String) jtb_table.getValueAt(countRow, 1);
        String birthday = (String) jtb_table.getValueAt(countRow, 2);
        String idCard = (String) jtb_table.getValueAt(countRow, 3);
        String address = (String) jtb_table.getValueAt(countRow, 4);
        String phone = (String) jtb_table.getValueAt(countRow, 5);
        String mail = (String) jtb_table.getValueAt(countRow, 6);
        String area = (String) jtb_table.getValueAt(countRow, 7);
        jtf_gender.setText(gender);
        jtf_name.setText(name);
        jtf_idCard.setText(idCard);
        jtf_address.setText(address);
        jtf_birthday.setText(birthday);
        jtf_phone.setText(phone);
        jtf_mail.setText(mail);
        jtf_area.setText(area);

    }
    private void jtf_phoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtf_phoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_phoneActionPerformed

    private void jtf_birthdayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtf_birthdayActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_birthdayActionPerformed

    private void cus_IDKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cus_IDKeyTyped
        char c = evt.getKeyChar();
        if (!Character.isDigit(c) || (c == KeyEvent.VK_SPACE) || (c == KeyEvent.VK_DELETE)) {
            evt.consume();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_cus_IDKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel avatar_lb;
    private javax.swing.JTextField cus_ID;
    private javax.swing.JLabel hello_lb;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jlb_phone;
    private javax.swing.JTable jtb_table;
    private javax.swing.JTextField jtf_address;
    private javax.swing.JTextField jtf_area;
    private javax.swing.JTextField jtf_birthday;
    private javax.swing.JTextField jtf_gender;
    private javax.swing.JTextField jtf_idCard;
    private javax.swing.JTextField jtf_mail;
    private javax.swing.JTextField jtf_name;
    private javax.swing.JTextField jtf_phone;
    // End of variables declaration//GEN-END:variables
}
