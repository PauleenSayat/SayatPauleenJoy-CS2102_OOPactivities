public class Dancer extends Artist {
    private String danceStyle;

    public Dancer(String name, int age, String specialty, String danceStyle) {
        super(name, age, specialty);
        this.danceStyle = danceStyle;
    }

    public String getDanceStyle() {
        return danceStyle;
    }

    @Override
    public void displayDetails() {
        System.out.println("Instance of Dancer class");
        System.out.println("\nDancer's Info:");
        System.out.println("Artist Name: " + getName());
        System.out.println("Age: " + getAge());
        System.out.println("Specialty: " + getSpecialty());
        System.out.println("Dance Style: " + danceStyle);
    }
}
