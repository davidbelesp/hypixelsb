package net.mcreator.hypixelsb.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;

import java.util.stream.Collectors;
import java.util.List;
import java.util.Comparator;

public class HyperionProcedureProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		double lookingX = 0;
		double lookingY = 0;
		double lookingZ = 0;
		double repeats = 0;
		boolean found = false;
		found = false;
		repeats = 5;
		lookingX = entity.level.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(5)),
				ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX();
		lookingY = entity.level.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(5)),
				ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY();
		lookingZ = entity.level.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(5)),
				ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ();
		for (int index0 = 0; index0 < (int) (repeats); index0++) {
			if (!found) {
				if (world.isEmptyBlock(new BlockPos(lookingX, lookingY, lookingZ))) {
					found = true;
					{
						Entity _ent = entity;
						_ent.teleportTo(lookingX, lookingY, lookingZ);
						if (_ent instanceof ServerPlayer _serverPlayer)
							_serverPlayer.connection.teleport(lookingX, lookingY, lookingZ, _ent.getYRot(), _ent.getXRot());
					}
					{
						final Vec3 _center = new Vec3(lookingX, lookingY, lookingZ);
						List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(6 / 2d), e -> true)
								.stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).collect(Collectors.toList());
						for (Entity entityiterator : _entfound) {
							if (entityiterator instanceof Monster || entityiterator instanceof Mob) {
								if (entityiterator instanceof LivingEntity _entity)
									_entity.hurt(new DamageSource("hyperion").bypassArmor(), 150);
							}
						}
					}
				}
				lookingX = lookingX - 1;
				lookingY = lookingY - 1;
				lookingZ = lookingZ - 1;
			}
		}
		if (!found) {
			if (entity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(Component.literal("\u00A7cThere are blocks in the way!"), (true));
		}
	}
}
