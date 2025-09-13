package com.strubium.openengie;

import com.strubium.immersiveengineering.Tags;
import com.strubium.openengie.assets.RuntimeAssets;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLConstructionEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(modid = Tags.MOD_ID, name = Tags.MOD_NAME, version = Tags.VERSION)
@Mod.EventBusSubscriber
public class OpenEngineering {

    public static final Logger LOGGER = LogManager.getLogger(Tags.MOD_NAME);

    @Mod.EventHandler
    public void construct(FMLConstructionEvent event){
        RuntimeAssets.downloadAssets();
    }

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        RuntimeAssets.generateRuntimeModels();

        if (event.getSide().isClient()) {
            RuntimeAssets.registerGeneratedResourcePack();
        }
    }
}
