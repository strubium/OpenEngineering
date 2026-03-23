package com.strubium.openengie.core.blocks.treated;

import com.strubium.openengie.Tags;
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

        this.setCreativeTab(OpenEngineering.CREATIVE_TAB);
        this.setRegistryName(Tags.MOD_ID, "treated_wood_stairs");
        this.setTranslationKey(Tags.MOD_ID + ".treated_wood_stairs");
        this.setSoundType(SoundType.WOOD);

        this.useNeighborBrightness = true;
    }

    @Override
    public boolean doesSideBlockRendering(IBlockState state, IBlockAccess world, BlockPos pos, EnumFacing face) {
        return false;
    }
}
