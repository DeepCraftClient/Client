package me.deepcraft.module.list.render;

import me.deepcraft.DeepCraft;
import me.deepcraft.module.Category;
import me.deepcraft.module.Module;
import org.lwjgl.input.Keyboard;

public class ClickGui extends Module {
    public ClickGui() {
        super("ClickGui", Keyboard.KEY_RSHIFT, Category.RENDER);
    }
    public Module module;
    @Override
    public void onEnable() {
        mc.displayGuiScreen(DeepCraft.clickgui);
        toggle();
    }
}
