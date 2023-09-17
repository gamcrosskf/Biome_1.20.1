package mc.gamcross.eko.item;

import Item;
import ItemConvertible;
import mc.gamcross.eko.EkoMod;
import mc.gamcross.eko.item.custom.DiamondDetectorItem;
import mc.gamcross.eko.item.custom.EkoApple;
import mc.gamcross.eko.item.custom.FragmentItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

public class EkoItems {
    public static final Item MYSTERIOUS_INGOT = registerItem("mysterious_ingot", new Item(new FabricItemSettings().maxCount(1)));
    public static final Item ENDERITE_INGOT = registerItem("enderite_ingot", new Item(new FabricItemSettings().maxCount(16)));

    // FRAGMENTS
    public static final Item MYSTERIOUS_FRAGMENT = registerItem("mysterious_fragment", new FragmentItem(new FabricItemSettings().rarity(Rarity.RARE)));
    public static final Item GARNET_FRAGMENT = registerItem("garnet_fragment", new FragmentItem(new FabricItemSettings().rarity(Rarity.RARE)));
    public static final Item AMBER_FRAGMENT = registerItem("amber_fragment", new FragmentItem(new FabricItemSettings().rarity(Rarity.RARE)));
    public static final Item OPAL_FRAGMENT = registerItem("opal_fragment", new FragmentItem(new FabricItemSettings().rarity(Rarity.RARE)));

    // AMBER TOOLS & ARMOR
    public static final ItemConvertible AMBER = registerItem("amber", new Item(new FabricItemSettings().rarity(Rarity.RARE)));
    public static final Item AMBER_PICKAXE = registerItem("amber_pickaxe",
            new PickaxeItem(EkoToolMaterial.AMBER, 1, 0.5f, new FabricItemSettings()));
    public static final Item AMBER_SWORD = registerItem("amber_sword",
            new SwordItem(EkoToolMaterial.AMBER, 4, 1f, new FabricItemSettings()));
    public static final Item AMBER_SHOVEL = registerItem("amber_shovel",
            new ShovelItem(EkoToolMaterial.AMBER, -1, -1f, new FabricItemSettings()));
    public static final Item AMBER_HOE = registerItem("amber_hoe",
            new HoeItem(EkoToolMaterial.AMBER, -1, -1f, new FabricItemSettings()));
    public static final Item AMBER_AXE = registerItem("amber_axe",
            new AxeItem(EkoToolMaterial.AMBER, 5, 0f, new FabricItemSettings()));

    // TOOLS
    public static final Item DIAMOND_DETECTOR = registerItem("diamond_detector", new DiamondDetectorItem(
            new FabricItemSettings().maxCount(1).maxDamage(128)));
    // FOODS
    public static final Item OPAL_APPLE = registerItem("opal_apple", new EkoApple(new FabricItemSettings().food(EkoFoodComponents.OpalApple)));

    private static void addItemsToIngredientItemGroup(FabricItemGroupEntries entries) {
        entries.add(MYSTERIOUS_INGOT);
    }
    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(EkoMod.MOD_ID, name), item);
    }
    public static void registerItems() {
        EkoMod.LOGGER.info("Registering Mod Items for", EkoMod.MOD_ID);

        //ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(Moditems::addItemsToIngredientItemGroup);
    }

}
