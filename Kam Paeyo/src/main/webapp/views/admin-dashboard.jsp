<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Admin Dashboard</title>
  <link rel="stylesheet" type="text/css" href="css/styles.css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
  <style>

  </style>
</head>
<body>
  <div class="dashboard-container">
   <%@ include file="includes/admin-sidebar.jsp" %>


    <div class="main-content">
        <div class="dashboard-header">
        <h1>Welcome, Admin</h1>
        <button class="btn">Add Job</button>
        </div>

        <div class="stats-container">
            <div class="stat-card">
                <h3>Total Users</h3>
                <p>154</p>
            </div>
            <div class="stat-card">
                <h3>Active Jobs</h3>
                <p>28</p>
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
            <h2>Recent Applications</h2>
            <p>Coming soon: List of latest applications...</p>
        </div>
  </div>
</body>
</html>