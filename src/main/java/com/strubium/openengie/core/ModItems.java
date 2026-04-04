package com.strubium.openengie.core;

import com.strubium.openengie.Tags;
import com.strubium.openengie.OpenEngineering;
import com.strubium.openengie.core.registry.Registry;
import net.minecraft.item.Item;


public class ModItems {
    public static final Item TOOL_HAMMER = new Item()
            .setCreativeTab(OpenEngineering.CREATIVE_TAB)
            .setRegistryName(Tags.MOD_ID, "tool_hammer")
            .setTranslationKey(Tags.MOD_ID + ".tool_hammer");

    public static final Item INGOT_ALUMINUM = new Item()
            .setCreativeTab(OpenEngineering.CREATIVE_TAB)
            .setRegistryName(Tags.MOD_ID, "aluminum_ingot")
            .setTranslationKey(Tags.MOD_ID + ".aluminum_ingot");

    public static final Item INGOT_COPPER = new Item()
            .setCreativeTab(OpenEngineering.CREATIVE_TAB)
            .setRegistryName(Tags.MOD_ID, "copper_ingot")
            .setTranslationKey(Tags.MOD_ID + ".copper_ingot");

    public static final Item INGOT_LEAD = new Item()
            .setCreativeTab(OpenEngineering.CREATIVE_TAB)
            .setRegistryName(Tags.MOD_ID, "lead_ingot")
            .setTranslationKey(Tags.MOD_ID + ".lead_ingot");

    public static final Item INGOT_NICKEL = new Item()
            .setCreativeTab(OpenEngineering.CREATIVE_TAB)
            .setRegistryName(Tags.MOD_ID, "nickel_ingot")
            .setTranslationKey(Tags.MOD_ID + ".nickel_ingot");

    public static final Item INGOT_SILVER = new Item()
            .setCreativeTab(OpenEngineering.CREATIVE_TAB)
            .setRegistryName(Tags.MOD_ID, "silver_ingot")
            .setTranslationKey(Tags.MOD_ID + ".silver_ingot");

    public static final Item INGOT_URANIUM = new Item()
            .setCreativeTab(OpenEngineering.CREATIVE_TAB)
            .setRegistryName(Tags.MOD_ID, "uranium_ingot")
            .setTranslationKey(Tags.MOD_ID + ".uranium_ingot");



    public static void init() {
        Registry.addItem(TOOL_HAMMER);
        Registry.addItem(INGOT_ALUMINUM);
        Registry.addItem(INGOT_COPPER);
        Registry.addItem(INGOT_LEAD);
        Registry.addItem(INGOT_NICKEL);
        Registry.addItem(INGOT_SILVER);
        Registry.addItem(INGOT_URANIUM);

        // Furnace recipes

    }
}
