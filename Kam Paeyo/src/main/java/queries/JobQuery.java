package queries;

public class JobQuery {
    public static final String CREATE_JOB_TABLE = "CREATE TABLE IF NOT EXISTS jobs ("
            + "id VARCHAR(255) PRIMARY KEY, "
            + "title VARCHAR(255) NOT NULL, "
            + "company VARCHAR(255) NOT NULL, "
            + "experience VARCHAR(255) NOT NULL, "
            + "location VARCHAR(255) NOT NULL, "
            + "vacancy VARCHAR(255) NOT NULL, "
            + "type VARCHAR(50) NOT NULL, "
            + "salary VARCHAR(255) NOT NULL, "
            + "deadline DATE NOT NULL, "
            + "description TEXT NOT NULL, "
            + "created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP, "
            + "recruiter_id VARCHAR(255) NOT NULL, "
            + "FOREIGN KEY (recruiter_id) REFERENCES recruiters(id) ON DELETE CASCADE"
            + ");";

    public static final String INSERT_JOB = "INSERT INTO jobs (id, recruiter_id, title, company, experience, location, vacancy, type, salary, deadline, description) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";


    public static final String GET_ALL_JOBS = "SELECT * FROM jobs ORDER BY created_at DESC";

    public static final String GET_JOB_BY_ID = "SELECT * FROM jobs WHERE id = ?";

    public static final String DELETE_JOB = "DELETE FROM jobs WHERE id = ? AND recruiter_id = ?";
}
