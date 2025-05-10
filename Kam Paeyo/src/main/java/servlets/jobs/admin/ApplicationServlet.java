package servlets.jobs.admin;

import services.admin.AdminApplicationService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;


@WebServlet("/admin/application")
public class ApplicationServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String recruiterId = (String) req.getSession().getAttribute("userId");
        List<HashMap<String, String>> applications = AdminApplicationService.getApplications(recruiterId);
        req.setAttribute("applications", applications);
        req.getRequestDispatcher("/admin-application.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String status = req.getParameter("status");
        String applicationId = req.getParameter("application_id");
        System.out.println("askfjalsflajsf......................................................");
        System.out.println(status);
        System.out.println(applicationId);
    }
}
