/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pnv.functions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.pnv.project.ThemeLogin;

public class History {

    private static Connection connect;
    private static PreparedStatement preparedStatement = null;
    private static Statement statement;

    ;
    public static String insertHistory(String id, String checknote) {
        try {
        Class.forName("com.mysql.jdbc.Driver");

            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/management_project?user=root&password=");
            if (connect != null) {
                System.out.println("Connected to the database jdb_pactice");
            }
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            System.out.println(dtf.format(now));
            preparedStatement = (PreparedStatement) connect.prepareStatement("INSERT INTO History ( user_ID, time_of_use, history ) VALUES ( ? , ?, ?)");
            preparedStatement.setString(1, id);
             preparedStatement.setString(2, dtf.format(now));
             preparedStatement.setString(3, checknote);
            statement = connect.createStatement();
            preparedStatement.executeUpdate();
            
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "K ket noi");
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }
}
