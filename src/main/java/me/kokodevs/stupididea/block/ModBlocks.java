package me.kokodevs.stupididea.block;

import me.kokodevs.stupididea.StupidIdea;
import me.kokodevs.stupididea.block.blocks.BrownRedstone;
import me.kokodevs.stupididea.block.blocks.UnknownBlock;
import me.kokodevs.stupididea.item.ModItemGroup;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.block.Material;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

import java.util.HashMap;
import java.util.Map;

public class ModBlocks {
    public static final Block CITRINE_BLOCK = registerBlock("citrine_block",
            new Block(FabricBlockSettings.of(Material.STONE).strength(4.0f).requiresTool()),
            ModItemGroup.CITRINE);

    public static final Block CITRINE_ORE = registerBlock("citrine_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.of(Material.STONE).strength(4.0f).requiresTool(),
                    UniformIntProvider.create(3, 7)), ModItemGroup.CITRINE);

    public static final Block UNKNOWN_BLOCK = registerBlock("unknown_block",
            new UnknownBlock(), ModItemGroup.CITRINE);
    public static final Block BROWN_REDSTONE = registerBlock("brown_redstone",
            new BrownRedstone(), ModItemGroup.CITRINE);


    private static Block registerBlock(String name, Block block, ItemGroup group) {
        registerBlockItem(name, block, group);
        return Registry.register(Registries.BLOCK, new Identifier(StupidIdea.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block, ItemGroup group) {
        Item item = Registry.register(Registries.ITEM, new Identifier(StupidIdea.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(item));
        return item;
    }

    public static void registerModBlocks() {
        StupidIdea.LOGGER.info("Registering ModBlocks for " + StupidIdea.MOD_ID);
        BlockRenderLayerMap.INSTANCE.putBlock(BROWN_REDSTONE, RenderLayer.getCutout());
    }

}
