package labact3;

public abstract class Artist {
	private String name;
	private int experience;

	public Artist(String name, int experience) {
		this.name = name;
		this.experience = experience;
	}

	public String getName() {
		return name;
	}

	public int getExperience() {
		return experience;
	}

	public abstract void displayDetails();
	}
