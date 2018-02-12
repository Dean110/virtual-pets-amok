package virtual_pets_amok;

import java.util.concurrent.ThreadLocalRandom;

public abstract class VirtualPet {

	protected String name;
	protected String description;
	protected int boredom = ThreadLocalRandom.current().nextInt(20, 81);
	protected int happiness = ThreadLocalRandom.current().nextInt(50, 101);;
	protected int health = 100;
	protected boolean isThisPetDead = false;

	public VirtualPet() {
		super();
	}

	public String getName() {

		return name;
	}

	public String getDescription() {

		return description;
	}

	public int getBoredom() {

		return boredom;
	}

	public void play() {
		boredom -= 40;
		if (boredom <= 0) {
			boredom = 0;
		}
		happiness += 30;
		if (happiness >= 100) {
			happiness = 100;
		}
	}

	abstract public void tick();

	public int getHappiness() {

		return happiness;
	}

	public int getHealth() {

		return health;
	}

	public boolean getIsThisPetDead() {

		return isThisPetDead;
	}

}