
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.hypixelsb.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.mcreator.hypixelsb.client.model.ModelHeadModel;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class HypixelsbModModels {
	@SubscribeEvent
	public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
		event.registerLayerDefinition(ModelHeadModel.LAYER_LOCATION, ModelHeadModel::createBodyLayer);
	}
}
