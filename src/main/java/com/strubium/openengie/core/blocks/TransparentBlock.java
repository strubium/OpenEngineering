package com.strubium.openengie.core.blocks;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockRenderLayer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class TransparentBlock extends BaseOpenEngieBlock {

    private BlockRenderLayer renderLayer = BlockRenderLayer.CUTOUT;

    public TransparentBlock(Material material, String blockName) {
        super(material, blockName);
    }

    public TransparentBlock(Material material, String blockName, BlockRenderLayer renderLayer) {
        super(material, blockName);

        this.renderLayer = renderLayer;
    }

    @Override
    public boolean isFullCube(IBlockState state) {
        return false;
    }

    @Override
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }


    @Override
    @SideOnly(Side.CLIENT)
    public BlockRenderLayer getRenderLayer() {
        return renderLayer;
    }
}
