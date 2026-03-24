package com.strubium.openengie.core;

import com.strubium.openengie.core.blocks.alloy.RenderAlloyKiln;
import com.strubium.openengie.core.blocks.alloy.TileAlloyKiln;
import net.minecraftforge.fml.client.registry.ClientRegistry;

public class ModTileEntities {


    public static void init(){
        Registry.addTileEntity(TileAlloyKiln.class, "alloy_kiln");

    }

    public static void clientInit(){
        ClientRegistry.bindTileEntitySpecialRenderer(TileAlloyKiln.class, new RenderAlloyKiln());

    }
}
