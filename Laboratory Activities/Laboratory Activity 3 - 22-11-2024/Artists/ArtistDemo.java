package labact3;

public class ArtistDemo {
	public static void main(String[] args) {
		Singer singer = new Singer("Adele", 15, Singer.Genre.POP);
		Painter painter = new Painter("Van Gogh", 10, Painter.Medium.OIL);
		Writer writer = new Writer("Shakespeare", 20, Writer.WritingStyle.DRAMA);
		Dancer dancer = new Dancer("Misty Copeland", 12, Dancer.DanceStyle.BALLET);

		singer.displayDetails();
		System.out.println();
		painter.displayDetails();
		System.out.println();
		writer.displayDetails();
		System.out.println();
		dancer.displayDetails();
 }
}
