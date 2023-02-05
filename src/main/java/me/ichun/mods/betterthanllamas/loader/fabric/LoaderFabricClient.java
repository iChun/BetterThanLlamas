package me.ichun.mods.betterthanllamas.loader.fabric;

import me.ichun.mods.betterthanllamas.common.BetterThanLlamas;
import me.lortseam.completeconfig.data.Config;
import net.fabricmc.api.ClientModInitializer;

public class LoaderFabricClient extends BetterThanLlamas
        implements ClientModInitializer
{
    @Override
    public void onInitializeClient()
    {
        modProxy = this;

        //register config
        ConfigFabric configFabric = new ConfigFabric();
        config = configFabric;
        Config modConfig = new Config(MOD_ID, new String[]{}, configFabric);
        modConfig.load();
        Runtime.getRuntime().addShutdownHook(new Thread(modConfig::save));

        //Register event handler
        new EventHandlerClientFabric();
    }
}
