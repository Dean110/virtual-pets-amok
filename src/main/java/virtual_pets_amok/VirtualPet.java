package virtual_pets_amok;

public abstract class VirtualPet {

	protected String name;
	protected String description;
	protected int boredom;
	protected int happiness;
	protected int health;

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
		happiness += 30;
	}

	abstract public void tick();

	public int getHappiness() {

		return happiness;
	}

	public int getHealth() {
	
		return health;
	}

}