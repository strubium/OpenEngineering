package com.strubium.openengie.core.blocks.chute;

import com.strubium.openengie.Tags;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.List;

public class BlockChute extends Block {

    private final Block base;

    protected static final double THICKNESS = 0.125;

    protected static final AxisAlignedBB FULL_BOX = new AxisAlignedBB(
            0, 0, 0,
            1, 1, 1
    );

    public BlockChute(Block base, String name) {
        super(base.getDefaultState().getMaterial());

        this.base = base;

        this.setRegistryName(base.getRegistryName().getNamespace(), name);
        this.setTranslationKey(Tags.MOD_ID + "." + name);

        this.setCreativeTab(base.getCreativeTab());

        // Copy feel from base block
        this.setHardness(base.getBlockHardness(base.getDefaultState(), null, null));
        this.setResistance(base.getExplosionResistance(null));
        this.setSoundType(base.getSoundType());

        this.useNeighborBrightness = true;
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
    public EnumBlockRenderType getRenderType(IBlockState state) {
        return EnumBlockRenderType.MODEL;
    }

    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess world, BlockPos pos) {
        return FULL_BOX;
    }

    @Override
    public void addCollisionBoxToList(IBlockState state, World worldIn, BlockPos pos,
                                      AxisAlignedBB entityBox, List<AxisAlignedBB> collidingBoxes,
                                      Entity entityIn, boolean isActualState) {

        // NORTH wall
        addCollisionBoxToList(pos, entityBox, collidingBoxes,
                new AxisAlignedBB(0, 0, 0, 1, 1, THICKNESS));

        // SOUTH wall
        addCollisionBoxToList(pos, entityBox, collidingBoxes,
                new AxisAlignedBB(0, 0, 1 - THICKNESS, 1, 1, 1));

        // WEST wall
        addCollisionBoxToList(pos, entityBox, collidingBoxes,
                new AxisAlignedBB(0, 0, 0, THICKNESS, 1, 1));

        // EAST wall
        addCollisionBoxToList(pos, entityBox, collidingBoxes,
                new AxisAlignedBB(1 - THICKNESS, 0, 0, 1, 1, 1));
    }

    @Override
    public boolean causesSuffocation(IBlockState state) {
        return false;
    }

    @Override
    public boolean isTopSolid(IBlockState state) {
        return false;
    }
}
