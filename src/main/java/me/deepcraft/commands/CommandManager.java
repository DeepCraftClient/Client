package me.deepcraft.commands;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CommandManager {
    private final List<Command> commands = new ArrayList<Command>();

    public CommandManager() {
    }

    public boolean execute(String text) {
        if (!text.startsWith(".")) {
            return false;
        }
        text = text.substring(1);
        String[] arguments = text.split(" ");
        for (Command cmd : this.commands) {
            if (cmd.name.equals(arguments[0])) {
                String[] args = Arrays.copyOfRange(arguments, 1, arguments.length);
                cmd.execute(args);
                return true;
            }
        }
        return false;
    }

    public void addCmd(Command command) {
        commands.add(command);
    }

    public List<Command> getCommands() {
        return commands;
    }
}
