package me.ichun.mods.betterthanllamas.mixin;

import net.minecraft.client.model.LlamaModel;
import net.minecraft.client.renderer.entity.layers.LlamaDecorLayer;
import net.minecraft.world.entity.animal.horse.Llama;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(LlamaDecorLayer.class)
public interface LlamaDecorLayerAccessorMixin
{
    @Accessor
    LlamaModel<Llama> getModel();
}
