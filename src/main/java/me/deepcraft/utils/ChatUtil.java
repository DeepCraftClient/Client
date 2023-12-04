package me.deepcraft.utils;

import me.deepcraft.DeepCraft;
import net.minecraft.client.Minecraft;
import net.minecraft.network.play.client.C01PacketChatMessage;
import net.minecraft.util.ChatComponentText;

public class ChatUtil {
    public static void clientMessage(String content) {
        Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(DeepCraft.prefix + content));
    }
    public static void publicMessage(String content) {
        Minecraft.getMinecraft().getNetHandler().addToSendQueue(new C01PacketChatMessage(content));
    }
}