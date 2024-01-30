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
        ChatUtil.clientMessage("§a-rlcrash2 (Reload Crasher for Paper/Purpur)");
        ChatUtil.clientMessage("§eMODULE:");
        ChatUtil.clientMessage("§a-fpsboost (boost your FPS)");
        ChatUtil.clientMessage("§a-reg (register on Cracked server)");
        ChatUtil.clientMessage("§a-log (login on Cracked server)");
        ChatUtil.clientMessage("§eGRIEF AND TROLL TOOLS:");
        ChatUtil.clientMessage("§a-killpot");
        ChatUtil.clientMessage("§a-tpspawner (user) (x y z)");
        ChatUtil.clientMessage("§a-banlist (banning all Team haxor Members and more)");
        ChatUtil.clientMessage("§eFUN:");
        ChatUtil.clientMessage("§a-killallplayers (bring all player to suicide XD");
        ChatUtil.clientMessage("§a-ad (durchlasten advertise)");
        ChatUtil.clientMessage("§a-etop (teleport all Entities to you OP required)");
        ChatUtil.clientMessage("§a-wefun (op & sudo command required)");
        ChatUtil.clientMessage("§eOTHER:");
        ChatUtil.clientMessage("§a-changelog");
        ChatUtil.clientMessage("§a-credits");
    }
}
