package me.ichun.mods.betterthanllamas.common.core;

public class Reference
{
    public static final String MODID = "betterthanllamas";
    public static final String NAME = "BetterThanLlamas";
    private static final String MAJOR = "@MAJOR@";
    private static final String MINOR = "@MINOR@";
    private static final String BUILD = "@BUILD_NUMBER@";
    public static final String MCVERSION = "@MC_VERSION@";

    public static final String VERSION = MCVERSION + "-" + MAJOR + "." + MINOR + "." + BUILD;
}