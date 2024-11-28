public class Writer extends Artist {
    private String writingStyle;

    public Writer(String name, int age, String specialty, String writingStyle) {
        super(name, age, specialty);
        this.writingStyle = writingStyle;
    }

    public String getWritingStyle() {
        return writingStyle;
    }

    @Override
    public void displayDetails() {
        System.out.println("Instance of Writer class");
        System.out.println("\nWriter's Info:");
        System.out.println("Artist Name: " + getName());
        System.out.println("Age: " + getAge());
        System.out.println("Specialty: " + getSpecialty());
        System.out.println("Writing Style: " + writingStyle);
    }
}

