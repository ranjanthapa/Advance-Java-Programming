package services.user;

import config.DbConnection;
import queries.ApplicationQuery;
import queries.GeneralQuery;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ApplicationService {


    private static int getTotalActiveJobs() {
        try (Connection connection = DbConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(GeneralQuery.TOTAL_ACTIVE_JOB);
             ResultSet rs = stmt.executeQuery()) {

            if (rs.next()) {
                return rs.getInt("total_active_job");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }


    public static HashMap<String, Integer> applicationStats(String applicantId) {
        final HashMap<String, Integer> applicantStats = new HashMap<>();
        try (Connection connection = DbConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(ApplicationQuery.APPLICATION_STATS)) {

            stmt.setString(1, applicantId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                applicantStats.put("totalApplied", rs.getInt("total_applied"));
                applicantStats.put("totalAccepted", rs.getInt("total_accepted"));
                applicantStats.put("totalRejected", rs.getInt("total_rejected"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        applicantStats.put("totalActiveJob", getTotalActiveJobs());
        return applicantStats;
    }


    public static List<HashMap<String, String>> recentActivities(String applicantId){

        final List<HashMap<String, String>> activityList = new ArrayList<>();
        try (Connection connection = DbConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(ApplicationQuery.RECENT_ACTIVITY)) {

            stmt.setString(1, applicantId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                HashMap<String, String> jobDetails = new HashMap<>();
                jobDetails.put("jobId", rs.getString("id"));
                jobDetails.put("title", rs.getString("title"));
                jobDetails.put("company", rs.getString("company"));
                jobDetails.put("location", rs.getString("location"));
                jobDetails.put("type", rs.getString("type"));
                activityList.add(jobDetails);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return activityList;
    }




}
