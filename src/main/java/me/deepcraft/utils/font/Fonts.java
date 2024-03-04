package me.deepcraft.utils.font;

import java.util.HashMap;

public class Fonts {

    private static final HashMap<Integer, FontRenderer> fonts = new HashMap<>();

    public static FontRenderer get(int size) {
        if(!fonts.containsKey(size))
            fonts.put(size, new FontRenderer("smooth", size));
        return fonts.get(size);
    }

}

