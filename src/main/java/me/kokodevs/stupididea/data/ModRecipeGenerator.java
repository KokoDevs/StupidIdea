package me.kokodevs.stupididea.data;

import me.kokodevs.stupididea.block.ModBlocks;
import me.kokodevs.stupididea.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeGenerator extends FabricRecipeProvider {
    public ModRecipeGenerator(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {
        offerSmelting(exporter, List.of(ModItems.RAW_CITRINE), RecipeCategory.MISC, ModItems.CITRINE,
                0.7f, 200, "citrine");
        offerSmelting(exporter, List.of(ModBlocks.CITRINE_ORE.asItem()), RecipeCategory.MISC, ModItems.CITRINE,
                0.7f, 200, "citrine");

        offerBlasting(exporter, List.of(ModItems.RAW_CITRINE), RecipeCategory.MISC, ModItems.CITRINE,
                1.2f, 100, "citrine");
        offerBlasting(exporter, List.of(ModBlocks.CITRINE_ORE.asItem()), RecipeCategory.MISC, ModItems.CITRINE,
                1.2f, 100, "citrine");
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.CITRINE, RecipeCategory.DECORATIONS,
                ModBlocks.CITRINE_BLOCK);

        //Totem of flying
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.TOTEM_OF_FLYING)
                .pattern("SSS")
                .pattern("SCS")
                .pattern("SSS")
                .input('S', Items.PHANTOM_MEMBRANE)
                .input('C', Items.TOTEM_OF_UNDYING)
                .criterion(FabricRecipeProvider.hasItem(Items.TOTEM_OF_UNDYING),
                        FabricRecipeProvider.conditionsFromItem(Items.TOTEM_OF_UNDYING))
                .criterion(FabricRecipeProvider.hasItem(Items.PHANTOM_MEMBRANE),
                        FabricRecipeProvider.conditionsFromItem(Items.PHANTOM_MEMBRANE))
                .offerTo(exporter, new Identifier(FabricRecipeProvider.getRecipeName(ModItems.TOTEM_OF_FLYING)));
        //Unknown Block
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.UNKNOWN_BLOCK.asItem())
                .pattern("SCS")
                .pattern("CSC")
                .pattern("SCS")
                .input('S', Items.WHITE_CONCRETE)
                .input('C', Items.BLACK_CONCRETE)
                .criterion(FabricRecipeProvider.hasItem(Items.WHITE_CONCRETE),
                        FabricRecipeProvider.conditionsFromItem(Items.WHITE_CONCRETE))
                .criterion(FabricRecipeProvider.hasItem(Items.BLACK_CONCRETE),
                        FabricRecipeProvider.conditionsFromItem(Items.BLACK_CONCRETE))
                .offerTo(exporter, new Identifier(FabricRecipeProvider.getRecipeName(ModBlocks.UNKNOWN_BLOCK.asItem())));

    }
}
