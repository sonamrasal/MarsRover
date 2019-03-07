package main.command;

import main.rover.Rover;

public class MoveCommand implements ICommand {

	@Override
	public void execute(Rover rover) {
		rover.move();
	}

}
