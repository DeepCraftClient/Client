package me.deepcraft.commands;

import me.deepcraft.utils.TimerUtil;

import java.util.List;

public abstract class Command {
    String name;
    private List<String> aliases;
    public static TimerUtil timerUtil = new TimerUtil();

    public abstract void execute(String[] args);

    public Command(String name) {
        this.name = name;
    }
}
