package main.rover;

import main.command.CommandParser;

public class Rover {
	private Direction direction;
	private Plateau plateau;
	private Coordinates coordinates;

	public Rover(Coordinates coordinates, Direction direction, Plateau plateau) {
		this.coordinates = coordinates;
		this.direction = direction;
		this.plateau = plateau;
	}

	public void rotateLeft() {
		direction = direction.left();
	}

	public void rotateRight() {
		direction = direction.right();
	}

	public void move() {
		Coordinates coordinatesAfterIncrement = coordinates.afterIncrement(direction.xIncrement(), direction.yIncrement());
		if (plateau.isWithinRange(coordinatesAfterIncrement)) {
			this.coordinates = coordinatesAfterIncrement;
		}
	}

	public void processCommands(String commands) {
		CommandParser.getCommandsFor(commands).execute(this);
	}

	public String currentLocation() {
		return coordinates.toString() + " " + direction.toString();
	}
}
