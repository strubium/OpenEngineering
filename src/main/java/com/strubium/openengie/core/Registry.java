package com.strubium.openengie.core;

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
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@Mod.EventBusSubscriber
public class Registry {

    // Define block names
    private static final String[] BLOCK_NAMES = {
            "treated_wood",
            "ore_aluminum",
            "ore_copper",
            "ore_lead",
            "ore_nickel",
            "ore_silver",
            "ore_uranium",
            "sheetmetal_aluminum",
            "sheetmetal_steel",
            "storage_aluminum",
            "stone_decoration_alloybrick",
            "stone_decoration_blastbrick",
            "stone_decoration_coke"
    };

    // Array to hold block instances
    private static final Block[] BLOCKS = new Block[BLOCK_NAMES.length];

    /** Helper to get block by name */
    public static Block getBlock(String name) {
        for (int i = 0; i < BLOCK_NAMES.length; i++) {
            if (BLOCK_NAMES[i].equals(name)) return BLOCKS[i];
        }
        return null;
    }

    /** Helper to get item from block name */
    public static Item getItem(String name) {
        Block block = getBlock(name);
        return block != null ? Item.getItemFromBlock(block) : null;
    }

    /** Register blocks dynamically */
    @Mod.EventBusSubscriber
    public static class BlockRegistration {

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

        @SubscribeEvent
        public static void registerItems(RegistryEvent.Register<Item> event) {
            for (Block block : BLOCKS) {
                ItemBlock itemBlock = new ItemBlock(block);
                itemBlock.setRegistryName(block.getRegistryName());
                event.getRegistry().register(itemBlock);
            }
        }

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
}
