package com.strubium.openengie.core.multi;

import net.minecraft.util.IStringSerializable;

public enum MultiblockPart implements IStringSerializable {
    FRONT_LEFT_BOTTOM,
    FRONT_RIGHT_BOTTOM,
    BACK_LEFT_BOTTOM,
    BACK_RIGHT_BOTTOM,

    FRONT_LEFT_TOP,
    FRONT_RIGHT_TOP,
    BACK_LEFT_TOP,
    BACK_RIGHT_TOP,

    INTERIOR;

    @Override
    public String getName() {
        return name().toLowerCase();
    }
}