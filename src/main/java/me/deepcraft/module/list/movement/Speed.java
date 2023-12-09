package me.deepcraft.module.list.movement;

import me.deepcraft.module.Category;
import me.deepcraft.module.Module;
import me.deepcraft.utils.ChatUtil;
import org.lwjgl.input.Keyboard;

public class Speed extends Module {
    public Speed() {
        super("Speed", Keyboard.KEY_M, Category.MOVEMENT);
    }

    @Override
    public void onUpdate() {

    }

    @Override
    public void onEnable() {
        mc.timer.timerSpeed = 1.07F;
    }
}
