package me.ichun.mods.betterthanllamas.loader.neoforge;

import me.ichun.mods.betterthanllamas.common.BetterThanLlamas;
import me.ichun.mods.betterthanllamas.common.core.Config;
import me.ichun.mods.betterthanllamas.common.core.EventHandlerClient;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.LlamaRenderer;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.horse.Llama;
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
        if(BetterThanLlamas.config.applyOn == Config.ApplyOn.LLAMA || BetterThanLlamas.config.applyOn == Config.ApplyOn.ALL)
        {
            LivingEntityRenderer<Llama, ? extends EntityModel<Llama>> render = event.getRenderer(EntityType.LLAMA);
            if(render instanceof LlamaRenderer llamaRenderer)
            {
                addFancyLayer(llamaRenderer);
            }
        }
        if(BetterThanLlamas.config.applyOn == Config.ApplyOn.TRADER_LLAMA || BetterThanLlamas.config.applyOn == Config.ApplyOn.ALL)
        {
            LivingEntityRenderer<Llama, ? extends EntityModel<Llama>> render = event.getRenderer(EntityType.TRADER_LLAMA);
            if(render instanceof LlamaRenderer llamaRenderer)
            {
                addFancyLayer(llamaRenderer);
            }
        }
    }
}
