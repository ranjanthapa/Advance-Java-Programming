package services;

import config.DbConnection;
import dto.Job;
import queries.CandidateQuery;
import queries.JobQuery;
import utils.DbUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
}
