package virtual_pets_amok;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

import java.util.Collection;

import org.junit.Test;

public class ShelterTest {
	final static String PET_NAME = "Bruce";
	final static String PET_DESCRIPTION = "Fights and bites";
	private Shelter underTest = new Shelter();
	private VirtualPet testPet = new OrganicDog(PET_NAME, PET_DESCRIPTION);

	@Test
	public void shouldAdmitPet() {
		underTest.addPet(testPet);
		VirtualPet retrieved = underTest.findPet(PET_NAME);
		assertThat(retrieved, is(testPet));
	}

	@Test
	public void shouldAdmitMultiplePets() {

		String anotherPetName = "Bosco";
		VirtualPet anotherTestPet = new OrganicDog(anotherPetName, PET_DESCRIPTION);

		underTest.addPet(testPet);
		underTest.addPet(anotherTestPet);

		Collection<VirtualPet> pets = underTest.pets();
		assertThat(pets, containsInAnyOrder(testPet, anotherTestPet));
	}

	@Test
	public void shouldAdoptPetOutOfShelter() {
		underTest.addPet(testPet);

		underTest.adoptOut(PET_NAME);

		VirtualPet found = underTest.findPet(PET_NAME);
		assertThat(found, is(nullValue()));
	}

	String anotherPetName = "Bosco";
	VirtualPet anotherTestPet = new OrganicDog(anotherPetName, PET_DESCRIPTION);

	@Test
	public void feedPetsShouldLowerHungerOfPetsInShelter() {
		int preFeedHungerTestPet = ((Organic) testPet).getHunger();
		int preFeedHungeranotherTestPet = ((Organic) anotherTestPet).getHunger();

		underTest.addPet(testPet);
		underTest.addPet(anotherTestPet);
		underTest.feedPets();

		int petHunger = ((Organic) underTest.findPet(PET_NAME)).getHunger();
		int anotherPetHunger = ((Organic) underTest.findPet(anotherPetName)).getHunger();
		assertThat(testPet instanceof OrganicDog, is(true));
		assertThat(preFeedHungerTestPet - petHunger, is(20));
		assertThat(preFeedHungeranotherTestPet - anotherPetHunger, is(20));
	}

	@Test
	public void waterPetsShouldLowerThirstOfPetsInShelter() {
		int preWaterThirstTestPet = ((Organic) testPet).getThirst();
		int preWaterThirstanotherTestPet = ((Organic) anotherTestPet).getThirst();

		underTest.addPet(testPet);
		underTest.addPet(anotherTestPet);
		underTest.waterPets();

		int petThirst = ((Organic) testPet).getThirst();
		int anotherPetThirst = ((Organic) anotherTestPet).getThirst();
		assertThat(preWaterThirstTestPet - petThirst, is(20));
		assertThat(preWaterThirstanotherTestPet - anotherPetThirst, is(20));
	}

	@Test
	public void playWithPetShouldLowerBoredomOfOnePetBy40() {
		int prePlayBoredom = testPet.getBoredom();
		int prePlayAnotherPetBoredom = anotherTestPet.getBoredom();
		underTest.addPet(testPet);
		underTest.addPet(anotherTestPet);
		underTest.playWithPet(PET_NAME);

		int petBoredom = underTest.findPet(PET_NAME).getBoredom();
		int anotherPetBoredom = underTest.findPet(anotherPetName).getBoredom();
		assertThat(prePlayBoredom - petBoredom, is(40));
		assertThat(prePlayAnotherPetBoredom - anotherPetBoredom, is(0));
	}

	@Test
	public void tickShouldIncreaseHungerThirstAndBoredomBy1() {
		underTest.addPet(testPet);
		int preTickHunger = ((Organic) underTest.findPet(PET_NAME)).getHunger();
		int preTickThirst = ((Organic) underTest.findPet(PET_NAME)).getThirst();
		int prePetBoredom = underTest.findPet(PET_NAME).getBoredom();
		underTest.tick();
		int petHunger = ((Organic) underTest.findPet(PET_NAME)).getHunger();
		int petThirst = ((Organic) underTest.findPet(PET_NAME)).getThirst();
		int petBoredom = underTest.findPet(PET_NAME).getBoredom();
		assertThat(petHunger - preTickHunger, is(1));
		assertThat(petThirst - preTickThirst, is(1));
		assertThat(petBoredom - prePetBoredom, is(1));
	}

	@Test
	public void shouldReturnNumberOfPetsAtShelterAs2() {
		underTest.addPet(testPet);
		underTest.addPet(anotherTestPet);
		int petCount = underTest.getSize();
		assertThat(petCount, is(2));
	}

	@Test
	public void shouldReturnNumberOfPetsAtShelterAs1() {
		underTest.addPet(testPet);
		// Assert
		int petCount = underTest.getSize();
		assertThat(petCount, is(1));
	}

	@Test
	public void shouldReturnNumberOfPetsAtShelterAs0() {
		// Assert
		int petCount = underTest.getSize();
		assertThat(petCount, is(0));
	}

	@Test
	public void shouldReturnTrueForIsThereADeadPet() {
		underTest.addPet(testPet);
		for (int i = 0; i < 151; i++) {
			underTest.tick();
		}
		boolean result = underTest.isThereADeadPet();
		assertThat(result, is(true));
	}

	@Test
	public void shouldReturnFalseForIsThereADeadPet() {
		underTest.addPet(testPet);

		boolean result = underTest.isThereADeadPet();
		assertThat(result, is(false));
	}

	@Test
	public void shouldReturnFalseForIsThereADeadPetIfWeHaveNoPets() {
		boolean result = underTest.isThereADeadPet();
		assertThat(result, is(false));
	}

	@Test
	public void cleanLitterBoxShouldResetLitterBoxCleanlinessTo100() {
		underTest.cleanLitterBox();
		int result = underTest.getLitterBoxCleanliness();
		assertThat(result, is(100));
	}

	@Test
	public void walkAllDogsWalksEachDogInTheShelter() {
		underTest.addPet(testPet);
		underTest.addPet(new OrganicCat("Cat", "T", underTest));
		int preTestDogHappiness = testPet.getHappiness();
		int preTestCatHappiness = underTest.getPet("Cat").getHappiness();
		underTest.walkAllDogs();
		int postTestDogHappiness = testPet.getHappiness();
		int postTestCatHappiness = underTest.getPet("Cat").getHappiness();
		assertThat(postTestDogHappiness - preTestDogHappiness, is(40));
		assertThat(postTestCatHappiness - preTestCatHappiness, is(0));

	}
}
