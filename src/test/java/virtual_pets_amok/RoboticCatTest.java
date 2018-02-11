package virtual_pets_amok;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class RoboticCatTest {
	private static final String ROBOT_CAT_DESCRIPTION = "He is painted green.";
	private static final String ROBOT_CAT_NAME = "Pidge";

	Shelter testShelter = new Shelter();
	Robotic underTest = new RoboticCat(ROBOT_CAT_NAME, ROBOT_CAT_DESCRIPTION, testShelter);

	@Test
	public void shouldBeAnOrganicCatWithAName() {
		String result = underTest.getName();
		assertThat(result, is(ROBOT_CAT_NAME));
	}

	@Test
	public void shouldHaveADescription() {
		String result = underTest.getDescription();
		assertThat(result, is(ROBOT_CAT_DESCRIPTION));
	}

	@Test
	public void shouldBePutInShelterUponCreation() {
		int result = testShelter.getSize();
		assertThat(result, is(1));

	}

	@Test
	public void shouldHaveTwoCatsInTheShelter() {
		@SuppressWarnings("unused")
		RoboticCat underTest2 = new RoboticCat("A", "Cat", testShelter);
		int result = testShelter.getSize();
		assertThat(result, is(2));
	}

	@Test
	public void tickShouldDecreaseHappinessBy1() {
		int preTickHappiness = underTest.getHappiness();
		underTest.tick();
		int postTickHappiness = underTest.getHappiness();
		assertThat(preTickHappiness - postTickHappiness, is(1));
	}

	@Test
	public void tickShouldDecreaseHealthBy3() {
		int preTickHealth = underTest.getHealth();
		underTest.tick();
		int postTickHealth = underTest.getHealth();
		assertThat(preTickHealth - postTickHealth, is(3));
	}
}
