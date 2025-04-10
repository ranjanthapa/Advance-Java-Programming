package services;

import config.DbConnection;
import model.Candidate;
import queries.CandidateQuery;
import utils.annotations.TableExists;

import java.sql.*;

public class CandidateService {

    @TableExists(tableName = "candidate", createQuery = CandidateQuery.CREATE_CANDIDATE_TABLE)
    public static boolean register(Candidate candidate) {
        try (Connection conn = DbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(CandidateQuery.INSERT_DATA)) {
            stmt.setString(1, candidate.getEmail());
            stmt.setString(2, candidate.getPassword());
            stmt.setString(3, candidate.getFirstName());
            stmt.setString(4, candidate.getLastName());
            stmt.setString(5, candidate.getPhoneNumber());
            return stmt.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
