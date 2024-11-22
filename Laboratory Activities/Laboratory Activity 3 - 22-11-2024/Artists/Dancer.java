package labact3;

public class Dancer extends Artist {
	public enum DanceStyle {
		BALLET, HIPHOP, JAZZ, CONTEMPORARY
		}

	private DanceStyle danceStyle;

	public Dancer(String name, int experience, DanceStyle danceStyle) {
		super(name, experience);
		this.danceStyle = danceStyle;
		}

	public DanceStyle getDanceStyle() {
		return danceStyle;
		}


	public void displayDetails() {
		System.out.println("💃🏻 Dancer: " + getName());
		System.out.println("Experience: " + getExperience() + " years");
		System.out.println("Dance Style: " + danceStyle);
		}
	}
