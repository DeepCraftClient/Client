package me.deepcraft.gui;

import me.deepcraft.DeepCraft;
import me.deepcraft.utils.ColorUtil;
import me.deepcraft.utils.fontutil.FontRenderer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;

import java.awt.*;

public class IngameGui {
    public static FontRenderer title = new FontRenderer("Arial", 29, Font.PLAIN, true, true);
    public static FontRenderer text = new FontRenderer("Arial", 21, Font.PLAIN, true, true);
        public void draw() {
            GlStateManager.pushMatrix();
            title.drawStringWithShadow(DeepCraft.name + " " + DeepCraft.version, 2, 2, ColorUtil.rainBowEffect(1750000000L, 0.82F).getRGB());
            text.drawStringWithShadow("§6FPS -> §a" + Minecraft.getDebugFPS(), 2, 22, -1);
            GlStateManager.resetColor();
            GlStateManager.popMatrix();
        }
}
