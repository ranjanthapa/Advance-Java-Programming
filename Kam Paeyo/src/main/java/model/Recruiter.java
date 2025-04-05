package model;

import java.util.Date;

public class Recruiter {
    private int id;
    private String email;
    private String password;
    private String firmName;
    private String firmEmail;
    private String industry;
    private String website;
    private String location;
    private String contactEmail;
    private Date createdAt;

    public Recruiter(int id, String email, String password, String firmName,
                     String firmEmail, String industry, String website,
                     String location, String contactEmail, Date createdAt) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.firmName = firmName;
        this.firmEmail = firmEmail;
        this.industry = industry;
        this.website = website;
        this.location = location;
        this.contactEmail = contactEmail;
        this.createdAt = createdAt;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getFirmName() { return firmName; }
    public void setFirmName(String firmName) { this.firmName = firmName; }

    public String getFirmEmail() { return firmEmail; }
    public void setFirmEmail(String firmEmail) { this.firmEmail = firmEmail; }

    public String getIndustry() { return industry; }
    public void setIndustry(String industry) { this.industry = industry; }

    public String getWebsite() { return website; }
    public void setWebsite(String website) { this.website = website; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public String getContactEmail() { return contactEmail; }
    public void setContactEmail(String contactEmail) { this.contactEmail = contactEmail; }

    public Date getCreatedAt() { return createdAt; }
    public void setCreatedAt(Date createdAt) { this.createdAt = createdAt; }

    @Override
    public String toString() {
        return String.format("Recruiter %s from %s is created with email %s", firmName, industry, email);
    }
}
