package virtual_pets_amok;

public class RoboticDog extends Robotic implements Walkable {

	public RoboticDog(String name, String description) {
		this.name = name;
		this.description = description;
	}

	@Override
	public void walk() {
		boredom -= 20;
		if (boredom <= 0) {
			boredom = 0;
		}
		happiness += 40;
		if (happiness >= 100) {
			happiness = 100;
		}
	}

}
