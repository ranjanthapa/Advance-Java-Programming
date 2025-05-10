<section class="navigation">
  <ul class="nav-list">
    <li><a href="<%= request.getContextPath() %>/index.jsp">Home</a></li>
    <li><a href="">Internship</a></li>
    <li><a href="<%= request.getContextPath() %>/jobs">Jobs</a></li>

    <%
        String email = (String) session.getAttribute("email");
        if (email != null) {
    %>
        <li><a href="<%= request.getContextPath() %>/application/detail">Application</a></li>
        <li><a href="<%= request.getContextPath() %>/logout">Logout</a></li>
    <%
        } else {
    %>
        <li><a href="<%= request.getContextPath() %>/login.jsp">Login</a></li>
        <li class="register-container">
          <button class="register-btn">Register</button>
          <div class="register-as-box">
            <a href="<%= request.getContextPath() %>/signup-as-candidate.jsp">Register as Candidate</a><br />
            <a href="<%= request.getContextPath() %>/signup-as-recruiter.jsp">Register as Recruiter</a>
          </div>
        </li>
    <%
        }
    %>
  </ul>
</section>

<script src="scripts/index.js"></script>
