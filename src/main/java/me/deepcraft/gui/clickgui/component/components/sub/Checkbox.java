package me.deepcraft.gui.clickgui.component.components.sub;

import me.deepcraft.gui.clickgui.ClickGui;
import me.deepcraft.gui.clickgui.component.Component;
import me.deepcraft.gui.clickgui.component.components.Button;
import me.deepcraft.module.settings.Setting;
import net.minecraft.client.gui.Gui;


public class Checkbox extends Component {

	private boolean hovered;
	private Setting op;
	private Button parent;
	private int offset;
	private int x;
	private int y;
	
	public Checkbox(Setting option, Button button, int offset) {
		this.op = option;
		this.parent = button;
		this.x = button.parent.getX() + button.parent.getWidth();
		this.y = button.parent.getY() + button.offset;
		this.offset = offset;
	}

	@Override
	public void renderComponent() {
		Gui.drawRect(parent.parent.getX(), parent.parent.getY() + offset, parent.parent.getX() + (parent.parent.getWidth() * 1), parent.parent.getY() + offset + 12, ClickGui.backgroundDark);
		ClickGui.text.drawStringWithShadow(this.op.getName(), (parent.parent.getX() + 2) + 5, (parent.parent.getY() + offset + 1), -1);

		Gui.drawRect(parent.parent.getX() + 83 + 4, parent.parent.getY() + offset + 3, parent.parent.getX() + 89 + 4, parent.parent.getY() + offset + 9, ClickGui.background);
		if (this.op.getValBoolean())
			Gui.drawRect(parent.parent.getX() + 83 + 5, parent.parent.getY() + offset + 4, parent.parent.getX() + 89 + 3, parent.parent.getY() + offset + 8, ClickGui.color);
		}
	
	@Override
	public void setOff(int newOff) {
		offset = newOff;
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
			this.op.setValBoolean(!op.getValBoolean());;
		}
	}
	
	public boolean isMouseOnButton(int x, int y) {
		if(x > this.x && x < this.x + 88 && y > this.y && y < this.y + 12) {
			return true;
		}
		return false;
	}
}
