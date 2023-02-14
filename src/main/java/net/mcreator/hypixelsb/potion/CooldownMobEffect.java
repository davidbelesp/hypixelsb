
package net.mcreator.hypixelsb.potion;

import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

public class CooldownMobEffect extends MobEffect {
	public CooldownMobEffect() {
		super(MobEffectCategory.NEUTRAL, -1);
	}

	@Override
	public String getDescriptionId() {
		return "effect.hypixelsb.cooldown";
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
