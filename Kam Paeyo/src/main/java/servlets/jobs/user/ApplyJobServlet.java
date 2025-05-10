package servlets.jobs.user;

import dto.Applications;
import services.user.UserJobService;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.UUID;

@WebServlet("/job/apply")
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024, // 1MB
        maxFileSize = 1024 * 1024 * 5,   // 5MB
        maxRequestSize = 1024 * 1024 * 10 // 10MB
)
public class ApplyJobServlet extends HttpServlet {

    private static final String UPLOAD_DIR = "uploads/resumes";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String contact = req.getParameter("contact");
        String coverLetter = req.getParameter("cover-letter");
        String jobId = req.getParameter("jobId");
        String applicantId = (String) req.getSession().getAttribute("applicantId");

        if (applicantId == null) {
            req.getSession().setAttribute("loginRequired", true);
            resp.sendRedirect("/KamPaeyo/job/detail/?id=" + jobId);
            return;
        }

        // Handle resume upload
        Part resumePart = req.getPart("resume");
        String fileName = Paths.get(resumePart.getSubmittedFileName()).getFileName().toString();
        String savePath = getServletContext().getRealPath("") + File.separator + UPLOAD_DIR;

        File fileSaveDir = new File(savePath);
        if (!fileSaveDir.exists()) {
            fileSaveDir.mkdirs();
        }

        // Generate unique file name to avoid conflicts
        String uniqueFileName = UUID.randomUUID() + "_" + fileName;
        String fullResumePath = savePath + File.separator + uniqueFileName;

        // Write the file to disk
        resumePart.write(fullResumePath);

        // Construct relative path (to store in DB)
        String dbPath = UPLOAD_DIR + "/" + uniqueFileName;

        // Create Application object
        Applications application = new Applications();
        application.setName(name);
        application.setEmail(email);
        application.setContactNumber(contact);
        application.setCoverLetter(coverLetter);
        application.setResumePath(dbPath);
        application.setJobId(jobId);
        application.setApplicant_id(applicantId);

        boolean success = UserJobService.applyJob(application);

        if (success) {
            req.getSession().setAttribute("applyStatus", true);
            resp.sendRedirect("/KamPaeyo/job/detail/?id=" + jobId );
        } else {
            req.getSession().setAttribute("applyStatus", false);
            resp.sendRedirect("/KamPaeyo/job/detail/?id=" + jobId);
        }
    }
}
