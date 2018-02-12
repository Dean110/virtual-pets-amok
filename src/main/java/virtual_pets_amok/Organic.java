package virtual_pets_amok;

import java.util.concurrent.ThreadLocalRandom;

abstract public class Organic extends VirtualPet {

	protected int hunger = ThreadLocalRandom.current().nextInt(20, 81);
	protected int thirst = ThreadLocalRandom.current().nextInt(20, 81);
	protected int waste = ThreadLocalRandom.current().nextInt(20, 81);

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
		if (hunger < 0) {
			hunger = 0;
		}
		waste += 20;
		if (waste >= 100) {
			waste = 100;
		}
	}

	public void water() {
		thirst -= 20;
		if (thirst < 0) {
			thirst = 0;
		}
	}

	public int getWaste() {

		return waste;
	}

	abstract public void soil();

	@Override
	abstract public void tick();
}