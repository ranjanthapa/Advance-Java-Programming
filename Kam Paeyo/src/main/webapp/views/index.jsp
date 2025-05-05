<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <title>Job Portal</title>
    <link rel="stylesheet" type="text/css" href="css/styles.css">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" rel="stylesheet">
</head>
<body>
   <%@ include file="includes/navigation.jsp" %>

    <div class="header">
        <h2>Join the most popular internship <br>and companies.</h2>
        <p>Helping freshers land top internships and jobs.</p>

        <div class="search-form">
            <form action="search-results.jsp" method="get" id="formSearch">
                <select name="opportunity" id="opportunity">
                    <option value="">All</option>
                    <option value="internship">Internship</option>
                    <option value="Part Time">Part-Time</option>
                    <option value="Full Time">Full-Time</option>
                </select>

                <input type="text" name="query" placeholder="Search what you are looking for..." />

                <button type="submit" id="search-btn">
                    <i class="fas fa-search"></i>
                </button>
            </form>
        </div>
       <div class="flex-group-h">
           <p>Popular Searched : </p>
           <a href="#">backend</a>
           <a href="#">frontend</a>
           <a href="#">fullstack</a>
       </div>


    </div>




</body>

</html>
