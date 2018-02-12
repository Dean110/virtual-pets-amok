package virtual_pets_amok;

public class OrganicCat extends Organic {
	private Shelter litterBox;

	public OrganicCat(String name, String description, Shelter shelter) {
		this.name = name;
		this.description = description;
		litterBox = shelter;
		shelter.addPet(this);
	}

	@Override
	public void soil() {
		litterBox.soilLitterBox();
		waste = 0;
	}

	@Override
	public String toString() {
		return name;

	}

	@Override
	public void tick() {
		hunger++;
		thirst++;
		boredom++;
		waste++;
		happiness--;
		if (waste >= 100) {
			soil();
		}
		if (litterBox.getLitterBoxCleanliness() <= 0) {
			happiness -= 20;
		}
		if (hunger >= 100) {
			hunger = 100;
			health -= 20;
		}
		if (thirst >= 100) {
			thirst = 100;
			health -= 20;
		}
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

}
