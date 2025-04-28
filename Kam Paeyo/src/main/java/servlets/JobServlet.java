package servlets;

import dto.Job;
import services.JobService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

@WebServlet("/admin/job")
public class JobServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Job> jobs = JobService.getJobs(1);
        String recruiterId = (String) request.getSession().getAttribute("userId");
        int totalJobs = JobService.getTotalJobCount(recruiterId);
        int totalActiveJobs = JobService.getTotalActiveJobs(recruiterId);

        request.setAttribute("postedJobList", jobs);
        request.setAttribute("totalJobs", totalJobs);
        request.setAttribute("totalActiveJobs", totalActiveJobs);
        request.getRequestDispatcher("/admin-dashboard.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        String company = request.getParameter("company");
        String experience = request.getParameter("experience");
        String location = request.getParameter("location");
        String vacancy = request.getParameter("vacancy");
        String type = request.getParameter("type");
        String salary = request.getParameter("salary");
        String deadline = request.getParameter("deadline");
        String description = request.getParameter("description");
        String userId = (String) request.getSession().getAttribute("userId");

        try {
            Date sqlDeadline = Date.valueOf(deadline);
            dto.Job job = new dto.Job(title, company, experience, location, vacancy, type, salary, sqlDeadline, description, userId);
            boolean success = JobService.postJob(job);

            if (success) {
                request.getSession().setAttribute("jobPosted", true);
//                response.sendRedirect("admin-dashboard.jsp");

                response.sendRedirect("admin/job");

            } else {
                response.sendRedirect("create-job.jsp");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("create-job.jsp");
        }
    }
}
