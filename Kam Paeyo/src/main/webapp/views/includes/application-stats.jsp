<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.HashMap" %>

<div class="application-stats">
    <%
        HashMap<String, Integer> stats = (HashMap<String, Integer>) request.getAttribute("applicationStats");
        if (stats != null) {
    %>
        <div class="stats">
            <div class="sub-stats">
                <h1><%= stats.get("totalApplied") %></h1>
                <p>Applied</p>
            </div>
            <i class="fa-solid fa-bag-shopping bag-i"></i>
        </div>

        <div class="stats">
            <div class="sub-stats">
                <h1><%= stats.get("totalActiveJob") %></h1>
                <p>Alert</p>
            </div>
            <i class="fa-solid fa-circle-exclamation alert-i"></i>
        </div>

        <div class="stats">
            <div class="sub-stats">
                <h1><%= stats.get("totalAccepted") %></h1>
                <p>Accept</p>
            </div>
            <i class="fa-solid fa-check accept-i"></i>
        </div>

        <div class="stats">
            <div class="sub-stats">
                <h1><%= stats.get("totalRejected") %></h1>
                <p>Reject</p>
            </div>
            <i class="fa-solid fa-x reject-i"></i>
        </div>
    <%
        } else {
    %>
        <p>No statistics available.</p>
    <%
        }
    %>
</div>
