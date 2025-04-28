package services;

import config.DbConnection;
import dto.Job;
import queries.JobQuery;
import utils.DbUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JobService {

    public static boolean postJob(Job job) {
        try (Connection connection = DbConnection.getConnection()) {
            if (!DbUtils.checkTableExists(connection, "jobs")) {
                DbUtils.createTable(JobQuery.CREATE_JOB_TABLE, connection);
            }
            PreparedStatement stmt = connection.prepareStatement(JobQuery.INSERT_JOB);
            stmt.setString(1, job.getId());
            stmt.setString(2, job.getUserId());  // new line
            stmt.setString(3, job.getTitle());
            stmt.setString(4, job.getCompany());
            stmt.setString(5, job.getExperience());
            stmt.setString(6, job.getLocation());
            stmt.setString(7, job.getVacancy());
            stmt.setString(8, job.getType());
            stmt.setString(9, job.getSalary());
            stmt.setDate(10, job.getDeadline());
            stmt.setString(11, job.getDescription());

            int rowsInserted = stmt.executeUpdate();
            return rowsInserted > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static int getTotalJobCount(String userId) {
        try (Connection connection = DbConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(JobQuery.TOTAL_JOB_POSTED)) {

            stmt.setString(1, userId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return rs.getInt("total_jobs");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static int getTotalActiveJobs(String userId) {
        try (Connection connection = DbConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(JobQuery.TOTAL_ACTIVE_JOB)) {

            stmt.setString(1, userId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return rs.getInt("active_job");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }


    private static void updateJobStatuses(Connection connection) {
        try (PreparedStatement stmt = connection.prepareStatement(JobQuery.STATUS_UPDATE)) {
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static List<Job> getJobs(Integer limit) {
        List<Job> jobs = new ArrayList<>();
        String getJobQuery = JobQuery.GET_JOBS;

        if (limit != null && limit > 0) {
            getJobQuery += " LIMIT ?";
        }

        try (Connection connection = DbConnection.getConnection()) {
            updateJobStatuses(connection);

            try (PreparedStatement preparedStatement = connection.prepareStatement(getJobQuery)) {
                if (limit != null && limit > 0) {
                    preparedStatement.setInt(1, limit);
                }

                ResultSet rs = preparedStatement.executeQuery();

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
                            rs.getTimestamp("created_at")
                    );
                    jobs.add(job);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return jobs;
    }


}
