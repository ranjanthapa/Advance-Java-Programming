package constants;

public enum Education {
    HIGH_SCHOOL("High School"),
    DIPLOMA("Diploma"),
    BACHELORS("Bachelor's"),
    MASTERS("Master's"),
    PHD("PhD");

    private final String label;

    Education(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
