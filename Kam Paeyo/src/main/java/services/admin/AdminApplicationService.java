package services.admin;

import config.DbConnection;
import queries.ApplicationQuery;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AdminApplicationService {
    
    public static  List<HashMap<String, String>>  getApplications(String recruiter_id) {
        final List<HashMap<String, String>> applicationList = new ArrayList<>();
        try (Connection connection = DbConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(ApplicationQuery.ADMIN_APPLICATION_REQUEST)) {

            stmt.setString(1, recruiter_id);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                HashMap<String, String> applicationDetails = new HashMap<>();
                applicationDetails.put("applicationId", rs.getString("id"));
                applicationDetails.put("name", rs.getString("name"));
                applicationDetails.put("email", rs.getString("email"));
                applicationDetails.put("contact_number", rs.getString("contact_number"));
                applicationDetails.put("resume_path", rs.getString("resume_path"));
                applicationDetails.put("cover_letter", rs.getString("cover_letter"));
                applicationDetails.put("jobId", rs.getString("job_id"));
                applicationDetails.put("applicant_id", rs.getString("applicant_id"));
                applicationDetails.put("application_status", rs.getString("status"));
                applicationDetails.put("title", rs.getString("title"));
                applicationDetails.put("posted_at", rs.getString("created_at"));

                applicationList.add(applicationDetails);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return applicationList;
    };


    public static boolean updateApplication(String application_id, String status) {

        try (Connection connection = DbConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(ApplicationQuery.UPDATE_APPLICATION_STATUS)) {

            stmt.setString(1, status);
            stmt.setString(2, application_id);

            int rowsUpdated = stmt.executeUpdate();
            return rowsUpdated > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static HashMap<String, String> getApplication(String application_id) {
        HashMap<String, String> applicationData = new HashMap<>();

        try (Connection connection = DbConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(ApplicationQuery.GET_APPLICATION)) {

            stmt.setString(1, application_id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                applicationData.put("id", rs.getString("id"));
                applicationData.put("name", rs.getString("name"));
                applicationData.put("email", rs.getString("email"));
                applicationData.put("contactNumber", rs.getString("contact_number"));
                applicationData.put("coverLetter", rs.getString("cover_letter"));
                applicationData.put("jobId", rs.getString("job_id"));
                applicationData.put("resumePath", rs.getString("resume_path"));
                applicationData.put("status", rs.getString("status"));
                applicationData.put("applicant_id", rs.getString("applicant_id"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return applicationData.isEmpty() ? null : applicationData;
    }



}


