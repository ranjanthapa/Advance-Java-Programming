package utils;

import model.Candidate;
import queries.GeneralQuery;

import java.sql.*;

public class DbUtils {

    public static boolean checkTableExists(Connection conn, String tableName) {
        System.out.println("Connection from function" + conn);
        try (PreparedStatement stmt = conn.prepareStatement(GeneralQuery.TABLE_EXISTS)) {
            stmt.setString(1, tableName);
            try (ResultSet result = stmt.executeQuery()) {
                System.out.println("Checking table exists in the db utils" + result);
                System.out.println(result.next());
                return result.next();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean createTable(String createTableQuery, Connection conn){
        try (Statement stmt = conn.createStatement() ){
            stmt.executeUpdate(createTableQuery);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }




}
