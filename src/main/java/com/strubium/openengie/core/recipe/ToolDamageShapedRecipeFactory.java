package com.strubium.openengie.core.recipe;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.JsonUtils;

import net.minecraft.util.NonNullList;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.common.crafting.IRecipeFactory;
import net.minecraftforge.common.crafting.JsonContext;

import java.util.HashMap;
import java.util.Map;

public class ToolDamageShapedRecipeFactory
        implements IRecipeFactory {

    public static ToolDamageShapedRecipe create(
            String group,
            String[] pattern,
            Map<Character, Ingredient> ingredientMap,
            ItemStack result,
            int damage
    ) {
        if (pattern.length == 0) {
            throw new IllegalArgumentException(
                    "Empty pattern"
            );
        }

        int width = pattern[0].length();
        int height = pattern.length;

        for (String line : pattern) {
            if (line.length() != width) {
                throw new IllegalArgumentException(
                        "All pattern lines must have the same width"
                );
            }
        }

        Map<Character, Ingredient> ingredientsByChar =
                new HashMap<>(ingredientMap);

        ingredientsByChar.put(
                ' ',
                Ingredient.EMPTY
        );

        return new ToolDamageShapedRecipe(
                group,
                width,
                height,
                createIngredients(
                        pattern,
                        width,
                        height,
                        ingredientsByChar
                ),
                result,
                damage
        );
    }

    private static NonNullList<Ingredient> createIngredients(
            String[] pattern,
            int width,
            int height,
            Map<Character, Ingredient> ingredientMap
    ) {
        NonNullList<Ingredient> ingredients =
                NonNullList.withSize(
                        width * height,
                        Ingredient.EMPTY
                );

        int index = 0;

        for (String line : pattern) {
            for (char c : line.toCharArray()) {
                Ingredient ingredient =
                        ingredientMap.get(c);

                if (ingredient == null) {
                    throw new IllegalArgumentException(
                            "Pattern references undefined key: "
                                    + c
                    );
                }

                ingredients.set(
                        index++,
                        ingredient
                );
            }
        }

        return ingredients;
    }

    @Override
    public IRecipe parse(
            JsonContext context,
            JsonObject json
    ) {
        String group = JsonUtils.getString(
                json,
                "group",
                ""
        );

        int damage = JsonUtils.getInt(
                json,
                "damage",
                1
        );

        Map<Character, Ingredient> ingredientMap =
                new HashMap<>();

        for (Map.Entry<String, JsonElement> entry :
                JsonUtils.getJsonObject(
                        json,
                        "key"
                ).entrySet()) {

            String key = entry.getKey();

            if (key.length() != 1) {
                throw new RuntimeException(
                        "Invalid key entry: " + key
                );
            }

            ingredientMap.put(
                    key.charAt(0),
                    CraftingHelper.getIngredient(
                            entry.getValue(),
                            context
                    )
            );
        }

        JsonArray patternJson =
                JsonUtils.getJsonArray(
                        json,
                        "pattern"
                );

        if (patternJson.size() == 0) {
            throw new RuntimeException(
                    "Empty pattern"
            );
        }

        String[] pattern =
                new String[patternJson.size()];

        for (int i = 0; i < pattern.length; i++) {
            pattern[i] = JsonUtils.getString(
                    patternJson.get(i),
                    "pattern[" + i + "]"
            );
        }

        ItemStack result =
                CraftingHelper.getItemStack(
                        JsonUtils.getJsonObject(
                                json,
                                "result"
                        ),
                        context
                );

        return create(
                group,
                pattern,
                ingredientMap,
                result,
                damage
        );
    }
}