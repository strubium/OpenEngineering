package com.strubium.openengie.core;

import com.strubium.openengie.Tags;
import com.strubium.openengie.OpenEngineering;
import com.strubium.openengie.core.registry.Registry;
import net.minecraft.item.Item;


public class ModItems {
    public static final Item TOOL_HAMMER = createItem("tool_hammer").setMaxStackSize(1);

    public static final Item TOOL_WIRECUTTERS = createItem("tool_wirecutters").setMaxStackSize(1);

    public static final Item INGOT_ALUMINUM = createItem("aluminum_ingot");
    public static final Item INGOT_COPPER = createItem("copper_ingot");
    public static final Item INGOT_LEAD = createItem("lead_ingot");
    public static final Item INGOT_NICKEL = createItem("nickel_ingot");
    public static final Item INGOT_SILVER = createItem("silver_ingot");
    public static final Item INGOT_URANIUM = createItem("uranium_ingot");
    public static final Item INGOT_STEEL = createItem("steel_ingot");
    public static final Item INGOT_CONSTANTAN = createItem("constantan_ingot");
    public static final Item INGOT_ELECTRUM = createItem("electrum_ingot");

    public static final Item NUGGET_ALUMINUM = createItem("aluminum_nugget");
    public static final Item NUGGET_COPPER = createItem("copper_nugget");
    public static final Item NUGGET_LEAD = createItem("lead_nugget");
    public static final Item NUGGET_NICKEL = createItem("nickel_nugget");
    public static final Item NUGGET_SILVER = createItem("silver_nugget");
    public static final Item NUGGET_URANIUM = createItem("uranium_nugget");
    public static final Item NUGGET_STEEL = createItem("steel_nugget");
    public static final Item NUGGET_CONSTANTAN = createItem("constantan_nugget");
    public static final Item NUGGET_ELECTRUM = createItem("electrum_nugget");

    public static final Item PLATE_ALUMINUM = createItem("aluminum_plate");
    public static final Item PLATE_STEEL = createItem("steel_plate");
    public static final Item PLATE_COPPER = createItem("copper_plate");
    public static final Item PLATE_IRON = createItem("iron_plate");
    public static final Item PLATE_GOLD = createItem("gold_plate");
    public static final Item PLATE_SILVER = createItem("silver_plate");
    public static final Item PLATE_NICKEL = createItem("nickel_plate");
    public static final Item PLATE_LEAD = createItem("lead_plate");
    public static final Item PLATE_URANIUM = createItem("uranium_plate");
    public static final Item PLATE_CONSTANTAN = createItem("constantan_plate");
    public static final Item PLATE_ELECTRUM = createItem("electrum_plate");

    public static final Item GRIT_ALUMINUM = createItem("aluminum_grit");
    public static final Item GRIT_STEEL = createItem("steel_grit");
    public static final Item GRIT_COPPER = createItem("copper_grit");
    public static final Item GRIT_IRON = createItem("iron_grit");
    public static final Item GRIT_GOLD = createItem("gold_grit");
    public static final Item GRIT_SILVER = createItem("silver_grit");
    public static final Item GRIT_NICKEL = createItem("nickel_grit");
    public static final Item GRIT_LEAD = createItem("lead_grit");
    public static final Item GRIT_URANIUM = createItem("uranium_grit");
    public static final Item GRIT_CONSTANTAN = createItem("constantan_grit");
    public static final Item GRIT_ELECTRUM = createItem("electrum_grit");
    public static final Item GRIT_COKE = createItem("coke_grit");
    public static final Item GRIT_HOP_GRAPHITE = createItem("hop_graphite_grit");
    public static final Item GRIT_NITRATE = createItem("nitrate_grit");
    public static final Item GRIT_SULFUR = createItem("sulfur_grit");;


    public static final Item WIRECOIL_LV = createItem("wirecoil_lv");
    public static final Item WIRECOIL_MV = createItem("wirecoil_mv");
    public static final Item WIRECOIL_HV = createItem("wirecoil_hv");
    public static final Item WIRECOIL_HEMP = createItem("wirecoil_hemp");
    public static final Item WIRECOIL_STEEL = createItem("wirecoil_steel");
    public static final Item WIRECOIL_REDSTONE = createItem("wirecoil_redstone");
    public static final Item WIRECOIL_LV_INSULATED = createItem("wirecoil_lv_insulated");
    public static final Item WIRECOIL_MV_INSULATED = createItem("wirecoil_mv_insulated");

    public static final Item INDUSTRIAL_HEMP_SEEDS = createItem("industrial_hemp_seeds");
    public static final Item INDUSTRIAL_HEMP_FIBERS = createItem("industrial_hemp_fibers");
    public static final Item INDUSTRIAL_HEMP_FABRIC = createItem("industrial_hemp_fabric");

    public static final Item COMPONENT_MECH_IRON = createItem("component_mech_iron");
    public static final Item COMPONENT_MECH_STEEL = createItem("component_mech_steel");

    public static final Item VACUUM_TUBE = createItem("vacuum_tube");
    public static final Item CIRCUIT_BOARD = createItem("circuit_board");

    public static final Item METALPRESS_MOLD_PLATE = createItem("metalpress_mold_plate");
    public static final Item METALPRESS_MOLD_GEAR = createItem("metalpress_mold_gear");
    public static final Item METALPRESS_MOLD_ROD = createItem("metalpress_mold_rod");
    public static final Item METALPRESS_MOLD_WIRE = createItem("metalpress_mold_wire");
    public static final Item METALPRESS_MOLD_PACKING2x2 = createItem("metalpress_mold_packing_2x2");
    public static final Item METALPRESS_MOLD_PACKING3x3 = createItem("metalpress_mold_packing_3x3");
    public static final Item METALPRESS_MOLD_UNPACKING = createItem("metalpress_mold_unpacking");

    public static final Item BLUEPRINT_CRAFTING_COMP = createItem("blueprint_crafting_components");
    public static final Item BLUEPRINT_METALPRESS_MOLDS = createItem("blueprint_metalpress_molds");
    public static final Item BLUEPRINT_ARCFURNACE_ELECTRODES = createItem("blueprint_arcfurnace_electrodes");

    public static final Item STICK_TREATED_WOOD = createItem("stick_treated_wood");
    public static final Item STICK_IRON = createItem("stick_iron");
    public static final Item STICK_STEEL = createItem("stick_steel");
    public static final Item STICK_ALUMINIUM = createItem("stick_aluminium");

    public static final Item WIRE_COPPER = createItem("wire_copper");
    public static final Item WIRE_ELECTRUM = createItem("wire_electrum");
    public static final Item WIRE_ALUMINIUM = createItem("wire_aluminium");
    public static final Item WIRE_STEEL = createItem("wire_steel");


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
        Registry.addItem(INGOT_STEEL);
        Registry.addItem(INGOT_CONSTANTAN);
        Registry.addItem(INGOT_ELECTRUM);

        Registry.addItem(NUGGET_ALUMINUM);
        Registry.addItem(NUGGET_COPPER);
        Registry.addItem(NUGGET_LEAD);
        Registry.addItem(NUGGET_NICKEL);
        Registry.addItem(NUGGET_SILVER);
        Registry.addItem(NUGGET_URANIUM);
        Registry.addItem(NUGGET_STEEL);
        Registry.addItem(NUGGET_CONSTANTAN);
        Registry.addItem(NUGGET_ELECTRUM);

        Registry.addItem(PLATE_ALUMINUM);
        Registry.addItem(PLATE_STEEL);
        Registry.addItem(PLATE_COPPER);
        Registry.addItem(PLATE_IRON);
        Registry.addItem(PLATE_GOLD);
        Registry.addItem(PLATE_SILVER);
        Registry.addItem(PLATE_NICKEL);
        Registry.addItem(PLATE_LEAD);
        Registry.addItem(PLATE_URANIUM);
        Registry.addItem(PLATE_CONSTANTAN);
        Registry.addItem(PLATE_ELECTRUM);

        Registry.addItem(GRIT_ALUMINUM);
        Registry.addItem(GRIT_STEEL);
        Registry.addItem(GRIT_COPPER);
        Registry.addItem(GRIT_IRON);
        Registry.addItem(GRIT_GOLD);
        Registry.addItem(GRIT_SILVER);
        Registry.addItem(GRIT_NICKEL);
        Registry.addItem(GRIT_LEAD);
        Registry.addItem(GRIT_URANIUM);
        Registry.addItem(GRIT_CONSTANTAN);
        Registry.addItem(GRIT_ELECTRUM);

        Registry.addItem(WIRECOIL_LV);
        Registry.addItem(WIRECOIL_MV);
        Registry.addItem(WIRECOIL_HV);
        Registry.addItem(WIRECOIL_HEMP);
        Registry.addItem(WIRECOIL_STEEL);
        Registry.addItem(WIRECOIL_REDSTONE);
        Registry.addItem(WIRECOIL_LV_INSULATED);
        Registry.addItem(WIRECOIL_MV_INSULATED);

        Registry.addItem(INDUSTRIAL_HEMP_SEEDS);

        Registry.addItem(METALPRESS_MOLD_PLATE);
        Registry.addItem(METALPRESS_MOLD_GEAR);
        Registry.addItem(METALPRESS_MOLD_ROD);
        Registry.addItem(METALPRESS_MOLD_WIRE);
        Registry.addItem(METALPRESS_MOLD_PACKING2x2);
        Registry.addItem(METALPRESS_MOLD_PACKING3x3);
        Registry.addItem(METALPRESS_MOLD_UNPACKING);

        Registry.addItem(BLUEPRINT_CRAFTING_COMP);
        Registry.addItem(BLUEPRINT_METALPRESS_MOLDS);
        Registry.addItem(BLUEPRINT_ARCFURNACE_ELECTRODES);
    }
}
