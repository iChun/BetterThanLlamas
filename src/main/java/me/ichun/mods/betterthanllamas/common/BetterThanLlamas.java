package me.ichun.mods.betterthanllamas.common;

import me.ichun.mods.betterthanllamas.client.render.LlamaFancyLayer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.MainMenuScreen;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.LlamaRenderer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.passive.horse.LlamaEntity;
import net.minecraft.entity.passive.horse.TraderLlamaEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.GuiScreenEvent;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Calendar;

@Mod(BetterThanLlamas.MOD_ID)
public class BetterThanLlamas
{
    public static final String MOD_ID = "betterthanllamas";
    public static final String MOD_NAME = "Better Than Llamas";

    private static final Logger LOGGER = LogManager.getLogger();

    public static Config config;

    public BetterThanLlamas()
    {
        DistExecutor.runWhenOn(Dist.CLIENT, () -> () -> {
            setupConfig();
            FMLJavaModLoadingContext.get().getModEventBus().addListener(this::finishLoading);

            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(System.currentTimeMillis());
                    if(calendar.get(Calendar.MONTH) == Calendar.DECEMBER && calendar.get(Calendar.DAY_OF_MONTH) == 9) // National Llama day....?
            {
                MinecraftForge.EVENT_BUS.addListener(this::onInitGuiPost);
            }

        });
        DistExecutor.runWhenOn(Dist.DEDICATED_SERVER, () -> () -> LOGGER.log(Level.ERROR, "You are loading " + MOD_NAME + " on a server. " + MOD_NAME + " is a client only mod!"));
    }

    private void setupConfig()
    {
        //build the config
        ForgeConfigSpec.Builder configBuilder = new ForgeConfigSpec.Builder();

        config = new Config(configBuilder);

        //register the config. This loads the config for us
        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, configBuilder.build(), MOD_ID + ".toml");
    }

    @OnlyIn(Dist.CLIENT)
    private void finishLoading(FMLLoadCompleteEvent event)
    {
        int i = config.applyOn.get();
        if((i & 1) > 0)
        {
            EntityRenderer render = Minecraft.getInstance().getRenderManager().getRenderer(LlamaEntity.class);
            if(render instanceof LlamaRenderer)
            {
                LlamaRenderer llamaRenderer = (LlamaRenderer)render;
                llamaRenderer.addLayer(new LlamaFancyLayer(llamaRenderer));
            }
        }
        if((i & 2) > 0)
        {
            EntityRenderer render = Minecraft.getInstance().getRenderManager().getRenderer(TraderLlamaEntity.class);
            if(render instanceof LlamaRenderer)
            {
                LlamaRenderer llamaRenderer = (LlamaRenderer)render;
                llamaRenderer.addLayer(new LlamaFancyLayer(llamaRenderer));
            }
        }
    }

    @OnlyIn(Dist.CLIENT)
    private void onInitGuiPost(GuiScreenEvent.InitGuiEvent.Post event)
    {
        if(event.getGui() instanceof MainMenuScreen)
        {
            ((MainMenuScreen)event.getGui()).splashText = I18n.format("splash.llamaDay");
        }
    }

    public class Config
    {
        public ForgeConfigSpec.IntValue applyOn;

        public ForgeConfigSpec.IntValue fancyChance;

        public ForgeConfigSpec.IntValue hatChance;
        public ForgeConfigSpec.IntValue monocleChance;
        public ForgeConfigSpec.IntValue pipeChance;
        public ForgeConfigSpec.IntValue bowtieChance;
        public ForgeConfigSpec.IntValue fezChance;
        public ForgeConfigSpec.IntValue moustacheChance;

        public Config(ForgeConfigSpec.Builder builder)
        {
            builder.comment("General settings").push("general");

            applyOn = builder.comment("Apply Mod On...\n0 = Nothing (why install the mod though?)\n1 = Llamas\n2 = Trader Llamas\n3 = Both")
                    .translation("config.betterthanllamas.prop.applyOn.desc")
                    .worldRestart()
                    .defineInRange("applyOn", 3, 0, 3);

            fancyChance = builder.comment("Chance of llamas wearing parts of their outfit, in percentage% (0-100)")
                    .translation("config.betterthanllamas.prop.fancyChance.desc")
                    .defineInRange("fancyChance", 80, 0, 100);

            builder.pop();

            builder.comment("Settings regarding llamas that are wearing outfits").push("outfit");

            hatChance = builder.comment("Chance of llamas wearing hats in their outfit, in percentage% (0-100)")
                    .translation("config.betterthanllamas.prop.hatChance.desc")
                    .defineInRange("hatChance", 100, 0, 100);
            monocleChance = builder.comment("Chance of llamas wearing a monocle in their outfit, in percentage% (0-100)")
                    .translation("config.betterthanllamas.prop.monocleChance.desc")
                    .defineInRange("monocleChance", 100, 0, 100);
            pipeChance = builder.comment("Chance of llamas having a pipe in their outfit, in percentage% (0-100)")
                    .translation("config.betterthanllamas.prop.pipeChance.desc")
                    .defineInRange("pipeChance", 100, 0, 100);
            bowtieChance = builder.comment("Chance of llamas wearing a bow tie in their outfit, in percentage% (0-100)")
                    .translation("config.betterthanllamas.prop.bowtieChance.desc")
                    .defineInRange("bowtieChance", 100, 0, 100);
            fezChance = builder.comment("Chance of llamas wearing a fez in their outfit, in percentage% (0-100)")
                    .translation("config.betterthanllamas.prop.fezChance.desc")
                    .defineInRange("fezChance", 100, 0, 100);
            moustacheChance = builder.comment("Chance of llamas wearing a moustache in their outfit, in percentage% (0-100)")
                    .translation("config.betterthanllamas.prop.moustacheChance.desc")
                    .defineInRange("moustacheChance", 100, 0, 100);

            builder.pop();
        }
    }
}
