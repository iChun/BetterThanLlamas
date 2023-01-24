package me.ichun.mods.betterthanllamas.loader.fabric;

import me.ichun.mods.betterthanllamas.common.core.Config;
import me.lortseam.completeconfig.api.ConfigContainer;
import me.lortseam.completeconfig.api.ConfigEntries;
import me.lortseam.completeconfig.api.ConfigEntry;
import me.lortseam.completeconfig.api.ConfigGroup;

public class ConfigFabric extends Config
        implements ConfigContainer
{
    public static General GENERAL = null;
    public static Outfit OUTFIT = null;

    public ConfigFabric()
    {
        applyOn = new ConfigWrapper<>(() -> GENERAL.applyOn, v -> GENERAL.applyOn = v);
        fancyChance = new ConfigWrapper<>(() -> GENERAL.fancyChance, v -> GENERAL.fancyChance = v);
        
        hatChance = new ConfigWrapper<>(() -> OUTFIT.hatChance, v -> OUTFIT.hatChance = v);
        monocleChance = new ConfigWrapper<>(() -> OUTFIT.monocleChance, v -> OUTFIT.monocleChance = v);
        pipeChance = new ConfigWrapper<>(() -> OUTFIT.pipeChance, v -> OUTFIT.pipeChance = v);
        bowtieChance = new ConfigWrapper<>(() -> OUTFIT.bowtieChance, v -> OUTFIT.bowtieChance = v);
        fezChance = new ConfigWrapper<>(() -> OUTFIT.fezChance, v -> OUTFIT.fezChance = v);
        moustacheChance = new ConfigWrapper<>(() -> OUTFIT.moustacheChance, v -> OUTFIT.moustacheChance = v);
    }


    @Transitive
    @ConfigEntries(includeAll = true)
    public static class General implements ConfigGroup
    {
        public General()
        {
            GENERAL = this;
        }

        @Override
        public String getComment()
        {
            return "General configs that don't fit any other category.";
        }

        @Override
        public String getNameKey()
        {
            return "config.betterthanllamas.cat.general.name";
        }

        @Override
        public String getDescriptionKey()
        {
            return "config.betterthanllamas.cat.general.desc";
        }

        @ConfigEntry(nameKey = "config.betterthanllamas.prop.applyOn.name", descriptionKey = "config.betterthanllamas.prop.applyOn.desc", comment = "Apply Mod On...\n0 = Nothing (why install the mod though?)\n1 = Llamas\n2 = Trader Llamas\n3 = Both", requiresRestart = true)
        @ConfigEntry.BoundedInteger(min = 0, max = 3)
        public int applyOn = 3;

        @ConfigEntry(nameKey = "config.betterthanllamas.prop.fancyChance.name", descriptionKey = "config.betterthanllamas.prop.fancyChance.desc", comment = "Chance of llamas wearing parts of their outfit, in percentage% (0-100)")
        @ConfigEntry.BoundedInteger(min = 0, max = 100)
        public int fancyChance = 80;
    }

    @Transitive
    @ConfigEntries(includeAll = true)
    public static class Outfit implements ConfigGroup
    {
        public Outfit()
        {
            OUTFIT = this;
        }

        @Override
        public String getComment()
        {
            return "Configs regarding llamas that are wearing outfits.";
        }

        @Override
        public String getNameKey()
        {
            return "config.betterthanllamas.cat.outfit.name";
        }

        @Override
        public String getDescriptionKey()
        {
            return "config.betterthanllamas.cat.outfit.desc";
        }

        @ConfigEntry(nameKey = "config.betterthanllamas.prop.hatChance.name", descriptionKey = "config.betterthanllamas.prop.hatChance.desc", comment = "Chance of llamas wearing hats in their outfit, in percentage% (0-100)")
        @ConfigEntry.BoundedInteger(min = 0, max = 100)
        public int hatChance = 50;

        @ConfigEntry(nameKey = "config.betterthanllamas.prop.monocleChance.name", descriptionKey = "config.betterthanllamas.prop.monocleChance.desc", comment = "Chance of llamas wearing a monocle in their outfit, in percentage% (0-100)")
        @ConfigEntry.BoundedInteger(min = 0, max = 100)
        public int monocleChance = 50;

        @ConfigEntry(nameKey = "config.betterthanllamas.prop.pipeChance.name", descriptionKey = "config.betterthanllamas.prop.pipeChance.desc", comment = "Chance of llamas having a pipe in their outfit, in percentage% (0-100)")
        @ConfigEntry.BoundedInteger(min = 0, max = 100)
        public int pipeChance = 50;

        @ConfigEntry(nameKey = "config.betterthanllamas.prop.bowtieChance.name", descriptionKey = "config.betterthanllamas.prop.bowtieChance.desc", comment = "Chance of llamas wearing a bow tie in their outfit, in percentage% (0-100)")
        @ConfigEntry.BoundedInteger(min = 0, max = 100)
        public int bowtieChance = 50;

        @ConfigEntry(nameKey = "config.betterthanllamas.prop.fezChance.name", descriptionKey = "config.betterthanllamas.prop.fezChance.desc", comment = "Chance of llamas wearing a fez in their outfit, in percentage% (0-100)")
        @ConfigEntry.BoundedInteger(min = 0, max = 100)
        public int fezChance = 50;

        @ConfigEntry(nameKey = "config.betterthanllamas.prop.moustacheChance.name", descriptionKey = "config.betterthanllamas.prop.moustacheChance.desc", comment = "Chance of llamas wearing a moustache in their outfit, in percentage% (0-100)")
        @ConfigEntry.BoundedInteger(min = 0, max = 100)
        public int moustacheChance = 50;
    }
}