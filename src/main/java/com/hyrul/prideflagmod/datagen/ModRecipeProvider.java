package com.hyrul.prideflagmod.datagen;

import com.hyrul.prideflagmod.PrideFlags;
import com.hyrul.prideflagmod.block.ModBlocks;
import com.hyrul.prideflagmod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.item.Items;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.HolderLookup;
import net.minecraft.resources.Identifier;

import java.util.Map;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {

    public ModRecipeProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeProvider createRecipeProvider(HolderLookup.Provider provider, RecipeOutput recipeOutput) {
        return new RecipeProvider(provider, recipeOutput) {

            @Override
            public void buildRecipes() {

                Map<ItemLike, Block> flagRecipes = Map.ofEntries(
                        Map.entry(ModItems.PATTERN_TRANS, ModBlocks.FLAG_TRANS),
                        Map.entry(ModItems.PATTERN_GAY, ModBlocks.FLAG_GAY),
                        Map.entry(ModItems.PATTERN_BI, ModBlocks.FLAG_BI),
                        Map.entry(ModItems.PATTERN_LESB, ModBlocks.FLAG_LESB),
                        Map.entry(ModItems.PATTERN_PRIDE, ModBlocks.FLAG_PRIDE),
                        Map.entry(ModItems.PATTERN_PROGRESS, ModBlocks.FLAG_PROGRESS),
                        Map.entry(ModItems.PATTERN_INTER, ModBlocks.FLAG_INTER),
                        Map.entry(ModItems.PATTERN_POLYAMORY, ModBlocks.FLAG_POLYAMORY),
                        Map.entry(ModItems.PATTERN_PANSEXUAL, ModBlocks.FLAG_PANSEXUAL),
                        Map.entry(ModItems.PATTERN_NONBINARY, ModBlocks.FLAG_NONBINARY),
                        Map.entry(ModItems.PATTERN_ASEXUAL, ModBlocks.FLAG_ASEXUAL),
                        Map.entry(ModItems.PATTERN_AROMANTIC, ModBlocks.FLAG_AROMANTIC),
                        Map.entry(ModItems.PATTERN_GENDERFLUID, ModBlocks.FLAG_GENDERFLUID),
                        Map.entry(ModItems.PATTERN_DEMIGIRL, ModBlocks.FLAG_DEMIGIRL),
                        Map.entry(ModItems.PATTERN_DEMIBOY, ModBlocks.FLAG_DEMIBOY),
                        Map.entry(ModItems.PATTERN_TRANSFEM, ModBlocks.FLAG_TRANSFEM),
                        Map.entry(ModItems.PATTERN_TRANSMEN, ModBlocks.FLAG_TRANSMEN)
                );

                for (Map.Entry<ItemLike, Block> entry : flagRecipes.entrySet()) {
                    ItemLike pattern = entry.getKey();
                    Block flag = entry.getValue();

                    shaped(RecipeCategory.DECORATIONS, flag)
                            .pattern("N N")
                            .pattern("WPW")
                            .pattern("   ")
                            .define('P', pattern)
                            .define('N', Items.IRON_NUGGET)
                            .define('W', Items.WHITE_WOOL)
                            .unlockedBy("has_" + BuiltInRegistries.ITEM.getKey(pattern.asItem()).getPath(), has(pattern))
                            .save(recipeOutput, ResourceKey.create(Registries.RECIPE, Identifier.fromNamespaceAndPath(PrideFlags.MOD_ID, getFlagId(flag) + "_top")));

                    shaped(RecipeCategory.DECORATIONS, flag)
                            .pattern("   ")
                            .pattern("N N")
                            .pattern("WPW")
                            .define('P', pattern)
                            .define('N', Items.IRON_NUGGET)
                            .define('W', Items.WHITE_WOOL)
                            .unlockedBy("has_" + BuiltInRegistries.ITEM.getKey(pattern.asItem()).getPath(), has(pattern))
                            .save(recipeOutput, ResourceKey.create(Registries.RECIPE, Identifier.fromNamespaceAndPath(PrideFlags.MOD_ID, getFlagId(flag) + "_bottom")));
                }

                Item[] whiteMaterial = {
                        Items.WHITE_DYE,
                        Items.BONE_MEAL
                };

                for (Item white : whiteMaterial) {

                    ShapelessRecipeBuilder transBuilder = shapeless(RecipeCategory.MISC, ModItems.PATTERN_TRANS)
                            .requires(Items.PAPER)
                            .requires(white)
                            .requires(Items.CYAN_DYE)
                            .requires(Items.PINK_DYE);
                    addUnlockCriteriaForItems(transBuilder, Items.PAPER, white, Items.CYAN_DYE, Items.PINK_DYE);
                    transBuilder.save(recipeOutput, ResourceKey.create(Registries.RECIPE, Identifier.fromNamespaceAndPath(PrideFlags.MOD_ID, "pattern_trans_" + BuiltInRegistries.ITEM.getKey(white).getPath())));

                    ShapelessRecipeBuilder progressBuilder = shapeless(RecipeCategory.MISC, ModItems.PATTERN_PROGRESS)
                            .requires(Items.PAPER)
                            .requires(white)
                            .requires(Items.CYAN_DYE)
                            .requires(Items.PINK_DYE)
                            .requires(Items.BLACK_DYE)
                            .requires(Items.BROWN_DYE);
                    addUnlockCriteriaForItems(progressBuilder, Items.PAPER, white, Items.CYAN_DYE, Items.PINK_DYE, Items.BLACK_DYE, Items.BROWN_DYE);
                    progressBuilder.save(recipeOutput, ResourceKey.create(Registries.RECIPE, Identifier.fromNamespaceAndPath(PrideFlags.MOD_ID, "pattern_progress_" + BuiltInRegistries.ITEM.getKey(white).getPath())));

                    ShapelessRecipeBuilder polyamoryBuilder = shapeless(RecipeCategory.MISC, ModItems.PATTERN_POLYAMORY)
                            .requires(Items.PAPER)
                            .requires(white)
                            .requires(Items.YELLOW_DYE)
                            .requires(Items.CYAN_DYE)
                            .requires(Items.PINK_DYE)
                            .requires(Items.PURPLE_DYE);
                    addUnlockCriteriaForItems(polyamoryBuilder, Items.PAPER, white, Items.CYAN_DYE, Items.PINK_DYE, Items.PURPLE_DYE, Items.YELLOW_DYE);
                    polyamoryBuilder.save(recipeOutput, ResourceKey.create(Registries.RECIPE, Identifier.fromNamespaceAndPath(PrideFlags.MOD_ID, "pattern_polyamory_" + BuiltInRegistries.ITEM.getKey(white).getPath())));

                    ShapelessRecipeBuilder nonbinaryBuilder = shapeless(RecipeCategory.MISC, ModItems.PATTERN_NONBINARY)
                            .requires(Items.PAPER)
                            .requires(white)
                            .requires(Items.YELLOW_DYE)
                            .requires(Items.BLACK_DYE)
                            .requires(Items.PURPLE_DYE);
                    addUnlockCriteriaForItems(nonbinaryBuilder, Items.PAPER, white, Items.BLACK_DYE, Items.PURPLE_DYE, Items.YELLOW_DYE);
                    nonbinaryBuilder.save(recipeOutput, ResourceKey.create(Registries.RECIPE, Identifier.fromNamespaceAndPath(PrideFlags.MOD_ID, "pattern_nonbinary_" + BuiltInRegistries.ITEM.getKey(white).getPath())));

                    ShapelessRecipeBuilder lesbianBuilder = shapeless(RecipeCategory.MISC, ModItems.PATTERN_LESB)
                            .requires(Items.PAPER)
                            .requires(white)
                            .requires(Items.PINK_DYE)
                            .requires(Items.MAGENTA_DYE)
                            .requires(Items.ORANGE_DYE)
                            .requires(Items.RED_DYE);
                    addUnlockCriteriaForItems(lesbianBuilder, Items.PAPER, white, Items.PINK_DYE, Items.MAGENTA_DYE, Items.ORANGE_DYE, Items.RED_DYE);
                    lesbianBuilder.save(recipeOutput, ResourceKey.create(Registries.RECIPE, Identifier.fromNamespaceAndPath(PrideFlags.MOD_ID, "pattern_lesbian_" + BuiltInRegistries.ITEM.getKey(white).getPath())));

                    ShapelessRecipeBuilder genderfluidbuilder = shapeless(RecipeCategory.MISC, ModItems.PATTERN_GENDERFLUID)
                            .requires(Items.PAPER)
                            .requires(white)
                            .requires(Items.PINK_DYE)
                            .requires(Items.PURPLE_DYE)
                            .requires(Items.BLACK_DYE)
                            .requires(Items.BLUE_DYE);
                    addUnlockCriteriaForItems(genderfluidbuilder, Items.PAPER, white, Items.PINK_DYE, Items.PURPLE_DYE, Items.BLACK_DYE, Items.BLUE_DYE);
                    genderfluidbuilder.save(recipeOutput, ResourceKey.create(Registries.RECIPE, Identifier.fromNamespaceAndPath(PrideFlags.MOD_ID, "pattern_genderfluid_" + BuiltInRegistries.ITEM.getKey(white).getPath())));

                    ShapelessRecipeBuilder gayBuilder = shapeless(RecipeCategory.MISC, ModItems.PATTERN_GAY)
                            .requires(Items.PAPER)
                            .requires(white)
                            .requires(Items.GREEN_DYE)
                            .requires(Items.LIME_DYE)
                            .requires(Items.BLUE_DYE)
                            .requires(Items.LIGHT_BLUE_DYE);
                    addUnlockCriteriaForItems(gayBuilder, Items.PAPER, white, Items.GREEN_DYE, Items.LIME_DYE, Items.LIGHT_BLUE_DYE, Items.BLUE_DYE);
                    gayBuilder.save(recipeOutput, ResourceKey.create(Registries.RECIPE, Identifier.fromNamespaceAndPath(PrideFlags.MOD_ID, "pattern_gay_" + BuiltInRegistries.ITEM.getKey(white).getPath())));

                    ShapelessRecipeBuilder asexualBuilder = shapeless(RecipeCategory.MISC, ModItems.PATTERN_ASEXUAL)
                            .requires(Items.PAPER)
                            .requires(white)
                            .requires(Items.BLACK_DYE)
                            .requires(Items.GRAY_DYE)
                            .requires(Items.PURPLE_DYE);
                    addUnlockCriteriaForItems(asexualBuilder, Items.PAPER, white, Items.BLACK_DYE, Items.GRAY_DYE, Items.PURPLE_DYE);
                    asexualBuilder.save(recipeOutput, ResourceKey.create(Registries.RECIPE, Identifier.fromNamespaceAndPath(PrideFlags.MOD_ID, "pattern_asexual_" + BuiltInRegistries.ITEM.getKey(white).getPath())));

                    ShapelessRecipeBuilder aromanticBuilder = shapeless(RecipeCategory.MISC, ModItems.PATTERN_AROMANTIC)
                            .requires(Items.PAPER)
                            .requires(white)
                            .requires(Items.BLACK_DYE)
                            .requires(Items.GRAY_DYE)
                            .requires(Items.GREEN_DYE)
                            .requires(Items.LIME_DYE);
                    addUnlockCriteriaForItems(aromanticBuilder, Items.PAPER, white, Items.BLACK_DYE, Items.GRAY_DYE, Items.GREEN_DYE, Items.LIME_DYE);
                    aromanticBuilder.save(recipeOutput, ResourceKey.create(Registries.RECIPE, Identifier.fromNamespaceAndPath(PrideFlags.MOD_ID, "pattern_aromantic_" + BuiltInRegistries.ITEM.getKey(white).getPath())));
                }

                ShapelessRecipeBuilder prideBuilder = shapeless(RecipeCategory.MISC, ModItems.PATTERN_PRIDE)
                        .requires(Items.PAPER)
                        .requires(Items.RED_DYE)
                        .requires(Items.ORANGE_DYE)
                        .requires(Items.YELLOW_DYE)
                        .requires(Items.GREEN_DYE)
                        .requires(Items.BLUE_DYE)
                        .requires(Items.PURPLE_DYE);
                addUnlockCriteriaForItems(prideBuilder, Items.PAPER, Items.RED_DYE, Items.ORANGE_DYE, Items.YELLOW_DYE, Items.GREEN_DYE, Items.BLUE_DYE, Items.PURPLE_DYE);
                prideBuilder.save(recipeOutput);

                ShapelessRecipeBuilder pansexualBuilder = shapeless(RecipeCategory.MISC, ModItems.PATTERN_PANSEXUAL)
                        .requires(Items.PAPER)
                        .requires(Items.YELLOW_DYE)
                        .requires(Items.CYAN_DYE)
                        .requires(Items.PINK_DYE);
                addUnlockCriteriaForItems(pansexualBuilder, Items.PAPER, Items.YELLOW_DYE, Items.CYAN_DYE, Items.PINK_DYE);
                pansexualBuilder.save(recipeOutput);

                ShapelessRecipeBuilder intersexBuilder = shapeless(RecipeCategory.MISC, ModItems.PATTERN_INTER)
                        .requires(Items.PAPER)
                        .requires(Items.YELLOW_DYE)
                        .requires(Items.PURPLE_DYE);
                addUnlockCriteriaForItems(intersexBuilder, Items.PAPER, Items.YELLOW_DYE, Items.PURPLE_DYE);
                intersexBuilder.save(recipeOutput);

                ShapelessRecipeBuilder bisexualBuilder = shapeless(RecipeCategory.MISC, ModItems.PATTERN_BI)
                        .requires(Items.PAPER)
                        .requires(Items.PINK_DYE)
                        .requires(Items.BLUE_DYE)
                        .requires(Items.PURPLE_DYE);
                addUnlockCriteriaForItems(bisexualBuilder, Items.PAPER, Items.PINK_DYE, Items.PURPLE_DYE, Items.BLUE_DYE);
                bisexualBuilder.save(recipeOutput);

                ShapelessRecipeBuilder demigirlBuilder = shapeless(RecipeCategory.MISC, ModItems.PATTERN_DEMIGIRL)
                        .requires(Items.PAPER)
                        .requires(Items.PINK_DYE)
                        .requires(Items.WHITE_DYE)
                        .requires(Items.GRAY_DYE)
                        .requires(Items.LIGHT_GRAY_DYE);
                addUnlockCriteriaForItems(demigirlBuilder, Items.PAPER, Items.PINK_DYE, Items.WHITE_DYE, Items.GRAY_DYE, Items.LIGHT_GRAY_DYE);
                demigirlBuilder.save(recipeOutput);

                ShapelessRecipeBuilder demiboyBuilder = shapeless(RecipeCategory.MISC, ModItems.PATTERN_DEMIBOY)
                        .requires(Items.PAPER)
                        .requires(Items.LIGHT_BLUE_DYE)
                        .requires(Items.WHITE_DYE)
                        .requires(Items.GRAY_DYE)
                        .requires(Items.LIGHT_GRAY_DYE);
                addUnlockCriteriaForItems(demiboyBuilder, Items.PAPER, Items.LIGHT_BLUE_DYE, Items.WHITE_DYE, Items.GRAY_DYE, Items.LIGHT_GRAY_DYE);
                demiboyBuilder.save(recipeOutput);

                ShapelessRecipeBuilder transfemBuilder = shapeless(RecipeCategory.MISC, ModItems.PATTERN_TRANSFEM)
                        .requires(Items.PAPER)
                        .requires(Items.PINK_DYE)
                        .requires(Items.LIGHT_BLUE_DYE)
                        .requires(Items.WHITE_DYE)
                        .requires(Items.MAGENTA_DYE);
                addUnlockCriteriaForItems(transfemBuilder, Items.PAPER, Items.PINK_DYE, Items.LIGHT_BLUE_DYE, Items.WHITE_DYE, Items.MAGENTA_DYE);
                transfemBuilder.save(recipeOutput);

                ShapelessRecipeBuilder transmenBuilder = shapeless(RecipeCategory.MISC, ModItems.PATTERN_TRANSMEN)
                        .requires(Items.PAPER)
                        .requires(Items.PINK_DYE)
                        .requires(Items.WHITE_DYE)
                        .requires(Items.BLUE_DYE)
                        .requires(Items.LIGHT_BLUE_DYE)
                        .requires(Items.PURPLE_DYE);
                addUnlockCriteriaForItems(transmenBuilder, Items.PAPER, Items.PINK_DYE, Items.WHITE_DYE, Items.BLUE_DYE, Items.LIGHT_BLUE_DYE, Items.PURPLE_DYE);
                transmenBuilder.save(recipeOutput);
            }

            private void addUnlockCriteriaForItems(ShapelessRecipeBuilder builder, Item... items) {
                for (Item item : items) {
                    String path = BuiltInRegistries.ITEM.getKey(item).getPath();
                    builder.unlockedBy("has_" + path, has(item));
                }
            }
        };
    }

    private static String getFlagId(Block flag) {
        return BuiltInRegistries.BLOCK.getKey(flag).getPath();
    }

    @Override
    public String getName() {
        return "PrideFlagsMod Recipes";
    }
}