package me.deepcraft.gui;

import me.deepcraft.utils.ColorUtil;
import me.deepcraft.utils.fontutil.FontRenderer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;

import java.awt.*;

public class IngameGui {
    public static FontRenderer title = new FontRenderer("Arial", 27, Font.PLAIN, true, true);
    public static FontRenderer text = new FontRenderer("Arial", 21, Font.PLAIN, true, true);
        public void draw() {
            GlStateManager.pushMatrix();
            title.drawStringWithShadow("Deep", 2, 2, ColorUtil.rainBowEffect(1750000000L, 0.82F).getRGB());
            title.drawStringWithShadow("Craft Client", 37, 2, Color.GRAY.getRGB());
            text.drawStringWithShadow("§7[§1Fps§7]: §6" + Minecraft.getDebugFPS(), 2, 22, -1);
            text.drawStringWithShadow("§7[§1Timer§7]: §6" + Minecraft.getMinecraft().timer.timerSpeed, 2, 36, -1);
            GlStateManager.resetColor();
            GlStateManager.popMatrix();
        }
}
