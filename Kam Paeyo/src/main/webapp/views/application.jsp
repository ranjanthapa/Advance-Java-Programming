<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List, java.util.HashMap" %>

<html>
<head>
    <title>Job Portal</title>
     <link rel="stylesheet" href="<%= request.getContextPath() %>/css/styles.css">
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" rel="stylesheet">
</head>
<body>
   <%@ include file="includes/navigation.jsp" %>

   <div class="application-container">
       <div class="application">
            <h3> Hey there, Ranjan Thapa </h3>
            <%@ include file="includes/application-stats.jsp" %>

            <div class="application-recent-activity">
                <p>Recent Activity</p>
                <hr>

                <%
                    List<HashMap<String, String>> recentActivities = (List<HashMap<String, String>>) request.getAttribute("recentActivities");

                    if (recentActivities != null && !recentActivities.isEmpty()) {
                        for (HashMap<String, String> activity : recentActivities) {
                            String title = activity.get("title");
                            String location = activity.get("location");
                            String type = activity.get("type");
                            String jobId = activity.get("jobId");
                %>
                            <div class="activity">
                                <div class="activity-content">
                                    <p><%= title %></p>
                                    <p class="inline-p"><i class="fa-solid fa-location-dot"></i> <%= location %></p>
                                    <p class="inline-p"><i class="fa-solid fa-bag-shopping bag-i"></i> <%= type %></p>
                                </div>
                                <a href="<%= request.getContextPath() %>/job/detail/?id=<%= activity.get("jobId") %>">See Detail</a>

                            </div>
                            <hr>
                <%
                        }
                    } else {
                %>
                    <p>No recent activity found.</p>
                <%
                    }
                %>
            </div>

        </div>
    </div>

</body>
</html>
