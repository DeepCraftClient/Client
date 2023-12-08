package me.deepcraft.module.list.movement;

import me.deepcraft.module.Category;
import me.deepcraft.module.Module;
import org.lwjgl.input.Keyboard;

public class Sprint extends Module {
    public Sprint() {
        super("Sprint", Keyboard.KEY_V, Category.MOVEMENT);
    }
    public void onUpdate() {
        if (!mc.thePlayer.isCollidedHorizontally && mc.thePlayer.moveForward > 0)
            mc.thePlayer.setSprinting(true);
    }
}
