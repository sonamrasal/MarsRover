package main.rover;

import main.command.LeftCommand;
import main.command.MoveCommand;
import main.command.RightCommand;

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
		for (char singleCommand : commands.toCharArray()) {
			switch (singleCommand) {
			case 'L':
				new LeftCommand(this).execute();
				break;
			case 'R':
				new RightCommand(this).execute();
				break;
			case 'M':
				new MoveCommand(this).execute();
				break;
			}
		}
	}

	public String currentLocation() {
		return coordinates.toString() + " " + direction.toString();
	}
}
