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
	public void playShouldReduceBoredomBy40() {
		int prePlayBoredom = underTest.getBoredom();
		underTest.play();
		int postPlayBoredom = underTest.getBoredom();
		assertThat(prePlayBoredom - postPlayBoredom, is(40));
	}

	@Test
	public void walkShouldIncreaseHappinessBy40() {
		int preWalk = underTest.getHappiness();
		underTest.walk();
		int postWalk = underTest.getHappiness();
		assertThat(postWalk - preWalk, is(40));
	}
}
