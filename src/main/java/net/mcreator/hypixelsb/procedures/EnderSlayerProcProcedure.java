package net.mcreator.hypixelsb.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingAttackEvent;

import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.monster.Shulker;
import net.minecraft.world.entity.monster.Endermite;
import net.minecraft.world.entity.monster.EnderMan;
import net.minecraft.world.entity.boss.enderdragon.EnderDragon;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;

import net.mcreator.hypixelsb.init.HypixelsbModEnchantments;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class EnderSlayerProcProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingAttackEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity(), event.getSource().getEntity());
		}
	}

	public static void execute(Entity entity, Entity sourceentity) {
		execute(null, entity, sourceentity);
	}

	private static void execute(@Nullable Event event, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		double enchLevel = 0;
		if (EnchantmentHelper.getItemEnchantmentLevel(HypixelsbModEnchantments.ENDER_SLAYER.get(),
				(sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)) != 0
				&& (entity instanceof EnderMan || entity instanceof Shulker || entity instanceof EnderDragon || entity instanceof Endermite)) {
			enchLevel = EnchantmentHelper.getItemEnchantmentLevel(HypixelsbModEnchantments.ENDER_SLAYER.get(),
					(sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY));
			entity.hurt(DamageSource.GENERIC, (float) (EnchantmentHelper.getItemEnchantmentLevel(HypixelsbModEnchantments.ENDER_SLAYER.get(),
					(sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)) * 10));
		}
	}
}
