
package net.mcreator.hypixelsb.item;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

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

import net.mcreator.hypixelsb.procedures.BoosterCookieProcedureProcedure;

import java.util.List;

public class BoosterCookieItem extends Item {
	public BoosterCookieItem() {
		super(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).stacksTo(1).fireResistant().rarity(Rarity.EPIC));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public boolean isFoil(ItemStack itemstack) {
		return true;
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag); 
		list.add(Component.literal(""));
		list.add(Component.literal("§7Consume to gain the§d Cookie Buff§r§7 for §r§bThis §7session"));
		list.add(Component.literal(""));
		list.add(Component.literal("§ePermafly §r§7on private islands"));
		list.add(Component.literal(""));
		list.add(Component.literal("§6§lLEGENDARY"));
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
		InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
		ItemStack itemstack = ar.getObject();
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();

		BoosterCookieProcedureProcedure.execute(entity);
		return ar;
	}
}
