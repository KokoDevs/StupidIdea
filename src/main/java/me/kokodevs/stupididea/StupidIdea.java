package me.kokodevs.stupididea;

import me.kokodevs.stupididea.block.ModBlocks;
import me.kokodevs.stupididea.item.ModItemGroup;
import me.kokodevs.stupididea.item.ModItems;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.event.player.UseItemCallback;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StupidIdea implements ModInitializer {
	public static final String MOD_ID = "stupididea";
    public static final Logger LOGGER = LoggerFactory.getLogger("stupididea");

	@Override
	public void onInitialize() {
		ModItemGroup.registerItemGroups();
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
	}
}