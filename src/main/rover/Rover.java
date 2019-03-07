package main.rover;

import java.util.ArrayList;
import java.util.List;

import main.command.ICommand;
import main.command.LeftCommand;
import main.command.MacroCommand;
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
		List<ICommand> allCommands = new ArrayList();
		for (char singleCommand : commands.toCharArray()) {
			switch (singleCommand) {
			case 'L':
				allCommands.add(new LeftCommand());
				break;
			case 'R':
				allCommands.add(new RightCommand());
				break;
			case 'M':
				allCommands.add(new MoveCommand());
				break;
			}
		}
		new MacroCommand(allCommands).execute(this);
	}

	public String currentLocation() {
		return coordinates.toString() + " " + direction.toString();
	}
}
