package servlets;

import model.Candidate;
import model.Recruiter;
import services.CandidateService;
import services.RecruiterService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/register" , name = "Candidate")
public class RegisterUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Hello btn is clicked");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            String type = req.getParameter("type");
            final boolean isRegistered;
            if (type.equals("candidate")) {
                String firstName = req.getParameter("firstName");
                String lastName = req.getParameter("lastName");
                String email = req.getParameter("email");
                String phoneNumber = req.getParameter("phoneNumber");
                String password = req.getParameter("password");

                Candidate candidate = new Candidate(firstName, lastName, email, phoneNumber, password);
                isRegistered = CandidateService.register(candidate);
            }else {
                String firmName = req.getParameter("firmName");
                String email = req.getParameter("email");
                String location = req.getParameter("location");
                String industry = req.getParameter("industry");
                String websiteURL = req.getParameter("websiteURL");
                String password = req.getParameter("password");

                Recruiter recruiter = new Recruiter(email, password, firmName, industry, websiteURL, location);
                isRegistered = RecruiterService.register(recruiter);
            }

            if(isRegistered){
                resp.sendRedirect("login.jsp");
            }
        }



    }
