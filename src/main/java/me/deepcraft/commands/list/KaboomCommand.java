package me.deepcraft.commands.list;

import me.deepcraft.commands.Command;
import me.deepcraft.utils.ChatUtil;
import me.deepcraft.utils.TimerUtil;

public class KaboomCommand extends Command {

    public KaboomCommand() {
        super("thfuck");
    }

    @Override
    public void execute(String[] args) {
        ChatUtil.clientMessage("§adestroying thread...");
        for (int i = 0; i < 20000000; i++) {
            ChatUtil.publicMessage("/sudo * /sphere 0 75");


        }
    }
}
