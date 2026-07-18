package com.strubium.openengie.core.multi.patch;

import net.minecraft.block.Block;
import net.minecraft.util.ResourceLocation;
import vazkii.patchouli.api.PatchouliAPI;
import vazkii.patchouli.api.IMultiblock;

public class AlloyKlinMultiblock {

    public static final ResourceLocation ID =
            new ResourceLocation("openengie", "alloy_klin_multiblock");

    public static IMultiblock create() {
        Block alloyKlin = Block.REGISTRY.getObject(
                new ResourceLocation("openengie", "alloy_kiln_brick")
        );

        return PatchouliAPI.instance.makeMultiblock(
                new String[][] {
                        {
                                "AA",
                                "AA"
                        },
                        {
                                "A0",
                                "AA"
                        }
                },
                'A', alloyKlin,
                '0', alloyKlin
        );
    }

    public static void register() {
        PatchouliAPI.instance.registerMultiblock(ID, create());
    }
}
