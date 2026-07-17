package com.strubium.openengie.core.compact.groovy;

import com.cleanroommc.groovyscript.compat.mods.GroovyContainer;
import com.cleanroommc.groovyscript.compat.mods.GroovyPropertyContainer;

public class OpenEngie extends GroovyPropertyContainer {

    public static OpenEngie INSTANCE;

    // This will get added to groovy as 'mods.openengie.crafting_tool_damage_shaped'
    public final GroovyToolDamageShapedRecipe crafting_tool_damage_shaped = new GroovyToolDamageShapedRecipe();

    public OpenEngie() {
        INSTANCE = this;
    }

    @Override
    public void initialize(GroovyContainer<?> owner) {
        addPropertyFieldsOf(this, false);
    }
}