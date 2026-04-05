package com.strubium.openengie.core;

import com.strubium.openengie.Tags;
import com.strubium.openengie.OpenEngineering;
import com.strubium.openengie.core.registry.Registry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;


public class ModItems {
    public static final Item TOOL_HAMMER = createItem("tool_hammer");

    public static final Item TOOL_WIRECUTTERS = createItem("tool_wirecutters");

    public static final Item INGOT_ALUMINUM = createItem("aluminum_ingot");

    public static final Item INGOT_COPPER = createItem("copper_ingot");

    public static final Item INGOT_LEAD = createItem("lead_ingot");

    public static final Item INGOT_NICKEL = createItem("nickel_ingot");

    public static final Item INGOT_SILVER = createItem("silver_ingot");

    public static final Item INGOT_URANIUM = createItem("uranium_ingot");

    public static Item createItem(String name){
        Item item = new Item()
                .setCreativeTab(OpenEngineering.CREATIVE_TAB)
                .setRegistryName(Tags.MOD_ID, name)
                .setTranslationKey(Tags.MOD_ID + "." + name);;

        return item;
    }

    public static void init() {
        Registry.addItem(TOOL_HAMMER);
        Registry.addItem(TOOL_WIRECUTTERS);

        Registry.addItem(INGOT_ALUMINUM);
        Registry.addItem(INGOT_COPPER);
        Registry.addItem(INGOT_LEAD);
        Registry.addItem(INGOT_NICKEL);
        Registry.addItem(INGOT_SILVER);
        Registry.addItem(INGOT_URANIUM);
    }
}
