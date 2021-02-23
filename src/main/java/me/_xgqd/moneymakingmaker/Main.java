package me._xgqd.moneymakingmaker;

import me._xgqd.moneymakingmaker.commands.AuctionFlipCommand;
import me._xgqd.moneymakingmaker.commands.BinFlipCommand;
import me._xgqd.moneymakingmaker.hypixel.Hypixel;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Main.MODID, version = Main.VERSION, guiFactory = "me._xgqd.moneymakingmaker.ConfigGuiFactory")
public class Main
{
    public static final String MODID = "moneymakingmaker";
    public static final String VERSION = "1.0";
    public static Hypixel hypixel;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event){
        Config.init(event.getSuggestedConfigurationFile());
    }
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        System.out.println("Initializing MoneyMakingMaker");
        ClientCommandHandler.instance.registerCommand(new BinFlipCommand());
        ClientCommandHandler.instance.registerCommand(new AuctionFlipCommand());
        hypixel = new Hypixel(Config.getHypixelKeyProp().getString());
    }
}
