package main.command;

import main.rover.Rover;

public class LeftCommand implements ICommand {

	private Rover rover;

	public LeftCommand(Rover rover) {
		this.rover = rover;
	}

	@Override
	public void execute() {
		rover.rotateLeft();
	}

}
