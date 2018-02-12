package virtual_pets_amok;

import java.util.Collection;
import java.util.Scanner;

public class VirtualPetsAmokApp {

	public static void main(String[] args) {

		Shelter myShelter = new Shelter();
		ReportGenerator report = new ReportGenerator();
		Scanner input = new Scanner(System.in);
		Collection<VirtualPet> petList;
		String mainMenuChoice;
		String petChoice;

		// App Intro and default dog added
		System.out.println("Welcome to the Harding Hotel for Misfit Pets!");
		System.out.println();
		System.out.println(
				"We currently have no pets in the shelter, but fortunatly there is a traveling techno circus in town.\n"
						+ "I'm sure that means we will be able to acquire some misfit pets from the streets when they leave.");
		System.out.println();
		System.out.println("A single dog walks down the street towards you, it has no collar.\n"
				+ "It stops and lefts it's leg up and pees on your boot. I think we have our first misfit dog!");
		System.out.println();
		System.out.println("After a fierce fight you finally bring the dog inside the shelter.\n"
				+ "You decide to name him Bruce Wee, and it appears that he likes to bite and fight!");

		myShelter.addPet(new OrganicDog("Bruce Wee", "he likes to bite and fight."));
		myShelter.addPet(new OrganicDog("Bosco", "his fart is worse than his bite."));
		myShelter.addPet(new RobotDog("K-9", "he is a doctor's best friend."));
		System.out.println();

		// Game Loop
		// while (myShelter) {
		if (myShelter.getSize() < 1) {
			System.out.println("We are out of pets! Go find some more before we lose our grant money.");
			System.out.println();

		} else {
			if (myShelter.getSize() == 1) {
				System.out.println("This is how your pet is doing:");
			} else {
				System.out.println("This is how your pets are doing:");
			}

			System.out.println();
			// System.out.println("Name\t\t|Hunger\t|Thirst\t|Boredom|Happiness|Health");
			// System.out.println("----------------|-------|-------|-------|---------|-------");
			// }
			// petList = myShelter.pets();
			// String organicPetStats = "";
			//
			// for (VirtualPet pet : petList) {
			// if (pet instanceof Organic) {
			// organicPetStats += report.petStats((Organic) pet) + "\n";
			// }
			// }
			// if (!organicPetStats.isEmpty()) {
			// System.out.println(organicPetStats);
			System.out.println(report.combinedPetStats(myShelter));
		}
	}

}
