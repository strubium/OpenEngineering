package com.strubium.openengie.core.blocks.alloy;

import com.strubium.openengie.core.blocks.BaseOpenEngieBlock;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockAlloyKilnFormed extends BaseOpenEngieBlock {
    public BlockAlloyKilnFormed() {
        super(Material.ROCK, "alloy_kiln_formed");

        setHardness(3.0F).setResistance(15.0F);
    }

    @Override
    public boolean hasTileEntity(IBlockState state) {
        return true;
    }

    @Override
    public TileEntity createTileEntity(World world, IBlockState state) {
        return new TileAlloyKiln();
    }
}
