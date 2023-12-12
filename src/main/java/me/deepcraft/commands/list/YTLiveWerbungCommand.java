package me.deepcraft.commands.list;

import me.deepcraft.commands.Command;
import me.deepcraft.utils.ChatUtil;

public class YTLiveWerbungCommand extends Command {
    public YTLiveWerbungCommand() {
        super("livead");
    }

    @Override
    public void execute(String[] args) {
        ChatUtil.publicMessage("Ich bin Live auf YouTube @UltimateGriefer");
    }
}
