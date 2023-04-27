package net.mcreator.hypixelsb.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.level.BlockEvent;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.hypixelsb.init.HypixelsbModItems;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class GemstonesProceduresProcedure {
	@SubscribeEvent
	public static void onBlockBreak(BlockEvent.BreakEvent event) {
		execute(event, event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), event.getState(), event.getPlayer());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate, Entity entity) {
		execute(null, world, x, y, z, blockstate, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, BlockState blockstate, Entity entity) {
		if (entity == null)
			return;
		if (blockstate.getMaterial() == net.minecraft.world.level.material.Material.STONE) {
			if (Math.random() < 0.00002) {
				if (event != null && event.isCancelable()) {
					event.setCanceled(true);
				}
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(
							new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""),
									_level.getServer(), null).withSuppressedOutput(),
							("setblock ~ ~ ~ minecraft:chest{Items:[{"
									+ ("Slot:" + Math.round(Math.random() * 26) + ",id:" + "\"hypixelsb:flawed_topaz\"" + ",Count:"
											+ Math.round(Math.random() * 3))
									+ "},{"
									+ ("Slot:" + Math.round(Math.random() * 26) + ",id:" + "\"hypixelsb:flawed_amethyst\"" + ",Count:"
											+ Math.round(Math.random() * 3))
									+ "},{"
									+ ("Slot:" + Math.round(Math.random() * 26) + ",id:" + "\"hypixelsb:flawed_ruby\"" + ",Count:"
											+ Math.round(Math.random() * 3))
									+ "},{" + ("Slot:" + Math.round(Math.random() * 26) + ",id:" + "\"hypixelsb:flawed_sapphire\"" + ",Count:"
											+ Math.round(Math.random() * 3))
									+ "}]} replace"));
				if (entity instanceof Player _player && !_player.level.isClientSide())
					_player.displayClientMessage(Component.literal("\u00A7aA gemstone chest has appeared!"), (true));
			}
			if (Math.random() < 0.000001) {
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO,
							_level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(), "/summon hypixelsb:divan");
				if (entity instanceof Player _player && !_player.level.isClientSide())
					_player.displayClientMessage(Component.literal("\u00A74 You found a Divan's tomb!"), (true));
			}
			if (Math.random() < 0.00001) {
				if (world instanceof Level _level && !_level.isClientSide()) {
					ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(HypixelsbModItems.DIVAN_FRAGMENT.get()));
					entityToSpawn.setPickUpDelay(10);
					_level.addFreshEntity(entityToSpawn);
				}
				if (entity instanceof Player _player && !_player.level.isClientSide())
					_player.displayClientMessage(Component.literal("\u00A7c You found a Divan's fragment!"), (true));
			}
		}
	}
}
