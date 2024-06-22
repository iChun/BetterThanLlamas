package me.ichun.mods.betterthanllamas.loader.fabric;

import me.ichun.mods.betterthanllamas.common.BetterThanLlamas;
import me.ichun.mods.betterthanllamas.common.core.Config;
import me.ichun.mods.betterthanllamas.common.core.EventHandlerClient;
import net.fabricmc.fabric.api.client.rendering.v1.LivingEntityFeatureRendererRegistrationCallback;
import net.minecraft.client.renderer.entity.LlamaRenderer;
import net.minecraft.world.entity.EntityType;

public class EventHandlerClientFabric extends EventHandlerClient
{
    public EventHandlerClientFabric()
    {
        LivingEntityFeatureRendererRegistrationCallback.EVENT.register((entityType, entityRenderer, registrationHelper, context) ->
        {
            if((BetterThanLlamas.config.applyOn == Config.ApplyOn.ALL || (entityType == EntityType.LLAMA && BetterThanLlamas.config.applyOn == Config.ApplyOn.LLAMA) || (entityType == EntityType.TRADER_LLAMA && BetterThanLlamas.config.applyOn == Config.ApplyOn.TRADER_LLAMA)) && entityRenderer instanceof LlamaRenderer llamaRenderer)
            {
                addFancyLayer(llamaRenderer);
            }
        });
    }
}
