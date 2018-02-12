package virtual_pets_amok;

import java.util.Collection;

public class ReportGenerator {

	public String combinedPetStats(Shelter pets) {
		String combinedStats = "";
		Collection<VirtualPet> petList = pets.pets();
		String organicCatPetStats = "";
		for (VirtualPet pet : petList) {
			if (pet instanceof OrganicCat) {
				organicCatPetStats += petStats((OrganicCat) pet) + "\n";
			}
		}
		if (!organicCatPetStats.isEmpty()) {
			combinedStats += "Organic Cats\t|Hunger\t|Thirst\t|Boredom|Happiness|Waste  |Health\n";
			combinedStats += "----------------|-------|-------|-------|---------|-------|------\n";
			combinedStats += organicCatPetStats + "\n\n";
		}
		String organicDogPetStats = "";
		for (VirtualPet pet : petList) {
			if (pet instanceof OrganicDog) {
				organicDogPetStats += petStats((OrganicDog) pet) + "\n";
			}
		}
		if (!organicDogPetStats.isEmpty()) {
			combinedStats += "Organic Cats\t|Hunger\t|Thirst\t|Boredom|Happiness|Waste  |Health |Cage Cleanliness\n";
			combinedStats += "----------------|-------|-------|-------|---------|-------|-------|----------------\n";
			combinedStats += organicDogPetStats + "\n\n";
		}
		String roboticPetStats = "";
		for (VirtualPet pet : petList) {
			if (pet instanceof Robotic) {
				roboticPetStats += petStats((Robotic) pet) + "\n";
			}
		}
		if (!roboticPetStats.isEmpty()) {
			combinedStats += "Robotic Pets\t|Boredom|Happiness|Health\n";
			combinedStats += "----------------|-------|---------|-------\n";
			combinedStats += roboticPetStats + "\n\n";
		}
		if (pets.getLitterBoxCleanliness() < 100) {
			combinedStats += "The litter box is " + pets.getLitterBoxCleanliness() + "% clean.\n";
		}
		if (pets.getLitterBoxCleanliness() <= 20) {
			combinedStats += "The litter box needs cleaned NOW!";
		}
		return combinedStats;
	}

	public String petStats(Robotic virtualPet) {
		String name = formatPetNameWithSpaces(virtualPet);
		return name + "|" + virtualPet.getBoredom() + "\t|" + virtualPet.getHappiness() + "\t  |"
				+ virtualPet.getHealth();
	}

	public String petStats(OrganicDog virtualPet) {
		String name = formatPetNameWithSpaces(virtualPet);

		return name + "|" + virtualPet.getHunger() + "\t|" + virtualPet.getThirst() + "\t|" + virtualPet.getBoredom()
				+ "\t|" + virtualPet.getHappiness() + "\t  |" + virtualPet.getWaste() + "\t  |" + virtualPet.getHealth()
				+ "\t  |" + virtualPet.getCageCleanliness();

	}

	public String petStats(OrganicCat virtualPet) {
		String name = formatPetNameWithSpaces(virtualPet);

		return name + "|" + virtualPet.getHunger() + "\t|" + virtualPet.getThirst() + "\t|" + virtualPet.getBoredom()
				+ "\t|" + virtualPet.getHappiness() + "\t  |" + virtualPet.getWaste() + "\t  |"
				+ virtualPet.getHealth();
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

	public String displayNamesAndDescriptions(Shelter pets) {
		String output = "";
		Collection<VirtualPet> petList = pets.pets();
		for (VirtualPet pet : petList) {
			output += "[" + formatPetNameWithSpaces(pet) + "] " + pet.getDescription() + "\n";
		}
		return output;
	}

	public String displayOrganicDogsAndCageCleanliness(Shelter pets) {
		String output = "";
		Collection<VirtualPet> petList = pets.pets();
		for (VirtualPet pet : petList) {
			if (pet instanceof OrganicDog) {
				output += "[" + formatPetNameWithSpaces(pet) + "]   Their cage is "
						+ ((OrganicDog) pet).getCageCleanliness() + "% clean.\n";
			}
		}
		return output;
	}

}
