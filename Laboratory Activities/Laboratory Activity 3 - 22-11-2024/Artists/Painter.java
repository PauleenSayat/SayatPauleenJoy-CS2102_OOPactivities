package labact3;

	public class Painter extends Artist {
		public enum Medium {
			OIL, WATERCOLOR, ACRYLIC, PENCIL, CHARCOAL
			}

		private Medium medium;

		public Painter(String name, int experience, Medium medium) {
			super(name, experience);
			this.medium = medium;
		}

		public Medium getMedium() {
			return medium;
			}

		public void displayDetails() {
			System.out.println("🎨 Painter: " + getName());
			System.out.println("Experience: " + getExperience() + " years");
			System.out.println("Medium: " + medium);
			}
		}
