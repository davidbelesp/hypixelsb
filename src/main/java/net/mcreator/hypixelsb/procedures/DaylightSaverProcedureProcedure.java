package net.mcreator.hypixelsb.procedures;

import net.minecraftforge.server.ServerLifecycleHooks;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.MinecraftServer;
import net.minecraft.network.chat.Component;

import net.mcreator.hypixelsb.init.HypixelsbModMobEffects;

public class DaylightSaverProcedureProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (!(entity instanceof LivingEntity _livEnt ? _livEnt.hasEffect(HypixelsbModMobEffects.COOLDOWN.get()) : false)) {
			if (world instanceof ServerLevel _level)
				_level.setDayTime((int) (world.dayTime() + 12000));
			if (entity instanceof LivingEntity _entity)
				_entity.addEffect(new MobEffectInstance(HypixelsbModMobEffects.COOLDOWN.get(), 200, 1));
		} else {
			if (!world.isClientSide()) {
				MinecraftServer _mcserv = ServerLifecycleHooks.getCurrentServer();
				if (_mcserv != null)
					_mcserv.getPlayerList().broadcastSystemMessage(Component.literal("\u00A7cThis ability is on cooldown"), false);
			}
		}
	}
}
