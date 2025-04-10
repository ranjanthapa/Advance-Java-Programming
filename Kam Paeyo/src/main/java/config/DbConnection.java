package config;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {
    private static final String URL = "jdbc:postgresql://localhost:5432/kampayeoDb";
    private static final String USER = "postgres";
    private static final String PASSWORD = "qwerty";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            System.out.println("Database connected");
            connection =  DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        }
    return connection;
    }
}
