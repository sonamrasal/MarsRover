package main.rover;

import static org.junit.Assert.*;

import org.junit.Test;

public class PlateauTest {
	private Plateau plateau = new Plateau(5, 5);

	@Test
	public void isNotWithinPlateauLowerLimit() {
		assertFalse(plateau.isWithinRange(-1, 0));
		assertFalse(plateau.isWithinRange(0, -2));
		assertFalse(plateau.isWithinRange(1, -2));
		assertFalse(plateau.isWithinRange(-1, 2));
	}

	@Test
	public void isNotWithinPlateauUpperLimit() {
		assertFalse(plateau.isWithinRange(5, 6));
		assertFalse(plateau.isWithinRange(4, 6));
		assertFalse(plateau.isWithinRange(0, 6));
	}
	
	@Test
	public void isWithinPlateauLimit(){
		assertTrue(plateau.isWithinRange(4, 3));
	}

}
