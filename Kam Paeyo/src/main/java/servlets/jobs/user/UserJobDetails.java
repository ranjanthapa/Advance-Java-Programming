package servlets.jobs.user;

import dto.Job;
import services.user.UserJobService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/job/detail/")
public class UserJobDetails extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Detail endpiont hit.....");
        System.out.println(req.getParameter("id"));
        String jobId = req.getParameter("id");
        Job job = UserJobService.getJob(jobId);
        req.setAttribute("job", job);
        req.getRequestDispatcher("/jobdetails.jsp").forward(req, resp);
    }
}
