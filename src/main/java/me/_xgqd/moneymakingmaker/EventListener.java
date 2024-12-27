package me._xgqd.moneymakingmaker;

import static me._xgqd.moneymakingmaker.Main.*;

import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class EventListener {

    private boolean warned = false;

    @SubscribeEvent(priority = EventPriority.NORMAL, receiveCanceled = true)
    public void onTick(TickEvent.PlayerTickEvent event) {
        warned = true;

    }
}
