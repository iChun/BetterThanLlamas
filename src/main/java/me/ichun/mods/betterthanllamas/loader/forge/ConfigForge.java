package me.ichun.mods.betterthanllamas.loader.forge;

import me.ichun.mods.betterthanllamas.common.core.Config;
import net.minecraftforge.common.ForgeConfigSpec;

public class ConfigForge extends Config
{
    public ConfigForge(ForgeConfigSpec.Builder builder)
    {
        builder.comment("General settings").push("general");

        final ForgeConfigSpec.IntValue cApplyOn = builder.comment("Apply Mod On...\n0 = Nothing (why install the mod though?)\n1 = Llamas\n2 = Trader Llamas\n3 = Both")
                .translation("config.betterthanllamas.prop.applyOn.desc")
                .worldRestart()
                .defineInRange("applyOn", 3, 0, 3);
        applyOn = new ConfigWrapper<>(cApplyOn::get, cApplyOn::set, cApplyOn::save);

        final ForgeConfigSpec.IntValue cFancyChance = builder.comment("Chance of llamas wearing parts of their outfit, in percentage% (0-100)")
                .translation("config.betterthanllamas.prop.fancyChance.desc")
                .defineInRange("fancyChance", 80, 0, 100);
        fancyChance = new ConfigWrapper<>(cFancyChance::get, cFancyChance::set, cFancyChance::save);

        builder.pop();

        builder.comment("Configs regarding llamas that are wearing outfits.").push("outfit");

        final ForgeConfigSpec.IntValue cHatChance = builder.comment("Chance of llamas wearing hats in their outfit, in percentage% (0-100)")
                .translation("config.betterthanllamas.prop.hatChance.desc")
                .defineInRange("hatChance", 50, 0, 100);
        hatChance = new ConfigWrapper<>(cHatChance::get, cHatChance::set, cHatChance::save);

        final ForgeConfigSpec.IntValue cMonocleChance = builder.comment("Chance of llamas wearing a monocle in their outfit, in percentage% (0-100)")
                .translation("config.betterthanllamas.prop.monocleChance.desc")
                .defineInRange("monocleChance", 50, 0, 100);
        monocleChance = new ConfigWrapper<>(cMonocleChance::get, cMonocleChance::set, cMonocleChance::save);

        final ForgeConfigSpec.IntValue cPipeChance = builder.comment("Chance of llamas having a pipe in their outfit, in percentage% (0-100)")
                .translation("config.betterthanllamas.prop.pipeChance.desc")
                .defineInRange("pipeChance", 50, 0, 100);
        pipeChance = new ConfigWrapper<>(cPipeChance::get, cPipeChance::set, cPipeChance::save);

        final ForgeConfigSpec.IntValue cBowtieChance = builder.comment("Chance of llamas wearing a bow tie in their outfit, in percentage% (0-100)")
                .translation("config.betterthanllamas.prop.bowtieChance.desc")
                .defineInRange("bowtieChance", 50, 0, 100);
        bowtieChance = new ConfigWrapper<>(cBowtieChance::get, cBowtieChance::set, cBowtieChance::save);

        final ForgeConfigSpec.IntValue cFezChance = builder.comment("Chance of llamas wearing a fez in their outfit, in percentage% (0-100)")
                .translation("config.betterthanllamas.prop.fezChance.desc")
                .defineInRange("fezChance", 50, 0, 100);
        fezChance = new ConfigWrapper<>(cFezChance::get, cFezChance::set, cFezChance::save);

        final ForgeConfigSpec.IntValue cMoustacheChance = builder.comment("Chance of llamas wearing a moustache in their outfit, in percentage% (0-100)")
                .translation("config.betterthanllamas.prop.moustacheChance.desc")
                .defineInRange("moustacheChance", 50, 0, 100);
        moustacheChance = new ConfigWrapper<>(cMoustacheChance::get, cMoustacheChance::set, cMoustacheChance::save);

        builder.pop();
    }
}
