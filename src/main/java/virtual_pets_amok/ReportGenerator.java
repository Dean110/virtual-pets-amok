package virtual_pets_amok;

import java.util.Collection;

public class ReportGenerator {
	/*
	 * System.out.println();
	 * System.out.println("Name\t\t|Hunger\t|Thirst\t|Boredom|Happiness|Health");
	 * System.out.println(
	 * "----------------|-------|-------|-------|---------|-------"); } petList =
	 * myShelter.pets(); String organicPetStats = "";
	 * 
	 * for (VirtualPet pet : petList) { if (pet instanceof Organic) {
	 * organicPetStats += report.petStats((Organic) pet) + "\n"; } } if
	 * (!organicPetStats.isEmpty()) { System.out.println(organicPetStats); }
	 */

	public String combinedPetStats(Shelter pets) {
		String combinedStats = "";
		Collection<VirtualPet> petList = pets.pets();
		String organicPetStats = "";
		for (VirtualPet pet : petList) {
			if (pet instanceof Organic) {
				organicPetStats += petStats((Organic) pet) + "\n";
			}
		}
		if (!organicPetStats.isEmpty()) {
			combinedStats += "Organic Pets\t|Hunger\t|Thirst\t|Boredom|Happiness|Health\n";
			combinedStats += "----------------|-------|-------|-------|---------|-------\n";
			combinedStats += organicPetStats;
		}
		return combinedStats;
	}

	public String petStats(Robotic virtualPet) {
		String name = formatPetNameWithSpaces(virtualPet);
		return name + "|" + virtualPet.getBoredom() + "\t|" + virtualPet.getHappiness() + "\t|"
				+ virtualPet.getHealth();
	}

	public String petStats(Organic virtualPet) {
		String name = formatPetNameWithSpaces(virtualPet);

		return name + "|" + virtualPet.getHunger() + "\t|" + virtualPet.getThirst() + "\t|" + virtualPet.getBoredom()
				+ "\t|" + virtualPet.getHappiness() + "\t  |" + virtualPet.getHealth();
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
