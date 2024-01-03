package me.deepcraft.commands.list;

import me.deepcraft.commands.Command;
import me.deepcraft.utils.ChatUtil;

public class YTLiveWerbungCommand extends Command {
    public YTLiveWerbungCommand() {
        super("ad");
    }

    @Override
    public void execute(String[] args) {

        ChatUtil.publicMessage("psst skyguys geheimer server unter durchlasten(punkt)world");
    }
}
