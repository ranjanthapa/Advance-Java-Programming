<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Admin Dashboard</title>
  <link rel="stylesheet" type="text/css" href="css/styles.css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
  <style>

  </style>
</head>
<body>
  <div class="dashboard-container">
   <%@ include file="includes/admin-sidebar.jsp" %>


    <div class="main-content">
        <div class="dashboard-header">
        <h1>Welcome, Admin</h1>
       <a href="create-job.jsp" class="btn">
           Add Job
       </a>

        </div>

        <div class="stats-container">
            <div class="stat-card">
                <h3>Total Users</h3>
                <p>154</p>
            </div>
            <div class="stat-card">
                <h3>Active Jobs</h3>
                <p>28</p>
            </div>
            <div class="stat-card">
                <h3>Applications</h3>
                <p>203</p>
            </div>
            <div class="stat-card">
                <h3>Pending Reviews</h3>
                <p>11</p>
            </div>
        </div>

        <div class="divider"></div>
        <h2>Posted Jobs</h2>
            <table class="job-table">
                        <thead>
                            <tr>
                                <th>Job Title</th>
                                <th>Company</th>
                                <th>Location</th>
                                <th>Date Posted</th>
                                <th>Actions</th>
                            </tr>
                        </thead>
                        <tbody>
                            <!-- Example job entries (use dynamic data from the backend) -->
                            <tr>
                                <td>Software Engineer</td>
                                <td>ABC Corp</td>
                                <td>Kathmandu, Nepal</td>
                                <td>2025-04-20</td>
                                <td><button class="apply-btn">Apply</button></td>
                            </tr>
                            <tr>
                                <td>Marketing Specialist</td>
                                <td>XYZ Ltd</td>
                                <td>Pokhara, Nepal</td>
                                <td>2025-04-18</td>
                                <td><button class="apply-btn">Apply</button></td>
                            </tr>
                            <!-- Repeat the above rows dynamically for all posted jobs -->
                        </tbody>
                    </table>
        </div>
  </div>
</body>
</html>