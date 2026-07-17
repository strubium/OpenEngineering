package com.strubium.openengie.core;

import com.strubium.openengie.Tags;
import com.strubium.openengie.OpenEngineering;
import com.strubium.openengie.core.registry.Registry;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;


public class ModItems {
    public static final Item TOOL_HAMMER = createItem("tool_hammer").setMaxDamage(500);

    public static final Item TOOL_WIRECUTTERS = createItem("tool_wirecutters").setMaxDamage(475);

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

    public static final Item PLATE_ALUMINUM = createItem("plate_aluminum");
    public static final Item PLATE_STEEL = createItem("plate_steel");
    public static final Item PLATE_COPPER = createItem("plate_copper");
    public static final Item PLATE_IRON = createItem("plate_iron");
    public static final Item PLATE_GOLD = createItem("plate_gold");
    public static final Item PLATE_SILVER = createItem("plate_silver");
    public static final Item PLATE_NICKEL = createItem("plate_nickel");
    public static final Item PLATE_LEAD = createItem("plate_lead");
    public static final Item PLATE_URANIUM = createItem("plate_uranium");
    public static final Item PLATE_CONSTANTAN = createItem("plate_constantan");
    public static final Item PLATE_ELECTRUM = createItem("plate_electrum");

    public static final Item GRIT_ALUMINUM = createItem("grit_aluminum");
    public static final Item GRIT_STEEL = createItem("grit_steel");
    public static final Item GRIT_COPPER = createItem("grit_copper");
    public static final Item GRIT_IRON = createItem("grit_iron");
    public static final Item GRIT_GOLD = createItem("grit_gold");
    public static final Item GRIT_SILVER = createItem("grit_silver");
    public static final Item GRIT_NICKEL = createItem("grit_nickel");
    public static final Item GRIT_LEAD = createItem("grit_lead");
    public static final Item GRIT_URANIUM = createItem("grit_uranium");
    public static final Item GRIT_CONSTANTAN = createItem("grit_constantan");
    public static final Item GRIT_ELECTRUM = createItem("grit_electrum");
    public static final Item GRIT_COKE = createItem("grit_coke");
    public static final Item GRIT_HOP_GRAPHITE = createItem("grit_hop_graphite");
    public static final Item GRIT_NITRATE = createItem("grit_nitrate");
    public static final Item GRIT_SULFUR = createItem("grit_sulfur");


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

    public static final Item COAL_COKE = createItem("coal_coke");
    public static final Item SLAG = createItem("slag");


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
        Registry.addItem(STICK_TREATED_WOOD);
        Registry.addOre("stick", STICK_TREATED_WOOD.getRegistryName());
        Registry.addOre("stickTreatedWood", STICK_TREATED_WOOD.getRegistryName());

        Registry.addItem(STICK_IRON);
        Registry.addOre("stick", STICK_IRON.getRegistryName());
        Registry.addOre("stickIron", STICK_IRON.getRegistryName());

        Registry.addItem(STICK_STEEL);
        Registry.addOre("stick", STICK_STEEL.getRegistryName());
        Registry.addOre("stickSteel", STICK_STEEL.getRegistryName());

        Registry.addItem(STICK_ALUMINIUM);
        Registry.addOre("stick", STICK_ALUMINIUM.getRegistryName());
        Registry.addOre("stickAluminum", STICK_ALUMINIUM.getRegistryName());
        Registry.addOre("stick", new ResourceLocation("minecraft:stick"));



        Registry.addItem(INDUSTRIAL_HEMP_FIBERS); Registry.addOre("fiberHemp", INDUSTRIAL_HEMP_FIBERS.getRegistryName());
        Registry.addItem(INDUSTRIAL_HEMP_FABRIC); Registry.addOre("fabricHemp", INDUSTRIAL_HEMP_FABRIC.getRegistryName());
        Registry.addItem(COAL_COKE);
        Registry.addItem(SLAG);


        Registry.addItem(COMPONENT_MECH_IRON);
        Registry.addOre("component", COMPONENT_MECH_IRON.getRegistryName());
        Registry.addOre("componentIron", COMPONENT_MECH_IRON.getRegistryName());

        Registry.addItem(COMPONENT_MECH_STEEL);
        Registry.addOre("component", COMPONENT_MECH_STEEL.getRegistryName());
        Registry.addOre("componentSteel", COMPONENT_MECH_STEEL.getRegistryName());

        Registry.addItem(WIRE_COPPER);
        Registry.addOre("wire", WIRE_COPPER.getRegistryName());
        Registry.addOre("wireCopper", WIRE_COPPER.getRegistryName());

        Registry.addItem(WIRE_ELECTRUM);
        Registry.addOre("wire", WIRE_ELECTRUM.getRegistryName());
        Registry.addOre("wireElectrum", WIRE_ELECTRUM.getRegistryName());

        Registry.addItem(WIRE_ALUMINIUM);
        Registry.addOre("wire", WIRE_ALUMINIUM.getRegistryName());
        Registry.addOre("wireAluminum", WIRE_ALUMINIUM.getRegistryName());

        Registry.addItem(WIRE_STEEL);
        Registry.addOre("wire", WIRE_STEEL.getRegistryName());
        Registry.addOre("wireSteel", WIRE_STEEL.getRegistryName());

        Registry.addItem(GRIT_NITRATE); Registry.addOre("dustNitrate", GRIT_NITRATE.getRegistryName());

        Registry.addItem(GRIT_SULFUR); Registry.addOre("dustSulfur", GRIT_SULFUR.getRegistryName());

        Registry.addItem(GRIT_COKE); Registry.addOre("dustCoke", GRIT_COKE.getRegistryName());

        Registry.addItem(GRIT_HOP_GRAPHITE); Registry.addOre("dustHopGraphite", GRIT_HOP_GRAPHITE.getRegistryName());

        Registry.addItem(TOOL_HAMMER);
        Registry.addItem(TOOL_WIRECUTTERS);

        Registry.addItem(VACUUM_TUBE);
        Registry.addItem(CIRCUIT_BOARD);

        Registry.addItem(INGOT_ALUMINUM); Registry.addOre("ingotAluminum", INGOT_ALUMINUM.getRegistryName());
        Registry.addItem(INGOT_COPPER); Registry.addOre("ingotCopper", INGOT_COPPER.getRegistryName());
        Registry.addItem(INGOT_LEAD); Registry.addOre("ingotLead", INGOT_LEAD.getRegistryName());
        Registry.addItem(INGOT_NICKEL); Registry.addOre("ingotNickel", INGOT_NICKEL.getRegistryName());
        Registry.addItem(INGOT_SILVER); Registry.addOre("ingotSilver", INGOT_SILVER.getRegistryName());
        Registry.addItem(INGOT_URANIUM); Registry.addOre("ingotUranium", INGOT_URANIUM.getRegistryName());
        Registry.addItem(INGOT_STEEL); Registry.addOre("ingotSteel", INGOT_STEEL.getRegistryName());
        Registry.addItem(INGOT_CONSTANTAN); Registry.addOre("ingotConstantan", INGOT_CONSTANTAN.getRegistryName());
        Registry.addItem(INGOT_ELECTRUM); Registry.addOre("ingotElectrum", INGOT_ELECTRUM.getRegistryName());

        Registry.addItem(NUGGET_ALUMINUM); Registry.addOre("nuggetAluminum", NUGGET_ALUMINUM.getRegistryName());
        Registry.addItem(NUGGET_COPPER); Registry.addOre("nuggetCopper", NUGGET_COPPER.getRegistryName());
        Registry.addItem(NUGGET_LEAD); Registry.addOre("nuggetLead", NUGGET_LEAD.getRegistryName());
        Registry.addItem(NUGGET_NICKEL); Registry.addOre("nuggetNickel", NUGGET_NICKEL.getRegistryName());
        Registry.addItem(NUGGET_SILVER); Registry.addOre("nuggetSilver", NUGGET_SILVER.getRegistryName());
        Registry.addItem(NUGGET_URANIUM); Registry.addOre("nuggetUranium", NUGGET_URANIUM.getRegistryName());
        Registry.addItem(NUGGET_STEEL); Registry.addOre("nuggetSteel", NUGGET_STEEL.getRegistryName());
        Registry.addItem(NUGGET_CONSTANTAN); Registry.addOre("nuggetConstantan", NUGGET_CONSTANTAN.getRegistryName());
        Registry.addItem(NUGGET_ELECTRUM); Registry.addOre("nuggetElectrum", NUGGET_ELECTRUM.getRegistryName());


        Registry.addItem(PLATE_ALUMINUM); Registry.addOre("plateAluminum", PLATE_ALUMINUM.getRegistryName());
        Registry.addItem(PLATE_STEEL); Registry.addOre("plateSteel", PLATE_STEEL.getRegistryName());
        Registry.addItem(PLATE_COPPER); Registry.addOre("plateCopper", PLATE_COPPER.getRegistryName());
        Registry.addItem(PLATE_IRON); Registry.addOre("plateIron", PLATE_IRON.getRegistryName());
        Registry.addItem(PLATE_GOLD); Registry.addOre("plateGold", PLATE_GOLD.getRegistryName());
        Registry.addItem(PLATE_SILVER); Registry.addOre("plateSilver", PLATE_SILVER.getRegistryName());
        Registry.addItem(PLATE_NICKEL); Registry.addOre("plateNickel", PLATE_NICKEL.getRegistryName());
        Registry.addItem(PLATE_LEAD); Registry.addOre("plateLead", PLATE_LEAD.getRegistryName());
        Registry.addItem(PLATE_URANIUM); Registry.addOre("plateUranium", PLATE_URANIUM.getRegistryName());
        Registry.addItem(PLATE_CONSTANTAN); Registry.addOre("plateConstantan", PLATE_CONSTANTAN.getRegistryName());
        Registry.addItem(PLATE_ELECTRUM); Registry.addOre("plateElectrum", PLATE_ELECTRUM.getRegistryName());

        Registry.addItem(GRIT_ALUMINUM); Registry.addOre("dustAluminum", GRIT_ALUMINUM.getRegistryName());
        Registry.addItem(GRIT_STEEL); Registry.addOre("dustSteel", GRIT_STEEL.getRegistryName());
        Registry.addItem(GRIT_COPPER); Registry.addOre("dustCopper", GRIT_COPPER.getRegistryName());
        Registry.addItem(GRIT_IRON); Registry.addOre("dustIron", GRIT_IRON.getRegistryName());
        Registry.addItem(GRIT_GOLD); Registry.addOre("dustGold", GRIT_GOLD.getRegistryName());
        Registry.addItem(GRIT_SILVER); Registry.addOre("dustSilver", GRIT_SILVER.getRegistryName());
        Registry.addItem(GRIT_NICKEL); Registry.addOre("dustNickel", GRIT_NICKEL.getRegistryName());
        Registry.addItem(GRIT_LEAD); Registry.addOre("dustLead", GRIT_LEAD.getRegistryName());
        Registry.addItem(GRIT_URANIUM); Registry.addOre("dustUranium", GRIT_URANIUM.getRegistryName());
        Registry.addItem(GRIT_CONSTANTAN); Registry.addOre("dustConstantan", GRIT_CONSTANTAN.getRegistryName());
        Registry.addItem(GRIT_ELECTRUM); Registry.addOre("dustElectrum", GRIT_ELECTRUM.getRegistryName());

        Registry.addItem(WIRECOIL_LV); Registry.addOre("wirecoil", WIRECOIL_LV.getRegistryName());
        Registry.addItem(WIRECOIL_MV); Registry.addOre("wirecoil", WIRECOIL_MV.getRegistryName());
        Registry.addItem(WIRECOIL_HV); Registry.addOre("wirecoil", WIRECOIL_HV.getRegistryName());
        Registry.addItem(WIRECOIL_HEMP); Registry.addOre("wirecoil", WIRECOIL_HEMP.getRegistryName());
        Registry.addItem(WIRECOIL_STEEL); Registry.addOre("wirecoil", WIRECOIL_STEEL.getRegistryName());
        Registry.addItem(WIRECOIL_REDSTONE); Registry.addOre("wirecoil", WIRECOIL_REDSTONE.getRegistryName());
        Registry.addItem(WIRECOIL_LV_INSULATED); Registry.addOre("wirecoil", WIRECOIL_LV_INSULATED.getRegistryName());
        Registry.addItem(WIRECOIL_MV_INSULATED); Registry.addOre("wirecoil", WIRECOIL_MV_INSULATED.getRegistryName());

        Registry.addItem(INDUSTRIAL_HEMP_SEEDS);

        Registry.addItem(METALPRESS_MOLD_PLATE);
        Registry.addItem(METALPRESS_MOLD_GEAR);
        Registry.addItem(METALPRESS_MOLD_ROD);
        Registry.addItem(METALPRESS_MOLD_WIRE);
        Registry.addItem(METALPRESS_MOLD_PACKING2x2);
        Registry.addItem(METALPRESS_MOLD_PACKING3x3);
        Registry.addItem(METALPRESS_MOLD_UNPACKING);

        Registry.addItem(BLUEPRINT_CRAFTING_COMP); Registry.addOre("blueprint", BLUEPRINT_CRAFTING_COMP.getRegistryName());
        Registry.addItem(BLUEPRINT_METALPRESS_MOLDS); Registry.addOre("blueprint", BLUEPRINT_METALPRESS_MOLDS.getRegistryName());
        Registry.addItem(BLUEPRINT_ARCFURNACE_ELECTRODES); Registry.addOre("blueprint", BLUEPRINT_ARCFURNACE_ELECTRODES.getRegistryName());
    }
}
