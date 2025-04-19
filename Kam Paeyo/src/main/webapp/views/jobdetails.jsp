<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <title>Available Jobs</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" rel="stylesheet">
</head>
<body>
   <%@ include file="includes/navigation.jsp" %>

   <section class="job-details">
        <div class="card overview-card">
            <h2>Overview</h2>

            <div class="overview-row">
                <p>Job Title:</p>
                <span>Data Analyst  </span>
            </div>
            <div class="overview-row">
                <p>Experience:</p>
                <span>2yrs Exp</span>
            </div>
            <div class="overview-row">
                <p>Vacancy:</p>
                <span>10</span>
            </div>
            <div class="overview-row">
                <p>Job Type:</p>
                <span>Full-Type</span>
            </div>
            <div class="overview-row">
                <p>Posted Date:</p>
                <span>13-6-2023</span>
            </div>
            <div class="overview-row">
                <p>Last Apply Date:</p>
                <span>12-8-2023</span>
            </div>
            <div class="overview-row">
                <p>Closed Date:</p>
                <span>12-8-2023</span>
            </div>
        </div>

       <div class="details card">
           <h2>Data Analyst</h2>
           <div class="flex-box">
                <p class="text"><i class="fa-solid fa-building"></i>  DrillTheWay </p>
               <p><i class="fa-solid fa-location-dot"></i>  Nepal </p>
           </div>
            <hr class="job-divider">
           <ul class="description-list">
               <li><div class="circle"></div> Looking for a Data Analyst with strong SQL skills.</li>
               <li><div class="circle"></div> Knowledge of data visualization tools like PowerBI or Tableau.</li>
               <li><div class="circle"></div> Familiarity with Python and statistical methods.</li>
               <li><div class="circle"></div> Experience with large datasets and data cleaning.</li>
               <li><div class="circle"></div> Strong problem-solving skills and analytical mindset.</li>
           </ul>

           <h2>Job Details</h2>
           <div class="details-grid">
               <div class="overview-row details-overview-row">
                   <p class="custom-label">Experience:</p>
                   <span>2yrs Exp</span>
               </div>
               <div class="overview-row details-overview-row">
                   <p class="custom-label">Vacancy:</p>
                   <span>10</span>
               </div>
               <div class="overview-row details-overview-row">
                   <p class="custom-label">Job Type:</p>
                   <span>Full-Type</span>
               </div>
               <div class="overview-row details-overview-row">
                   <p class="custom-label">Posted Date:</p>
                   <span>13-6-2023</span>
               </div>
               <div class="overview-row details-overview-row">
                   <p class="custom-label">Last Apply Date:</p>
                   <span>12-8-2023</span>
               </div>
               <div class="overview-row details-overview-row">
                   <p class="custom-label">Closed Date:</p>
                   <span>12-8-2023</span>
               </div>

               <div class="overview-row details-overview-row">
                  <p class="custom-label">Closed Date:</p>
                  <span>12-8-2023</span>
              </div>
            <div class="overview-row details-overview-row">
                <p class="custom-label">Closed Date:</p>
                <span>12-8-2023</span>
              </div>
           </div>

            <div class="apply-btn-container" onclick="openApplyForm()">
                <button class="apply-btn"><i class="fa-solid fa-paper-plane"></i> Apply Now</button>
            </div>
       </div>

   <%@ include file="includes/apply-job.jsp" %>

   </section>
<script src="${pageContext.request.contextPath}/scripts/index.js"></script>

</body>
</html>
