package com.strubium.openengie.core.blocks.alloy;

import com.strubium.immersiveengineering.Tags;
import com.strubium.openengie.OpenEngineering;
import com.strubium.openengie.core.ModBlocks;
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

    public BlockAlloyBrick() {
        super(Material.ROCK);
        setCreativeTab(OpenEngineering.CREATIVE_TAB);
        setRegistryName(Tags.MOD_ID, "stone_decoration_alloybrick");
        setTranslationKey(Tags.MOD_ID + ".stone_decoration_alloybrick");
        setSoundType(SoundType.STONE);
        setHardness(2.0F);
        setResistance(10.0F);
    }

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state,
                                    EntityPlayer player, EnumHand hand,
                                    EnumFacing facing, float hitX, float hitY, float hitZ) {
        if (!world.isRemote) {
            if (tryFormMultiblock(world, pos)) {
                player.sendMessage(new TextComponentString("Alloy Kiln formed!"));
            } else {
                player.sendMessage(new TextComponentString("Nah"));
            }
        }
        return true;
    }

    private boolean tryFormMultiblock(World world, BlockPos clickedPos) {
        // Try all 4 rotations and all possible 2x2x2 placements that include clickedPos
        for (EnumFacing facing : EnumFacing.Plane.HORIZONTAL) {
            for (int offX = -1; offX <= 0; offX++) {
                for (int offZ = -1; offZ <= 0; offZ++) {
                    for (int offY = -1; offY <= 0; offY++) {
                        BlockPos candidateBase = clickedPos.add(offX, offY, offZ);
                        if (structureMatches(world, candidateBase, facing)) {
                            IBlockState formedState = ModBlocks.ALLOY_KILN_FORMED.getDefaultState();
                            fillStructure(world, candidateBase, facing, formedState);
                            System.out.println("[OpenEngineering] Valid 2x2x2 multiblock found at base: " + candidateBase + " facing " + facing);
                            return true;
                        }
                    }
                }
            }
        }
        System.out.println("[OpenEngineering] Could not find valid 2x2x2 multiblock including " + clickedPos);
        return false;
    }

    private boolean structureMatches(World world, BlockPos base, EnumFacing facing) {
        EnumFacing right = facing.rotateY();
        for (int x = 0; x < 2; x++) {
            for (int z = 0; z < 2; z++) {
                for (int y = 0; y < 2; y++) {
                    BlockPos checkPos = base.offset(facing, z).offset(right, x).up(y);
                    if (world.getBlockState(checkPos).getBlock() != this) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private void fillStructure(World world, BlockPos base, EnumFacing facing, IBlockState state) {
        EnumFacing right = facing.rotateY();
        for (int x = 0; x < 2; x++) {
            for (int z = 0; z < 2; z++) {
                for (int y = 0; y < 2; y++) {
                    BlockPos placePos = base.offset(facing, z).offset(right, x).up(y);
                    world.setBlockState(placePos, state, 3);
                }
            }
        }
    }
}
