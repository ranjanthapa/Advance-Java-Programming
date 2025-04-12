package utils;

import queries.CandidateQuery;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserUtils {
    public static ResultSet checkCredential(Connection conn, String email, String password) {
        try {
            PreparedStatement stmt = conn.prepareStatement(CandidateQuery.LOGIN_QUERY);
            stmt.setString(1, email);
            stmt.setString(2, password);
            return stmt.executeQuery();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
