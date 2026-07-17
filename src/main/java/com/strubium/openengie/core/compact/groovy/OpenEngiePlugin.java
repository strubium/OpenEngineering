package com.strubium.openengie.core.compact.groovy;

import com.cleanroommc.groovyscript.api.GroovyPlugin;
import com.cleanroommc.groovyscript.compat.mods.GroovyContainer;

public class OpenEngiePlugin implements GroovyPlugin {

    @Override
    public String getModId() {
        return "openengie";
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
        System.out.println("OpenEngie compat loaded");
    }
}