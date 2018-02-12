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
	public void feedShouldIncreaseWaste() {
		int preFeedWaste = underTest.getWaste();
		underTest.feed();
		int postFeedWaste = underTest.getWaste();
		assertThat(preFeedWaste < postFeedWaste, is(true));
	}

	@Test
	public void waterShouldReduceThirstBy20() {
		int preWaterThirst = underTest.getThirst();
		underTest.water();
		int postWaterThirst = underTest.getThirst();
		assertThat(preWaterThirst - postWaterThirst, is(20));
	}

	@Test
	public void walkShouldReduceWaste() {
		int preWalkWaste = underTest.getWaste();
		underTest.walk();
		int postWalkWaste = underTest.getWaste();
		assertThat(preWalkWaste > postWalkWaste, is(true));
	}

	@Test
	public void walkShouldReduceBoredomBy20() {
		int preWalkBoredom = underTest.getBoredom();
		underTest.walk();
		int postWalkBoredom = underTest.getBoredom();
		assertThat(preWalkBoredom - postWalkBoredom, is(20));
	}

	@Test
	public void walkShouldIncreaseHappiness() {
		int preWalk = underTest.getHappiness();
		underTest.walk();
		int postWalk = underTest.getHappiness();
		assertThat(postWalk > preWalk, is(true));
	}

	@Test
	public void playShouldReduceBoredom() {
		int prePlayBoredom = underTest.getBoredom();
		underTest.play();
		int postPlayBoredom = underTest.getBoredom();
		assertThat(prePlayBoredom > postPlayBoredom, is(true));
	}

	@Test
	public void playShouldIncreaseHapiness() {
		int prePlayBoredom = underTest.getHappiness();
		underTest.play();
		int postPlayBoredom = underTest.getHappiness();
		assertThat(postPlayBoredom > prePlayBoredom, is(true));

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

	@Test
	public void organicDogsHaveAStartingHungerThirstAndWasteBetween20And80() {
		for (int i = 0; i < 10001; i++) {
			assertThat(underTest.getHunger() <= 80, is(true));
			assertThat(underTest.getHunger() >= 20, is(true));
			assertThat(underTest.getThirst() <= 80, is(true));
			assertThat(underTest.getThirst() >= 20, is(true));
			assertThat(underTest.getWaste() <= 80, is(true));
			assertThat(underTest.getWaste() >= 20, is(true));
		}

	}

	@Test
	public void organicDogsHaveAStartingBoredomBetween20And80() {
		for (int i = 0; i < 10001; i++) {
			assertThat(underTest.getBoredom() <= 80, is(true));
			assertThat(underTest.getBoredom() >= 20, is(true));
		}

	}

	@Test
	public void organicDogsHaveAStartingHappinessBetween100And50() {
		for (int i = 0; i < 10001; i++) {
			assertThat(underTest.getHappiness() <= 100, is(true));
			assertThat(underTest.getHappiness() >= 50, is(true));
		}

	}

	@Test
	public void feedShouldNotLowerHungerBelow0() {
		for (int i = 0; i < 1000; i++) {
			underTest.feed();
		}
		assertThat(underTest.getHunger(), is(0));
	}

	@Test
	public void waterShouldNotLowerThirstBelow0() {
		for (int i = 0; i < 1000; i++) {
			underTest.water();
		}
		assertThat(underTest.getThirst(), is(0));
	}

	@Test
	public void tickShouldDecreaseHappinessIfCageCleanlinessIsAt0() {
		for (int i = 0; i < 10; i++) {
			underTest.soil();
		}
		for (int i = 0; i < 100; i++) {
			underTest.tick();
		}
		assertThat(underTest.getHappiness(), is(0));
	}

	@Test
	public void soilShouldCapCageCleanlinessAt0() {
		for (int i = 0; i < 1000; i++) {
			underTest.soil();
		}
		assertThat(underTest.getCageCleanliness(), is(0));
	}

	@Test
	public void walkShouldLimitAffectedValuesTo0Or100CaseDependent() {
		for (int i = 0; i < 1000; i++) {
			underTest.walk();
		}
		assertThat(underTest.getWaste(), is(0));
		assertThat(underTest.getBoredom(), is(0));
		assertThat(underTest.getHappiness(), is(100));
	}

	@Test
	public void playShouldLimitItsEffectTo0Or100CaseDependent() {
		for (int i = 0; i < 1000; i++) {
			underTest.play();
		}

		assertThat(underTest.getBoredom(), is(0));
		assertThat(underTest.getHappiness(), is(100));

	}
}
