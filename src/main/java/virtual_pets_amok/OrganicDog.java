package virtual_pets_amok;

public class OrganicDog extends Organic implements Walkable {

	private int cageCleanliness = 100;

	public int getCageCleanliness() {

		return cageCleanliness;
	}

	public OrganicDog(String name, String description) {
		this.name = name;
		this.description = description;
	}

	@Override
	public void walk() {
		waste -= 30;
		if (waste <= 0) {
			waste = 0;
		}
		boredom -= 20;
		if (boredom <= 0) {
			boredom = 0;
		}
		happiness += 40;
		if (happiness >= 100) {
			happiness = 100;
		}
	}

	@Override
	public void soil() {
		cageCleanliness -= 50;
		if (cageCleanliness <= 0) {
			cageCleanliness = 0;
		}
		waste = 0;
	}

	public void cleanCage() {
		cageCleanliness = 100;

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
		if (cageCleanliness <= 0) {
			cageCleanliness = 0;
			happiness -= 30;
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
