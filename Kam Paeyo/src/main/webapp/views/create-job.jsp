<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Create Job</title>
  <link rel="stylesheet" type="text/css" href="css/styles.css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">


</head>
<body>

<div class="dashboard-container">
   <%@ include file="includes/admin-sidebar.jsp" %>
    <div class="main-content">
        <h2>Create a New Job Posting</h2>
        <form class="job-form" action="job" method="post">
            <div class="form-grid">
                <div class="form-group">
                    <label for="title">Job Title</label>
                    <input type="text" name="title" id="title" required>
                </div>
                <div class="form-group">
                    <label for="company">Company Name</label>
                    <input type="text" name="company" id="company" required>
                </div>

                <div class="form-group">
                    <label for="company">Experience</label>
                    <input type="text" name="experience" id="experience" required>
                </div>

                <div class="form-group-h">

                    <div class="form-group">
                        <label for="location">Location</label>
                        <input type="text" name="location" id="location" required>
                    </div>

                    <div class="form-group">
                        <label for="vacancy">Vacancy</label>
                        <input type="text" name="vacancy" id="vacancy" required>
                    </div>
                </div>

                <div class="form-group">
                    <label for="type">Job Type</label>
                    <select name="type" id="type" required>
                        <option value="">Select Type</option>
                        <option value="Full Time">Full Time</option>
                        <option value="Part Time">Part Time</option>
                        <option value="Internship">Internship</option>
                    </select>
                </div>

                <div class="form-group">
                    <label for="salary">Salary Range</label>
                    <input type="text" name="salary" id="salary" placeholder="e.g. $40,000 - $60,000" required>
                </div>

                <div class="form-group">
                    <label for="deadline">Application Deadline</label>
                    <input type="date" name="deadline" id="deadline" required>
                </div>

                <div class="form-group description">
                    <label for="description">Job Description</label>
                    <textarea name="description" id="description" rows="5" required></textarea>
                </div>

            </div>
            <div class="form-buttons">
                <button type="submit" class="submit-btn">Post Job</button>
                <button type="reset" class="close-btn">Clear</button>
            </div>
        </form>
    </div>

</div>

</body>
</html>
