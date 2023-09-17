package mc.gamcross.eko.item;

import mc.gamcross.eko.EkoMod;
import mc.gamcross.eko.block.EkoBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class EkoItemGroups {
    public static final ItemGroup EKO_BLOCK = Registry.register(Registries.ITEM_GROUP,
            new Identifier(EkoMod.MOD_ID, "eko_block"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.eko_block"))
                    .icon(() -> new ItemStack(EkoBlocks.ENDERITE_BLOCK)).entries((displayContext, entries) -> {
                        entries.add(EkoBlocks.ENDERITE_BLOCK);
                        entries.add(EkoBlocks.END_STONE_MYSTERIOUS_ORE);
                        entries.add(EkoBlocks.DEEPSLATE_AMBER_ORE);
                        entries.add(EkoBlocks.DEEPSLATE_OPAL_ORE);
                        entries.add(EkoBlocks.NETHERACK_GARNET_ORE);
                    }).build());
    public static final ItemGroup EKO_INGREDIENT = Registry.register(Registries.ITEM_GROUP,
            new Identifier(EkoMod.MOD_ID, "eko_ingredient"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.eko_ingredient"))
                    .icon(() -> new ItemStack(EkoItems.MYSTERIOUS_INGOT)).entries((displayContext, entries) -> {
                        entries.add(EkoItems.MYSTERIOUS_INGOT);
                        entries.add(EkoItems.ENDERITE_INGOT);
                        entries.add(EkoItems.MYSTERIOUS_FRAGMENT);
                        entries.add(EkoItems.GARNET_FRAGMENT);
                        entries.add(EkoItems.AMBER_FRAGMENT);
                        entries.add(EkoItems.OPAL_FRAGMENT);
            }).build());

    public static final ItemGroup EKO_TOOL = Registry.register(Registries.ITEM_GROUP,
            new Identifier(EkoMod.MOD_ID, "eko_tool"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.eko_tool"))
                    .icon(() -> new ItemStack(EkoItems.AMBER_SWORD)).entries((displayContext, entries) -> {
                        entries.add(EkoItems.AMBER_SWORD);
                        entries.add(EkoItems.AMBER_PICKAXE);
                        entries.add(EkoItems.AMBER_AXE);
                        entries.add(EkoItems.AMBER_SHOVEL);
                        entries.add(EkoItems.AMBER_HOE);
                        entries.add(EkoItems.DIAMOND_DETECTOR);
                    }).build());

    public static final ItemGroup EKO_FOODS = Registry.register(Registries.ITEM_GROUP,
            new Identifier(EkoMod.MOD_ID, "eko_food"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.eko_food"))
                    .icon(() -> new ItemStack(EkoItems.OPAL_APPLE)).entries((displayContext, entries) -> {
                        entries.add(EkoItems.OPAL_APPLE);
                    }).build());

    public static void registerItemGroups() {
        EkoMod.LOGGER.info("Registering Mod Item Groups for", EkoMod.MOD_ID);
    }
}
