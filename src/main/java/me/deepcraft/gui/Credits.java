package me.deepcraft.gui;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.ResourceLocation;

import java.io.IOException;

public class Credits extends GuiScreen {

    private enum Components {
        BUTTON_BACK;
    }



    private GuiScreen parentScreen;

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        mc.getTextureManager().bindTexture(new ResourceLocation("deepcraft/co.png"));
        drawCenteredString(this.fontRendererObj, "§5§lDeep§d§lCraft", this.width / 2, 17, 10526880);
        drawCenteredString(this.fontRendererObj, "§6§lCredits", this.width / 2, 67, 10526880);
        drawCenteredString(this.fontRendererObj, "Coder: PublicCode", this.width / 2, 97, 255*65536+255*256+255);
        drawCenteredString(this.fontRendererObj, "Coder: GameDevv", this.width / 2, 107, 255*65536+255*256+255);
    }





    protected void actionPerformed (GuiButton button) throws IOException {
        if (button.id == ClientOptions.Components.BUTTON_BACK.ordinal()) {
            this.mc.displayGuiScreen(this.parentScreen);
            return;
        }

        }
    public void initGui () {
        this.buttonList.add(new GuiButton(ClientOptions.Components.BUTTON_BACK.ordinal(), this.width / 2 - 100, this.height / 2 - 55, "Back"));
    }
}
