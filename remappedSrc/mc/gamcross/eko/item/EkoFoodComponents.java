package mc.gamcross.eko.item;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;

public class EkoFoodComponents {
    public static final FoodComponent OpalApple = (new FoodComponent.Builder()
            .hunger(20).saturationModifier(2F).statusEffect(
                    new StatusEffectInstance(StatusEffects.RESISTANCE, -1, 1, true, false), 1f)).build();
}
