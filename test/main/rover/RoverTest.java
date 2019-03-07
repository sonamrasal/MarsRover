package main.rover;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class RoverTest {

	private Plateau plateau = new Plateau(new Coordinates(5, 5));
	private Coordinates lowerLeft = new Coordinates(0, 0);

	@Test
	public void roverCanOutputItsCurrentLocation() {
		Rover rover = new Rover(new Coordinates(3, 1), Direction.South, plateau);
		assertTrue("3 1 S".equals(rover.currentLocation()));
	}

	@Test
	public void rotateRoverLeft() {
		Rover rover = new Rover(lowerLeft, Direction.North, plateau);
		rover.rotateLeft();
		assertTrue("0 0 W".equals(rover.currentLocation()));
	}

	@Test
	public void rotateRoverRight() {
		Rover rover = new Rover(lowerLeft, Direction.South, plateau);
		rover.rotateRight();
		assertTrue("0 0 W".equals(rover.currentLocation()));
	}

	@Test
	public void moveRoverOneUnit() {
		Rover rover = new Rover(new Coordinates(2, 3), Direction.West, plateau);
		rover.move();
		assertTrue("1 3 W".equals(rover.currentLocation()));
		rover = new Rover(new Coordinates(4, 1), Direction.South, plateau);
		rover.move();
		assertTrue("4 0 S".equals(rover.currentLocation()));
	}

	@Test
	public void processSingleTurnLeftCommand() {
		Rover rover = new Rover(new Coordinates(1, 4), Direction.West, plateau);
		rover.processCommands("L");
		assertTrue("1 4 S".equals(rover.currentLocation()));
	}

	@Test
	public void processSingleTurnRightCommand() {
		Rover rover = new Rover(new Coordinates(1, 4), Direction.West, plateau);
		rover.processCommands("R");
		assertTrue("1 4 N".equals(rover.currentLocation()));
	}

	@Test
	public void processSingleMoveCommand() {
		Rover rover = new Rover(new Coordinates(1, 3), Direction.East, plateau);
		rover.processCommands("M");
		assertTrue("2 3 E".equals(rover.currentLocation()));
	}

	@Test
	public void processStringOfCommands() {
		Rover rover = new Rover(new Coordinates(1, 2), Direction.North, plateau);
		rover.processCommands("LMLMLMLMM");
		assertTrue("1 3 N".equals(rover.currentLocation()));
		Rover anotherRover = new Rover(new Coordinates(3, 3), Direction.East, plateau);
		anotherRover.processCommands("MMRMMRMRRM");
		assertTrue("5 1 E".equals(anotherRover.currentLocation()));
	}

	@Test
	public void roverDoesNotCrossPlateauBoundary() {
		Rover rover = new Rover(new Coordinates(5, 1), Direction.East, plateau);
		rover.move();
		assertTrue("5 1 E".equals(rover.currentLocation()));
		Rover anotherRover = new Rover(new Coordinates(3, 3), Direction.East, plateau);
		anotherRover.processCommands("MMRMMRMRRMM");
		assertTrue("5 1 E".equals(anotherRover.currentLocation()));
	}

}
