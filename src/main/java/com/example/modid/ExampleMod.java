package com.example.modid;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(modid = Tags.MOD_ID, name = Tags.MOD_NAME, version = Tags.VERSION)
@Mod.EventBusSubscriber
public class ExampleMod {

    public static final Logger LOGGER = LogManager.getLogger(Tags.MOD_NAME);
    public static final Block TREATED_WOOD = new Block(Material.ROCK)
            .setCreativeTab(CreativeTabs.BUILDING_BLOCKS)
            .setRegistryName(Tags.MOD_ID + ":treated_wood")
            .setTranslationKey(Tags.MOD_ID + ".treated_wood");
    public static final ResourceLocation DYNAMIC_TEXTURE = new ResourceLocation(Tags.MOD_ID, "textures/blocks/treated_wood.png");

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        RuntimeAssets.downloadTextureIfMissing();
        RuntimeAssets.generateRuntimeModels();

        if (event.getSide().isClient()) {
            RuntimeAssets.registerGeneratedResourcePack();
        }
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        if (event.getSide().isClient()) {
            RuntimeAssets.registerDynamicTexture();
        }
    }

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        event.getRegistry().register(TREATED_WOOD);
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        ItemBlock itemBlock = new ItemBlock(TREATED_WOOD);
        itemBlock.setRegistryName(TREATED_WOOD.getRegistryName());
        event.getRegistry().register(itemBlock);
    }

    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public static void registerModels(ModelRegistryEvent event) {
        ModelLoader.setCustomModelResourceLocation(
                Item.getItemFromBlock(TREATED_WOOD),
                0,
                new net.minecraft.client.renderer.block.model.ModelResourceLocation(TREATED_WOOD.getRegistryName(), "inventory")
        );
    }
}
