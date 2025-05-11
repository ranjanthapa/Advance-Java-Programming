package servlets.jobs.admin;

import dto.Job;
import services.admin.AdminApplicationService;
import services.admin.JobService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@WebServlet("/admin/filter-application")
public class ApplicationFilter extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String recruiterId = (String) req.getSession().getAttribute("userId");

        Map<String, String> filters = new HashMap<>();
        filters.put("company", req.getParameter("company"));
        filters.put("type", req.getParameter("type"));
        filters.put("location", req.getParameter("location"));
        filters.put("status", req.getParameter("status") != null ? req.getParameter("status").toLowerCase() : null);

        List<HashMap<String, String>> filterApplication = AdminApplicationService.filterApplication(recruiterId, filters);
        System.out.println(filters);


        req.getSession().setAttribute("filterApplication", filterApplication);
        resp.sendRedirect(req.getContextPath() + "/admin/application");


    }
}
