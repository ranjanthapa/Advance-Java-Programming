<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="dto.Job" %>
<html>
<head>
    <title>Available Jobs</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" rel="stylesheet">
</head>
<body>
            <%@ include file="includes/navigation.jsp" %>

       <section class="job-listing">
           <%
               List<Job> jobs = (List<Job>) request.getAttribute("jobs");
               if (jobs != null) {
                   for (Job job : jobs) {
           %>
               <div class="job-card">
                   <h3><%= job.getTitle() %></h3>
                   <div class="flex-box">
                       <p><i class="fa-solid fa-building"></i> <%= job.getCompany() %></p>
                       <p><i class="fa-solid fa-location-dot"></i> <%= job.getLocation() %></p>
                       <p><i class="fa-solid fa-money-check-dollar"></i> <%= job.getSalary() %></p>
                       <p><i class="fa-solid fa-clock"></i> <%= job.getType() %></p>
                   </div>
                   <p class="job-description"><%= job.getDescription() %></p>
                   <hr class="job-divider" />
                   <a href="<%= request.getContextPath() %>/job/detail/?id=<%= job.getId() %>" class="apply-btn">View Detail</a>
               </div>
           <%
                   }
               }
           %>
       </section>


   <script src="scripts/index.js"></script>
</body>
</html>
