package me.deepcraft.commands.list;

import me.deepcraft.commands.Command;
import me.deepcraft.utils.ChatUtil;

public class FpsBoostCommand extends Command {
    public FpsBoostCommand() {
        super("fpsboost");
    }
    public static boolean fpsboost;
    @Override
    public void execute(String[] args) {
        if(fpsboost) {
            fpsboost = false;
            ChatUtil.clientMessage("§aFps Boost disabled!");
        } else {
            fpsboost = true;
            ChatUtil.clientMessage("§aFps Boost enabled!");
        }
    }

}
