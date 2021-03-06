package me._xgqd.moneymakingmaker;

import me._xgqd.moneymakingmaker.commands.AuctionFlipCommand;
import me._xgqd.moneymakingmaker.commands.BinFlipCommand;
import me._xgqd.moneymakingmaker.hypixel.Hypixel;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.event.ClickEvent;
import net.minecraft.event.HoverEvent;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatStyle;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.ForgeEventFactory;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.EventBus;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

@Mod(modid = Main.MODID, version = Main.VERSION, guiFactory = "me._xgqd.moneymakingmaker.ConfigGuiFactory")
public class Main
{
    public static final String MODID = "moneymakingmaker";
    public static final String VERSION = "0.3";
    public static Hypixel hypixel;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event){
        Config.init(event.getSuggestedConfigurationFile());
    }
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        MinecraftForge.EVENT_BUS.register(new EventListener());
        System.out.println("Initializing MoneyMakingMaker");
        ClientCommandHandler.instance.registerCommand(new BinFlipCommand());
        ClientCommandHandler.instance.registerCommand(new AuctionFlipCommand());
        hypixel = new Hypixel(Config.getHypixelKeyProp().getString());
    }
}
