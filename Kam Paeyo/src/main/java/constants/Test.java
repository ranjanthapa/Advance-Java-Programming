package constants;

public class Test {
    public static void main(String[] args) {
        Education edu = Education.DIPLOMA;
        System.out.println(edu.getLabel());
        for (Education e : Education.values()) {

            System.out.println(e.name());

        }
    }
}
