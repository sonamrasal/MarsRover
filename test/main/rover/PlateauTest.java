package main.rover;

import static org.junit.Assert.*;

import org.junit.Test;

public class PlateauTest {
	private Plateau plateau = new Plateau(new Coordinates(5, 5));

	@Test
	public void isNotWithinPlateauLowerLimit() {
		assertFalse(plateau.isWithinRange(new Coordinates(-1, 0)));
		assertFalse(plateau.isWithinRange(new Coordinates(0, -2)));
		assertFalse(plateau.isWithinRange(new Coordinates(1, -2)));
		assertFalse(plateau.isWithinRange(new Coordinates(-1, 2)));
	}

	@Test
	public void isNotWithinPlateauUpperLimit() {
		assertFalse(plateau.isWithinRange(new Coordinates(5, 6)));
		assertFalse(plateau.isWithinRange(new Coordinates(4, 6)));
		assertFalse(plateau.isWithinRange(new Coordinates(0, 6)));
	}
	
	@Test
	public void isWithinPlateauLimit(){
		assertTrue(plateau.isWithinRange(new Coordinates(4, 3)));
	}

}
