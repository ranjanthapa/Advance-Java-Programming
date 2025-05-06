package queries.admin;

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
            + "status VARCHAR(20) DEFAULT 'active', "
            + "created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP, "
            + "updated_at TIMESTAMP DEFAULT NULL, "
            + "recruiter_id VARCHAR(255) NOT NULL, "
            + "FOREIGN KEY (recruiter_id) REFERENCES recruiters(id) ON DELETE CASCADE"
            + ");";



    public static final String INSERT_JOB = "INSERT INTO jobs (id, recruiter_id, title, company, experience, location," +
            " vacancy, type, salary, deadline, description) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    public static final String TOTAL_JOB_POSTED = "SELECT COUNT(*) AS total_jobs FROM jobs WHERE recruiter_id = ?";

    public static final String TOTAL_ACTIVE_JOB = "SELECT COUNT(*) AS active_job FROM jobs WHERE recruiter_id = ?" +
            " AND status = 'active'";

    public static final String GET_JOBS = "SELECT * FROM jobs WHERE recruiter_id= ? ORDER BY created_at DESC";

//    public static final String GET_LOCATION_AND_COMPANY = "SELECT "
    public static final String GET_A_JOB = "SELECT * FROM jobs WHERE id = ? AND recruiter_id= ?";

    public static final String UPDATE_JOB = "UPDATE jobs SET "
            + "title = ?, "
            + "company = ?, "
            + "experience = ?, "
            + "location = ?, "
            + "vacancy = ?, "
            + "type = ?, "
            + "salary = ?, "
            + "deadline = ?, "
            + "description = ?, "
            + "updated_at = CURRENT_TIMESTAMP "
            + "WHERE id = ? AND recruiter_id = ?";


    public static final String STATUS_UPDATE = "UPDATE jobs SET status = 'expired' WHERE deadline < CURRENT_DATE " +
            "AND status != 'expired'";

    public static final String DELETE_JOB = "DELETE FROM jobs WHERE id = ? AND recruiter_id = ?";

    public static final String GET_LOCATION_COMPANY_NAME = "SELECT company, location FROM jobs where recruiter_id = ?";

    public static final String FILTER_JOB = "SELECT * FROM jobs WHERE recruiter_id = ?";
}
