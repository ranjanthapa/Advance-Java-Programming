package services;

import config.DbConnection;
import dto.Recruiter;
import queries.RecruiterQuery;
import utils.DbUtils;
import utils.PasswordUtils;
import utils.UserUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RecruiterService {
    public  static boolean register(Recruiter recruiter){
        try (Connection conn = DbConnection.getConnection()) {
            if (!DbUtils.checkTableExists(conn, "recruiters")) {
                DbUtils.createTable(RecruiterQuery.CREATE_TABLE, conn);
            }

            String hashPassword = PasswordUtils.hashPassword(recruiter.getPassword());
            try (PreparedStatement stmt = conn.prepareStatement(RecruiterQuery.INSERT_DATA)) {
                stmt.setString(1, recruiter.getId());
                stmt.setString(2, recruiter.getEmail());
                stmt.setString(3, hashPassword);
                stmt.setString(4, recruiter.getFirmName());
                stmt.setString(5, recruiter.getIndustry());
                stmt.setString(6, recruiter.getWebsite());
                stmt.setString(7, recruiter.getLocation());
                return stmt.executeUpdate() > 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    public static String login(String email, String password) {
        try (Connection conn = DbConnection.getConnection()) {
            String userId = UserUtils.checkCredential(conn, email, password, RecruiterQuery.FETCH_USER_BY_EMAIL);

            if (userId != null) {
                System.out.println("Login successful for user: " + email + " with id: " + userId);
                return userId;
            } else {
                System.out.println("Invalid email or password.");
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


}
