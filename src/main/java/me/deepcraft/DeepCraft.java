package me.deepcraft;


import me.deepcraft.commands.CommandManager;
import me.deepcraft.gui.IngameGui;
import me.deepcraft.module.ModuleManager;

public class DeepCraft {
    public static String PrevIp;
    public static int PrevPort;
    public static String name = "DeepCraft";
    public static String version = "b5";
    public static String prefix = "§5§lDeep§d§lCraft§7» §r";
    public static ModuleManager moduleManager = new ModuleManager();
    public static CommandManager commandManager = new CommandManager();
    public static IngameGui ingameGui = new IngameGui();
    public static void start() {

    }

    public static void stop() {

    }
}
