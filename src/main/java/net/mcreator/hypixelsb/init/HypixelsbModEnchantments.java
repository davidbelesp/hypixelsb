
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.hypixelsb.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.item.enchantment.Enchantment;

import net.mcreator.hypixelsb.enchantment.EnderSlayerEnchantment;
import net.mcreator.hypixelsb.HypixelsbMod;

public class HypixelsbModEnchantments {
	public static final DeferredRegister<Enchantment> REGISTRY = DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, HypixelsbMod.MODID);
	public static final RegistryObject<Enchantment> ENDER_SLAYER = REGISTRY.register("ender_slayer", () -> new EnderSlayerEnchantment());
}
