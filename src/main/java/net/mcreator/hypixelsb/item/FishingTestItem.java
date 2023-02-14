
package net.mcreator.hypixelsb.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.FishingRodItem;
import net.minecraft.world.item.CreativeModeTab;

public class FishingTestItem extends FishingRodItem {
	public FishingTestItem() {
		super(new Item.Properties().tab(CreativeModeTab.TAB_TOOLS).durability(100));
	}

	@Override
	public int getEnchantmentValue() {
		return 2;
	}
}
