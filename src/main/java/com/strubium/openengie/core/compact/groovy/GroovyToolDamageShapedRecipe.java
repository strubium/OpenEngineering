package com.strubium.openengie.core.compact.groovy;

import com.cleanroommc.groovyscript.api.IScriptReloadable;
import com.cleanroommc.groovyscript.api.documentation.annotations.MethodDescription;
import com.cleanroommc.groovyscript.registry.NamedRegistry;
import com.strubium.openengie.core.recipe.ToolDamageShapedRecipe;
import com.strubium.openengie.core.recipe.ToolDamageShapedRecipeFactory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroovyToolDamageShapedRecipe extends NamedRegistry implements IScriptReloadable {

    private final List<ToolDamageShapedRecipe> recipes = new ArrayList<>();
    private int recipeId = 0;

    @MethodDescription(type = MethodDescription.Type.ADDITION)
    public void add(
            String group,
            List<String> pattern,
            Map<String, ItemStack> key,
            ItemStack result,
            int damageAmount
    ) {
        String[] patternArray = pattern.toArray(new String[0]);

        Map<Character, Ingredient> ingredientMap = new HashMap<>();

        for (Map.Entry<String, ItemStack> entry : key.entrySet()) {
            if (entry.getKey().length() != 1) {
                throw new IllegalArgumentException(
                        "Invalid key: " + entry.getKey()
                );
            }

            ingredientMap.put(
                    entry.getKey().charAt(0),
                    Ingredient.fromStacks(entry.getValue())
            );
        }

        ToolDamageShapedRecipe recipe = ToolDamageShapedRecipeFactory.create(
                group,
                patternArray,
                ingredientMap,
                result,
                damageAmount
        );

        recipe.setRegistryName(
                new ResourceLocation(
                        "openengie",
                        "groovy_" + recipeId++
                )
        );
        recipes.add(recipe);
    }

    public List<ToolDamageShapedRecipe> getRecipes() {
        return recipes;
    }

    @Override
    public void onReload() {
        recipes.clear();
    }

    @Override
    public void afterScriptLoad() {

        for (ToolDamageShapedRecipe recipe : recipes) {
            ForgeRegistries.RECIPES.register(recipe);
        }
    }
}