package dto;

import java.util.UUID;

public class Candidate {
    private final String id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String education;
    private String experience;
    private String website;
    private String location;

    public Candidate(String firstName, String lastName, String email, String phoneNumber, String password, String location,
                     String website, String education) {
        this.id = UUID.randomUUID().toString();
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.website = (website != null && !website.trim().isEmpty()) ? website : null;
        this.experience = null;
        this.location = location;
        this.education = education;

    }

    public String getId() { return id; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public String getEducation() { return education; }
    public void setEducation(String education) { this.education = education; }

    public String getExperience() { return experience; }
    public void setExperience(String experience) { this.experience = experience; }

    public String getWebsite() { return website; }
    public void setWebsite(String website) { this.website = website; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }


    @Override
    public String toString() {
        return "Candidate " + this.firstName + " is created with email " + this.email;
    }
}
