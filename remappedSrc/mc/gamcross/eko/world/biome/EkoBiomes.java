package mc.gamcross.eko.world.biome;

import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.world.biome.Biome;

import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class EkoBiomes {
    public static final RegistryKey<Biome> HOT_RED = register("hot_red");

    private static RegistryKey<Biome> register(String name) {
        return RegistryKey.of(RegistryKeys.BIOME, new Identifier(name));
    }
}
