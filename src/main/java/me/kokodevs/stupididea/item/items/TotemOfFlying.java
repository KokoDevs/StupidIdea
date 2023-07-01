package me.kokodevs.stupididea.item.items;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class TotemOfFlying extends Item {
    public TotemOfFlying() {
        super(new FabricItemSettings());
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {

        user.getAbilities().allowFlying = !user.getAbilities().allowFlying;
        if (!user.getAbilities().allowFlying) user.getAbilities().flying = false;

        user.getItemCooldownManager().set(this, 100);

        return super.use(world, user, hand);
    }
}
