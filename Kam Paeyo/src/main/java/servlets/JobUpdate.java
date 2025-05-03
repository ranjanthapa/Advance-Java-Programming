package servlets;

import dto.Job;
import enums.JobStatus;
import services.JobService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

import java.sql.*;

@WebServlet("/admin/job/edit")
public class JobUpdate extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String jobId = request.getParameter("id");
        String recruiterId = (String) request.getSession().getAttribute("userId");

        if (jobId != null) {
            Job job = JobService.getJob(jobId, recruiterId);
            if (job != null) {
                request.setAttribute("job", job);
                request.getRequestDispatcher("/update-job.jsp").forward(request, response);

            } else {
                response.sendError(HttpServletResponse.SC_NOT_FOUND, "Job not found.");
            }
        } else {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Job ID is required.");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String jobId = req.getParameter("id");
        String recruiterId = (String) req.getSession().getAttribute("userId");

        if (jobId == null || recruiterId == null) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            resp.getWriter().write("Job ID or recruiter ID is missing.");
            return;
        }

        String title = req.getParameter("title");
        String company = req.getParameter("company");
        String experience = req.getParameter("experience");
        String location = req.getParameter("location");
        String vacancy = req.getParameter("vacancy");
        String type = req.getParameter("type");
        String salary = req.getParameter("salary");
        String deadlineStr = req.getParameter("deadline");
        String description = req.getParameter("description");
        String statusStr = req.getParameter("status");

        System.out.println("status of the job" + statusStr);

        Date sqlDeadline = Date.valueOf(deadlineStr);

        JobStatus status = JobStatus.valueOf(statusStr);

        System.out.println("TIme stamp of deadline" + deadlineStr);
        System.out.println("TIme stamp of deadline" + deadlineStr);

        Job job = new Job(jobId, title, company, experience, location, vacancy, type, salary, sqlDeadline, description,
                recruiterId, status);


        boolean success = JobService.updateJob(job);

        if (success) {
            System.out.println("Job updated you check the db ");
            req.getSession().setAttribute("jobUpdated", true);
            resp.sendRedirect(req.getContextPath() + "/admin/job-list");
        } else {
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            resp.getWriter().write("Failed to update job.");
        }
    }
}
