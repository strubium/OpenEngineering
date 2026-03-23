package com.strubium.openengie.assets;

import com.google.common.collect.ImmutableSet;
import com.strubium.openengie.Tags;
import net.minecraft.client.resources.IResourcePack;
import net.minecraft.client.resources.data.IMetadataSection;
import net.minecraft.client.resources.data.MetadataSerializer;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.file.Files;
import java.util.Set;

public class GeneratedResourcePack implements IResourcePack {

    private final File baseDir;

    public GeneratedResourcePack(File baseDir) {
        this.baseDir = baseDir;
    }

    @Override
    public InputStream getInputStream(ResourceLocation location) throws IOException {
        File file = new File(baseDir, "assets/" + location.getNamespace() + "/" + location.getPath());
        if (file.isFile()) {
            return Files.newInputStream(file.toPath());
        }
        throw new FileNotFoundException(file.toString());
    }

    @Override
    public boolean resourceExists(ResourceLocation location) {
        File file = new File(baseDir, "assets/" + location.getNamespace() + "/" + location.getPath());
        return file.isFile();
    }

    @Override
    public Set<String> getResourceDomains() {
        return ImmutableSet.of(Tags.MOD_ID);
    }

    @Nullable
    @Override
    public <T extends IMetadataSection> T getPackMetadata(MetadataSerializer serializer, String sectionName) {
        return null; // No pack.mcmeta support
    }

    @Override
    public BufferedImage getPackImage() {
        // Return a 1x1 dummy image so Minecraft won't crash when displaying pack info
        BufferedImage img = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = img.createGraphics();
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, 1, 1);
        g.dispose();
        return img;
    }

    @Override
    public String getPackName() {
        return Tags.MOD_NAME + ": GeneratedAssets";
    }
}
