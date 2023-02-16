package net.mcreator.hypixelsb.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.core.BlockPos;

import net.mcreator.hypixelsb.init.HypixelsbModMobEffects;

import java.util.stream.Collectors;
import java.util.List;
import java.util.Comparator;

public class GyrokineticWandProcedureProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		boolean floorFound = false;
		double currentBlock = 0;
		double lookingX = 0;
		double lookingY = 0;
		double lookingZ = 0;
		currentBlock = 20;
		floorFound = false;
		for (int index0 = 0; index0 < (int) (20); index0++) {
			if (floorFound == false) {
				if (world.isEmptyBlock(new BlockPos(
						entity.level.clip(new ClipContext(entity.getEyePosition(1f),
								entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(currentBlock)), ClipContext.Block.OUTLINE,
								ClipContext.Fluid.NONE, entity)).getBlockPos().getX(),
						entity.level.clip(new ClipContext(entity.getEyePosition(1f),
								entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(currentBlock)), ClipContext.Block.OUTLINE,
								ClipContext.Fluid.NONE, entity)).getBlockPos().getY(),
						entity.level.clip(new ClipContext(entity.getEyePosition(1f),
								entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(currentBlock)), ClipContext.Block.OUTLINE,
								ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()))) {
					lookingX = entity.level.clip(
							new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(currentBlock)),
									ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
							.getBlockPos().getX();
					lookingY = entity.level.clip(
							new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(currentBlock)),
									ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
							.getBlockPos().getY();
					lookingZ = entity.level.clip(
							new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(currentBlock)),
									ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
							.getBlockPos().getZ();
					floorFound = true;
					{
						final Vec3 _center = new Vec3(lookingX, lookingY, lookingZ);
						List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(10 / 2d), e -> true)
								.stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).collect(Collectors.toList());
						for (Entity entityiterator : _entfound) {
							if (!(entityiterator == entity)) {
								{
									Entity _ent = entityiterator;
									_ent.teleportTo(lookingX, lookingY, lookingZ);
									if (_ent instanceof ServerPlayer _serverPlayer)
										_serverPlayer.connection.teleport(lookingX, lookingY, lookingZ, _ent.getYRot(), _ent.getXRot());
								}
							}
						}
					}
				} else {
					currentBlock = currentBlock - 1;
				}
			}
		}
		if (entity instanceof LivingEntity _entity)
			_entity.addEffect(new MobEffectInstance(HypixelsbModMobEffects.COOLDOWN.get(), 60, 1, (false), (false)));
	}
}
