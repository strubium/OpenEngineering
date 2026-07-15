package com.strubium.openengie.assets;

import com.google.gson.*;
import com.strubium.openengie.Tags;
import com.strubium.openengie.OpenEngineering;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.SimpleReloadableResourceManager;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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

    /** Checks for missing textures and prompts user to download them */
    public static void checkAssets() {
        try {
            JsonObject assetsJson = loadAssetsJson();
            JsonArray textures = assetsJson.getAsJsonArray("textures");

            StringBuilder missingFiles = new StringBuilder();
            boolean missing = false;

            Set<String> names = new HashSet<>();

            for (JsonElement elem : textures) {
                JsonObject tex = elem.getAsJsonObject();

                String name = tex.get("name").getAsString();
                String type = tex.get("type").getAsString();

                if (!names.add(name)) {
                    throw new RuntimeException("Duplicate texture name found: " + name);
                }

                String path = "textures/" + type + "s/" + name + ".png";

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

            // scrollable text goes here
            JTextArea textArea = new JTextArea(
                    "Some texture assets required by OpenEngie are missing:\n\n"
                            + message
                            + "\nThese assets are copyrighted by BluSunrize and cannot be "
                            + "distributed directly by this mod.\n"
                            + "You can choose to download them directly from the official sources "
                            + "by clicking 'Download Missing Assets', or continue without them by "
                            + "clicking 'Ignore' (visual issues may occur).\n"
                            + "You will need to reopen the game if you choose to download these textures"
            );
            textArea.setLineWrap(true);
            textArea.setWrapStyleWord(true);
            textArea.setEditable(false);

            JScrollPane scrollPane = new JScrollPane(textArea);
            scrollPane.setPreferredSize(new Dimension(500, 300));

            int response = JOptionPane.showOptionDialog(
                    getPopupFrame(),
                    scrollPane,
                    title,
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.WARNING_MESSAGE,
                    null,
                    options,
                    options[0]
            );

            if (response == 0 && textures != null) {
                downloadMissingTextures(textures);
            }
        });
    }
    private static void downloadMissingTextures(JsonArray textures) {
        for (JsonElement elem : textures) {
            JsonObject tex = elem.getAsJsonObject();
            String name = tex.get("name").getAsString();
            String url = tex.get("url").getAsString();
            JsonElement typeElement = tex.get("type");
            if (typeElement == null) {
                throw new RuntimeException("Texture '" + name + "' is missing a type field.");
            }
            String type = typeElement.getAsString();

            String path = "textures/"+type +"s/"+name+".png";

            File file = new File("config/openengie/assets/" + Tags.MOD_ID + "/" + path);
            if (!file.exists()) {
                file.getParentFile().mkdirs();
                OpenEngineering.LOGGER.info("Downloading {}...", name);

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