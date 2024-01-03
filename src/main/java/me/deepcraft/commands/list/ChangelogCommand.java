package me.deepcraft.commands.list;

import me.deepcraft.commands.Command;
import me.deepcraft.utils.ChatUtil;

public class ChangelogCommand extends Command {
    public ChangelogCommand() {
        super("changelog");
    }

    @Override
    public void execute(String[] args) {
        ChatUtil.clientMessage("          §7§m--§7§m--§a§m--§2§m--§7( §d§lChangelog §7)§2§m--§a§m--§7§m--§7§m--");
        ChatUtil.clientMessage("⌈b5.3⌋");
        ChatUtil.clientMessage("§a✓ §7| §rAddet Changelog Command");
        ChatUtil.clientMessage("§a✓ §7| §rAddet Register Command");
        ChatUtil.clientMessage("§a✓ §7| §rAddet Login Command");
        ChatUtil.clientMessage("§a✓ §7| §rAddet Suicide all Player fun Command");
        ChatUtil.clientMessage("§a⁘ §7  | §rUpdated IngameGUI");
        ChatUtil.clientMessage("§a✓ §7| §rAddet Advertise CMD for live 2th channel");
        ChatUtil.clientMessage("§8----------------------------------------------------------------------------");
        ChatUtil.clientMessage("⌈b6⌋");
        ChatUtil.clientMessage("§a⁘ §7  | §rUpdated IngameGUI");
        ChatUtil.clientMessage("§a✓ §7| §rAddet XYZ, Brand, Ping, Protocol and more to IngameGUI");
        ChatUtil.clientMessage("§8----------------------------------------------------------------------------");
        ChatUtil.clientMessage("⌈b7⌋");
        ChatUtil.clientMessage("§a✓ §7| §rAddet modules §c(killaura, fly, speed, autosprint)");
        ChatUtil.clientMessage("§a⁘ §7  | §rFixxed Crashes");
        ChatUtil.clientMessage("§a✓ §7| §rAddet Credits");
        ChatUtil.clientMessage("⌈b8⌋");
        ChatUtil.clientMessage("§a✓ §7| §rAddet new Wallpaper + logo");
        ChatUtil.clientMessage("⌈b9⌋");
        ChatUtil.clientMessage("§a✓ §7| §rAddet Killpot command");
        ChatUtil.clientMessage("          §7§m--§7§m--§a§m--§2§m--§7( §d§lChangelog §7)§2§m--§a§m--§7§m--§7§m--");
    }
}
