package com.strubium.openengie.core.recipe;

import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.crafting.ShapedRecipes;
import net.minecraft.util.NonNullList;

public class ToolDamageShapedRecipe extends ShapedRecipes {

    private final int damageAmount;

    public ToolDamageShapedRecipe(
            String group,
            int width,
            int height,
            NonNullList<Ingredient> ingredients,
            ItemStack result,
            int damageAmount
    ) {
        super(group, width, height, ingredients, result);
        this.damageAmount = damageAmount;
    }


    @Override
    public NonNullList<ItemStack> getRemainingItems(InventoryCrafting inv) {

        NonNullList<ItemStack> remaining =
                NonNullList.withSize(inv.getSizeInventory(), ItemStack.EMPTY);


        for (int i = 0; i < inv.getSizeInventory(); i++) {

            ItemStack stack = inv.getStackInSlot(i);

            if (!stack.isEmpty() && stack.getItem().isDamageable()) {

                ItemStack damaged = stack.copy();

                damaged.attemptDamageItem(
                        damageAmount,
                        null,
                        null
                );

                if (damaged.getItemDamage() < damaged.getMaxDamage()) {
                    remaining.set(i, damaged);
                }
            }
        }

        return remaining;
    }
}