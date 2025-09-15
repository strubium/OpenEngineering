package com.strubium.openengie.core.blocks.treated;

import com.strubium.immersiveengineering.Tags;
import com.strubium.openengie.OpenEngineering;
import net.minecraft.block.Block;
import net.minecraft.block.BlockStairs;
import net.minecraft.block.SoundType;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class BlockTreatedWoodStairs extends BlockStairs {

    public BlockTreatedWoodStairs(Block baseBlock) {
        super(baseBlock.getDefaultState());

        // Copy important properties
        this.setCreativeTab(OpenEngineering.CREATIVE_TAB);
        this.setRegistryName(Tags.MOD_ID, "treated_wood_stairs");
        this.setTranslationKey(Tags.MOD_ID + ".treated_wood_stairs");
        this.setSoundType(SoundType.WOOD);

        // Optional: make sure it’s treated as solid for rendering
        this.useNeighborBrightness = true;
    }

    @Override
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }

    @Override
    public boolean isFullCube(IBlockState state) {
        return false;
    }

    // Ensure neighboring blocks render correctly
    @Override
    public boolean doesSideBlockRendering(IBlockState state, IBlockAccess world, BlockPos pos, EnumFacing face) {
        return false;
    }
}
