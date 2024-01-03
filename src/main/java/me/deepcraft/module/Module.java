package me.deepcraft.module;

import me.deepcraft.module.list.movement.Speed;
import net.minecraft.client.Minecraft;

public class Module {
    public Minecraft mc = Minecraft.getMinecraft();
    public boolean toggled = false;
    private String name;
    private int key;
    private Category category;

    public Module(String name, int key, Category category) {
        this.name = name;
        this.category = category;
        this.key = key;
        this.category = category;
    }

    public void onEnable() {
    }

    public void onDisable() {
    }

    public void onUpdate() {
    }
    public void setup() {
    }
    public void keyPressed(int k) {
    }
    public void toggle() {
        toggled = !toggled;
        if(toggled) {
            onEnable();
        } else {
            onDisable();
        }
    }
    public boolean isToggled() {
        return toggled;
    }

    public void setToggled(boolean toggled) {
        this.toggled = toggled;
    }

    public String getName() {
        return name;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public Category getCategory() {
        return category;
    }
}
