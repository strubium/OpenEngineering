package com.strubium.openengie.core.blocks.alloy;

import com.strubium.immersiveengineering.Tags;
import com.strubium.openengie.OpenEngineering;
import com.strubium.openengie.core.ModBlocks;
import com.strubium.openengie.core.multi.Multiblock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

public class BlockAlloyBrick extends Block {

    // A 2x2x2 multiblock where every component must be *this* block
    private final Multiblock alloyKilnMultiblock;

    public BlockAlloyBrick() {
        super(Material.ROCK);
        setCreativeTab(OpenEngineering.CREATIVE_TAB);
        setRegistryName(Tags.MOD_ID, "stone_decoration_alloybrick");
        setTranslationKey(Tags.MOD_ID + ".stone_decoration_alloybrick");
        setSoundType(SoundType.STONE);
        setHardness(2.0F);
        setResistance(10.0F);

        // create a multiblock matcher that requires the block at each position to be this block instance
        this.alloyKilnMultiblock = new Multiblock(2, 2, 2, state -> state.getBlock() == this);
    }

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state,
                                    EntityPlayer player, EnumHand hand,
                                    EnumFacing facing, float hitX, float hitY, float hitZ) {
        if (!world.isRemote) {
            boolean formed = alloyKilnMultiblock.tryForm(world, pos,
                    ModBlocks.ALLOY_KILN_FORMED.getDefaultState(), 3);
            if (formed) {
                player.sendMessage(new TextComponentString("Alloy Kiln formed!"));
            } else {
                player.sendMessage(new TextComponentString("Nah"));
            }
        }
        return true;
    }
}
