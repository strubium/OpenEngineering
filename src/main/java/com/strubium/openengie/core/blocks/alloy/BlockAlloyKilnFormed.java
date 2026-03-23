package com.strubium.openengie.core.blocks.alloy;

import com.strubium.openengie.Tags;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockAlloyKilnFormed extends Block {
    public BlockAlloyKilnFormed() {
        super(Material.ROCK);
        setRegistryName(Tags.MOD_ID, "alloy_kiln_formed");
        setTranslationKey(Tags.MOD_ID + ".alloy_kiln_formed");
        setHardness(3.0F).setResistance(15.0F);
    }
}
