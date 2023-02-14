package net.mcreator.hypixelsb.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

public class BoosterCookieProcedureProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player _player) {
			_player.getAbilities().mayfly = (true);
			_player.onUpdateAbilities();
		}
		if (entity instanceof Player _player && !_player.level.isClientSide())
			_player.displayClientMessage(Component.literal("\u00A7b\u00A7lBooster cookie used!"), (true));
	}
}
