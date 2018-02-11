package virtual_pets_amok;

public class RobotDog extends Robotic implements Walkable {

	public RobotDog(String name, String description) {
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
