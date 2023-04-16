package net.mcreator.hypixelsb.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

public class AspectofthevoidProcedureProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		boolean found = false;
		double blockvar = 0;
		found = false;
		blockvar = 12;
		for (int index0 = 0; index0 < (int) (12); index0++) {
			if (!found) {
				if (world.isEmptyBlock(new BlockPos(
						entity.level.clip(
								new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(blockvar)),
										ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
								.getBlockPos().getX(),
						entity.level.clip(
								new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(blockvar)),
										ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
								.getBlockPos().getY(),
						entity.level.clip(
								new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(blockvar)),
										ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
								.getBlockPos().getZ()))) {
					{
						Entity _ent = entity;
						_ent.teleportTo(
								(entity.level.clip(new ClipContext(entity.getEyePosition(1f),
										entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(blockvar)), ClipContext.Block.OUTLINE,
										ClipContext.Fluid.NONE, entity)).getBlockPos().getX()),
								(entity.level.clip(new ClipContext(entity.getEyePosition(1f),
										entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(blockvar)), ClipContext.Block.OUTLINE,
										ClipContext.Fluid.NONE, entity)).getBlockPos().getY() + 1),
								(entity.level.clip(new ClipContext(entity.getEyePosition(1f),
										entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(blockvar)), ClipContext.Block.OUTLINE,
										ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()));
						if (_ent instanceof ServerPlayer _serverPlayer)
							_serverPlayer.connection.teleport(
									(entity.level.clip(new ClipContext(entity.getEyePosition(1f),
											entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(blockvar)), ClipContext.Block.OUTLINE,
											ClipContext.Fluid.NONE, entity)).getBlockPos().getX()),
									(entity.level.clip(new ClipContext(entity.getEyePosition(1f),
											entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(blockvar)), ClipContext.Block.OUTLINE,
											ClipContext.Fluid.NONE, entity)).getBlockPos().getY() + 1),
									(entity.level.clip(new ClipContext(entity.getEyePosition(1f),
											entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(blockvar)), ClipContext.Block.OUTLINE,
											ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()),
									_ent.getYRot(), _ent.getXRot());
					}
					found = true;
				}
				blockvar = blockvar - 1;
			}
		}
		if (!found) {
			if (entity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(Component.literal("\u00A7cThere are blocks in the way!"), (true));
		}
		if (world instanceof ServerLevel _level)
			_level.sendParticles(ParticleTypes.EFFECT,
					(entity.level
							.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(blockvar)),
									ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
							.getBlockPos().getX()),
					(entity.level
							.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(blockvar)),
									ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
							.getBlockPos().getY()),
					(entity.level
							.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(blockvar)),
									ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
							.getBlockPos().getZ()),
					100, 3, 3, 3, 1);
		if (entity instanceof LivingEntity _entity)
			_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 60, 2, (false), (false)));
	}
}
