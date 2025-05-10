package services.user;

import config.DbConnection;
import dto.Applications;
import dto.Job;
import enums.JobStatus;
import queries.ApplicationQuery;
import queries.admin.JobQuery;
import queries.admin.RecruiterQuery;
import queries.users.UserLevelJobQuery;
import utils.DbUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserJobService {

    public static List<Job> getAllJob(){
        List<Job> jobs = new ArrayList<>();
        try (Connection connection = DbConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(UserLevelJobQuery.GET_ALL_JOBS);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Job job = new Job(
                        rs.getString("id"),
                        rs.getString("title"),
                        rs.getString("company"),
                        rs.getString("experience"),
                        rs.getString("location"),
                        rs.getString("vacancy"),
                        rs.getString("type"),
                        rs.getString("salary"),
                        rs.getDate("deadline"),
                        rs.getString("description"),
                        rs.getString("recruiter_id"),
                        rs.getTimestamp("created_at"),
                        JobStatus.valueOf(rs.getString("status").toUpperCase())
                );
                jobs.add(job);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return jobs;
    }


    public static Job getJob(String id) {
        Job job = null;

        try (Connection conn = DbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(UserLevelJobQuery.GET_JOB)) {

            stmt.setString(1, id);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                job = new Job(
                        rs.getString("id"),
                        rs.getString("title"),
                        rs.getString("company"),
                        rs.getString("experience"),
                        rs.getString("location"),
                        rs.getString("vacancy"),
                        rs.getString("type"),
                        rs.getString("salary"),
                        rs.getDate("deadline"),
                        rs.getString("description"),
                        rs.getString("recruiter_id"), // userId
                        rs.getTimestamp("created_at"),
                        JobStatus.valueOf(rs.getString("status").toUpperCase())
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return job;
    }


    public static boolean applyJob(Applications application) {
        try (Connection connection = DbConnection.getConnection()) {
            PreparedStatement stmt = connection.prepareStatement(ApplicationQuery.APPLY_JOB);
            stmt.setString(1, application.getId());
            stmt.setString(2, application.getName());
            stmt.setString(3, application.getEmail());
            stmt.setString(4, application.getContactNumber());
            stmt.setString(5, application.getResumePath());
            stmt.setString(6, application.getCoverLetter());
            stmt.setString(7, application.getJobId());
            stmt.setString(8, application.getApplicant_id());

            int rowsInserted = stmt.executeUpdate();
            return rowsInserted > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

}
