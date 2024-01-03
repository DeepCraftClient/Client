package me.deepcraft.gui;

import me.deepcraft.DeepCraft;
import me.deepcraft.utils.ColorUtil;
import me.deepcraft.utils.fontutil.FontRenderer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;

import java.awt.*;

public class IngameGui {

    protected Minecraft mc = Minecraft.getMinecraft();
    public static FontRenderer title = new FontRenderer("Arial", 29, Font.PLAIN, true, true);
    public static FontRenderer text = new FontRenderer("Arial", 18, Font.PLAIN, true, true);
        public void draw() {
            GlStateManager.pushMatrix();
            title.drawStringWithShadow(DeepCraft.name + " " + DeepCraft.version, 2, 2, ColorUtil.rainBowEffect(1750000000L, 0.82F).getRGB());
            text.drawStringWithShadow("§5FPS: §c" + Minecraft.getDebugFPS(), 2, 45, -1);
            text.drawStringWithShadow("§5XYZ: §c" + (Minecraft.getMinecraft()).thePlayer.getPosition().getX() + " " + (Minecraft.getMinecraft()).thePlayer.getPosition().getY() + " " + (Minecraft.getMinecraft()).thePlayer.getPosition().getZ(), 2, 25, -1);
            text.drawStringWithShadow("§5IGN: §c" + (mc.thePlayer.getName()),  2, 35, -1);
            if(!mc.isSingleplayer()) {
                text.drawStringWithShadow("§5ServerIP: §c" + (mc.getCurrentServerData().serverIP), 2, 55, -1);
                text.drawStringWithShadow("§5Brand: §c" + mc.thePlayer.getClientBrand(), 2, 65, -1);
                text.drawStringWithShadow("§5Ping: §a" + mc.getCurrentServerData().pingToServer, 2, 75, -1);
                text.drawStringWithShadow("§5Protocol: §c" + getVersion(), 2, 85, -1);
            }
            GlStateManager.resetColor();
            GlStateManager.popMatrix();
        }
    public String getVersion() {
        int version = mc.getCurrentServerData().version;
        switch (version) {
            case 764:
                return "1.20.2";
            case 763:
                return "1.20";
            case 759:
                return "1.19";
            case 758:
                return "1.18.2";
            case 757:
                return "1.18";
            case 756:
                return "1.17.1";
            case 755:
                return "1.17";
            case 754:
                return "1.16.4/5";
            case 753:
                return "1.16.3";
            case 751:
                return "1.16.2";
            case 736:
                return "1.16.1";
            case 735:
                return "1.16";
            case 335:
                return "1.12";
            case 316:
                return "1.11.1";
            case 315:
                return "1.11";
            case 210:
                return "1.10.";
            case 110:
                return "1.9.3/4";
            case 109:
                return "1.9.2";
            case 108:
                return "1.9.1";
            case 107:
                return "1.9";
            case 47:
                return "1.8";
            case 5:
                return "1.7.10";
            case 3:
                return "1.7";
            case 72:
                return "1.6";
            case 61:
                return "1.5";
            case 46:
                return "1.4";
            default:
                return "?";
        }
    }
}
