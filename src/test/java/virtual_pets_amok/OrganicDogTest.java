package virtual_pets_amok;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class OrganicDogTest {
	private static final String ORGANIC_DOG_DESCRIPTION = "Fights and bites";
	private static final String ORGANIC_DOG_NAME = "Bruce";

	@Test
	public void shouldHaveAName() {
		OrganicDog underTest = new OrganicDog(ORGANIC_DOG_NAME, "");
		String result = underTest.getName();
		assertThat(result, is(ORGANIC_DOG_NAME));
	}

	OrganicDog underTest = new OrganicDog(ORGANIC_DOG_NAME, ORGANIC_DOG_DESCRIPTION);

	@Test
	public void shouldHaveADescription() {
		String result = underTest.getDescription();
		assertThat(result, is(ORGANIC_DOG_DESCRIPTION));
	}

	@Test
	public void feedShouldReduceHungerBy20() {
		int preFeedHunger = underTest.getHunger();
		underTest.feed();
		int postFeedHunger = underTest.getHunger();
		assertThat(preFeedHunger - postFeedHunger, is(20));

	}

	@Test
	public void waterShouldReduceThirstBy20() {
		int preWaterThirst = underTest.getThirst();
		underTest.water();
		int postWaterThirst = underTest.getThirst();
		assertThat(preWaterThirst - postWaterThirst, is(20));
	}

	@Test
	public void walkShouldReduceWasteBy30() {
		int preWalkWaste = underTest.getWaste();
		underTest.walk();
		int postWalkWaste = underTest.getWaste();
		assertThat(preWalkWaste - postWalkWaste, is(30));
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
}
