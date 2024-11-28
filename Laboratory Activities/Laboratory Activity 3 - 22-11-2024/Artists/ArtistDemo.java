public class ArtistDemo {
    public static void main(String[] args) {
        Artist artist = new Artist("Jieun Lee", 31, "Music");
        artist.displayDetails();
        System.out.println();

        Singer singer = new Singer("Tzuyu Chou", 25, "Music", "POP");
        singer.displayDetails();
        System.out.println();

        Dancer dancer = new Dancer("Misty Copeland", 31, "Dance", "BALLET");
        dancer.displayDetails();
        System.out.println();

        Painter painter = new Painter("Pablo Picasso", 91, "Visual Arts", "OIL");
        painter.displayDetails();
        System.out.println();

        Writer writer = new Writer("William Shakespeare", 52, "Literature", "DRAMA");
        writer.displayDetails();
    }
}
