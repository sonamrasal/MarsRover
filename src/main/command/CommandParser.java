package main.command;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommandParser {

	private static Map<String, ICommand> commandMap = new HashMap(){{
		put('L', new LeftCommand());
		put('R', new RightCommand());
		put('M', new MoveCommand());
	}};

	public static ICommand getCommandsFor(String commands) {
		List<ICommand> allCommands = new ArrayList<ICommand>();
		for (char singleCommand : commands.toCharArray()) {
			allCommands.add(commandMap.get(singleCommand));
		}
		return new MacroCommand(allCommands);
	}

}
