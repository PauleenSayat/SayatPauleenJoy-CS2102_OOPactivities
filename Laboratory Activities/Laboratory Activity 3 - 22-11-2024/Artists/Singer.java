package labact3;

public class Singer extends Artist {
	public enum Genre {
     POP, ROCK, CLASSICAL, JAZZ, HIPHOP, RNB
	}
	
	private Genre genre;

	public Singer(String name, int experience, Genre genre) {
		super(name, experience);
		this.genre = genre;
	}

	public Genre getGenre() {
		return genre;
	}

	public void displayDetails() {
		System.out.println("🎤 Singer: " + getName());
		System.out.println("Experience: " + getExperience() + " years");
		System.out.println("Genre: " + genre);
		}
	}
