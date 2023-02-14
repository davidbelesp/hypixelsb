package net.mcreator.hypixelsb.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;

public class ScyllaProcedureProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		double lookingX = 0;
		double lookingY = 0;
		double lookingZ = 0;
		double repeats = 0;
		boolean found = false;
		if (entity instanceof LivingEntity _entity)
			_entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 60, 1));
	}
}
