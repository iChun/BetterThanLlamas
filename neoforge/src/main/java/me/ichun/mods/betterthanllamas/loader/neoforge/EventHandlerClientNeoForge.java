package me.ichun.mods.betterthanllamas.loader.neoforge;

import me.ichun.mods.betterthanllamas.common.BetterThanLlamas;
import me.ichun.mods.betterthanllamas.common.core.Config;
import me.ichun.mods.betterthanllamas.common.core.EventHandlerClient;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.LlamaRenderer;
import net.minecraft.world.entity.EntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

public class EventHandlerClientNeoForge extends EventHandlerClient
{
    public EventHandlerClientNeoForge(IEventBus modEventBus)
    {
        modEventBus.addListener(this::onAddLayers);
    }

    private void onAddLayers(EntityRenderersEvent.AddLayers event)
    {
        event.getEntityTypes().forEach(type -> {
            EntityRenderer<?> renderer = event.getRenderer(type);
            if(renderer instanceof LlamaRenderer llamaRenderer)
            {
                if(BetterThanLlamas.config.applyOn == Config.ApplyOn.ALL || (type == EntityType.LLAMA && BetterThanLlamas.config.applyOn == Config.ApplyOn.LLAMA) || (type == EntityType.TRADER_LLAMA && BetterThanLlamas.config.applyOn == Config.ApplyOn.TRADER_LLAMA))
                {
                    addFancyLayer(llamaRenderer);
                }
            }
        });
    }
}
