package enums;

public enum JobStatus {
    ACTIVE("active"),
    EXPIRED("expired");

    private final String value;

    JobStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
