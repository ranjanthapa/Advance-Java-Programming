package servlets;


import services.RecruiterService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(value = "/login/recruiter")
public class LoginRecruiter extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        String userId = RecruiterService.login(email, password);

        if (userId != null) {
            req.getSession().setAttribute("role", "recruiter");
            req.getSession().setAttribute("userId", userId);
            resp.sendRedirect(req.getContextPath() + "/admin/job");
        } else {
            req.setAttribute("error", "Invalid email or password.");
//            req.getRequestDispatcher("/login-as-recruiter.jsp").forward(req, resp);
            resp.sendRedirect(req.getContextPath() + "/login-as-recruiter.jsp");

        }
    }
}
