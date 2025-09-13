package com.strubium.openengie;

import com.strubium.immersiveengineering.Tags;
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

    // Define block names
    public static final String[] BLOCK_NAMES = {
            "treated_wood",
            "ore_aluminum",
            "ore_copper",
            "ore_lead",
            "ore_nickel",
            "ore_silver",
            "ore_uranium"
    };

    // Array to hold block instances
    public static final Block[] BLOCKS = new Block[BLOCK_NAMES.length];

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

    // Register blocks dynamically
    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        for (int i = 0; i < BLOCK_NAMES.length; i++) {
            BLOCKS[i] = new Block(Material.ROCK)
                    .setCreativeTab(CreativeTabs.BUILDING_BLOCKS)
                    .setRegistryName(Tags.MOD_ID + ":" + BLOCK_NAMES[i])
                    .setTranslationKey(Tags.MOD_ID + "." + BLOCK_NAMES[i]);
            event.getRegistry().register(BLOCKS[i]);
        }
    }

    // Register corresponding item blocks
    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        for (Block block : BLOCKS) {
            ItemBlock itemBlock = new ItemBlock(block);
            itemBlock.setRegistryName(block.getRegistryName());
            event.getRegistry().register(itemBlock);
        }
    }

    // Register models for all blocks
    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public static void registerModels(ModelRegistryEvent event) {
        for (Block block : BLOCKS) {
            ModelLoader.setCustomModelResourceLocation(
                    Item.getItemFromBlock(block),
                    0,
                    new net.minecraft.client.renderer.block.model.ModelResourceLocation(block.getRegistryName(), "inventory")
            );
        }
    }
}
