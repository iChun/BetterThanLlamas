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

    public me.lortseam.completeconfig.data.Config configInstance;

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
            return "cat.general.name";
        }

        @Override
        public String getDescriptionKey()
        {
            return "cat.general.desc";
        }

        @ConfigEntry(nameKey = "prop.applyOn.name", descriptionKey = "prop.applyOn.desc", comment = Reference.APPLY_ON_COMMENT, requiresRestart = true)
        @ConfigEntry.BoundedInteger(min = 0, max = 3)
        public int applyOn = 3;

        @ConfigEntry(nameKey = "prop.fancyChance.name", descriptionKey = "prop.fancyChance.desc", comment = Reference.FANCY_CHANCE_COMMENT)
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
            return "cat.outfit.name";
        }

        @Override
        public String getDescriptionKey()
        {
            return "cat.outfit.desc";
        }

        @ConfigEntry(nameKey = "prop.hatChance.name", descriptionKey = "prop.hatChance.desc", comment = Reference.HAT_CHANCE_COMMENT)
        @ConfigEntry.BoundedInteger(min = 0, max = 100)
        public int hatChance = 50;

        @ConfigEntry(nameKey = "prop.monocleChance.name", descriptionKey = "prop.monocleChance.desc", comment = Reference.MONOCLE_CHANCE_COMMENT)
        @ConfigEntry.BoundedInteger(min = 0, max = 100)
        public int monocleChance = 50;

        @ConfigEntry(nameKey = "prop.pipeChance.name", descriptionKey = "prop.pipeChance.desc", comment = Reference.PIPE_CHANCE_COMMENT)
        @ConfigEntry.BoundedInteger(min = 0, max = 100)
        public int pipeChance = 50;

        @ConfigEntry(nameKey = "prop.bowtieChance.name", descriptionKey = "prop.bowtieChance.desc", comment = Reference.BOWTIE_CHANCE_COMMENT)
        @ConfigEntry.BoundedInteger(min = 0, max = 100)
        public int bowtieChance = 50;

        @ConfigEntry(nameKey = "prop.fezChance.name", descriptionKey = "prop.fezChance.desc", comment = Reference.FEZ_CHANCE_COMMENT)
        @ConfigEntry.BoundedInteger(min = 0, max = 100)
        public int fezChance = 50;

        @ConfigEntry(nameKey = "prop.moustacheChance.name", descriptionKey = "prop.moustacheChance.desc", comment = Reference.MOUSTACHE_CHANCE_COMMENT)
        @ConfigEntry.BoundedInteger(min = 0, max = 100)
        public int moustacheChance = 50;
    }
}
