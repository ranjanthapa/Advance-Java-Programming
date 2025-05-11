<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.HashMap" %>

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
        <h2>Job Application</h2>

        <%@ include file="includes/application-filter-container.jsp" %>

        <table class="job-table">
            <thead>
                <tr>
                    <th>S.N</th>
                    <th>Job Title</th>
                    <th>Applicant Name</th>
                    <th>Email</th>
                    <th>Applied On</th>
                    <th>Contact Number</th>
                    <th>Status</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
            <%
                List<HashMap<String, String>> applications = (List<HashMap<String, String>>) request.getAttribute("applications");
                int sn = 1;
                if (applications != null) {
                    for (HashMap<String, String> app : applications) {
                        String statusClass = "status";
                        String appStatus = app.get("application_status");
                        if ("accepted".equalsIgnoreCase(appStatus)) {
                            statusClass += " status-accepted";
                        } else if ("rejected".equalsIgnoreCase(appStatus)) {
                            statusClass += " status-rejected";
                        } else {
                            statusClass += " status-pending";
                        }
            %>
                <tr style="cursor: pointer;">
                    <td><%= sn++ %></td>
                    <td onclick="window.location.href='<%= request.getContextPath() %>/admin/job/details/?id=<%= app.get("jobId") %>'">
                                                <%= app.get("title") %>
                    </td>
                    <td><%= app.get("name") %></td>
                    <td><%= app.get("email") %></td>
                    <td><%= app.get("posted_at") %></td>
                    <td><%= app.get("contact_number") %></td>
                    <td class="<%= statusClass %>"><%= appStatus %></td>
                    <td>
                        <div class="action-buttons">
                            <button onclick="viewApplication(this)"
                                data-id="<%= app.get("applicationId") %>"
                                data-name="<%= app.get("name") %>"
                                data-email="<%= app.get("email") %>"
                                data-contact="<%= app.get("contact_number") %>"
                                data-cover="<%= app.get("cover_letter") %>"
                                data-resume="<%= app.get("resume_path") %>"
                                data-status="<%= app.get("application_status") %>">
                                View
                            </button>



                        </div>
                    </td>
                </tr>
            <%
                    }
                } else {
            %>
                <tr>
                    <td colspan="8">No applications found.</td>
                </tr>
            <%
                }
            %>
            </tbody>
        </table>
    </div>

    <%@ include file="includes/applicant-detail.jsp" %>

    <div id="customToast" class="customToast">
        Job posted successfully!
    </div>
  </div>
   <div id="customToast" class="customToast">
          Job deleted successfully!
      </div>
</body>
<script>
    function showToast(message) {
        const toast = document.getElementById("customToast");
        toast.innerText = message;
        toast.classList.add("show");
        setTimeout(() => {
            toast.classList.remove("show");
        }, 2000);
    }

    <%
        Boolean applicationUpdateStatus = (Boolean) session.getAttribute("applicationUpdateStatus");
        if (applicationUpdateStatus != null && applicationUpdateStatus) {
            session.removeAttribute("applicationUpdateStatus");
    %>
        showToast("Application updated successfully!");
    <% } %>
</script>



<script src="<%= request.getContextPath() %>/scripts/index.js"></script>

</html>
