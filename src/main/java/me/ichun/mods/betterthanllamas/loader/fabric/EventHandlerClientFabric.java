package me.ichun.mods.betterthanllamas.loader.fabric;

import me.ichun.mods.betterthanllamas.common.BetterThanLlamas;
import me.ichun.mods.betterthanllamas.common.core.EventHandlerClient;
import net.fabricmc.fabric.api.client.rendering.v1.LivingEntityFeatureRendererRegistrationCallback;
import net.fabricmc.fabric.api.client.screen.v1.ScreenEvents;
import net.minecraft.client.renderer.entity.LlamaRenderer;
import net.minecraft.world.entity.EntityType;

public class EventHandlerClientFabric extends EventHandlerClient
{
    public EventHandlerClientFabric()
    {
        LivingEntityFeatureRendererRegistrationCallback.EVENT.register((entityType, entityRenderer, registrationHelper, context) ->
        {
            if(((entityType == EntityType.LLAMA && (BetterThanLlamas.config.applyOn.get() & 1) > 0) || (entityType == EntityType.TRADER_LLAMA && (BetterThanLlamas.config.applyOn.get() & 2) > 0)) && entityRenderer instanceof LlamaRenderer llamaRenderer)
            {
                addFancyLayer(llamaRenderer);
            }
        });
    }

    @Override
    public void addInitScreenHook()
    {
        ScreenEvents.AFTER_INIT.register((client, screen, scaledWidth, scaledHeight) -> onScreenInitPost(screen));
    }
}
