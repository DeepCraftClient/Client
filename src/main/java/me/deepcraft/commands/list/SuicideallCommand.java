package me.deepcraft.commands.list;

import me.deepcraft.commands.Command;
import me.deepcraft.utils.ChatUtil;

public class SuicideallCommand extends Command {
    public SuicideallCommand() {
        super("killallplayers");
    }

    @Override
    public void execute(String[] args) {
        ChatUtil.clientMessage("§akill all players...");
        ChatUtil.publicMessage("/sudo * suicide");

    }
}
