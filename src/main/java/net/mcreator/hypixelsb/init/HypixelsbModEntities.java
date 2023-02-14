
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.hypixelsb.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;

import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;

import net.mcreator.hypixelsb.entity.WitherLordEntity;
import net.mcreator.hypixelsb.entity.DivanEntity;
import net.mcreator.hypixelsb.HypixelsbMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class HypixelsbModEntities {
	public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, HypixelsbMod.MODID);
	public static final RegistryObject<EntityType<WitherLordEntity>> WITHER_LORD = register("wither_lord",
			EntityType.Builder.<WitherLordEntity>of(WitherLordEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
					.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(WitherLordEntity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<DivanEntity>> DIVAN = register("divan",
			EntityType.Builder.<DivanEntity>of(DivanEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64)
					.setUpdateInterval(3).setCustomClientFactory(DivanEntity::new)

					.sized(0.6f, 1.8f));

	private static <T extends Entity> RegistryObject<EntityType<T>> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
		return REGISTRY.register(registryname, () -> (EntityType<T>) entityTypeBuilder.build(registryname));
	}

	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		event.enqueueWork(() -> {
			WitherLordEntity.init();
			DivanEntity.init();
		});
	}

	@SubscribeEvent
	public static void registerAttributes(EntityAttributeCreationEvent event) {
		event.put(WITHER_LORD.get(), WitherLordEntity.createAttributes().build());
		event.put(DIVAN.get(), DivanEntity.createAttributes().build());
	}
}
