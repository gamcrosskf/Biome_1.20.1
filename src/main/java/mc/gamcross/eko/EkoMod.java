package mc.gamcross.eko;

import mc.gamcross.eko.world.biome.custom.Eko_Cold_Blue_Biome;
import mc.gamcross.eko.world.biome.custom.Eko_Hot_Red_Biome;
import mc.gamcross.eko.world.biome.EkoSurfaceRuleData;
import net.fabricmc.api.ModInitializer;

import net.minecraft.resources.ResourceLocation;
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
	}

	@Override
	public void onTerraBlenderInitialized() {
		Regions.register(new Eko_Cold_Blue_Biome(new ResourceLocation(MOD_ID, "overworld_1"), 2));
		Regions.register(new Eko_Hot_Red_Biome(new ResourceLocation(MOD_ID, "overworld_2"), 2));

		SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD, MOD_ID, EkoSurfaceRuleData.makeRules());
	}
}
