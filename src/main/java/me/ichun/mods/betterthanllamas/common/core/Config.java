package me.ichun.mods.betterthanllamas.common.core;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class Config
{
    public ConfigWrapper<Integer> applyOn;

    public ConfigWrapper<Integer> fancyChance;

    public ConfigWrapper<Integer> hatChance;
    public ConfigWrapper<Integer> monocleChance;
    public ConfigWrapper<Integer> pipeChance;
    public ConfigWrapper<Integer> bowtieChance;
    public ConfigWrapper<Integer> fezChance;
    public ConfigWrapper<Integer> moustacheChance;

    protected static class Reference
    {
        public static final String APPLY_ON_COMMENT = "Apply Mod On...\n0 = Nothing (why install the mod though?)\n1 = Llamas\n2 = Trader Llamas\n3 = Both";
        public static final String FANCY_CHANCE_COMMENT = "Chance of llamas wearing parts of their outfit, in percentage% (0-100)";
        public static final String HAT_CHANCE_COMMENT = "Chance of llamas wearing hats in their outfit, in percentage% (0-100)";
        public static final String MONOCLE_CHANCE_COMMENT = "Chance of llamas wearing a monocle in their outfit, in percentage% (0-100)";
        public static final String PIPE_CHANCE_COMMENT = "Chance of llamas having a pipe in their outfit, in percentage% (0-100)";
        public static final String BOWTIE_CHANCE_COMMENT = "Chance of llamas wearing a bow tie in their outfit, in percentage% (0-100)";
        public static final String FEZ_CHANCE_COMMENT = "Chance of llamas wearing a fez in their outfit, in percentage% (0-100)";
        public static final String MOUSTACHE_CHANCE_COMMENT = "Chance of llamas wearing a moustache in their outfit, in percentage% (0-100)";
    }

    public static class ConfigWrapper<T>
    {
        public final Supplier<T> getter;
        public final Consumer<T> setter;
        public final Runnable saver;

        public ConfigWrapper(Supplier<T> getter, Consumer<T> setter) {
            this.getter = getter;
            this.setter = setter;
            this.saver = null;
        }

        public ConfigWrapper(Supplier<T> getter, Consumer<T> setter, Runnable saver) {
            this.getter = getter;
            this.setter = setter;
            this.saver = saver;
        }

        public T get()
        {
            return getter.get();
        }

        public void set(T obj)
        {
            setter.accept(obj);
        }

        public void save()
        {
            if(saver != null)
            {
                saver.run();
            }
        }
    }
}
