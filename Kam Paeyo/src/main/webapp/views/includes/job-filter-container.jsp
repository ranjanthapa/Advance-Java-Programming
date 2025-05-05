<%@ page import="dto.Job" %>
<%@ page import="java.util.Set" %>
<%@ page import="java.util.HashSet" %>


<div class="filter-container">
    <form method="post" action="<%= request.getContextPath() %>/admin/filter-job" class="form-group-h">

        <select name="company">
            <option value="">Filter by Company</option>
            <%
                // Get the companies from the request
                Set<String> companies = (Set<String>) request.getAttribute("companies");
                if (companies != null) {
                    for (String company : companies) {
            %>
                <option value="<%= company %>"><%= company %></option>
            <%
                    }
                }
            %>
        </select>

        <select name="type">
            <option value="">Filter by Type</option>
            <option value="Full Time">Full-Time</option>
            <option value="Part Time">Part-Time</option>
            <option value="Internship">Internship</option>
        </select>

        <select name="location">
            <option value="">Filter by Location</option>
            <%
                // Get the locations from the request
                Set<String> locations = (Set<String>) request.getAttribute("locations");
                if (locations != null) {
                    for (String location : locations) {
            %>
                <option value="<%= location %>"><%= location %></option>
            <%
                    }
                }
            %>
        </select>

        <select name="status">
            <option value="">Filter by Status</option>
            <option value="ACTIVE">ACTIVE</option>
            <option value="EXPIRED">EXPIRED</option>
        </select>

        <button type="submit">Apply</button>
    </form>
</div>
