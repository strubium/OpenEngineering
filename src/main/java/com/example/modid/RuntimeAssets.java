package com.example.modid;

import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.DynamicTexture;
import net.minecraft.client.resources.SimpleReloadableResourceManager;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URL;
import java.nio.charset.StandardCharsets;

@SideOnly(Side.CLIENT)
public class RuntimeAssets {

    private static final Logger LOGGER = LogManager.getLogger(Tags.MOD_NAME);

    public static void downloadTextureIfMissing() {
        try {
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

    public static void generateRuntimeModels() {
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

            // models/item/treated_wood.json
            JsonObject itemModelJson = new JsonObject();
            itemModelJson.add("parent", new JsonPrimitive(Tags.MOD_ID + ":block/treated_wood"));
            writeJson(new File(modelsItemDir, "treated_wood.json"), itemModelJson);

            LOGGER.info("Generated runtime models for treated_wood.");
        } catch (Exception e) {
            LOGGER.error("Failed to generate runtime models for treated_wood.", e);
        }
    }

    private static void writeJson(File file, JsonObject json) throws IOException {
        try (Writer writer = new OutputStreamWriter(new FileOutputStream(file), StandardCharsets.UTF_8)) {
            writer.write(json.toString());
        }
    }

    public static void registerGeneratedResourcePack() {
        File resourceBase = new File("config/openengie");
        SimpleReloadableResourceManager resourceManager = (SimpleReloadableResourceManager) Minecraft.getMinecraft().getResourceManager();
        resourceManager.reloadResourcePack(new GeneratedResourcePack(resourceBase));
        LOGGER.info("Injected runtime resource pack from {}", resourceBase.getAbsolutePath());
    }

    public static void registerDynamicTexture() {
        try {
            File textureFile = new File("config/openengie/treated_wood.png");
            if (!textureFile.exists()) {
                LOGGER.warn("Dynamic texture file missing, skipping registration.");
                return;
            }

            BufferedImage image = ImageIO.read(textureFile);
            DynamicTexture dynamicTexture = new DynamicTexture(image);
            Minecraft.getMinecraft().getTextureManager().loadTexture(ExampleMod.DYNAMIC_TEXTURE, dynamicTexture);
            LOGGER.info("Registered dynamic texture: {}", ExampleMod.DYNAMIC_TEXTURE);
        } catch (IOException e) {
            LOGGER.error("Failed to register dynamic texture!", e);
        }
    }
}
