package virtual_pets_amok;

public class ReportGenerator {
	public static String petStats(OrganicCat pet) {
		String name = formatPetNameWithSpaces(pet);

		return name + "|" + pet.getHunger() + "\t|" + pet.getThirst() + "\t|" + pet.getBoredom();
	}

	public static String formatPetNameWithSpaces(VirtualPet pet) {
		String output = pet.getName();
		if (output.length() == 16) {
			return output;
		} else if (output.length() < 16) {
			while (output.length() < 16) {
				output += " ";
			}
		} else {
			output = output.substring(0, 16);
		}
		return output;
	}

}
