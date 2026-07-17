package com.strubium.openengie.core.compact.groovy;

import com.cleanroommc.groovyscript.api.GroovyPlugin;
import com.cleanroommc.groovyscript.compat.mods.GroovyContainer;
import com.strubium.openengie.OpenEngineering;
import com.strubium.openengie.Tags;

public class OpenEngiePlugin implements GroovyPlugin {

    @Override
    public String getModId() {
        return Tags.MOD_ID;
    }

    @Override
    public String getContainerName() {
        return "OpenEngie";
    }

    @Override
    public OpenEngie createGroovyPropertyContainer() {
        return new OpenEngie();
    }

    @Override
    public void onCompatLoaded(GroovyContainer<?> container) {
        OpenEngineering.LOGGER.info("OpenEngie GrS compat loaded");
    }
}