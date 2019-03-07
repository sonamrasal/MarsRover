package main.command;

import main.rover.Rover;

public interface ICommand {
	public void execute(Rover rover);
}
