
package net.mcreator.hypixelsb.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.network.chat.Component;

import java.util.List;

public class ShadowWarpItem extends Item {
	public ShadowWarpItem() {
		super(new Item.Properties().tab(CreativeModeTab.TAB_MISC).stacksTo(1).rarity(Rarity.COMMON));
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
		list.add(Component.literal(""));
        list.add(Component.literal("§6Ability: Shadow Warp"));
        list.add(Component.literal("§7Creates a spacial distortion §r§c7 §r§7blocks"));
        list.add(Component.literal("§7ahead of you that kills enemies and"));
        list.add(Component.literal("§7sucks you into them."));
		list.add(Component.literal(""));
		list.add(Component.literal("\u00A75\u00A7lEPIC"));
	}
}
