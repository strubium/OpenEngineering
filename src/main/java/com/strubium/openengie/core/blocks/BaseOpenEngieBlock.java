package com.strubium.openengie.core.blocks;

import com.strubium.openengie.Tags;
import com.strubium.openengie.OpenEngineering;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class BaseOpenEngieBlock extends Block {

    public BaseOpenEngieBlock(Material material, String blockName) {
        super(material);

        setCreativeTab(OpenEngineering.CREATIVE_TAB);
        setRegistryName(Tags.MOD_ID, blockName);
        setTranslationKey(Tags.MOD_ID + "." + blockName);
        setSoundType(SoundType.WOOD);
    }
}
