package enums;

public enum ApplicationStatus {
    ACCEPT("accepted"),
    REJECT("rejected"),
    PENDING("pending");

    private final String value;

    ApplicationStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
