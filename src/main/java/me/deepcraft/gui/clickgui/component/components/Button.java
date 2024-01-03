package me.deepcraft.gui.clickgui.component.components;

import me.deepcraft.DeepCraft;
import me.deepcraft.gui.clickgui.ClickGui;
import me.deepcraft.gui.clickgui.component.Component;
import me.deepcraft.gui.clickgui.component.Frame;
import me.deepcraft.gui.clickgui.component.components.sub.Checkbox;
import me.deepcraft.gui.clickgui.component.components.sub.Keybind;
import me.deepcraft.gui.clickgui.component.components.sub.ModeButton;
import me.deepcraft.gui.clickgui.component.components.sub.Slider;
import me.deepcraft.module.Module;
import me.deepcraft.module.settings.Setting;
import me.deepcraft.utils.fontutil.FontRenderer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;

import java.awt.*;
import java.util.ArrayList;


public class Button extends Component {

	public Module mod;
	public Frame parent;
	public int offset;
	private boolean isHovered;
	private ArrayList<Component> subcomponents;
	public boolean open;
	private int height;
	
	public Button(Module mod, Frame parent, int offset) {
		this.mod = mod;
		this.parent = parent;
		this.offset = offset;
		this.subcomponents = new ArrayList<Component>();
		this.open = false;
		height = 12;
		int opY = offset + 12;
		if(DeepCraft.settingsManager.getSettingsByMod(mod) != null) {
			for(Setting s : DeepCraft.settingsManager.getSettingsByMod(mod)){
				if(s.isCombo()){
					this.subcomponents.add(new ModeButton(s, this, mod, opY));
					opY += 12;
				}
				if(s.isSlider()){
					this.subcomponents.add(new Slider(s, this, opY));
					opY += 12;
				}
				if(s.isCheck()){
					this.subcomponents.add(new Checkbox(s, this, opY));
					opY += 12;
				}
			}
		}
		this.subcomponents.add(new Keybind(this, opY));
		//this.subcomponents.add(new VisibleButton(this, mod, opY));
	}
	
	@Override
	public void setOff(int newOff) {
		offset = newOff;
		int opY = offset + 12;
		for(Component comp : this.subcomponents) {
			comp.setOff(opY);
			opY += 12;
		}
	}
	@Override
	public void renderComponent() {
		Gui.drawRect(parent.getX() - 1, this.parent.getY() + this.offset, parent.getX() + parent.getWidth() + 1, this.parent.getY() + 13 + this.offset,this.mod.isToggled() ? ClickGui.state : ClickGui.backgroundDark);
		Gui.drawRect(parent.getX(), this.parent.getY() + this.offset, parent.getX() + parent.getWidth(), this.parent.getY() + 12 + this.offset,this.mod.isToggled() ? ClickGui.state : ClickGui.background);
		ClickGui.text.drawStringWithShadow(this.mod.getName(), (parent.getX() + 2), (parent.getY() + offset + 3),  -1);
		if(this.subcomponents.size() > 1)
			ClickGui.text.drawStringWithShadow(this.open ? "-" : "+", (parent.getX() + parent.getWidth() - 10), (parent.getY() + offset + 2), -1);
		if(this.open) {
			if(!this.subcomponents.isEmpty()) {
				Gui.drawRect(parent.getX() - 1, parent.getY() + this.offset + 12, parent.getX() + parent.getWidth() + 1, parent.getY() + this.offset + ((this.subcomponents.size() + 1) * 12) + 1, ClickGui.backgroundDark);

				for(Component comp : this.subcomponents) {
					comp.renderComponent();
				}
			}
		}
	}
	
	@Override
	public int getHeight() {
		if(this.open) {
			return (12 * (this.subcomponents.size() + 1));
		}
		return 12;
	}
	
	@Override
	public void updateComponent(int mouseX, int mouseY) {
		this.isHovered = isMouseOnButton(mouseX, mouseY);
		if(!this.subcomponents.isEmpty()) {
			for(Component comp : this.subcomponents) {
				comp.updateComponent(mouseX, mouseY);
			}
		}
	}
	
	@Override
	public void mouseClicked(int mouseX, int mouseY, int button) {
		if(isMouseOnButton(mouseX, mouseY) && button == 0) {
			this.mod.toggle();
		}
		if(isMouseOnButton(mouseX, mouseY) && button == 1) {
			this.open = !this.open;
			this.parent.refresh();
		}
		for(Component comp : this.subcomponents) {
			comp.mouseClicked(mouseX, mouseY, button);
		}
	}
	
	@Override
	public void mouseReleased(int mouseX, int mouseY, int mouseButton) {
		for(Component comp : this.subcomponents) {
			comp.mouseReleased(mouseX, mouseY, mouseButton);
		}
	}
	
	@Override
	public void keyTyped(char typedChar, int key) {
		for(Component comp : this.subcomponents) {
			comp.keyTyped(typedChar, key);
		}
	}
	
	public boolean isMouseOnButton(int x, int y) {
		if(x > parent.getX() && x < parent.getX() + parent.getWidth() && y > this.parent.getY() + this.offset && y < this.parent.getY() + 12 + this.offset) {
			return true;
		}
		return false;
	}
}
