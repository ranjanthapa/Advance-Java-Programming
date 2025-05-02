package servlets;

import dto.Job;
import services.JobService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/admin/filter-job")
public class JobFilter extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String recruiterId = (String) req.getSession().getAttribute("userId");
        System.out.println("From the filter job ...........");

        Map<String, String> filters = new HashMap<>();
        filters.put("company", req.getParameter("company"));
        filters.put("type", req.getParameter("type"));
        filters.put("location", req.getParameter("location"));
        filters.put("status", req.getParameter("status"));

        List<Job> filteredJobs = JobService.filterJob(recruiterId, filters);

        req.setAttribute("postedJobList", filteredJobs);
        resp.sendRedirect("admin/job-list");


    }
}
