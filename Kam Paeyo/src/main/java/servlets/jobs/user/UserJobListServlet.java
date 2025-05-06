package servlets.jobs.user;

import dto.Job;
import services.user.UserJobService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet("/jobs")
public class UserJobListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Endpoint hit...........");

        List<Job> jobs = UserJobService.getAllJob();
        System.out.println(jobs);
        req.setAttribute("jobs", jobs);
        req.getRequestDispatcher("/jobs.jsp").forward(req, resp);

    }
}
