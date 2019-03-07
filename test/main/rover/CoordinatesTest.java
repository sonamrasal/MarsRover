package main.rover;

import static org.junit.Assert.*;

import org.junit.Test;

public class CoordinatesTest {
	private Coordinates coordinates = new Coordinates(4, 5);

	@Test
	public void prettyPrintCoordinates() {
		assertTrue("4 5".equals(coordinates.toString()));
	}

	@Test
	public void incrementCoordinates() {
		assertTrue("7 1".equals(coordinates.afterIncrement(3, -4).toString()));
	}

	@Test
	public void isBelowCoordinates() {
		assertTrue(new Coordinates(1, 4).isBelow(coordinates));
	}

	@Test
	public void isNotBelowCoordinates() {
		assertFalse(new Coordinates(5, 7).isBelow(coordinates));
	}

}
