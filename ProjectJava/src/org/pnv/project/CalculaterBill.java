package org.pnv.project;

import java.awt.Image;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.pnv.functions.DatabaseHelper;
import org.pnv.functions.FunctionOfProgram;

public class CalculaterBill extends javax.swing.JFrame {

    private Connection connect;
    private ResultSet resultset;
    private ResultSetMetaData resultSetMetaData;
    private PreparedStatement preparedStatement = null;
    private String iduser_table;
    public String username_program;
    public String iduser_program;
    public String idIndex;
    public int totalmoney = 0;
    public int power = 0;
    public int money = 0;
    public int moneytax = 0;
    public int total = 0;
    Integer news = 0;
    Integer old = 0;
    public String month;
    public String cusID;

    public void displayTable() throws SQLException {
        resultset = preparedStatement.executeQuery("SELECT ID, index_of_month, cus_ID, old_number, new_number, indexs, into_money, vat_tax, total FROM Indexs");
        resultSetMetaData = resultset.getMetaData();
        DefaultTableModel model = new DefaultTableModel();
        int demcolumn = resultSetMetaData.getColumnCount();
        Object[] nameColumn = new Object[demcolumn];
        for (int i = 0; i < demcolumn; i++) {
            nameColumn[i] = resultSetMetaData.getColumnClassName(i + 1);
        }
        nameColumn[0] = "Code Bill";
        nameColumn[1] = "Months";
        nameColumn[2] = "Customer ID";
        nameColumn[3] = "Old Index";
        nameColumn[4] = "New Index";
        nameColumn[5] = "Indexs";
        nameColumn[6] = "Into Money";
        nameColumn[7] = "VAT Tax";
        nameColumn[8] = "Total";

        jtable_Caculater.setModel(model);
        model.setColumnIdentifiers(nameColumn);
        while (resultset.next() != false) {
            Object[] content = new Object[demcolumn];
            for (int i = 0; i < demcolumn; i++) {
                content[i] = resultset.getString(i + 1);
            }
            model.addRow(content);
        }
    }

    public CalculaterBill(String id_user, String name_user) throws SQLException {
        initComponents();
        connect = DatabaseHelper.getConnection();
        username_program = name_user;
        iduser_program = id_user;
        hello_lb.setText("Hi, " + FunctionOfProgram.capsText(username_program));
        CheckRole();
        this.setLocationRelativeTo(null);
        jLabel1.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/org/pnv/image/backgrounds.jpg")).getImage().getScaledInstance(790, 640, Image.SCALE_SMOOTH)));
        displayTable();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jtf_cus = new javax.swing.JTextField();
        jtf_IntoMoney = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jtf_VatTax = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jtf_old = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jtf_new = new javax.swing.JTextField();
        jtf_index = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jtf_total = new javax.swing.JTextField();
        delete_jbt = new javax.swing.JButton();
        add_jbt = new javax.swing.JButton();
        update_jbt = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtable_Caculater = new javax.swing.JTable();
        jbt_calculater = new javax.swing.JButton();
        avatar_lb = new javax.swing.JLabel();
        hello_lb = new javax.swing.JLabel();
        printbill_bt = new javax.swing.JButton();
        statistical_bt = new javax.swing.JButton();
        payment_bt = new javax.swing.JButton();
        gohome_bt = new javax.swing.JButton();
        exit = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        noti = new javax.swing.JLabel();
        month_cbx = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Electricity Management");
        setPreferredSize(new java.awt.Dimension(790, 640));
        setSize(new java.awt.Dimension(790, 640));
        getContentPane().setLayout(null);

        jLabel10.setFont(new java.awt.Font("Century Schoolbook", 3, 36)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Calculator Electricity Bill");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(30, 110, 490, 40);

        jLabel11.setFont(new java.awt.Font("Century Schoolbook", 3, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Enter The Electricity Indicaror");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(120, 150, 390, 40);

        jLabel4.setFont(new java.awt.Font("Century Schoolbook", 1, 16)); // NOI18N
        jLabel4.setText("Month");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(30, 400, 110, 30);

        jtf_cus.setFont(new java.awt.Font("Century Schoolbook", 0, 12)); // NOI18N
        jtf_cus.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtf_cusKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtf_cusKeyTyped(evt);
            }
        });
        getContentPane().add(jtf_cus);
        jtf_cus.setBounds(150, 280, 120, 30);

        jtf_IntoMoney.setEditable(false);
        jtf_IntoMoney.setFont(new java.awt.Font("Century Schoolbook", 0, 12)); // NOI18N
        getContentPane().add(jtf_IntoMoney);
        jtf_IntoMoney.setBounds(400, 320, 120, 30);

        jLabel14.setFont(new java.awt.Font("Century Schoolbook", 1, 16)); // NOI18N
        jLabel14.setText("Into Money");
        getContentPane().add(jLabel14);
        jLabel14.setBounds(280, 320, 110, 30);

        jtf_VatTax.setEditable(false);
        jtf_VatTax.setFont(new java.awt.Font("Century Schoolbook", 0, 12)); // NOI18N
        getContentPane().add(jtf_VatTax);
        jtf_VatTax.setBounds(400, 360, 120, 30);

        jLabel12.setFont(new java.awt.Font("Century Schoolbook", 1, 16)); // NOI18N
        jLabel12.setText("VAT Tax");
        getContentPane().add(jLabel12);
        jLabel12.setBounds(280, 360, 110, 30);

        jtf_old.setFont(new java.awt.Font("Century Schoolbook", 0, 12)); // NOI18N
        jtf_old.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtf_oldKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtf_oldKeyTyped(evt);
            }
        });
        getContentPane().add(jtf_old);
        jtf_old.setBounds(150, 320, 120, 30);

        jLabel6.setFont(new java.awt.Font("Century Schoolbook", 1, 16)); // NOI18N
        jLabel6.setText("Old number");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(30, 320, 110, 30);

        jLabel7.setFont(new java.awt.Font("Century Schoolbook", 1, 16)); // NOI18N
        jLabel7.setText("New number");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(30, 360, 110, 30);

        jtf_new.setFont(new java.awt.Font("Century Schoolbook", 0, 12)); // NOI18N
        jtf_new.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtf_newKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtf_newKeyTyped(evt);
            }
        });
        getContentPane().add(jtf_new);
        jtf_new.setBounds(150, 360, 120, 30);

        jtf_index.setEditable(false);
        jtf_index.setFont(new java.awt.Font("Century Schoolbook", 0, 12)); // NOI18N
        getContentPane().add(jtf_index);
        jtf_index.setBounds(400, 280, 120, 30);

        jLabel8.setFont(new java.awt.Font("Century Schoolbook", 1, 16)); // NOI18N
        jLabel8.setText("Total");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(280, 400, 110, 30);

        jtf_total.setEditable(false);
        jtf_total.setFont(new java.awt.Font("Century Schoolbook", 0, 12)); // NOI18N
        getContentPane().add(jtf_total);
        jtf_total.setBounds(400, 400, 120, 30);

        delete_jbt.setFont(new java.awt.Font("Century Schoolbook", 1, 12)); // NOI18N
        delete_jbt.setForeground(new java.awt.Color(51, 51, 255));
        delete_jbt.setText("Delete");
        delete_jbt.setEnabled(false);
        delete_jbt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete_jbtActionPerformed(evt);
            }
        });
        getContentPane().add(delete_jbt);
        delete_jbt.setBounds(470, 440, 80, 40);

        add_jbt.setFont(new java.awt.Font("Century Schoolbook", 1, 12)); // NOI18N
        add_jbt.setForeground(new java.awt.Color(51, 51, 255));
        add_jbt.setText("Add");
        add_jbt.setEnabled(false);
        add_jbt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_jbtActionPerformed(evt);
            }
        });
        getContentPane().add(add_jbt);
        add_jbt.setBounds(290, 440, 80, 40);

        update_jbt.setFont(new java.awt.Font("Century Schoolbook", 1, 12)); // NOI18N
        update_jbt.setForeground(new java.awt.Color(51, 51, 255));
        update_jbt.setText("Update");
        update_jbt.setEnabled(false);
        update_jbt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                update_jbtActionPerformed(evt);
            }
        });
        getContentPane().add(update_jbt);
        update_jbt.setBounds(380, 440, 80, 40);

        jtable_Caculater.setFont(new java.awt.Font("Century Schoolbook", 1, 12)); // NOI18N
        jtable_Caculater.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Code", "Customer ID", "Old number", "New number", "Power consumer", "Total"
            }
        ));
        jtable_Caculater.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtable_CaculaterMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtable_Caculater);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(20, 490, 530, 80);

        jbt_calculater.setFont(new java.awt.Font("Century Schoolbook", 1, 12)); // NOI18N
        jbt_calculater.setText("Calculate");
        jbt_calculater.setEnabled(false);
        jbt_calculater.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbt_calculaterActionPerformed(evt);
            }
        });
        getContentPane().add(jbt_calculater);
        jbt_calculater.setBounds(150, 440, 120, 40);
        getContentPane().add(avatar_lb);
        avatar_lb.setBounds(590, 160, 140, 140);

        hello_lb.setFont(new java.awt.Font("Century Schoolbook", 3, 16)); // NOI18N
        hello_lb.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(hello_lb);
        hello_lb.setBounds(590, 120, 160, 30);

        printbill_bt.setFont(new java.awt.Font("Century Schoolbook", 1, 12)); // NOI18N
        printbill_bt.setText("View and Print Bill");
        printbill_bt.setEnabled(false);
        printbill_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printbill_btActionPerformed(evt);
            }
        });
        getContentPane().add(printbill_bt);
        printbill_bt.setBounds(570, 310, 180, 50);

        statistical_bt.setFont(new java.awt.Font("Century Schoolbook", 1, 12)); // NOI18N
        statistical_bt.setText("Statistical ");
        statistical_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statistical_btActionPerformed(evt);
            }
        });
        getContentPane().add(statistical_bt);
        statistical_bt.setBounds(570, 360, 180, 50);

        payment_bt.setFont(new java.awt.Font("Century Schoolbook", 1, 12)); // NOI18N
        payment_bt.setText("Payment");
        payment_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                payment_btActionPerformed(evt);
            }
        });
        getContentPane().add(payment_bt);
        payment_bt.setBounds(570, 410, 180, 50);

        gohome_bt.setFont(new java.awt.Font("Century Schoolbook", 1, 12)); // NOI18N
        gohome_bt.setText("Go Home");
        gohome_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gohome_btActionPerformed(evt);
            }
        });
        getContentPane().add(gohome_bt);
        gohome_bt.setBounds(570, 460, 180, 50);

        exit.setFont(new java.awt.Font("Century Schoolbook", 1, 12)); // NOI18N
        exit.setText("Exit");
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });
        getContentPane().add(exit);
        exit.setBounds(570, 510, 180, 50);

        jLabel15.setFont(new java.awt.Font("Century Schoolbook", 1, 16)); // NOI18N
        jLabel15.setText("Index ");
        getContentPane().add(jLabel15);
        jLabel15.setBounds(280, 280, 110, 30);

        jLabel9.setFont(new java.awt.Font("Century Schoolbook", 1, 16)); // NOI18N
        jLabel9.setText("Customer ID");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(30, 280, 110, 30);

        noti.setFont(new java.awt.Font("Century Schoolbook", 1, 18)); // NOI18N
        noti.setForeground(new java.awt.Color(255, 0, 0));
        getContentPane().add(noti);
        noti.setBounds(30, 240, 490, 30);

        month_cbx.setFont(new java.awt.Font("Century Schoolbook", 1, 12)); // NOI18N
        month_cbx.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "January", "Frebuary", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" }));
        getContentPane().add(month_cbx);
        month_cbx.setBounds(150, 400, 120, 30);

        jLabel1.setFont(new java.awt.Font("Century Schoolbook", 0, 12)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/pnv/image/backgrounds.jpg"))); // NOI18N
        jLabel1.setPreferredSize(new java.awt.Dimension(790, 640));
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 790, 640);

        pack();
    }// </editor-fold>//GEN-END:initComponents
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
    private void update_jbtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_update_jbtActionPerformed
        try {
            preparedStatement = connect.prepareStatement("UPDATE Indexs SET index_of_month = ?, "
                    + "cus_ID = ?, "
                    + "old_number = ?, "
                    + "new_number = ?, "
                    + "indexs= ? , "
                    + "into_money = ?,"
                    + "vat_tax = ?, "
                    + "total = ? WHERE ID = ?");
            preparedStatement.setString(9, idIndex);
            preparedStatement.setString(1, String.valueOf(month_cbx.getSelectedIndex() + 1));
            preparedStatement.setString(2, jtf_cus.getText());
            preparedStatement.setString(3, jtf_old.getText());
            preparedStatement.setString(4, jtf_new.getText());
            preparedStatement.setString(5, jtf_index.getText());
            preparedStatement.setString(6, String.valueOf(money));
            preparedStatement.setString(7, String.valueOf(moneytax));
            preparedStatement.setString(8, String.valueOf(total));
            preparedStatement.executeUpdate();
            displayTable();
            jtf_cus.setText(null);
            jtf_old.setText(null);
            jtf_new.setText(null);
            jtf_index.setText(null);
            jtf_IntoMoney.setText(null);
            jtf_VatTax.setText(null);
            jtf_total.setText(null);
            update_jbt.setEnabled(false);
            delete_jbt.setEnabled(false);
            jbt_calculater.setEnabled(true);
        } catch (SQLException ex) {
            Logger.getLogger(CalculaterBill.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_update_jbtActionPerformed

    private void jtable_CaculaterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtable_CaculaterMouseClicked
        int row = jtable_Caculater.getSelectedRow();
        iduser_table = (String) jtable_Caculater.getValueAt(row, 0);
        idIndex = (String) jtable_Caculater.getValueAt(row, 0);
        month = (String) jtable_Caculater.getValueAt(row, 1);
        cusID = (String) jtable_Caculater.getValueAt(row, 2);
        String old = (String) jtable_Caculater.getValueAt(row, 3);
        String news = (String) jtable_Caculater.getValueAt(row, 4);
        String indexs = (String) jtable_Caculater.getValueAt(row, 5);
        String into = (String) jtable_Caculater.getValueAt(row, 6);
        String vatTax = (String) jtable_Caculater.getValueAt(row, 7);
        String total = (String) jtable_Caculater.getValueAt(row, 8);
        jtf_cus.setText(cusID);
        jtf_old.setText(old);
        jtf_new.setText(news);
        jtf_index.setText(indexs);
        jtf_IntoMoney.setText(into);
        jtf_VatTax.setText(vatTax);
        jtf_total.setText(total);
        jbt_calculater.setEnabled(false);
        add_jbt.setEnabled(false);
        update_jbt.setEnabled(true);
        delete_jbt.setEnabled(true);
        printbill_bt.setEnabled(true);
    }//GEN-LAST:event_jtable_CaculaterMouseClicked
    public void check(String a, String b) throws SQLException {
        preparedStatement = connect.prepareStatement("SELECT index_of_month, cus_ID FROM Indexs WHERE index_of_month = ? AND cus_ID = ? LIMIT 1  ");
        preparedStatement.setString(1, b);
        preparedStatement.setString(2, a);
        resultset = preparedStatement.executeQuery();
        if (resultset.next()) {
            noti.setText("Customer ID of month already exist");
        } else {
            noti.setText("");
        }
    }


    private void add_jbtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_jbtActionPerformed
        try {
            check(jtf_cus.getText(), month);
            preparedStatement = connect.prepareStatement("INSERT INTO Indexs ( index_of_month, "
                    + "cus_ID,"
                    + "old_number,"
                    + "new_number,"
                    + "indexs,"
                    + "into_money,"
                    + "vat_tax,"
                    + "total,"
                    + "payment)"
                    + " VALUES ( ?, ?, ?, ?, ? ,?, ?, ?, ?)");
            preparedStatement.setInt(1, month_cbx.getSelectedIndex() + 1);
            preparedStatement.setString(2, jtf_cus.getText());
            preparedStatement.setString(3, jtf_old.getText());
            preparedStatement.setString(4, jtf_new.getText());
            preparedStatement.setString(5, jtf_index.getText());
            preparedStatement.setString(6, String.valueOf(money));
            preparedStatement.setString(7, String.valueOf(moneytax));
            preparedStatement.setString(8, String.valueOf(total));
            preparedStatement.setString(9, "Unsubmit");
            preparedStatement.executeUpdate();
            displayTable();
            jtf_cus.setText(null);
            jtf_old.setText(null);
            jtf_new.setText(null);
            jtf_index.setText(null);
            jtf_IntoMoney.setText(null);
            jtf_VatTax.setText(null);
            jtf_total.setText(null);
            add_jbt.setEnabled(false);
            update_jbt.setEnabled(false);

        } catch (SQLException ex) {
            Logger.getLogger(CalculaterBill.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_add_jbtActionPerformed

    private void gohome_btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gohome_btActionPerformed
        try {
            ThemeLoginSuccessAdmin login = new ThemeLoginSuccessAdmin(iduser_program, username_program);
            login.setVisible(true);
            FunctionOfProgram.insertHistory(iduser_program, "User: " + username_program + " Sign out");
            dispose();
        } catch (SQLException ex) {
            Logger.getLogger(CalculaterBill.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_gohome_btActionPerformed

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
        int check = JOptionPane.showConfirmDialog(rootPane, "Are you sure", "Exit program", JOptionPane.YES_OPTION);
        if (check == JOptionPane.YES_OPTION) {
            System.exit(0);
        } else {

        }
    }//GEN-LAST:event_exitActionPerformed

    private void jtf_newKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_newKeyReleased
        try {
            jtf_IntoMoney.setText(null);
            jtf_VatTax.setText(null);
            jtf_total.setText(null);
            news = Integer.valueOf(jtf_new.getText());
            old = Integer.valueOf(jtf_old.getText());
            if (news < old) {
                noti.setText("The new index must be greater than the old index!");
                jbt_calculater.setEnabled(false);
                add_jbt.setEnabled(false);
                update_jbt.setEnabled(false);
            } else {
                jbt_calculater.setEnabled(true);
                noti.setText("");
            }
        } catch (Exception ex) {
        }
    }//GEN-LAST:event_jtf_newKeyReleased

    private void jbt_calculaterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbt_calculaterActionPerformed
        try {
            String a = String.valueOf(month_cbx.getSelectedIndex() + 1);
            preparedStatement = connect.prepareStatement("SELECT index_of_month, cus_ID FROM Indexs WHERE index_of_month = ? AND cus_ID = ? LIMIT 1  ");
            preparedStatement.setString(1, a);
            preparedStatement.setString(2, jtf_cus.getText());
            resultset = preparedStatement.executeQuery();
            if (resultset.next()) {
                add_jbt.setEnabled(false);

            } else {
                add_jbt.setEnabled(true);
            }
            news = Integer.valueOf(jtf_new.getText());
            old = Integer.valueOf(jtf_old.getText());
            power = news - old;
            String idexpower = String.valueOf(power);
            jtf_index.setText(idexpower);
            money = index(power);
            jtf_IntoMoney.setText("" + money + " VND");
            moneytax = (money * 10) / 100;
            jtf_VatTax.setText("" + moneytax + " VNĐ");
            total = money + moneytax;
            jtf_total.setText("" + total + " VNĐ");
            jbt_calculater.setEnabled(false);

        } catch (SQLException ex) {

        }


    }//GEN-LAST:event_jbt_calculaterActionPerformed

    private void jtf_cusKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_cusKeyReleased

        try {
            if (jtf_cus.getText().equals("")) {
            } else {
                preparedStatement = connect.prepareStatement("SELECT ID FROM Customer  WHERE ID = ?");
                preparedStatement.setString(1, jtf_cus.getText());
                resultset = preparedStatement.executeQuery();
                if (!resultset.first()) {
                    noti.setText("Customer ID not exist in database");
                    add_jbt.setEnabled(false);
                } else {
                    noti.setText("");
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Areas.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jtf_cusKeyReleased

    private void printbill_btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printbill_btActionPerformed
        try {
            PrintBill bill = new PrintBill(jtf_cus.getText(), month, iduser_program, username_program);
            bill.setVisible(true);
            dispose();
        } catch (SQLException ex) {
            Logger.getLogger(CalculaterBill.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_printbill_btActionPerformed

    private void delete_jbtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete_jbtActionPerformed

        try {
            preparedStatement = connect.prepareStatement("DELETE FROM Indexs  WHERE ID = ?");
            preparedStatement.setString(1, idIndex);
            preparedStatement.executeUpdate();
            displayTable();

            jtf_cus.setText(null);
            jtf_old.setText(null);
            jtf_new.setText(null);
            jtf_index.setText(null);
            jtf_IntoMoney.setText(null);
            jtf_VatTax.setText(null);
            jtf_total.setText(null);
            add_jbt.setEnabled(false);
            update_jbt.setEnabled(false);
            delete_jbt.setEnabled(false);
            jbt_calculater.setEnabled(true);
        } catch (SQLException ex) {
            Logger.getLogger(ThemeUsers.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_delete_jbtActionPerformed

    private void jtf_oldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_oldKeyReleased

        try {
            jtf_IntoMoney.setText(null);
            jtf_VatTax.setText(null);
            jtf_total.setText(null);
        } catch (Exception ex) {
            jtf_old.setText(null);
        }
    }//GEN-LAST:event_jtf_oldKeyReleased

    private void statistical_btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statistical_btActionPerformed
        try {
            ViewPayment showTheme = new ViewPayment(iduser_program, username_program);
            showTheme.setVisible(true);
            dispose();
        } catch (SQLException ex) {
            Logger.getLogger(ThemeLoginSuccessAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_statistical_btActionPerformed

    private void payment_btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_payment_btActionPerformed
        try {
            PaymentOfCustomer a = new PaymentOfCustomer(iduser_program, username_program);
            a.setVisible(true);
            dispose();
        } catch (SQLException ex) {
            Logger.getLogger(ThemeLoginSuccessAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_payment_btActionPerformed

    private void jtf_cusKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_cusKeyTyped
        char c = evt.getKeyChar();
        if (!Character.isDigit(c) || (c == KeyEvent.VK_SPACE) || (c == KeyEvent.VK_DELETE)) {
            evt.consume();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_cusKeyTyped

    private void jtf_oldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_oldKeyTyped
        char c = evt.getKeyChar();
        if (!Character.isDigit(c) || (c == KeyEvent.VK_SPACE) || (c == KeyEvent.VK_DELETE)) {
            evt.consume();
        }
    }//GEN-LAST:event_jtf_oldKeyTyped

    private void jtf_newKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_newKeyTyped
        char c = evt.getKeyChar();
        if (!Character.isDigit(c) || (c == KeyEvent.VK_SPACE) || (c == KeyEvent.VK_DELETE)) {
            evt.consume();
        }
    }//GEN-LAST:event_jtf_newKeyTyped
    public int index(int dien) throws SQLException {
        int index = 0, price = 0, k = 0;

        resultset = preparedStatement.executeQuery("SELECT end_number, price FROM PriceRange");
        resultSetMetaData = resultset.getMetaData();
        ArrayList moctiendien = new ArrayList();
        ArrayList tiendien = new ArrayList();
        moctiendien.add(0);
        while (resultset.next()) {
            index = resultset.getInt(1);
            price = resultset.getInt(2);
            moctiendien.add(index);
            tiendien.add(price);
        }
        for (int i = 0; i < moctiendien.size(); i++) {
            if (k + ((int) moctiendien.get(i + 1) - (int) moctiendien.get(i)) <= dien) {
                totalmoney += ((int) moctiendien.get(i + 1) - (int) moctiendien.get(i)) * (int) tiendien.get(i);
                k += (int) moctiendien.get(i + 1) - (int) moctiendien.get(i);
            } else {
                totalmoney += ((dien - k) * (int) tiendien.get(i));
                break;
            }
        }

        return totalmoney;

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add_jbt;
    private javax.swing.JLabel avatar_lb;
    private javax.swing.JButton delete_jbt;
    private javax.swing.JButton exit;
    private javax.swing.JButton gohome_bt;
    private javax.swing.JLabel hello_lb;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbt_calculater;
    private javax.swing.JTable jtable_Caculater;
    private javax.swing.JTextField jtf_IntoMoney;
    private javax.swing.JTextField jtf_VatTax;
    private javax.swing.JTextField jtf_cus;
    private javax.swing.JTextField jtf_index;
    private javax.swing.JTextField jtf_new;
    private javax.swing.JTextField jtf_old;
    private javax.swing.JTextField jtf_total;
    private javax.swing.JComboBox month_cbx;
    private javax.swing.JLabel noti;
    private javax.swing.JButton payment_bt;
    private javax.swing.JButton printbill_bt;
    private javax.swing.JButton statistical_bt;
    private javax.swing.JButton update_jbt;
    // End of variables declaration//GEN-END:variables
}
