package net.mcreator.hypixelsb.procedures;

import net.minecraftforge.server.ServerLifecycleHooks;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingDeathEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.monster.Spider;
import net.minecraft.world.entity.monster.Giant;
import net.minecraft.world.entity.monster.EnderMan;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.boss.wither.WitherBoss;
import net.minecraft.world.entity.boss.enderdragon.EnderDragon;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.MinecraftServer;
import net.minecraft.network.chat.Component;

import net.mcreator.hypixelsb.init.HypixelsbModItems;
import net.mcreator.hypixelsb.init.HypixelsbModBlocks;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class DropsProcedureProcedure {
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
		double randomNumber = 0;
		double scrollrandom = 0;
		double giantdrop = 0;
		if (entity instanceof EnderDragon) {
			randomNumber = Math.random();
			if (randomNumber < 0.001) {
				if (world instanceof Level _level && !_level.isClientSide()) {
					ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(HypixelsbModItems.NECRONS_HANDLE.get()));
					entityToSpawn.setPickUpDelay(10);
					_level.addFreshEntity(entityToSpawn);
				}
				if (!world.isClientSide()) {
					MinecraftServer _mcserv = ServerLifecycleHooks.getCurrentServer();
					if (_mcserv != null)
						_mcserv.getPlayerList().broadcastSystemMessage(
								Component.literal("\u00A74\u00A7lINSANE DROP! \u00A7r\u00A75Necron's Handle \u00A7r\u00A7b(0.1%)"), false);
				}
			}
		}
		if (entity instanceof Giant) {
			giantdrop = Math.random();
			scrollrandom = Math.random();
			if (giantdrop < 0.8) {
				if ((entity.getDisplayName().getString()).equals("\u00A7gDiamante")) {
					if (world instanceof Level _level && !_level.isClientSide()) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(HypixelsbModItems.DIAMANTES_HANDLE.get()));
						entityToSpawn.setPickUpDelay(10);
						_level.addFreshEntity(entityToSpawn);
					}
				} else if ((entity.getDisplayName().getString()).equals("\u00A7gL.A.S.R.")) {
					if (world instanceof Level _level && !_level.isClientSide()) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(HypixelsbModItems.LAS_REYE.get()));
						entityToSpawn.setPickUpDelay(10);
						_level.addFreshEntity(entityToSpawn);
					}
				} else if ((entity.getDisplayName().getString()).equals("\u00A7gJolly")) {
					if (world instanceof Level _level && !_level.isClientSide()) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(HypixelsbModItems.JOLLY_PINK_ROCK.get()));
						entityToSpawn.setPickUpDelay(10);
						_level.addFreshEntity(entityToSpawn);
					}
				} else if ((entity.getDisplayName().getString()).equals("\u00A7gBigfoot")) {
					if (world instanceof Level _level && !_level.isClientSide()) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(HypixelsbModItems.BIGFOOTS_LASSO.get()));
						entityToSpawn.setPickUpDelay(10);
						_level.addFreshEntity(entityToSpawn);
					}
				}
			}
			if (scrollrandom < 0.01) {
				if (world instanceof Level _level && !_level.isClientSide()) {
					ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(HypixelsbModItems.GIANT_SLAM.get()));
					entityToSpawn.setPickUpDelay(10);
					_level.addFreshEntity(entityToSpawn);
				}
				if (!world.isClientSide()) {
					MinecraftServer _mcserv = ServerLifecycleHooks.getCurrentServer();
					if (_mcserv != null)
						_mcserv.getPlayerList().broadcastSystemMessage(
								Component.literal("\u00A7d\u00A7lCRAZY RARE DROP! \u00A7r\u00A75Giant Slam \u00A7r\u00A7b(1%)"), false);
				}
			}
		}
		if (entity instanceof WitherBoss) {
			randomNumber = Math.random();
			scrollrandom = Math.random();
			if (randomNumber < 0.25) {
				if (world instanceof Level _level && !_level.isClientSide()) {
					ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(HypixelsbModItems.WITHER_CATALYST.get()));
					entityToSpawn.setPickUpDelay(10);
					_level.addFreshEntity(entityToSpawn);
				}
				if (!world.isClientSide()) {
					MinecraftServer _mcserv = ServerLifecycleHooks.getCurrentServer();
					if (_mcserv != null)
						_mcserv.getPlayerList().broadcastSystemMessage(
								Component.literal("\u00A79\u00A7lRARE DROP! \u00A7r\u00A79Wither Catalyst \u00A7r\u00A7b(25%)"), false);
				}
			}
			if (scrollrandom < 0.01) {
				if (world instanceof Level _level && !_level.isClientSide()) {
					ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(HypixelsbModItems.WITHER_SHIELD.get()));
					entityToSpawn.setPickUpDelay(10);
					_level.addFreshEntity(entityToSpawn);
				}
				if (!world.isClientSide()) {
					MinecraftServer _mcserv = ServerLifecycleHooks.getCurrentServer();
					if (_mcserv != null)
						_mcserv.getPlayerList().broadcastSystemMessage(
								Component.literal("\u00A75\u00A7lEPIC DROP! \u00A7r\u00A75Wither Shield \u00A7r\u00A7b(1%)"), false);
				}
			}
			if (scrollrandom >= 0.01 && scrollrandom < 0.02) {
				if (world instanceof Level _level && !_level.isClientSide()) {
					ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(HypixelsbModItems.WITHER_HEALING.get()));
					entityToSpawn.setPickUpDelay(10);
					_level.addFreshEntity(entityToSpawn);
				}
				if (!world.isClientSide()) {
					MinecraftServer _mcserv = ServerLifecycleHooks.getCurrentServer();
					if (_mcserv != null)
						_mcserv.getPlayerList().broadcastSystemMessage(
								Component.literal("\u00A75\u00A7lEPIC DROP! \u00A7r\u00A75Wither Healing \u00A7r\u00A7b(1%)"), false);
				}
			}
		}
		if (entity instanceof EnderMan) {
			randomNumber = Math.random();
			if ((entity.getDisplayName().getString()).equals("\u00A7gVoidgloom Seraph")) {
				if (randomNumber < 0.01) {
					if (world instanceof Level _level && !_level.isClientSide()) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(HypixelsbModItems.JUDGEMENT_CORE.get()));
						entityToSpawn.setPickUpDelay(10);
						_level.addFreshEntity(entityToSpawn);
					}
					if (!world.isClientSide()) {
						MinecraftServer _mcserv = ServerLifecycleHooks.getCurrentServer();
						if (_mcserv != null)
							_mcserv.getPlayerList().broadcastSystemMessage(
									Component.literal("\u00A7d\u00A7lCRAZY RARE DROP! \u00A7r\u00A76Judgement Core \u00A7r\u00A7b(1%)"), false);
					}
				}
				if (randomNumber < 0.1) {
					if (world instanceof Level _level && !_level.isClientSide()) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(HypixelsbModBlocks.ENCHANTED_OBSIDIAN.get()));
						entityToSpawn.setPickUpDelay(10);
						_level.addFreshEntity(entityToSpawn);
					}
					if (!world.isClientSide()) {
						MinecraftServer _mcserv = ServerLifecycleHooks.getCurrentServer();
						if (_mcserv != null)
							_mcserv.getPlayerList().broadcastSystemMessage(
									Component.literal("\u00A79\u00A7lRARE DROP! \u00A7r\u00A79Enchanted Obsidian \u00A7r\u00A7b(10%)"), false);
					}
				}
				for (int index0 = 0; index0 < (int) (6); index0++) {
					randomNumber = Math.random();
					if (randomNumber < 0.2) {
						if (world instanceof Level _level && !_level.isClientSide()) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(HypixelsbModItems.NULL_ATOM.get()));
							entityToSpawn.setPickUpDelay(10);
							_level.addFreshEntity(entityToSpawn);
						}
					}
				}
			}
		}
		if (entity instanceof Spider) {
			randomNumber = Math.random();
			if (randomNumber < 0.01) {
				if (world instanceof Level _level && !_level.isClientSide()) {
					ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(HypixelsbModItems.SOUL_STRING.get()));
					entityToSpawn.setPickUpDelay(10);
					_level.addFreshEntity(entityToSpawn);
				}
				if (!world.isClientSide()) {
					MinecraftServer _mcserv = ServerLifecycleHooks.getCurrentServer();
					if (_mcserv != null)
						_mcserv.getPlayerList().broadcastSystemMessage(
								Component.literal("\u00A7d\u00A7lCRAZY RARE DROP! \u00A7r\u00A79 Soul String \u00A7r\u00A7b(1%)"), false);
				}
			}
		}
	}
}
