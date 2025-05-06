package servlets.jobs.admin;

import dto.Job;
import services.admin.JobService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@WebServlet("/admin/job-list")
public class AdminJobServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String recruiterId = (String) request.getSession().getAttribute("userId");

        List<Job> jobsToShow;
        Object filtered = request.getSession().getAttribute("postedJobList");
        if (filtered != null) {
            jobsToShow = (List<Job>) filtered;
            request.getSession().removeAttribute("postedJobList");
        } else {
            jobsToShow = JobService.getJobs(null, recruiterId);
        }

        List<Job> allJobs = JobService.getJobs(null, recruiterId);
        Set<String> companies = new HashSet<>();
        Set<String> locations = new HashSet<>();
        for (Job job : allJobs) {
            companies.add(job.getCompany());
            locations.add(job.getLocation());
        }

        request.setAttribute("companies", companies);
        request.setAttribute("locations", locations);
        request.setAttribute("jobList", jobsToShow); // this will be filtered or unfiltered
        request.getRequestDispatcher("/job-lists.jsp").forward(request, response);
    }
}

