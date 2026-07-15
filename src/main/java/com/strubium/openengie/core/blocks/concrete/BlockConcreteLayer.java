package com.strubium.openengie.core.blocks.concrete;

import com.strubium.openengie.core.blocks.BaseOpenEngieBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockConcreteLayer extends BaseOpenEngieBlock {

    public static final PropertyInteger LAYERS = PropertyInteger.create("layers", 1, 8);

    private static final AxisAlignedBB[] LAYER_AABB = new AxisAlignedBB[] {
            null,
            new AxisAlignedBB(0, 0, 0, 1, 0.125, 1), // 1 layer
            new AxisAlignedBB(0, 0, 0, 1, 0.250, 1), // 2 layers
            new AxisAlignedBB(0, 0, 0, 1, 0.375, 1), // 3 layers
            new AxisAlignedBB(0, 0, 0, 1, 0.500, 1), // 4 layers
            new AxisAlignedBB(0, 0, 0, 1, 0.625, 1), // 5 layers
            new AxisAlignedBB(0, 0, 0, 1, 0.750, 1), // 6 layers
            new AxisAlignedBB(0, 0, 0, 1, 0.875, 1), // 7 layers
            Block.FULL_BLOCK_AABB  // 8 layers (full block)
    };


    public BlockConcreteLayer(Material material, String blockName) {
        super(material, blockName);

        setDefaultState(blockState.getBaseState().withProperty(LAYERS, 1));

        setHardness(1.5F);
        setResistance(10F);
    }


    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, LAYERS);
    }


    @Override
    public IBlockState getStateFromMeta(int meta) {
        return getDefaultState().withProperty(LAYERS, meta + 1);
    }


    @Override
    public int getMetaFromState(IBlockState state) {
        return state.getValue(LAYERS) - 1;
    }


    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state,
                                        IBlockAccess source,
                                        BlockPos pos) {
        return LAYER_AABB[state.getValue(LAYERS)];
    }


    @Override
    public boolean isFullCube(IBlockState state) {
        return state.getValue(LAYERS) == 8;
    }


    @Override
    public boolean isOpaqueCube(IBlockState state) {
        return state.getValue(LAYERS) == 8;
    }


    @Override
    public boolean isTopSolid(IBlockState state) {
        return state.getValue(LAYERS) == 8;
    }


    public static int getLayerHeight(IBlockState state) {
        return state.getValue(LAYERS);
    }

    @Override
    public boolean onBlockActivated(World worldIn,
                                    BlockPos pos,
                                    IBlockState state,
                                    EntityPlayer playerIn,
                                    EnumHand hand,
                                    EnumFacing facing,
                                    float hitX,
                                    float hitY,
                                    float hitZ) {

        ItemStack heldItem = playerIn.getHeldItem(hand);

        // Only grow when holding this block
        if (heldItem.getItem() == Item.getItemFromBlock(this)) {

            int layers = getLayerHeight(state);

            // Already full
            if (layers >= 8) {
                return false;
            }

            if (!worldIn.isRemote) {

                // Increase layer count
                worldIn.setBlockState(
                        pos,
                        state.withProperty(LAYERS, layers + 1),
                        3
                );

                // Consume item unless creative
                if (!playerIn.capabilities.isCreativeMode) {
                    heldItem.shrink(1);
                }
            }

            return true;
        }

        return false;
    }

}