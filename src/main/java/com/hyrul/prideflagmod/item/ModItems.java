package com.hyrul.prideflagmod.item;

import com.hyrul.prideflagmod.PrideFlags;
import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.core.Registry;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;

import java.util.function.Function;

public class ModItems {
    public static final Item PATTERN_BI = registerItem("pattern_bi", Item::new);
    public static final Item PATTERN_GAY = registerItem("pattern_gay", Item::new);
    public static final Item PATTERN_INTER = registerItem("pattern_inter", Item::new);
    public static final Item PATTERN_LESB = registerItem("pattern_lesb", Item::new);
    public static final Item PATTERN_TRANS = registerItem("pattern_trans", Item::new);
    public static final Item PATTERN_PRIDE = registerItem("pattern_pride", Item::new);
    public static final Item PATTERN_PROGRESS = registerItem("pattern_progress", Item::new);
    public static final Item PATTERN_POLYAMORY = registerItem("pattern_polyamory", Item::new);
    public static final Item PATTERN_PANSEXUAL = registerItem("pattern_pansexual", Item::new);
    public static final Item PATTERN_NONBINARY = registerItem("pattern_nonbinary", Item::new);
    public static final Item PATTERN_ASEXUAL = registerItem("pattern_asexual", Item::new);
    public static final Item PATTERN_AROMANTIC = registerItem("pattern_aromantic", Item::new);
    public static final Item PATTERN_GENDERFLUID = registerItem("pattern_genderfluid", Item::new);
    public static final Item PATTERN_DEMIGIRL = registerItem("pattern_demigirl", Item::new);
    public static final Item PATTERN_DEMIBOY = registerItem("pattern_demiboy", Item::new);
    public static final Item PATTERN_TRANSFEM = registerItem("pattern_transfem", Item::new);
    public static final Item PATTERN_TRANSMEN = registerItem("pattern_transmen", Item::new);

/*
    public static final Item SHIELD_TRANS = registerItem("shield_trans",
            setting -> new ModShieldItem(setting.maxDamage(336).maxCount(1)));
*/

    private static Item registerItem(String name, Function<Item.Properties, Item> function) {
        return Registry.register(BuiltInRegistries.ITEM, Identifier.fromNamespaceAndPath(PrideFlags.MOD_ID, name),
                function.apply(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(PrideFlags.MOD_ID, name)))));
    }

    public static void registerModItems() {
        PrideFlags.LOGGER.info("Registering items for " + PrideFlags.MOD_ID);

        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.COLORED_BLOCKS).register((creativeTab) -> {
            creativeTab.accept(PATTERN_BI);
            creativeTab.accept(PATTERN_GAY);
            creativeTab.accept(PATTERN_INTER);
            creativeTab.accept(PATTERN_LESB);
            creativeTab.accept(PATTERN_TRANS);
            creativeTab.accept(PATTERN_PRIDE);
            creativeTab.accept(PATTERN_PROGRESS);
            creativeTab.accept(PATTERN_POLYAMORY);
            creativeTab.accept(PATTERN_PANSEXUAL);
            creativeTab.accept(PATTERN_NONBINARY);
            creativeTab.accept(PATTERN_ASEXUAL);
            creativeTab.accept(PATTERN_AROMANTIC);
            creativeTab.accept(PATTERN_GENDERFLUID);
            creativeTab.accept(PATTERN_DEMIGIRL);
            creativeTab.accept(PATTERN_DEMIBOY);
            creativeTab.accept(PATTERN_TRANSFEM);
            creativeTab.accept(PATTERN_TRANSMEN);
        });

//        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(entries -> {
//            entries.add(SHIELD_TRANS);
//        });
    }
}