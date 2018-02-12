package virtual_pets_amok;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class RoboticDogTest {
	private static final String DEFAULT_DESCRIPTION = "A doctor's best friend.";
	private static final String DEFAULT_NAME = "K-9";
	RoboticDog underTest = new RoboticDog(DEFAULT_NAME, DEFAULT_DESCRIPTION);

	@Test
	public void roboDogShouldHaveANameAndDescription() {
		String name = underTest.getName();
		String description = underTest.getDescription();
		assertThat(name, is(DEFAULT_NAME));
		assertThat(description, is(DEFAULT_DESCRIPTION));
	}

	@Test
	public void oilShouldIncreaseHealthBy20() {
		int preOil = underTest.getHealth();
		underTest.oil();
		int postOil = underTest.getHealth();
		assertThat(postOil - preOil, is(20));
	}

	@Test
	public void walkShouldReduceBoredomBy20() {
		int preWalkBoredom = underTest.getBoredom();
		underTest.walk();
		int postWalkBoredom = underTest.getBoredom();
		assertThat(preWalkBoredom - postWalkBoredom, is(20));
	}

	@Test
	public void playShouldReduceBoredom() {
		int prePlayBoredom = underTest.getBoredom();
		underTest.play();
		int postPlayBoredom = underTest.getBoredom();
		assertThat(prePlayBoredom > postPlayBoredom, is(true));
	}

	@Test
	public void walkShouldIncreaseHappiness() {
		int preWalk = underTest.getHappiness();
		underTest.walk();
		int postWalk = underTest.getHappiness();
		assertThat(postWalk > preWalk, is(true));
	}

	@Test
	public void walkShouldLimitAffectedValuesTo0Or100CaseDependent() {
		for (int i = 0; i < 1000; i++) {
			underTest.walk();
		}

		assertThat(underTest.getBoredom(), is(0));
		assertThat(underTest.getHappiness(), is(100));
	}

	@Test
	public void oilShouldNotIncreaseHealthAbove100() {
		for (int i = 0; i < 1000; i++) {
			underTest.oil();
		}
		assertThat(underTest.getHealth(), is(100));
	}
}
