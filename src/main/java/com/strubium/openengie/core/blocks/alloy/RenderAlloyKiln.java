package com.strubium.openengie.core.blocks.alloy;

import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.util.ResourceLocation;

public class RenderAlloyKiln extends TileEntitySpecialRenderer<TileAlloyKiln> {

    private static final ResourceLocation TEXTURE_BOTTOM =
            new ResourceLocation("openengie:textures/blocks/stone_device_allloy_smelter_bottom.png");
    private static final ResourceLocation TEXTURE_TOP =
            new ResourceLocation("openengie:textures/blocks/stone_device_allloy_smelter_top.png");
    private static final ResourceLocation TEXTURE_SIDE =
            new ResourceLocation("openengie:textures/blocks/stone_device_allloy_smelter_side.png");

    @Override
    public void render(TileAlloyKiln te, double x, double y, double z,
                       float partialTicks, int destroyStage, float alpha) {

        GlStateManager.pushMatrix();
        GlStateManager.pushAttrib();

        GlStateManager.translate(x, y, z);
        GlStateManager.disableCull();

        // Keep textures from going black
        this.setLightmapDisabled(true);

        // Enable lighting for normals to work
        GlStateManager.enableLighting();
        GlStateManager.color(0.95f, 0.95f, 0.95f, 1f);

        GlStateManager.scale(2.0, 2.0, 2.0);

        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder buf = tessellator.getBuffer();

        // Bottom face (Y negative)
        this.bindTexture(TEXTURE_BOTTOM);
        buf.begin(7, DefaultVertexFormats.POSITION_TEX_NORMAL);
        addQuad(buf, 0,0,0, 1,0,0, 1,0,1, 0,0,1, 0f, -1f, 0f);
        tessellator.draw();

        // Top face (Y positive)
        this.bindTexture(TEXTURE_TOP);
        buf.begin(7, DefaultVertexFormats.POSITION_TEX_NORMAL);
        addQuad(buf, 0,1,0, 1,1,0, 1,1,1, 0,1,1, 0f, 1f, 0f);
        tessellator.draw();

        // North face (Z negative)
        this.bindTexture(TEXTURE_SIDE);
        buf.begin(7, DefaultVertexFormats.POSITION_TEX_NORMAL);
        addQuad(buf, 0,0,0, 1,0,0, 1,1,0, 0,1,0, 0f, 0f, -1f);
        tessellator.draw();

        // South face (Z positive)
        this.bindTexture(TEXTURE_SIDE);
        buf.begin(7, DefaultVertexFormats.POSITION_TEX_NORMAL);
        addQuad(buf, 0,0,1, 1,0,1, 1,1,1, 0,1,1, 0f, 0f, 1f);
        tessellator.draw();

        // West face (X negative)
        this.bindTexture(TEXTURE_SIDE);
        buf.begin(7, DefaultVertexFormats.POSITION_TEX_NORMAL);
        addQuad(buf, 0,0,0, 0,0,1, 0,1,1, 0,1,0, -1f, 0f, 0f);
        tessellator.draw();

        // East face (X positive)
        this.bindTexture(TEXTURE_SIDE);
        buf.begin(7, DefaultVertexFormats.POSITION_TEX_NORMAL);
        addQuad(buf, 1,0,0, 1,0,1, 1,1,1, 1,1,0, 1f, 0f, 0f);
        tessellator.draw();

        GlStateManager.enableCull();
        GlStateManager.disableLighting(); // return OpenGL state
        this.setLightmapDisabled(false);

        GlStateManager.popAttrib();
        GlStateManager.popMatrix();
    }

    /**
     * Adds a single quad with 4 vertices and a face normal.
     */
    private void addQuad(BufferBuilder buf,
                         double x1, double y1, double z1,
                         double x2, double y2, double z2,
                         double x3, double y3, double z3,
                         double x4, double y4, double z4,
                         float nx, float ny, float nz) {
        buf.pos(x1, y1, z1).tex(0.0D, 0.0D).normal(nx, ny, nz).endVertex();
        buf.pos(x2, y2, z2).tex(1.0D, 0.0D).normal(nx, ny, nz).endVertex();
        buf.pos(x3, y3, z3).tex(1.0D, 1.0D).normal(nx, ny, nz).endVertex();
        buf.pos(x4, y4, z4).tex(0.0D, 1.0D).normal(nx, ny, nz).endVertex();
    }
}