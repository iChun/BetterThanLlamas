package me.ichun.mods.betterthanllamas.common.core;

import me.ichun.mods.betterthanllamas.client.render.LlamaFancyLayer;
import me.ichun.mods.ichunutil.loader.event.client.LivingRenderPreEvent;
import me.ichun.mods.ichunutil.mixin.client.LivingEntityRendererAccessorMixin;
import net.minecraft.client.model.LlamaModel;
import net.minecraft.client.renderer.entity.LlamaRenderer;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.entity.state.LlamaRenderState;
import net.minecraft.world.entity.animal.horse.Llama;

public abstract class EventHandlerClient
{
    public final LivingRenderPreEvent.LastRenderedEntitySupplier<Llama> llamaRendered;

    public EventHandlerClient()
    {
        llamaRendered = new LivingRenderPreEvent.LastRenderedEntitySupplier<>(event -> event.renderer() instanceof LlamaRenderer renderer && renderer.getModel().getClass().equals(LlamaModel.class) && event.livingEntity() instanceof Llama && event.renderState() instanceof LlamaRenderState);
    }

    @SuppressWarnings("unchecked")
    public void addFancyLayer(LlamaRenderer llamaRenderer)
    {
        boolean flag = false;
        for(RenderLayer<LlamaRenderState, LlamaModel> layer : ((LivingEntityRendererAccessorMixin<Llama, LlamaRenderState, LlamaModel>)llamaRenderer).getLayers())
        {
            if(layer instanceof LlamaFancyLayer)
            {
                flag = true;
                break;
            }

        }
        if(!flag)
        {
            LlamaFancyLayer fancyLayer = new LlamaFancyLayer(llamaRenderer);
            ((LivingEntityRendererAccessorMixin<Llama, LlamaRenderState, LlamaModel>)llamaRenderer).invokeAddLayer(fancyLayer);
        }
    }
}
