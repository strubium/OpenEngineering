package com.strubium.openengie;

import com.strubium.openengie.Tags;
import com.strubium.openengie.assets.RuntimeAssets;
import com.strubium.openengie.core.ModBlocks;
import com.strubium.openengie.core.ModItems;
import com.strubium.openengie.core.Registry;
import com.strubium.openengie.core.blocks.alloy.RenderAlloyKiln;
import com.strubium.openengie.core.blocks.alloy.TileAlloyKiln;
import com.strubium.openengie.core.generated.OreGenerator;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLConstructionEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(modid = Tags.MOD_ID, name = Tags.MOD_NAME, version = Tags.VERSION)
@Mod.EventBusSubscriber
public class OpenEngineering {

    public static final Logger LOGGER = LogManager.getLogger(Tags.MOD_NAME);

    public static final CreativeTabs CREATIVE_TAB = new CreativeTabs("ie") {
        @Override
        public ItemStack createIcon() {
            return Registry.getItem("treated_wood").getDefaultInstance();
        }
    };

    @Mod.EventHandler
    public void construct(FMLConstructionEvent event){
        RuntimeAssets.checkAssets();
    }

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        //RuntimeAssets.generateRuntimeModels();
        ModBlocks.init();
        ModItems.init();

        if (event.getSide().isClient()) {
            RuntimeAssets.registerGeneratedResourcePack();
            ClientRegistry.bindTileEntitySpecialRenderer(TileAlloyKiln.class, new RenderAlloyKiln());
        }

        GameRegistry.registerTileEntity(TileAlloyKiln.class, Tags.MOD_ID + "_alloy_kiln");
    }
    @Mod.EventHandler
    public void init(FMLInitializationEvent event){
        GameRegistry.registerWorldGenerator(new OreGenerator(), 0);


        GameRegistry.addSmelting(ModBlocks.ORE_ALUMINUM, new ItemStack(ModItems.INGOT_ALUMINUM), 0.7f);
        GameRegistry.addSmelting(ModBlocks.ORE_COPPER, new ItemStack(ModItems.INGOT_COPPER), 0.7f);
        GameRegistry.addSmelting(ModBlocks.ORE_LEAD, new ItemStack(ModItems.INGOT_LEAD), 0.7f);
        GameRegistry.addSmelting(ModBlocks.ORE_NICKEL, new ItemStack(ModItems.INGOT_NICKEL), 0.7f);
        GameRegistry.addSmelting(ModBlocks.ORE_SILVER, new ItemStack(ModItems.INGOT_SILVER), 0.7f);
        GameRegistry.addSmelting(ModBlocks.ORE_URANIUM, new ItemStack(ModItems.INGOT_URANIUM), 0.7f);
    }
}
