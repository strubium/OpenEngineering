package com.example.modid;

import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.texture.DynamicTexture;
import net.minecraft.client.resources.SimpleReloadableResourceManager;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URL;
import java.nio.charset.StandardCharsets;

@Mod(modid = Tags.MOD_ID, name = Tags.MOD_NAME, version = Tags.VERSION)
@Mod.EventBusSubscriber
public class ExampleMod {

    public static final Logger LOGGER = LogManager.getLogger(Tags.MOD_NAME);
    public static final Block TREATED_WOOD = new Block(Material.ROCK)
            .setCreativeTab(CreativeTabs.BUILDING_BLOCKS)
            .setRegistryName(Tags.MOD_ID + ":treated_wood");
    public static final ResourceLocation DYNAMIC_TEXTURE = new ResourceLocation(Tags.MOD_ID, "textures/blocks/treated_wood.png");

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        downloadTextureIfMissing();
        generateRuntimeModels();

        // Register our generated assets as a resource pack (client side only)
        if (event.getSide().isClient()) {
            registerGeneratedResourcePack();
        }
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        if (event.getSide().isClient()) {
            registerDynamicTexture();
        }
    }

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        event.getRegistry().register(TREATED_WOOD);
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        // Create an ItemBlock for your block and register it
        ItemBlock itemBlock = new ItemBlock(TREATED_WOOD);
        itemBlock.setRegistryName(TREATED_WOOD.getRegistryName()); // Important: must match block's registry name
        event.getRegistry().register(itemBlock);
    }

    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public static void registerModels(ModelRegistryEvent event) {
        ModelLoader.setCustomModelResourceLocation(
                Item.getItemFromBlock(TREATED_WOOD), // The item we want to render
                0, // Metadata (0 for non-variant blocks)
                new ModelResourceLocation(TREATED_WOOD.getRegistryName(), "inventory")
        );
    }

    private void downloadTextureIfMissing() {
        try {
            // Correct base directory: inside our runtime resource pack
            File textureDir = new File("config/openengie/assets/" + Tags.MOD_ID + "/textures/blocks");
            if (!textureDir.exists()) textureDir.mkdirs();

            File textureFile = new File(textureDir, "treated_wood.png");
            if (!textureFile.exists()) {
                LOGGER.info("[{}] Downloading treated_wood texture...", Tags.MOD_NAME);
                URL url = new URL(
                        "https://raw.githubusercontent.com/BluSunrize/ImmersiveEngineering/1.13pre/src/main/resources/assets/immersiveengineering/textures/blocks/treated_wood.png"
                );

                try (InputStream in = url.openStream(); FileOutputStream out = new FileOutputStream(textureFile)) {
                    byte[] buffer = new byte[4096];
                    int bytesRead;
                    while ((bytesRead = in.read(buffer)) != -1) {
                        out.write(buffer, 0, bytesRead);
                    }
                }

                LOGGER.info("Downloaded texture to {}", textureFile.getAbsolutePath());
            }
        } catch (Exception e) {
            LOGGER.error("Failed to download treated_wood texture!", e);
        }
    }

    private void generateRuntimeModels() {
        try {
            File runtimeAssetsDir = new File("config/openengie/assets/" + Tags.MOD_ID);
            File modelsBlockDir = new File(runtimeAssetsDir, "models/block");
            File modelsItemDir = new File(runtimeAssetsDir, "models/item");
            File blockstatesDir = new File(runtimeAssetsDir, "blockstates");

            modelsBlockDir.mkdirs();
            modelsItemDir.mkdirs();
            blockstatesDir.mkdirs();

            // blockstates/treated_wood.json
            JsonObject blockstateJson = new JsonObject();
            JsonObject variants = new JsonObject();
            JsonObject variant = new JsonObject();
            variant.add("model", new JsonPrimitive(Tags.MOD_ID + ":treated_wood"));
            variants.add("normal", variant);
            blockstateJson.add("variants", variants);
            writeJson(new File(blockstatesDir, "treated_wood.json"), blockstateJson);

            // models/block/treated_wood.json
            JsonObject modelJson = new JsonObject();
            modelJson.add("parent", new JsonPrimitive("block/cube_all"));
            JsonObject textures = new JsonObject();
            textures.add("all", new JsonPrimitive(Tags.MOD_ID + ":blocks/treated_wood"));
            modelJson.add("textures", textures);
            writeJson(new File(modelsBlockDir, "treated_wood.json"), modelJson);

            // models/item/treated_wood.json (use block model)
            JsonObject itemModelJson = new JsonObject();
            itemModelJson.add("parent", new JsonPrimitive(Tags.MOD_ID + ":block/treated_wood"));
            writeJson(new File(modelsItemDir, "treated_wood.json"), itemModelJson);

            LOGGER.info("Generated runtime models for treated_wood.");
        } catch (Exception e) {
            LOGGER.error("Failed to generate runtime models for treated_wood.", e);
        }
    }

    private void writeJson(File file, JsonObject json) throws IOException {
        try (Writer writer = new OutputStreamWriter(new FileOutputStream(file), StandardCharsets.UTF_8)) {
            writer.write(json.toString());
        }
    }

    @SideOnly(Side.CLIENT)
    private void registerGeneratedResourcePack() {
        File resourceBase = new File("config/openengie");
        SimpleReloadableResourceManager resourceManager = (SimpleReloadableResourceManager) Minecraft.getMinecraft().getResourceManager();
        resourceManager.reloadResourcePack(new GeneratedResourcePack(resourceBase));
        LOGGER.info("Injected runtime resource pack from {}", resourceBase.getAbsolutePath());
    }

    @SideOnly(Side.CLIENT)
    private void registerDynamicTexture() {
        try {
            File textureFile = new File("config/openengie/treated_wood.png");
            if (!textureFile.exists()) {
                LOGGER.warn("Dynamic texture file missing, skipping registration.");
                return;
            }

            BufferedImage image = ImageIO.read(textureFile);
            DynamicTexture dynamicTexture = new DynamicTexture(image);
            Minecraft.getMinecraft().getTextureManager().loadTexture(DYNAMIC_TEXTURE, dynamicTexture);
            LOGGER.info("Registered dynamic texture: {}", DYNAMIC_TEXTURE);
        } catch (IOException e) {
            LOGGER.error("Failed to register dynamic texture!", e);
        }
    }
}
