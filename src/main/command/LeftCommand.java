package main.command;

import main.rover.Rover;

public class LeftCommand implements ICommand {

	@Override
	public void execute(Rover rover) {
		rover.rotateLeft();
	}

}
