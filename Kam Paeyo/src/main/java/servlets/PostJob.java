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
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@WebServlet("/job")
public class PostJob extends HttpServlet {

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

//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        try {
//            LocalDate parsedDeadline = LocalDate.parse(deadline, formatter);
            Date sqlDeadline = Date.valueOf(deadline);

            Job job = new Job(title, company, experience, location, vacancy, type, salary, sqlDeadline, description, userId);

            boolean success = JobService.postJob(job);

            if (success) {
                response.sendRedirect("admin-dashboard.jsp");
            } else {
                response.sendRedirect("create-job.jsp");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("create-job.jsp");
        }
    }
}
