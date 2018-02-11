package virtual_pets_amok;

public class RoboticCat extends Robotic {

	public RoboticCat(String name, String description, Shelter shelter) {
		this.name = name;
		this.description = description;
		shelter.addPet(this);
	}

}
