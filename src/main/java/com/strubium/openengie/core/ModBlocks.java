package com.strubium.openengie.core;

import com.strubium.immersiveengineering.Tags;
import com.strubium.openengie.OpenEngineering;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class ModBlocks {

    private static final String[] BLOCK_NAMES = {
            "stone_decoration_alloybrick",
            "stone_decoration_blastbrick",
            "stone_decoration_coke"
    };


    public static final Block TREATED_WOOD = new Block(Material.WOOD)
            .setCreativeTab(OpenEngineering.CREATIVE_TAB)
            .setRegistryName(Tags.MOD_ID, "treated_wood")
            .setTranslationKey(Tags.MOD_ID + ".treated_wood");

    public static final Block ORE_ALUMINUM = new Block(Material.ROCK)
            .setCreativeTab(OpenEngineering.CREATIVE_TAB)
            .setRegistryName(Tags.MOD_ID, "ore_aluminum")
            .setTranslationKey(Tags.MOD_ID + ".ore_aluminum");

    public static final Block ORE_COPPER = new Block(Material.ROCK)
            .setCreativeTab(CreativeTabs.BUILDING_BLOCKS)
            .setRegistryName(Tags.MOD_ID, "ore_copper")
            .setTranslationKey(Tags.MOD_ID + ".ore_copper");

    public static final Block ORE_LEAD = new Block(Material.ROCK)
            .setCreativeTab(CreativeTabs.BUILDING_BLOCKS)
            .setRegistryName(Tags.MOD_ID, "ore_lead")
            .setTranslationKey(Tags.MOD_ID + ".ore_lead");

    public static final Block ORE_NICKEL = new Block(Material.ROCK)
            .setCreativeTab(CreativeTabs.BUILDING_BLOCKS)
            .setRegistryName(Tags.MOD_ID, "ore_nickel")
            .setTranslationKey(Tags.MOD_ID + ".ore_nickel");

    public static final Block ORE_SILVER = new Block(Material.ROCK)
            .setCreativeTab(CreativeTabs.BUILDING_BLOCKS)
            .setRegistryName(Tags.MOD_ID, "ore_silver")
            .setTranslationKey(Tags.MOD_ID + ".ore_silver");

    public static final Block ORE_URANIUM = new Block(Material.ROCK)
            .setCreativeTab(CreativeTabs.BUILDING_BLOCKS)
            .setRegistryName(Tags.MOD_ID, "ore_uranium")
            .setTranslationKey(Tags.MOD_ID + ".ore_uranium");

    public static final Block SHEETMETAL_ALUMINUM = new Block(Material.ROCK)
            .setCreativeTab(CreativeTabs.BUILDING_BLOCKS)
            .setRegistryName(Tags.MOD_ID, "sheetmetal_aluminum")
            .setTranslationKey(Tags.MOD_ID + ".sheetmetal_aluminum");

    public static final Block SHEETMETAT_STEEL = new Block(Material.ROCK)
            .setCreativeTab(CreativeTabs.BUILDING_BLOCKS)
            .setRegistryName(Tags.MOD_ID, "sheetmetal_steel")
            .setTranslationKey(Tags.MOD_ID + ".sheetmetal_steel");

    public static final Block SD_ALLOYBRICK = new Block(Material.ROCK)
            .setCreativeTab(CreativeTabs.BUILDING_BLOCKS)
            .setRegistryName(Tags.MOD_ID, "stone_decoration_alloybrick")
            .setTranslationKey(Tags.MOD_ID + ".stone_decoration_alloybrick");

    public static final Block SD_BLASTBRICK = new Block(Material.ROCK)
            .setCreativeTab(CreativeTabs.BUILDING_BLOCKS)
            .setRegistryName(Tags.MOD_ID, "stone_decoration_blastbrick")
            .setTranslationKey(Tags.MOD_ID + ".stone_decoration_blastbrick");

    public static final Block SD_COKE = new Block(Material.ROCK)
            .setCreativeTab(CreativeTabs.BUILDING_BLOCKS)
            .setRegistryName(Tags.MOD_ID, "stone_decoration_coke")
            .setTranslationKey(Tags.MOD_ID + ".stone_decoration_coke");

    public static void init() {
        Registry.addBlock(TREATED_WOOD);
        Registry.addBlock(ORE_ALUMINUM);
        Registry.addBlock(ORE_COPPER);
        Registry.addBlock(ORE_LEAD);
        Registry.addBlock(ORE_NICKEL);
        Registry.addBlock(ORE_SILVER);
        Registry.addBlock(ORE_URANIUM);
        Registry.addBlock(SHEETMETAL_ALUMINUM);
        Registry.addBlock(SHEETMETAT_STEEL);
        Registry.addBlock(SD_ALLOYBRICK);
        Registry.addBlock(SD_BLASTBRICK);
        Registry.addBlock(SD_COKE);
    }
}

