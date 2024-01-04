package me.deepcraft.gui;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Session;

import java.io.IOException;

public class NameChanger extends GuiScreen {
    GuiTextField name;

    private GuiScreen parentScreen;

    public NameChanger(GuiScreen parentScreen) {
        this.parentScreen = parentScreen;
    }

    private enum Components {
        NAME_ENUM, BUTTON_BACK, BUTTON_CONFIRM;
    }

    public void GuiNameLogin(GuiScreen parentScreenIn) {
        this.parentScreen = parentScreenIn;
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        mc.getTextureManager().bindTexture(new ResourceLocation("deepcraft/calts.png"));
        drawDefaultBackground();
        this.name.drawTextBox();
        drawCenteredString(this.fontRendererObj, "§6§lHier kannst du dein Namen ändern", this.width / 2, 17, 10526880);
        super.drawScreen(mouseX, mouseY, partialTicks);
    }
    protected void keyTyped(char typedChar, int keyCode) throws IOException {
        if (this.name.isFocused())
            this.name.textboxKeyTyped(typedChar, keyCode);
        if (keyCode == 1)
            actionPerformed(getByID(Components.BUTTON_BACK.ordinal()));
        if (keyCode == 28)
            actionPerformed(getByID(Components.BUTTON_CONFIRM.ordinal()));
    }

    private GuiButton getByID(int id) {
        return this.buttonList.stream().filter(b -> (b.id == id)).findFirst().orElse(null);
    }

    protected void actionPerformed(GuiButton button) throws IOException {
        if (button.id == Components.BUTTON_BACK.ordinal()) {
            this.mc.displayGuiScreen(this.parentScreen);
            return;
        }
        this.mc.session = new Session(this.name.getText(), this.mc.session.getPlayerID(),
                this.mc.session.getToken(), this.mc.session.getSessionType().toString());
        this.mc.displayGuiScreen(this.parentScreen);
    }

    public void initGui() {
        int width = 200, height = 20, margin = 25;
        int x = this.width / 2 - width / 2;
        int y = this.height / 4;
        this.name = new GuiTextField(Components.NAME_ENUM.ordinal(), this.fontRendererObj, x, y, width, height);
        this.name.setText(this.mc.session.getUsername());
        this.name.setFocused(true);
        this.buttonList.add(new GuiButton(Components.BUTTON_CONFIRM.ordinal(), x, y + margin, "Change name"));
        this.buttonList.add(new GuiButton(Components.BUTTON_BACK.ordinal(), x, y + margin * 2, "Zurück"));

    }
}

