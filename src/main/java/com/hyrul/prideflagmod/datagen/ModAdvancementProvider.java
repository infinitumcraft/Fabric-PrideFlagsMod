package com.hyrul.prideflagmod.datagen;

import com.hyrul.prideflagmod.PrideFlags;
import com.hyrul.prideflagmod.block.ModBlocks;
import com.hyrul.prideflagmod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.advancements.AdvancementType;
import net.minecraft.advancements.criterion.InventoryChangeTrigger;
import net.minecraft.core.HolderLookup;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.advancements.AdvancementRequirements;

import java.util.List;
import java.util.Arrays;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class ModAdvancementProvider extends FabricAdvancementProvider {

    public ModAdvancementProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(output, registryLookup);
    }

    @Override
    public void generateAdvancement(HolderLookup.Provider wrapperLookup, Consumer<AdvancementHolder> consumer) {

        AdvancementHolder getPattern = Advancement.Builder.advancement()
                .parent(Identifier.fromNamespaceAndPath("minecraft", "husbandry/root"))
                .display(
                        ModItems.PATTERN_PROGRESS,
                        Component.translatable("advancement.prideflagmod.got_pattern.title"),
                        Component.translatable("advancement.prideflagmod.got_pattern.description"),
                        Identifier.fromNamespaceAndPath("minecraft", "textures/gui/advancements/backgrounds/adventure.png"),
                        AdvancementType.TASK,
                        true,
                        true,
                        false
                )
                .addCriterion("has_pride", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.PATTERN_PRIDE))
                .addCriterion("has_trans", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.PATTERN_TRANS))
                .addCriterion("has_gay", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.PATTERN_GAY))
                .addCriterion("has_bi", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.PATTERN_BI))
                .addCriterion("has_lesb", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.PATTERN_LESB))
                .addCriterion("has_progress", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.PATTERN_PROGRESS))
                .addCriterion("has_inter", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.PATTERN_INTER))
                .addCriterion("has_polyamory", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.PATTERN_POLYAMORY))
                .addCriterion("has_pansexual", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.PATTERN_PANSEXUAL))
                .addCriterion("has_nonbinary", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.PATTERN_NONBINARY))
                .addCriterion("has_asexual", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.PATTERN_ASEXUAL))
                .addCriterion("has_aromantic", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.PATTERN_AROMANTIC))
                .addCriterion("has_genderfluid", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.PATTERN_GENDERFLUID))
                .addCriterion("has_demigirl", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.PATTERN_DEMIGIRL))
                .addCriterion("has_demiboy", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.PATTERN_DEMIBOY))
                .addCriterion("has_transfem", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.PATTERN_TRANSFEM))
                .addCriterion("has_transmen", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.PATTERN_TRANSMEN))
                .requirements(new AdvancementRequirements(
                        List.of(
                                Arrays.asList(
                                        "has_pride",
                                        "has_trans",
                                        "has_gay",
                                        "has_bi",
                                        "has_lesb",
                                        "has_progress",
                                        "has_inter",
                                        "has_polyamory",
                                        "has_pansexual",
                                        "has_nonbinary",
                                        "has_asexual",
                                        "has_aromantic",
                                        "has_genderfluid",
                                        "has_demigirl",
                                        "has_demiboy",
                                        "has_transfem",
                                        "has_transmen"
                                )
                        )
                ))
                .build(Identifier.fromNamespaceAndPath(PrideFlags.MOD_ID, "got_pattern"));

        consumer.accept(getPattern);


        AdvancementHolder getFlag = Advancement.Builder.advancement()
                .parent(getPattern)
                .display(
                        ModBlocks.FLAG_PROGRESS,
                        Component.translatable("advancement.prideflagmod.got_flag.title"),
                        Component.translatable("advancement.prideflagmod.got_flag.description"),
                        Identifier.fromNamespaceAndPath("minecraft", "textures/gui/advancements/backgrounds/adventure.png"),
                        AdvancementType.TASK,
                        true,
                        true,
                        false
                )
                .addCriterion("has_pride_flag", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.FLAG_PRIDE))
                .addCriterion("has_trans_flag", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.FLAG_TRANS))
                .addCriterion("has_gay_flag", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.FLAG_GAY))
                .addCriterion("has_bi_flag", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.FLAG_BI))
                .addCriterion("has_lesb_flag", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.FLAG_LESB))
                .addCriterion("has_progress_flag", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.FLAG_PROGRESS))
                .addCriterion("has_inter_flag", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.FLAG_INTER))
                .addCriterion("has_polyamory_flag", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.FLAG_POLYAMORY))
                .addCriterion("has_pansexual_flag", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.FLAG_PANSEXUAL))
                .addCriterion("has_nonbinary_flag", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.FLAG_NONBINARY))
                .addCriterion("has_asexual_flag", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.FLAG_ASEXUAL))
                .addCriterion("has_aromantic_flag", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.FLAG_AROMANTIC))
                .addCriterion("has_genderfluid_flag", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.FLAG_GENDERFLUID))
                .addCriterion("has_demigirl_flag", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.FLAG_DEMIGIRL))
                .addCriterion("has_demiboy_flag", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.FLAG_DEMIBOY))
                .addCriterion("has_transfem_flag", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.FLAG_TRANSFEM))
                .addCriterion("has_transmen_flag", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.FLAG_TRANSMEN))
                .requirements(new AdvancementRequirements(
                        List.of(
                                Arrays.asList(
                                        "has_pride_flag",
                                        "has_trans_flag",
                                        "has_gay_flag",
                                        "has_bi_flag",
                                        "has_lesb_flag",
                                        "has_progress_flag",
                                        "has_inter_flag",
                                        "has_polyamory_flag",
                                        "has_pansexual_flag",
                                        "has_nonbinary_flag",
                                        "has_asexual_flag",
                                        "has_aromantic_flag",
                                        "has_genderfluid_flag",
                                        "has_demigirl_flag",
                                        "has_demiboy_flag",
                                        "has_transfem_flag",
                                        "has_transmen_flag"
                                )
                        )
                ))
                .build(Identifier.fromNamespaceAndPath(PrideFlags.MOD_ID, "got_flag"));

        consumer.accept(getFlag);
    }
}