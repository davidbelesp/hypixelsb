
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.hypixelsb.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;

import net.mcreator.hypixelsb.block.EnchantedRedstoneBlockBlock;
import net.mcreator.hypixelsb.block.EnchantedQuartzBlockBlock;
import net.mcreator.hypixelsb.block.EnchantedObsidianBlock;
import net.mcreator.hypixelsb.block.EnchantedIronBlockBlock;
import net.mcreator.hypixelsb.block.EnchantedGoldBlockBlock;
import net.mcreator.hypixelsb.block.EnchantedDiamondBlockBlock;
import net.mcreator.hypixelsb.HypixelsbMod;

public class HypixelsbModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, HypixelsbMod.MODID);
	public static final RegistryObject<Block> ENCHANTED_OBSIDIAN = REGISTRY.register("enchanted_obsidian", () -> new EnchantedObsidianBlock());
	public static final RegistryObject<Block> ENCHANTED_QUARTZ_BLOCK = REGISTRY.register("enchanted_quartz_block",
			() -> new EnchantedQuartzBlockBlock());
	public static final RegistryObject<Block> ENCHANTED_REDSTONE_BLOCK = REGISTRY.register("enchanted_redstone_block",
			() -> new EnchantedRedstoneBlockBlock());
	public static final RegistryObject<Block> ENCHANTED_IRON_BLOCK = REGISTRY.register("enchanted_iron_block", () -> new EnchantedIronBlockBlock());
	public static final RegistryObject<Block> ENCHANTED_GOLD_BLOCK = REGISTRY.register("enchanted_gold_block", () -> new EnchantedGoldBlockBlock());
	public static final RegistryObject<Block> ENCHANTED_DIAMOND_BLOCK = REGISTRY.register("enchanted_diamond_block",
			() -> new EnchantedDiamondBlockBlock());
}
