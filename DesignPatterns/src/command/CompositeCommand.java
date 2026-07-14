package command;

import command.fx.Command;

import java.util.ArrayList;
import java.util.List;

public class CompositeCommand implements Command {
    private final List<Command> commands = new ArrayList<>();

    public void add(Command command) {
        commands.add(command);
    }

    @Override
    public void execute() {
        for (Command command : commands)
            command.execute();
    }
}
