package virtual_pets_amok;

public class VirtualPetsAmokApp {

	public static void main(String[] args) {
		Shelter myShelter = new Shelter();
		ReportGenerator report = new ReportGenerator();
		myShelter.addPet(new OrganicCat("Sphinx", "is a great cat", myShelter));
		System.out.println(report.petStats((Organic) myShelter.getPet("Sphinx")));
	}

}
