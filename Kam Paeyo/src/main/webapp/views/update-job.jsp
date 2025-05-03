<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="dto.Job" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Update Job</title>
    <link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/styles.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
</head>
<body>

<div class="dashboard-container">
   <%@ include file="includes/admin-sidebar.jsp" %>
    <div class="main-content">
        <h2>Update Job</h2>

        <%
            Job job = (Job) request.getAttribute("job");
            if (job != null) {
        %>
        <form class="job-form"  action="<%= request.getContextPath() %>/admin/job/edit"  method="post">
            <div class="form-grid">
                <div class="form-group">
                    <label for="title">Job Title</label>
                    <input type="text" name="title" id="title" value="<%= job.getTitle() %>" required>
                </div>
                <div class="form-group">
                    <label for="company">Company Name</label>
                    <input type="text" name="company" id="company" value="<%= job.getCompany() %>" required>
                </div>

                <div class="form-group">
                    <label for="experience">Experience</label>
                    <input type="text" name="experience" id="experience" value="<%= job.getExperience() %>" required>
                </div>

                <div class="form-group-h">
                    <div class="form-group">
                        <label for="location">Location</label>
                        <input type="text" name="location" id="location" value="<%= job.getLocation() %>" required>
                    </div>

                    <div class="form-group">
                        <label for="vacancy">Vacancy</label>
                        <input type="text" name="vacancy" id="vacancy" value="<%= job.getVacancy() %>" required>
                    </div>
                </div>

                <div class="form-group">
                    <label for="type">Job Type</label>
                    <select name="type" id="type" required>
                        <option value="Full Time" <%= "Full Time".equals(job.getType()) ? "selected" : "" %>>Full Time</option>
                        <option value="Part Time" <%= "Part Time".equals(job.getType()) ? "selected" : "" %>>Part Time</option>
                        <option value="Internship" <%= "Internship".equals(job.getType()) ? "selected" : "" %>>Internship</option>
                    </select>
                </div>

                <div class="form-group">
                    <label for="salary">Salary Range</label>
                    <input type="text" name="salary" id="salary" value="<%= job.getSalary() %>" placeholder="e.g. $40,000 - $60,000" required>
                </div>

                <div class="form-group">
                    <label for="deadline">Application Deadline</label>
                    <input type="date" name="deadline" id="deadline" value="<%= job.getDeadline() != null ? job.getDeadline().toString() : "" %>" required>
                </div>

                <div class="form-group description">
                    <label for="description">Job Description</label>
                    <textarea name="description" id="description" rows="5" required><%= job.getDescription() %></textarea>
                </div>
            </div>

            <!-- Hidden input for the job status -->
            <input type="hidden" name="status" value="<%= job.getStatus() %>">
            <input type="hidden" name="id" value="<%= job.getId() %>">

            <div class="form-buttons">
                <button type="submit" class="submit-btn">Update Job</button>
                <button class="close-btn" type="button" onclick="window.location.href='<%= request.getContextPath() %>/admin/job-list'">Cancel</button>
            </div>
        </form>
        <% } else { %>
            <p>Job not found!</p>
        <% } %>
    </div>
</div>

</body>
</html>
