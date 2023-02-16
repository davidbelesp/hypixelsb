
package net.mcreator.hypixelsb.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.network.chat.Component;

import java.util.List;

public class WitherHealingItem extends Item {
	public WitherHealingItem() {
		super(new Item.Properties().tab(CreativeModeTab.TAB_MISC).stacksTo(1).rarity(Rarity.COMMON));
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
		list.add(Component.literal(""));
		list.add(Component.literal("§6Ability: Wither Healing"));
		list.add(Component.literal("§7Grants §r§eAbsortion §r§7and heals §r§c40% §r§7of"));
		list.add(Component.literal("§7your health."));
		list.add(Component.literal(""));
		list.add(Component.literal("\u00A75\u00A7lEPIC"));
	}
}
