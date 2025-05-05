<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="dto.Job" %>

<!DOCTYPE html>
<html lang="en">
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

<%
    Job job = (Job) request.getAttribute("job");
%>
        <div class="details">
            <h2><%= job.getTitle() %></h2>
            <div class="flex-box">
                <p class="text"><i class="fa-solid fa-building"></i> <%= job.getCompany() %></p>
                <p><i class="fa-solid fa-location-dot"></i> <%= job.getLocation() %></p>
            </div>
            <hr class="job-divider">
                    <p class="description" ><%= job.getDescription() %></p>
            <hr class="job-divider">

            <h2>Job Details</h2>
            <div class="details-grid">
                <div class="overview-row details-overview-row">
                    <p class="custom-label">Experience:</p>
                    <span><%= job.getExperience() %></span>
                </div>
                <div class="overview-row details-overview-row">
                    <p class="custom-label">Vacancy:</p>
                    <span><%= job.getVacancy() %></span>
                </div>
                <div class="overview-row details-overview-row">
                    <p class="custom-label">Job Type:</p>
                    <span><%= job.getType() %></span>
                </div>
                <div class="overview-row details-overview-row">
                    <p class="custom-label">Posted Date:</p>
                    <span><%= job.getCreatedAt() %></span>
                </div>
                <div class="overview-row details-overview-row">
                    <p class="custom-label">Last Apply Date:</p>
                    <span><%= job.getFormattedDeadline() %></span>
                </div>

            </div>


        </div>
    </div>
</div>
</body>
</html>
