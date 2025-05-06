package servlets.auth;

import dto.Recruiter;
import services.admin.RecruiterService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/register-recruiter" , name = "recruiter")
public class RegisterRecruiter extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("inside of do post method recruiter");
        final boolean isRegistered;
        String firmName = req.getParameter("firmName");
        String email = req.getParameter("email");
        String industry = req.getParameter("industry");
        String password = req.getParameter("password");
        String location = req.getParameter("location");
        String website = req.getParameter("websiteURL");
        System.out.println("hello world recruiter");
        Recruiter recruiter = new Recruiter(email, password, firmName, industry, website, location);
        isRegistered = RecruiterService.register(recruiter);
        if(isRegistered){
            resp.sendRedirect("login.jsp");
        }else{
            resp.sendRedirect("signup-as-recruiter.jsp");
        }
    }



}
