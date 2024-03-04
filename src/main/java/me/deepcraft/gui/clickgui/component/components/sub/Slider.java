package me.deepcraft.gui.clickgui.component.components.sub;

import java.math.BigDecimal;
import java.math.RoundingMode;

import me.deepcraft.gui.clickgui.ClickGui;
import me.deepcraft.gui.clickgui.component.Component;
import me.deepcraft.gui.clickgui.component.components.Button;
import me.deepcraft.module.settings.Setting;
import net.minecraft.client.gui.Gui;


public class Slider extends Component {

	private boolean hovered;

	private Setting set;
	private Button parent;
	private int offset;
	private int x;
	private int y;
	private boolean dragging = false;

	private double renderWidth;
	
	public Slider(Setting value, Button button, int offset) {
		this.set = value;
		this.parent = button;
		this.x = button.parent.getX() + button.parent.getWidth();
		this.y = button.parent.getY() + button.offset;
		this.offset = offset;
	}

	@Override
	public void renderComponent() {
		Gui.drawRect(parent.parent.getX() + 2, parent.parent.getY() + offset, parent.parent.getX() + parent.parent.getWidth(), parent.parent.getY() + offset + 12, ClickGui.backgroundDark);
		final int drag = (int)(this.set.getValDouble() / this.set.getMax() * this.parent.parent.getWidth());
		double fillWidth = ((this.set.getValDouble() - this.set.getMin()) / (this.set.getMax() - this.set.getMin())) * (parent.parent.getWidth() - 4);
		Gui.drawRect(parent.parent.getX() + 2, parent.parent.getY() + offset, parent.parent.getX() + 2 + (int) fillWidth, parent.parent.getY() + offset + 12, ClickGui.color);
		ClickGui.text.drawStringWithShadow(this.set.getName() + ": " + this.set.getValDouble() , (float) (parent.parent.getX() + 5), (float) (parent.parent.getY() + offset + 2.75), -1);
	}
	
	@Override
	public void setOff(int newOff) {
		offset = newOff;
	}
	
	@Override
	public void updateComponent(int mouseX, int mouseY) {
		this.hovered = isMouseOnButtonD(mouseX, mouseY) || isMouseOnButtonI(mouseX, mouseY);
		this.y = parent.parent.getY() + offset;
		this.x = parent.parent.getX();
		
		double diff = Math.min(100, Math.max(4, mouseX - this.x));

		double min = set.getMin();
		double max = set.getMax();
		
		renderWidth = (100) * (set.getValDouble() - min) / (max - min);
		
		if (dragging) {
			if (diff == 4) {
				set.setValDouble(set.getMin());
			}
			else {
				double newValue = roundToPlace(((diff / 100) * (max - min) + min), 2);
				set.setValDouble(newValue);
			}
		}
	}
	
	private static double roundToPlace(double value, int places) {
        if (places < 0) {
            throw new IllegalArgumentException();
        }
        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
	
	@Override
	public void mouseClicked(int mouseX, int mouseY, int button) {
		if(isMouseOnButtonD(mouseX, mouseY) && button == 0 && this.parent.open) {
			dragging = true;
		}
		if(isMouseOnButtonI(mouseX, mouseY) && button == 0 && this.parent.open) {
			dragging = true;
		}
	}
	
	@Override
	public void mouseReleased(int mouseX, int mouseY, int mouseButton) {
		dragging = false;
	}
	
	public boolean isMouseOnButtonD(int x, int y) {
		if(x > this.x && x < this.x + (parent.parent.getWidth() / 2 + 1) && y > this.y && y < this.y + 12) {
			return true;
		}
		return false;
	}
	
	public boolean isMouseOnButtonI(int x, int y) {
		if(x > this.x + parent.parent.getWidth() / 2 && x < this.x + parent.parent.getWidth() && y > this.y && y < this.y + 12) {
			return true;
		}
		return false;
	}
}
