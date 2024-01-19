package me.ichun.mods.betterthanllamas.loader.neoforge;

import me.ichun.mods.betterthanllamas.common.core.Config;
import net.neoforged.neoforge.common.ModConfigSpec;

public class ConfigNeoforge extends Config
{
    public ConfigNeoforge(ModConfigSpec.Builder builder)
    {
        builder.comment("General settings").push("general");

        final ModConfigSpec.IntValue cApplyOn = builder.comment(Reference.APPLY_ON_COMMENT)
            .translation("config.betterthanllamas.prop.applyOn.desc")
            .worldRestart()
            .defineInRange("applyOn", 3, 0, 3);
        applyOn = new ConfigWrapper<>(cApplyOn::get, cApplyOn::set, cApplyOn::save);

        final ModConfigSpec.IntValue cFancyChance = builder.comment(Reference.FANCY_CHANCE_COMMENT)
            .translation("config.betterthanllamas.prop.fancyChance.desc")
            .defineInRange("fancyChance", 80, 0, 100);
        fancyChance = new ConfigWrapper<>(cFancyChance::get, cFancyChance::set, cFancyChance::save);

        builder.pop();

        builder.comment("Configs regarding llamas that are wearing outfits.").push("outfit");

        final ModConfigSpec.IntValue cHatChance = builder.comment(Reference.HAT_CHANCE_COMMENT)
            .translation("config.betterthanllamas.prop.hatChance.desc")
            .defineInRange("hatChance", 50, 0, 100);
        hatChance = new ConfigWrapper<>(cHatChance::get, cHatChance::set, cHatChance::save);

        final ModConfigSpec.IntValue cMonocleChance = builder.comment(Reference.MONOCLE_CHANCE_COMMENT)
            .translation("config.betterthanllamas.prop.monocleChance.desc")
            .defineInRange("monocleChance", 50, 0, 100);
        monocleChance = new ConfigWrapper<>(cMonocleChance::get, cMonocleChance::set, cMonocleChance::save);

        final ModConfigSpec.IntValue cPipeChance = builder.comment(Reference.PIPE_CHANCE_COMMENT)
            .translation("config.betterthanllamas.prop.pipeChance.desc")
            .defineInRange("pipeChance", 50, 0, 100);
        pipeChance = new ConfigWrapper<>(cPipeChance::get, cPipeChance::set, cPipeChance::save);

        final ModConfigSpec.IntValue cBowtieChance = builder.comment(Reference.BOWTIE_CHANCE_COMMENT)
            .translation("config.betterthanllamas.prop.bowtieChance.desc")
            .defineInRange("bowtieChance", 50, 0, 100);
        bowtieChance = new ConfigWrapper<>(cBowtieChance::get, cBowtieChance::set, cBowtieChance::save);

        final ModConfigSpec.IntValue cFezChance = builder.comment(Reference.FEZ_CHANCE_COMMENT)
            .translation("config.betterthanllamas.prop.fezChance.desc")
            .defineInRange("fezChance", 50, 0, 100);
        fezChance = new ConfigWrapper<>(cFezChance::get, cFezChance::set, cFezChance::save);

        final ModConfigSpec.IntValue cMoustacheChance = builder.comment(Reference.MOUSTACHE_CHANCE_COMMENT)
            .translation("config.betterthanllamas.prop.moustacheChance.desc")
            .defineInRange("moustacheChance", 50, 0, 100);
        moustacheChance = new ConfigWrapper<>(cMoustacheChance::get, cMoustacheChance::set, cMoustacheChance::save);

        builder.pop();
    }
}
