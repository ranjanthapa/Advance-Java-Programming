<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="dto.Job" %>
<%@ page import="enums.JobStatus" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Dashboard</title>
    <link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/styles.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
</head>

<body>
    <div class="dashboard-container">
        <%@ include file="includes/admin-sidebar.jsp" %>

        <div class="main-content">
            <h2>All Job Posts</h2>
            <%@ include file="includes/job-filter-container.jsp" %>

            <table class="job-table">
                <thead>
                    <tr>
                        <th>S.N</th>
                        <th>Job Title</th>
                        <th>Company</th>
                        <th>Type</th>
                        <th>Location</th>
                        <th>Date Posted</th>
                        <th>Deadline</th>
                        <th>Status</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                    List<Job> jobs = (List<Job>) request.getAttribute("jobList");
                    if (jobs != null) {
                        int sn = 1;
                        for (Job job : jobs) {
                    %>
                    <tr>
                        <td><%= sn++ %></td>
                        <td><%= job.getTitle() %></td>
                        <td><%= job.getCompany() %></td>
                        <td><%= job.getType() %></td>
                        <td><%= job.getLocation() %></td>
                        <td><%= job.getCreatedAt() %></td>
                        <td><%= job.getFormattedDeadline() %></td>
                        <td class="<%= job.getStatus() == JobStatus.ACTIVE ? "status-active" : "inactive-status" %>">
                            <%= job.getStatus() %>
                        </td>
                        <td>
                            <div class="action-buttons">
                                <button class="btn-edit"> <a href="<%= request.getContextPath() %>/admin/job/edit?id=<%= job.getId() %>" class="btn-edit">Edit</a></button>
                                <button class="btn-delete" onclick="openDeleteModal('<%= job.getId() %>')">Delete</button>
                            </div>
                        </td>
                    </tr>
                    <% } } %>
                </tbody>
            </table>
        </div>
    </div>

    <!-- Modal -->
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

    <!-- Toast -->
    <div id="customToast" class="customToast">
        Job deleted successfully!
    </div>

    <script>
        // Declare global variables
        const contextPath = "<%= request.getContextPath() %>";
        let selectedJobId = null;

        function openDeleteModal(jobId) {
            selectedJobId = jobId;
            console.log("Selected job ID to delete:", selectedJobId);
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

        <%
        Boolean jobPosted = (Boolean) session.getAttribute("jobPosted");
        if (jobPosted != null && jobPosted) {
            session.removeAttribute("jobPosted"); %>
            showToast("Job posted successfully!");
        <% } %>

        <%
        Boolean jobUpdated = (Boolean) session.getAttribute("jobUpdated");
        if (jobUpdated != null && jobUpdated) {
            session.removeAttribute("jobUpdated");
        %>
            showToast("Job updated successfully!");
        <% } %>



    </script>
</body>

</html>
