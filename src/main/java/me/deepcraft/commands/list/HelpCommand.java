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
        ChatUtil.clientMessage("§a-wecrash (worldedit crasher)");
        ChatUtil.clientMessage("§a-rlcrash (Reload Crasher)");
        ChatUtil.clientMessage("§a-thfuck (destroying the thread bring maybe your §amc to lag)");
        ChatUtil.clientMessage("§eMODULE:");
        ChatUtil.clientMessage("§a-fpsboost (boost your FPS)");
        ChatUtil.clientMessage("§a-reg (register on Cracked server)");
        ChatUtil.clientMessage("§a-log (login on Cracked server)");
        ChatUtil.clientMessage("§eFUN:");
        ChatUtil.clientMessage("§a-killallplayers (bring all player to suicide XD");
        ChatUtil.clientMessage("§a-livead (Advertise for YT LIVE (2th channel))");
        ChatUtil.clientMessage("§eOTHER:");
        ChatUtil.clientMessage("§a-changelog");
    }
}
