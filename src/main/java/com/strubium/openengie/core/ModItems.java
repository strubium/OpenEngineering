package com.strubium.openengie.core;

import com.strubium.immersiveengineering.Tags;
import com.strubium.openengie.OpenEngineering;
import com.strubium.openengie.core.blocks.BlockTreatedWood;
import com.strubium.openengie.core.blocks.alloy.BlockAlloyBrick;
import com.strubium.openengie.core.blocks.alloy.BlockAlloyKilnFormed;
import net.minecraft.item.Item;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;



public class ModItems {
    public static final Item TOOL_HAMMER = new Item()
            .setCreativeTab(OpenEngineering.CREATIVE_TAB)
            .setRegistryName(Tags.MOD_ID, "tool_hammer")
            .setTranslationKey(Tags.MOD_ID + ".tool_hammer");





    public static void init() {
        Registry.addItem(TOOL_HAMMER);
    }
}
