package com.hyrul.prideflagmod;

import com.hyrul.prideflagmod.block.ModBlocks;
import com.hyrul.prideflagmod.item.ModItems;
import com.hyrul.prideflagmod.util.ModLootTableModifiers;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PrideFlags implements ModInitializer {
		public static final String MOD_ID = "prideflagmod";
		public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		ModLootTableModifiers.modifyLootTables();


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

		// Making them flammable
		FlammableBlockRegistry registry = FlammableBlockRegistry.getDefaultInstance();
		registry.add(ModBlocks.FLAG_BI, 30, 60);
		registry.add(ModBlocks.FLAG_TRANS, 30, 60);
		registry.add(ModBlocks.FLAG_GAY, 30, 60);
		registry.add(ModBlocks.FLAG_LESB, 30, 60);
		registry.add(ModBlocks.FLAG_INTER, 30, 60);
		registry.add(ModBlocks.FLAG_PRIDE, 30, 60);
		registry.add(ModBlocks.FLAG_PROGRESS, 30, 60);
		registry.add(ModBlocks.FLAG_POLYAMORY, 30, 60);
		registry.add(ModBlocks.FLAG_PANSEXUAL, 30, 60);
		registry.add(ModBlocks.FLAG_NONBINARY, 30, 60);
		registry.add(ModBlocks.FLAG_ASEXUAL, 30, 60);
		registry.add(ModBlocks.FLAG_AROMANTIC, 30, 60);
		registry.add(ModBlocks.FLAG_GENDERFLUID, 30, 60);
		registry.add(ModBlocks.FLAG_DEMIGIRL, 30, 60);
		registry.add(ModBlocks.FLAG_DEMIBOY, 30, 60);
		registry.add(ModBlocks.FLAG_TRANSFEM, 30, 60);
		registry.add(ModBlocks.FLAG_TRANSMEN, 30, 60);
	}
}