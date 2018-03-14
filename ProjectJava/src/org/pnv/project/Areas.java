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

public class Areas extends javax.swing.JFrame {

    private Connection connect;
    private ResultSet resultset;
    private ResultSetMetaData rsmt;
    private PreparedStatement preparedStatement = null;
    public String username_program;
    public String iduser_program;
    public String id;
    public String shorts;
    public String name;

    public void displayTable() throws SQLException {
        resultset = preparedStatement.executeQuery("SELECT * FROM Area");
        rsmt = resultset.getMetaData();
        DefaultTableModel model = new DefaultTableModel();
        int demcolumn = rsmt.getColumnCount();
        Object[] nameColumn = new Object[demcolumn];
        for (int i = 0; i < demcolumn; i++) {
            nameColumn[i] = rsmt.getColumnClassName(i + 1);
        }
        nameColumn[0] = "ID Area";
        nameColumn[1] = "Short Name";
        nameColumn[2] = "Name Area";
        jTable1.setModel(model);
        model.setColumnIdentifiers(nameColumn);
        while (resultset.next() != false) {
            Object[] content = new Object[demcolumn];
            for (int i = 0; i < demcolumn; i++) {
                content[i] = resultset.getString(i + 1);
            }
            model.addRow(content);
        }
    }

    public Areas(String id_user, String name_user) throws SQLException {
        initComponents();
        connect = DatabaseHelper.getConnection();
        username_program = name_user;
        iduser_program = id_user;
        CheckRole();
        hello_lb.setText("Hi, " + FunctionOfProgram.capsText(username_program));
        this.setLocationRelativeTo(null);
        displayTable();
        jLabel1.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/org/pnv/image/backgrounds.jpg")).getImage().getScaledInstance(790, 640, Image.SCALE_SMOOTH)));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jbt_goHome = new javax.swing.JButton();
        hello_lb = new javax.swing.JLabel();
        avatar_lb = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        nameArea_jtf = new javax.swing.JTextField();
        shortName_jtf = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jbt_add = new javax.swing.JButton();
        jbt_update = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        checkShortName = new javax.swing.JLabel();
        checkNameArea_jlb = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Electricity Management");
        setResizable(false);

        jPanel1.setPreferredSize(new java.awt.Dimension(790, 640));
        jPanel1.setLayout(null);

        jLabel3.setFont(new java.awt.Font("Century Schoolbook", 3, 48)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Area ");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(130, 160, 140, 56);

        jbt_goHome.setFont(new java.awt.Font("Century Schoolbook", 1, 12)); // NOI18N
        jbt_goHome.setText("Go Home");
        jbt_goHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbt_goHomeActionPerformed(evt);
            }
        });
        jPanel1.add(jbt_goHome);
        jbt_goHome.setBounds(570, 460, 180, 50);

        hello_lb.setFont(new java.awt.Font("Century Schoolbook", 3, 16)); // NOI18N
        hello_lb.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(hello_lb);
        hello_lb.setBounds(590, 120, 160, 30);
        jPanel1.add(avatar_lb);
        avatar_lb.setBounds(590, 160, 140, 140);

        jButton6.setFont(new java.awt.Font("Century Schoolbook", 1, 12)); // NOI18N
        jButton6.setText("Customer of Area");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton6);
        jButton6.setBounds(570, 360, 180, 50);

        jButton5.setFont(new java.awt.Font("Century Schoolbook", 1, 12)); // NOI18N
        jButton5.setText("View Area Payment");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5);
        jButton5.setBounds(570, 410, 180, 50);

        jButton3.setFont(new java.awt.Font("Century Schoolbook", 1, 12)); // NOI18N
        jButton3.setText("Exit");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3);
        jButton3.setBounds(570, 510, 180, 50);

        jPanel2.setLayout(null);

        nameArea_jtf.setFont(new java.awt.Font("Century Schoolbook", 0, 12)); // NOI18N
        nameArea_jtf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                nameArea_jtfKeyReleased(evt);
            }
        });
        jPanel2.add(nameArea_jtf);
        nameArea_jtf.setBounds(170, 80, 190, 30);

        shortName_jtf.setFont(new java.awt.Font("Century Schoolbook", 0, 12)); // NOI18N
        shortName_jtf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                shortName_jtfKeyReleased(evt);
            }
        });
        jPanel2.add(shortName_jtf);
        shortName_jtf.setBounds(170, 20, 190, 30);

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel6.setText("Short Name:");
        jPanel2.add(jLabel6);
        jLabel6.setBounds(40, 20, 110, 30);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel2.setText("Name Area:");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(40, 80, 110, 30);

        jTable1.setFont(new java.awt.Font("Century Schoolbook", 1, 12)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "Area ID", "Name Area"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel2.add(jScrollPane1);
        jScrollPane1.setBounds(40, 140, 430, 100);

        jbt_add.setFont(new java.awt.Font("Century Schoolbook", 1, 14)); // NOI18N
        jbt_add.setForeground(new java.awt.Color(0, 0, 204));
        jbt_add.setText("Add");
        jbt_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbt_addActionPerformed(evt);
            }
        });
        jPanel2.add(jbt_add);
        jbt_add.setBounds(380, 20, 90, 50);

        jbt_update.setFont(new java.awt.Font("Century Schoolbook", 1, 14)); // NOI18N
        jbt_update.setForeground(new java.awt.Color(0, 0, 204));
        jbt_update.setText("Update");
        jbt_update.setEnabled(false);
        jbt_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbt_updateActionPerformed(evt);
            }
        });
        jPanel2.add(jbt_update);
        jbt_update.setBounds(380, 80, 90, 50);

        jLabel8.setFont(new java.awt.Font("Century Schoolbook", 1, 22)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 153, 153));
        jLabel8.setText("Please enter the area in Da Nang city!");
        jPanel2.add(jLabel8);
        jLabel8.setBounds(40, 240, 440, 40);
        jPanel2.add(checkShortName);
        checkShortName.setBounds(170, 50, 190, 30);
        jPanel2.add(checkNameArea_jlb);
        checkNameArea_jlb.setBounds(170, 110, 190, 30);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(30, 270, 490, 290);

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
    private void jbt_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbt_addActionPerformed
        try {
            preparedStatement = connect.prepareStatement("INSERT INTO Area ( short_name, name_area)"
                    + " VALUES ( ?, ?)");
            preparedStatement.setString(1, shortName_jtf.getText());
            preparedStatement.setString(2, nameArea_jtf.getText());
            preparedStatement.executeUpdate();
            displayTable();
            JOptionPane.showMessageDialog(rootPane, "Add success !!");
            shortName_jtf.setText(null);
            nameArea_jtf.setText(null);
        } catch (SQLException ex) {
            Logger.getLogger(Areas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jbt_addActionPerformed

    private void jbt_goHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbt_goHomeActionPerformed
        try {
            ThemeLoginSuccessAdmin loginSuccess = new ThemeLoginSuccessAdmin(iduser_program, username_program);
            setVisible(false);
            loginSuccess.setVisible(true);
            dispose();
        } catch (SQLException ex) {
            Logger.getLogger(Areas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jbt_goHomeActionPerformed

    private void jbt_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbt_updateActionPerformed

        try {
            preparedStatement = connect.prepareStatement("UPDATE Area SET short_name=?, name_area = ? WHERE ID = ?");
            preparedStatement.setString(3, id);
            preparedStatement.setString(1, shortName_jtf.getText());
            preparedStatement.setString(2, nameArea_jtf.getText());
            preparedStatement.executeUpdate();
            displayTable();
            JOptionPane.showMessageDialog(rootPane, "Updated success !!");
            shortName_jtf.setText(null);
            nameArea_jtf.setText(null);
        } catch (SQLException ex) {
            Logger.getLogger(ThemeUsers.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jbt_updateActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int check = JOptionPane.showConfirmDialog(rootPane, "Are you sure", "Exit program", JOptionPane.YES_OPTION);
        if (check == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked

        int b = jTable1.getSelectedRow();
        id = (String) jTable1.getValueAt(b, 0);
        shorts = (String) jTable1.getValueAt(b, 1);
        name = (String) jTable1.getValueAt(b, 2);
        shortName_jtf.setText(shorts);
        nameArea_jtf.setText(name);
        jbt_update.setEnabled(true);
    }//GEN-LAST:event_jTable1MouseClicked

    private void shortName_jtfKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_shortName_jtfKeyReleased
        try {

            preparedStatement = connect.prepareStatement("SELECT short_name FROM Area WHERE short_name = ?");
            preparedStatement.setString(1, shortName_jtf.getText());
            resultset = preparedStatement.executeQuery();
            if (!resultset.first()) {
                jbt_add.setEnabled(true);
                jbt_update.setEnabled(true);
                checkShortName.setText(null);
            } else {
                jbt_add.setEnabled(false);
                jbt_update.setEnabled(false);
                checkShortName.setText(" Area exist");
            }

        } catch (SQLException ex) {
            Logger.getLogger(Areas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_shortName_jtfKeyReleased

    private void nameArea_jtfKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nameArea_jtfKeyReleased

        try {

            preparedStatement = connect.prepareStatement("SELECT name_area FROM Area WHERE name_area = ?");
            preparedStatement.setString(1, nameArea_jtf.getText());
            resultset = preparedStatement.executeQuery();
            if (!resultset.first()) {
                jbt_add.setEnabled(true);
                jbt_update.setEnabled(true);
                checkNameArea_jlb.setText(null);
            } else {
                jbt_add.setEnabled(false);
                jbt_update.setEnabled(false);
                checkNameArea_jlb.setText(" Name Area exist");
            }

        } catch (SQLException ex) {
            Logger.getLogger(Areas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_nameArea_jtfKeyReleased

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        try {
            CustomerInformationofArea a = new CustomerInformationofArea(iduser_program, username_program);
            a.setVisible(true);
            dispose();
        } catch (SQLException ex) {
            Logger.getLogger(Areas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        try {
            ViewPayment showTheme = new ViewPayment(iduser_program, username_program);
            showTheme.setVisible(true);
            dispose();
        } catch (SQLException ex) {
            Logger.getLogger(Areas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton5ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel avatar_lb;
    private javax.swing.JLabel checkNameArea_jlb;
    private javax.swing.JLabel checkShortName;
    private javax.swing.JLabel hello_lb;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton jbt_add;
    private javax.swing.JButton jbt_goHome;
    private javax.swing.JButton jbt_update;
    private javax.swing.JTextField nameArea_jtf;
    private javax.swing.JTextField shortName_jtf;
    // End of variables declaration//GEN-END:variables
}
