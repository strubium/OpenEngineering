package com.strubium.openengie.core.multi;

import com.strubium.openengie.core.blocks.BaseOpenEngieBlock;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyBool;

public class BlockMultiblockPart extends BaseOpenEngieBlock {

    public static final PropertyBool IS_FORMED = PropertyBool.create("is_formed");


    public BlockMultiblockPart(Material material, String blockName) {
        super(material, blockName);

        setDefaultState( this.blockState.getBaseState() .withProperty(IS_FORMED, false) );

    }
}
