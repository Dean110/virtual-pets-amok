package virtual_pets_amok;

public class RoboticDog extends Robotic implements Walkable {

	public RoboticDog(String name, String description) {
		this.name = name;
		this.description = description;
	}

	// From Walkable
	@Override
	public void walk() {
		boredom -= 20;
		happiness += 40;
	}

}
