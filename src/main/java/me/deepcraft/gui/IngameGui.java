package me.deepcraft.gui;

import me.deepcraft.DeepCraft;
import me.deepcraft.module.Module;
import me.deepcraft.module.ModuleManager;
import me.deepcraft.utils.font.ColorUtil;
import me.deepcraft.utils.font.Fonts;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;

import java.awt.*;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static org.lwjgl.opengl.Display.getWidth;


public class IngameGui{
    public Minecraft mc = Minecraft.getMinecraft();
    public void draw() {
            ScaledResolution sr = new ScaledResolution(mc);
            GlStateManager.pushMatrix();
            Fonts.get(31).drawStringWithShadow(DeepCraft.name + " " + DeepCraft.version, 2, 2, ColorUtil.getRainbowColorInt());
            Fonts.get(20).drawStringWithShadow("FPS: " + Minecraft.getDebugFPS(), 2, 45, -1);
            Fonts.get(20).drawStringWithShadow("XYZ: " + (Minecraft.getMinecraft()).thePlayer.getPosition().getX() + " " + (Minecraft.getMinecraft()).thePlayer.getPosition().getY() + " " + (Minecraft.getMinecraft()).thePlayer.getPosition().getZ(), 2, 25, -1);
            Fonts.get(20).drawStringWithShadow("IGN: " + (mc.thePlayer.getName()),  2, 35, -1);
            if(!mc.isSingleplayer()) {
                Fonts.get(20).drawStringWithShadow("ServerIP: " + (mc.getCurrentServerData().serverIP), 2, 55, -1);
                Fonts.get(20).drawStringWithShadow("Brand: " + mc.thePlayer.getClientBrand(), 2, 65, -1);
                Fonts.get(20).drawStringWithShadow("Ping: " + mc.getCurrentServerData().pingToServer, 2, 75, -1);
                Fonts.get(20).drawStringWithShadow("Protocol: " + getVersion(), 2, 85, -1);
            }
            renderArraylist();
            GlStateManager.resetColor();
            GlStateManager.popMatrix();
        }

    public void renderArraylist() {
        ScaledResolution sr = new ScaledResolution(mc);
        List<Module> modules = ModuleManager.getModules().stream()
                .filter(Module::isToggled)
                .sorted(Comparator.comparingInt(m -> -Fonts.get(26).getStringWidth(m.getName())))
                .collect(Collectors.toList());

        int y = 1;
        int relativeYOffset = 3;
        int offset = 26 / 2 + relativeYOffset;

        for (Module module : modules) {
            String s = module.getName();
            int mWidth = Fonts.get(26).getStringWidth(s);

            int textX = sr.getScaledWidth() - mWidth;

            Gui.drawRect(textX, y - 1, sr.getScaledWidth(), y + offset, new Color(0, 0, 0, 100).getRGB());

            Fonts.get(26).drawString(s, textX, y, ColorUtil.getRainbowColorInt());

            y += offset + 1;
        }
    }

    public String getVersion() {
        int version = mc.getCurrentServerData().version;
        switch (version) {
            case 764:
                return "1.20.2";
            case 763:
                return "1.20";
            case 759:
                return "1.19";
            case 758:
                return "1.18.2";
            case 757:
                return "1.18";
            case 756:
                return "1.17.1";
            case 755:
                return "1.17";
            case 754:
                return "1.16.4/5";
            case 753:
                return "1.16.3";
            case 751:
                return "1.16.2";
            case 736:
                return "1.16.1";
            case 735:
                return "1.16";
            case 335:
                return "1.12";
            case 316:
                return "1.11.1";
            case 315:
                return "1.11";
            case 210:
                return "1.10.";
            case 110:
                return "1.9.3/4";
            case 109:
                return "1.9.2";
            case 108:
                return "1.9.1";
            case 107:
                return "1.9";
            case 47:
                return "1.8";
            case 5:
                return "1.7.10";
            case 3:
                return "1.7";
            case 72:
                return "1.6";
            case 61:
                return "1.5";
            case 46:
                return "1.4";
            default:
                return "?";
        }
    }
}
