package com.strubium.openengie.assets;

import com.google.gson.*;
import com.strubium.immersiveengineering.Tags;
import com.strubium.openengie.OpenEngineering;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.SimpleReloadableResourceManager;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.swing.*;
import java.awt.*;
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

    /** Generate blockstates/models from assets.json */
    public static void generateRuntimeModels() {
        try {
            JsonObject assetsJson = loadAssetsJson();
            JsonArray models = assetsJson.getAsJsonArray("models");
            File baseDir = new File("config/openengie/assets/" + Tags.MOD_ID);

            for (JsonElement elem : models) {
                JsonObject model = elem.getAsJsonObject();
                String name = model.get("name").getAsString();
                String type = model.has("type") ? model.get("type").getAsString() : "block"; // default to block

                if (type.equalsIgnoreCase("block")) {
                    // --- BLOCK HANDLING ---
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

                    // item model (references block model)
                    File itemModelFile = new File(baseDir, itemModelPath);
                    itemModelFile.getParentFile().mkdirs();
                    JsonObject itemModelJson = new JsonObject();
                    itemModelJson.addProperty("parent", Tags.MOD_ID + ":block/" + name);
                    writeJson(itemModelFile, itemModelJson);

                    OpenEngineering.LOGGER.info("Generated runtime block models for {}", name);

                } else if (type.equalsIgnoreCase("item")) {
                    // --- ITEM HANDLING ---
                    String itemModelPath = model.get("itemModelPath").getAsString();
                    String parentItemModel = model.has("parentItemModel")
                            ? model.get("parentItemModel").getAsString()
                            : "item/generated";

                    File itemModelFile = new File(baseDir, itemModelPath);
                    itemModelFile.getParentFile().mkdirs();

                    JsonObject itemModelJson = new JsonObject();
                    itemModelJson.addProperty("parent", parentItemModel);

                    // Optional textures for items
                    JsonObject textures = new JsonObject();
                    textures.addProperty("layer0", Tags.MOD_ID + ":items/" + name);
                    itemModelJson.add("textures", textures);

                    writeJson(itemModelFile, itemModelJson);

                    OpenEngineering.LOGGER.info("Generated runtime item model for {}", name);
                }
            }
        } catch (Exception e) {
            OpenEngineering.LOGGER.error("Failed to generate runtime models!", e);
        }
    }


    /** Checks for missing textures and prompts user to download them */
    public static void checkAssets() {
        try {
            JsonObject assetsJson = loadAssetsJson();
            JsonArray textures = assetsJson.getAsJsonArray("textures");

            StringBuilder missingFiles = new StringBuilder();
            boolean missing = false;

            for (JsonElement elem : textures) {
                JsonObject tex = elem.getAsJsonObject();
                String path = tex.get("path").getAsString();
                File file = new File("config/openengie/assets/" + Tags.MOD_ID + "/" + path);
                if (!file.exists()) {
                    missing = true;
                    missingFiles.append(path).append("\n");
                }
            }

            if (missing) {
                showMissingAssetsDialog(missingFiles.toString(), textures);
            }

        } catch (IOException e) {
            OpenEngineering.LOGGER.error("Failed to check runtime assets!", e);
            showMissingAssetsDialog("Could not read assets.json!", null);
        }
    }

    private static void showMissingAssetsDialog(String message, JsonArray textures) {
        EventQueue.invokeLater(() -> {
            String title = "Missing OpenEngie Assets";
            String[] options = {"Download Missing Assets", "Ignore"};

            // User-facing explanation added
            String userMessage = "Some texture assets required by OpenEngie are missing:\n\n"
                    + message
                    + "\nThese assets are copyrighted by BluSunrize and cannot be "
                    + "distributed directly by this mod.\n"
                    + "You can choose to download them directly from the official sources "
                    + "by clicking 'Download Missing Assets', or continue without them by "
                    + "clicking 'Ignore' (visual issues may occur).\n"
                    + "You will need to reopen the game if you choose to download these textures";

            int response = JOptionPane.showOptionDialog(
                    getPopupFrame(),
                    userMessage,
                    title,
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.WARNING_MESSAGE,
                    null,
                    options,
                    options[0]
            );

            // User clicked "Download Missing Assets"
            if (response == 0 && textures != null) {
                downloadMissingTextures(textures);
            }
        });
    }

    /** Only downloads missing .png textures */
    private static void downloadMissingTextures(JsonArray textures) {
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

                    OpenEngineering.LOGGER.info("Downloaded {} to {}", name, file.getAbsolutePath());

                } catch (IOException ex) {
                    OpenEngineering.LOGGER.error("Failed to download asset {}", name, ex);
                }
            }
        }
    }

    /** Creates a simple always-on-top JFrame for the JOptionPane */
    private static JFrame getPopupFrame() {
        JFrame parent = new JFrame();
        parent.setAlwaysOnTop(true);
        return parent;
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