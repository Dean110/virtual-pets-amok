package virtual_pets_amok;

public class ReportGenerator {
	public String petStats(Organic virtualPet) {
		String name = formatPetNameWithSpaces(virtualPet);

		return name + "|" + virtualPet.getHunger() + "\t|" + virtualPet.getThirst() + "\t|" + virtualPet.getBoredom();
	}

	public String formatPetNameWithSpaces(VirtualPet pet) {
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
