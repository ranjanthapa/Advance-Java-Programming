package services;

import config.DbConnection;
import model.Candidate;

import java.sql.*;

public class CandidateService {

    private final Connection conn;

    public CandidateService() {
        this.conn = DbConnection.getConnection();
    }

    public boolean register(Candidate candidate) {
        String query = "INSERT INTO candidates (email, password, first_name, last_name, phone_number) VALUES (?,?, ?, ?, ?)";
        try (PreparedStatement stmt = this.conn.prepareStatement(query)) {
            stmt.setString(1, candidate.getEmail());
            stmt.setString(2, candidate.getPassword());
            stmt.setString(3, candidate.getFirstName());
            stmt.setString(4, candidate.getLastName());
            stmt.setString(5, candidate.getPhoneNumber());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
