package me.deepcraft.commands.list;

import me.deepcraft.commands.Command;
import me.deepcraft.utils.ChatUtil;

public class ReloadCrash2Command extends Command {
    public ReloadCrash2Command() {
        super("rlcrash2");
    }

    @Override
    public void execute(String[] args) {
        for (int i = 0; i < 20; i++) {
            ChatUtil.publicMessage("/reload confirm");
        }

    }
}
