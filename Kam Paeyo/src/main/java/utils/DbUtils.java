package utils;

import config.DbConnection;
import queries.GeneralQuery;

import java.sql.*;

public class DbUtils {

    public static boolean checkTableExists(Connection conn, String tableName){
        try (PreparedStatement stmt = conn.prepareStatement(GeneralQuery.TABLE_EXISTS)){
            stmt.setString(1, tableName);
            try(ResultSet result = stmt.executeQuery() ){
                System.out.println(result);
            }
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }
        return true;
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
