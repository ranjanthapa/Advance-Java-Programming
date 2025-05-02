package servlets;

import dto.Job;
import services.JobService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/admin/job-list")
public class AdminJobServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String recruiterId = (String) request.getSession().getAttribute("userId");
        List<Job> jobs = JobService.getJobs(null, recruiterId);
        request.setAttribute("jobList", jobs);
        request.getRequestDispatcher("/job-lists.jsp").forward(request, response);
    }
}
