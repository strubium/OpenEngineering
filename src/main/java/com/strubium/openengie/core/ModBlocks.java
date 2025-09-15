package com.strubium.openengie.core;

import com.strubium.immersiveengineering.Tags;
import com.strubium.openengie.OpenEngineering;
import com.strubium.openengie.core.blocks.treated.BlockTreatedWood;
import com.strubium.openengie.core.blocks.alloy.BlockAlloyBrick;
import com.strubium.openengie.core.blocks.alloy.BlockAlloyKilnFormed;
import com.strubium.openengie.core.blocks.treated.BlockTreatedWoodStairs;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class ModBlocks {

    public static final Block TREATED_WOOD = new BlockTreatedWood();
    public static final Block TREATED_WOOD_STAIRS = new BlockTreatedWoodStairs(TREATED_WOOD);

    public static final Block ORE_ALUMINUM = new Block(Material.ROCK)
            .setCreativeTab(OpenEngineering.CREATIVE_TAB)
            .setRegistryName(Tags.MOD_ID, "ore_aluminum")
            .setTranslationKey(Tags.MOD_ID + ".ore_aluminum");

    public static final Block ORE_COPPER = new Block(Material.ROCK)
            .setCreativeTab(OpenEngineering.CREATIVE_TAB)
            .setRegistryName(Tags.MOD_ID, "ore_copper")
            .setTranslationKey(Tags.MOD_ID + ".ore_copper");

    public static final Block ORE_LEAD = new Block(Material.ROCK)
            .setCreativeTab(OpenEngineering.CREATIVE_TAB)
            .setRegistryName(Tags.MOD_ID, "ore_lead")
            .setTranslationKey(Tags.MOD_ID + ".ore_lead");

    public static final Block ORE_NICKEL = new Block(Material.ROCK)
            .setCreativeTab(OpenEngineering.CREATIVE_TAB)
            .setRegistryName(Tags.MOD_ID, "ore_nickel")
            .setTranslationKey(Tags.MOD_ID + ".ore_nickel");

    public static final Block ORE_SILVER = new Block(Material.ROCK)
            .setCreativeTab(OpenEngineering.CREATIVE_TAB)
            .setRegistryName(Tags.MOD_ID, "ore_silver")
            .setTranslationKey(Tags.MOD_ID + ".ore_silver");

    public static final Block ORE_URANIUM = new Block(Material.ROCK)
            .setCreativeTab(OpenEngineering.CREATIVE_TAB)
            .setRegistryName(Tags.MOD_ID, "ore_uranium")
            .setTranslationKey(Tags.MOD_ID + ".ore_uranium");

    public static final Block SHEETMETAL_ALUMINUM = new Block(Material.ROCK)
            .setCreativeTab(OpenEngineering.CREATIVE_TAB)
            .setRegistryName(Tags.MOD_ID, "sheetmetal_aluminum")
            .setTranslationKey(Tags.MOD_ID + ".sheetmetal_aluminum");

    public static final Block SHEETMETAT_STEEL = new Block(Material.ROCK)
            .setCreativeTab(OpenEngineering.CREATIVE_TAB)
            .setRegistryName(Tags.MOD_ID, "sheetmetal_steel")
            .setTranslationKey(Tags.MOD_ID + ".sheetmetal_steel");

    public static final BlockAlloyBrick ALLOY_KILN_BRICK = new BlockAlloyBrick();
    public static final BlockAlloyKilnFormed ALLOY_KILN_FORMED = new BlockAlloyKilnFormed();

    public static final Block BLASTBRICK = new Block(Material.ROCK)
            .setCreativeTab(OpenEngineering.CREATIVE_TAB)
            .setRegistryName(Tags.MOD_ID, "blastbrick")
            .setTranslationKey(Tags.MOD_ID + ".blastbrick");

    public static final Block COKE = new Block(Material.ROCK)
            .setCreativeTab(OpenEngineering.CREATIVE_TAB)
            .setRegistryName(Tags.MOD_ID, "coke")
            .setTranslationKey(Tags.MOD_ID + ".coke");

    public static void init() {
        Registry.addBlock(TREATED_WOOD);
        Registry.addBlock(TREATED_WOOD_STAIRS);
        Registry.addBlock(ORE_ALUMINUM);
        Registry.addBlock(ORE_COPPER);
        Registry.addBlock(ORE_LEAD);
        Registry.addBlock(ORE_NICKEL);
        Registry.addBlock(ORE_SILVER);
        Registry.addBlock(ORE_URANIUM);
        Registry.addBlock(SHEETMETAL_ALUMINUM);
        Registry.addBlock(SHEETMETAT_STEEL);
        Registry.addBlock(ALLOY_KILN_BRICK);
        Registry.addBlock(ALLOY_KILN_FORMED);
        Registry.addBlock(BLASTBRICK);
        Registry.addBlock(COKE);
    }
}

