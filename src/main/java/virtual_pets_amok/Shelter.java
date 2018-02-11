package virtual_pets_amok;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map.Entry;

public class Shelter {

	private int litterBoxCleanliness;
	private HashMap<String, VirtualPet> pets = new HashMap<>();

	public void addPet(VirtualPet pet) {
		pets.put(pet.getName(), pet);
	}

	public int getLitterBoxCleanliness() {

		return litterBoxCleanliness;
	}

	public void soilLitterBox() {
		litterBoxCleanliness -= 20;
	}

	public int getSize() {
		// TODO Auto-generated method stub
		return pets.size();
	}

	public VirtualPet findPet(String petName) {
		return pets.get(petName);
	}

	public Collection<VirtualPet> pets() {

		return pets.values();
	}

	public void adoptOut(String name) {
		pets.remove(name);
	}

	public void feedPets() {
		for (Entry<String, VirtualPet> pet : pets.entrySet()) {
			if (pet.getValue() instanceof Organic) {
				((Organic) pet.getValue()).feed();

			}
		}
	}

	public void waterPets() {
		for (Entry<String, VirtualPet> pet : pets.entrySet()) {
			if (pet.getValue() instanceof Organic) {
				((Organic) pet.getValue()).water();

			}
		}

	}

	public void playWithPet(String petName) {
		pets.get(petName).play();
	}

	public void tick() {
		for (Entry<String, VirtualPet> pet : pets.entrySet()) {
			pet.getValue().tick();

		}
	}
}
