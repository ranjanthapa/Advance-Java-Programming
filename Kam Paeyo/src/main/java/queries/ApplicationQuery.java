package queries;

public class ApplicationQuery {

    public static final String APPLY_JOB = "INSERT INTO applications (id, name, email, contact_number, resume_path," +
            " cover_letter, job_id, applicant_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

    public static final String CREATE_APPLICATION_TABLE =
            "CREATE TABLE IF NOT EXISTS applications (\n" +
                    "    id VARCHAR(255) PRIMARY KEY,\n" +
                    "    name VARCHAR(100) NOT NULL,\n" +
                    "    email VARCHAR(100) NOT NULL,\n" +
                    "    contact_number VARCHAR(20),\n" +
                    "    resume_path VARCHAR(255),\n" +
                    "    cover_letter TEXT,\n" +
                    "    job_id VARCHAR(255),\n" +
                    "    applicant_id VARCHAR(255),\n" +
                    "    status VARCHAR(20) DEFAULT 'pending',\n" +
                    "    applied_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,\n" +
                    "    FOREIGN KEY (job_id) REFERENCES jobs(id) ON DELETE CASCADE,\n" +
                    "    FOREIGN KEY (applicant_id) REFERENCES candidates(id) ON DELETE CASCADE\n" +
                    ");\n" +
                    "CREATE INDEX IF NOT EXISTS idx_job_id ON applications(job_id);\n" +
                    "CREATE INDEX IF NOT EXISTS idx_applicant_id ON applications(applicant_id);";

    public static final String APPLICATION_STATS =
            "SELECT " +
                    "COUNT(*) AS total_applied, " +
                    "COUNT(*) FILTER (WHERE status = 'accepted') AS total_accepted, " +
                    "COUNT(*) FILTER (WHERE status = 'rejected') AS total_rejected " +
                    "FROM applications " +
                    "WHERE applicant_id = ?;";


    public static final String RECENT_ACTIVITY = "\n" +
            "SELECT jobs.id, jobs.title, jobs.company, jobs.location, jobs.type\n" +
            "FROM jobs\n" +
            "JOIN applications ON jobs.id = applications.job_id\n" +
            "WHERE applications.applicant_id = ?;\n" +
            "\n";


    public static final String ADMIN_APPLICATION_REQUEST = "\n" +
            "WITH temptable AS (\n" +
            "    SELECT jobs.*\n" +
            "    FROM jobs\n" +
            "    JOIN recruiters ON recruiters.id = jobs.recruiter_id\n" +
            "    WHERE recruiters.id = ?" +
            ")\n" +
            "SELECT applications.*, temptable.title, temptable.created_at\n" +
            "FROM applications\n" +
            "JOIN temptable ON applications.job_id = temptable.id";


    public static final String UPDATE_APPLICATION_STATUS = "UPDATE applications SET status = ? WHERE id = ?";

    public static final String GET_APPLICATION = "SELECT * FROM applications where id=?";
}
