package me.deepcraft.commands.list;

import me.deepcraft.commands.Command;
import me.deepcraft.utils.ChatUtil;

public class CreditsCommand extends Command {
    public CreditsCommand() {
        super("credits");
    }

    @Override
    public void execute(String[] args) {
        ChatUtil.clientMessage("          §7§m--§7§m--§2§m--§a( §e§lCredits §7)§2§m--§a§m--§7§m--§7§m--");
        ChatUtil.clientMessage("§aCoder: PublicCode     | §chttps://youtube.com/@PublicCodes");
        ChatUtil.clientMessage("§aCoder: GameDev        | §cHe dont make youtube i guess");
        ChatUtil.clientMessage("          §7§m--§7§m--§2§m--§a( §e§lCredits §7)§2§m--§a§m--§7§m--§7§m--");
    }
}
