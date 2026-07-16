package com.strubium.openengie.core.multi;

import com.strubium.openengie.core.blocks.alloy.BlockAlloyKilnFormed;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.block.Block;


import java.util.function.Predicate;

/**
 * Generic rectangular multiblock helper.
 *
 * Coordinate system:
 *  - widthX : number of blocks along the "right" direction (rotateY of facing)
 *  - depthZ : number of blocks along the "forward" direction (facing)
 *  - heightY: number of blocks upward
 */
public class Multiblock {
    private final int sizeX; // right
    private final int sizeY; // up
    private final int sizeZ; // forward
    private final Predicate<IBlockState> validator;
    private EnumFacing frontSide = EnumFacing.NORTH;

    /**
     * @param sizeX number of blocks along right (x) axis (>=1)
     * @param sizeY number of blocks along up (y) axis (>=1)
     * @param sizeZ number of blocks along forward (z) axis (>=1)
     * @param validator predicate that returns true for a valid "component" block at a position
     */
    public Multiblock(int sizeX, int sizeY, int sizeZ, Predicate<IBlockState> validator) {
        if (sizeX < 1 || sizeY < 1 || sizeZ < 1) {
            throw new IllegalArgumentException("All dimensions must be >= 1");
        }
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.sizeZ = sizeZ;
        this.validator = validator;
    }

    /**
     * Attempts to find a valid placement that includes clickedPos, and if found fills it with the given state.
     *
     * @param world the world
     * @param clickedPos the position the player clicked (must be inside the candidate box)
     * @param flags world.setBlockState flags (e.g. 3)
     * @return true if a multiblock was formed
     */
    public boolean tryForm(World world, BlockPos clickedPos, Block formedBlock, EnumFacing playerFacing, int flags) {

        Match match = findMatch(world, clickedPos);

        if (playerFacing == null) {
            throw new IllegalStateException("playerFacing is null");
        }

        frontSide = playerFacing.getOpposite();

        if (match != null) {
            if (formedBlock == null) {
                throw new IllegalStateException("formedBlock is null");
            }

            fillStructure(
                    world,
                    match.base,
                    match.facing,
                    formedBlock.getDefaultState(),
                    flags
            );

            return true;
        }

        return false;
    }

    /**
     * Searches for a match that includes clickedPos.
     *
     * @return Match with base and facing, or null if none found.
     */
    public Match findMatch(World world, BlockPos clickedPos) {
        for (EnumFacing facing : EnumFacing.Plane.HORIZONTAL) {
            EnumFacing right = facing.rotateY();

            for (int offX = -(sizeX - 1); offX <= 0; offX++) {
                for (int offZ = -(sizeZ - 1); offZ <= 0; offZ++) {
                    for (int offY = -(sizeY - 1); offY <= 0; offY++) {

                        BlockPos candidateBase = clickedPos
                                .offset(right, offX)
                                .offset(facing, offZ)
                                .up(offY);

                        if (structureMatches(world, candidateBase, facing)) {
                            return new Match(candidateBase, facing);
                        }
                    }
                }
            }
        }

        return null;
    }

    /** Returns true if the entire box at base with given facing passes the validator. */
    public boolean structureMatches(World world, BlockPos base, EnumFacing facing) {
        EnumFacing right = facing.rotateY();
        for (int x = 0; x < sizeX; x++) {
            for (int z = 0; z < sizeZ; z++) {
                for (int y = 0; y < sizeY; y++) {
                    BlockPos checkPos = base.offset(facing, z).offset(right, x).up(y);
                    IBlockState state = world.getBlockState(checkPos);
                    if (!validator.test(state)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    /** Fill the box with the given state. */
    public void fillStructure(World world, BlockPos base, EnumFacing facing, IBlockState state, int flags) {
        EnumFacing right = facing.rotateY();
        for (int x = 0; x < sizeX; x++) {
            for (int z = 0; z < sizeZ; z++) {
                for (int y = 0; y < sizeY; y++) {
                    BlockPos placePos = base.offset(facing, z).offset(right, x).up(y);
                    IBlockState placedState;

                    MultiblockPart part = getPart(x, y, z);
                    placedState = state.withProperty(BlockAlloyKilnFormed.PART, part);


                    world.setBlockState(placePos, placedState, flags);                }
            }
        }
    }

    private MultiblockPart getPart(int x, int y, int z) {

        boolean bottom = y == 0;
        boolean top = y == sizeY - 1;

        boolean front = z == 0;
        boolean back = z == sizeZ - 1;

        boolean left = x == 0;
        boolean right = x == sizeX - 1;

        if (bottom || top) {
            if (front && left)
                return bottom ? MultiblockPart.FRONT_LEFT_BOTTOM : MultiblockPart.FRONT_LEFT_TOP;

            if (front && right)
                return bottom ? MultiblockPart.FRONT_RIGHT_BOTTOM : MultiblockPart.FRONT_RIGHT_TOP;

            if (back && left)
                return bottom ? MultiblockPart.BACK_LEFT_BOTTOM : MultiblockPart.BACK_LEFT_TOP;

            if (back && right)
                return bottom ? MultiblockPart.BACK_RIGHT_BOTTOM : MultiblockPart.BACK_RIGHT_TOP;
        }

        return MultiblockPart.INTERIOR;
    }

    /** Small holder for a successful match. */
    public static class Match {
        public final BlockPos base;
        public final EnumFacing facing;

        public Match(BlockPos base, EnumFacing facing) {
            this.base = base;
            this.facing = facing;
        }
    }
}
