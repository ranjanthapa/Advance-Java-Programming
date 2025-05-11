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
import java.util.Map;

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
                applicationDetails.put("company", rs.getString("company"));
                applicationDetails.put("location", rs.getString("location"));
                applicationDetails.put("type", rs.getString("type"));

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

    public static List<HashMap<String, String>> filterApplication(String recruiterId, Map<String, String> queryParams) {
        List<HashMap<String, String>> applications = new ArrayList<>();
        StringBuilder query = new StringBuilder(ApplicationQuery.ADMIN_APPLICATION_FILTER);

        // Define valid filters and map them to fully-qualified column names
        Map<String, String> columnMapping = Map.of(
                "status", "applications.status",
                "company", "temp.company",
                "type", "temp.type",
                "location", "temp.location"
        );

        List<String> validFilters = List.of("status", "company", "type", "location");

        List<Object> params = new ArrayList<>();
        params.add(recruiterId);  // Always include recruiterId as the first parameter

        // Dynamically build the query based on provided filters
        for (String key : validFilters) {
            String value = queryParams.get(key);
            if (value != null && !value.trim().isEmpty()) {
                String qualifiedColumn = columnMapping.get(key);
                query.append(" AND ").append(qualifiedColumn).append(" = ?");
                params.add(value.trim());
            }
        }

        query.append(" ORDER BY CASE LOWER(applications.status) ")
                .append("WHEN 'pending' THEN 1 ")
                .append("WHEN 'accepted' THEN 2 ")
                .append("WHEN 'rejected' THEN 3 ")
                .append("ELSE 4 END");

        try (Connection conn = DbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query.toString())) {

            // Set parameters in the PreparedStatement
            for (int i = 0; i < params.size(); i++) {
                stmt.setObject(i + 1, params.get(i));
            }

            // Execute and collect results
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    HashMap<String, String> row = new HashMap<>();
                    row.put("applicationId", rs.getString("id"));
                    row.put("name", rs.getString("name"));
                    row.put("email", rs.getString("email"));
                    row.put("contact_number", rs.getString("contact_number"));
                    row.put("resume_path", rs.getString("resume_path"));
                    row.put("cover_letter", rs.getString("cover_letter"));
                    row.put("jobId", rs.getString("job_id"));
                    row.put("applicant_id", rs.getString("applicant_id"));
                    row.put("application_status", rs.getString("status"));
                    row.put("title", rs.getString("title"));
                    row.put("posted_at", rs.getString("created_at"));
                    row.put("company", rs.getString("company"));
                    row.put("location", rs.getString("location"));
                    row.put("type", rs.getString("type"));

                    applications.add(row);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return applications;
    }





}


