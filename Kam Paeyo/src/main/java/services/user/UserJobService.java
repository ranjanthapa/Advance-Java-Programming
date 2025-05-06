package services.user;

import config.DbConnection;
import dto.Job;
import enums.JobStatus;
import queries.admin.JobQuery;
import queries.users.UserLevelJobQuery;

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

}
