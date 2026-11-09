package com.strubium.openengie.config;

import com.strubium.openengie.Tags;
import net.minecraftforge.common.config.Config;

@Config(modid = Tags.MOD_ID, name = Tags.MOD_NAME)
public class ModConfig {

    @Config.Comment("Configs about World Gen")
    public static WorldGen worldGen = new WorldGen();

    public static class WorldGen {

        @Config.Comment("Copper Ore Generation Settings")
        public OreConfig copper = new OreConfig(10, 9, 2, 110);

        @Config.Comment("Aluminum Ore Generation Settings")
        public OreConfig aluminum = new OreConfig(10, 13, 5, 90);

        @Config.Comment("Lead Ore Generation Settings")
        public OreConfig lead = new OreConfig(10, 9, 2, 80);

        @Config.Comment("Nickel Ore Generation Settings")
        public OreConfig nickel = new OreConfig(10, 9, 2, 80);

        @Config.Comment("Uranium Ore Generation Settings")
        public OreConfig uranium = new OreConfig(10, 9, 2, 80);

        @Config.Comment("Silver Ore Generation Settings")
        public OreConfig silver = new OreConfig(10, 9, 2, 80);

        public static class OreConfig {
            @Config.RangeInt(min = 0, max = 50)
            @Config.Comment("Number of spawn attempts per chunk.")
            public int spawnsPerChunk;

            @Config.RangeInt(min = 1, max = 64)
            @Config.Comment("Maximum size of the ore vein.")
            public int maxVeinSize;

            @Config.RangeInt(min = 0, max = 255)
            @Config.Comment("Minimum Y level for generation.")
            public int minY;

            @Config.RangeInt(min = 0, max = 255)
            @Config.Comment("Maximum Y level for generation.")
            public int maxY;

            public OreConfig(int spawnsPerChunk, int maxVeinSize, int minY, int maxY) {
                this.spawnsPerChunk = spawnsPerChunk;
                this.maxVeinSize = maxVeinSize;
                this.minY = minY;
                this.maxY = maxY;
            }
        }
    }
}