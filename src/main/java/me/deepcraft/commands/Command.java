package me.deepcraft.commands;

import java.util.List;

public abstract class Command {
    String name;
    private List<String> aliases;

    public abstract void execute(String[] args);

    public Command(String name) {
        this.name = name;
    }
}
