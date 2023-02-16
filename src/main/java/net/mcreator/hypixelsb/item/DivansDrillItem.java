
package net.mcreator.hypixelsb.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.network.chat.Component;

import java.util.List;

public class DivansDrillItem extends PickaxeItem {
	public DivansDrillItem() {
		super(new Tier() {
			public int getUses() {
				return 0;
			}

			public float getSpeed() {
				return 21f;
			}

			public float getAttackDamageBonus() {
				return 2f;
			}

			public int getLevel() {
				return 5;
			}

			public int getEnchantmentValue() {
				return 2;
			}

			public Ingredient getRepairIngredient() {
				return Ingredient.EMPTY;
			}
		}, 1, -2f, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS));
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
		list.add(Component.literal("§8Breaking Power 10"));
		list.add(Component.literal(""));
		list.add(Component.literal("§7Damage: §c+70"));
		list.add(Component.literal("§7Mining Speed: §a+1,800"));
		list.add(Component.literal("§7Mining Fortune: §a+150"));
		list.add(Component.literal(" §6[§6⸕§6] §6[§6⸕§6] §6[§a☘§6] §6[§a☘§6] §6[§5✦§6]"));
		list.add(Component.literal(""));
		list.add(Component.literal("§9Perfectly-Cut Fuel Tank"));
		list.add(Component.literal("§7Increases the fuel capacity to"));
		list.add(Component.literal("§2100,000§7."));
		list.add(Component.literal(""));
		list.add(Component.literal("§aAmber-polished Drill Engine"));
		list.add(Component.literal("§7Grants §a+400 §6⸕ Mining"));
		list.add(Component.literal("§6Speed§7."));
		list.add(Component.literal(""));
		list.add(Component.literal("§9Sunny Side Goblin Omelette"));
		list.add(Component.literal("§7Grants §a+50 §6☘ Mining"));
		list.add(Component.literal("§7Fortune§7, but fuel consumption"));
		list.add(Component.literal("§7is doubled."));
		list.add(Component.literal(""));
		list.add(Component.literal("§7Fuel: §291,151§8/100k"));
		list.add(Component.literal(""));
		list.add(Component.literal("§b§k§lA §r§b§lDIVINE DRILL §r§b§k§lA"));

	}
}
