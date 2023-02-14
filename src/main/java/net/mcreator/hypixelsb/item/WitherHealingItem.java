
package net.mcreator.hypixelsb.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;

public class WitherHealingItem extends Item {
	public WitherHealingItem() {
		super(new Item.Properties().tab(CreativeModeTab.TAB_MISC).stacksTo(1).rarity(Rarity.RARE));
	}
}
