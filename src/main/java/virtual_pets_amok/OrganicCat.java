package virtual_pets_amok;

public class OrganicCat extends Organic {

	public OrganicCat(String name, String description, Shelter shelter) {
		this.name = name;
		this.description = description;
		shelter.addPet(this);
	}

	public void soil(Shelter shelter) {
		shelter.soilLitterBox();
		waste = 0;
	}

	@Override
	public void soil() {
	}

	@Override
	public void tick() {
		hunger++;
		thirst++;
		boredom++;
		waste++;
		happiness--;
	}

	public void tick(Shelter testShelter) {
		hunger++;
		thirst++;
		boredom++;
		waste++;
		happiness--;
		if (waste >= 100) {
			soil(testShelter);
		}
	}

}
