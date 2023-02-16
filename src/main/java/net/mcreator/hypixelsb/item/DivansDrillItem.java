
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
		list.add(Component.literal(" §8[§7⸕§8] §8[§7⸕§8] §8[§8☘§8] §8[§8☘§8] §8[§8✦§8]"));
		list.add(Component.literal(""));
		list.add(Component.literal("§7Fuel Tank: §cNot Installed"));
		list.add(Component.literal("§7Increases fuel capacity with"));
		list.add(Component.literal("§7part installed."));
		list.add(Component.literal(""));
		list.add(Component.literal("§7Drill Engine: §cNot Installed"));
		list.add(Component.literal("§7Increases §6⸕ Mining Speed"));
		list.add(Component.literal("§7with part installed."));
		list.add(Component.literal(""));
		list.add(Component.literal("§7Upgrade Module: §cNot Installed"));
		list.add(Component.literal("§7Applies a passive upgrade with"));
		list.add(Component.literal("§7part installed."));
		list.add(Component.literal(""));
		list.add(Component.literal("§7Apply Drill Parts to this Drill"));
		list.add(Component.literal("§7by talking to a §2Drill"));
		list.add(Component.literal("§7Mechanic§7!"));
		list.add(Component.literal(""));
		list.add(Component.literal("§7Fuel: §23,000§8"));
		list.add(Component.literal("3k"));
		list.add(Component.literal(""));
		list.add(Component.literal("§8This item can be reforged!"));
		list.add(Component.literal("§4❣ §cRequires §5Heart of the"));
		list.add(Component.literal("§7Mountain Tier 7."));
		list.add(Component.literal("§b§lDIVINE DRILL"));

	}
}
