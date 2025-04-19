package servlets;


import services.CandidateService;
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

        boolean isLoggedIn = RecruiterService.login(email, password);

        if (isLoggedIn) {
            req.getSession().setAttribute("email", email);
            req.getSession().setAttribute("role", "recruiter");
            resp.sendRedirect(req.getContextPath() + "/admin-dashboard.jsp");
        } else {
            req.setAttribute("error", "Invalid email or password.");
            req.getRequestDispatcher("/login-as-recruiter.jsp").forward(req, resp);
        }
    }
}
