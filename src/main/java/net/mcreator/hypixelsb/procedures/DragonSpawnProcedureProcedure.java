package net.mcreator.hypixelsb.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;

import net.minecraft.world.entity.boss.enderdragon.EnderDragon;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.network.chat.Component;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class DragonSpawnProcedureProcedure {
	@SubscribeEvent
	public static void onEntitySpawned(EntityJoinLevelEvent event) {
		execute(event, event.getEntity());
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		double randomDragonNumber = 0;
		if (entity instanceof EnderDragon) {
			randomDragonNumber = Mth.nextInt(RandomSource.create(), 1, 100);
			if (randomDragonNumber <= 1) {
				entity.setCustomName(Component.literal("\u00A7gHoly Dragon"));
				if (entity instanceof LivingEntity _entity)
					_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 999999, 2));
				if (entity instanceof LivingEntity _entity)
					_entity.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 999999, 50));
				if (entity instanceof LivingEntity _entity)
					_entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 999999, 5));
			} else if (randomDragonNumber > 1 && randomDragonNumber <= 3) {
				entity.setCustomName(Component.literal("\u00A7gSuperior Dragon"));
				if (entity instanceof LivingEntity _entity)
					_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 999999, 2));
			} else if (randomDragonNumber > 3 && randomDragonNumber <= 8) {
				entity.setCustomName(Component.literal("\u00A7gStrong Dragon"));
				if (entity instanceof LivingEntity _entity)
					_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 999999, 2));
				if (entity instanceof LivingEntity _entity)
					_entity.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 999999, 20));
			} else if (randomDragonNumber > 8 && randomDragonNumber <= 15) {
				entity.setCustomName(Component.literal("\u00A7gWise Dragon"));
			} else if (randomDragonNumber > 15 && randomDragonNumber <= 30) {
				entity.setCustomName(Component.literal("\u00A7gYoung Dragon"));
				if (entity instanceof LivingEntity _entity)
					_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 999999, 3));
			} else if (randomDragonNumber > 30 && randomDragonNumber <= 50) {
				entity.setCustomName(Component.literal("\u00A7gUnstable Dragon"));
			} else if (randomDragonNumber > 50 && randomDragonNumber <= 73) {
				entity.setCustomName(Component.literal("\u00A7gProtector Dragon"));
			} else if (randomDragonNumber > 73 && randomDragonNumber <= 100) {
				entity.setCustomName(Component.literal("\u00A7gOld Dragon"));
				if (entity instanceof LivingEntity _entity)
					_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 999999, 3));
			}
		}
	}
}
