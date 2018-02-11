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

	@Override
	public String toString() {
		return name;

	}
}
