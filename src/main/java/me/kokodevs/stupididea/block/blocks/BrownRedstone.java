package me.kokodevs.stupididea.block.blocks;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Material;
import net.minecraft.block.RedstoneWireBlock;

public class BrownRedstone extends RedstoneWireBlock {
    public BrownRedstone() {
        super(FabricBlockSettings.of(Material.STONE));
    }
}
