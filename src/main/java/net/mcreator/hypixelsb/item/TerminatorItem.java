
package net.mcreator.hypixelsb.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;
import net.minecraft.network.chat.Component;

import net.mcreator.hypixelsb.procedures.TerminatorProcedureProcedure;

import java.util.List;

public class TerminatorItem extends Item {
	public TerminatorItem() {
		super(new Item.Properties().tab(CreativeModeTab.TAB_COMBAT).stacksTo(1).fireResistant().rarity(Rarity.EPIC));
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
		list.add(Component.literal("§7Damage: §r§c+100"));
        list.add(Component.literal("§7Bonus Attack Speed: §r§c+200%"));
        list.add(Component.literal(""));
        list.add(Component.literal("§6Shortbow: Instantly shoots!"));
        list.add(Component.literal("§7Shoots §r§d3 §r§7arrows at once."));
        list.add(Component.literal(""));
        list.add(Component.literal("§6§lLEGENDARY BOW"));
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
		InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
		ItemStack itemstack = ar.getObject();
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();

		TerminatorProcedureProcedure.execute(world, x, y, z, entity);
		return ar;
	}
}
