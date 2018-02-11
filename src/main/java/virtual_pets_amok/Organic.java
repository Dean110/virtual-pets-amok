package virtual_pets_amok;

abstract public class Organic extends VirtualPet {

	int hunger;
	int thirst;
	protected int waste = 10;

	public Organic() {
		super();
	}

	public int getHunger() {
		return hunger;
	}

	public int getThirst() {

		return thirst;
	}

	public void feed() {
		hunger -= 20;
	}

	public void water() {
		thirst -= 20;
	}

	public int getWaste() {

		return waste;
	}

	abstract public void soil();

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

	}

}