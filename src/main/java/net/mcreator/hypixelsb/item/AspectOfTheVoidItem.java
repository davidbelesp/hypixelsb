
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

import net.mcreator.hypixelsb.procedures.AspectofthevoidProcedureProcedure;

import java.util.List;

public class AspectOfTheVoidItem extends SwordItem {
	public AspectOfTheVoidItem() {
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
		AspectofthevoidProcedureProcedure.execute(world, entity);
		return ar;
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
		list.add(Component.literal("§7Damage: §r§c+5"));
        list.add(Component.literal(""));
        list.add(Component.literal("§6Ability: Instant Trasmission §r§e§lRIGHT CLICK"));
        list.add(Component.literal("§7Teleport §r§a15 §r§7blocks ahead of"));
        list.add(Component.literal("§7you and gain §r§fSpeed"));
        list.add(Component.literal("§7for §r§a3 seconds§r§7."));
        list.add(Component.literal(""));
        list.add(Component.literal("§5§lEPIC SWORD"));
	}
}
