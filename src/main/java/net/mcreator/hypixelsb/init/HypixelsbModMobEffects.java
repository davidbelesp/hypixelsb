
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.hypixelsb.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.effect.MobEffect;

import net.mcreator.hypixelsb.potion.CooldownMobEffect;
import net.mcreator.hypixelsb.HypixelsbMod;

public class HypixelsbModMobEffects {
	public static final DeferredRegister<MobEffect> REGISTRY = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, HypixelsbMod.MODID);
	public static final RegistryObject<MobEffect> COOLDOWN = REGISTRY.register("cooldown", () -> new CooldownMobEffect());
}
