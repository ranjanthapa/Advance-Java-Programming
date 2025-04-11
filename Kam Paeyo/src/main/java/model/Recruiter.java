package model;

import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;

public class Recruiter {
    private String id;
    private String email;
    private String password;
    private String firmName;
    private String industry;
    private String website;
    private String location;
    private final Timestamp createdAt;


    public Recruiter( String email, String password, String firmName,
                      String industry, String website,
                     String location) {
        this.id = UUID.randomUUID().toString();
        this.email = email;
        this.password = password;
        this.firmName = firmName;
        this.industry = industry;
        this.website = website;
        this.location = location;
        this.createdAt = new Timestamp(System.currentTimeMillis());
    }

    public String getId() { return id; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getFirmName() { return firmName; }
    public void setFirmName(String firmName) { this.firmName = firmName; }

    public String getIndustry() { return industry; }
    public void setIndustry(String industry) { this.industry = industry; }

    public String getWebsite() { return website; }
    public void setWebsite(String website) { this.website = website; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public Timestamp getCreatedAt() { return createdAt; }


    @Override
    public String toString() {
        return String.format("Recruiter %s from %s is created with email %s", firmName, industry, email);
    }
}
