package me.deepcraft.commands.list;

import me.deepcraft.commands.Command;
import me.deepcraft.utils.ChatUtil;

public class CustomBanlisteCommand extends Command {
    public CustomBanlisteCommand() {
        super("banliste");
    }

    @Override
    public void execute(String[] args) {
        ChatUtil.clientMessage("§aBanning all Players from list for §4§lHAUSVERBOT");
        ChatUtil.publicMessage("/ban mori0 HAUSVERBOT");
        ChatUtil.publicMessage("/ban Riesenrad HAUSVERBOT");
        ChatUtil.publicMessage("/ban ReyDev HAUSVERBOT");
        ChatUtil.publicMessage("/ban MHF_Barrier HAUSVERBOT");
        ChatUtil.publicMessage("/ban Player161 HAUSVERBOT");
        ChatUtil.publicMessage("/ban zDomenik HAUSVERBOT");
        ChatUtil.publicMessage("/ban Deadsec_Real HAUSVERBOT");
        ChatUtil.publicMessage("/ban ryzetech HAUSVERBOT");
        ChatUtil.publicMessage("/ban Hauber HAUSVERBOT");
        ChatUtil.publicMessage("/ban Adrian__yt HAUSVERBOT");
        ChatUtil.publicMessage("/ban Germanien HAUSVERBOT");
        ChatUtil.publicMessage("/ban GrafVillainous HAUSVERBOT");
        ChatUtil.publicMessage("/ban EUGaming HAUSVERBOT");
        ChatUtil.publicMessage("/ban SirLennox HAUSVERBOT");
        ChatUtil.publicMessage("/ban BobbycarDealer HAUSVERBOT");
        ChatUtil.clientMessage("§aSucessfully!");
    }
}
