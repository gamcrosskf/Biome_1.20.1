package mc.gamcross.eko;

import mc.gamcross.eko.block.EkoBlocks;
import mc.gamcross.eko.item.EkoItemGroups;
import mc.gamcross.eko.item.EkoItems;
import mc.gamcross.eko.world.biome.custom.EkoRegion1;
import mc.gamcross.eko.world.dimension.EkoDimensions;
import net.fabricmc.api.ModInitializer;

import net.minecraft.util.Identifier;
import net.minecraft.world.gen.surfacebuilder.VanillaSurfaceRules;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import terrablender.api.Regions;
import terrablender.api.SurfaceRuleManager;
import terrablender.api.TerraBlenderApi;

public class EkoMod implements ModInitializer, TerraBlenderApi {
	public static final String MOD_ID = "eko";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		EkoItemGroups.registerItemGroups();

		EkoItems.registerItems();
		EkoBlocks.registerBlocks();

		EkoDimensions.register();
	}

	@Override
	public void onTerraBlenderInitialized() {
		Regions.register(new EkoRegion1(new Identifier(MOD_ID, "hot_red"), 2));

		// Register our surface rules
		SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD, MOD_ID, VanillaSurfaceRules.getEndStoneRule());
	}
}
