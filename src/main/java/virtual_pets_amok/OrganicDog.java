package virtual_pets_amok;

public class OrganicDog {

	private String name;
	private String description;
	private int hunger;
	private int thirst;
	private int waste;
	private int boredom;

	public OrganicDog(String name, String description) {
		this.name = name;
		this.description = description;
	}

	public String getName() {

		return name;
	}

	public String getDescription() {

		return description;
	}

	public int getHunger() {
		return hunger;
	}

	public int getThirst() {

		return thirst;
	}

	public void feed() {
		hunger -= 20;
	}

	public void water() {
		thirst -= 20;
	}

	public int getWaste() {

		return waste;
	}

	public void walk() {
		waste -= 30;
		boredom -= 20;
	}

	public int getBoredom() {

		return boredom;
	}

	public void play() {
		boredom -= 40;
	}

}
