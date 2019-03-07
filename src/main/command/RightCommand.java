package main.command;

import main.rover.Rover;

public class RightCommand implements ICommand {

	private Rover rover;

	public RightCommand(Rover rover) {
		this.rover = rover;
	}

	@Override
	public void execute() {
		rover.rotateRight();
	}

}
