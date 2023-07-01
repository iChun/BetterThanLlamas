package me.ichun.mods.betterthanllamas.mixin;

import me.ichun.mods.betterthanllamas.common.BetterThanLlamas;
import net.minecraft.client.gui.components.SplashRenderer;
import net.minecraft.client.resources.SplashManager;
import net.minecraft.client.resources.language.I18n;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(SplashManager.class)
public abstract class SplashManagerMixin
{
    @Inject(method = "getSplash", at = @At("HEAD"), cancellable = true)
    private void btl$getSplash(CallbackInfoReturnable<SplashRenderer> cir)
    {
        if(BetterThanLlamas.isNationalLlamaDay())
        {
            String splash = I18n.get("splash.llamaDay");
            if(splash.equals("splash.llamaDay")) //localisations have not loaded
            {
                splash = "Happy Llama Day!";
            }
            cir.setReturnValue(new SplashRenderer(splash));
        }
    }
}
