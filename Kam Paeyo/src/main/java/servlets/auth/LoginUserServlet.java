package servlets.auth;


import services.CandidateService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(value = "/login")
public class LoginUserServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        String userId = CandidateService.login(email, password);

        if (userId !=null) {
            req.getSession().setAttribute("email", email);
            req.getSession().setAttribute("applicantId", userId);
            req.getSession().setAttribute("role", "candidate");
            resp.sendRedirect(req.getContextPath() + "/index.jsp");
        } else {
            req.setAttribute("error", "Invalid email or password.");
            resp.sendRedirect(req.getContextPath() + "/login.jsp");
        }
    }
}
