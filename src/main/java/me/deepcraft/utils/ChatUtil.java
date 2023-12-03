package me.deepcraft.utils;

import me.deepcraft.DeepCraft;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ChatComponentText;

public class ChatUtil {
    public static void clientMessage(String content) {
        Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(DeepCraft.prefix + content));
    }
}