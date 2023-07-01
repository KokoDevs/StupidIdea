package me.kokodevs.stupididea.item;

import me.kokodevs.stupididea.StupidIdea;
import me.kokodevs.stupididea.item.items.TotemOfFlying;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item CITRINE = registerItem("citrine",
            new Item(new FabricItemSettings()));
    public static final Item RAW_CITRINE = registerItem("raw_citrine",
            new Item(new FabricItemSettings()));
    public static final Item TOTEM_OF_FLYING = registerItem("totem_of_flying",
            new TotemOfFlying());

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(StupidIdea.MOD_ID, name), item);
    }

    public static void addItemsToItemGroup() {
        addToItemGroup(ModItemGroup.CITRINE, CITRINE);
        addToItemGroup(ModItemGroup.CITRINE, RAW_CITRINE);
        addToItemGroup(ModItemGroup.CITRINE, TOTEM_OF_FLYING);
    }

    private static void addToItemGroup(ItemGroup group, Item item) {
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(item));
    }

    public static void registerModItems() {
        StupidIdea.LOGGER.info("Registering Mod Items for " + StupidIdea.MOD_ID);

        addItemsToItemGroup();
    }

}
