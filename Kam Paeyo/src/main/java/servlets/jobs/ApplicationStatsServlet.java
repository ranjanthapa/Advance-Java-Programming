package servlets.jobs;

import services.user.ApplicationService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;


@WebServlet("/application/detail")
public class ApplicationStatsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String applicantId = (String) req.getSession().getAttribute("applicantId");

        HashMap<String, Integer> applicationStats = ApplicationService.applicationStats(applicantId);
        List<HashMap<String, String>> recentActivities = ApplicationService.recentActivities(applicantId);
        req.setAttribute("recentActivities", recentActivities);
        req.setAttribute("applicationStats", applicationStats);
        req.getRequestDispatcher("/application.jsp").forward(req, resp);
    }
}
