package servlets.jobs.admin;

import services.admin.AdminApplicationService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@WebServlet("/admin/application")
public class ApplicationServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String recruiterId = (String) req.getSession().getAttribute("userId");

        Object filterApplications = req.getSession().getAttribute("filterApplication");

        List<HashMap<String, String>> applications;
        if (filterApplications !=null){
            applications = (List<HashMap<String, String>>) filterApplications;
            req.getSession().removeAttribute("applications");
        }else{
            applications = AdminApplicationService.getApplications(recruiterId);
        }

        Set<String> companies = new HashSet<>();
        Set<String> locations = new HashSet<>();

        for (HashMap<String, String> app : applications) {
            System.out.println(app);
            String company = app.get("company");
            String location = app.get("location");
            System.out.println("...........................................");
            System.out.println(app.get("company"));
            if (company != null) {
                companies.add(company);
            }
            if (location != null) {
                locations.add(location);
            }
        }



        System.out.println(companies);
        req.setAttribute("applications", applications);
        req.setAttribute("companies", companies);
        req.setAttribute("locations", locations);
        req.getRequestDispatcher("/admin-application.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String status = req.getParameter("status");
        String applicationId = req.getParameter("app_id");

        boolean isUpdated = AdminApplicationService.updateApplication(applicationId, status);

        req.getSession().setAttribute("applicationUpdateStatus", isUpdated);

        resp.sendRedirect(req.getContextPath() + "/admin/application");
    }
}
