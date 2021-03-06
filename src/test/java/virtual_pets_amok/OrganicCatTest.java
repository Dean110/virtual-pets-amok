package virtual_pets_amok;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class OrganicCatTest {
	private static final String ORGANIC_CAT_DESCRIPTION = "Chill cat";
	private static final String ORGANIC_CAT_NAME = "Sphinx";

	Shelter testShelter = new Shelter();
	OrganicCat underTest = new OrganicCat(ORGANIC_CAT_NAME, ORGANIC_CAT_DESCRIPTION, testShelter);

	@Test
	public void shouldBeAnOrganicCatWithAName() {
		String result = underTest.getName();
		assertThat(result, is(ORGANIC_CAT_NAME));
	}

	@Test
	public void shouldHaveADescription() {
		String result = underTest.getDescription();
		assertThat(result, is(ORGANIC_CAT_DESCRIPTION));
	}

	@Test
	public void shouldBePutInShelterUponCreation() {
		int result = testShelter.getSize();
		assertThat(result, is(1));

	}

	@Test
	public void shouldHaveTwoCatsInTheShelter() {
		@SuppressWarnings("unused")
		OrganicCat underTest2 = new OrganicCat("A", "Cat", testShelter);
		int result = testShelter.getSize();
		assertThat(result, is(2));
	}

	@Test
	public void soilShouldReduceWasteToZero() {
		int preSoilWaste = underTest.getWaste();
		underTest.soil();
		int postSoilWaste = underTest.getWaste();
		assertThat(preSoilWaste != 0, is(true));
		assertThat(postSoilWaste, is(0));

	}

	@Test
	public void soilShouldLowerLitterBoxCleanlinessBy20() {

		int preSoilCleanliness = testShelter.getLitterBoxCleanliness();
		underTest.soil();
		int postSoilCleanliness = testShelter.getLitterBoxCleanliness();
		assertThat(preSoilCleanliness - postSoilCleanliness, is(20));
	}

	@Test
	public void tickShouldIncreaseHungerThirstBoredomBy1() {
		int preTickHunger = underTest.getHunger();
		int preTickThirst = underTest.getThirst();
		int preTickBoredom = underTest.getBoredom();
		underTest.tick();
		int postTickHunger = underTest.getHunger();
		int postTickThirst = underTest.getThirst();
		int postTickBoredom = underTest.getBoredom();
		assertThat(postTickHunger - preTickHunger, is(1));
		assertThat(postTickThirst - preTickThirst, is(1));
		assertThat(postTickBoredom - preTickBoredom, is(1));
	}

	@Test
	public void tickShouldIncreaseWasteBy1() {
		int preTickWaste = underTest.getWaste();
		underTest.tick();
		int postTickWaste = underTest.getWaste();
		assertThat(postTickWaste - preTickWaste, is(1));
	}

	@Test
	public void tickShouldDecreaseHappinessBy1() {
		int preTickHappiness = underTest.getHappiness();
		underTest.tick();
		int postTickHappiness = underTest.getHappiness();
		assertThat(preTickHappiness - postTickHappiness, is(1));
	}

	@Test
	public void tickShouldSoilLitterBoxIfWasteIsAbove100() {
		int preSoilCleanliness = testShelter.getLitterBoxCleanliness();
		for (int i = 0; i < 105; i++) {
			underTest.tick();
		}
		int postSoilCleanliness = testShelter.getLitterBoxCleanliness();
		assertThat(preSoilCleanliness > postSoilCleanliness, is(true));
	}

	@Test
	public void tickShouldCapHungerAt100() {
		for (int i = 0; i <= 120; i++) {
			underTest.tick();
		}
		int postTickHunger = underTest.getHunger();
		assertThat(postTickHunger, is(100));
	}

	@Test
	public void tickShouldLowerHealthIfHungerIsAt100() {
		for (int i = 0; i <= 120; i++) {
			underTest.tick();
		}
		int postTickHealth = underTest.getHealth();
		assertThat(postTickHealth <= 0, is(true));

	}

	@Test
	public void tickShouldCapThirstAt100() {
		for (int i = 0; i <= 120; i++) {
			underTest.tick();
		}
		int postTickThirst = underTest.getThirst();
		assertThat(postTickThirst, is(100));
	}

	@Test
	public void tickShouldLowerHealthIfThirstIsAt100() {
		for (int i = 0; i <= 120; i++) {
			underTest.tick();
		}
		int postTickHealth = underTest.getHealth();
		assertThat(postTickHealth <= 0, is(true));
	}

	@Test
	public void tickShouldCapBoredom() {
		for (int i = 0; i <= 120; i++) {
			underTest.tick();
		}
		int postTickBoredom = underTest.getBoredom();
		assertThat(postTickBoredom, is(100));
	}

	public void tickShouldLowerHappinessIfBoredomIsAt100() {
		for (int i = 0; i <= 120; i++) {
			underTest.tick();
		}
		int postTickHappiness = underTest.getHappiness();
		assertThat(postTickHappiness < 0, is(true));
	}

	@Test
	public void tickShouldDecreaseHappinessIfLitterBoxCleanlinessIsAt0() {
		for (int i = 0; i < 10; i++) {
			underTest.soil();
		}
		for (int i = 0; i < 100; i++) {
			underTest.tick();
		}
		assertThat(underTest.getHappiness(), is(0));
	}

}