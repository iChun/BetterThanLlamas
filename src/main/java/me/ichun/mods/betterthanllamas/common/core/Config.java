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
