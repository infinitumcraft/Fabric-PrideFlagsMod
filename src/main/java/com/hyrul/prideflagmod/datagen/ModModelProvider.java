package com.hyrul.prideflagmod.datagen;

import com.hyrul.prideflagmod.block.ModBlocks;
import com.hyrul.prideflagmod.item.ModItems;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.model.ModelTemplates;

public class ModModelProvider extends FabricModelProvider {

    Item[] pridePatterns = {
            ModItems.PATTERN_BI,
            ModItems.PATTERN_GAY,
            ModItems.PATTERN_INTER,
            ModItems.PATTERN_LESB,
            ModItems.PATTERN_TRANS,
            ModItems.PATTERN_PRIDE,
            ModItems.PATTERN_PROGRESS,
            ModItems.PATTERN_POLYAMORY,
            ModItems.PATTERN_PANSEXUAL,
            ModItems.PATTERN_NONBINARY,
            ModItems.PATTERN_ASEXUAL,
            ModItems.PATTERN_AROMANTIC,
            ModItems.PATTERN_GENDERFLUID,
            ModItems.PATTERN_DEMIGIRL,
            ModItems.PATTERN_DEMIBOY,
            ModItems.PATTERN_TRANSFEM,
            ModItems.PATTERN_TRANSMEN
    };

    Block[] prideFlags = {
            ModBlocks.FLAG_BI,
            ModBlocks.FLAG_GAY,
            ModBlocks.FLAG_INTER,
            ModBlocks.FLAG_LESB,
            ModBlocks.FLAG_TRANS,
            ModBlocks.FLAG_PRIDE,
            ModBlocks.FLAG_PROGRESS,
            ModBlocks.FLAG_POLYAMORY,
            ModBlocks.FLAG_PANSEXUAL,
            ModBlocks.FLAG_NONBINARY,
            ModBlocks.FLAG_ASEXUAL,
            ModBlocks.FLAG_AROMANTIC,
            ModBlocks.FLAG_GENDERFLUID,
            ModBlocks.FLAG_DEMIGIRL,
            ModBlocks.FLAG_DEMIBOY,
            ModBlocks.FLAG_TRANSFEM,
            ModBlocks.FLAG_TRANSMEN
    };

    public ModModelProvider(FabricPackOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators blockStateModelGenerator) {
        for (Block flag : prideFlags) {
            blockStateModelGenerator.createNonTemplateHorizontalBlock(flag);
        }
    }

    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerator) {
        for (Item pattern : pridePatterns) {
            itemModelGenerator.generateFlatItem(pattern, ModelTemplates.FLAT_ITEM);
        }

        for (Block flag : prideFlags) {
            itemModelGenerator.generateFlatItem(flag.asItem(), ModelTemplates.FLAT_ITEM);
        }
    }
}