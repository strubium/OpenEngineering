package com.strubium.openengie.core.blocks.treated;

import com.strubium.immersiveengineering.Tags;
import com.strubium.openengie.OpenEngineering;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class BlockTreatedWoodSlab extends BlockSlab {


    private final boolean isDouble;

    public BlockTreatedWoodSlab(boolean isDouble) {
        super(Material.WOOD);

        this.isDouble = isDouble;
        this.setCreativeTab(OpenEngineering.CREATIVE_TAB);
        this.setRegistryName(Tags.MOD_ID, isDouble ? "treated_wood_slab" + "_double" : "treated_wood_slab");
        this.setTranslationKey(Tags.MOD_ID + "." + "treated_wood_slab");
        this.setSoundType(SoundType.WOOD);

        this.useNeighborBrightness = true;

        if (isDouble) {
            this.fullBlock = true;
        }
    }

    @Override
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }

    @Override
    public boolean isFullCube(IBlockState state) {
        return false;
    }

    @Override
    public String getTranslationKey(int meta) {
        return super.getTranslationKey();
    }

    @Override
    protected BlockStateContainer createBlockState() {
        if (this.isDouble()) {
            return new BlockStateContainer(this); // double slabs have no HALF
        } else {
            return new BlockStateContainer(this, HALF);
        }
    }


    @Override
    public boolean doesSideBlockRendering(IBlockState state, IBlockAccess world, BlockPos pos, net.minecraft.util.EnumFacing face) {
        return false;
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {
        IBlockState state = this.getDefaultState();
        if (!this.isDouble()) {
            state = state.withProperty(HALF, (meta == 0) ? BlockSlab.EnumBlockHalf.BOTTOM : BlockSlab.EnumBlockHalf.TOP);
        }
        return state;
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        if (!this.isDouble()) {
            return state.getValue(HALF) == BlockSlab.EnumBlockHalf.BOTTOM ? 0 : 1;
        }
        return 0;
    }

    @Override
    public boolean isDouble() {
        return this.isDouble;
    }

    @Override
    public IProperty<?> getVariantProperty() {
        return null;
    }

    @Override
    public Comparable<?> getTypeForItem(ItemStack stack) {
        return null;
    }
}
