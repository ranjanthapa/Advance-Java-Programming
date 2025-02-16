package SwingDemo.model;

public class Student {
    private String fullName;
    private String address;
    private String pAddress;
    private String gender;
    private String registration;
    private String batch;
    private String department;

    public Student(String fullName, String address, String pAddress, String gender,
                   String registration, String batch, String department) {
        this.fullName = fullName;
        this.address = address;
        this.pAddress = pAddress;
        this.gender = gender;
        this.registration = registration;
        this.batch = batch;
        this.department = department;
    }

    public String getFullName() { return fullName; }
    public String getAddress() { return address; }
    public String getPAddress() { return pAddress; }
    public String getGender() { return gender; }
    public String getRegistration() { return registration; }
    public String getBatch() { return batch; }
    public String getDepartment() { return department; }

    public void setFullName(String fullName) { this.fullName = fullName; }
    public void setAddress(String address) { this.address = address; }
    public void setPAddress(String pAddress) { this.pAddress = pAddress; }
    public void setGender(String gender) { this.gender = gender; }
    public void setRegistration(String registration) { this.registration = registration; }
    public void setBatch(String batch) { this.batch = batch; }
    public void setDepartment(String department) { this.department = department; }
}
