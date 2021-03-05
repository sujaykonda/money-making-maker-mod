package me._xgqd.moneymakingmaker;

import me._xgqd.moneymakingmaker.hypixel.Hypixel;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.config.GuiConfig;
import net.minecraftforge.fml.client.config.IConfigElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConfigGui extends GuiConfig {
    public ConfigGui(GuiScreen parentScreen) {
        super(parentScreen,
                new ConfigElement(Config.config.getCategory(Configuration.CATEGORY_GENERAL)).getChildElements(),
                Main.MODID,
                "moneymakingconfig",
                false,
                false,
                "Money Making Maker Config");
    }
    @Override
    public void onGuiClosed(){
        super.onGuiClosed();
        Config.saveConfig();
        System.out.println(Config.getHypixelKeyProp().getString());
        Main.hypixel = new Hypixel(Config.getHypixelKeyProp().getString());
    }
}
