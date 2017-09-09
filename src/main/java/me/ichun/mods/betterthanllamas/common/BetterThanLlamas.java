package me.ichun.mods.betterthanllamas.common;

import me.ichun.mods.betterthanllamas.common.core.Reference;
import me.ichun.mods.betterthanllamas.common.render.LayerFancyLlama;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLlama;
import net.minecraft.entity.passive.EntityLlama;
import net.minecraftforge.client.event.GuiScreenEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod(modid = Reference.MODID, name = Reference.NAME,
        version = Reference.VERSION,
        clientSideOnly = true,
        acceptableRemoteVersions = "*",
        dependencies = "required-after:forge@[13.19.0.2141,)",
        acceptedMinecraftVersions = "[1.12,1.13)"
)
public class BetterThanLlamas
{
    public boolean hasShownFirstGui;

    public static int fancyWeightage = 80;
    public static int randomizeParts = 1;
    public static String[] disabledParts = new String[0];

    @Mod.EventHandler
    public void preLoad(FMLPreInitializationEvent event)
    {
        Configuration config = new Configuration(event.getSuggestedConfigurationFile());
        config.load();

        config.addCustomCategoryComment("general", "General settings");
        fancyWeightage = config.getInt("fancyWeightage", "general", 80, 0, 100, "Weightage of llamas wearing parts of their outfit, in percentage% (0-100)");
        randomizeParts = config.getInt("randomizeParts", "general", 1, 0, 1, "0 = Render the entire outfit (except disabled parts)\n1 = Randomly choose which parts of the outfit to render (per llama)");
        disabledParts = config.getStringList("disabledParts", "general", disabledParts, "Disable parts of the outfit", new String[] { "hat", "monocle", "pipe", "bowtie", "fez", "moustache" });

        if(config.hasChanged())
        {
            config.save();
        }

        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public void onInitGuiPost(GuiScreenEvent.InitGuiEvent.Post event)
    {
        if(!hasShownFirstGui)
        {
            hasShownFirstGui = true;

            //Add the layer renderers
            Render renderer = Minecraft.getMinecraft().getRenderManager().getEntityClassRenderObject(EntityLlama.class);
            if(renderer instanceof RenderLlama)
            {
                RenderLlama renderLlama = (RenderLlama)renderer;
                renderLlama.addLayer(new LayerFancyLlama(renderLlama));
            }
        }
    }
}
