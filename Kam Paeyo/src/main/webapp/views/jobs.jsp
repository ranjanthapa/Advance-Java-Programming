<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <title>Available Jobs</title>
    <link rel="stylesheet" type="text/css" href="css/styles.css">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" rel="stylesheet">
</head>
<body>
   <%@ include file="includes/navigation.jsp" %>

   <section class="job-listing">


       <div class="job-card">
          <h3>Data Analyst</h3>
          <div class="flex-box">
              <p><i class="fa-solid fa-building"></i>  DrillTheWay </p>
              <p>|</p>
              <p><i class="fa-solid fa-location-dot"></i>  Nepal </p>
              <p>|</p>

              <p><i class="fa-solid fa-money-check-dollar"></i>  $2000</p>
              <p>|</p>

              <p><i class="fa-solid fa-clock"></i>  FullTime</p>
          </div>
          <p class="job-description" >A data analyst collects, interprets and visualizes data to uncover insights. A data analyst assigns a
          numerical value to business functions so performance is assessed and compared over time.</p>

          <hr class="job-divider" />

          <a href="jobdetails.jsp" class="apply-btn">View Detail</a>

        </div>

   </section>

   <script src="scripts/index.js"></script>
</body>
</html>
