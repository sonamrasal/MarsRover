package main.rover;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class RoverTest {

	private Plateau plateau = new Plateau(5, 5);

	@Test
	public void roverEquality() {
		Rover rover = new Rover(0, 0, Direction.East, plateau);
		Rover anotherRover = new Rover(0, 0, Direction.East, null);
		assertEquals(anotherRover, rover);
	}

	@Test
	public void rotateRoverLeft() {
		Rover rover = new Rover(0, 0, Direction.North, plateau);
		rover.rotateLeft();
		assertEquals(new Rover(0, 0, Direction.West, plateau), rover);
	}

	@Test
	public void rotateRoverRight() {
		Rover rover = new Rover(0, 0, Direction.South, plateau);
		rover.rotateRight();
		assertEquals(new Rover(0, 0, Direction.West, plateau), rover);
	}

	@Test
	public void moveRoverOneUnit() {
		Rover rover = new Rover(2, 3, Direction.West, plateau);
		rover.move();
		assertEquals(new Rover(1, 3, Direction.West, plateau), rover);
		rover = new Rover(4, 1, Direction.South, plateau);
		rover.move();
		assertEquals(new Rover(4, 0, Direction.South, plateau), rover);
	}

	@Test
	public void processSingleTurnLeftCommand() {
		Rover rover = new Rover(1, 4, Direction.West, plateau);
		rover.processCommands("L");
		assertEquals(new Rover(1, 4, Direction.South, plateau), rover);
	}

	@Test
	public void processSingleTurnRightCommand() {
		Rover rover = new Rover(1, 4, Direction.West, plateau);
		rover.processCommands("R");
		assertEquals(new Rover(1, 4, Direction.North, plateau), rover);
	}

	@Test
	public void processSingleMoveCommand() {
		Rover rover = new Rover(1, 3, Direction.East, plateau);
		rover.processCommands("M");
		assertEquals(new Rover(2, 3, Direction.East, plateau), rover);
	}

	@Test
	public void processStringOfCommands() {
		Rover rover = new Rover(1, 2, Direction.North, plateau);
		rover.processCommands("LMLMLMLMM");
		assertEquals(new Rover(1, 3, Direction.North, plateau), rover);
		Rover anotherRover = new Rover(3, 3, Direction.East, plateau);
		anotherRover.processCommands("MMRMMRMRRM");
		assertEquals(new Rover(5, 1, Direction.East, plateau), anotherRover);
	}

	@Test
	public void roverDoesNotCrossPlateauBoundary() {
		Rover rover = new Rover(5, 1, Direction.East, plateau);
		rover.move();
		assertEquals(new Rover(5, 1, Direction.East, plateau), rover);
		Rover anotherRover = new Rover(3, 3, Direction.East, plateau);
		anotherRover.processCommands("MMRMMRMRRMM");
		assertEquals(new Rover(5, 1, Direction.East, plateau), anotherRover);
	}

}
