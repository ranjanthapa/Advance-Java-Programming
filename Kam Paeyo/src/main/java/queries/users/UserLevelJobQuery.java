package queries.users;

public class UserLevelJobQuery {
    public static final String GET_ALL_JOBS = "SELECT * FROM jobs ORDER BY created_at DESC";
    public static final String GET_JOB = "SELECT * FROM jobs where id = ?";
}
