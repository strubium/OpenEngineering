package com.strubium.openengie.core.registry;

import net.minecraft.tileentity.TileEntity;

public class TileEntry {
    public final Class<? extends TileEntity> clazz;
    public final String id;

    public TileEntry(Class<? extends TileEntity> clazz, String id) {
        this.clazz = clazz;
        this.id = id;
    }
}