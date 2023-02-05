package me.ichun.mods.betterthanllamas.common;

import com.mojang.logging.LogUtils;
import me.ichun.mods.betterthanllamas.common.core.Config;
import org.slf4j.Logger;

import java.util.Calendar;

public abstract class BetterThanLlamas
{
    public static final String MOD_ID = "betterthanllamas";
    public static final String MOD_NAME = "Better Than Llamas";

    public static final Logger LOGGER = LogUtils.getLogger();

    public static BetterThanLlamas modProxy;

    public static Config config;

    private static Boolean isNationalLlamaDay; //I know, I know, a dirty triple state boolean

    public static boolean isNationalLlamaDay()
    {
        if(isNationalLlamaDay == null)
        {
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(System.currentTimeMillis());

            // National Llama day....?
            isNationalLlamaDay = calendar.get(Calendar.MONTH) == Calendar.DECEMBER && calendar.get(Calendar.DAY_OF_MONTH) == 9;
        }
        return isNationalLlamaDay;
    }
}
