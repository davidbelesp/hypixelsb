package net.mcreator.hypixelsb.procedures;

import net.minecraftforge.server.ServerLifecycleHooks;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingDeathEvent;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.entity.monster.EnderMan;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.MinecraftServer;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class SpecialMobsSpawnProcedure {
	@SubscribeEvent
	public static void onEntityDeath(LivingDeathEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity().level, event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity());
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double giantspawn = 0;
		double gianttype = 0;
		double endermanSpawn = 0;
		double zealotspawn = 0;
		if (entity instanceof Zombie) {
			giantspawn = Math.random();
			if (giantspawn < 0.005) {
				gianttype = Math.random();
				if (gianttype <= 0.25) {
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performPrefixedCommand(
								new CommandSourceStack(CommandSource.NULL, new Vec3(x, (y + 2), z), Vec2.ZERO, _level, 4, "", Component.literal(""),
										_level.getServer(), null).withSuppressedOutput(),
								"summon giant ~ ~1 ~ {ArmorItems:[{Count:1,id:leather_boots,tag:{display:{color:15961002}}},{Count:1,id:leather_leggings,tag:{display:{color:15961002}}},{Count:1,id:leather_chestplate,tag:{display:{color:15961002}}}],CustomName:'[{\"text\":\"\u00A7gJolly\",\"color\":\"red\"}]'}");
				} else if (gianttype > 0.25 && gianttype <= 0.5) {
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performPrefixedCommand(
								new CommandSourceStack(CommandSource.NULL, new Vec3(x, (y + 2), z), Vec2.ZERO, _level, 4, "", Component.literal(""),
										_level.getServer(), null).withSuppressedOutput(),
								"summon giant ~ ~1 ~ {ArmorItems:[{Count:1,id:leather_boots,tag:{display:{color:3847130}}},{Count:1,id:leather_leggings,tag:{display:{color:3847130}}},{Count:1,id:leather_chestplate,tag:{display:{color:3847130}}},{Count:1,id:leather_helmet,tag:{display:{color:3847130}}}],CustomName:'[{\"text\":\"\u00A7gL.A.S.R.\",\"color\":\"red\"}]'}");
				} else if (gianttype > 0.5 && gianttype <= 0.75) {
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performPrefixedCommand(
								new CommandSourceStack(CommandSource.NULL, new Vec3(x, (y + 2), z), Vec2.ZERO, _level, 4, "", Component.literal(""),
										_level.getServer(), null).withSuppressedOutput(),
								"summon giant ~ ~1 ~ {ArmorItems:[{Count:1,id:diamond_boots},{Count:1,id:diamond_leggings},{Count:1,id:diamond_chestplate},{Count:1,id:diamond_helmet}],CustomName:'[{\"text\":\"\u00A7gDiamante\",\"color\":\"red\"}]'}");
				} else {
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performPrefixedCommand(
								new CommandSourceStack(CommandSource.NULL, new Vec3(x, (y + 2), z), Vec2.ZERO, _level, 4, "", Component.literal(""),
										_level.getServer(), null).withSuppressedOutput(),
								"summon giant ~ ~1 ~ {ArmorItems:[{Count:1,id:leather_boots,tag:{display:{color:11546150}}},{},{},{}],CustomName:'[{\"text\":\"\u00A7gBigfoot\",\"color\":\"red\"}]'}");
				}
			}
		}
		if (entity instanceof EnderMan) {
			zealotspawn = Math.random();
			endermanSpawn = Math.random();
			if (zealotspawn <= 0.01) {
				if (!world.isClientSide()) {
					MinecraftServer _mcserv = ServerLifecycleHooks.getCurrentServer();
					if (_mcserv != null)
						_mcserv.getPlayerList().broadcastSystemMessage(Component.literal("\u00A79\u00A7l A Special Zealot has spawned nearby"),
								false);
				}
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(
							new CommandSourceStack(CommandSource.NULL, new Vec3(x, (y + 2), z), Vec2.ZERO, _level, 4, "", Component.literal(""),
									_level.getServer(), null).withSuppressedOutput(),
							"/summon enderman ~ ~1 ~ {carried:121,PersistenceRequired:1,CustomName:\"\\\"\u00A7gSpecial Zealot\\\"\"}");
			}
			if ((entity.getDisplayName().getString()).equals("\u00A7gSpecial Zealot")) {
				endermanSpawn = Math.random();
				if (endermanSpawn <= 0.12) {
					if (!world.isClientSide()) {
						MinecraftServer _mcserv = ServerLifecycleHooks.getCurrentServer();
						if (_mcserv != null)
							_mcserv.getPlayerList().broadcastSystemMessage(Component.literal("\u00A74\u00A7l A Voidgloom Seraph raises from below "),
									false);
					}
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performPrefixedCommand(
								new CommandSourceStack(CommandSource.NULL, new Vec3(x, (y + 2), z), Vec2.ZERO, _level, 4, "", Component.literal(""),
										_level.getServer(), null).withSuppressedOutput(),
								"/summon enderman ~ ~1 ~ {carried:152,PersistenceRequired:1,CustomName:\"\\\"\u00A7gVoidgloom Seraph\\\"\",ActiveEffects:[{Id:5,Amplifier:6,Duration:999999},{Id:11,Amplifier:3,Duration:999999}]}");
				}
			}
		}
	}
}
