package com.strubium.openengie.assets;

import com.google.gson.*;
import com.strubium.immersiveengineering.Tags;
import com.strubium.openengie.OpenEngineering;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.SimpleReloadableResourceManager;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.io.*;
import java.net.URL;
import java.nio.charset.StandardCharsets;

@SideOnly(Side.CLIENT)
public class RuntimeAssets {

    /** Load assets.json from inside the JAR */
    private static JsonObject loadAssetsJson() throws IOException {
        try (InputStream in = RuntimeAssets.class.getResourceAsStream("/assets/openengie/assets.json")) {
            try (Reader reader = new InputStreamReader(in, StandardCharsets.UTF_8)) {
                JsonParser parser = new JsonParser();
                return parser.parse(reader).getAsJsonObject();
            }
        }
    }

    /** Download all textures listed in assets.json */
    public static void downloadAssets() {
        try {
            JsonObject assetsJson = loadAssetsJson();
            JsonArray textures = assetsJson.getAsJsonArray("textures");

            for (JsonElement elem : textures) {
                JsonObject tex = elem.getAsJsonObject();
                String name = tex.get("name").getAsString();
                String url = tex.get("url").getAsString();
                String path = tex.get("path").getAsString();

                File file = new File("config/openengie/assets/" + Tags.MOD_ID + "/" + path);
                if (!file.exists()) {
                    file.getParentFile().mkdirs();
                    OpenEngineering.LOGGER.info("[{}] Downloading {}...", Tags.MOD_NAME, name);
                    try (InputStream in = new URL(url).openStream();
                         FileOutputStream out = new FileOutputStream(file)) {
                        byte[] buffer = new byte[4096];
                        int bytesRead;
                        while ((bytesRead = in.read(buffer)) != -1) {
                            out.write(buffer, 0, bytesRead);
                        }
                    }
                    OpenEngineering.LOGGER.info("Downloaded {} to {}", name, file.getAbsolutePath());
                }
            }
        } catch (Exception e) {
            OpenEngineering.LOGGER.error("Failed to download assets!", e);
        }
    }

    /** Generate blockstates/models from assets.json */
    public static void generateRuntimeModels() {
        try {
            JsonObject assetsJson = loadAssetsJson();
            JsonArray models = assetsJson.getAsJsonArray("models");
            File baseDir = new File("config/openengie/assets/" + Tags.MOD_ID);

            for (JsonElement elem : models) {
                JsonObject model = elem.getAsJsonObject();
                String name = model.get("name").getAsString();
                String blockStatePath = model.get("blockStatePath").getAsString();
                String blockModelPath = model.get("blockModelPath").getAsString();
                String itemModelPath = model.get("itemModelPath").getAsString();
                String parentBlockModel = model.get("parentBlockModel").getAsString();

                // blockstates
                File blockstateFile = new File(baseDir, blockStatePath);
                blockstateFile.getParentFile().mkdirs();
                JsonObject blockstateJson = new JsonObject();
                JsonObject variants = new JsonObject();
                JsonObject variant = new JsonObject();
                variant.addProperty("model", Tags.MOD_ID + ":" + name);
                variants.add("normal", variant);
                blockstateJson.add("variants", variants);
                writeJson(blockstateFile, blockstateJson);

                // block model
                File blockModelFile = new File(baseDir, blockModelPath);
                blockModelFile.getParentFile().mkdirs();
                JsonObject blockModelJson = new JsonObject();
                blockModelJson.addProperty("parent", parentBlockModel);
                JsonObject textures = new JsonObject();
                textures.addProperty("all", Tags.MOD_ID + ":blocks/" + name);
                blockModelJson.add("textures", textures);
                writeJson(blockModelFile, blockModelJson);

                // item model
                File itemModelFile = new File(baseDir, itemModelPath);
                itemModelFile.getParentFile().mkdirs();
                JsonObject itemModelJson = new JsonObject();
                itemModelJson.addProperty("parent", Tags.MOD_ID + ":block/" + name);
                writeJson(itemModelFile, itemModelJson);

                OpenEngineering.LOGGER.info("Generated runtime models for {}", name);
            }
        } catch (Exception e) {
            OpenEngineering.LOGGER.error("Failed to generate runtime models!", e);
        }
    }

    private static void writeJson(File file, JsonObject json) throws IOException {
        try (Writer writer = new OutputStreamWriter(new FileOutputStream(file), StandardCharsets.UTF_8)) {
            writer.write(json.toString());
        }
    }

    /** Inject the generated resource pack into Minecraft */
    public static void registerGeneratedResourcePack() {
        File resourceBase = new File("config/openengie");
        SimpleReloadableResourceManager resourceManager = (SimpleReloadableResourceManager) Minecraft.getMinecraft().getResourceManager();
        resourceManager.reloadResourcePack(new GeneratedResourcePack(resourceBase));
        OpenEngineering.LOGGER.info("Injected runtime resource pack from {}", resourceBase.getAbsolutePath());
    }
}