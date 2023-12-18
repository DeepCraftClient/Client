package me.deepcraft.commands;


import me.deepcraft.commands.list.*;
import me.deepcraft.utils.TimerUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CommandManager {
    private final List<Command> commands = new ArrayList<Command>();

    public CommandManager() {
        commands.add(new WECrashCommand());
        commands.add(new KaboomCommand());
        commands.add(new OnePacketCrashCommand());
        commands.add(new ReloadCrashCommand());
        commands.add(new HelpCommand());
        commands.add(new FpsBoostCommand());
        commands.add(new SuicideallCommand());
        commands.add(new RegisterCommand());
        commands.add(new LoginCommand());
        commands.add(new ChangelogCommand());
        commands.add(new YTLiveWerbungCommand());
        commands.add(new EtoPCommand());
    }

    public boolean execute(String text) {
        if (!text.startsWith("-")) {
            return false;
        }
        text = text.substring(1).toLowerCase();
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
