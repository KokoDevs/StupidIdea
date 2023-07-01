package me.kokodevs.stupididea.data;

import me.kokodevs.stupididea.StupidIdea;
import me.kokodevs.stupididea.block.ModBlocks;
import me.kokodevs.stupididea.item.ModItems;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.Blocks;
import net.minecraft.block.enums.WireConnection;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.data.client.*;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.CITRINE_BLOCK);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.CITRINE_ORE);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.UNKNOWN_BLOCK);
        //redstone
        blockStateModelGenerator.blockStateCollector.accept(
                MultipartBlockStateSupplier.create(ModBlocks.BROWN_REDSTONE)
                        .with(When.anyOf(
                                When.create()
                                        .set(Properties.NORTH_WIRE_CONNECTION, WireConnection.NONE)
                                        .set(Properties.EAST_WIRE_CONNECTION, WireConnection.NONE)
                                        .set(Properties.SOUTH_WIRE_CONNECTION, WireConnection.NONE)
                                        .set(Properties.WEST_WIRE_CONNECTION, WireConnection.NONE), When.create()
                                        .set(Properties.NORTH_WIRE_CONNECTION, WireConnection.SIDE, new WireConnection[]{WireConnection.UP})
                                        .set(Properties.EAST_WIRE_CONNECTION, WireConnection.SIDE, WireConnection.UP), When.create()
                                        .set(Properties.EAST_WIRE_CONNECTION, WireConnection.SIDE, new WireConnection[]{WireConnection.UP})
                                        .set(Properties.SOUTH_WIRE_CONNECTION, WireConnection.SIDE, WireConnection.UP), When.create()
                                        .set(Properties.SOUTH_WIRE_CONNECTION, WireConnection.SIDE, new WireConnection[]{WireConnection.UP})
                                        .set(Properties.WEST_WIRE_CONNECTION, WireConnection.SIDE, WireConnection.UP), When.create()
                                        .set(Properties.WEST_WIRE_CONNECTION, WireConnection.SIDE, new WireConnection[]{WireConnection.UP})
                                        .set(Properties.NORTH_WIRE_CONNECTION, WireConnection.SIDE, WireConnection.UP)), BlockStateVariant.create().put(VariantSettings.MODEL, getModNamespacedBlock("redstone_dust_dot"))).with(When.create()
                                .set(Properties.NORTH_WIRE_CONNECTION, WireConnection.SIDE, WireConnection.UP), BlockStateVariant.create().put(VariantSettings.MODEL, getModNamespacedBlock("redstone_dust_side0"))).with(When.create()
                                .set(Properties.SOUTH_WIRE_CONNECTION, WireConnection.SIDE, WireConnection.UP), BlockStateVariant.create().put(VariantSettings.MODEL, getModNamespacedBlock("redstone_dust_side_alt0"))).with(When.create()
                                .set(Properties.EAST_WIRE_CONNECTION, WireConnection.SIDE, WireConnection.UP), BlockStateVariant.create().put(VariantSettings.MODEL, getModNamespacedBlock("redstone_dust_side_alt1")).put(VariantSettings.Y, VariantSettings.Rotation.R270)).with(When.create()
                                .set(Properties.WEST_WIRE_CONNECTION, WireConnection.SIDE, WireConnection.UP), BlockStateVariant.create().put(VariantSettings.MODEL, getModNamespacedBlock("redstone_dust_side1")).put(VariantSettings.Y, VariantSettings.Rotation.R270)).with(When.create()
                                .set(Properties.NORTH_WIRE_CONNECTION, WireConnection.UP), BlockStateVariant.create().put(VariantSettings.MODEL, getModNamespacedBlock("redstone_dust_up"))).with(When.create()
                                .set(Properties.EAST_WIRE_CONNECTION, WireConnection.UP), BlockStateVariant.create().put(VariantSettings.MODEL, getModNamespacedBlock("redstone_dust_up")).put(VariantSettings.Y, VariantSettings.Rotation.R90)).with(When.create()
                                .set(Properties.SOUTH_WIRE_CONNECTION, WireConnection.UP), BlockStateVariant.create().put(VariantSettings.MODEL, getModNamespacedBlock("redstone_dust_up")).put(VariantSettings.Y, VariantSettings.Rotation.R180)).with(When.create()
                                .set(Properties.WEST_WIRE_CONNECTION, WireConnection.UP), BlockStateVariant.create().put(VariantSettings.MODEL, getModNamespacedBlock("redstone_dust_up")).put(VariantSettings.Y, VariantSettings.Rotation.R270)));
    }
    
    private Identifier getModNamespacedBlock(String name) {
        return new Identifier(StupidIdea.MOD_ID, "block/" + name);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.CITRINE, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_CITRINE, Models.GENERATED);
        itemModelGenerator.register(ModItems.TOTEM_OF_FLYING, Models.GENERATED);
        itemModelGenerator.register(ModBlocks.BROWN_REDSTONE.asItem(), Models.GENERATED);
    }
}
