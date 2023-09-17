package mc.gamcross.eko.world.biome;

import mc.gamcross.eko.EkoMod;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;


//import net.minecraft.core.Registry;
//import net.minecraft.core.registries.Registries;
//import net.minecraft.resources.ResourceKey;
//import net.minecraft.resources.ResourceLocation;
//import net.minecraft.world.level.biome.Biome;


public class EkoBiomes {
    public static final RegistryKey<Biome> HOT_RED = register("hot_red");
    public static final RegistryKey<Biome> COLD_BLUE = register("cold_blue");


    private static RegistryKey<Biome> register(String name)
    {
        return RegistryKey.of(RegistryKeys.BIOME, new Identifier(EkoMod.MOD_ID, name));
    }

}
