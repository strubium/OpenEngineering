package com.strubium.openengie.core.blocks.alloy;

import com.strubium.openengie.Tags;
import com.strubium.openengie.core.multi.MultiblockPart;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.IBlockState;

public class BlockAlloyKilnFormed extends Block {

    public static final PropertyEnum<MultiblockPart> PART =
            PropertyEnum.create("part", MultiblockPart.class);

    public BlockAlloyKilnFormed() {
        super(Material.ROCK);

        setRegistryName(Tags.MOD_ID, "alloy_kiln_formed");
        setTranslationKey(Tags.MOD_ID + "." + "alloy_kiln_formed");

        setHardness(3.0F).setResistance(15.0F);

        setDefaultState(blockState.getBaseState()
                .withProperty(PART, MultiblockPart.INTERIOR));
    }

    @Override
    protected net.minecraft.block.state.BlockStateContainer createBlockState() {
        return new net.minecraft.block.state.BlockStateContainer(this, PART);
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return state.getValue(PART).ordinal();
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {
        return getDefaultState()
                .withProperty(PART, MultiblockPart.values()[meta]);
    }

    @Override
    public boolean hasTileEntity(IBlockState state) {
        return true;
    }
}