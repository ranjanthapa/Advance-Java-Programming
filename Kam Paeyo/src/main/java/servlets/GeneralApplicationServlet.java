package servlets;

import services.admin.AdminApplicationService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;


@WebServlet("/admin/application/form")
public class GeneralApplicationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("hello from applicatin details.....");
        String applicationId = req.getParameter("id");
        HashMap<String, String>  application = AdminApplicationService.getApplication(applicationId);
        req.setAttribute("applicationDetail", application); // ✅ Add this line
        req.getRequestDispatcher("/applicant-detail.jsp").forward(req, resp);
    }
}
