package me.ichun.mods.betterthanllamas.common.core;

import me.ichun.mods.betterthanllamas.common.BetterThanLlamas;
import me.ichun.mods.ichunutil.common.config.ConfigBase;
import me.ichun.mods.ichunutil.common.config.annotations.CategoryDivider;
import me.ichun.mods.ichunutil.common.config.annotations.Prop;
import org.jetbrains.annotations.NotNull;

public class Config extends ConfigBase
{
    public ApplyOn applyOn = ApplyOn.ALL;

    @Prop(min = 0, max = 100)
    public int fancyChance = 80;

    @CategoryDivider(name = "outfit")
    @Prop(min = 0, max = 100)
    public int hatChance = 50;

    @Prop(min = 0, max = 100)
    public int monocleChance = 50;

    @Prop(min = 0, max = 100)
    public int pipeChance = 50;

    @Prop(min = 0, max = 100)
    public int bowtieChance = 50;

    @Prop(min = 0, max = 100)
    public int fezChance = 50;

    @Prop(min = 0, max = 100)
    public int moustacheChance = 50;

    public Config()
    {
        super(BetterThanLlamas.MOD_ID + ".toml");
    }

    @NotNull
    @Override
    public String getModId()
    {
        return BetterThanLlamas.MOD_ID;
    }

    @NotNull
    @Override
    public String getConfigName()
    {
        return BetterThanLlamas.MOD_NAME;
    }

    @Override
    public Type getConfigType()
    {
        return Type.CLIENT;
    }

    public enum ApplyOn {
        LLAMA,
        TRADER_LLAMA,
        ALL
    }
}
