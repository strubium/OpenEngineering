package com.strubium.openengie.core.blocks.alloy;

import com.strubium.openengie.core.ModItems;
import com.strubium.openengie.core.blocks.BaseOpenEngieBlock;
import com.strubium.openengie.core.multi.Multiblock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

public class BlockAlloyBrick extends BaseOpenEngieBlock {

    // A 2x2x2 multiblock where every component must be *this* block
    private final Multiblock alloyKilnMultiblock;

    public BlockAlloyBrick() {
        super(Material.ROCK, "alloy_kiln_brick");

        setSoundType(SoundType.STONE);
        setHardness(2.0F);
        setResistance(10.0F);

        // create a multiblock matcher that requires the block at each position to be this block instance
        this.alloyKilnMultiblock = new Multiblock(2, 2, 2,  state -> state.getBlock() == this);

        setDefaultState( this.blockState.getBaseState() .withProperty(IS_FORMED, false) );

    }

    public static final PropertyBool IS_FORMED = PropertyBool.create("is_formed");

    @Override
    protected net.minecraft.block.state.BlockStateContainer createBlockState() {
        return new net.minecraft.block.state.BlockStateContainer( this, IS_FORMED );
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return state.getValue(IS_FORMED) ? 1 : 0;
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {
        return getDefaultState() .withProperty(IS_FORMED, meta == 1);
    }

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state,
                                    EntityPlayer player, EnumHand hand,
                                    EnumFacing facing, float hitX, float hitY, float hitZ) {
        ItemStack held = player.getHeldItem(hand); // get the item in the player's hand

        // Check if the player is holding the hammer
        if (!held.isEmpty() && held.getItem() == ModItems.TOOL_HAMMER) {
            if (!world.isRemote) {
                if(!state.getValue(IS_FORMED)){
                    boolean formed = alloyKilnMultiblock.canForm(world, pos, player.getHorizontalFacing());
                    if (formed) {
                        world.setBlockState( pos, state.withProperty(IS_FORMED, true) );
                        player.sendMessage(new TextComponentString("Alloy Kiln formed!"));
                    } else {
                        player.sendMessage(new TextComponentString("Incorrect Placement"));
                    }
                }
            }
            return true;
        }


        // Return false to allow normal block placement or other interaction
        return false;
    }
}
