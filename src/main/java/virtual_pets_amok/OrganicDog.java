package virtual_pets_amok;

public class OrganicDog extends Organic implements Walkable {

	private int cageCleanliness;

	public OrganicDog(String name, String description) {
		this.name = name;
		this.description = description;
	}

	@Override
	public void walk() {
		waste -= 30;
		boredom -= 20;
		happiness += 40;
	}

	@Override
	public void soil() {
		cageCleanliness -= 50;
		waste = 0;
	}

	public int getCageCleanliness() {

		return cageCleanliness;
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
	}

}
