
package net.mcreator.hypixelsb.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;
import net.minecraft.network.chat.Component;

import net.mcreator.hypixelsb.procedures.GyrokineticWandProcedureProcedure;

import java.util.List;

public class GyrokineticWandItem extends SwordItem {
	public GyrokineticWandItem() {
		super(new Tier() {
			public int getUses() {
				return 0;
			}

			public float getSpeed() {
				return 4f;
			}

			public float getAttackDamageBonus() {
				return 1f;
			}

			public int getLevel() {
				return 1;
			}

			public int getEnchantmentValue() {
				return 2;
			}

			public Ingredient getRepairIngredient() {
				return Ingredient.EMPTY;
			}
		}, 3, -3f, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT));
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
		InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
		GyrokineticWandProcedureProcedure.execute(world, entity);
		return ar;
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
		list.add(Component.literal("§6Ability: Gravity Storm §e§lLEFT CLICK§r"));
		list.add(Component.literal("§7Create a large §5rift §7at aimed"));
		list.add(Component.literal("§7location, pulling all mobs"));
		list.add(Component.literal("§7together."));
		list.add(Component.literal("§8Regen mana 10x slower for 3s"));
		list.add(Component.literal("§7after cast."));
		list.add(Component.literal("§7Soulflow Cost: §310"));
		list.add(Component.literal("§8Mana Cost: §31200"));
		list.add(Component.literal("§8Cooldown: §a3s"));
		list.add(Component.literal(""));
		list.add(Component.literal("§6Ability: Cells Alignment §e§lRIGHT CLICK§r"));
		list.add(Component.literal("§7Apply §aAligned §7to 4 nearby"));
		list.add(Component.literal("§7players and yourself for §a6s§7."));
		list.add(Component.literal(""));
		list.add(Component.literal("§a¦¦¦ Aligned"));
		list.add(Component.literal("§7Splits incoming damage and apply"));
		list.add(Component.literal("§7it over §a3s§7."));
		list.add(Component.literal("§8Soulflow Cost: §32"));
		list.add(Component.literal("§8Mana Cost: §3220"));
		list.add(Component.literal("§8Cooldown: §a10s"));
		list.add(Component.literal(""));
		list.add(Component.literal("§5§lEPIC WAND"));
	}
}
