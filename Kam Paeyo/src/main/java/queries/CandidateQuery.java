package queries;

public class CandidateQuery {
    public static final String CREATE_CANDIDATE_TABLE = "CREATE TABLE IF NOT EXISTS candidates ("
            + "id VARCHAR(255) PRIMARY KEY, "
            + "email VARCHAR(255) NOT NULL, "
            + "password VARCHAR(255) NOT NULL, "
            + "first_name VARCHAR(255) NOT NULL, "
            + "last_name VARCHAR(255) NOT NULL, "
            + "phone_number VARCHAR(255) NOT NULL, "
            + "education VARCHAR(255), "
            + "experience VARCHAR(255), "
            + "website VARCHAR(255), "
            + "location VARCHAR(255), "
            + "created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP"
            + ");";


    public static final String INSERT_DATA = "INSERT INTO candidates (id, email, password, first_name, last_name," +
            " location, website, phone_number, education) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";


    public static final String FETCH_USER_BY_EMAIL = "SELECT * FROM candidates WHERE email = ?";
}


