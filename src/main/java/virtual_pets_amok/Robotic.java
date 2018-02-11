package virtual_pets_amok;

public class Robotic extends VirtualPet {

	@Override
	public void tick() {
		happiness--;
		health -= 3;
	}

	public void oil() {
		health += 20;
	}

}
