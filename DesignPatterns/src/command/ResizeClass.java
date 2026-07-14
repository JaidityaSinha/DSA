package command;

import command.fx.Command;

public class ResizeClass implements Command {
    @Override
    public void execute() {
        System.out.println("Resize");
    }
}
