package mc.gamcross.eko.item.custom;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class EkoApple extends Item {
    public EkoApple(Settings settings) {
        super(settings);
    }
    @Override
    public boolean hasGlint(ItemStack stack) {
        return true;
    }
}
