package main.rover;

import main.command.LeftCommand;
import main.command.MoveCommand;
import main.command.RightCommand;

public class Rover {

	private int x_coordinate;
	private Direction direction;
	private int y_coordinate;
	private Plateau plateau;

	public Rover(int x_coordinate, int y_coordinate, Direction direction, Plateau plateau) {
		this.x_coordinate = x_coordinate;
		this.y_coordinate = y_coordinate;
		this.direction = direction;
		this.plateau = plateau;
	}

	@Override
	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (null == other || !this.getClass().equals(other.getClass())) {
			return false;
		}
		Rover rover = (Rover) other;
		return this.x_coordinate == rover.x_coordinate
				&& y_coordinate == rover.y_coordinate
				&& this.direction.equals(rover.direction);
	}

	public void rotateLeft() {
		direction = direction.left();
	}

	public void rotateRight() {
		direction = direction.right();
	}

	public void move() {
		x_coordinate += direction.xIncrement();
		y_coordinate += direction.yIncrement();
		if(!plateau.isWithinRange(x_coordinate, y_coordinate)){
			x_coordinate -= direction.xIncrement();
			y_coordinate -= direction.yIncrement();
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
}
