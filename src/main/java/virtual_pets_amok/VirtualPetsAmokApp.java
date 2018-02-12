package virtual_pets_amok;

import java.util.Scanner;

public class VirtualPetsAmokApp {

	public static void main(String[] args) {

		Shelter myShelter = new Shelter();
		ReportGenerator report = new ReportGenerator();
		Scanner input = new Scanner(System.in);
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
		System.out.println();

		// Game Loop
		while (!myShelter.isThereADeadPet()) {
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
				System.out.println(report.combinedPetStats(myShelter));
			}
			System.out.println();
			printMainUserMenu();
			mainMenuChoice = input.nextLine();
			switch (mainMenuChoice) {
			case "1": {
				myShelter.feedPets();
				System.out.println("The shelter is quiet as the pets focus on eating.");
				break;
			}
			case "2": {
				myShelter.waterPets();
				System.out.println("All your pets have water in their dishes.");
				break;
			}
			case "3": {
				myShelter.walkAllDogs();
				System.out.println("All dogs made it back from the walk.");
				break;
			}
			case "4": {
				System.out.println("Which pet would you like to play with?");
				System.out.println(report.displayNamesAndDescriptions(myShelter));
				petChoice = input.nextLine();
				myShelter.playWithPet(petChoice);
				System.out.println(petChoice + " loves the attention!");
				break;
			}
			case "5": {
				myShelter.oilAllRobots();
				System.out.println("All robots have been oiled.");
				break;
			}
			case "6": {
				System.out.println("Which dog's cage would you like to clean?");
				System.out.println(report.displayOrganicDogsAndCageCleanliness(myShelter));
				petChoice = input.nextLine();
				myShelter.cleanDogCage(petChoice);
				break;
			}
			case "7": {
				myShelter.cleanLitterBox();
				System.out.println("The litter box is empty, but the cats have formed a line to use it again.");
				break;
			}
			case "8": {
				System.out.println("You found another circus pet in the alley behind the shelter.");
				System.out.println(
						"It tries to get away, but you manage to corner it! What would you like to name this pet?");
				String nameChoice = input.nextLine();
				System.out.println("What kind of behavior do they show?");
				String descriptionChoice = input.nextLine();
				System.out.println("What kind of pet is it? 1)Organic Dog  2)Organic Cat  3)Robot Dog  4)Robot Cat?");
				System.out.println("Use the number to select your answer:");
				petChoice = input.nextLine();
				switch (petChoice) {
				case "1": {
					myShelter.addPet(new OrganicDog(nameChoice, descriptionChoice));
					break;
				}
				case "2": {
					myShelter.addPet(new OrganicCat(nameChoice, descriptionChoice, myShelter));
					break;
				}
				case "3": {
					myShelter.addPet(new RobotDog(nameChoice, descriptionChoice));
					break;
				}
				case "4": {
					myShelter.addPet(new RoboticCat(nameChoice, descriptionChoice, myShelter));
					break;
				}
				default: {
					System.out.println("huh?");
				}
				}
				break;
			}
			case "9": {
				System.out.println("A nice family shows up and wants a circus pet for their own!");
				System.out.println("Which pet would you like to let them take home?");
				System.out.println(report.displayNamesAndDescriptions(myShelter));
				petChoice = input.nextLine();
				myShelter.adoptOut(petChoice);

				System.out.println(petChoice
						+ " runs to their new family. They all look a little nervous in their car, but they are on their way.");
				break;
			}
			default: {
				System.out.println("Huh?");
			}
			}
			myShelter.tick();
		}

		input.close();
	}

	public static void printMainUserMenu() {
		System.out.println();
		System.out.println("What would you like to do next?");
		System.out.println("-------------------------------");
		System.out.println("1. Feed all pets.");
		System.out.println("2. Water all pets.");
		System.out.println("3. Walk all dogs.");
		System.out.println("4. Play with a pet.");
		System.out.println("5. Oil all robotic pets.");
		System.out.println("6. Clean an organic dog's cage.");
		System.out.println("7. Clean the shelter litter box.");
		System.out.println("8. Bring a pet in off the streets.");
		System.out.println("9. Send a pet to a new home.");
		System.out.println();
	}
}
