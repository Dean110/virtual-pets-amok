package virtual_pets_amok;

import java.util.HashMap;

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

}
