package me.deepcraft.commands.list;

import me.deepcraft.commands.Command;
import me.deepcraft.utils.ChatUtil;

public class HelpCommand  extends Command {
    public HelpCommand() {
        super("help");
    }

    @Override
    public void execute(String[] args) {
        ChatUtil.clientMessage("§6help");
        ChatUtil.clientMessage("§eCRASHER:");
        ChatUtil.clientMessage("§a-crashxd (onepacket)");
        ChatUtil.clientMessage("§a-kaboom (kaboom crasher)");
        ChatUtil.clientMessage("§a-wecrash (worldedit crasher)");
        ChatUtil.clientMessage("§a-rlcrash (Reload Crasher)");
        ChatUtil.clientMessage("§eMODULE:");
        ChatUtil.clientMessage("§a-normaltimer (reset timer to 1x)");
        ChatUtil.clientMessage("§a-fasttimer (set your timer to 3x)");
    }
}
