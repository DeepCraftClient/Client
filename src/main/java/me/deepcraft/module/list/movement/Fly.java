package me.deepcraft.module.list.movement;

import me.deepcraft.DeepCraft;
import me.deepcraft.module.Category;
import me.deepcraft.module.Module;
import me.deepcraft.module.settings.Setting;
import org.lwjgl.input.Keyboard;

import java.util.ArrayList;

public class Fly extends Module {
    public ArrayList<Object> modes = new ArrayList<>();


    public Fly() {
        super("Fly", Keyboard.KEY_F, Category.MOVEMENT);
    }

    @Override
    public void setup() {
        modes.add("Test");
        modes.add("Vanilla");
        DeepCraft.settingsManager.rSetting(new Setting("Modes", this,"Test",modes));
    }


    @Override
    public void onUpdate() {

    }

    @Override
    public void onEnable(){

    }

    @Override
    public void onDisable() {

    }
}
