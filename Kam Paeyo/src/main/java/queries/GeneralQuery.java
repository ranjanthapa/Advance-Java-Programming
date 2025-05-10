package queries;

public class GeneralQuery {
    public static final String TABLE_EXISTS = "SELECT EXISTS ("
            + "SELECT 1 FROM information_schema.tables "
            + "WHERE table_schema = 'public' AND table_name = ?"
            + ");";


    public static final String TOTAL_ACTIVE_JOB = "SELECT COUNT(status) FILTER (WHERE status = 'active') AS total_active_job\n" +
            "FROM jobs;\n";
}
