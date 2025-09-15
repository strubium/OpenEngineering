package com.strubium.openengie.core;

import com.strubium.immersiveengineering.Tags;
import com.strubium.openengie.OpenEngineering;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;


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



    public static void preInit() {
        Registry.addItem(TOOL_HAMMER);
        Registry.addItem(INGOT_ALUMINUM);
        Registry.addItem(INGOT_COPPER);
        Registry.addItem(INGOT_LEAD);
        Registry.addItem(INGOT_NICKEL);
        Registry.addItem(INGOT_SILVER);
        Registry.addItem(INGOT_URANIUM);

        Registry.addSmelting(ModBlocks.ORE_ALUMINUM, new ItemStack(ModItems.INGOT_ALUMINUM), 0.7f);
        Registry.addSmelting(ModBlocks.ORE_COPPER, new ItemStack(ModItems.INGOT_COPPER), 0.7f);
        Registry.addSmelting(ModBlocks.ORE_LEAD, new ItemStack(ModItems.INGOT_LEAD), 0.7f);
        Registry.addSmelting(ModBlocks.ORE_NICKEL, new ItemStack(ModItems.INGOT_NICKEL), 0.7f);
        Registry.addSmelting(ModBlocks.ORE_SILVER, new ItemStack(ModItems.INGOT_SILVER), 0.7f);
        Registry.addSmelting(ModBlocks.ORE_URANIUM, new ItemStack(ModItems.INGOT_URANIUM), 0.7f);
    }
}
