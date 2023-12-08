package me.deepcraft.module;


import me.deepcraft.module.list.movement.Speed;
import me.deepcraft.module.list.movement.Sprint;

import java.util.ArrayList;
import java.util.List;

public class ModuleManager {
    private static final List<Module> modules = new ArrayList<>();
    public ModuleManager() {
        modules.add(new Speed());
        modules.add(new Sprint());
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
