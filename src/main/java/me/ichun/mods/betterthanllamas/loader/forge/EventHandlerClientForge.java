package me.ichun.mods.betterthanllamas.loader.forge;

import me.ichun.mods.betterthanllamas.common.BetterThanLlamas;
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
        int i = BetterThanLlamas.config.applyOn.get();
        if((i & 1) > 0)
        {
            LivingEntityRenderer<Llama, ? extends EntityModel<Llama>> render = event.getRenderer(EntityType.LLAMA);
            if(render instanceof LlamaRenderer llamaRenderer)
            {
                addFancyLayer(llamaRenderer);
            }
        }
        if((i & 2) > 0)
        {
            LivingEntityRenderer<Llama, ? extends EntityModel<Llama>> render = event.getRenderer(EntityType.TRADER_LLAMA);
            if(render instanceof LlamaRenderer llamaRenderer)
            {
                addFancyLayer(llamaRenderer);
            }
        }
    }
}
