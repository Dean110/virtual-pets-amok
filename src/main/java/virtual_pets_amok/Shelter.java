package virtual_pets_amok;

public class Shelter {

	private int litterBoxCleanliness;

	public int getLitterBoxCleanliness() {

		return litterBoxCleanliness;
	}

	public void soilLitterBox() {
		litterBoxCleanliness -= 20;
	}

}
