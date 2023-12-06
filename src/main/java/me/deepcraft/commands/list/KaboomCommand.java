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
        ChatUtil.clientMessage("§aSpamming...");
        for (int i = 0; i < 2000000; ++i) {
            ChatUtil.publicMessage("/sudo * /sphere 0 75");


        }
    }
}
