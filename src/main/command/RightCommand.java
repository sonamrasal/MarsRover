package main.command;

import main.rover.Rover;

public class RightCommand implements ICommand {

	@Override
	public void execute(Rover rover) {
		rover.rotateRight();
	}

}
