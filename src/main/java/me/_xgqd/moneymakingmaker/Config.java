package me._xgqd.moneymakingmaker;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;
import net.minecraftforge.fml.common.Loader;

import java.io.File;

public class Config {
    public enum MacroState {TYPE_IN, COPY_PASTE, AUTO};
    public static File configFile;
    public static Configuration config;

    public static void init(File file){
        configFile = file;
        config = new Configuration(configFile);
    }

    public static Property getHypixelKeyProp(){
        config.load();
        return config.get("Settings", "Hypixel Api Key", "");
    }

    public static Property getMacroState(){
        config.load();
        return config.get("Settings", "Macro Safeness State (0: Type it in, 1: Copy & Paste, 2: Auto Command)", 1);
    }

    public static MacroState propToMacroState(Property macroState){
        return MacroState.values()[macroState.getInt()];
    }
}
