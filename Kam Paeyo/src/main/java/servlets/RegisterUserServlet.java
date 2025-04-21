package servlets;

import dto.Candidate;
import services.CandidateService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/register" , name = "Candidate")
public class RegisterUserServlet extends HttpServlet {
        @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("inside of do post method");
            final boolean isRegistered;
                String firstName = req.getParameter("firstName");
                String lastName = req.getParameter("lastName");
                String email = req.getParameter("email");
                String phoneNumber = req.getParameter("phoneNumber");
                String password = req.getParameter("password");
                String education = req.getParameter("education");
                String location = req.getParameter("location");
                String website = req.getParameter("website");
                System.out.println("hello world");
                Candidate candidate = new Candidate(firstName, lastName, email, phoneNumber, password, location, website, education);
                isRegistered = CandidateService.register(candidate);
            if(isRegistered){
                resp.sendRedirect("login.jsp");
            }else{
                resp.sendRedirect("signup-as-candidate.jsp");
            }
        }



    }
