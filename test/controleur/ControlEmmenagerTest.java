package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import villagegaulois.Village;
import personnages.Chef;
import personnages.Gaulois;

class ControlEmmenagerTest {
	
	private Village village1;

	@BeforeEach
	public void initialiserSituation() {
		System.out.println("Initialisation ... ");
		Village village1 = new Village ("Napoli", 10, 10);
		Chef insigne = new Chef("Insigne", 15, village1);
		village1.setChef(insigne);
		
		
	}
	
	
	@Test
	void testControlEmmenager() {
		ControlEmmenager controlEmmenager = new ControlEmmenager(village1);
		assertNotNull(controlEmmenager, "Constructeur ne renvoie pas null");
	}

	@Test
	void testIsHabitant() {
		fail("Not yet implemented");
	}

	@Test
	void testAjouterDruide() {
		fail("Not yet implemented");
	}

	@Test
	void testAjouterGaulois() {
		fail("Not yet implemented");
	}

}
