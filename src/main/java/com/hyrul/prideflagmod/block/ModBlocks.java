package com.hyrul.prideflagmod.block;

import com.hyrul.prideflagmod.PrideFlags;
import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.resources.Identifier;

public class ModBlocks {

    public static final Block FLAG_TRANS = registerBlock("flag_trans", WallFlagBlock::new);
    public static final Block FLAG_GAY = registerBlock("flag_gay", WallFlagBlock::new);
    public static final Block FLAG_BI = registerBlock("flag_bi", WallFlagBlock::new);
    public static final Block FLAG_LESB = registerBlock("flag_lesb", WallFlagBlock::new);
    public static final Block FLAG_INTER = registerBlock("flag_inter", WallFlagBlock::new);
    public static final Block FLAG_PRIDE = registerBlock("flag_pride", WallFlagBlock::new);
    public static final Block FLAG_PROGRESS = registerBlock("flag_progress", WallFlagBlock::new);
    public static final Block FLAG_POLYAMORY = registerBlock("flag_polyamory", WallFlagBlock::new);
    public static final Block FLAG_PANSEXUAL = registerBlock("flag_pansexual", WallFlagBlock::new);
    public static final Block FLAG_NONBINARY = registerBlock("flag_nonbinary", WallFlagBlock::new);
    public static final Block FLAG_ASEXUAL = registerBlock("flag_asexual", WallFlagBlock::new);
    public static final Block FLAG_AROMANTIC = registerBlock("flag_aromantic", WallFlagBlock::new);
    public static final Block FLAG_GENDERFLUID = registerBlock("flag_genderfluid", WallFlagBlock::new);
    public static final Block FLAG_DEMIGIRL = registerBlock("flag_demigirl", WallFlagBlock::new);
    public static final Block FLAG_DEMIBOY = registerBlock("flag_demiboy", WallFlagBlock::new);
    public static final Block FLAG_TRANSFEM = registerBlock("flag_transfem", WallFlagBlock::new);
    public static final Block FLAG_TRANSMEN = registerBlock("flag_transmen", WallFlagBlock::new);

    private static BlockBehaviour.Properties createWallFlagSettings(ResourceKey<Block> blockKey) {
        return BlockBehaviour.Properties.of()
                .setId(blockKey)
                .strength(0.5f, 0.8f)
                .noOcclusion()
                .sound(SoundType.WOOL);
    }

    private static Block registerBlock(String name, java.util.function.Function<BlockBehaviour.Properties, Block> factory) {
        Identifier id = Identifier.fromNamespaceAndPath(PrideFlags.MOD_ID, name);
        ResourceKey<Block> blockKey = ResourceKey.create(Registries.BLOCK, id);

        BlockBehaviour.Properties settings = createWallFlagSettings(blockKey);

        Block block = factory.apply(settings);
        registerBlockItem(name, block);
        return Registry.register(BuiltInRegistries.BLOCK, id, block);
    }

    private static void registerBlockItem(String name, Block block) {
        Identifier id = Identifier.fromNamespaceAndPath(PrideFlags.MOD_ID, name);
        ResourceKey<Item> itemKey = ResourceKey.create(Registries.ITEM, id);

        Registry.register(BuiltInRegistries.ITEM, id,
                new BlockItem(block, new Item.Properties()
                        .useBlockDescriptionPrefix()
                        .setId(itemKey)));
    }

    public static void registerModBlocks() {
        PrideFlags.LOGGER.info("Registering blocks for " + PrideFlags.MOD_ID);

        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.COLORED_BLOCKS).register((creativeTab) -> {
            creativeTab.accept(ModBlocks.FLAG_BI);
            creativeTab.accept(ModBlocks.FLAG_TRANS);
            creativeTab.accept(ModBlocks.FLAG_GAY);
            creativeTab.accept(ModBlocks.FLAG_LESB);
            creativeTab.accept(ModBlocks.FLAG_INTER);
            creativeTab.accept(ModBlocks.FLAG_PRIDE);
            creativeTab.accept(ModBlocks.FLAG_PROGRESS);
            creativeTab.accept(ModBlocks.FLAG_POLYAMORY);
            creativeTab.accept(ModBlocks.FLAG_PANSEXUAL);
            creativeTab.accept(ModBlocks.FLAG_NONBINARY);
            creativeTab.accept(ModBlocks.FLAG_ASEXUAL);
            creativeTab.accept(ModBlocks.FLAG_AROMANTIC);
            creativeTab.accept(ModBlocks.FLAG_GENDERFLUID);
            creativeTab.accept(ModBlocks.FLAG_DEMIGIRL);
            creativeTab.accept(ModBlocks.FLAG_DEMIBOY);
            creativeTab.accept(ModBlocks.FLAG_TRANSFEM);
            creativeTab.accept(ModBlocks.FLAG_TRANSMEN);
        }
        );
    }
}