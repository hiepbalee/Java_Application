package org.pnv.functions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseHelper {

    private static Connection connect;

    static {

        try {

            Class.forName("com.mysql.jdbc.Driver");

            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/management_project?user=root&password=");
            if (connect != null) {
                System.out.println("Connected to the database success !!");
            }

        } catch (ClassNotFoundException ex) {
        } catch (SQLException ex) {
        }

    }

    public static Connection getConnection() {
        return connect;
    }
}
