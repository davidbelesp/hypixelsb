package net.mcreator.hypixelsb.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;

public class TerminatorProcedureProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (world instanceof ServerLevel projectileLevel) {
			Projectile _entityToSpawn = new Object() {
				public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
					AbstractArrow entityToSpawn = new Arrow(EntityType.ARROW, level);
					entityToSpawn.setOwner(shooter);
					entityToSpawn.setBaseDamage(damage);
					entityToSpawn.setKnockback(knockback);
					entityToSpawn.pickup = AbstractArrow.Pickup.CREATIVE_ONLY;
					return entityToSpawn;
				}
			}.getArrow(projectileLevel, entity, 7, 1);
			_entityToSpawn.setPos(x, (y + 1), z);
			_entityToSpawn.shoot((entity.getLookAngle().x), (entity.getLookAngle().y), (entity.getLookAngle().z), 10, 0);
			projectileLevel.addFreshEntity(_entityToSpawn);
		}
		if (world instanceof ServerLevel projectileLevel) {
			Projectile _entityToSpawn = new Object() {
				public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
					AbstractArrow entityToSpawn = new Arrow(EntityType.ARROW, level);
					entityToSpawn.setOwner(shooter);
					entityToSpawn.setBaseDamage(damage);
					entityToSpawn.setKnockback(knockback);
					entityToSpawn.pickup = AbstractArrow.Pickup.CREATIVE_ONLY;
					return entityToSpawn;
				}
			}.getArrow(projectileLevel, entity, 7, 1);
			_entityToSpawn.setPos((x - 1), (y + 1), z);
			_entityToSpawn.shoot((entity.getLookAngle().x), (entity.getLookAngle().y), (entity.getLookAngle().z), 10, 0);
			projectileLevel.addFreshEntity(_entityToSpawn);
		}
		if (world instanceof ServerLevel projectileLevel) {
			Projectile _entityToSpawn = new Object() {
				public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
					AbstractArrow entityToSpawn = new Arrow(EntityType.ARROW, level);
					entityToSpawn.setOwner(shooter);
					entityToSpawn.setBaseDamage(damage);
					entityToSpawn.setKnockback(knockback);
					entityToSpawn.pickup = AbstractArrow.Pickup.CREATIVE_ONLY;
					return entityToSpawn;
				}
			}.getArrow(projectileLevel, entity, 7, 1);
			_entityToSpawn.setPos((x + 1), (y + 1), z);
			_entityToSpawn.shoot((entity.getLookAngle().x), (entity.getLookAngle().y), (entity.getLookAngle().z), 10, 0);
			projectileLevel.addFreshEntity(_entityToSpawn);
		}
	}
}
