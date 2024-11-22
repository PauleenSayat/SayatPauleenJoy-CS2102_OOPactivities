package labact3;

public class Writer extends Artist {
	public enum WritingStyle {
		FICTION, NONFICTION, POETRY, DRAMA
		}
	
	private WritingStyle writingStyle;

	public Writer(String name, int experience, WritingStyle writingStyle) {
		super(name, experience);
		this.writingStyle = writingStyle;
		}

	public WritingStyle getWritingStyle() {
		return writingStyle;
		}


	public void displayDetails() {
		System.out.println("✍🏻 Writer: " + getName());
		System.out.println("Experience: " + getExperience() + " years");
		System.out.println("Writing Style: " + writingStyle);
		}
	}
