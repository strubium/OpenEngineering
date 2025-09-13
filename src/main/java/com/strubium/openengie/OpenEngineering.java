package com.strubium.openengie;

import com.strubium.immersiveengineering.Tags;
import com.strubium.openengie.assets.RuntimeAssets;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLConstructionEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
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
