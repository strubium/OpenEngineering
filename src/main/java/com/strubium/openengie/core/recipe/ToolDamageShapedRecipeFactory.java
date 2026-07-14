package com.strubium.openengie.core.recipe;

import com.google.gson.JsonArray;
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

public class ToolDamageShapedRecipeFactory implements IRecipeFactory {

    @Override
    public IRecipe parse(JsonContext context, JsonObject json) {

        String group = JsonUtils.getString(json, "group", "");
        int damage = JsonUtils.getInt(json, "damage", 1);

        Map<Character, Ingredient> ingredientMap = new HashMap<>();

        for (Map.Entry<String, com.google.gson.JsonElement> entry :
                JsonUtils.getJsonObject(json, "key").entrySet()) {

            if (entry.getKey().length() != 1) {
                throw new RuntimeException(
                        "Invalid key entry: " + entry.getKey()
                );
            }

            ingredientMap.put(
                    entry.getKey().charAt(0),
                    CraftingHelper.getIngredient(entry.getValue(), context)
            );
        }

        ingredientMap.put(' ', Ingredient.EMPTY);


        JsonArray patternJson = JsonUtils.getJsonArray(json, "pattern");

        if (patternJson.size() == 0) {
            throw new RuntimeException("Empty pattern");
        }

        String[] pattern = new String[patternJson.size()];

        for (int i = 0; i < pattern.length; i++) {
            pattern[i] = JsonUtils.getString(
                    patternJson.get(i),
                    "pattern[" + i + "]"
            );
        }


        int width = pattern[0].length();
        int height = pattern.length;


        NonNullList<Ingredient> ingredients =
                NonNullList.withSize(width * height, Ingredient.EMPTY);


        int index = 0;

        for (String line : pattern) {
            for (char c : line.toCharArray()) {

                Ingredient ingredient = ingredientMap.get(c);

                if (ingredient == null) {
                    throw new RuntimeException(
                            "Pattern references undefined key: " + c
                    );
                }

                ingredients.set(index++, ingredient);
            }
        }


        ItemStack result = CraftingHelper.getItemStack(
                JsonUtils.getJsonObject(json, "result"),
                context
        );


        return new ToolDamageShapedRecipe(
                group,
                width,
                height,
                ingredients,
                result,
                damage
        );
    }
}