package me.deepcraft.module;


import me.deepcraft.module.list.combat.KillAura;
import me.deepcraft.module.list.movement.Fly;
import me.deepcraft.module.list.movement.Speed;
import me.deepcraft.module.list.movement.Sprint;
import me.deepcraft.module.list.render.ClickGui;

import java.util.ArrayList;
import java.util.List;

public class ModuleManager {
    private static final List<Module> modules = new ArrayList<>();
    public ModuleManager() {
        modules.add(new Speed());
        modules.add(new Sprint());
        modules.add(new Fly());
        modules.add(new ClickGui());
        modules.add(new KillAura());
    }
    public static List<Module> getModules() {
        return modules;
    }
    public Module getModule(String name) {
        return modules.stream()
                .filter(m -> m.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }
    public ArrayList<Module> getModulesInCategory(Category categoryIn){
        ArrayList<Module> mods = new ArrayList<Module>();
        for(Module m : modules){
            if(m.getCategory() == categoryIn)
                mods.add(m);
        }
        return mods;
    }
}
