package command.editor;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class History {
    private Stack<UndoableCommand> commands = new Stack<>();

    public void push(UndoableCommand command) {
        commands.push(command);
    }

    public UndoableCommand pop() {
        return commands.pop();
    }

    public int size() {
        return commands.size();
    }

}
