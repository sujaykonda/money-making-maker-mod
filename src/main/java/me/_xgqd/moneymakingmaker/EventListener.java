package me._xgqd.moneymakingmaker;

import net.minecraft.event.ClickEvent;
import net.minecraft.event.HoverEvent;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatStyle;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import static me._xgqd.moneymakingmaker.Main.VERSION;

public class EventListener {

    private boolean warned = false;

    @SubscribeEvent(priority= EventPriority.NORMAL, receiveCanceled=true)
    public void onTick(TickEvent.PlayerTickEvent event){
        if(!warned){
            System.out.println("Player Logged In");
            String latestVersion = VERSION;
            InputStream in = null;
            try
            {
                in = new URL("https://raw.githubusercontent.com/sujaykonda/money-making-maker-mod/main/src/main/resources/version").openStream();
            }
            catch
            (MalformedURLException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            catch (IOException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            try
            {
                latestVersion = IOUtils.readLines(in).get(0);
                System.out.println(latestVersion);
            }
            catch (IOException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            finally
            {
                IOUtils.closeQuietly(in);
            }
            System.out.println("Latest mod version = "+ latestVersion);
            if(!VERSION.equals(latestVersion)){
                ChatComponentText text = new ChatComponentText("§aMoney Making Maker Mod \n§bNew Update Released \n§ehttps://github.com/sujaykonda/money-making-maker-mod/releases \n§aLatest Version§r: §c" + latestVersion);
                ChatStyle style = new ChatStyle();
                style.setChatHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ChatComponentText("https://github.com/sujaykonda/money-making-maker-mod/releases")));
                style.setChatClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://github.com/sujaykonda/money-making-maker-mod/releases"));
                text.setChatStyle(style);
                event.player.addChatMessage(text);
            }
            warned = true;
        }
    }
}
