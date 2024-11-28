public class Painter extends Artist {
    private String medium;

    public Painter(String name, int age, String specialty, String medium) {
        super(name, age, specialty);
        this.medium = medium;
    }

    public String getMedium() {
        return medium;
    }

    @Override
    public void displayDetails() {
        System.out.println("Instance of Painter class");
        System.out.println("\nPainter's Info:");
        System.out.println("Artist Name: " + getName());
        System.out.println("Age: " + getAge());
        System.out.println("Specialty: " + getSpecialty());
        System.out.println("Medium: " + medium);
    }
}

