package me.ichun.mods.betterthanllamas.loader.fabric;

import me.ichun.mods.betterthanllamas.common.BetterThanLlamas;
import me.ichun.mods.betterthanllamas.common.core.Config;
import me.ichun.mods.ichunutil.common.iChunUtil;
import net.fabricmc.api.ClientModInitializer;

public class LoaderFabricClient extends BetterThanLlamas
        implements ClientModInitializer
{
    @Override
    public void onInitializeClient()
    {
        modProxy = this;

        //register config
        config = iChunUtil.d().registerConfig(new Config());

        //Register event handler
        new EventHandlerClientFabric();
    }
}
