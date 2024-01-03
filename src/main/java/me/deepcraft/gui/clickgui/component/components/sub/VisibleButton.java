package me.deepcraft.gui.clickgui.component.components.sub;


import me.deepcraft.gui.clickgui.ClickGui;
import me.deepcraft.gui.clickgui.component.Component;
import me.deepcraft.gui.clickgui.component.components.Button;
import me.deepcraft.module.Module;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;


public class VisibleButton extends Component { // Remove this class if you don't want it (it's kinda useless)

	private boolean hovered;
	private Button parent;
	private int offset;
	private int x;
	private int y;
	private Module mod;
	
	public VisibleButton(Button button, Module mod, int offset) {
		this.parent = button;
		this.mod = mod;
		this.x = button.parent.getX() + button.parent.getWidth();
		this.y = button.parent.getY() + button.offset;
		this.offset = offset;
	}
	
	@Override
	public void setOff(int newOff) {
		offset = newOff;
	}
	
	@Override
	public void renderComponent() {
		Gui.drawRect(parent.parent.getX() + 2, parent.parent.getY() + offset, parent.parent.getX() + (parent.parent.getWidth()), parent.parent.getY() + offset + 12, ClickGui.backgroundDark);
		Gui.drawRect(parent.parent.getX(), parent.parent.getY() + offset, parent.parent.getX() + 2, parent.parent.getY() + offset + 12, 0xFF111111);
		Minecraft.getMinecraft().fontRendererObj.drawStringWithShadow("Visible: " + mod.toggled, (parent.parent.getX() + 7), (parent.parent.getY() + offset + 2) + 1, -1);
	}
	
	@Override
	public void updateComponent(int mouseX, int mouseY) {
		this.hovered = isMouseOnButton(mouseX, mouseY);
		this.y = parent.parent.getY() + offset;
		this.x = parent.parent.getX();
	}
	
	@Override
	public void mouseClicked(int mouseX, int mouseY, int button) {
		if(isMouseOnButton(mouseX, mouseY) && button == 0 && this.parent.open) {
			mod.toggled = (!mod.toggled);
		}
	}
	
	public boolean isMouseOnButton(int x, int y) {
		if(x > this.x && x < this.x + 88 && y > this.y && y < this.y + 12) {
			return true;
		}
		return false;
	}
}
