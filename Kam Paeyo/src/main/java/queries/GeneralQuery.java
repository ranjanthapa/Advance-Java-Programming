package queries;

public class GeneralQuery {
    public static final String TABLE_EXISTS = "SELECT EXISTS ("
            + "SELECT 1 FROM information_schema.tables "
            + "WHERE table_schema = 'public' AND table_name = ?"
            + ");";
}
