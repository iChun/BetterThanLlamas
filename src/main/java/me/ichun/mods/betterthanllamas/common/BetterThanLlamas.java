package me.ichun.mods.betterthanllamas.common;

import me.ichun.mods.betterthanllamas.client.render.LlamaFancyLayer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.TitleScreen;
import net.minecraft.client.model.LlamaModel;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.LlamaRenderer;
import net.minecraft.client.renderer.entity.layers.LlamaDecorLayer;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.resources.language.I18n;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.horse.Llama;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.GuiScreenEvent;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.IExtensionPoint;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fmllegacy.network.FMLNetworkConstants;
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
        DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () -> {
            setupConfig();
            MinecraftForge.EVENT_BUS.addListener(this::onClientTick);

            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(System.currentTimeMillis());
            if(calendar.get(Calendar.MONTH) == Calendar.DECEMBER && calendar.get(Calendar.DAY_OF_MONTH) == 9) // National Llama day....?
            {
                MinecraftForge.EVENT_BUS.addListener(this::onInitGuiPost);
            }
        });
        DistExecutor.unsafeRunWhenOn(Dist.DEDICATED_SERVER, () -> () -> LOGGER.log(Level.ERROR, "You are loading " + MOD_NAME + " on a server. " + MOD_NAME + " is a client only mod!"));

        //Make sure the mod being absent on the other network side does not cause the client to display the server as incompatible
        ModLoadingContext.get().registerExtensionPoint(IExtensionPoint.DisplayTest.class, () -> new IExtensionPoint.DisplayTest(() -> FMLNetworkConstants.IGNORESERVERONLY, (a, b) -> true));
    }

    private void setupConfig()
    {
        //build the config
        ForgeConfigSpec.Builder configBuilder = new ForgeConfigSpec.Builder();

        config = new Config(configBuilder);

        //register the config. This loads the config for us
        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, configBuilder.build(), MOD_ID + ".toml");
    }

    private boolean hasLoadingGui = false;
    @OnlyIn(Dist.CLIENT)
    private void onClientTick(TickEvent.ClientTickEvent event)
    {
        if(event.phase == TickEvent.Phase.END)
        {
            if(Minecraft.getInstance().getOverlay() == null && hasLoadingGui)
            {
                injectLayer();
            }
            hasLoadingGui = Minecraft.getInstance().getOverlay() != null;
        }
    }


    @OnlyIn(Dist.CLIENT)
    private void injectLayer()
    {
        int i = config.applyOn.get();
        if((i & 1) > 0)
        {
            EntityRenderer render = Minecraft.getInstance().getEntityRenderDispatcher().renderers.get(EntityType.LLAMA);
            if(render instanceof LlamaRenderer llamaRenderer)
            {
                boolean flag = false;
                for(RenderLayer<Llama, LlamaModel<Llama>> layer : llamaRenderer.layers)
                {
                    if(layer instanceof LlamaFancyLayer)
                    {
                        flag = true;
                        break;
                    }

                }
                if(!flag)
                {
                    LlamaFancyLayer fancyLayer = new LlamaFancyLayer(llamaRenderer);
                    llamaRenderer.addLayer(fancyLayer);
                    if(fancyLayer.isEasterEggDay)
                    {
                        llamaRenderer.layers.stream().filter(l -> l instanceof LlamaDecorLayer).forEach(layer -> LlamaFancyLayer.processLlamaModelForEE(((LlamaDecorLayer)layer).model));
                    }
                }
            }
        }
        if((i & 2) > 0)
        {
            EntityRenderer render = Minecraft.getInstance().getEntityRenderDispatcher().renderers.get(EntityType.TRADER_LLAMA);
            if(render instanceof LlamaRenderer llamaRenderer)
            {
                boolean flag = false;
                for(RenderLayer<Llama, LlamaModel<Llama>> layer : llamaRenderer.layers)
                {
                    if(layer instanceof LlamaFancyLayer)
                    {
                        flag = true;
                        break;
                    }

                }
                if(!flag)
                {
                    LlamaFancyLayer fancyLayer = new LlamaFancyLayer(llamaRenderer);
                    llamaRenderer.addLayer(fancyLayer);
                    if(fancyLayer.isEasterEggDay)
                    {
                        llamaRenderer.layers.stream().filter(l -> l instanceof LlamaDecorLayer).forEach(layer -> LlamaFancyLayer.processLlamaModelForEE(((LlamaDecorLayer)layer).model));
                    }
                }
            }
        }
    }

    @OnlyIn(Dist.CLIENT)
    private void onInitGuiPost(GuiScreenEvent.InitGuiEvent.Post event)
    {
        if(event.getGui() instanceof TitleScreen)
        {
            ((TitleScreen)event.getGui()).splash = I18n.get("splash.llamaDay");
        }
    }

    public class Config
    {
        public final ForgeConfigSpec.IntValue applyOn;

        public final ForgeConfigSpec.IntValue fancyChance;

        public final ForgeConfigSpec.IntValue hatChance;
        public final ForgeConfigSpec.IntValue monocleChance;
        public final ForgeConfigSpec.IntValue pipeChance;
        public final ForgeConfigSpec.IntValue bowtieChance;
        public final ForgeConfigSpec.IntValue fezChance;
        public final ForgeConfigSpec.IntValue moustacheChance;

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
                    .defineInRange("hatChance", 50, 0, 100);
            monocleChance = builder.comment("Chance of llamas wearing a monocle in their outfit, in percentage% (0-100)")
                    .translation("config.betterthanllamas.prop.monocleChance.desc")
                    .defineInRange("monocleChance", 50, 0, 100);
            pipeChance = builder.comment("Chance of llamas having a pipe in their outfit, in percentage% (0-100)")
                    .translation("config.betterthanllamas.prop.pipeChance.desc")
                    .defineInRange("pipeChance", 50, 0, 100);
            bowtieChance = builder.comment("Chance of llamas wearing a bow tie in their outfit, in percentage% (0-100)")
                    .translation("config.betterthanllamas.prop.bowtieChance.desc")
                    .defineInRange("bowtieChance", 50, 0, 100);
            fezChance = builder.comment("Chance of llamas wearing a fez in their outfit, in percentage% (0-100)")
                    .translation("config.betterthanllamas.prop.fezChance.desc")
                    .defineInRange("fezChance", 50, 0, 100);
            moustacheChance = builder.comment("Chance of llamas wearing a moustache in their outfit, in percentage% (0-100)")
                    .translation("config.betterthanllamas.prop.moustacheChance.desc")
                    .defineInRange("moustacheChance", 50, 0, 100);

            builder.pop();
        }
    }
}
