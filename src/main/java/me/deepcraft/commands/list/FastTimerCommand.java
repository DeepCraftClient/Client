package me.deepcraft.commands.list;

import me.deepcraft.commands.Command;

public class FastTimerCommand extends Command {
    public FastTimerCommand() {
        super("fasttimer");
    }

    @Override
    public void execute(String[] args) {
        mc.timer.timerSpeed = 3;
    }
}
