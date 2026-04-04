package com.strubium.openengie.core.registry;

import net.minecraft.util.ResourceLocation;

public class OreEntry {
    String name;
    ResourceLocation regName;

    OreEntry(String name, ResourceLocation regName) {
        this.name = name;
        this.regName = regName;
    }
}

