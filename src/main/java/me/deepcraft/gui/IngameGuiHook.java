package me.deepcraft.gui;

import me.deepcraft.utils.Wrapper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiIngame;

public class IngameGuiHook extends GuiIngame {

    public IngameGuiHook(Minecraft mcIn) {
        super(mcIn);
    }

    public void renderGameOverlay(float p_175180_1_){
        super.renderGameOverlay(p_175180_1_);

        drawRect(2, 2, 15, 14, 0x80000000);
        Wrapper.fr.drawString("DeepCraft", 4, 4, 660066);
        Wrapper.fr.drawString("FPS: " + Minecraft.getDebugFPS(), 50, 4, -1);

    }

}
