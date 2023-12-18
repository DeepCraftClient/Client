package me.deepcraft.commands.list;

import me.deepcraft.commands.Command;
import me.deepcraft.utils.ChatUtil;

public class EtoPCommand extends Command {
    public EtoPCommand() {
        super("etop");
    }

    @Override
    public void execute(String[] args) {
        ChatUtil.clientMessage("§aTeleport all Entities to you....");
        for (int i = 0; i < 10000; i++) {
            ChatUtil.publicMessage("/tp @e @s");
        }

    }
}
