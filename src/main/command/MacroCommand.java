package main.command;

import java.util.List;

import main.rover.Rover;

public class MacroCommand implements ICommand {
	private List<ICommand> commands;

	public MacroCommand(List<ICommand> commands) {
		this.commands = commands;
	}

	@Override
	public void execute(Rover rover) {
		commands.forEach(command -> command.execute(rover));
	}

}
