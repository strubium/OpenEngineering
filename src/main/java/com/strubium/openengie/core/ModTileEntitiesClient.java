package com.strubium.openengie.core;

import com.strubium.openengie.core.blocks.alloy.RenderAlloyKiln;
import com.strubium.openengie.core.blocks.alloy.TileAlloyKiln;
import net.minecraftforge.fml.client.registry.ClientRegistry;

public class ModTileEntitiesClient {

    public static void clientInit(){
        ClientRegistry.bindTileEntitySpecialRenderer(TileAlloyKiln.class, new RenderAlloyKiln());

    }
}
