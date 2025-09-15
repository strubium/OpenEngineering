package com.strubium.openengie.core.generated;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;
import com.strubium.openengie.core.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.world.gen.feature.WorldGenMinable;
import java.util.Random;

public class OreGenerator implements IWorldGenerator {
    public static final int copperSpawnsPerChunk = 10;
    public static final int aluminumSpawnsPerChunk = 10;
    public static final int leadSpawnsPerChunk = 10;
    public static final int nickelSpawnsPerChunk = 10;
    public static final int uraniumSpawnsPerChunk = 10;
    public static final int silverSpawnsPerChunk = 10;


    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
        if (world.provider.getDimension() != 0) {
            return;
        }

        int x = chunkX * 16;
        int z = chunkZ * 16;

        addOreSpawn(ModBlocks.ORE_COPPER, world, copperSpawnsPerChunk, random, x, z, 9, 9, 6 + random.nextInt(4), 2, 110);

        addOreSpawn(ModBlocks.ORE_ALUMINUM, world,aluminumSpawnsPerChunk, random, x, z, 13, 13, 6 + random.nextInt(7), 5, 90);

        addOreSpawn(ModBlocks.ORE_LEAD, world,leadSpawnsPerChunk, random, x, z, 9, 9, 6 + random.nextInt(4), 2, 80);

        addOreSpawn(ModBlocks.ORE_NICKEL, world, nickelSpawnsPerChunk, random, x, z, 9, 9, 6 + random.nextInt(4), 2, 80);

        addOreSpawn(ModBlocks.ORE_URANIUM, world, uraniumSpawnsPerChunk, random, x, z, 9, 9, 6 + random.nextInt(4), 2, 80);

        addOreSpawn(ModBlocks.ORE_SILVER, world, silverSpawnsPerChunk, random, x, z, 9, 9, 6 + random.nextInt(4), 2, 80);
    }

    public void addOreSpawn(Block block, World world, int chancesToSpawn, Random random, int blockXPos, int blockZPos, int maxX, int maxZ, int maxVeinSize, int minY, int maxY) {

        int diffBetweenMinMaxY = maxY - minY;

        for (int x = 0; x < chancesToSpawn; x++) {
            int posX = blockXPos + random.nextInt(maxX);
            int posY = minY + random.nextInt(diffBetweenMinMaxY);
            int posZ = blockZPos + random.nextInt(maxZ);

            new WorldGenMinable(block.getDefaultState(), maxVeinSize).generate(world, random, new BlockPos(posX, posY, posZ));
        }
    }
}