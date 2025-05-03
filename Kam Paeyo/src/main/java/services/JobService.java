package services;

import config.DbConnection;
import dto.Job;
import enums.JobStatus;
import queries.JobQuery;
import utils.DbUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class JobService {

    public static boolean postJob(Job job) {
        try (Connection connection = DbConnection.getConnection()) {
            if (!DbUtils.checkTableExists(connection, "jobs")) {
                DbUtils.createTable(JobQuery.CREATE_JOB_TABLE, connection);
            }
            PreparedStatement stmt = connection.prepareStatement(JobQuery.INSERT_JOB);
            stmt.setString(1, job.getId());
            stmt.setString(2, job.getUserId());
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


    public static Job getJob(String id, String recruiterId) {
        Job job = null;

        try (Connection conn = DbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(JobQuery.GET_A_JOB)) {

            stmt.setString(1, id);
            stmt.setString(2, recruiterId);

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



    public static boolean updateJob(Job job) {

        try (Connection connection = DbConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(JobQuery.UPDATE_JOB)) {

            stmt.setString(1, job.getTitle());
            stmt.setString(2, job.getCompany());
            stmt.setString(3, job.getExperience());
            stmt.setString(4, job.getLocation());
            stmt.setString(5, job.getVacancy());
            stmt.setString(6, job.getType());
            stmt.setString(7, job.getSalary());
            stmt.setDate(8, job.getDeadline());
            stmt.setString(9, job.getDescription());
            stmt.setString(10, job.getId());
            stmt.setString(11, job.getUserId());
            int rowsUpdated = stmt.executeUpdate();
            return rowsUpdated > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }



    public static List<Job> getJobs(Integer limit,String recruiterId) {
        List<Job> jobs = new ArrayList<>();
        String getJobQuery = JobQuery.GET_JOBS;

        System.out.println("Printing the recruiter id" + recruiterId);

        if (limit != null && limit > 0) {
            getJobQuery += " LIMIT ?";
        }
        try (Connection connection = DbConnection.getConnection()) {
            updateJobStatuses(connection);

            try (PreparedStatement preparedStatement = connection.prepareStatement(getJobQuery)) {
                preparedStatement.setString(1, recruiterId);

                if (limit != null && limit > 0) {
                    preparedStatement.setInt(2, limit);
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
                            rs.getTimestamp("created_at"),
                            JobStatus.valueOf(rs.getString("status").toUpperCase())
                    );
                    jobs.add(job);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return jobs;
    }

    public static boolean deleteJob(String jobId, String authorId) {
        try (Connection connection = DbConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(JobQuery.DELETE_JOB)) {

            stmt.setString(1, jobId);
            stmt.setString(2, authorId);
            System.out.println(jobId + authorId + "From the service method");
            int rowsAffected = stmt.executeUpdate();
            System.out.println(jobId + "is being deleted.............");
            System.out.println(rowsAffected > 0);
            return rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }


    public static List<Job> filterJob(String authorId, Map<String, String> queryParams) {
        List<Job> jobs = new ArrayList<>();
        StringBuilder query = new StringBuilder(JobQuery.FILTER_JOB);
        List<String> validFilters = List.of("company", "type", "location", "status");

        List<Object> params = new ArrayList<>();
        params.add(authorId);

        for (String key : validFilters) {
            String value = queryParams.get(key);
            if (!value.isEmpty()) {
                query.append(" AND ").append(key).append(" = ?");
                params.add(value);
            }
        }

        query.append(" ORDER BY created_at DESC");

        System.out.println(query);

        try (Connection conn = DbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query.toString())) {

            for (int i = 0; i < params.size(); i++) {
                stmt.setObject(i + 1, params.get(i));
            }

            ResultSet rs = stmt.executeQuery();
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
        System.out.println("all the filter jobs are " + jobs);
        return jobs;
    }



}
