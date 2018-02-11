package virtual_pets_amok;

public class Robotic extends VirtualPet {

	@Override
	public void tick() {
		happiness--;
		boredom++;
		health -= 3;
		if (boredom >= 100) {
			boredom = 100;
			happiness -= 20;
		}
		if (happiness <= 0) {
			happiness = 0;
			health -= 10;
		}
		if (health <= 0) {
			health = 0;
			isThisPetDead = true;
		}
	}

	public void oil() {
		health += 20;
	}

}
