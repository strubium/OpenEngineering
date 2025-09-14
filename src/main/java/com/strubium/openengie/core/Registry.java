package com.strubium.openengie.core;

import com.strubium.openengie.core.blocks.BlockTreatedWood;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.ArrayList;
import java.util.List;

@Mod.EventBusSubscriber
public class Registry {

    /** Holds all registered blocks dynamically */
    private static final List<Block> BLOCKS = new ArrayList<>();
    private static final List<Item> ITEMS = new ArrayList<>();


    /**
     * Add an already-constructed block to the registry list.
     * Call this during preInit or static initialization.
     */
    public static void addBlock(Block block) {
        BLOCKS.add(block);
    }

    /**
     * Add an already-constructed block to the registry list.
     * Call this during preInit or static initialization.
     */
    public static void addItem(Item item) {
        ITEMS.add(item);
    }

    /** Helper to get block by registry name */
    public static Block getBlock(String name) {
        return BLOCKS.stream()
                .filter(b -> b.getRegistryName().getPath().equals(name))
                .findFirst()
                .orElse(null);
    }

    /** Helper to get item from block name */
    public static Item getItem(String name) {
        Block block = getBlock(name);
        return block != null ? Item.getItemFromBlock(block) : null;
    }

    @Mod.EventBusSubscriber
    public static class BlockRegistration {

        @SubscribeEvent
        public static void registerBlocks(RegistryEvent.Register<Block> event) {
            for (Block block : BLOCKS) {
                event.getRegistry().register(block);
                if(block instanceof BlockTreatedWood){
                    Blocks.FIRE.setFireInfo(ModBlocks.TREATED_WOOD, 0, 0); // No chance to catch or spread fire
                }
            }
        }

        @SubscribeEvent
        public static void registerItems(RegistryEvent.Register<Item> event) {
            for (Block block : BLOCKS) {
                ItemBlock itemBlock = new ItemBlock(block);
                itemBlock.setRegistryName(block.getRegistryName());
                event.getRegistry().register(itemBlock);
            }
            for (Item item : ITEMS){
                event.getRegistry().register(item);
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
