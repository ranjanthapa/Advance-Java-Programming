package dto;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.UUID;

public class Job {
    private String id;
    private String userId;
    private String title;
    private String company;
    private String experience;
    private String location;
    private String vacancy;
    private String type;
    private String salary;
    private Date deadline;
    private Timestamp createdAt;
    private String description;


    public Job(String id, String title, String company, String experience, String location, String vacancy,
               String type, String salary, Date deadline, String description, String userId, Timestamp createdAt) {
        this.id = id;
        this.title = title;
        this.company = company;
        this.experience = experience;
        this.location = location;
        this.vacancy = vacancy;
        this.type = type;
        this.salary = salary;
        this.deadline = deadline;
        this.description = description;
        this.userId = userId;
        this.createdAt = createdAt;
    }



    public Job(String title, String company, String experience, String location, String vacancy, String type,
               String salary, Date deadline, String description, String userId) {
        this.id = UUID.randomUUID().toString();
        this.title = title;
        this.company = company;
        this.experience = experience;
        this.location = location;
        this.vacancy = vacancy;
        this.type = type;
        this.salary = salary;
        this.deadline = deadline;
        this.description = description;
        this.userId = userId;
    }


    public String getId() {return id;}

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getCompany() { return company; }
    public void setCompany(String company) { this.company = company; }

    public String getExperience() { return experience; }
    public void setExperience(String experience) { this.experience = experience; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public String getVacancy() { return vacancy; }
    public void setVacancy(String vacancy) { this.vacancy = vacancy; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public String getUserId() { return userId;}
    public void setUserId(String userId) {this.userId = userId;}

    public String getSalary() { return salary; }
    public void setSalary(String salary) { this.salary = salary; }

    public Date getDeadline() { return deadline; }
    public void setDeadline(java.sql.Date deadline) { this.deadline = deadline; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getCreatedAt() {
        SimpleDateFormat formatter = new SimpleDateFormat("MMM dd, yyyy");
        return formatter.format(createdAt);
    }

    public String getFormattedDeadline() {
        SimpleDateFormat formatter = new SimpleDateFormat("MMM dd, yyyy");
        return formatter.format(deadline);
    }

}
