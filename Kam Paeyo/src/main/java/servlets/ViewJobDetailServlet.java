package servlets;


import dto.Job;
import services.JobService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin/job/details/")
public class ViewJobDetailServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String jobId =  req.getParameter("id");
        String recruiterId = (String) req.getSession().getAttribute("userId");

        Job job = JobService.getJob(jobId, recruiterId);
        req.setAttribute("job", job); // ✅ Add this line
        req.getRequestDispatcher("/admin-view-job-detail.jsp").forward(req, res);


    }

}
