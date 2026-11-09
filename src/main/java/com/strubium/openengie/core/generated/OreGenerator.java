package com.strubium.openengie.core.generated;

import com.strubium.openengie.config.ModConfig;
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

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
        if (world.provider.getDimension() != 0) {
            return;
        }

        int x = chunkX * 16;
        int z = chunkZ * 16;

        generateOre(ModBlocks.ORE_COPPER, ModConfig.worldGen.copper, world, random, x, z);
        generateOre(ModBlocks.ORE_ALUMINUM, ModConfig.worldGen.aluminum, world, random, x, z);
        generateOre(ModBlocks.ORE_LEAD, ModConfig.worldGen.lead, world, random, x, z);
        generateOre(ModBlocks.ORE_NICKEL, ModConfig.worldGen.nickel, world, random, x, z);
        generateOre(ModBlocks.ORE_URANIUM, ModConfig.worldGen.uranium, world, random, x, z);
        generateOre(ModBlocks.ORE_SILVER, ModConfig.worldGen.silver, world, random, x, z);
    }

    private void generateOre(Block block, ModConfig.WorldGen.OreConfig config, World world, Random random, int blockXPos, int blockZPos) {
        int maxX = 16;
        int maxZ = 16;

        int diffBetweenMinMaxY = config.maxY - config.minY;
        if (diffBetweenMinMaxY <= 0) return;

        for (int i = 0; i < config.spawnsPerChunk; i++) {
            int posX = blockXPos + random.nextInt(maxX);
            int posY = config.minY + random.nextInt(diffBetweenMinMaxY);
            int posZ = blockZPos + random.nextInt(maxZ);

            new WorldGenMinable(block.getDefaultState(), config.maxVeinSize).generate(world, random, new BlockPos(posX, posY, posZ));
        }
    }
}