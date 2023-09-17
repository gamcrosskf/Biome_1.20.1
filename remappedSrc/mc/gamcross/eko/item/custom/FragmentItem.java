/*
 * Decompiled with CFR 0.2.1 (FabricMC 53fa44c9).
 */
package mc.gamcross.eko.item.custom;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class FragmentItem
        extends Item {
    public FragmentItem(Item.Settings settings) {
        super(settings);
    }

    @Override
    public boolean hasGlint(ItemStack stack) {
        return true;
    }
}

