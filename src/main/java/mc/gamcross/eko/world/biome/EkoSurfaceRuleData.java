package mc.gamcross.eko.world.biome;

//import net.minecraft.world.level.block.Block;
//import net.minecraft.world.level.block.Blocks;
//import net.minecraft.world.level.levelgen.MaterialRules;

// net/minecraft/world/gen/surfacebuilder/MaterialRules

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;

import net.minecraft.world.gen.surfacebuilder.MaterialRules;

public class EkoSurfaceRuleData {
    private static final MaterialRules.MaterialRule DIRT = makeStateRule(Blocks.DIRT);
    private static final MaterialRules.MaterialRule GRASS_BLOCK = makeStateRule(Blocks.GRASS_BLOCK);
    private static final MaterialRules.MaterialRule RED_TERRACOTTA = makeStateRule(Blocks.RED_TERRACOTTA);
    private static final MaterialRules.MaterialRule BLUE_TERRACOTTA = makeStateRule(Blocks.BLUE_TERRACOTTA);

     public static MaterialRules.MaterialRule makeRules()
    {
        MaterialRules.MaterialCondition isAtOrAboveWaterLevel = MaterialRules.water(-1, 0);
        MaterialRules.MaterialRule grassSurface = MaterialRules.sequence(MaterialRules.condition(isAtOrAboveWaterLevel, GRASS_BLOCK), DIRT);

        return MaterialRules.sequence(
                MaterialRules.condition(MaterialRules.biome(EkoBiomes.HOT_RED), RED_TERRACOTTA),
                MaterialRules.condition(MaterialRules.biome(EkoBiomes.COLD_BLUE), BLUE_TERRACOTTA),

                // Default to a grass and dirt surface
                MaterialRules.condition(MaterialRules.STONE_DEPTH_FLOOR, grassSurface)
        );
    }

    private static MaterialRules.MaterialRule makeStateRule(Block block)
    {
        return MaterialRules.block(block.getDefaultState());
    }
}
