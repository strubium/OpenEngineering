package com.strubium.openengie.core;

import com.strubium.openengie.Tags;
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

    public static final Block ORE_ALUMINUM = createBlock(Material.ROCK, "ore_aluminum");
    public static final Block ORE_COPPER = createBlock(Material.ROCK, "ore_copper");
    public static final Block ORE_LEAD = createBlock(Material.ROCK, "ore_lead");
    public static final Block ORE_NICKEL = createBlock(Material.ROCK, "ore_nickel");
    public static final Block ORE_SILVER = createBlock(Material.ROCK, "ore_silver");
    public static final Block ORE_URANIUM = createBlock(Material.ROCK, "ore_uranium");

    public static final Block SHEETMETAL_ALUMINUM = createBlock(Material.ROCK, "sheetmetal_aluminum");
    public static final Block SHEETMETAL_STEEL = createBlock(Material.ROCK, "sheetmetal_steel");
    public static final Block SHEETMETAL_COPPER = createBlock(Material.ROCK, "sheetmetal_copper");
    public static final Block SHEETMETAL_IRON = createBlock(Material.ROCK, "sheetmetal_iron");
    public static final Block SHEETMETAL_GOLD = createBlock(Material.ROCK, "sheetmetal_gold");
    public static final Block SHEETMETAL_SILVER = createBlock(Material.ROCK, "sheetmetal_silver");
    public static final Block SHEETMETAL_NICKEL = createBlock(Material.ROCK, "sheetmetal_nickel");
    public static final Block SHEETMETAL_LEAD = createBlock(Material.ROCK, "sheetmetal_lead");
    public static final Block SHEETMETAL_URANIUM = createBlock(Material.ROCK, "sheetmetal_uranium");
    public static final Block SHEETMETAL_CONSTANTAN = createBlock(Material.ROCK, "sheetmetal_constantan");
    public static final Block SHEETMETAL_ELECTRUM = createBlock(Material.ROCK, "sheetmetal_electrum");

    public static final Block COIL_COPPER = createBlock(Material.ROCK, "coil_lv");
    public static final Block COIL_ELECTRUM = createBlock(Material.ROCK, "coil_mv");
    public static final Block COIL_HV = createBlock(Material.ROCK, "coil_hv");


    public static final BlockAlloyBrick ALLOY_KILN_BRICK = new BlockAlloyBrick();
    public static final BlockAlloyKilnFormed ALLOY_KILN_FORMED = new BlockAlloyKilnFormed();

    public static final Block BLASTBRICK = createBlock(Material.ROCK, "blastbrick");
    public static final Block BLASTBRICK_REINFORCED = createBlock(Material.ROCK, "blastbrick_reinforced");
    public static final Block COKE = createBlock(Material.ROCK, "coke");
    public static final Block COKE_BRICK = createBlock(Material.ROCK, "coke_brick");
    public static final Block HEMP_CRETE = createBlock(Material.ROCK, "hemp_crete");
    public static final Block CONCRETE = createBlock(Material.ROCK, "concrete");
    public static final Block LEADED_CONCRETE = createBlock(Material.ROCK, "leaded_concrete");


    public static Block createBlock(Material material, String name){
        Block block = new Block(material)
                .setCreativeTab(OpenEngineering.CREATIVE_TAB)
                .setRegistryName(Tags.MOD_ID, name)
                .setTranslationKey(Tags.MOD_ID + "." + name);

        return block;
    }

    public static void init() {
        Registry.addBlock(TREATED_WOOD);
        Registry.addBlock(TREATED_WOOD_STAIRS);
        Registry.addBlock(ORE_ALUMINUM);
        Registry.addBlock(ORE_COPPER);
        Registry.addBlock(ORE_LEAD);
        Registry.addBlock(ORE_NICKEL);
        Registry.addBlock(ORE_SILVER);
        Registry.addBlock(ORE_URANIUM);

        Registry.addBlock(COIL_COPPER);
        Registry.addBlock(COIL_ELECTRUM);
        Registry.addBlock(COIL_HV);

        Registry.addBlock(SHEETMETAL_ALUMINUM);
        Registry.addBlock(SHEETMETAL_STEEL);
        Registry.addBlock(SHEETMETAL_COPPER);
        Registry.addBlock(SHEETMETAL_IRON);
        Registry.addBlock(SHEETMETAL_GOLD);
        Registry.addBlock(SHEETMETAL_SILVER);
        Registry.addBlock(SHEETMETAL_NICKEL);
        Registry.addBlock(SHEETMETAL_LEAD);
        Registry.addBlock(SHEETMETAL_URANIUM);
        Registry.addBlock(SHEETMETAL_CONSTANTAN);
        Registry.addBlock(SHEETMETAL_ELECTRUM);

        Registry.addBlock(ALLOY_KILN_BRICK);
        Registry.addBlock(ALLOY_KILN_FORMED);
        Registry.addBlock(BLASTBRICK);
        Registry.addBlock(BLASTBRICK_REINFORCED);
        Registry.addBlock(COKE);
        Registry.addBlock(COKE_BRICK);
        Registry.addBlock(HEMP_CRETE);
        Registry.addBlock(CONCRETE);
        Registry.addBlock(LEADED_CONCRETE);
    }
}