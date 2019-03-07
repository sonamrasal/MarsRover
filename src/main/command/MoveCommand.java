package main.command;

import main.rover.Rover;

public class MoveCommand implements ICommand {

	private Rover rover;

	public MoveCommand(Rover rover) {
		this.rover = rover;
	}

	@Override
	public void execute() {
		rover.move();
	}

}
