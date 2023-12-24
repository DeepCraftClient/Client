package me.deepcraft.commands.list;

import me.deepcraft.commands.Command;
import me.deepcraft.utils.ChatUtil;

public class ReloadCrashCommand extends Command {
    public ReloadCrashCommand() {
        super("rlcrash");
    }

    @Override
    public void execute(String[] args) {
        for (int i = 0; i < 20; i++) {
            ChatUtil.publicMessage("/reload");
        }

    }
}
