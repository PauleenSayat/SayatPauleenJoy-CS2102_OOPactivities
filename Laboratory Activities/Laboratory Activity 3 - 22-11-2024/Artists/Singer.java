public class Singer extends Artist {
    private String genre;

    public Singer(String name, int age, String specialty, String genre) {
        super(name, age, specialty);
        this.genre = genre;
    }

    public String getGenre() {
        return genre;
    }

    @Override
    public void displayDetails() {
        System.out.println("Instance of Singer class");
        System.out.println("\nSinger's Info:");
        System.out.println("Artist Name: " + getName());
        System.out.println("Age: " + getAge());
        System.out.println("Specialty: " + getSpecialty());
        System.out.println("Genre: " + genre);
    }
}
