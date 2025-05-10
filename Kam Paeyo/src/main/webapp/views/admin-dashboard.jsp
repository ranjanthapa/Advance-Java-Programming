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
                <th>S.N</th>
                    <th>Job Title</th>
                    <th>Company</th>
                    <th>Location</th>
                    <th>Date Posted</th>
                    <th>DeadLine</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                <%
                    List<Job> jobs = (List<Job>) request.getAttribute("postedJobList");
                    if (jobs != null) {
                        int sn = 1;
                        for (Job job : jobs) {
                %>
                <tr style="cursor: pointer;">
                    <td><%= sn++ %></td>
                    <td onclick="window.location.href='<%= request.getContextPath() %>/admin/job/details/?id=<%= job.getId() %>'">
                        <%= job.getTitle() %>
                    </td>
                    <td><%= job.getCompany() %></td>
                    <td><%= job.getLocation() %></td>
                    <td><%= job.getCreatedAt() %></td>
                    <td><%= job.getFormattedDeadline() %></td>
                    <td>
                        <div class="action-buttons">
                            <button  class="btn-edit">
                            <a href="<%= request.getContextPath() %>/admin/job/edit?id=<%= job.getId() %>">
                                Edit
                            </a>
                            </button>
                            <button class="btn-delete" onclick="openDeleteModal('<%= job.getId() %>')">
                                Delete
                            </button>
                        </div>
                    </td>
                </tr>
                <%
                        }
                    }
                %>
            </tbody>
        </table>
    </div>
  </div>
  <div id="modal-overlay" class="modal" style="display:none;">
          <div class="modal-content">
              <h3>Confirm Deletion</h3>
              <p>Are you sure you want to delete this job?</p>
              <div class="modal-actions">
                  <button id="confirmDelete" class="btn-delete" onclick="confirmDelete()">Delete</button>
                  <button class="btn-cancel" onclick="onCancel()">Cancel</button>
              </div>
          </div>
      </div>


AvailableJobsServlet.java


  <div id="customToast" class="customToast">
      Job posted successfully!
  </div>

  <script>
  const contextPath = "<%= request.getContextPath() %>";
          let selectedJobId = null;

          function openDeleteModal(jobId) {
              selectedJobId = jobId;
              document.getElementById("modal-overlay").style.display = "flex";
          }

          function onCancel() {
              selectedJobId = null;
              document.getElementById("modal-overlay").style.display = "none";
          }

          function confirmDelete() {
                      if (!selectedJobId) {
                          console.warn("No job ID selected.");
                          return;
                      }

                      let deleteUrl = contextPath + "/admin/job?id=" + selectedJobId;

                      fetch(deleteUrl, {
                          method: "DELETE"
                      })
                      .then(response => {
                          if (response.ok) {
                              showToast("Job deleted successfully!");
                              setTimeout(() => {
                                  location.reload(); // Reload to reflect changes
                              }, 1000);
                          } else {
                              return response.json().then(data => {
                                  throw new Error(data.message || "Failed to delete.");
                              });
                          }
                      })
                      .catch(error => {
                          console.error("Error:", error);
                      });

                      document.getElementById("modal-overlay").style.display = "none";
                  }


        function showToast(message) {
            const toast = document.getElementById("customToast");
            toast.innerText = message;
            toast.classList.add("show");
            setTimeout(() => {
                toast.classList.remove("show");
            }, 2000);
        }

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
         showToast("JOb posted successfully");
      <% } %>
  </script>
</body>
</html>
