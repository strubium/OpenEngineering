package com.strubium.openengie.core.multi;

import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.function.Predicate;

/**
 * Generic rectangular multiblock helper.
 *
 * Coordinate system:
 *  - widthX : number of blocks along the "right" direction (rotateY of facing)
 *  - depthZ : number of blocks along the "forward" direction (facing)
 *  - heightY: number of blocks upward
 *
 * The helper will:
 *  - search for any valid placement that includes the clickedPos (all offsets that place a sizeX*sizeY*sizeZ box
 *    such that clickedPos is inside it),
 *  - try all horizontal facings (N/S/E/W),
 *  - optionally fill the structure with a provided IBlockState.
 */
public class Multiblock {
    private final int sizeX; // right
    private final int sizeY; // up
    private final int sizeZ; // forward
    private final Predicate<IBlockState> validator;

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
     * @param formedState the state to place when forming the multiblock
     * @param flags world.setBlockState flags (e.g. 3)
     * @return true if a multiblock was formed
     */
    public boolean tryForm(World world, BlockPos clickedPos, IBlockState formedState, int flags) {
        Match match = findMatch(world, clickedPos);
        if (match != null) {
            fillStructure(world, match.base, match.facing, formedState, flags);
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
        // Iterate all horizontal facings
        for (EnumFacing facing : EnumFacing.Plane.HORIZONTAL) {
            // Offsets to shift the base such that clickedPos is somewhere inside the box.
            // For a dimension N we need offsets from -(N-1) .. 0 (inclusive)
            for (int offX = -(sizeX - 1); offX <= 0; offX++) {
                for (int offZ = -(sizeZ - 1); offZ <= 0; offZ++) {
                    for (int offY = -(sizeY - 1); offY <= 0; offY++) {
                        BlockPos candidateBase = clickedPos.add(offX, offY, offZ);
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
                    world.setBlockState(placePos, state, flags);
                }
            }
        }
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
