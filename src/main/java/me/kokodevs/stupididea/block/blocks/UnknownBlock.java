package me.kokodevs.stupididea.block.blocks;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.Material;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.apache.commons.compress.utils.Lists;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Random;

public class UnknownBlock extends Block {
    public UnknownBlock() {
        super(FabricBlockSettings.of(Material.STONE));
    }

    @Override
    public void onPlaced(World world, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack itemStack) {
        Iterable<Block> blockTypes = Registries.BLOCK;
        List<Block> blockList = Lists.newArrayList(blockTypes.iterator());

        Random random = new Random();
        int randomIndex = random.nextInt(blockList.size());

        Block randomBlock = blockList.get(randomIndex);

        world.setBlockState(pos, randomBlock.getDefaultState());
    }
}
