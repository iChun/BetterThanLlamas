package me.ichun.mods.betterthanllamas.mixin;

import net.minecraft.client.gui.screens.TitleScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(TitleScreen.class)
public interface TitleScreenAccessorMixin
{
    @Accessor
    void setSplash(String newSplash);
}
