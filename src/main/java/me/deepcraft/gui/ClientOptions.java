package me.deepcraft.gui;

import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;

import java.awt.*;
import java.io.IOException;
import java.net.URI;

public class ClientOptions extends GuiScreen {

    private final GuiScreen parentScreen;

    public ClientOptions(GuiScreen paGuiScreen) {
        this.parentScreen = paGuiScreen;
    }
    private static void openWebsite(String url) {
        try {
            Desktop.getDesktop().browse(new URI(url));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        mc.getTextureManager().bindTexture(new ResourceLocation("deepcraft/co.png"));
        drawModalRectWithCustomSizedTexture(0, 0, 0, 0, this.width, this.height, this.width, this.height);
        Gui.drawRect(this.width / 2 + 135, this.height / 2 - 80, this.width / 2 - 135, this.height / 2 + 70, new Color(0, 0, 0, 120).getRGB());
        GlStateManager.pushMatrix();
        GlStateManager.translate(-(width / 1.990f), -(height / 2f), 0);
        GlStateManager.scale(6, 6, 6);
        GlStateManager.popMatrix();
        super.drawScreen(mouseX, mouseY, partialTicks);
    }

            private enum Components {
                BUTTON_BACK, BUTTON_CREDITS, BUTTON_YOUTUBE, BUTTON_UPDATER;
            }

            protected void actionPerformed (GuiButton button) throws IOException {
                if (button.id == Components.BUTTON_BACK.ordinal()) {
                    this.mc.displayGuiScreen(this.parentScreen);
                    return;
                }
                //if ...
                if (button.id == Components.BUTTON_CREDITS.ordinal()) {
                    openWebsite("https://durchlasten.world/deepcraft/credits.txt");
                    return;
                }
                if (button.id == Components.BUTTON_YOUTUBE.ordinal()) {
                    openWebsite("https://www.youtube.com/channel/UCXdjr9BM6H2h0J5_9LBPhSg");
                    return;
                }
                if (button.id == Components.BUTTON_UPDATER.ordinal()) {
                    openWebsite("https://durchlasten.world/deepcraft/updater.exe");
                    return;
                }
            }

            public void initGui () {
                this.buttonList.add(new GuiButton(Components.BUTTON_BACK.ordinal(), this.width / 2 - 100, this.height / 2 - 55, "Zurück"));
                this.buttonList.add(new GuiButton(Components.BUTTON_CREDITS.ordinal(), this.width / 2 - 100, this.height / 2 - 28, "Credits"));
                this.buttonList.add(new GuiButton(Components.BUTTON_YOUTUBE.ordinal(), this.width / 2 - 100, this.height / 2 - 1, "YouTube"));
                this.buttonList.add(new GuiButton(Components.BUTTON_UPDATER.ordinal(), this.width / 2 - 100, this.height / 2 + 28, "Updater"));


    }

}
