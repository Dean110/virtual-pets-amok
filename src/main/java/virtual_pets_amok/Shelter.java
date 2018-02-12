package virtual_pets_amok;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map.Entry;

public class Shelter {

	private int litterBoxCleanliness = 100;
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

	public VirtualPet getPet(String name) {
		return pets.get(name);
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

	public boolean isThereADeadPet() {
		boolean doWeHaveADeadPet = false;
		for (Entry<String, VirtualPet> checkedPet : pets.entrySet()) {
			if (checkedPet.getValue().getIsThisPetDead()) {
				doWeHaveADeadPet = true;
			}
		}
		return doWeHaveADeadPet;
	}

	public void cleanLitterBox() {
		litterBoxCleanliness = 100;
	}

	public void walkAllDogs() {
		for (Entry<String, VirtualPet> pet : pets.entrySet()) {
			if (pet.getValue() instanceof Walkable) {
				((Walkable) pet.getValue()).walk();
			}
		}

	}
}
