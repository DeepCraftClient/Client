package me.deepcraft.utils.font;

import java.awt.*;

public class ColorUtil {
	
	public static int getRainbowColorInt() {
		float hue_get = (System.currentTimeMillis() % 5000) / 5000F;
		return Color.HSBtoRGB(hue_get, 1, 1);
	}
	
	public static int getRainbowColorInt(long offset) {
		float hue = ((System.currentTimeMillis() + offset) % 5000) / 5000F;
		return Color.HSBtoRGB(hue, 1, 1);
	}
	
	public static Color getRainbowColor() {
		float hue_get = (System.currentTimeMillis() % 5000) / 5000F;
		return Color.getHSBColor(hue_get, 1, 1);
	}
	
	public static Color getRainbowColor(long offset) {
		float hue = ((System.currentTimeMillis() + offset) % 5000) / 5000F;
		return Color.getHSBColor(hue, 1, 1);
	}

}