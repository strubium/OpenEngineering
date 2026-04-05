package com.strubium.openengie.core;

import com.strubium.openengie.Tags;
import com.strubium.openengie.OpenEngineering;
import com.strubium.openengie.core.blocks.treated.BlockTreatedWood;
import com.strubium.openengie.core.blocks.alloy.BlockAlloyBrick;
import com.strubium.openengie.core.blocks.alloy.BlockAlloyKilnFormed;
import com.strubium.openengie.core.registry.Registry;
import net.minecraft.block.*;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class ModBlocks {

    public static final Block TREATED_WOOD_PLANK = createBlockOre(Material.WOOD, "treated_wood", "plankTreatedWood");
   // public static final Block TREATED_WOOD_PLANK_SLAB = createSlab(TREATED_WOOD_PLANK);
    public static final Block TREATED_WOOD_PLANK_STAIRS = createStairs(TREATED_WOOD_PLANK);
    public static final Block TREATED_WOOD_FENCE = createFence(TREATED_WOOD_PLANK);

    public static final Block TREATED_WOOD_PLANK_VERTICAL = createBlockOre(Material.WOOD, "treated_wood_vertical", "plankTreatedWood");
    // public static final Block TREATED_WOOD_PLANK_SLAB = createSlab(TREATED_WOOD_PLANK_VERTICAL);
    public static final Block TREATED_WOOD_PLANK_VERTICAL_STAIRS = createStairs(TREATED_WOOD_PLANK_VERTICAL);

    public static final Block TREATED_WOOD_PLANK_PACKAGED = createBlockOre(Material.WOOD, "treated_wood_packaged", "plankTreatedWood");
    // public static final Block TREATED_WOOD_PLANK_SLAB = createSlab(TREATED_WOOD_PLANK_PACKAGED);
    public static final Block TREATED_WOOD_PLANK_PACKAGED_STAIRS = createStairs(TREATED_WOOD_PLANK_PACKAGED);


    public static final Block ORE_ALUMINUM = createBlock(Material.ROCK, "ore_aluminum");
    public static final Block ORE_COPPER = createBlock(Material.ROCK, "ore_copper");
    public static final Block ORE_LEAD = createBlock(Material.ROCK, "ore_lead");
    public static final Block ORE_NICKEL = createBlock(Material.ROCK, "ore_nickel");
    public static final Block ORE_SILVER = createBlock(Material.ROCK, "ore_silver");
    public static final Block ORE_URANIUM = createBlock(Material.ROCK, "ore_uranium");

    public static final Block SHEETMETAL_ALUMINUM = createBlockOre(Material.ROCK, "sheetmetal_aluminum", "blockSheetmetalAluminum");
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

    public static final Block HEAVY_ENG = createBlock(Material.ROCK, "heavy_engineering");
    public static final Block LIGHT_ENG = createBlock(Material.ROCK, "light_engineering");
    public static final Block REDSTONE_ENG = createBlock(Material.ROCK, "redstone_engineering");

    public static final Block GENERATOR = createBlock(Material.ROCK, "generator");
    public static final Block RADIATOR = createBlock(Material.ROCK, "radiator");

    public static final BlockAlloyBrick ALLOY_KILN_BRICK = new BlockAlloyBrick();
   // public static final Block ALLOY_KILN_BRICK_SLAB = createStairs(new BlockAlloyBrick());
    public static final BlockAlloyKilnFormed ALLOY_KILN_FORMED = new BlockAlloyKilnFormed();

    public static final Block BLASTBRICK = createBlock(Material.ROCK, "blastbrick");
 //   public static final Block BLASTBRICK_SLAB = createSlab(BLASTBRICK);
    public static final Block BLASTBRICK_REINFORCED = createBlock(Material.ROCK, "blastbrick_reinforced");
 //   public static final Block BLASTBRICK_REINFORCED_SLAB = createSlab(BLASTBRICK_REINFORCED);
    public static final Block COKE = createBlock(Material.ROCK, "coke");
    public static final Block COKE_BRICK = createBlock(Material.ROCK, "coke_brick");
   // public static final Block COKE_BRICK_SLAB = createSlab(COKE_BRICK);

    public static final Block INSULATED_GLASS = createBlock(Material.ROCK, "insulated_glass");


    public static final Block HEMP_CRETE = createBlock(Material.ROCK, "hemp_crete");
  //  public static final Block HEMP_CRETE_SLAB = createSlab(HEMP_CRETE);
    public static final Block HEMP_CRETE_STAIRS = createStairs(HEMP_CRETE);
    public static final Block CONCRETE = createBlock(Material.ROCK, "concrete");
   // public static final Block CONCRETE_SLAB = createSlab(CONCRETE);
    public static final Block CONCRETE_STAIRS = createStairs(CONCRETE);
    public static final Block CONCRETE_SHEET = createBlock(Material.ROCK, "concrete_sheet");
    public static final Block CONCRETE_PANEL = createBlock(Material.ROCK, "concrete_panel");
    public static final Block CONCRETE_CHUNK = createBlock(Material.ROCK, "concrete_chunk");
    public static final Block CONCRETE_TILE = createBlock(Material.ROCK, "concrete_tile");
    //public static final Block CONCRETE_TILE_SLAB = createBlock(Material.ROCK, "concrete_tile_slab");
    public static final Block CONCRETE_TILE_STAIRS = createStairs(CONCRETE_TILE);
    public static final Block LEADED_CONCRETE = createBlock(Material.ROCK, "leaded_concrete");
   // public static final Block LEADED_CONCRETE_SLAB = createSlab(LEADED_CONCRETE);
    public static final Block LEADED_CONCRETE_STAIRS = createStairs(LEADED_CONCRETE);

    public static final Block JUMP_CUSHION = createBlock(Material.ROCK, "jump_cushion");

    public static final Block STORAGE_ALUMINUM = createBlock(Material.ROCK, "storage_aluminum");
    public static final Block STORAGE_COPPER = createBlock(Material.ROCK, "storage_copper");
    public static final Block STORAGE_STEEL = createBlock(Material.ROCK, "storage_steel");
    public static final Block STORAGE_SILVER = createBlock(Material.ROCK, "storage_silver");
    public static final Block STORAGE_NICKEL = createBlock(Material.ROCK, "storage_nickel");
    public static final Block STORAGE_LEAD = createBlock(Material.ROCK, "storage_lead");
    public static final Block STORAGE_URANIUM = createBlock(Material.ROCK, "storage_uranium");
    public static final Block STORAGE_CONSTANTAN = createBlock(Material.ROCK, "storage_constantan");
    public static final Block STORAGE_ELECTRUM = createBlock(Material.ROCK, "storage_electrum");

   /* public static final Block STORAGE_ALUMINUM_SLAB = createSlab(STORAGE_ALUMINUM);
    public static final Block STORAGE_COPPER_SLAB = createSlab(STORAGE_COPPER);
    public static final Block STORAGE_STEEL_SLAB = createSlab(STORAGE_STEEL);
    public static final Block STORAGE_SILVER_SLAB = createSlab(STORAGE_SILVER);
    public static final Block STORAGE_NICKEL_SLAB = createSlab(STORAGE_NICKEL);
    public static final Block STORAGE_LEAD_SLAB = createSlab(STORAGE_LEAD);
    public static final Block STORAGE_URANIUM_SLAB = createSlab(STORAGE_URANIUM);
    public static final Block STORAGE_CONSTANTAN_SLAB = createSlab(STORAGE_CONSTANTAN);
    public static final Block STORAGE_ELECTRUM_SLAB = createSlab(STORAGE_ELECTRUM);
*/

    public static final Block STEEL_FENCE = createFence(STORAGE_STEEL);
    public static final Block ALUMINUM_FENCE = createFence(STORAGE_ALUMINUM);

    public static final Block STEEL_SCAFFOLDING = createBlock(Material.ROCK, "steel_scaffolding");


    public static Block createBlock(Material material, String name){
        Block block = new Block(material)
                .setCreativeTab(OpenEngineering.CREATIVE_TAB)
                .setRegistryName(Tags.MOD_ID, name)
                .setTranslationKey(Tags.MOD_ID + "." + name);

        return block;
    }

    public static Block createBlockOre(Material material, String name, String oreName){
        Block block = createBlock(material, name);

        Registry.addOre(oreName, block.getRegistryName());

        return block;
    }

    public static Block createStairs(Block baseBlock) {
        String name = baseBlock.getRegistryName().getPath() + "_stairs";
        BlockStairs stairs = new BlockStairs(baseBlock.getDefaultState()) {
            {
                this.setCreativeTab(OpenEngineering.CREATIVE_TAB);
                this.setRegistryName(Tags.MOD_ID, name);
                this.setTranslationKey(Tags.MOD_ID + "." + name);
                this.useNeighborBrightness = true;
            }

            @Override
            public boolean doesSideBlockRendering(IBlockState state, IBlockAccess world, BlockPos pos, EnumFacing face) {
                return false;
            }
        };

        return stairs;
    }

    public static Block createFence(Block baseBlock) {
        final Material material = baseBlock.getDefaultState().getMaterial();
        final MapColor mapColor = material.getMaterialMapColor();
        String name = baseBlock.getRegistryName().getPath() + "_fence";

        Block fence = new BlockFence(material, mapColor) {
            {
                this.setCreativeTab(OpenEngineering.CREATIVE_TAB);
                this.setRegistryName(Tags.MOD_ID, name);
                this.setTranslationKey(Tags.MOD_ID + "." + name);
                this.useNeighborBrightness = true;
            }
        };

        return fence;
    }

    public static Block createSlab(Block baseBlock) {
        String name = baseBlock.getRegistryName().getPath() + "_slab";
        BlockSlab slab  = new BlockSlab( baseBlock.getDefaultState().getMaterial()) {
            {
                this.setCreativeTab(OpenEngineering.CREATIVE_TAB);
                this.setRegistryName(Tags.MOD_ID, name);
                this.setTranslationKey(Tags.MOD_ID + "." + name);
                this.setSoundType(SoundType.WOOD);
                this.useNeighborBrightness = true;
            }

            @Override
            public String getTranslationKey(int meta) {
                return "";
            }

            @Override
            public boolean isDouble() {
                return false;
            }

            @Override
            public IProperty<?> getVariantProperty() {
                return null;
            }

            @Override
            public Comparable<?> getTypeForItem(ItemStack stack) {
                return null;
            }
        };

        return slab;
    }


    public static void init() {
        Registry.addBlock(ORE_COPPER);
        Registry.addBlock(ORE_ALUMINUM);
        Registry.addBlock(ORE_LEAD);
        Registry.addBlock(ORE_SILVER);
        Registry.addBlock(ORE_NICKEL);
        Registry.addBlock(ORE_URANIUM);
        Registry.addBlock(STORAGE_COPPER);
        Registry.addBlock(STORAGE_ALUMINUM);
        Registry.addBlock(STORAGE_LEAD);
        //
        Registry.addBlock(STORAGE_SILVER);
        Registry.addBlock(STORAGE_NICKEL);
        Registry.addBlock(STORAGE_URANIUM);
        Registry.addBlock(STORAGE_CONSTANTAN);
        Registry.addBlock(STORAGE_ELECTRUM);
        Registry.addBlock(STORAGE_STEEL);
       // Registry.addBlock(STORAGE_COPPER_SLAB);
        //Registry.addBlock(STORAGE_ALUMINUM_SLAB);
        //Registry.addBlock(STORAGE_LEAD_SLAB);
        //
       //  Registry.addBlock(STORAGE_SILVER_SLAB);
        //Registry.addBlock(STORAGE_NICKEL_SLAB);
        //Registry.addBlock(STORAGE_URANIUM_SLAB);
        //Registry.addBlock(STORAGE_CONSTANTAN_SLAB);
        //Registry.addBlock(STORAGE_ELECTRUM_SLAB);
        //Registry.addBlock(STORAGE_STEEL_SLAB);
        Registry.addBlock(COKE_BRICK);
        Registry.addBlock(BLASTBRICK);
        Registry.addBlock(BLASTBRICK_REINFORCED);
        //
        Registry.addBlock(COKE);
        Registry.addBlock(HEMP_CRETE);
        Registry.addBlock(CONCRETE);
        Registry.addBlock(CONCRETE_TILE);
        Registry.addBlock(LEADED_CONCRETE);
        Registry.addBlock(INSULATED_GLASS);
        Registry.addBlock(ALLOY_KILN_BRICK);
     //   Registry.addBlock(COKE_BRICK_SLAB);
       // Registry.addBlock(BLASTBRICK_SLAB);
        //
        // Registry.addBlock(BLASTBRICK_REINFORCED_SLAB);
       // Registry.addBlock(HEMP_CRETE_SLAB);
        //Registry.addBlock(CONCRETE_SLAB);
        //Registry.addBlock(CONCRETE_TILE_SLAB);
        //Registry.addBlock(LEADED_CONCRETE_SLAB);
        //Registry.addBlock(ALLOY_KILN_BRICK_SLAB);
        Registry.addBlock(HEMP_CRETE_STAIRS);
        Registry.addBlock(CONCRETE_STAIRS);
        Registry.addBlock(CONCRETE_TILE_STAIRS);
        //
        Registry.addBlock(LEADED_CONCRETE_STAIRS);
        Registry.addBlock(CONCRETE_SHEET);
        Registry.addBlock(CONCRETE_PANEL);
        Registry.addBlock(CONCRETE_CHUNK);
        Registry.addBlock(TREATED_WOOD_PLANK);//horizontal
        Registry.addBlock(TREATED_WOOD_PLANK_VERTICAL);//vertical
        Registry.addBlock(TREATED_WOOD_PLANK_PACKAGED);//packaged
       // Registry.addBlock(TREATED_WOOD_PLANK_SLAB);//horizontal
        //Registry.addBlock(TREATED_WOOD_PLANK_SLAB);//vertical
        //
        //Registry.addBlock(TREATED_WOOD_PLANK_SLAB);//packaged
        Registry.addBlock(TREATED_WOOD_PLANK_STAIRS);//horizontal
        Registry.addBlock(TREATED_WOOD_PLANK_VERTICAL_STAIRS);//vertical
        Registry.addBlock(TREATED_WOOD_PLANK_PACKAGED_STAIRS);//packaged
        Registry.addBlock(TREATED_WOOD_FENCE);

        Registry.addBlock(JUMP_CUSHION);

        Registry.addBlock(SHEETMETAL_COPPER);
        Registry.addBlock(SHEETMETAL_ALUMINUM);
        Registry.addBlock(SHEETMETAL_LEAD);
        Registry.addBlock(SHEETMETAL_SILVER);
        Registry.addBlock(SHEETMETAL_NICKEL);
        Registry.addBlock(SHEETMETAL_URANIUM);
        Registry.addBlock(SHEETMETAL_CONSTANTAN);
        Registry.addBlock(SHEETMETAL_ELECTRUM);
        Registry.addBlock(SHEETMETAL_STEEL);
        Registry.addBlock(SHEETMETAL_IRON);
        Registry.addBlock(SHEETMETAL_GOLD);

        Registry.addBlock(COIL_COPPER);
        Registry.addBlock(COIL_ELECTRUM);
        Registry.addBlock(COIL_HV);

        Registry.addBlock(REDSTONE_ENG);
        Registry.addBlock(LIGHT_ENG);
        Registry.addBlock(HEAVY_ENG);

        Registry.addBlock(GENERATOR);
        Registry.addBlock(RADIATOR);

        Registry.addBlock(STEEL_FENCE);
        Registry.addBlock(ALUMINUM_FENCE);

        Registry.addBlock(STEEL_SCAFFOLDING);




    }
}