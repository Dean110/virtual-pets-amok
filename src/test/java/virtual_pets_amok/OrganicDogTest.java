package virtual_pets_amok;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class OrganicDogTest {
	private static final String ORGANIC_DOG_DESCRIPTION = "Fights and bites";
	private static final String ORGANIC_DOG_NAME = "Bruce";

	@Test
	public void shouldHaveAName() {
		VirtualPet underTest = new OrganicDog("Bruce", "");
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
	public void walkShouldIncreaseHappinessBy40() {
		int preWalk = underTest.getHappiness();
		underTest.walk();
		int postWalk = underTest.getHappiness();
		assertThat(postWalk - preWalk, is(40));
	}

	@Test
	public void playShouldReduceBoredomBy40() {
		int prePlayBoredom = underTest.getBoredom();
		underTest.play();
		int postPlayBoredom = underTest.getBoredom();
		assertThat(prePlayBoredom - postPlayBoredom, is(40));
	}

	@Test
	public void playShouldIncreaseHapinessBy30() {
		int prePlayBoredom = underTest.getHappiness();
		underTest.play();
		int postPlayBoredom = underTest.getHappiness();
		assertThat(postPlayBoredom - prePlayBoredom, is(30));

	}

	@Test
	public void soilShouldSoilCage() {
		int preSoilCageCleanliness = underTest.getCageCleanliness();
		underTest.soil();
		int postSoilCageCleanliness = underTest.getCageCleanliness();
		assertTrue(postSoilCageCleanliness < preSoilCageCleanliness);
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
	public void tickShouldTriggerSoilIfWasteIsAbove100() {
		int preSoilCageCleanliness = underTest.getCageCleanliness();
		for (int i = 0; i < 110; i++) {
			underTest.tick();
		}
		int postSoilCageCleanliness = underTest.getCageCleanliness();
		assertTrue(postSoilCageCleanliness < preSoilCageCleanliness);
	}
}
