package me.deepcraft.gui.clickgui;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

import me.deepcraft.gui.clickgui.component.Component;
import me.deepcraft.gui.clickgui.component.Frame;
import me.deepcraft.module.Category;
import me.deepcraft.utils.fontutil.FontRenderer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.ResourceLocation;


public class ClickGui extends GuiScreen {

	public static ArrayList<Frame> frames;
	public static int color = 0xFF4848FF, background = 0xFF1F1F1F, backgroundDark = new Color(0, 0, 0, 255).getRGB(), state = new Color(58, 77, 224, 255).getRGB();
	public static FontRenderer text = new FontRenderer("Arial", 18, Font.PLAIN, true, true);

	public ClickGui() {
		frames = new ArrayList<Frame>();
		int frameX = 21;
		for (Category category : Category.values()) {
			Frame frame = new Frame(category);
			frame.setX(frameX);
			frames.add(frame);
			frameX += frame.getWidth() + 1;

		}
	}
	
	@Override
	public void initGui() {
		Minecraft.getMinecraft().entityRenderer.loadShader(new ResourceLocation("shaders/post/clickguiblur.json"));
	}

	@Override
	public void onGuiClosed() {
		mc.entityRenderer.stopUseShader();
	}
	
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		for(Frame frame : frames) {
			frame.renderFrame(this.fontRendererObj);
			frame.updatePosition(mouseX, mouseY);
			for(Component comp : frame.getComponents()) {
				comp.updateComponent(mouseX, mouseY);
			}
		}
	}
	
	@Override
    protected void mouseClicked(final int mouseX, final int mouseY, final int mouseButton) throws IOException {
		for(Frame frame : frames) {
			if(frame.isWithinHeader(mouseX, mouseY) && mouseButton == 0) {
				frame.setDrag(true);
				frame.dragX = mouseX - frame.getX();
				frame.dragY = mouseY - frame.getY();
			}
			if(frame.isWithinHeader(mouseX, mouseY) && mouseButton == 1) {
				frame.setOpen(!frame.isOpen());
			}
			if(frame.isOpen()) {
				if(!frame.getComponents().isEmpty()) {
					for(Component component : frame.getComponents()) {
						component.mouseClicked(mouseX, mouseY, mouseButton);
					}
				}
			}
		}
	}
	
	@Override
	protected void keyTyped(char typedChar, int keyCode) {
		for(Frame frame : frames) {
			if(frame.isOpen() && keyCode != 1) {
				if(!frame.getComponents().isEmpty()) {
					for(Component component : frame.getComponents()) {
						component.keyTyped(typedChar, keyCode);
					}
				}
			}
		}
		if (keyCode == 1) {
            this.mc.displayGuiScreen(null);
        }
	}

	
	@Override
    protected void mouseReleased(int mouseX, int mouseY, int state) {
		for(Frame frame : frames) {
			frame.setDrag(false);
		}
		for(Frame frame : frames) {
			if(frame.isOpen()) {
				if(!frame.getComponents().isEmpty()) {
					for(Component component : frame.getComponents()) {
						component.mouseReleased(mouseX, mouseY, state);
					}
				}
			}
		}
	}

}
