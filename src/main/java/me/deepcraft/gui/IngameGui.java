package me.deepcraft.gui;

import me.deepcraft.DeepCraft;
import me.deepcraft.utils.ColorUtil;
import me.deepcraft.utils.fontutil.FontRenderer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;

import javax.vecmath.AxisAngle4d;
import java.awt.*;

public class IngameGui {
    protected Minecraft mc = Minecraft.getMinecraft();
    public static FontRenderer title = new FontRenderer("Arial", 29, Font.PLAIN, true, true);
    public static FontRenderer text = new FontRenderer("Arial", 18, Font.PLAIN, true, true);
        public void draw() {
            GlStateManager.pushMatrix();
            title.drawStringWithShadow(DeepCraft.name + " " + DeepCraft.version, 2, 2, ColorUtil.rainBowEffect(1750000000L, 0.82F).getRGB());
            text.drawStringWithShadow("§6FPS: §a" + Minecraft.getDebugFPS(), 2, 45, -1);
            text.drawStringWithShadow("§6XYZ: §a" + (Minecraft.getMinecraft()).thePlayer.getPosition().getX() + " " + (Minecraft.getMinecraft()).thePlayer.getPosition().getY() + " " + (Minecraft.getMinecraft()).thePlayer.getPosition().getZ(), 2, 25, -1);
            text.drawStringWithShadow("§6IGN: §a" + (mc.thePlayer.getName()),  2, 35, -1);
            text.drawStringWithShadow("§6ServerIP: §a" + (Minecraft.getMinecraft().getCurrentServerData().serverIP),  2, 55, -1);
            text.drawStringWithShadow("§6Brand: §a" + mc.thePlayer.getClientBrand(), 2, 65, -1);
            text.drawStringWithShadow("§6Ping: §a" + mc.getCurrentServerData().pingToServer, 2, 75, -1);
            text.drawStringWithShadow("§6Protocol: §a" + mc.getCurrentServerData().version, 2, 85, -1);

            GlStateManager.resetColor();
            GlStateManager.popMatrix();
        }
}
