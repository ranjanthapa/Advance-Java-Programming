package config;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {
    private static final String URL = "jdbc:postgresql://localhost:5432/KamPayoDB";
    private static final String USER = "postgres";
    private static final String PASSWORD = "qwerty";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection =  DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        }
    return connection;
    }
}
