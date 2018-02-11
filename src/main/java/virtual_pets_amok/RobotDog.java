package virtual_pets_amok;

public class RobotDog extends VirtualPet implements Walkable {

	public RobotDog(String name, String description) {
		this.name = name;
		this.description = description;
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub

	}

	public void oil() {
		health += 20;
	}

	/* (non-Javadoc)
	 * @see virtual_pets_amok.Walkable#walk()
	 */
	@Override
	public void walk() {
		boredom -= 20;

	}

}
