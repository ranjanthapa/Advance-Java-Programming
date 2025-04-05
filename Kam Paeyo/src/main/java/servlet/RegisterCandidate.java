package servlet;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.ServletException;

import java.io.IOException;
import model.Candidate;
import services.CandidateService;

@WebServlet("/register")
public class RegisterCandidate extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String phoneNumber = request.getParameter("phoneNumber");

        Candidate candidate = new Candidate( firstName, lastName, password, email, phoneNumber);

        CandidateService candidateService = new CandidateService();
        boolean success = candidateService.register(candidate);

        if (success) {
            response.sendRedirect("register_success.jsp");
        } else {
            response.sendRedirect("register_failure.jsp");
        }
    }
}
