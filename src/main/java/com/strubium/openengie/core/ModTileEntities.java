package com.strubium.openengie.core;

import com.strubium.openengie.core.blocks.alloy.TileAlloyKiln;

public class ModTileEntities {


    public static void init(){
        Registry.addTileEntity(TileAlloyKiln.class, "alloy_kiln");

    }


}
