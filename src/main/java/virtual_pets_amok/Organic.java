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

}