package services;

import config.DbConnection;
import dto.Candidate;
import queries.users.CandidateQuery;
import utils.DbUtils;
import utils.UserUtils;

import java.sql.*;

public class CandidateService {

public static boolean register(Candidate candidate) {
    try (Connection conn = DbConnection.getConnection()) {
        if (DbUtils.checkTableExists(conn, "candidates")) {
            DbUtils.createTable(CandidateQuery.CREATE_CANDIDATE_TABLE, conn);
        }
        try (PreparedStatement stmt = conn.prepareStatement(CandidateQuery.INSERT_DATA)) {
            stmt.setString(1, candidate.getId());
            stmt.setString(2, candidate.getEmail());
            stmt.setString(3, candidate.getPassword());
            stmt.setString(4, candidate.getFirstName());
            stmt.setString(5, candidate.getLastName());
            stmt.setString(6, candidate.getLocation());
            stmt.setString(7, candidate.getWebsite());
            stmt.setString(8, candidate.getPhoneNumber()); // was 9
            stmt.setString(9, candidate.getEducation());   // was 8

            return stmt.executeUpdate() > 0;
        }
    } catch (Exception e) {
        e.printStackTrace();
        return false;
    }
}

    public static boolean login(String email, String password) {
        try (Connection conn = DbConnection.getConnection()) {
            String userId = UserUtils.checkCredential(conn, email, password, CandidateQuery.FETCH_USER_BY_EMAIL);

            if (userId != null) {
                System.out.println("Login successful for user: " + email + " with id: " + userId);
                return true;
            } else {
                System.out.println("Invalid email or password.");
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }



}
