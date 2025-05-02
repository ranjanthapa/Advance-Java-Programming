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
        String recruiterId = (String) request.getSession().getAttribute("userId");
        List<Job> jobs = JobService.getJobs(2, recruiterId);

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

                response.sendRedirect(request.getContextPath() + "/admin/job");


            } else {
                response.sendRedirect("create-job.jsp");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("create-job.jsp");
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String jobId = req.getParameter("id");
        String recruiterId = (String) req.getSession().getAttribute("userId");

        resp.setContentType("application/json");

        if (jobId != null) {
            boolean deleted = JobService.deleteJob(jobId, recruiterId);
            if (deleted) {
                req.getSession().setAttribute("jobDeleted", true);
                resp.setStatus(HttpServletResponse.SC_OK);
                resp.getWriter().write("{\"success\": true}");
            } else {
                resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                resp.getWriter().write("{\"success\": false, \"message\": \"Failed to delete job.\"}");
            }
        } else {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            resp.getWriter().write("{\"success\": false, \"message\": \"Invalid job ID.\"}");
        }
    }


}
