package me.deepcraft.gui;

import net.minecraft.client.gui.*;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;

import java.awt.*;
import java.io.IOException;

public class MainMenu extends GuiScreen {

    @Override
    public void initGui() {
        this.buttonList.add(new GuiButton(0, this.width / 2 - 100, this.height / 2 - 55, "OFFLINE"));
        this.buttonList.add(new GuiButton(1, this.width / 2 - 100, this.height / 2 - 28, "ONLINE"));
        this.buttonList.add(new GuiButton(2, this.width / 2 - 100, this.height / 2 - 1, "SETTINGS"));
        this.buttonList.add(new GuiButton(3, this.width / 2 - 100, this.height / 2 + 28, "RAGE QUIT"));


        super.initGui();
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        mc.getTextureManager().bindTexture(new ResourceLocation("deepcraft/background.png"));
        drawModalRectWithCustomSizedTexture(0, 0, 0, 0, this.width, this.height, this.width, this.height);
        Gui.drawRect(this.width / 2 + 135, this.height / 2 - 80, this.width / 2 - 135, this.height / 2 + 70, new Color(0, 0, 0, 120).getRGB());
        GlStateManager.pushMatrix();
        GlStateManager.translate(-(width / 1.990f), -(height / 2f), 0);
        GlStateManager.scale(2, 2, 2);
        GlStateManager.popMatrix();
        super.drawScreen(mouseX, mouseY, partialTicks);
    }

    @Override
    protected void actionPerformed(GuiButton button) throws IOException {
        if (button.id == 0) {
            mc.displayGuiScreen(new GuiSelectWorld(this));
        }
        if (button.id == 1) {
            mc.displayGuiScreen(new GuiMultiplayer(this));
        }
        if (button.id == 2) {
            mc.displayGuiScreen(new GuiOptions(this, mc.gameSettings));
        }
        if (button.id == 3) {
            mc.shutdown();
        }

        super.actionPerformed(button);
    }
}
