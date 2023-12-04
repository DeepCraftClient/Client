package me.deepcraft.commands.list;

import me.deepcraft.commands.Command;

public class NormalTimerCommand extends Command {
    public NormalTimerCommand() {
        super("normaltimer");
    }

    @Override
    public void execute(String[] args) {
        mc.timer.timerSpeed = 1;
    }
}
