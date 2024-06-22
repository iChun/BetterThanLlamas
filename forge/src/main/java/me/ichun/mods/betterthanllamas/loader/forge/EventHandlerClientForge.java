package me.ichun.mods.betterthanllamas.loader.forge;

import me.ichun.mods.betterthanllamas.common.BetterThanLlamas;
import me.ichun.mods.betterthanllamas.common.core.Config;
import me.ichun.mods.betterthanllamas.common.core.EventHandlerClient;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.LlamaRenderer;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.horse.Llama;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

public class EventHandlerClientForge extends EventHandlerClient
{
    public EventHandlerClientForge()
    {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::onAddLayers);
    }

    private void onAddLayers(EntityRenderersEvent.AddLayers event)
    {
        if(BetterThanLlamas.config.applyOn == Config.ApplyOn.LLAMA || BetterThanLlamas.config.applyOn == Config.ApplyOn.ALL)
        {
            LivingEntityRenderer<Llama, ? extends EntityModel<Llama>> render = event.getEntityRenderer(EntityType.LLAMA);
            if(render instanceof LlamaRenderer llamaRenderer)
            {
                addFancyLayer(llamaRenderer);
            }
        }
        if(BetterThanLlamas.config.applyOn == Config.ApplyOn.TRADER_LLAMA || BetterThanLlamas.config.applyOn == Config.ApplyOn.ALL)
        {
            LivingEntityRenderer<Llama, ? extends EntityModel<Llama>> render = event.getEntityRenderer(EntityType.TRADER_LLAMA);
            if(render instanceof LlamaRenderer llamaRenderer)
            {
                addFancyLayer(llamaRenderer);
            }
        }
    }
}
