package services;

import config.DbConnection;
import model.Recruiter;
import queries.RecruiterQuery;
import utils.DbUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class RecruiterService {
    public  static boolean register(Recruiter recruiter){
        try (Connection conn = DbConnection.getConnection()) {
            if (!DbUtils.checkTableExists(conn, "recruiters")) {
                DbUtils.createTable(RecruiterQuery.CREATE_TABLE, conn);
            }
            try (PreparedStatement stmt = conn.prepareStatement(RecruiterQuery.INSERT_DATA)) {
                stmt.setString(1, recruiter.getId());
                stmt.setString(2, recruiter.getEmail());
                stmt.setString(3, recruiter.getPassword());
                stmt.setString(4, recruiter.getFirmName());
                stmt.setString(5, recruiter.getIndustry());
                stmt.setString(6, recruiter.getWebsite());
                stmt.setString(7, recruiter.getLocation());
                stmt.setTimestamp(8, recruiter.getCreatedAt());
                return stmt.executeUpdate() > 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
