package org.pnv.project;

import java.awt.Image;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.pnv.functions.DatabaseHelper;
import org.pnv.functions.FunctionOfProgram;

public class CustomerCalculater extends javax.swing.JFrame {

    private Connection connect;
    private Statement statement;
    private ResultSet resultset;
    private ResultSetMetaData resultSetMetaData;
    private PreparedStatement preparedStatement = null;
    private String iduser_table;
    public String username_program;
    public String iduser_program;
    public String idIndex;
    public int s = 0;
    public int power = 0;
    public int money = 0;
    public int moneytax = 0;
    public int total = 0;
    Integer news = 0;
    Integer old = 0;
    public String month;
    public String cusID;

    public CustomerCalculater(String id_user, String name_user) throws SQLException {
        initComponents();
        connect = DatabaseHelper.getConnection();
        username_program = name_user;
        iduser_program = id_user;
        preparedStatement = connect.prepareStatement("SELECT id, cus_name FROM Customer WHERE id_card = ?");
        preparedStatement.setString(1, name_user);
        resultset = preparedStatement.executeQuery();
        if (resultset.next()) {

            hello_lb.setText("Hi, " + FunctionOfProgram.capsText(resultset.getString(2)));
        }
        avatar_lb.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/org/pnv/image/customer.png")).getImage().getScaledInstance(140, 140, Image.SCALE_SMOOTH)));
        this.setLocationRelativeTo(null);
        jLabel1.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/org/pnv/image/backgrounds.jpg")).getImage().getScaledInstance(790, 640, Image.SCALE_SMOOTH)));
        jbt_calculater.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel10 = new javax.swing.JLabel();
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
        jbt_calculater = new javax.swing.JButton();
        avatar_lb = new javax.swing.JLabel();
        hello_lb = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        noti = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
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
        jLabel10.setBounds(30, 140, 500, 40);

        jtf_IntoMoney.setEditable(false);
        jtf_IntoMoney.setFont(new java.awt.Font("Century Schoolbook", 1, 12)); // NOI18N
        getContentPane().add(jtf_IntoMoney);
        jtf_IntoMoney.setBounds(230, 450, 190, 30);

        jLabel14.setFont(new java.awt.Font("Century Schoolbook", 1, 16)); // NOI18N
        jLabel14.setText("Into Money");
        getContentPane().add(jLabel14);
        jLabel14.setBounds(60, 450, 110, 30);

        jtf_VatTax.setEditable(false);
        jtf_VatTax.setFont(new java.awt.Font("Century Schoolbook", 1, 12)); // NOI18N
        getContentPane().add(jtf_VatTax);
        jtf_VatTax.setBounds(230, 490, 190, 30);

        jLabel12.setFont(new java.awt.Font("Century Schoolbook", 1, 16)); // NOI18N
        jLabel12.setText("VAT Tax");
        getContentPane().add(jLabel12);
        jLabel12.setBounds(60, 490, 110, 30);

        jtf_old.setFont(new java.awt.Font("Century Schoolbook", 1, 12)); // NOI18N
        jtf_old.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtf_oldKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtf_oldKeyTyped(evt);
            }
        });
        getContentPane().add(jtf_old);
        jtf_old.setBounds(230, 280, 190, 30);

        jLabel6.setFont(new java.awt.Font("Century Schoolbook", 1, 16)); // NOI18N
        jLabel6.setText("Old number");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(60, 280, 140, 30);

        jLabel7.setFont(new java.awt.Font("Century Schoolbook", 1, 16)); // NOI18N
        jLabel7.setText("New number");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(60, 320, 140, 30);

        jtf_new.setFont(new java.awt.Font("Century Schoolbook", 1, 12)); // NOI18N
        jtf_new.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtf_newKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtf_newKeyTyped(evt);
            }
        });
        getContentPane().add(jtf_new);
        jtf_new.setBounds(230, 320, 190, 30);

        jtf_index.setEditable(false);
        jtf_index.setFont(new java.awt.Font("Century Schoolbook", 1, 12)); // NOI18N
        getContentPane().add(jtf_index);
        jtf_index.setBounds(230, 360, 190, 30);

        jLabel8.setFont(new java.awt.Font("Century Schoolbook", 1, 16)); // NOI18N
        jLabel8.setText("Total");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(60, 530, 70, 30);

        jtf_total.setEditable(false);
        jtf_total.setFont(new java.awt.Font("Century Schoolbook", 1, 12)); // NOI18N
        getContentPane().add(jtf_total);
        jtf_total.setBounds(230, 530, 190, 30);

        jbt_calculater.setFont(new java.awt.Font("Century Schoolbook", 1, 14)); // NOI18N
        jbt_calculater.setText("Calculate");
        jbt_calculater.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbt_calculaterActionPerformed(evt);
            }
        });
        getContentPane().add(jbt_calculater);
        jbt_calculater.setBounds(230, 400, 190, 40);
        getContentPane().add(avatar_lb);
        avatar_lb.setBounds(590, 160, 140, 140);

        hello_lb.setFont(new java.awt.Font("Century Schoolbook", 3, 16)); // NOI18N
        hello_lb.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(hello_lb);
        hello_lb.setBounds(590, 120, 160, 30);

        jButton3.setFont(new java.awt.Font("Century Schoolbook", 1, 12)); // NOI18N
        jButton3.setText("Exit");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(570, 480, 180, 60);

        jLabel15.setFont(new java.awt.Font("Century Schoolbook", 1, 16)); // NOI18N
        jLabel15.setText("Index ");
        getContentPane().add(jLabel15);
        jLabel15.setBounds(60, 360, 140, 30);

        noti.setFont(new java.awt.Font("Century Schoolbook", 1, 18)); // NOI18N
        noti.setForeground(new java.awt.Color(255, 0, 0));
        getContentPane().add(noti);
        noti.setBounds(30, 240, 490, 30);

        jButton4.setFont(new java.awt.Font("Century Schoolbook", 1, 12)); // NOI18N
        jButton4.setText("Go Home");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4);
        jButton4.setBounds(570, 400, 180, 60);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/pnv/image/backgrounds.jpg"))); // NOI18N
        jLabel1.setPreferredSize(new java.awt.Dimension(790, 640));
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 790, 640);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public void check(String a, String b) throws SQLException {
        preparedStatement = connect.prepareStatement("SELECT index_of_month, cus_ID FROM Indexs WHERE index_of_month = ? AND cus_ID = ? LIMIT 1  ");
        preparedStatement.setString(1, b);
        preparedStatement.setString(2, a);
        resultset = preparedStatement.executeQuery();

        if (resultset.next()) {
            String months = resultset.getString(1);
            String cusid = resultset.getString(2);
        } else {

        }
    }


    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int check = JOptionPane.showConfirmDialog(rootPane, "Are you sure", "Exit program", JOptionPane.YES_OPTION);
        if (check == JOptionPane.YES_OPTION) {
            System.exit(0);
        } else {
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jtf_newKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_newKeyReleased
        try {
            Double a = Double.parseDouble(jtf_new.getText());
            news = Integer.valueOf(jtf_new.getText());
            old = Integer.valueOf(jtf_old.getText());
            if (news < old) {
                noti.setText("The new index must be greater than the old index!");
                jbt_calculater.setEnabled(false);

            } else {
                jbt_calculater.setEnabled(true);

            }
        } catch (Exception ex) {
            jbt_calculater.setEnabled(false);

        }
    }//GEN-LAST:event_jtf_newKeyReleased

    private void jbt_calculaterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbt_calculaterActionPerformed
        try {
            if (jbt_calculater.getText().equals("Calculate")) {
                news = Integer.valueOf(jtf_new.getText());
                old = Integer.valueOf(jtf_old.getText());
                power = news - old;
                String idexpower = String.valueOf(power);
                jtf_index.setText(idexpower);
                money = index(power);
                jtf_IntoMoney.setText("" + money + " VND");
                moneytax = (money * 10) / 100;
                jtf_VatTax.setText("" + moneytax + " VNĐ" + " (10% VAT)");
                total = money + moneytax;
                jtf_total.setText("" + total + " VNĐ");

                jbt_calculater.setText("Reset Data");
            } else {
                jtf_old.setText(null);
                jtf_new.setText(null);
                jtf_IntoMoney.setText(null);
                jtf_VatTax.setText(null);
                jtf_index.setText(null);
                jtf_total.setText(null);
                jbt_calculater.setEnabled(false);
                jbt_calculater.setText("Calculate");
            }
        } catch (SQLException ex) {
        }
    }//GEN-LAST:event_jbt_calculaterActionPerformed

    private void jtf_oldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_oldKeyReleased
        try {
            Double a = Double.parseDouble(jtf_old.getText());

        } catch (Exception ex) {
            jtf_old.setText(null);
        }
    }//GEN-LAST:event_jtf_oldKeyReleased

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        try {
            ThemeLoginSuccessUser gohome = new ThemeLoginSuccessUser(iduser_program, username_program);
            dispose();
            gohome.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(CustomerCalculater.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jtf_oldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_oldKeyTyped
        char c = evt.getKeyChar();
        if (!Character.isDigit(c) || (c == KeyEvent.VK_SPACE) || (c == KeyEvent.VK_DELETE)) {
            evt.consume();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_oldKeyTyped

    private void jtf_newKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_newKeyTyped
        char c = evt.getKeyChar();
        if (!Character.isDigit(c) || (c == KeyEvent.VK_SPACE) || (c == KeyEvent.VK_DELETE)) {
            evt.consume();
        }
    }//GEN-LAST:event_jtf_newKeyTyped
    public int index(int dien) throws SQLException {
        int index = 0, price = 0, k = 0;
        String sqlStml = "SELECT end_number, price FROM PriceRange";
        statement = connect.createStatement();
        resultset = statement.executeQuery(sqlStml);
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
                s += ((int) moctiendien.get(i + 1) - (int) moctiendien.get(i)) * (int) tiendien.get(i);
                k += (int) moctiendien.get(i + 1) - (int) moctiendien.get(i);
            } else {
                s += ((dien - k) * (int) tiendien.get(i));
                break;
            }
        }

        return s;

    }

    public static void main(String[] args) throws SQLException {
        CustomerCalculater a = new CustomerCalculater("s", "2");
        a.setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel avatar_lb;
    private javax.swing.JLabel hello_lb;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JButton jbt_calculater;
    private javax.swing.JTextField jtf_IntoMoney;
    private javax.swing.JTextField jtf_VatTax;
    private javax.swing.JTextField jtf_index;
    private javax.swing.JTextField jtf_new;
    private javax.swing.JTextField jtf_old;
    private javax.swing.JTextField jtf_total;
    private javax.swing.JLabel noti;
    // End of variables declaration//GEN-END:variables
}
