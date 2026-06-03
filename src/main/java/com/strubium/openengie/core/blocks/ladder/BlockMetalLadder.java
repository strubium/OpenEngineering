package com.strubium.openengie.core.blocks.ladder;

import com.strubium.openengie.OpenEngineering;
import com.strubium.openengie.Tags;
import net.minecraft.block.BlockLadder;

public class BlockMetalLadder extends BlockLadder {

    public BlockMetalLadder() {
        setCreativeTab(OpenEngineering.CREATIVE_TAB);
        setRegistryName(Tags.MOD_ID, "steel_ladder");
        setTranslationKey(Tags.MOD_ID + ".steel_ladder");

        setHardness(3.0F);
        setResistance(10.0F);
    }
}