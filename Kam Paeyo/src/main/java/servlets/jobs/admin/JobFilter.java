package servlets.jobs.admin;

import dto.Job;
import services.admin.JobService;

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

        Map<String, String> filters = new HashMap<>();
        filters.put("company", req.getParameter("company"));
        filters.put("type", req.getParameter("type"));
        filters.put("location", req.getParameter("location"));
        filters.put("status", req.getParameter("status") != null ? req.getParameter("status").toLowerCase() : null);

        System.out.println(filters);


        List<Job> filteredJobs = JobService.filterJob(recruiterId, filters);
        System.out.println(filteredJobs);

        req.getSession().setAttribute("postedJobList", filteredJobs);
        resp.sendRedirect(req.getContextPath() + "/admin/job-list");


    }
}
