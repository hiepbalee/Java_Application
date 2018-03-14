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
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.pnv.functions.DatabaseHelper;
import org.pnv.functions.FunctionOfProgram;

public class ThemeUsers extends javax.swing.JFrame {

    private Connection connect;
    private ResultSet resultset;
    private ResultSetMetaData resultsetmetadata;
    private PreparedStatement preparedStatement = null;
    public String username_program;
    public String iduser_program;
    private String iduser_table;
    private String path = null;

    public ThemeUsers(String id_user, String name_user) throws SQLException {
        connect = DatabaseHelper.getConnection();
        initComponents();
        username_program = name_user;
        iduser_program = id_user;
        hello_lb.setText("Hi, " + FunctionOfProgram.capsText(username_program));
        background2_lb.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/org/pnv/image/online12.png")).getImage().getScaledInstance(490, 290, Image.SCALE_SMOOTH)));
        avatar_lb.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/org/pnv/image/admin.png")).getImage().getScaledInstance(140, 140, Image.SCALE_SMOOTH)));
        this.setLocationRelativeTo(null);
        ShowTableUser();
    }

    public static boolean isEmpty(JTable jTable) {
        if (jTable != null && jTable.getModel() != null) {
            return jTable.getModel().getRowCount() <= 0 ? true : false;
        }
        return false;
    }

    public void ShowTableUser() throws SQLException {
        preparedStatement = connect.prepareStatement("SELECT ID, user_name, role, date_login FROM Users");
        resultset = preparedStatement.executeQuery();
        resultsetmetadata = resultset.getMetaData();
        DefaultTableModel model = new DefaultTableModel();
        int columnoftable = resultsetmetadata.getColumnCount();
        Object[] title = new Object[columnoftable];
        for (int i = 0; i < columnoftable; i++) {
            title[i] = resultsetmetadata.getColumnName(i + 1);
        }
        title[0] = "ID User";
        title[1] = "User Name";
        title[2] = "Role";
        title[3] = "Date Login";
        table_users.setModel(model);
        model.setColumnIdentifiers(title);
        while (resultset.next() != false) {

            Object[] content = new Object[columnoftable];
            for (int i = 0; i < columnoftable; i++) {
                content[i] = resultset.getString(i + 1);
            }
            model.addRow(content);
        }
    }

    public void ShowTableUserFind(String text) throws SQLException {
        preparedStatement = connect.prepareStatement("SELECT ID, user_name, role, date_login FROM Users WHERE user_name LIKE ?");
        preparedStatement.setString(1, "%" + text + "%");
        resultset = preparedStatement.executeQuery();
        resultsetmetadata = resultset.getMetaData();
        DefaultTableModel model2 = new DefaultTableModel();
        int demcolumn1 = resultsetmetadata.getColumnCount();
        Object[] tieude2 = new Object[demcolumn1];
        for (int i = 0; i < demcolumn1; i++) {
            tieude2[i] = resultsetmetadata.getColumnName(i + 1);
        }
        tieude2[0] = "ID User";
        tieude2[1] = "User Name";
        tieude2[2] = "Role";
        tieude2[3] = "Date Login";
        table_users.setModel(model2);
        model2.setColumnIdentifiers(tieude2);
        while (resultset.next() != false) {
            Object[] noidung2 = new Object[demcolumn1];
            for (int i = 0; i < demcolumn1; i++) {
                noidung2[i] = resultset.getString(i + 1);
            }
            model2.addRow(noidung2);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        username_tf = new javax.swing.JTextField();
        repassword_tf = new javax.swing.JPasswordField();
        password_tf = new javax.swing.JPasswordField();
        role_lb = new javax.swing.JLabel();
        username_lb = new javax.swing.JLabel();
        password_lb = new javax.swing.JLabel();
        repassword_lb = new javax.swing.JLabel();
        role_cbb = new javax.swing.JComboBox();
        table_users_scroll = new javax.swing.JScrollPane();
        table_users = new javax.swing.JTable();
        delete_button = new javax.swing.JButton();
        add_button = new javax.swing.JButton();
        update_button = new javax.swing.JButton();
        background2_lb = new javax.swing.JLabel();
        avatar_lb = new javax.swing.JLabel();
        home_bt = new javax.swing.JButton();
        exit_bt = new javax.swing.JButton();
        usage_bt = new javax.swing.JButton();
        find_bt = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        hello_lb = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        background_lb = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Electricity Management");
        setResizable(false);

        jPanel1.setPreferredSize(new java.awt.Dimension(790, 640));
        jPanel1.setLayout(null);

        username_tf.setFont(new java.awt.Font("Century Schoolbook", 0, 16)); // NOI18N
        username_tf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                username_tfKeyReleased(evt);
            }
        });
        jPanel1.add(username_tf);
        username_tf.setBounds(180, 290, 210, 30);

        repassword_tf.setFont(new java.awt.Font("Century Schoolbook", 0, 16)); // NOI18N
        repassword_tf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                repassword_tfKeyReleased(evt);
            }
        });
        jPanel1.add(repassword_tf);
        repassword_tf.setBounds(180, 370, 210, 30);

        password_tf.setFont(new java.awt.Font("Century Schoolbook", 0, 16)); // NOI18N
        jPanel1.add(password_tf);
        password_tf.setBounds(180, 330, 210, 30);

        role_lb.setFont(new java.awt.Font("Century Schoolbook", 1, 16)); // NOI18N
        role_lb.setText("Role");
        jPanel1.add(role_lb);
        role_lb.setBounds(50, 410, 120, 30);

        username_lb.setFont(new java.awt.Font("Century Schoolbook", 1, 16)); // NOI18N
        username_lb.setText("User Name");
        jPanel1.add(username_lb);
        username_lb.setBounds(50, 290, 120, 30);

        password_lb.setFont(new java.awt.Font("Century Schoolbook", 1, 16)); // NOI18N
        password_lb.setText("Password");
        jPanel1.add(password_lb);
        password_lb.setBounds(50, 330, 120, 30);

        repassword_lb.setFont(new java.awt.Font("Century Schoolbook", 1, 16)); // NOI18N
        repassword_lb.setText("Re-Password");
        jPanel1.add(repassword_lb);
        repassword_lb.setBounds(50, 370, 120, 30);

        role_cbb.setFont(new java.awt.Font("Century Schoolbook", 0, 16)); // NOI18N
        role_cbb.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Administrator", "Employee" }));
        role_cbb.setEnabled(false);
        jPanel1.add(role_cbb);
        role_cbb.setBounds(180, 410, 210, 30);

        table_users.setFont(new java.awt.Font("Century Schoolbook", 0, 12)); // NOI18N
        table_users.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "null"
            }
        ));
        table_users.getTableHeader().setReorderingAllowed(false);
        table_users.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_usersMouseClicked(evt);
            }
        });
        table_users_scroll.setViewportView(table_users);
        if (table_users.getColumnModel().getColumnCount() > 0) {
            table_users.getColumnModel().getColumn(0).setResizable(false);
            table_users.getColumnModel().getColumn(1).setResizable(false);
            table_users.getColumnModel().getColumn(2).setResizable(false);
            table_users.getColumnModel().getColumn(3).setResizable(false);
        }

        jPanel1.add(table_users_scroll);
        table_users_scroll.setBounds(30, 453, 490, 110);

        delete_button.setFont(new java.awt.Font("Century Schoolbook", 0, 14)); // NOI18N
        delete_button.setText("Delete");
        delete_button.setEnabled(false);
        delete_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete_buttonActionPerformed(evt);
            }
        });
        jPanel1.add(delete_button);
        delete_button.setBounds(420, 400, 90, 40);

        add_button.setFont(new java.awt.Font("Century Schoolbook", 0, 14)); // NOI18N
        add_button.setText("Add");
        add_button.setEnabled(false);
        add_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_buttonActionPerformed(evt);
            }
        });
        jPanel1.add(add_button);
        add_button.setBounds(420, 290, 90, 40);

        update_button.setFont(new java.awt.Font("Century Schoolbook", 0, 14)); // NOI18N
        update_button.setText("Update");
        update_button.setEnabled(false);
        update_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                update_buttonActionPerformed(evt);
            }
        });
        jPanel1.add(update_button);
        update_button.setBounds(420, 350, 90, 40);
        jPanel1.add(background2_lb);
        background2_lb.setBounds(30, 270, 490, 290);
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

        usage_bt.setFont(new java.awt.Font("Century Schoolbook", 1, 12)); // NOI18N
        usage_bt.setText("Usage History");
        usage_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usage_btActionPerformed(evt);
            }
        });
        jPanel1.add(usage_bt);
        usage_bt.setBounds(570, 410, 180, 50);

        find_bt.setFont(new java.awt.Font("Century Schoolbook", 1, 12)); // NOI18N
        find_bt.setText("Find The User");
        find_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                find_btActionPerformed(evt);
            }
        });
        jPanel1.add(find_bt);
        find_bt.setBounds(570, 360, 180, 50);

        jButton7.setFont(new java.awt.Font("Century Schoolbook", 1, 12)); // NOI18N
        jButton7.setText("Show User of Customer");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton7);
        jButton7.setBounds(570, 310, 180, 50);

        hello_lb.setFont(new java.awt.Font("Century Schoolbook", 3, 16)); // NOI18N
        hello_lb.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(hello_lb);
        hello_lb.setBounds(590, 120, 160, 30);

        jLabel3.setFont(new java.awt.Font("Century Schoolbook", 3, 48)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("User of System");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(50, 130, 400, 59);

        background_lb.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/pnv/image/backgrounds.jpg"))); // NOI18N
        background_lb.setPreferredSize(new java.awt.Dimension(790, 640));
        jPanel1.add(background_lb);
        background_lb.setBounds(0, 0, 790, 640);

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

    private void delete_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete_buttonActionPerformed
        try {
            if (iduser_table.equals("1")) {
                JOptionPane.showMessageDialog(rootPane, "Administator account is not allowed to delete", "Notification", JOptionPane.OK_OPTION);
            } else {
                preparedStatement = connect.prepareStatement("DELETE FROM History WHERE user_ID = ?");
                preparedStatement.setString(1, iduser_table);
                preparedStatement.executeUpdate();
                preparedStatement = connect.prepareStatement("DELETE FROM Users WHERE ID = ?");
                preparedStatement.setString(1, iduser_table);
                preparedStatement.executeUpdate();
                ShowTableUser();
                JOptionPane.showMessageDialog(rootPane, "Delete username success !!");
                username_tf.setText(null);
                password_tf.setText(null);
                repassword_tf.setText(null);
                update_button.setEnabled(false);
                delete_button.setEnabled(false);
                role_cbb.setEnabled(false);
                if (add_button.getText().equals("Search")) {
                    add_button.setEnabled(true);
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(ThemeUsers.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_delete_buttonActionPerformed

    private void add_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_buttonActionPerformed

        String username = username_tf.getText();
        String password = password_tf.getText();
        String re_password = repassword_tf.getText();
        if (username.indexOf(" ") == -1) {
            try {
                preparedStatement = connect.prepareStatement("SELECT * FROM Users WHERE user_name = ? LIMIT 1 ");
                preparedStatement.setString(1, username_tf.getText());
                resultset = preparedStatement.executeQuery();
                if (resultset.first()) {
                    JOptionPane.showMessageDialog(rootPane, "This user already exist !");
                    username_tf.setText(null);
                    password_tf.setText(null);
                    repassword_tf.setText(null);
                    add_button.setEnabled(false);
                    role_cbb.setEnabled(false);
                } else {
                    try {
                        if (!(re_password.equals(password))) {
                            JOptionPane.showMessageDialog(rootPane, "Please input re-password is same to password !");
                            password_tf.setText(null);
                            repassword_tf.setText(null);
                            add_button.setEnabled(false);
                            role_cbb.setEnabled(false);
                        } else {
                            if (username.equals("")) {
                                JOptionPane.showMessageDialog(rootPane, "Please enter user name !");
                                password_tf.setText(null);
                                repassword_tf.setText(null);
                            } else {
                                preparedStatement = connect.prepareStatement("INSERT INTO Users ( user_name, user_password , role) VALUES ( ?, ?, ? )");
                                preparedStatement.setString(1, username);
                                preparedStatement.setString(2, FunctionOfProgram.getMD5(password));
                                preparedStatement.setString(3, role_cbb.getSelectedItem().toString());

                                preparedStatement.executeUpdate();
                                ShowTableUser();
                                JOptionPane.showMessageDialog(rootPane, "Add user success !!");
                                username_tf.setText(null);
                                password_tf.setText(null);
                                repassword_tf.setText(null);
                                update_button.setEnabled(false);
                                delete_button.setEnabled(false);
                                add_button.setEnabled(false);
                                role_cbb.setEnabled(false);
                            }
                        }

                    } catch (SQLException ex) {
                        Logger.getLogger(ThemeUsers.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            } catch (Exception e) {
                Logger.getLogger(ThemeUsers.class.getName()).log(Level.SEVERE, null, e);
            }

        } else {
            JOptionPane.showMessageDialog(rootPane, "User name isn't allowed spaces");
            username_tf.setText(null);
            password_tf.setText(null);
            repassword_tf.setText(null);
            role_cbb.setEnabled(false);
        }
    }//GEN-LAST:event_add_buttonActionPerformed

    private void update_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_update_buttonActionPerformed
        if (password_tf.getText().equals("") || repassword_tf.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Please enter the password", "Password Wrong", WIDTH);
            password_tf.setText(null);
            repassword_tf.setText(null);
            add_button.setEnabled(false);
            role_cbb.setEnabled(false);
        } else {
            if (repassword_tf.getText().equals(password_tf.getText())) {
                try {
                    preparedStatement = connect.prepareStatement("SELECT user_name FROM Users");
                    resultset = preparedStatement.executeQuery();
                    while (resultset.next()) {
                        if (resultset.getString(1).equals(username_tf.getText())) {
                            preparedStatement = connect.prepareStatement("UPDATE Users SET user_name= ?,  user_password = ?, role = ? WHERE ID = ?");
                            preparedStatement.setString(4, iduser_table);
                            preparedStatement.setString(1, username_tf.getText());
                            preparedStatement.setString(2, FunctionOfProgram.getMD5(password_tf.getText()));
                            preparedStatement.setString(3, role_cbb.getSelectedItem().toString());

                            preparedStatement.executeUpdate();
                            ShowTableUser();
                            JOptionPane.showMessageDialog(rootPane, "Update username success !!");
                            if (add_button.getText().equals("Search")) {
                                add_button.setEnabled(true);
                                ShowTableUserFind(username_tf.getText());
                            }
                            password_tf.setText(null);
                            repassword_tf.setText(null);
                            username_tf.setText(null);
                            update_button.setEnabled(false);
                            delete_button.setEnabled(false);
                            role_cbb.setEnabled(false);
                        } else {
                            JOptionPane.showMessageDialog(rootPane, "User name not exist !!", "Error", WIDTH);
                        }
                    }

                } catch (SQLException ex) {
                    Logger.getLogger(ThemeUsers.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                JOptionPane.showMessageDialog(rootPane, "Please input re-password is same to password !");
                password_tf.setText(null);
                repassword_tf.setText(null);
                add_button.setEnabled(false);
                role_cbb.setEnabled(false);
            }
        }
    }//GEN-LAST:event_update_buttonActionPerformed

    private void table_usersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_usersMouseClicked

        add_button.setEnabled(false);
        update_button.setEnabled(true);
        delete_button.setEnabled(true);
        int row = table_users.getSelectedRow();

        iduser_table = (String) table_users.getValueAt(row, 0);
        String ok = (String) table_users.getValueAt(row, 2);
        if (ok.equals("Employee")) {
            role_cbb.setSelectedIndex(1);
        } else if (ok.equals("Customer")) {
            username_tf.setEnabled(false);
            password_tf.setEnabled(false);
            repassword_tf.setEnabled(false);
            update_button.setEnabled(false);
            delete_button.setEnabled(false);
        } else {
            username_tf.setEnabled(true);
            password_tf.setEnabled(true);
            repassword_tf.setEnabled(true);
            update_button.setEnabled(true);
            delete_button.setEnabled(true);
            role_cbb.setSelectedIndex(0);
        }
        String user = (String) table_users.getValueAt(row, 1);
        username_tf.setText("" + user);
        role_cbb.setEnabled(false);

    }//GEN-LAST:event_table_usersMouseClicked

    private void repassword_tfKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_repassword_tfKeyReleased
        if (add_button.getText().equals("Search")) {
            add_button.setEnabled(false);
        } else {
            add_button.setEnabled(true);
        }
        role_cbb.setEnabled(true);
        update_button.setEnabled(true);
    }//GEN-LAST:event_repassword_tfKeyReleased

    private void home_btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_home_btActionPerformed
        try {
            ThemeLoginSuccessAdmin loginSuccess = new ThemeLoginSuccessAdmin(iduser_program, username_program);
            setVisible(false);
            loginSuccess.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(ThemeUsers.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_home_btActionPerformed

    private void find_btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_find_btActionPerformed

        try {
            if (find_bt.getText().equals("Show All")) {
                username_tf.setText(null);
                username_tf.setEditable(true);
                add_button.setEnabled(true);
                add_button.setText("Add");
                find_bt.setText("Find The User");
                password_tf.setEnabled(true);
                repassword_tf.setEnabled(true);
                ShowTableUser();
            } else {
                username_tf.setText(null);
                add_button.setEnabled(false);
                password_tf.setEnabled(false);
                repassword_tf.setEnabled(false);

                find_bt.setText("Show All");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ThemeUsers.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_find_btActionPerformed

    private void usage_btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usage_btActionPerformed

        try {
            ThemeUserHistory userhistory = new ThemeUserHistory(iduser_program, username_program);
            setVisible(false);
            userhistory.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(ThemeUsers.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_usage_btActionPerformed

    private void exit_btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exit_btActionPerformed

    }//GEN-LAST:event_exit_btActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        try {
            preparedStatement = connect.prepareStatement("SELECT ID, user_name, role, date_login FROM Users WHERE role = ?");
            preparedStatement.setString(1, "Customer");
            resultset = preparedStatement.executeQuery();
            resultsetmetadata = resultset.getMetaData();
            DefaultTableModel model = new DefaultTableModel();
            int columnoftable = resultsetmetadata.getColumnCount();
            Object[] title = new Object[columnoftable];
            for (int i = 0; i < columnoftable; i++) {
                title[i] = resultsetmetadata.getColumnName(i + 1);
            }
            title[0] = "ID User";
            title[1] = "User Name";
            title[2] = "Role";
            title[3] = "Date Login";

            //add model vào bảng:
            table_users.setModel(model);
            //tiêu đề cho bảng:
            model.setColumnIdentifiers(title);
            //nội dung cho bảng:
            while (resultset.next() != false) {

                Object[] content = new Object[columnoftable];
                for (int i = 0; i < columnoftable; i++) {
                    content[i] = resultset.getString(i + 1);
                }
                model.addRow(content);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ThemeUsers.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButton7ActionPerformed

    private void username_tfKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_username_tfKeyReleased
        if (find_bt.getText().equals("Show All")) {
            try {
                ShowTableUserFind(username_tf.getText());
            } catch (SQLException ex) {
                Logger.getLogger(ThemeUsers.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_username_tfKeyReleased
    public static void main(String[] args) throws SQLException {
        ThemeUsers s = new ThemeUsers("s", "s");
        s.setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add_button;
    private javax.swing.JLabel avatar_lb;
    private javax.swing.JLabel background2_lb;
    private javax.swing.JLabel background_lb;
    private javax.swing.JButton delete_button;
    private javax.swing.JButton exit_bt;
    private javax.swing.JButton find_bt;
    private javax.swing.JLabel hello_lb;
    private javax.swing.JButton home_bt;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel password_lb;
    private javax.swing.JPasswordField password_tf;
    private javax.swing.JLabel repassword_lb;
    private javax.swing.JPasswordField repassword_tf;
    private javax.swing.JComboBox role_cbb;
    private javax.swing.JLabel role_lb;
    private javax.swing.JTable table_users;
    private javax.swing.JScrollPane table_users_scroll;
    private javax.swing.JButton update_button;
    private javax.swing.JButton usage_bt;
    private javax.swing.JLabel username_lb;
    private javax.swing.JTextField username_tf;
    // End of variables declaration//GEN-END:variables
}
