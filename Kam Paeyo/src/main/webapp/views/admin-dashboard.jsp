<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="dto.Job" %>

<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Admin Dashboard</title>
  <link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/styles.css">

  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
</head>
<body>
  <div class="dashboard-container">
    <%@ include file="includes/admin-sidebar.jsp" %>

    <div class="main-content">
        <div class="dashboard-header">
            <h1>Welcome, Admin</h1>
            <a href="<%= request.getContextPath() %>/create-job.jsp" class="btn">
                Add Job
            </a>
        </div>

        <div class="stats-container">
            <div class="stat-card">
                <h3>Total Job Posted</h3>
                <p><%= request.getAttribute("totalJobs") %></p>
            </div>
            <div class="stat-card">
                <h3>Active Jobs</h3>
                <p><%= request.getAttribute("totalActiveJobs") %></p>

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
        <h2>Recent Job Posts</h2>



        <table class="job-table">
            <thead>
                <tr>
                    <th>Job Title</th>
                    <th>Company</th>
                    <th>Location</th>
                    <th>Date Posted</th>
                    <th>DeadLine</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <%
                    List<Job> jobs = (List<Job>) request.getAttribute("postedJobList");
                    if (jobs != null) {
                        for (Job job : jobs) {
                %>
                <tr>
                    <td><%= job.getTitle() %></td>
                    <td><%= job.getCompany() %></td>
                    <td><%= job.getLocation() %></td>
                    <td><%= job.getCreatedAt() %></td>

                    <td><%= job.getFormattedDeadline() %></td>

                    <td><button class="btn">Delete</button></td>

                </tr>
                <%
                        }
                    }
                %>
            </tbody>
        </table>
    </div>
  </div>

  <div id="customToast" class="customToast">
      Job posted successfully!
  </div>

  <script>
      function showCustomToast() {
          var toast = document.getElementById('customToast');
          toast.classList.add('show');  // Add class to show the toast
          setTimeout(function() {
              toast.classList.remove('show');  // Remove class after 3 seconds
          }, 2000);
      }

      <%
         Boolean jobPosted = (Boolean) session.getAttribute("jobPosted");
         if (jobPosted != null && jobPosted) {
             session.removeAttribute("jobPosted");
      %>
          showCustomToast();
      <% } %>
  </script>
</body>
</html>
