package dto;

import enums.ApplicationStatus;
import java.io.File;
import java.util.UUID;

public class Applications {

    private final String id;
    private String name;
    private String email;
    private String contactNumber;
    private File resume;
    private String coverLetter;
    private String jobId;
    private String resumePath;
    private ApplicationStatus status;
    private String applicant_id;

    public Applications() {
        this.id = UUID.randomUUID().toString();
    }

    public Applications(String name, String email, String contactNumber, File resume, String coverLetter, String jobId,
                        String resumePath, ApplicationStatus status, String applicant_id) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.email = email;
        this.contactNumber = contactNumber;
        this.resumePath = resumePath;
        this.resume = resume;
        this.coverLetter = coverLetter;
        this.jobId = jobId;
        this.applicant_id = applicant_id;
        this.status = status != null ? status : ApplicationStatus.PENDING;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public File getResume() {
        return resume;
    }

    public void setResume(File resume) {
        this.resume = resume;
    }

    public String getCoverLetter() {
        return coverLetter;
    }

    public void setCoverLetter(String coverLetter) {
        this.coverLetter = coverLetter;
    }

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public String getResumePath() {
        return resumePath;
    }

    public void setResumePath(String resumePath) {
        this.resumePath = resumePath;
    }

    public ApplicationStatus getStatus() {
        return status;
    }

    public void setStatus(ApplicationStatus status) {
        this.status = status;
    }

    public String getApplicant_id() {
        return applicant_id;
    }

    public void setApplicant_id(String applicant_id) {
        this.applicant_id = applicant_id;
    }

}
