
package net.mcreator.hypixelsb.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.mcreator.hypixelsb.procedures.AstraeaProcedureProcedure;

import java.util.List;

public class AstraeaItem extends SwordItem {
	public AstraeaItem() {
		super(new Tier() {
			public int getUses() {
				return 0;
			}

			public float getSpeed() {
				return 4f;
			}

			public float getAttackDamageBonus() {
				return 11f;
			}

			public int getLevel() {
				return 1;
			}

			public int getEnchantmentValue() {
				return 0;
			}

			public Ingredient getRepairIngredient() {
				return Ingredient.EMPTY;
			}
		}, 3, -3f, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT).fireResistant());
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
		list.add(Component.literal("§7Damage: §r§c+8"));
		list.add(Component.literal(""));
		list.add(Component.literal("§6Ability: Wither Shield §r§e§lPASSIVE"));
		list.add(Component.literal("§7Reduces damage taken by §r§c50% §r§7when"));
		list.add(Component.literal("§7in hand."));
		list.add(Component.literal(""));
		list.add(Component.literal("§6§lLEGENDARY SWORD"));
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		if (selected)
			AstraeaProcedureProcedure.execute(entity);
	}
}
