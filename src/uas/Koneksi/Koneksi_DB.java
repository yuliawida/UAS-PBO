package uas.Koneksi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Koneksi_DB {

    private static Connection connection;

    public static Connection connection() {
        try {
            // db parameters
            String url = "jdbc:sqlite:dbUas.db";
            connection = DriverManager.getConnection(url);
            System.out.println("Connection successful");
        } catch (SQLException e) {
            System.out.println("Connection failed: " + e.getMessage());
        }
        return connection;
    }
}
