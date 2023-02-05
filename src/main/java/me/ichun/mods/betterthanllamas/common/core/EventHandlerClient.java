package me.ichun.mods.betterthanllamas.common.core;

import me.ichun.mods.betterthanllamas.client.render.LlamaFancyLayer;
import me.ichun.mods.betterthanllamas.common.BetterThanLlamas;
import me.ichun.mods.betterthanllamas.mixin.LivingEntityRendererAccessorMixin;
import me.ichun.mods.betterthanllamas.mixin.LlamaDecorLayerAccessorMixin;
import me.ichun.mods.betterthanllamas.mixin.TitleScreenAccessorMixin;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.TitleScreen;
import net.minecraft.client.model.LlamaModel;
import net.minecraft.client.renderer.entity.LlamaRenderer;
import net.minecraft.client.renderer.entity.layers.LlamaDecorLayer;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.resources.language.I18n;
import net.minecraft.world.entity.animal.horse.Llama;

public abstract class EventHandlerClient
{
    public EventHandlerClient()
    {
        if(BetterThanLlamas.isNationalLlamaDay())
        {
            addInitScreenHook();
        }
    }

    public abstract void addInitScreenHook();

    public void onScreenInitPost(Screen screen)
    {
        if(screen instanceof TitleScreen titleScreen)
        {
            ((TitleScreenAccessorMixin)titleScreen).setSplash(I18n.get("splash.llamaDay"));
        }
    }

    @SuppressWarnings("unchecked")
    public void addFancyLayer(LlamaRenderer llamaRenderer)
    {
        boolean flag = false;
        for(RenderLayer<Llama, LlamaModel<Llama>> layer : ((LivingEntityRendererAccessorMixin<Llama, LlamaModel<Llama>>)llamaRenderer).getLayers())
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
            ((LivingEntityRendererAccessorMixin<Llama, LlamaModel<Llama>>)llamaRenderer).invokeAddLayer(fancyLayer);
            if(fancyLayer.isEasterEggDay)
            {
                ((LivingEntityRendererAccessorMixin<Llama, LlamaModel<Llama>>)llamaRenderer).getLayers().stream().filter(l -> l instanceof LlamaDecorLayer).forEach(layer -> LlamaFancyLayer.processLlamaModelForEE(((LlamaDecorLayerAccessorMixin)(LlamaDecorLayer)layer).getModel()));
            }
        }

    }
}
