package virtual_pets_amok;

import java.util.Scanner;

import virtual_pet_shelter.VirtualPetShelter;

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
		
		//Game Loop
		while()
		
	}

}
