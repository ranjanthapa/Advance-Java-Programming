package queries;

public class RecruiterQuery {
    public static final String CREATE_TABLE =
            "CREATE TABLE IF NOT EXISTS recruiters (" +
                    "id VARCHAR(255) PRIMARY KEY, " +
                    "email VARCHAR(255) UNIQUE NOT NULL, " +
                    "password VARCHAR(255) NOT NULL, " +
                    "firm_name VARCHAR(255) NOT NULL, " +
                    "industry VARCHAR(255) NOT NULL, " +
                    "website VARCHAR(255), " +
                    "location VARCHAR(255), " +
                    "created_at TIMESTAMP NOT NULL" +
                    ");";

    public static final String INSERT_DATA =
            "INSERT INTO recruiters (id, email, password, firm_name, industry, website, location, created_at) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?);";

}
