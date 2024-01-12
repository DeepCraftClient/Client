package me.deepcraft.gui.clickgui.component;

import me.deepcraft.DeepCraft;
import me.deepcraft.gui.clickgui.ClickGui;
import me.deepcraft.gui.clickgui.component.components.Button;
import me.deepcraft.module.Category;
import me.deepcraft.module.Module;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;

import java.util.ArrayList;

public class Frame {

	public ArrayList<Component> components;
	public Category category;
	private boolean open;
	private int width;
	private int y;
	private int x;
	private int barHeight;
	private boolean isDragging;
	public int dragX;
	public int dragY;
	
	public Frame(Category cat) {
		this.components = new ArrayList<>();
		this.category = cat;
		this.width = 100;
		this.x = 15;
		this.y = 25;
		this.barHeight = 13;
		this.dragX = 0;
		this.open = false;
		this.isDragging = false;
		int tY = this.barHeight;
		
		/**
		 * 		public ArrayList<Module> getModulesInCategory(Category categoryIn){
		 * 			ArrayList<Module> mods = new ArrayList<Module>();
		 * 			for(Module m : this.modules){
		 * 				if(m.getCategory() == categoryIn)
		 * 					mods.add(m);
		 * 			}
		 * 			return mods;
		 * 		}
		 */
		
		for(Module mod : DeepCraft.moduleManager.getModulesInCategory(category)) {
			Button modButton = new Button(mod, this, tY);
			this.components.add(modButton);
			tY += 12;
		}
	}
	
	public ArrayList<Component> getComponents() {
		return components;
	}
	
	public void setX(int newX) {
		this.x = newX;
	}
	
	public void setY(int newY) {
		this.y = newY;
	}
	
	public void setDrag(boolean drag) {
		this.isDragging = drag;
	}
	
	public boolean isOpen() {
		return open;
	}
	
	public void setOpen(boolean open) {
		this.open = open;
	}
	public void renderFrame(FontRenderer fontRenderer) {
		Gui.drawRect(this.x - 1, this.y - 1, this.x + this.width + 1, this.y + this.barHeight + 1, ClickGui.backgroundDark);
		ClickGui.text.drawString(this.category.name(), (this.x + 2) + 2, (this.y + 3.5f), 0xFFFFFFFF);
		if(this.open) {
			if(!this.components.isEmpty()) {
				//Gui.drawRect(this.x, this.y + this.barHeight, this.x + 1, this.y + this.barHeight + (12 * components.size()), new Color(4, 220, 25, 150).getRGB());
				//Gui.drawRect(this.x, this.y + this.barHeight + (12 * components.size()), this.x + this.width, this.y + this.barHeight + (12 * components.size()) + 1, new Color(4, 220, 25, 150).getRGB());
				//Gui.drawRect(this.x + this.width, this.y + this.barHeight, this.x + this.width - 1, this.y + this.barHeight + (12 * components.size()), new Color(4, 220, 25, 150).getRGB());
				for(Component component : components) {
					component.renderComponent();
				}
			}
		}
	}
	
	public void refresh() {
		int off = this.barHeight;
		for(Component comp : components) {
			comp.setOff(off);
			off += comp.getHeight();
		}
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public int getWidth() {
		return width;
	}
	
	public void updatePosition(int mouseX, int mouseY) {
		if(this.isDragging) {
			this.setX(mouseX - dragX);
			this.setY(mouseY - dragY);
		}
	}
	
	public boolean isWithinHeader(int x, int y) {
		if(x >= this.x && x <= this.x + this.width && y >= this.y && y <= this.y + this.barHeight) {
			return true;
		}
		return false;
	}
	
}