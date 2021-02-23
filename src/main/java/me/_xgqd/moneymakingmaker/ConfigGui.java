package me._xgqd.moneymakingmaker;

import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.fml.client.config.GuiConfig;
import net.minecraftforge.fml.client.config.IConfigElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConfigGui extends GuiConfig {
    public ConfigGui(GuiScreen parentScreen) {
        super(parentScreen,
                Arrays.asList(new IConfigElement[]{
                        new ConfigElement(Config.getHypixelKeyProp()),
                        new ConfigElement(Config.getMacroState())}),
                Main.MODID,
                "moneymakingconfig",
                false,
                false,
                "Money Making Maker Config");
    }
}
