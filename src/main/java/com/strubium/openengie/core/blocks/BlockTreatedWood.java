package com.strubium.openengie.core.blocks;

import com.strubium.immersiveengineering.Tags;
import com.strubium.openengie.OpenEngineering;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class BlockTreatedWood extends Block {

    public BlockTreatedWood() {
        super(Material.WOOD);
        setCreativeTab(OpenEngineering.CREATIVE_TAB);
        setRegistryName(Tags.MOD_ID, "treated_wood");
        setTranslationKey(Tags.MOD_ID + ".treated_wood");
        setSoundType(SoundType.WOOD);
    }
}
