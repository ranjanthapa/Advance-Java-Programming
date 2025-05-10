<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="dto.Job" %>
<%
    Job job = (Job) request.getAttribute("job");
%>
<html>
<head>
    <title>Available Jobs</title>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/css/styles.css">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" rel="stylesheet">
</head>
<body>
<%@ include file="includes/navigation.jsp" %>

<section class="job-details">
    <div class="card overview-card">
        <h2>Overview</h2>

        <div class="overview-row">
            <p>Job Title:</p>
            <span><%= job.getTitle() %></span>
        </div>
        <div class="overview-row">
            <p>Experience:</p>
            <span><%= job.getExperience() %></span>
        </div>
        <div class="overview-row">
            <p>Vacancy:</p>
            <span><%= job.getVacancy() %></span>
        </div>
        <div class="overview-row">
            <p>Job Type:</p>
            <span><%= job.getType() %></span>
        </div>
        <div class="overview-row">
            <p>Posted Date:</p>
            <span><%= job.getCreatedAt() %></span>
        </div>
        <div class="overview-row">
            <p>Last Apply Date:</p>
            <span><%= job.getFormattedDeadline() %></span>
        </div>
        <div class="overview-row">
            <p>Closed Date:</p>
            <span><%= job.getFormattedDeadline() %></span>
        </div>
    </div>

    <div class="details card">
        <h2><%= job.getTitle() %></h2>
        <div class="flex-box">
            <p class="text"><i class="fa-solid fa-building"></i> <%= job.getCompany() %></p>
            <p><i class="fa-solid fa-location-dot"></i> <%= job.getLocation() %></p>
        </div>
        <hr class="job-divider">
        <ul class="description-list">
            <li><div class="circle"></div> <%= job.getDescription() %></li>
        </ul>

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

            <div class="overview-row details-overview-row">
                <p class="custom-label">Closed Date:</p>
                <span><%= job.getFormattedDeadline() %></span>
            </div>
            <div class="overview-row details-overview-row">
                <p class="custom-label">Salary:</p>
                <span><%= job.getSalary() %></span>
            </div>
        </div>

        <% if ("EXPIRED".equalsIgnoreCase(job.getStatus().toString())) { %>
            <div class="apply-btn-container">
                <button class="apply-btn expired" disabled>
                    <i class="fa-solid fa-ban"></i> Expired
                </button>
            </div>
        <% } else { %>
            <div class="apply-btn-container" onclick="openApplyForm()">
                <button class="apply-btn">
                    <i class="fa-solid fa-paper-plane"></i> Apply Now
                </button>
            </div>
        <% } %>


    </div>

<%@ include file="includes/apply-job.jsp" %>

    <div id="customToast" class="customToast">
    </div>


</section>


<script>
    function showToast(message, color) {
        const toast = document.getElementById("customToast");
        toast.innerText = message;
        toast.style.background = color;
        toast.classList.add("show");
        setTimeout(() => {
            toast.classList.remove("show");
        }, 2000);
    }

    <%
        Boolean applyStatus = (Boolean) session.getAttribute("applyStatus");
        if (applyStatus != null && applyStatus) {
            session.removeAttribute("applyStatus");
    %>
        showToast("Apply successfully!", "green");
    <% } %>

    <%
        Boolean isLoginRequired = (Boolean) session.getAttribute("loginRequired");
        if (isLoginRequired != null && isLoginRequired) {
            session.removeAttribute("loginRequired");
    %>
        showToast("Login required!", "red");
    <%
        }
    %>

</script>
<script src="<%= request.getContextPath() %>/scripts/index.js"></script>

</body>
</html>
