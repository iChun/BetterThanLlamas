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
        configFabric.configInstance = new Config(MOD_ID, new String[]{}, configFabric);
        configFabric.configInstance.load();
        Runtime.getRuntime().addShutdownHook(new Thread(configFabric.configInstance::save));

        //Register event handler
        new EventHandlerClientFabric();
    }
}
